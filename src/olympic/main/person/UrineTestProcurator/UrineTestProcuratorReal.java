package olympic.main.person.UrineTestProcurator;

import java.util.ArrayList;
import java.util.Arrays;

public class UrineTestProcuratorReal extends UrineTestProcurator {
	private String grade;
	private final ArrayList<String> gradeList = new ArrayList<>(Arrays.asList("初级", "中级", "副高级", "高级"));
	
	protected UrineTestProcuratorReal(String name, String nation) {
		super(name, nation);
		int num = (int) (Math.random() * 4);
		grade = gradeList.get(num);
	}
	
	@Override
	public void check() {
		System.out.println("检察员名为" + name + "，" + "是一位" + grade + "的检察员。");
	}
}
