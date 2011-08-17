package akiinyo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Battle {
	private String player = "あき";
	private int myHP = 10;
	private int myMP = 6;
	Monster m = new Monster();
	String monster = m.getName();
	int m_hp = m.getHP();

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Battle battle = new Battle();
		battle.doit();
	}

	public void doit() throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("----------------");
		System.out.println(monster + "があらわれた！");
		System.out.println("----------------");

		for (;;) {
			if (myHP < 1 || m_hp < 1) {
				break;
			}
			if (myturn(in) == 3) {
				break;
			}
			String s1 = in.readLine();
			if (s1.length() <= 0 && m_hp > 1) {
				MonsterTurn();
			}
			String s2 = in.readLine();
			if (s2.length() <= 0) {
				continue;
			}
		}
		if (m_hp < 1) {
			System.out.println("----------------");
			System.out.println(monster + "をたおした！");
			System.out.println("----------------");
		} else if (myHP < 1) {
			System.out.println("----------------");
			System.out.println("ゲームオーバー");
			System.out.println("----------------");
		} else {
			System.out.println("----------------");
			System.out.println(player + "は逃げ出した");
			System.out.println("----------------");
		}
	}

	public int myturn(BufferedReader in) throws IOException {
		System.out.println("HP = " + myHP + "  " + "MP = " + myMP);
		System.out.println("コマンド");
		System.out.println("1.たたかう");
		System.out.println("2.ホイミ");
		System.out.println("3.にげる");
		String command = in.readLine();
		if (command.equals("1")) {
			attack();
			return 1;
		} else if (command.equals("2")) {
			recovery();
			return 2;
		} else if (command.equals("3")) {
			return 3;
		} else {
			return -1;
		}
	}

	public void attack() {
		Random r = new Random();
		int bump = r.nextInt(10) + 1;
		if (bump == 1) {
			System.out.println("かいしんのいちげき！");
			System.out.println(monster + "に100のこうげき");
			m_hp -= 100;
		} else {
			Random point = new Random();
			int power = point.nextInt(3) + 1;
			System.out.println(monster + "に" + power + "のこうげき");
			m_hp -= power;
		}
	}

	public void recovery() {
		System.out.println("ホイミをとなえた！");
		if (myMP < 2) {
			System.out.println("しかし、MPが足りない");
		} else if (myHP == 10) {
			System.out.println("しかし、今の" + player + "には必要なさそうだ");

		} else if (myHP == 9) {
			myHP += 1;
			myMP -= 2;
			System.out.println("HPが1かいふく");
			System.out.println("HP = " + myHP + "  " + "MP = " + myMP);
		} else if (myHP <= 8) {
			myHP += 2;
			myMP -= 2;
			System.out.println("HPが2かいふく");
			System.out.println("HP = " + myHP + "  " + "MP = " + myMP);
		}
	}

	public void MonsterTurn() {
		System.out.println("----------------");
		System.out.println(monster + "のこうげき");
		Random point = new Random();
		int power = point.nextInt(3) + 1;
		System.out.println(player + "に" + power + "のダメージ");
		myHP -= power;
		System.out.println("----------------");
	}

}
