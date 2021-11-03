package olympic.main.PreCompetitionSystem.UrineTest;

import java.util.HashMap;

/**
 * 生成尿检策略类的尿检策略工厂
 * 使用了享元模式，工厂模式，单例模式
 */
public class UrineTestStrategyFactory {
	/**
	 * 策略模式的对象池，用于存储策略、共享对象
	 */
	private final HashMap<Integer, UrineTestStrategy> pool = new HashMap<>();
	
	/**
	 * 空策略对象，当用户想要的尿检策略不存在时会返回该值
	 */
	private final UrineTestStrategy nullStrategy = new NullUrineTestTechnologyStrategy();
	
	/**
	 * 尿检策略工厂的单例，用于保证所有类共享一个尿检策略工厂
	 */
	private static final UrineTestStrategyFactory singleton = new UrineTestStrategyFactory();
	
	/**
	 * 尿检策略工厂的私有构造函数，是单例模式的一部分
	 */
	private UrineTestStrategyFactory() {
	
	}
	
	/**
	 * 获取尿检策略工厂单例
	 *
	 * @return 尿检策略工厂单例
	 */
	public static UrineTestStrategyFactory getInstance() {
		return singleton;
	}
	
	/**
	 * 根据输入的数字获取具体的尿检策略，如果不存在该尿检策略则返回空尿检策略
	 *
	 * @param number 需要第几代尿检策略
	 * @return 所需要的尿检策略
	 */
	public synchronized UrineTestStrategy getUrineTestStrategy(int number) {
		if (number != 3 && number != 4) {
			return nullStrategy;
		}
		UrineTestStrategy urineTestStrategy = pool.get(number);
		if (urineTestStrategy == null) {
			if (number == 3) {
				urineTestStrategy = new ThirdGenerationUrineTestTechnologyStrategy();
			} else {
				urineTestStrategy = new FourthGenerationUrineTestTechnologyStrategy();
			}
			pool.put(number, urineTestStrategy);
		}
		return urineTestStrategy;
	}
	
}
