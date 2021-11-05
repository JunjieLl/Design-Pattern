package olympic.main.postgame.review_qualification;

import olympic.utils.PrintBlockFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 评估小组，负责对调查结果进行评估和判断.
 */
public class ReviewColleagueEvaluation implements ReviewColleague {
    /**
     * 该工作小组拥有的仲裁者
     */
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
    public void conductEvaluation() {
        List<String> evalInitPrintBlock = new ArrayList<>();
        evalInitPrintBlock.add("评估小组");
        evalInitPrintBlock.add("正在对调查结果进行分析。");
        PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
        printBlockFormat.printFormatLeftScreen(evalInitPrintBlock,true);
        if (new Random().nextBoolean()) {
            List<String> evalRNGPrintBlock = new ArrayList<>();
            evalRNGPrintBlock.add("评估小组");
            evalRNGPrintBlock.add("调查结果蹊跷。");
            printBlockFormat.printFormatLeftScreen(evalRNGPrintBlock,true);
            mediator.colleagueChanged("RNG"); //Result not good.
        } else {
            List<String> evalRGPrintBlock = new ArrayList<>();
            evalRGPrintBlock.add("评估小组");
            evalRGPrintBlock.add("调查结果很清晰。");
            printBlockFormat.printFormatLeftScreen(evalRGPrintBlock,true);
            mediator.colleagueChanged("RG"); //Result good.
        }
    }
}
