package akiinyo;

public class Slime extends Monster {

	String name;
	int hp;

	Slime(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}

	public String getName() {
		return this.name;
	}

	public int getHP() {
		return this.hp;
	}

}
