package view;

import controller.Dungeon;
import controller.Game;
import model.PC;
import model.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Startgame extends JPanel {

    private Game game;
    private View view;
    private Dungeon dungeon;
    private PC pc;
    private Room currentRoom;
    private Startgame startgame;
    ImageIcon startGame = new ImageIcon("src/resources/StartGame.png");

    public Startgame(Game game) {

        this.game = game;

        addKeyListener(new Startgame.TAdapter());
        setBackground(Color.black);
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        g.drawImage(startGame.getImage(), 0, 0, this);
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            game.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            game.keyPressed(e);
        }
    }
}
