package game.withstate;

import game.withstate.Game;

public abstract class LevelState {
    protected final Game game;

    protected LevelState(Game game) {
        this.game = game;
    }

    public  void addPoints(int points) {
        checkForLevelUp();
    }
    public abstract void checkForLevelUp();
}
