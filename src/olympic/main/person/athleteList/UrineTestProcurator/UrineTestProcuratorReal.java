package olympic.main.person.athleteList.UrineTestProcurator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 尿检检察员真实类，在这里做真正的尿检检察员检查操作
 */
public class UrineTestProcuratorReal extends UrineTestProcurator {
	/**
	 * 尿检检察员等级
	 */
	private final String grade;
	
	/**
	 * 尿检检察员真实类的构造函数
	 *
	 * @param name   尿检检察员的姓名
	 * @param nation 尿检检察员的国籍
	 */
	protected UrineTestProcuratorReal(String name, String nation) {
		super(name, nation);
		int num = (int) (Math.random() * 4);
		/*
		  尿检检察员等级必须为gradeList中的一个
		 */
		ArrayList<String> gradeList = new ArrayList<>(Arrays.asList("初级", "中级", "副高级", "高级"));
		grade = gradeList.get(num);
	}
	
	/**
	 * 尿检检察员真实类的检察院动员函数
	 */
	@Override
	public void check() {
		System.out.println("检察员名为" + name + "，" + "是一位" + grade + "的检察员。");
	}
}
