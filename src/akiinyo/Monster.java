package akiinyo;

import java.util.Random;

public class Monster {

	public Monster monster() {
		Random r = new Random();
		int monster = r.nextInt(2) + 1;
		if (monster % 2 == 0) {
			return new Slime("スライム", 8);
		} else {
			return new Dragon("ドラゴン", 30);
		}
	}
	
	public String getName() {
		return monster().getName();
	}

	public int getHP() {
		return monster().getHP();
	}

}
