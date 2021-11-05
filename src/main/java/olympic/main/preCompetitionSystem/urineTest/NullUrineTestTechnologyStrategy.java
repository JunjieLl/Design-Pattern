package olympic.main.preCompetitionSystem.urineTest;

/**
 * 空尿检策略，当用户想要的尿检方式不存在时返回这个值
 * 使用了策略模式以及空对象模式
 */
public class NullUrineTestTechnologyStrategy implements UrineTestStrategy {
    /**
     * 空尿检策略的具体尿检方式
     *
     * @param isPrint 控制是否输出classname语句
     * @return 尿检策略详情
     */
    @Override
    public String urineTest(boolean isPrint) {
        if(isPrint) {
            System.out.println("classname: (NullUrineTestTechnologyStrategy) method: (urineTest) " + "action: (当用户使用的尿检方法不存在时使用此方式，使用了Strategy模式以及Null Object模式) ");
        }
        return "不提供此类尿检方法";
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
