package olympic.main.opening.protectionFactory;

/**
 * 口罩
 */
class Mask extends Protection {
    /**
     * 获取口罩个数方法
     * @param num 口罩个数
     */
    @Override
    public void get(int num) {
        factory.setMask_num(num);
        System.out.println("classname: (Mask) method: (get) action: (已获取口罩" + num + "个)");
    }
}
