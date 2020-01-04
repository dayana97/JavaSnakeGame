package GUI;
import controls.Buttons;
import controls.KeyInput;
import game.Main;
import modes.MultiplayerMode;
import modes.SingleMode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    public static String nickname;

    // Game Size
    public int w = 800;
    public int h = 800;

    Display display;

    // Panel Components
    Image snakeTitleIMG;
    Image playButtonIMG;
    Image menuButtonIMG;
    Image singleButtonIMG;
    Image multiplayerButtonIMG;
    Image onlineButtonIMG;
    Image backButtonIMG;
    Image connectButtonIMG;
    Image exitButtonIMG;
    Image settingsButtonIMG;
    Image fastSpeedButtonIMG;
    Image slowSpeedButtonIMG;
    Image enterButtonIMG;

    JLabel authorCredit;

    public JTextField ipTextField;

    public JButton enterButton;
    public JButton fastSpeedButton;
    public JButton slowSpeedButton;
    public JButton playButton;
    public JButton singleButton;
    public JButton settingsButton;
    public JButton multiplayerButton;
    public JButton onlineButton;
    public JButton backButton;
    public JButton menuButton;
    public JButton connectButton;
    public JButton returnButton;
    public JButton exitButton;

    public JTextField nicknameField;

    public JLabel label;

    // Controls
    KeyInput input;

    Buttons buttonListener;

    public SPanel() {
        display = Display.InitialScreen;
        init();
        addComponents();
    }

    private void addComponents() {

        this.add(playButton);
        this.add(menuButton);
        this.add(singleButton);
        this.add(settingsButton);
        this.add(multiplayerButton);
        this.add(onlineButton);
        this.add(backButton);
        this.add(authorCredit);
        this.add(ipTextField);
        this.add(connectButton);
        this.add(returnButton);
        this.add(exitButton);
        this.add(fastSpeedButton);
        this.add(slowSpeedButton);
        this.add(nicknameField);
        this.add(label);
        this.add(enterButton);

        playButton.addActionListener(buttonListener);
        menuButton.addActionListener(buttonListener);
        singleButton.addActionListener(buttonListener);
        multiplayerButton.addActionListener(buttonListener);
        onlineButton.addActionListener(buttonListener);
        backButton.addActionListener(buttonListener);
        connectButton.addActionListener(buttonListener);
        returnButton.addActionListener(buttonListener);
        ipTextField.addActionListener(buttonListener);
        exitButton.addActionListener(buttonListener);
        settingsButton.addActionListener(buttonListener);
        slowSpeedButton.addActionListener(buttonListener);
        fastSpeedButton.addActionListener(buttonListener);
        enterButton.addActionListener(buttonListener);

        addKeyListener(input);
    }

    private void init() {

        buttonListener = new Buttons(this);
        input = new KeyInput();
        authorCredit = new JLabel("Created by D.Mladenova");
        ipTextField = new JTextField();
        ipTextField.setFont(new Font("SansSerif", Font.PLAIN, 32));

        try {
            snakeTitleIMG = ImageIO.read(new File("res/snake.png"));
            playButtonIMG = ImageIO.read(new File("res/play_button.png"));
            menuButtonIMG = ImageIO.read(new File("res/menu_button.png"));
            singleButtonIMG = ImageIO.read(new File("res/single_button.png"));
            multiplayerButtonIMG = ImageIO.read(new File("res/local_button.png"));
            onlineButtonIMG = ImageIO.read(new File("res/online_button.png"));
            backButtonIMG = ImageIO.read(new File("res/back_button.png"));
            connectButtonIMG = ImageIO.read(new File("res/connect_button.png"));
            exitButtonIMG = ImageIO.read(new File("res/exit_button.png"));
            settingsButtonIMG = ImageIO.read(new File("res/settings_button.png"));
            slowSpeedButtonIMG = ImageIO.read(new File("res/slow_speed.png"));
            fastSpeedButtonIMG = ImageIO.read(new File("res/fast_speed.png"));
            enterButtonIMG = ImageIO.read(new File("res/enter_button.png"));

            playButton = new JButton(new ImageIcon(playButtonIMG));
            menuButton = new JButton(new ImageIcon(menuButtonIMG));
            singleButton = new JButton(new ImageIcon(singleButtonIMG));
            settingsButton = new JButton(new ImageIcon(settingsButtonIMG));
            multiplayerButton = new JButton(new ImageIcon(multiplayerButtonIMG));
            onlineButton = new JButton(new ImageIcon(onlineButtonIMG));
            backButton = new JButton(new ImageIcon(backButtonIMG));
            returnButton = new JButton(new ImageIcon(backButtonIMG));
            exitButton = new JButton(new ImageIcon(exitButtonIMG));
            slowSpeedButton = new JButton(new ImageIcon(slowSpeedButtonIMG));
            fastSpeedButton = new JButton(new ImageIcon(fastSpeedButtonIMG));
            connectButton = new JButton(new ImageIcon(connectButtonIMG));
            enterButton = new JButton(new ImageIcon(enterButtonIMG));

            nicknameField = new JTextField();
            label = new JLabel("Nickname");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setScreenMode(Display s) {
        display = s;
    }

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        int offsetX = this.getWidth()/2 - w/2;
        int offsetY = this.getHeight()/2 - h/2;

        switch(display) {
            case InitialScreen:

                label.setText("<html><font color='green'>Type your nickname and press ENTER to start the game</font></html>\")");
                label.setVisible(true);
                label.setPreferredSize(new Dimension(250, 60));
                label.setLocation(this.getWidth()/2 - nicknameField.getWidth()/2, this.getHeight()/2 - nicknameField.getHeight()/2);
                nicknameField.setVisible(true);
                nicknameField.setPreferredSize(new Dimension(250, 45));
                nicknameField.setLocation(this.getWidth()/2 - nicknameField.getWidth()/2, this.getHeight()/2 - nicknameField.getHeight()/2 + 55);
                nickname = nicknameField.getText();
                enterButton.setVisible(true);
                enterButton.setPreferredSize(new Dimension(400, 60));
                enterButton.setLocation(this.getWidth()/2 - enterButton.getWidth()/2, this.getHeight()/2 - enterButton.getHeight()/2 + 120);
                playButton.setVisible(false);
                singleButton.setVisible(false);
                menuButton.setVisible(false);
                settingsButton.setVisible(false);
                multiplayerButton.setVisible(false);
                authorCredit.setVisible(false);
                onlineButton.setVisible(false);
                backButton.setVisible(false);
                ipTextField.setVisible(false);
                connectButton.setVisible(false);
                returnButton.setVisible(false);
                exitButton.setVisible(false);
                fastSpeedButton.setVisible(false);
                slowSpeedButton.setVisible(false);
                break;
            case Settings:
                fastSpeedButton.setVisible(true);
                fastSpeedButton.setPreferredSize(new Dimension(400, 60));
                fastSpeedButton.setLocation(this.getWidth()/2 - fastSpeedButton.getWidth()/2, this.getHeight()/2 - fastSpeedButton.getHeight()/2);
                slowSpeedButton.setVisible(true);
                slowSpeedButton.setPreferredSize(new Dimension(400, 60));
                slowSpeedButton.setLocation(this.getWidth()/2 - slowSpeedButton.getWidth()/2, this.getHeight()/2 - slowSpeedButton.getHeight()/2 + 80);
                settingsButton.setVisible(false);
                menuButton.setVisible(false);
                break;
            case Menu:
                g.drawImage(snakeTitleIMG, this.getWidth()/2 - snakeTitleIMG.getWidth(this)/2, 50, this);

                playButton.setPreferredSize(new Dimension(400, 60));
                playButton.setLocation(this.getWidth()/2 - playButton.getWidth()/2, this.getHeight()/2 - playButton.getHeight()/2);

                exitButton.setPreferredSize(new Dimension(400, 60));
                exitButton.setLocation(this.getWidth()/2 - exitButton.getWidth()/2, this.getHeight()/2 - exitButton.getHeight()/2 + 80);

                authorCredit.setLocation(5, this.getHeight() - authorCredit.getHeight() - 5);
                enterButton.setVisible(false);
                nicknameField.setVisible(false);
                label.setVisible(false);
                settingsButton.setVisible(false);
                ipTextField.setVisible(false);
                connectButton.setVisible(false);
                playButton.setVisible(true);
                authorCredit.setVisible(true);
                menuButton.setVisible(false);
                singleButton.setVisible(false);
                multiplayerButton.setVisible(false);
                onlineButton.setVisible(false);
                backButton.setVisible(false);
                returnButton.setVisible(false);
                exitButton.setVisible(true);
                fastSpeedButton.setVisible(false);
                slowSpeedButton.setVisible(false);

                break;
            case PlayMenu:
                playButton.setVisible(false);
                menuButton.setVisible(false);
                authorCredit.setVisible(true);
                ipTextField.setVisible(false);
                connectButton.setVisible(false);
                returnButton.setVisible(false);
                settingsButton.setVisible(false);
                fastSpeedButton.setVisible(false);
                slowSpeedButton.setVisible(false);

                authorCredit.setLocation(5, this.getHeight() - authorCredit.getHeight() - 5);
                g.drawImage(snakeTitleIMG, this.getWidth()/2 - snakeTitleIMG.getWidth(this)/2, 50, this);

                singleButton.setPreferredSize(new Dimension(400, 60));
                singleButton.setLocation(this.getWidth()/2 - singleButton.getWidth()/2, this.getHeight()/2 - singleButton.getHeight()/2);
                singleButton.setVisible(true);

                settingsButton.setVisible(false);

                multiplayerButton.setPreferredSize(new Dimension(400, 60));
                multiplayerButton.setLocation(this.getWidth()/2 - multiplayerButton.getWidth()/2, this.getHeight()/2 - multiplayerButton.getHeight()/2 + 20 + multiplayerButton.getHeight());
                multiplayerButton.setVisible(true);

                onlineButton.setPreferredSize(new Dimension(400, 60));
                onlineButton.setLocation(this.getWidth()/2 - onlineButton.getWidth()/2, this.getHeight()/2 - onlineButton.getHeight()/2 + 100 + onlineButton.getHeight());
                onlineButton.setVisible(true);

                backButton.setPreferredSize(new Dimension(400, 60));
                backButton.setLocation(this.getWidth()/2 - backButton.getWidth()/2, this.getHeight()/2 - backButton.getHeight()/2 + 180 + backButton.getHeight());
                backButton.setVisible(true);

                break;
            case Game:
                requestFocus();
                menuButton.setLocation(offsetX + w - menuButton.getWidth(), offsetY + h);
                menuButton.setPreferredSize(new Dimension(100, 40));
                settingsButton.setLocation(offsetX + w - settingsButton.getWidth() - 100, offsetY + h);
                settingsButton.setPreferredSize(new Dimension(100, 40));
                playButton.setVisible(false);
                singleButton.setVisible(false);
                menuButton.setVisible(true);
                settingsButton.setVisible(true);
                multiplayerButton.setVisible(false);
                authorCredit.setVisible(false);
                onlineButton.setVisible(false);
                backButton.setVisible(false);
                ipTextField.setVisible(false);
                connectButton.setVisible(false);
                returnButton.setVisible(false);
                exitButton.setVisible(false);
                fastSpeedButton.setVisible(false);
                slowSpeedButton.setVisible(false);

                g.setColor(Color.GRAY);
                g.fillRect(offsetX, offsetY, w, h);

                //Render entities
                Main.singleGame.getSnack().render(g, Color.GREEN, offsetX, offsetY);
                Main.singleGame.getSnake().render(g, Color.RED, offsetX, offsetY);

                if(SingleMode.paused) {
                    g.drawString("Paused", this.getWidth()/2, this.getHeight()/2);
                }

                break;
            case multiplayerGame:
                requestFocus();
                menuButton.setLocation(offsetX + w - menuButton.getWidth(), offsetY + h);
                menuButton.setPreferredSize(new Dimension(100, 40));
                settingsButton.setLocation(offsetX + w - settingsButton.getWidth() - 100, offsetY + h);
                settingsButton.setPreferredSize(new Dimension(100, 40));
                playButton.setVisible(false);
                singleButton.setVisible(false);
                menuButton.setVisible(true);
                settingsButton.setVisible(true);
                multiplayerButton.setVisible(false);
                authorCredit.setVisible(false);
                onlineButton.setVisible(false);
                backButton.setVisible(false);
                ipTextField.setVisible(false);
                connectButton.setVisible(false);
                returnButton.setVisible(false);
                exitButton.setVisible(false);
                fastSpeedButton.setVisible(false);
                slowSpeedButton.setVisible(false);

                g.setColor(Color.GRAY);
                g.fillRect(offsetX, offsetY, w, h);

                //Render entities
                Main.multiplayerGame.getSnack().render(g, Color.GREEN, offsetX, offsetY);
                Main.multiplayerGame.getSnake(0).render(g, Color.RED, offsetX, offsetY);
                Main.multiplayerGame.getSnake(1).render(g, Color.BLUE, offsetX, offsetY);

                if(MultiplayerMode.paused) {
                    g.drawString("Paused", this.getWidth()/2, this.getHeight()/2);
                }
                break;
            case OnlineMenu:
                playButton.setVisible(false);
                singleButton.setVisible(false);
                menuButton.setVisible(false);
                multiplayerButton.setVisible(false);
                authorCredit.setVisible(true);
                onlineButton.setVisible(false);
                backButton.setVisible(false);
                ipTextField.setVisible(true);
                connectButton.setVisible(true);
                returnButton.setVisible(true);
                exitButton.setVisible(false);
                fastSpeedButton.setVisible(false);
                slowSpeedButton.setVisible(false);

                ipTextField.requestFocus();
                ipTextField.setEditable(true);

                authorCredit.setLocation(5, this.getHeight() - authorCredit.getHeight() - 5);
                g.drawImage(snakeTitleIMG, this.getWidth()/2 - snakeTitleIMG.getWidth(this)/2, 50, this);
                connectButton.setPreferredSize(new Dimension(400, 60));
                ipTextField.setPreferredSize(new Dimension(400, 60));
                returnButton.setPreferredSize(new Dimension(400, 60));
                ipTextField.setLocation(this.getWidth()/2 - ipTextField.getWidth()/2, this.getHeight()/2 - ipTextField.getHeight()/2);
                connectButton.setLocation(this.getWidth()/2 - connectButton.getWidth()/2, this.getHeight()/2 - connectButton.getHeight()/2 + 80);
                returnButton.setLocation(this.getWidth()/2 - backButton.getWidth()/2, this.getHeight()/2 - backButton.getHeight()/2 + 180 + backButton.getHeight());

                break;
            case OnlineGame:
                requestFocus();
                menuButton.setLocation(offsetX + w - menuButton.getWidth(), offsetY + h);
                menuButton.setPreferredSize(new Dimension(100, 40));

                playButton.setVisible(false);
                singleButton.setVisible(false);
                menuButton.setVisible(true);
                multiplayerButton.setVisible(false);
                authorCredit.setVisible(false);
                onlineButton.setVisible(false);
                backButton.setVisible(false);
                ipTextField.setVisible(false);
                connectButton.setVisible(false);
                returnButton.setVisible(false);
                exitButton.setVisible(false);
                fastSpeedButton.setVisible(false);
                slowSpeedButton.setVisible(false);

                g.setColor(Color.GRAY);
                g.fillRect(offsetX, offsetY, w, h);

                //Render entities
                Main.onlineGame.getSnack().render(g, Color.GREEN, offsetX, offsetY);
                Main.onlineGame.getSnake(0).render(g, Color.RED, offsetX, offsetY);
                Main.onlineGame.getSnake(1).render(g, Color.BLUE, offsetX, offsetY);

                break;
        }
        // TODO: Add game speed settings
    }
}
