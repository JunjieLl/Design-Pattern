package olympic.scene.fireworkshow;

class LightShow extends Decorator {
    public LightShow(Show show){
        super(show);
    }
    private void lightShow(){
        System.out.println("class:(LightShow) methods: (lightShow) action:(运动场外新增加了灯光秀表演)");
//        System.out.println("运动场外新增加了灯光秀表演");
    }

    public void operation() {
        lightShow();
    }
}
