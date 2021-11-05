package olympic.main.game.diving;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import olympic.Utils.PrintBlockFormat;
import olympic.main.person.athlete.Athlete;
import olympic.main.director.Mode;

import java.util.*;

/**
 * 包含跳水比赛运动员的对象池
 */
public class AthletePool {
    /**
     * 包含跳水运动员的列表
     */
    private final LinkedList<Athlete> pool;

    /**
     * 跳水比赛选择的策略
     */
    private final Strategy strategy;

    /**
     * 选择是否要展示细节
     */
    private boolean viewDetail = false;

    /**
     * 保存每位运动员正在进行轮次的分数
     */
    private final Map<Athlete, Double> allScore = new HashMap<>();

    /**
     * 将分数与运动员的映射关系按照分数进行排序后保存
     */
    private List<Map.Entry<Athlete, Double>> list;

    public AthletePool(Strategy strategy, List<Athlete> athleteList) {
        System.out.println("classname: (AthletePool) method: (AthletePool) action: (对象池模式下获取参加比赛的运动员) ");
        this.pool = new LinkedList<>(athleteList);
        for (Athlete athlete : pool) {
            this.allScore.put(athlete, 0.0);
        }
        this.strategy = strategy;
    }

    /**
     * 获取对象池中的运动员/组合数量
     *
     * @return 对象池中的运动员/组合数量
     */
    public int getSize() {
        return this.pool.size();
    }

    /**
     * 在对象池中加入运动员
     *
     * @param object 要添加的运动员
     */
    public void add(Athlete object) {
        this.pool.add(object);
    }

    /**
     * 更新一位运动员的分数
     *
     * @param object 要修改分数的运动员
     * @param score  要增加的分数
     */
    public void addScore(Athlete object, double score) {
        this.allScore.put(object, this.allScore.get(object) + score);
    }

    /**
     * 运动员出场
     *
     * @return Athlete 当前即将出场的运动员
     */
    public Athlete appear() {
        return this.pool.getFirst();
    }

    /**
     * 运动员退场
     */
    public void disappear() {
        Athlete object = this.pool.poll();
        this.pool.add(object);
    }

    /**
     * 获取当前比赛的评分策略
     *
     * @return Strategy 当前评分策略
     */
    public Strategy getStrategy() {
        return this.strategy;
    }

    /**
     * 获取本场比赛结果
     *
     * @param game 本次比赛名字
     */
    public void getResult(String game) {
        list = new ArrayList<Map.Entry<Athlete, Double>>(allScore.entrySet());
        list.sort(new Comparator<Entry<Athlete, Double>>() {
            //降序排序
            @Override
            public int compare(Entry<Athlete, Double> o1, Entry<Athlete, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        List<String> ceremonyInitPrintBlock = new ArrayList<>();
        ceremonyInitPrintBlock.add(game + "积分榜");
        ceremonyInitPrintBlock.add(String.format("排名\t\t%-16s\t%-10s", "姓名", "分数"));
        for (int i = 0; i < list.size(); i++) {
            ceremonyInitPrintBlock.add(String.format("第%d名\t\t%-16s\t%.3f", i + 1, list.get(i).getKey().getName(), list.get(i).getValue()));
            list.get(i).getKey().setRank(game, i + 1);
        }
        PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
        printBlockFormat.printFormatLeftScreen(ceremonyInitPrintBlock,Mode.getShowDetail());
    }

    /**
     * 淘汰运动员
     *
     * @param num 淘汰后剩余运动员数量
     */
    public void eliminate(int num) {
        pool.clear();
        allScore.clear();
        while (num > 0) {
            pool.add(list.get(num - 1).getKey());
            allScore.put(list.get(num - 1).getKey(), 0.0);
            num--;
        }
        list.clear();
    }

    /**
     * 设置是否展示细节
     */
    public void showDetail() {
        if (Mode.getNeedDetail()) {
            System.out.println("【跳水Scene】请选择是否展示细节，输入true展示细节，输入其他不展示:");
            Scanner input = new Scanner(System.in);
            if (input.next().equals("true")) {
                Mode.setShowDetail(true);
            }
        }
    }

    /**
     * 获取是否展示细节指令
     *
     * @return viewDetail 是否展示细节指令
     */
    public boolean getDetail() {
        return Mode.getShowDetail();
    }

    /**
     * 获取要颁奖的人
     *
     * @param num 参加颁奖的人数
     * @return winner 参加颁奖的运动员的列表
     */
    public List<Athlete> gotoCeremony(int num) {
        List<Athlete> winner = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            winner.add(list.get(i).getKey());
        }
        return winner;
    }
}
