/**
 * CardUtil.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package com.example.app.util;

/**
 * カードに関する変換処理を提供するクラスです。
 * @author sf0537
 * @version 1.0.0
 */
public class CardUtil {

	/**
	 * 11はJ、12はQ、13はK、14はAに変換し、それ以外は数値を文字列として返します。
	 * @param card
	 * @return 表示用のカード名
	 */
	public static String getCardName(int card) {
		switch(card) {
			case 11:
				return "J";
			case 12:
				return "Q";
			case 13:
				return "K";
			case 14:
				return "A";
			default:
				return String.valueOf(card);
		}
	}

}
