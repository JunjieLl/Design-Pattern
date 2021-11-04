package olympic.main.PreCompetitionSystem.UrineTest;

/**
 * 第四代尿检技术
 * 使用了策略模式
 */
public class FourthGenerationUrineTestTechnologyStrategy implements UrineTestStrategy {
	/**
	 * 第四代尿检技术的具体尿检方式（着重检测生物类分子）
	 *
	 * @param isPrint 控制是否输出classname语句
	 * @return 尿检策略详情
	 */
	@Override
	public String urineTest(boolean isPrint) {
		if(isPrint) {
			System.out.println("classname: (FourthGenerationUrineTestTechnologyStrategy) method: (urineTest) " + "action: (使用第四代尿检技术对运动员进行尿检，使用了Strategy模式) ");
		}
		return "采用第4代尿检技术，着重检测生物分子类兴奋剂。";
	}
	
	/**
	 * 检测该尿检策略是否为空对象
	 *
	 * @return 因为该尿检策略不为空对象，所以返回false
	 */
	@Override
	public boolean isNil() {
		return false;
	}
}
