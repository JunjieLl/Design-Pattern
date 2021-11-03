package olympic.main.opening.protectionFactory;

class TemperatureGun extends Protection {
    @Override
    public void get(int num) {
        factory.setTemper_num(num);
        System.out.println("classname: (TemperatureGun) method: (get) action: (已获取测温枪" + num + "个)");
    }
}