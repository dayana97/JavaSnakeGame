import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame object = new JFrame();
        GamePlay gamePlay = new GamePlay();

        object.setBounds(10, 10,905,700);
        object.setBackground(Color.PINK);
        object.setResizable(false);
        object.setVisible(true);
        object.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        object.add(gamePlay);
    }
}
