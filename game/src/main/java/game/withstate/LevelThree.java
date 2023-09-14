package game.withstate;

import game.withstate.Game;

public class LevelThree extends LevelState {
    protected LevelThree(Game game) {
        super(game);
    }

    @Override
    public void addPoints(int points) {
        game.setTotalPoints(game.getTotalPoints() + 2 * points);
        super.addPoints(points);
    }

    @Override
    public void checkForLevelUp() {
        if (game.getTotalPoints() > 10) {

        }
    }
}
