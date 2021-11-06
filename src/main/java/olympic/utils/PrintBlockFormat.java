package olympic.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义了输出规范的类
 */
public class PrintBlockFormat {
	
	/**
	 * 私有构造函数
	 */
	private PrintBlockFormat() {
	}
	
	/**
	 * 输入字符串列表的缓存
	 */
	List<String> strings = new ArrayList<>();
	
	/**
	 * 把新的字符串加入该类的字符串列表
	 *
	 * @param str 新加入的字符串
	 */
	public void addString(String str) {
		strings.add(str);
	}
	
	/**
	 * 把本类的字符串缓存列表输出并清空
	 *
	 * @param isShow 是否要把该列表展示出来
	 */
	public void printFormatLeftScreen(boolean isShow) {
		if (isShow) {
			printBlock(strings, false);
		}
		strings.clear();
	}
	
	/**
	 * 把字符cc重复num遍
	 *
	 * @param num 被重复的字数
	 * @param cc  被重复的字符
	 * @return 结果字符串
	 */
	private String printLineRepeat(int num, Character cc) {
		return cc.toString().repeat(Math.max(0, num));
	}
	
	/**
	 * 生成本类的单例
	 */
	private static final PrintBlockFormat PRINT_BLOCK_FORMAT = new PrintBlockFormat();
	
	/**
	 * 获取本类的单例
	 *
	 * @return 本来的单例
	 */
	public static PrintBlockFormat getPrintFormat() {
		return PRINT_BLOCK_FORMAT;
	}
	
	/**
	 * 字符串靠左输出
	 *
	 * @param str       被输出的字符串
	 * @param maxLength 被输出字符串的最大长度
	 * @param frontStr  被输出字符串的前置字符串
	 */
	private void printLineLeft(String str, int maxLength, String frontStr) {
		maxLength = maxLength - 8;
		String strOut = String.format("%-" + maxLength + "." + maxLength + "s\t", str);
		System.out.println(frontStr + "  " + strOut);
		
	}
	
	/**
	 * 输出标题
	 *
	 * @param str       被输出的字符串，即标题
	 * @param maxLength 被输出字符串的最大长度
	 * @param frontStr  被输出字符串的前置字符串
	 */
	private void printTitle(String str, int maxLength, String frontStr) {
		int spaceLine = (maxLength - str.length() - 2 - 2) / 2;
		int surplus = maxLength - spaceLine - 2 - str.length() - 2;
		str = '[' + "\033[1;34m" + str + "\033[0m" + ']';
		
		System.out.println(frontStr + printLineRepeat(spaceLine, ' ') + str + printLineRepeat(surplus, ' '));
	}
	
	/**
	 * 获取字符串占用的空格数
	 *
	 * @param str 字符串
	 * @return 占用的空格数
	 */
	private int getSpace(String str) {
		double num = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 0x4E00) {
				num += 1.7;
			} else {
				num += 1;
			}
		}
		return (int) num;
	}
	
	/**
	 * 打印一个字符串块
	 *
	 * @param stringList     需要被打印的字符串构成的列表
	 * @param isScreenMiddle 是否要打印到屏幕的中间
	 */
	public void printBlock(List<String> stringList, boolean isScreenMiddle) {
		int maxLength = 10;
		String frontStr = "";
		for (int i = 0; i < stringList.size(); i++) {
			if (i == 0) {
				maxLength = Math.max(maxLength + 8, getSpace(stringList.get(i)) + 7);
			} else {
				maxLength = Math.max(maxLength + 8, getSpace(stringList.get(i)) + 5);
			}
		}
		maxLength = maxLength + 4;
		/*
		 * 开头，结尾的最多输出多少个=（即变量c）符号
		 */
		int maxStringSize = 134;
		maxLength = Math.min(maxLength, maxStringSize);
		
		if (isScreenMiddle) {
			frontStr = printLineRepeat((maxStringSize - maxLength) / 2, ' ');
		}
		/*
		 * 组成开头，结尾的字符
		 */
		Character c = '=';
		System.out.println(frontStr + printLineRepeat(maxLength + 8, c));
		for (int i = 0; i < stringList.size(); i++) {
			if (i == 0) {
				printTitle(stringList.get(i), maxLength, frontStr);
			} else {
				printLineLeft(stringList.get(i), maxLength, frontStr);
			}
		}
		System.out.println(frontStr + printLineRepeat(maxLength + 8, c));
		System.out.println();
	}
	
	/**
	 * 打印字符串列表到屏幕左端
	 *
	 * @param stringList 需要被打印的字符串构成的列表
	 * @param isShow     是否要把该列表展示出来
	 */
	public void printFormatLeftScreen(List<String> stringList, boolean isShow) {
		if (isShow) {
			printBlock(stringList, false);
		}
	}
	
	/**
	 * 打印字符串列表到屏幕中间
	 *
	 * @param stringList 需要被打印的字符串构成的列表
	 * @param isShow     是否要把该列表展示出来
	 */
	public void printFormatMiddleScreen(List<String> stringList, boolean isShow) {
		if (isShow) {
			printBlock(stringList, true);
		}
	}
	
}
