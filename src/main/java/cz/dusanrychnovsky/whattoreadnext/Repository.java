package cz.dusanrychnovsky.whattoreadnext;

import java.util.Random;

public abstract class Repository {

	private Random rand = new Random();
	
	/**
	 * 
	 * @return
	 */
	protected int newId() {
		return Math.abs(rand.nextInt());
	}
}
