package akiinyo;

import java.util.Random;

public class Dragon extends Monster {
	String name = "ドラゴン";
	int hp = 30;
	Random r = new Random();
	int power = r.nextInt(5) + 3;
	int d_power = power;

	public String getName() {
		return this.name;
	}

	public int getHP() {
		return this.hp;
	}

	public int getPower() {
		return this.d_power;
	}

}
