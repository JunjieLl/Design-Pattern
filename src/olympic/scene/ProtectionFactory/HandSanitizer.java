package olympic.scene.ProtectionFactory;

class HandSanitizer extends Protection{

    @Override
    public void get(int num){
        factory.setHandSan_num(num);
        System.out.println("classname: (HandSanitizer) method: (get) action: (已获取洗手液"+num+"瓶)");
    }
}
