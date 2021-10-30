package ceremony.fireworkshow;


class AircraftShow extends Decorator {
    public AircraftShow(Show show){
        super(show);
    }
    private void aircraftShow(){
        System.out.println("class:(AircraftShow) methods: (aircraftShow) action:(运动场外新增加了无人机表演)");
//        System.out.println("运动场外新增加了无人机表演");
    }

    public void operation() {
        aircraftShow();
    }

}