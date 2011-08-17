package akiinyo;

import java.util.Random;

public class Monster {
	
	public Monster monster() {
		Random r = new Random();
		int monster = r.nextInt(2);
		if (monster % 2 == 0) {
			return new Slime();
		} else {
			return new Dragon();
		}
	}

	public String getName() {
			return monster().getName();
		}

	public int getHP() {
			return monster().getHP();
		} 
	
	public int getPower() {
			return monster().getPower();
	}
}
