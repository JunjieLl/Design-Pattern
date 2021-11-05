package olympic.main.opening.protectionFactory;

/**
 * 洗手液
 */
class HandSanitizer extends Protection {
    /**
     * 获取洗手液瓶数方法
     * @param num 洗手液瓶数
     */
    @Override
    public void get(int num) {
        factory.setHandSan_num(num);
        System.out.println("classname: (HandSanitizer) method: (get) action: (已获取洗手液" + num + "瓶)");
    }
}
