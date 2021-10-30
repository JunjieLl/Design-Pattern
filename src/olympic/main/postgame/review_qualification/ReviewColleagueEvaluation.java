package olympic.main.postgame.review_qualification;

import java.util.Random;

/**
 * 评估小组，负责对调查结果进行评估和判断.
 */
public class ReviewColleagueEvaluation implements ReviewColleague{
    private ReviewMediator mediator;

    /**
     * @param mediator 为该组员注册的仲裁者.
     */
    @Override
    public void setMediator(ReviewMediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 评估小组的工作函数.
     * 为了演示效果的方便，会随机生成评估结果.
     */
    public void conductEvalution(){
        System.out.println("\nclassname: (ReviewColleagueEvaluation) method: (conductEvalution) action: (被仲裁者传唤，评估调查结果) ");
        System.out.println("【评估小组】正在对调查结果进行分析。");
        if(new Random().nextBoolean()){
            System.out.println("【评估小组】调查结果蹊跷。");
            mediator.colleagueChanged("RNG"); //Result not good.
        }else{
            System.out.println("【评估小组】调查结果很清晰。");
            mediator.colleagueChanged("RG"); //Result good.
        }
    }
}
