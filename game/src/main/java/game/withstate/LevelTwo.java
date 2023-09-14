package game.withstate;

public class LevelTwo extends LevelState{
    protected LevelTwo(Game game) {
        super(game);
    }
    @Override
    public void addPoints(int points) {
        game.setTotalPoints(game.getTotalPoints()+2*points);
        super.addPoints(points);
    }
    @Override
    public void checkForLevelUp() {
        if(game.getTotalPoints()>20)
        {
            game.setLevel(3);
            game.setTotalPoints(game.getTotalPoints()+1);
            LevelThree levelThree=new LevelThree(game);
            game.setLevelState(levelThree);

        }
    }
}
