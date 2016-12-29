package graphics;

import java.util.ArrayList;
import java.util.List;
import config.Config;

public class Entities {

	public static List<Entity> entities = new ArrayList<Entity>();

	public static Ball ball;
	public static Racket racket;
	
	static {
		racket = new Racket(0, 0, Config.RACKET_COLOR, 5, 20);
		ball = new Ball(50, 50, Config.BALL_COLOR, 10);
	
		entities.add(ball);
		entities.add(racket);
	}
}
