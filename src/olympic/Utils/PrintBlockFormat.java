package olympic.Utils;

import java.util.List;

public class PrintBlockFormat {
	private PrintBlockFormat(){
	
	}
	
	private static final PrintBlockFormat PRINT_BLOCK_FORMAT = new PrintBlockFormat();
	
	public static PrintBlockFormat getPrintFormat() {
		return PRINT_BLOCK_FORMAT;
	}
	
	public void printFormatLeftScreen(List<String> stringList, boolean isBoxMiddle){
		for (String s : stringList) {
			System.out.println(s);
		}
	}
	
	public void printFormatMiddleScreen(List<String> stringList, boolean isBoxMiddle){
		for (String s : stringList) {
			System.out.println(s);
		}
	}
	
	
}
