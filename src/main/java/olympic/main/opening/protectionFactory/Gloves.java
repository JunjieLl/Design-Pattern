package olympic.main.opening.protectionFactory;

class Gloves extends Protection {
    /**
     * 获取手套个数方法
     * @param num 手套个数
     */
    @Override
    public void get(int num) {
        factory.setGlove_num(num);
        System.out.println("classname: (Gloves) method: (get) action: (已获取手套" + num + "套)");
    }
}