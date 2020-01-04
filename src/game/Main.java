package game;

import GUI.SPanel;
import modes.MultiplayerMode;
import modes.OnlineMode;
import modes.SingleMode;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {
    // Frame Properties
    static JFrame frame;
    static SPanel panel;
    static ImageIcon imgIcon;
    static int WIDTH = 1200;
    static int HEIGHT = 900;

    // Different modes available for playing
    public static SingleMode singleGame;
    public static MultiplayerMode multiplayerGame;
    public static OnlineMode onlineGame;

    // Threads
    public static Thread singleThread;
    public static Thread multiplayerThread;
    public static Thread onlineThread;

    public static void main(String[] args) {
        init();
        configureWindow();
        run();
    }

    private static void run() {
        while(true) {
            render();
        }
    }

    private static void init() {
        frame = new JFrame("Snake Game");
        panel = new SPanel();
        imgIcon = new ImageIcon("res/snake.png");
        singleGame = new SingleMode();
        multiplayerGame = new MultiplayerMode();
        onlineGame = new OnlineMode();
        singleThread = new Thread(singleGame);
        multiplayerThread = new Thread(multiplayerGame);
        onlineThread = new Thread(onlineGame);
    }

    private static void configureWindow() {
        // Panel properties
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        // Frame properties
        frame.setIconImage(imgIcon.getImage());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
    }

    public static void startSinglePlayer(boolean gameSpeed, String nickname) {

        singleGame.reset();
        singleGame.setNickname(nickname);
        //if gameSpeed is false == slow speed
        if(!gameSpeed){
            SingleMode.gameSpeed = 450000000;
        }
        singleThread = new Thread(singleGame);
        singleThread.start();
    }

    public static void startMultiplayerGame(boolean gameSpeed) {
        multiplayerGame.reset();
        if(!gameSpeed){
            MultiplayerMode.gameSpeed = 450000000;
        }
        multiplayerThread = new Thread(multiplayerGame);
        multiplayerThread.start();
    }

    public static void startOnlineGame(String host) {
        onlineGame.setIP(host);
        onlineThread= new Thread(onlineGame);
        onlineThread.start();
    }

    public static void render() {
        panel.repaint();
    }
}
