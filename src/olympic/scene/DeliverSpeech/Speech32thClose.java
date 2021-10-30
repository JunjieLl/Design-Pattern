package olympic.scene.DeliverSpeech;

/**
 * 子类改写，第32届奥运会闭幕式
 */

class Speech32thClose extends DeliverSpeech {   //具体子类
    @Override
    String time() {
        return "32";
    }

    @Override
    String OOCP() {
        return "武藤敏郎";
    }

    @Override
    String IOCP() {
        return "托马斯·巴赫";
    }

    @Override
    String HP() {
        return "岸田文雄";
    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    String athleteRepre() {
        return "苏炳添";
    }

    @Override
    String refereeRepre() {
        return "Amazon";
    }
}
