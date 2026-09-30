/**
 * HighLowGame.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package com.example.app.service;

import java.util.Random;
import java.util.Scanner;

/**
 * High&Lowゲームの処理を行うクラスです。
 * @author sf0537
 * @version 1.0.0
 */
public class HighLowGame {

	private static Random random = new Random();

	/**
	 * 2～14の範囲からランダムにカードの値を生成します。
	 * @return 生成されたカードの値
	 */
	public static int createCard() {
		int card = random.nextInt(13) + 2;
		return card;
	}

	/**
	 * 子の手札をランダムに生成します。<br>
	 * 親の手札と同じ値が生成された場合は再度生成します。
	 * @param cpu 親の手札
	 * @return 親の手札とは異なる子の手札
	 */
	public static int createPlayerCard(int cpu) {
		int player;

		do {
			player = createCard();
		} while (player == cpu);

		return player;
	}

	/**
	 * 大きい、小さい、等しいのいずれかの入力を促し、値を受取る<br>
	 * 入力チェックを行う(1~3の値以外は受け付けない)
	 * @param scanner
	 * @return 1~3の値
	 */
	public static int selectPrediction(Scanner scanner) {
		int playerChoice;

		// (c)大きい、小さい、等しいのいずれかの入力を促し、値を受取る
		do {
			System.out.println("""
					------------
					1：親より大きい
					2：親と等しい
					3：親より小さい
					------------
					""");
			System.out.print("選択してください：");
			playerChoice = scanner.nextInt();
		}
		// (d)入力チェックを行う
		while (playerChoice < 1 || playerChoice > 3);

		return playerChoice;

	}

	/**
	 * 親の手札と子の手札を比較し、大小関係を判定します。
	 * @param player
	 * @param cpu
	 * @return 子の手札が大きい場合は1、等しい場合は2、小さい場合は3
	 */
	public static int result(int player, int cpu) {
		int result;
		if (player > cpu) {
			result = 1;
		} else if (player == cpu) {
			result = 2;
		} else {
			result = 3;
		}
		return result;
	}

}
