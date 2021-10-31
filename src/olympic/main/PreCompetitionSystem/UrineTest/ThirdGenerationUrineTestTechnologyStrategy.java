package olympic.main.PreCompetitionSystem.UrineTest;

/**
 * 第三代尿检技术
 * 使用了策略模式
 */
public class ThirdGenerationUrineTestTechnologyStrategy implements UrineTestStrategy{
	/**
	 * 第三代尿检技术的具体尿检方式（着重检测化学兴奋剂）
	 */
	@Override
	public void urineTest() {
		System.out.println("采用第3代尿检技术，着重检测化学类兴奋剂。");
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
