import Assets.Entity.Entity;
import Assets.Entity.Item.ItemType;
import Assets.Entity.NPC;
import Assets.Entity.Player;
import Assets.Entity.Item.Item;
import Assets.Entity.Move.Projectile;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.*;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Player player;
    private List<NPC> npcs;
    private List<Item> items;
    private boolean ingame;
    private final int STARTING_X = 40;
    private final int STARTING_Y = new Random().nextInt(800) + 50;
    private final int B_WIDTH = 850;
    private final int B_HEIGHT = 850;
    private final int DELAY = 15;
    private AnimationHandler aH;
    private Image hp;
    private Image bg;
    private List<List<Integer>> npcLoc = new ArrayList<>();
    private List<List<Integer>> itemLoc = new ArrayList<>();
    private int hpDrawLoc = 30;

    private void setupNPCLoc() {
        for (int i = 0; i <= 20; i++) {
            npcLoc.add(makePos(true));
        }
    }

    private void setupItemLoc() {
        for (int i = 0; i <= 8; i++) {
            itemLoc.add(makePos(false));
        }
    }

    private List<Integer> makePos(boolean NPCorItem) {
        return NPCorItem ?
                new ArrayList<>(Arrays.asList(new Random().nextInt(850) + 850, new Random().nextInt(785) + 50)) :
                new ArrayList<>(Arrays.asList(new Random().nextInt(785) + 50, new Random().nextInt(785) + 50));
    }

    protected Board() {
        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.GRAY);
        loadImages();
        ingame = true;

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        player = new Player(STARTING_X, STARTING_Y);

        setupNPCLoc();
        initNPCs();

        setupItemLoc();
        initItems();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void initNPCs() {
        npcs = new ArrayList<>();

        for (int i = 0; i < npcLoc.size(); i++) {
            npcs.add(new NPC(npcLoc.get(i).get(0), npcLoc.get(i).get(1)));
        }
    }

    private void initItems() {
        items = new ArrayList<>();

        for (int i = 0; i < itemLoc.size(); i++) {
            items.add(new Item(itemLoc.get(i).get(0), itemLoc.get(i).get(1)));
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        if (ingame) {

            drawObjects(g);

        } else {

            drawGameOver(g);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics g) {

        g.setColor(Color.WHITE);

        g.drawImage(getBGImage(), 0, 0, this);

        // Draw HitPoints
        if (player.isVisible()) {
            g.drawImage(player.getImage(), player.getX(), player.getY(), this);
            g.drawString("HP: ", 5, 15);
            g.drawImage(getHPImage(), 30, 5, this);
//            for (int i = 0; i < player.getHP(); i++) {
//                hpDrawLoc += 15;
//                g.drawImage(getHPImage(), hpDrawLoc, 5, this);
//            }
            if (player.getHP() > 1) {
                g.drawImage(getHPImage(), 45, 5, this);
                if (player.getHP() > 2) {
                    g.drawImage(getHPImage(), 60, 5, this);
                    if (player.getHP() > 3) {
                        g.drawImage(getHPImage(), 75, 5, this);
                        if (player.getHP() > 4) {
                            g.drawImage(getHPImage(), 90, 5, this);
                        }
                    }
                }
            }
        }

        // Draw Items
        for (Item item : items) {
            g.drawImage(item.getImage(), item.getX(), item.getY(), this);
        }

        // Draw Projectiles
        List<Projectile> projectiles = player.getProjectiles();

        for (Projectile projectile : projectiles) {
            if (projectile.isVisible()) {
                g.drawImage(projectile.getImage(), projectile.getX(), projectile.getY() - 3, this);
            }
        }

        for (NPC npc : npcs) {
            if (npc.isVisible()) {
                g.drawImage(npc.getImage(), npc.getX(), npc.getY(), this);
            }
        }

        // Draw Stats
        g.drawString("Current EXP: " + player.getEXP() + " / " + player.getMaxEXP(), 5, 30);

        // Draw Moves
        g.drawString("Pokémon left: " + npcs.size(), 750, 15);
    }

    private void loadImages() {
        ImageIcon ii = new ImageIcon("resources/hitpoint.png");
        ImageIcon jj = new ImageIcon("resources/bg.png");
        hp = ii.getImage();
        bg = jj.getImage();
    }

    private Image getHPImage() {
        return hp;
    }

    private Image getBGImage() {
        return bg;
    }

    private void drawGameOver(Graphics g) {

        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
                B_HEIGHT / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        inGame();

        updatePlayer();
        updateProjectiles();
        updateNPCs();
        updateItems();

        checkCollisions();

        repaint();
    }

    private void inGame() {

        if (!ingame) {
            timer.stop();
        }
    }

    private void updatePlayer() {

        if (player.isVisible()) {

            player.move();
        }
    }

    private void updateProjectiles() {

        List<Projectile> ms = player.getProjectiles();

        for (int i = 0; i < ms.size(); i++) {

            Projectile m = ms.get(i);

            if (m.isVisible()) {
                m.move();
            } else {
                ms.remove(i);
            }
        }
    }

    private void updateItems() {

        List<Item> it = items;

        for (int i = 0; i < it.size(); i++) {

            Item item = it.get(i);

            if (!item.isVisible()) {
                it.remove(i);
            }
        }

    }

    private void updateNPCs() {

        if (npcs.isEmpty()) {

            ingame = false;
            return;
        }

        for (int i = 0; i < npcs.size(); i++) {

            NPC n = npcs.get(i);

            if (n.isVisible()) {
                n.move();
            } else {
                npcs.remove(i);
            }
        }
    }

    private void checkCollisions() {

        Rectangle r3 = player.getBounds();

        List<Projectile> ms = player.getProjectiles();

        if (player.getEXP() >= player.getMaxEXP()) {
            player.evolve();
            System.out.println("> Player Evolved!");
        }

        for (Projectile m : ms) {

            Rectangle r1 = m.getBounds();
            for (NPC npc : npcs) {

                Rectangle r2 = npc.getBounds();

                if (r1.intersects(r2)) {
                    System.out.println("> Projectile collided with NPC");
                    player.setEXP(player.getEXP()+20);
                    m.setVisible(false);
                    npc.setVisible(false);
                }
            }
        }

        for (NPC npc : npcs) {

            Rectangle r2 = npc.getBounds();

            if (r3.intersects(r2)) {
                System.out.println("> Player collided with NPC");
                if (player.getHP() < 1) {
                    ingame = false;
                }
                if (player.getState()) {
                    player.setState(false);
                    player.decHP(15);
                    hpDrawLoc -= 15;
                }
            }
        }

        for (Item item : items) {

            Rectangle r4 = item.getBounds();

            if (r3.intersects(r4) && item.getType() == ItemType.RARE_CANDY) {
                player.setEXP(player.getEXP() + 40);
                item.setVisible(false);
            }

            if (r3.intersects(r4) && item.getType() == ItemType.POTION) {
                player.incHP(1);
                item.setVisible(false);
            }

        }
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
    }
}