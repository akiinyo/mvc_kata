package akiinyo;

public class Dragon extends Monster {

	String name;
	int hp;

	Dragon(String name, int hp) {
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
