package olympic.main.opening.protectionFactory;

class Mask extends Protection {

    @Override
    public void get(int num) {
        factory.setMask_num(num);
        System.out.println("classname: (Mask) method: (get) action: (已获取口罩" + num + "个)");
    }
}
