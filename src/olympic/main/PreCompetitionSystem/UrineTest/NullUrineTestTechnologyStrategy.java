package olympic.main.PreCompetitionSystem.UrineTest;

/**
 * 空尿检策略，当用户想要的尿检方式不存在时返回这个值
 * 使用了策略模式以及空对象模式
 */
public class NullUrineTestTechnologyStrategy implements UrineTestStrategy {
	/**
	 * 空尿检策略的具体尿检方式
	 */
	@Override
	public void urineTest() {
		System.out.println("不提供此类尿检方法");
	}
	
	/**
	 * 检测该尿检策略是否为空对象
	 *
	 * @return 因为该尿检策略确实为空对象，所以返回true
	 */
	@Override
	public boolean isNil() {
		return true;
	}
}
