package game.withstate;

import game.withstate.Game;

public class LevelOne extends LevelState{
    protected LevelOne(Game game) {
        super(game);
    }

    @Override
    public void addPoints(int points) {

        game.setTotalPoints(game.getTotalPoints()+points);
        super.addPoints(points);
    }

    @Override
    public void checkForLevelUp() {
        if(game.getTotalPoints()>10)
        {
            game.setLevel(2);
            game.setTotalPoints(game.getTotalPoints()+2);
            LevelTwo levelTwo=new LevelTwo(game);
            game.setLevelState(levelTwo);

        }

    }
}
