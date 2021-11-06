package olympic.main.person.athlete;

/**
 * 回调
 */
public interface CallBack {
    /**
     * 回调
     * @param oppoent 对手
     * @return 是否赢了
     */
    Boolean call(CallBack oppoent);
}
