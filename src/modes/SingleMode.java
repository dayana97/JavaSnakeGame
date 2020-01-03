package modes;

import entities.Snack;
import entities.Snake;

public class SingleMode extends GameMode implements Runnable{
    // Game Properties
    public static boolean running = false;
    public static boolean paused = false;
    static int gameSpeed = 100000000;

    // Entities
    Snake snake;
    Snack snack;

    public SingleMode() {
        snake = new Snake();
        snack = new Snack();
    }

    public void reset() {
        snake.reset();
        snack.reset();
        running = false;
        paused = false;
    }


    @Override
    public void run() {
        running = true;

        long last = System.nanoTime();
        while(running) {
            if(!paused) {
                if(System.nanoTime() - last > gameSpeed) {
                    last = System.nanoTime();
                    tick();
                }
            }
        }
    }

    public void tick() {

        snake.tick();
        snack.tick();

        if(snake.checkCollisionWith(snack)) {
            snack = new Snack();
        }

    }

    public Snake getSnake() {
        return snake;
    }

    public Snack getSnack() {
        return snack;
    }
}
