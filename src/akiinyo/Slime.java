package akiinyo;

import java.util.Random;

public class Slime extends Monster {
	String name = "スライム";
	int hp = 8;
	Random r = new Random();
	int power = r.nextInt(2) + 1;
	int s_power = power;

	public String getName() {
		return this.name;
	}

	public int getHP() {
		return this.hp;
	}

	public int getPower() {
		return this.s_power;
	}
}
