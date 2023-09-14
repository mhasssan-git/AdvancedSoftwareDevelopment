package game.withstate;

import java.util.Random;

public class Game {
    private int totalPoints = 0;
    private int level = 1;

    private LevelState levelState;

    public void play() {
        Random random = new Random();
        addPoints(random.nextInt(7));
        System.out.println("points=" + totalPoints + " level=" + level);
    }

    public void addPoints(int newPoints) {
        levelState.addPoints(newPoints);
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public LevelState getLevelState() {
        return levelState;
    }

    public void setLevelState(LevelState levelState) {
        this.levelState = levelState;
    }
}
