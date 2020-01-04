package controls;
import entities.Moves;
import game.Main;
import modes.MultiplayerMode;
import modes.SingleMode;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener{
    @Override
    public void keyPressed(KeyEvent e) {

        if(Main.singleThread.isAlive()) {
            if(e.getKeyCode() == KeyEvent.VK_W) {
                if(Main.singleGame.getSnake().getMoves() != Moves.down)
                    Main.singleGame.getSnake().setMoves(Moves.up);
            }else if(e.getKeyCode() == KeyEvent.VK_D) {
                if(Main.singleGame.getSnake().getMoves() != Moves.left)
                    Main.singleGame.getSnake().setMoves(Moves.right);
            }else if(e.getKeyCode() == KeyEvent.VK_S) {
                if(Main.singleGame.getSnake().getMoves() != Moves.up)
                    Main.singleGame.getSnake().setMoves(Moves.down);
            }else if(e.getKeyCode() == KeyEvent.VK_A) {
                if(Main.singleGame.getSnake().getMoves() != Moves.right)
                    Main.singleGame.getSnake().setMoves(Moves.left);
            }else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                SingleMode.paused = !SingleMode.paused;
            }
        }

        if(Main.multiplayerThread.isAlive()) {
            if(e.getKeyCode() == KeyEvent.VK_W) {
                if(Main.multiplayerGame.getSnake(0).getMoves() != Moves.down)
                    Main.multiplayerGame.getSnake(0).setMoves(Moves.up);
            }else if(e.getKeyCode() == KeyEvent.VK_D) {
                if(Main.multiplayerGame.getSnake(0).getMoves() != Moves.left)
                    Main.multiplayerGame.getSnake(0).setMoves(Moves.right);
            }else if(e.getKeyCode() == KeyEvent.VK_S) {
                if(Main.multiplayerGame.getSnake(0).getMoves() != Moves.up)
                    Main.multiplayerGame.getSnake(0).setMoves(Moves.down);
            }else if(e.getKeyCode() == KeyEvent.VK_A) {
                if(Main.multiplayerGame.getSnake(0).getMoves() != Moves.right)
                    Main.multiplayerGame.getSnake(0).setMoves(Moves.left);
            }else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                MultiplayerMode.paused = !MultiplayerMode.paused;
                if(!MultiplayerMode.running) {
                    MultiplayerMode.running = true;
                }
            }

            if(e.getKeyCode() == KeyEvent.VK_UP) {
                if(Main.multiplayerGame.getSnake(1).getMoves() != Moves.down)
                    Main.multiplayerGame.getSnake(1).setMoves(Moves.up);
            }else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if(Main.multiplayerGame.getSnake(1).getMoves() != Moves.left)
                    Main.multiplayerGame.getSnake(1).setMoves(Moves.right);
            }else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                if(Main.multiplayerGame.getSnake(1).getMoves() != Moves.up)
                    Main.multiplayerGame.getSnake(1).setMoves(Moves.down);
            }else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                if(Main.multiplayerGame.getSnake(1).getMoves() != Moves.right)
                    Main.multiplayerGame.getSnake(1).setMoves(Moves.left);
            }
        }

        if(Main.onlineThread.isAlive()) {
            if(e.getKeyCode() == KeyEvent.VK_W) {
                if(Main.onlineGame.getSnake(0).getMoves() != Moves.down)
                    Main.onlineGame.getSnake(0).setMoves(Moves.up);
            }else if(e.getKeyCode() == KeyEvent.VK_D) {
                if(Main.onlineGame.getSnake(0).getMoves() != Moves.left)
                    Main.onlineGame.getSnake(0).setMoves(Moves.right);
            }else if(e.getKeyCode() == KeyEvent.VK_S) {
                if(Main.onlineGame.getSnake(0).getMoves() != Moves.up)
                    Main.onlineGame.getSnake(0).setMoves(Moves.down);
            }else if(e.getKeyCode() == KeyEvent.VK_A) {
                if(Main.onlineGame.getSnake(0).getMoves() != Moves.right)
                    Main.onlineGame.getSnake(0).setMoves(Moves.left);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

}
