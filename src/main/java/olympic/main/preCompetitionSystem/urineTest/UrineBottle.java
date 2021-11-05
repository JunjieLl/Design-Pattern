package olympic.main.preCompetitionSystem.urineTest;

/**
 * 尿检结束后获取的尿样瓶
 */
public class UrineBottle {
    /**
     * 尿样瓶的名称（只能为‘A’或者‘B’）
     */
    private final char urineBottles;
    
    /**
     * 获取尿样瓶的名称
     *
     * @return 尿样瓶的名称
     */
    public char getUrineBottles() {
        return urineBottles;
    }
    
    /**
     * 该尿样是否为阳性
     */
    private Boolean isPositive;
    
    /**
     * 尿样瓶的构造函数
     *
     * @param c 尿样瓶的名称
     * @throws Exception 如果输入即不为A也不为B，则抛出异常提示用户输入错误
     */
    public UrineBottle(char c) throws Exception {
        double num = (Math.random() * 100);
        isPositive = false;
        if (c == 'A') {
            urineBottles = c;
            if (num < 2) {
                isPositive = true;
            }
        } else
            if (c == 'B') {
                urineBottles = c;
                if (num < 5) {
                    isPositive = true;
                }
            } else {
                throw new Exception("尿样只能装入A瓶或B瓶");
            }
    }
    
    /**
     * 获取该尿样瓶中的尿样是否为阳性
     *
     * @return 尿样瓶中的尿样是否为阳性
     */
    public Boolean getPositive() {
        return isPositive;
    }
    
    /**
     * 尿检策略，默认值为null
     */
    private UrineTestStrategy urineTestStrategy = null;
    
    /**
     * 获取尿检策略
     *
     * @return 尿检策略
     */
    public UrineTestStrategy getUrineTestStrategy() {
        return urineTestStrategy;
    }
    
    /**
     * 为尿样瓶设置尿检策略
     *
     * @param number 该数字指定了尿检策略
     * @param isPrint 控制是否输出classname语句
     * @return 该尿样瓶的尿检策略详情介绍
     */
    public String setUrineTestStrategy(int number,boolean isPrint) {
        UrineTestStrategyFactory urineTestStrategyFactory = UrineTestStrategyFactory.getInstance(isPrint);
        urineTestStrategy = urineTestStrategyFactory.getUrineTestStrategy(number);
        return urineTestStrategy.urineTest(isPrint);
    }
    

}
