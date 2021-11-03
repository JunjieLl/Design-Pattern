package olympic.Utils;

import java.nio.charset.StandardCharsets;
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

    private void printLineLeft(String str, int maxLength, String frontStr) {
        maxLength = maxLength - 8;
        String strOut = String.format("%-" + maxLength + "." + maxLength + "s\t", str);
        System.out.println(frontStr + "  " + strOut);

    }

    private void printLineMiddle(String str, String frontStr) {
        System.out.printf(frontStr + "  " + "\t%-" +
                getSpace(str) + "s" + "\n", str);
    }

    private void printTitle(String str, int maxLength, String frontStr) {
        int spaceLine = (maxLength - str.length() - 2 - 2) / 2;
        int surplus = maxLength - spaceLine - 2 - str.length() - 2;
        str = '[' + "\033[1;34m" + str + "\033[0m" + ']';

        System.out.println(frontStr + printLineRepeat(spaceLine, ' ')
                + str + printLineRepeat(surplus, ' '));
    }

    private int getSpace(String str) {
        double num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 0x4E00 && str.charAt(i) <= 0x29FA5) {
                num += 2;
            } else {
                num += 1;
            }
        }
        return (int) num;
    }

    public void printBlock(List<String> stringList, boolean isScreenMiddle) {
        int maxLength = 10;
        String frontStr = "";
        for (int i = 0; i < stringList.size(); i++) {
            if (i == 0) {
                maxLength = Math.max(maxLength, getSpace(stringList.get(i)) + 7);
            } else {
                maxLength = Math.max(maxLength, getSpace(stringList.get(i)) + 5);
            }
        }
        maxLength = maxLength + 4;

        if (isScreenMiddle) {
            frontStr = printLineRepeat((maxStringSize - maxLength) / 2, ' ');
        }
        String boxFrontStr = printLineRepeat((maxLength - getSpace(stringList.get(0))) / 2, ' ');
        System.out.println(frontStr + printLineRepeat(maxLength, c));
        for (int i = 0; i < stringList.size(); i++) {
            if (i == 0) {
                printTitle(stringList.get(i), maxLength, frontStr);
            } else {
                printLineLeft(stringList.get(i), maxLength, frontStr);
            }
        }
        System.out.println(frontStr + printLineRepeat(maxLength, c));
        System.out.println();
    }

    public void printFormatLeftScreen(List<String> stringList, boolean isShow) {
        if (isShow) {
            printBlock(stringList, false);
        }
    }

    public void printFormatMiddleScreen(List<String> stringList, boolean isShow) {
        if (isShow) {
            printBlock(stringList, true);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.print(i);
        }
        System.out.println();
        System.out.println("哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
        List<String> strings = new ArrayList<>();
        strings.add("title");
        strings.add("asdas");
        strings.add("dasdasfdasdass");
        strings.add("ascxas13");
        PrintBlockFormat printBlockFormat = new PrintBlockFormat();
        printBlockFormat.printFormatLeftScreen(strings, true);
        printBlockFormat.printFormatLeftScreen(strings, true);
        printBlockFormat.printFormatMiddleScreen(strings, true);
        printBlockFormat.printFormatMiddleScreen(strings, true);
        ;
    }

}
