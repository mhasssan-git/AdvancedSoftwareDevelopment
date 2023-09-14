package game.withstate;

public class Application {

	public static void main(String[] args) {
		Game game = new Game();
		LevelOne levelOne=new LevelOne(game);
		game.setLevelState(levelOne);
		game.play();
		game.play();
		game.play();
		game.play();
		game.play();

	}

}
