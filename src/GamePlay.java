import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class GamePlay extends JPanel implements KeyListener, ActionListener {

    private int[] snakeXLength = new int[750];
    private int[] snakeYLength = new int[750];

    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;

    private ImageIcon rightmouth;
    private ImageIcon upmouth;
    private ImageIcon downmouth;
    private ImageIcon leftmouth;

    private int lengthOfSnake = 3;

    //speed of Snake
    private Timer timer;
    private int delay = 100;
    //for the snake body
    private ImageIcon snakeimage;

    private int [] enemyXPosition = {25,50,75,100,125,150,175,200,225,250,275,300,325,350,
            375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
    private int [] enemyYPosition = {75,100,125,150,175,200,225,250,275,300,325,350,
            375,400,425,450,475,500,525,550,575,600,625};

    private  ImageIcon enemyimage;

    private Random random = new Random();

    private int XPosition = random.nextInt(34);
    private int YPosition = random.nextInt(23);

    private int moves = 0;

    private ImageIcon titleImage;

    public GamePlay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g){

        if(moves == 0){
           snakeXLength[2] = 50;
           snakeXLength[1] = 75;
           snakeXLength[0] = 100;

            snakeYLength[2] = 100;
            snakeYLength[1] = 100;
            snakeYLength[0] = 100;
        }

       //draw title image border
        g.setColor(Color.white);
        g.drawRect(24,10,851,55);

        //draw the title image
        titleImage = new ImageIcon("snaketitle.jpg");
        titleImage.paintIcon(this, g,25,11);

        //draw border for gameplay
        g.setColor(Color.WHITE);
        g.drawRect(24, 74, 851, 577);

        //draw background for the gameplay
        g.setColor(Color.black);
        g.fillRect(25,75,850,575);

        rightmouth = new ImageIcon("rightmouth.png");
        rightmouth.paintIcon(this, g, snakeXLength[0],snakeYLength[0]);

        for(int a=0; a<lengthOfSnake; a++){
            if(a == 0 && right){
                rightmouth = new ImageIcon("rightmouth.png");
                rightmouth.paintIcon(this, g, snakeXLength[a],snakeYLength[a]);
            }
            if(a == 0 && left){
                leftmouth = new ImageIcon("leftmouth.png");
                leftmouth.paintIcon(this, g, snakeXLength[a],snakeYLength[a]);
            }
            if(a == 0 && down){
                downmouth = new ImageIcon("downmouth.png");
                downmouth.paintIcon(this, g, snakeXLength[a],snakeYLength[a]);
            }
            if(a == 0 && up){
                upmouth = new ImageIcon("upmouth.png");
                upmouth.paintIcon(this, g, snakeXLength[a],snakeYLength[a]);
            }
            if(a!=0){
                snakeimage = new ImageIcon("snakeimage.png");
                snakeimage.paintIcon(this, g, snakeXLength[a],snakeYLength[a]);
            }
        }

        //collated in the sneak head
        enemyimage = new ImageIcon("enemy.png");
        //position of sneak head
        if((enemyXPosition[XPosition] == snakeXLength[0] && enemyYPosition[YPosition] == snakeYLength[0])){
            lengthOfSnake++;
            XPosition = random.nextInt(34);
            YPosition = random.nextInt(23);
        }

            enemyimage.paintIcon(this, g, enemyXPosition[XPosition], enemyYPosition[YPosition]);

        g.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(right){
           for(int r = lengthOfSnake-1; r>=0; r--){
               snakeYLength[r+1] = snakeYLength[r];
           }
           for(int r = lengthOfSnake; r>=0; r--){
               if(r == 0){
                   snakeXLength[r] = snakeXLength[r] + 25;
               }
               else{
                   snakeXLength[r] = snakeXLength[r-1];
               }
               if(snakeXLength[r] > 850){
                   snakeXLength[r] = 25;
               }
           }
           repaint();
        }
        if(left){
            for(int r = lengthOfSnake-1; r>=0; r--){
                snakeYLength[r+1] = snakeYLength[r];
            }
            for(int r = lengthOfSnake; r>=0; r--){
                if(r == 0){
                    snakeXLength[r] = snakeXLength[r] - 25;
                }
                else{
                    snakeXLength[r] = snakeXLength[r-1];
                }
                if(snakeXLength[r] < 25){
                    snakeXLength[r] = 850;
                }
            }
            repaint();
        }
        if(up){
            for(int r = lengthOfSnake-1; r>=0; r--){
                snakeXLength[r+1] = snakeXLength[r];
            }
            for(int r = lengthOfSnake; r>=0; r--){
                if(r == 0){
                    snakeYLength[r] = snakeYLength[r] - 25;
                }
                else{
                    snakeYLength[r] = snakeYLength[r-1];
                }
                if(snakeYLength[r] < 75){
                    snakeYLength[r] = 625;
                }
            }
            repaint();
        }
        if(down){
            for(int r = lengthOfSnake-1; r>=0; r--){
                snakeXLength[r+1] = snakeXLength[r];
            }
            for(int r = lengthOfSnake; r>=0; r--){
                if(r == 0){
                    snakeYLength[r] = snakeYLength[r] + 25;
                }
                else{
                    snakeYLength[r] = snakeYLength[r-1];
                }
                if(snakeYLength[r] > 625){
                    snakeYLength[r] = 75;
                }
            }
            repaint();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            moves++;
            right = true;
            if(!left){
                right = true;
            }
            else{
                right = false;
                left= true;
            }

            down = false;
            up = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            moves++;
            left = true;
            if(!right){
                left = true;
            }
            else{
                right = true;
                left= false;
            }

            down = false;
            up = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_UP){
            moves++;
            up = true;
            if(!down){
                up = true;
            }
            else{
                down = true;
                up = false;
            }

            left = false;
            right = false;
        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            moves++;
            down = true;
            if(!up){
                down = true;
            }
            else{
                up = true;
                down = false;
            }

            left = false;
            right = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
