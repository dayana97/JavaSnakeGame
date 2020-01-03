package modes;

import controls.KeyInput;
import entities.Snack;
import entities.Snake;

public class GameMode {
    Snake snake;
    Snack snack;
    boolean paused = false;
    KeyInput input;

    public Snake getSnake() {
        return snake;
    }

    public Snack getSnack() {
        return snack;
    }
}
