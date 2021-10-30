package olympic.main.game.pingponggame;

public class Mode {
    private Mode(){};

    private static Boolean showDetail = true;

    public static void setShowDetail(Boolean showDetail) {
        Mode.showDetail = showDetail;
    }

    public static Boolean getShowDetail() {
        return showDetail;
    }
}
