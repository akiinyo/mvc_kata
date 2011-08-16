package akiinyo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Battle {
	private String player = "����";
	private int myHP = 10;
	private int myMP = 6;
	private String monster = "�X���C��";
	private int monsterHP = 8;

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
		System.out.println(monster + "�������ꂽ!");
		System.out.println("----------------");
		for (;;) {
			if (myHP < 1 || monsterHP < 1) {
				break;
			}
			myturn(in);
			String s1 = in.readLine();
			if (s1.length() <= 0 && monsterHP > 1) {
				MonsterTurn();
			}
			String s2 = in.readLine();
			if (s2.length() <= 0) {
				continue;
			}
		}
		if (monsterHP < 1) {
			System.out.println("----------------");
			System.out.println(monster + "�����������I");
			System.out.println("----------------");
		} else if (myHP < 1) {
			System.out.println("----------------");
			System.out.println("�Q�[���I�[�o�[");
			System.out.println("----------------");
		}
	}

	public void myturn(BufferedReader in) throws IOException {
		System.out.println("HP = " + myHP + "  " + "MP = " + myMP);
		System.out.println("�R�}���h");
		System.out.println("1.��������");
		System.out.println("2.�z�C�~");
		// System.out.println("3.�ɂ���");
		String command = in.readLine();
		if (command.equals("1")) {
			attack();
		} else if (command.equals("2")) {
			recovery();
			// } else if (command.equals("3")) {
			// escape();
		}
	}

	public void attack() {
		Random point = new Random();
		int power = point.nextInt(3) + 1;
		System.out.println(monster + "��" + power + "�̂�������");
		monsterHP -= power;
	}

	public void recovery() {
		System.out.println("�z�C�~���ƂȂ����I");
		if (myMP < 2) {
			System.out.println("�������AMP������Ȃ�");
		} else if (myHP == 10) {
			System.out.println("�������A����" + player + "�ɂ͕K�v�Ȃ�������");
		} else if (myHP == 9) {
			myHP += 1;
			myMP -= 2;
			System.out.println("HP��1�����ӂ�");
			System.out.println("HP = " + myHP + "  " + "MP = " + myMP);
		} else if (myHP <= 8) {
			myHP += 2;
			myMP -= 2;
			System.out.println("HP��2�����ӂ�");
			System.out.println("HP = " + myHP + "  " + "MP = " + myMP);
		}
	}

	public void MonsterTurn() {
		System.out.println("----------------");
		System.out.println(monster + "�̂�������");
		Random point = new Random();
		int power = point.nextInt(3) + 1;
		System.out.println(player + "��" + power + "�̃_���[�W");
		myHP -= power;
		System.out.println("----------------");
	}

	// public void escape() {
	// System.out.println("----------------");
	// System.out.println(player + "�͓����o����");
	// System.out.println("----------------");
	// }

}
