package ticTacToe.v250;

public abstract class GameController {

	private Game game;

	protected GameController(Game game) {
		assert game != null;
		this.game = game;
	}
	
	public abstract void control();
	
	protected State getState(){
		return game.getState();
	}
	
	protected void setState(State state){
		assert state != null;
		game.setState(state);
	}
	
	protected Board getBoard() {
		return game.getBoard();
	}
	
	protected Turn getTurn() {
		return game.getTurn();
	}
}
