/**
 * Main.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package com.example.app.controller;

import java.util.Scanner;

import com.example.app.service.HighLowGame;
import com.example.app.util.CardUtil;
import com.example.app.util.FileUtil;

/**
 * High&Lowゲームを実行するメインクラスです。
 * @author sf0537
 * @version 1.0.0
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("High&Lowゲームを始めます！");

		boolean playAgain = true;

		while (playAgain) {
			// (a)親の手札を決定
			int cpu = HighLowGame.createCard();

			boolean retry = true;

			while (retry) {
				// (b)親の値を表示する
				System.out.println(
						"親の手札は「" + CardUtil.getCardName(cpu) + "」です。");

				// (c)大きい、小さい、等しいのいずれかの入力を促し、値を受取る
				// (d)入力チェックを行う
				int playerChoice = HighLowGame.selectPrediction(scanner);

				/*
				 * (e)子の手札を決定し、Hi-Loを実行する
				 * 但し、親の手札と同じ値は子の手札として選択させない
				 * 大小は以下の順 ↓
				 * (小)2,3,4...10,J,Q,K,A(大)
				 */
				int player = HighLowGame.createPlayerCard(cpu);

				int result = HighLowGame.result(player, cpu);

				// (f)対戦結果をファイルに記録する
				boolean predictionResult = playerChoice == result;
				FileUtil.writeResult(cpu, player, predictionResult);

				/*
				 * (g)勝敗を表示する
				 * (h)子が勝利した場合、子の手札を親の手札として表示し、(b)以降を繰り返す
				 * 親が勝利した場合、再度(a)から始める
				 */
				if (predictionResult) {
					System.out.println("あなたの勝ちです");
					cpu = player;
				} else {
					System.out.println("あなたの負けです");
					retry = false;
				}
			}
		}
		scanner.close();
	}
}
