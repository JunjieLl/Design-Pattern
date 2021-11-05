package olympic.main.opening.protectionFactory;

class HandSanitizer extends Protection {
    /**
     * 获取洗手液个数方法
     * @param num
     */
    @Override
    public void get(int num) {
        factory.setHandSan_num(num);
        System.out.println("classname: (HandSanitizer) method: (get) action: (已获取洗手液" + num + "瓶)");
    }
}
