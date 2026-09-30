/**
 * FileUtil.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package com.example.app.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * High&Lowゲームのファイル操作を行うクラスです。
 * @author sf0537
 * @version 1.0.0
 */
public class FileUtil {

	/**
	 * (f)対戦結果をファイルに記録する<br>
	 * ファイルの所在地は【C:\AWS\2026\対戦結果.txt】です。
	 * @param cpu
	 * @param player
	 * @param result
	 */
	public static void writeResult(int cpu, int player, boolean predictionResult) {

		try {
			File file = new File("C:\\AWS\\2026\\対戦結果.txt");
			FileWriter fileWriter = new FileWriter(file, true);

			fileWriter.write("親の手札：" + CardUtil.getCardName(cpu) + "\n");
			fileWriter.write("子の手札：" + CardUtil.getCardName(player) + "\n");
			if (predictionResult) {
				fileWriter.write("あなたの勝ちでした。" + "\n");
			} else {
				fileWriter.write("あなたの負けでした。" + "\n");
			}
			fileWriter.write("\n");
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
