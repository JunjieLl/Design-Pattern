package olympic.main.opening.protectionfactory;

/**
 * 测温枪
 */
class TemperatureGun extends Protection {
    /**
     * 获取测温枪个数
     * @param num 测温枪个数
     */
    @Override
    public void get(int num) {
        factory.setTemper_num(num);
        System.out.println("classname: (TemperatureGun) method: (get) action: (已获取测温枪" + num + "个)");
    }
}