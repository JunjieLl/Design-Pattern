package olympic.Utils;

import java.util.ArrayList;
import java.util.List;

public class PrintBlockFormat {
	private final int maxStringSize = 136;
	private final Character c = '=';
	
	private PrintBlockFormat() {
	}
	
	private String printLineRepeat(int num, Character cc) {
		String str = "";
		for (int i = 0; i < num; i++) {
			str = str + cc.toString();
		}
		return str;
	}
	
	private static final PrintBlockFormat PRINT_BLOCK_FORMAT = new PrintBlockFormat();
	
	public static PrintBlockFormat getPrintFormat() {
		return PRINT_BLOCK_FORMAT;
	}
	
	private String printLineLeft(String str, int maxLength) {
		int spaceLine = maxLength - str.length() - 3;
		return c.toString() + ' ' + str + printLineRepeat(spaceLine, ' ') + c.toString();
	}
	
	private String printLineMiddle(String str, int maxLength) {
		int spaceLine = (maxLength - str.length() - 2) / 2;
		int surplus = maxLength - spaceLine - 2 - str.length();
		return c.toString() + printLineRepeat(spaceLine, ' ') + str + printLineRepeat(surplus, ' ') + c.toString();
	}
	
	private String printTitle(String str, int maxLength) {
		int spaceLine = (maxLength - str.length() - 2 - 2) / 2;
		int surplus = maxLength - spaceLine - 2 - str.length() - 2;
		str = '[' + "\033[1;34m" + str + "\033[0m" + ']';
		return c.toString() + printLineRepeat(spaceLine, ' ') + str + printLineRepeat(surplus, ' ') + c.toString();
	}
	
	public void printBlock(List<String> stringList, boolean isBoxMiddle, boolean isScreenMiddle) {
		int maxLength = 10;
		String frontStr = "";
		for (int i = 0; i < stringList.size(); i++) {
			if (i == 0) {
				maxLength = Math.max(maxLength, stringList.get(i).length() + 7);
			} else {
				maxLength = Math.max(maxLength, stringList.get(i).length() + 5);
			}
		}
		
		if (isScreenMiddle) {
			frontStr = printLineRepeat((maxStringSize - maxLength) / 2, ' ');
		}
		
		System.out.println(frontStr + printLineRepeat(maxLength, c));
		for (int i = 0; i < stringList.size(); i++) {
			if (i == 0) {
				System.out.println(frontStr + printTitle(stringList.get(i), maxLength));
			}
			else if (isBoxMiddle) {
					System.out.println(frontStr + printLineMiddle(stringList.get(i), maxLength));
			}
			else {
					System.out.println(frontStr + printLineLeft(stringList.get(i), maxLength));
			}
		}
		System.out.println(frontStr + printLineRepeat(maxLength, c));
		System.out.println();
	}
	
	public void printFormatLeftScreen(List<String> stringList, boolean isBoxMiddle, boolean isShow) {
		if (isShow) {
			printBlock(stringList, isBoxMiddle, false);
		}
	}
	
	public void printFormatMiddleScreen(List<String> stringList, boolean isBoxMiddle, boolean isShow) {
		if (isShow) {
			printBlock(stringList, isBoxMiddle, true);
		}
	}
	
	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		strings.add("title");
		strings.add("asdas");
		strings.add("dasdasfdasdass");
		strings.add("ascxas13");
		PrintBlockFormat printBlockFormat = new PrintBlockFormat();
		printBlockFormat.printFormatLeftScreen(strings, true, true);
		printBlockFormat.printFormatLeftScreen(strings, false, true);
		printBlockFormat.printFormatMiddleScreen(strings, true, true);
		printBlockFormat.printFormatMiddleScreen(strings, false, true);
		;
	}
	
}
