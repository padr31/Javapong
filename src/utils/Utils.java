package utils;

import java.util.Random;

public class Utils {

	/**
	 * Puts the thread into a sleep for the specified amount of milliseconds
	 * @param millis Amount of milliseconds to sleep
	 */
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param n
	 * @return A random integer from the range of [-n;0) or (0;n]
	 */
	public static int randomWithNegative(int n) {
		Random r = new Random();
		return r.nextInt(n) == 0 ? (r.nextInt(n)+1) : -(r.nextInt(n)+1);
		
	}
	
	/**
	 * @param n
	 * @return A random integer from the range of (0;n]
	 */
	public static int randomPositive(int n) {
		Random r = new Random();
		return r.nextInt(n)+1;
		
	}

	/**
	 * @param n
	 * @return A random integer from the range of [-n;0)
	 */
	public static int randomNegative(int n) {
		Random r = new Random();
		return -(r.nextInt(n)+1);
		
	}
}
