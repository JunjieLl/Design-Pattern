package olympic.main.postgame.review_qualification;

import olympic.utils.PrintBlockFormat;

import java.util.ArrayList;
import java.util.List;

/**
 * 取证小组，负责收集证据.
 */
public class ReviewColleagueEvidence implements ReviewColleague {

    /**
     * 该工作小组拥有的仲裁者
     */
    private ReviewMediator mediator;

    /**
     * @param mediator 注册的仲裁者.
     */
    @Override
    public void setMediator(ReviewMediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 取证小组的工作函数.
     */
    public void collectEvidence() {
        System.out.println("\nclassname: (ReviewColleagueEvidence) method: (collectEvidence) action: (被仲裁者传唤，收集证据) ");


        List<String> evidencePrintBlock = new ArrayList<>();
        evidencePrintBlock.add("取证小组");
        evidencePrintBlock.add("已经接到指令，正在取证。");
        evidencePrintBlock.add("已经收集证据。");

        PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
        printBlockFormat.printFormatLeftScreen(evidencePrintBlock,true);
        mediator.colleagueChanged("EC"); //Evidence collected
    }

}
