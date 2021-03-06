package olympic.main.precompetitionsystem.urinetest;

/**
 * 尿检策略类
 * 涉及到策略模式
 */
public interface UrineTestStrategy {
    /**
     * 尿检策略方法，用于进行具体的尿检
     *
     * @param isPrint 控制是否输出classname语句
     * @return 尿检策略详情
     */
    String urineTest(boolean isPrint);
    
    /**
     * 检测该类是否为空对象
     *
     * @return 该类是否为空对象，如果是空对象返回true，反之返回false
     */
    boolean isNil();
}
