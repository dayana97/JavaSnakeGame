package modes;

import entities.Moves;
import entities.Snack;
import entities.Snake;

import java.util.ArrayList;

public class MultiplayerMode extends GameMode implements Runnable{
    ArrayList<Snake> snakes;
    Snack snack;

    // Game Properties
    public static boolean running = false;
    public static boolean paused = false;
    public static int gameSpeed = 100000000;

    public MultiplayerMode() {
        snakes = new ArrayList<Snake>();
        snakes.add(new Snake());
        snakes.add(new Snake(780, 780, Moves.left));
        snack = new Snack();
    }

    public void reset() {
        snakes.get(0).reset();
        snakes.get(1).reset();
        snack.reset();
        running = false;
        paused = false;
    }

    @Override
    public void run() {
        long last = System.nanoTime();
        running = true;

        while(running) {
            if(!paused) {
                if(System.nanoTime() - last > gameSpeed) {
                    last = System.nanoTime();
                    tick();
                }
            }

        }

    }

    private void tick() {
        snakes.get(0).tick();
        snakes.get(1).tick();
        snack.tick();

        if(snakes.get(0).checkCollisionWith(snack)) {
            snack = new Snack();
        }

        if(snakes.get(1).checkCollisionWith(snack)) {
            snack = new Snack();
        }

        if(snakes.get(0).checkCollisionWith(snakes.get(1))) {
            snack = new Snack();
        }

        if(snakes.get(1).checkCollisionWith(snakes.get(0))) {
            snack = new Snack();
        }
    }


    public Snake getSnake(int x) {
        return snakes.get(x);
    }

    public Snack getSnack() {
        return snack;
    }
}
