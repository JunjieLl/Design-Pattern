package olympic.main.PreCompetitionSystem.UrineTest;

/**
 * 第四代尿检技术
 * 使用了策略模式
 */
public class FourthGenerationUrineTestTechnologyStrategy implements UrineTestStrategy{
	/**
	 * 第四代尿检技术的具体尿检方式（着重检测生物类分子）
	 */
	@Override
	public void urineTest() {
		System.out.println("采用第4代尿检技术，着重检测生物分子类兴奋剂。");
	}
	
	/**
	 * 检测该尿检策略是否为空对象
	 * @return 因为该尿检策略不为空对象，所以返回false
	 */
	@Override
	public boolean isNil() {
		return false;
	}
}
