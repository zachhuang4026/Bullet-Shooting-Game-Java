package game.model;



import edu.uchicago.gerber._08final.mvc.controller.Sound;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//the lombok @Data gives us automatic getters and setters on all members
@Data
public class CommandCenter {

	private  int numFalcons;
	private  int level;
	private  long score;
	private  Falcon falcon;
	private  boolean playing;
	private  boolean paused;

	private List<Movable> movDebris = new ArrayList<>();
	private List<Movable> movFriends = new ArrayList<>();
	private List<Movable> movFoes = new ArrayList<>();
	private List<Movable> movFloaters = new ArrayList<>();

	private GameOpsList opsList = new GameOpsList();


	private static CommandCenter instance = null;

	// Constructor made private - static Utility class only
	private CommandCenter() {}


	public static CommandCenter getInstance(){
		if (instance == null){
			instance = new CommandCenter();
		}
		return instance;
	}


	public  void initGame(){
		setLevel(1);
		setScore(0);
		setNumFalcons(4);
		spawnFalcon();
	}

	public  void spawnFalcon() {
		if (getNumFalcons() != 0) {
			falcon = new Falcon();
			opsList.enqueue(falcon, CollisionOp.Operation.ADD);
			setNumFalcons(getNumFalcons() - 1);
		}
		Sound.playSound("shipspawn.wav");

	}

	public  void clearAll(){
		movDebris.clear();
		movFriends.clear();
		movFoes.clear();
		movFloaters.clear();
	}


	public  boolean isGameOver() {		//if the number of falcons is zero, then game over
		return getNumFalcons() == 0;
	}

	public void addScore(){
		score += 1;
		System.out.println("Score" + score);
	}

	public long getScore(){
		return score;
	}

	public int getNumFalcons(){
		return numFalcons;
	}

	public int getLevel(){
		return level;
	}

	public void resetScore() {
		score = 0;
	}

	public void addHP(){
		numFalcons += 1;
	}


	public List<Movable> getMoveDebris(){
		return movDebris;
	}

}
