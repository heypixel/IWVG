package ticTacToe.v230;

public abstract class ColocateController {

	private Turn turn;

	private Board board;
	
	private TicTacToeCoordinate target;

	protected ColocateController(Turn turn, Board board) {
		assert turn != null;
		assert board != null;
		this.turn = turn;
		this.board = board;
		target = new TicTacToeCoordinate();
	}
	
	public abstract void control();
	
	protected void control(String actionTitle, String targetTitle) {
		IO io = new IO();
		io.writeln(actionTitle + " el jugador " + turn.take());
		this.colocate(targetTitle);
		board.write();
		if (board.existTicTacToe(turn.take())) {
			io.writeln("Victoria!!!! " + turn.take() + "! " + turn.take()
					+ "! " + turn.take() + "! Victoria!!!!");
		} else {
			turn.change();
		}
	}
	
	protected abstract void colocate(String targetTitle);
	
	protected void put(String targetTitle) {
		target = new TicTacToeCoordinate();
		boolean ok;
		do {
			target.read(targetTitle);
			ok = this.errorToPut();
		} while (ok);
		board.put(target, turn.take());
	}
	
	protected boolean errorToPut() {
		boolean ok = this.getBoard().empty(this.getTarget());
		if (!ok) {
			new IO().writeln("Esa casilla no está vacía");
		}
		return ok;
	}

	protected Turn getTurn() {
		return turn;
	}

	protected Board getBoard() {
		return board;
	}	
	
	protected TicTacToeCoordinate getTarget(){
		return target;
	}
	
}
