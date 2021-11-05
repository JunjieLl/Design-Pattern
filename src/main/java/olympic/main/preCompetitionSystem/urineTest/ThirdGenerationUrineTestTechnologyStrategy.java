package olympic.main.preCompetitionSystem.urineTest;

/**
 * 第三代尿检技术
 * 使用了策略模式
 */
public class ThirdGenerationUrineTestTechnologyStrategy implements UrineTestStrategy {
    /**
     * 第三代尿检技术的具体尿检方式（着重检测化学兴奋剂）
     *
     * @param isPrint 控制是否输出classname语句
     * @return 尿检策略详情
     */
    @Override
    public String urineTest(boolean isPrint) {
        if(isPrint){
            System.out.println("classname: (ThirdGenerationUrineTestTechnologyStrategy) method: (urineTest) " +
                    "action: (使用第三代尿检技术对运动员进行尿检，使用了Strategy模式以及Null Object模式) ");
        }
        return "采用第3代尿检技术，着重检测化学类兴奋剂。";
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
