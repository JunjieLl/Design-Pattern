package olympic.scene.TicketCheckinig;

class CheckingMachine{
    private TicketChecking strategy;

    /**
     * 设计模式：策略模式
     * 自动验票机
     * @return 策略对象
     */
    public TicketChecking getStrategy() {
        return strategy;
    }
    public void setStrategy(TicketChecking strategy) {
        this.strategy = strategy;
    }
    /**
     * 设计模式：策略模式
     * 策略方法
     */
    public void strategyMethod() {
        strategy.checkMethod();
    }
}