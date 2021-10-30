package olympic.scene.ProtectionFactory;

class Gloves extends Protection{
    @Override
    public void get(int num){
        factory.setGlove_num(num);
        System.out.println("classname: (Gloves) method: (get) action: (已获取手套"+num+"套)");
    }
}