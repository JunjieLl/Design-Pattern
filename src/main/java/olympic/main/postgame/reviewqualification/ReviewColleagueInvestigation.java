package olympic.main.postgame.reviewqualification;

import olympic.utils.PrintBlockFormat;

import java.util.ArrayList;
import java.util.List;

/**
 * 调查小组，负责根据证据进行调查.
 */
public class ReviewColleagueInvestigation implements ReviewColleague {

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
     * 调查小组的工作函数.
     */
    public void conductInvestigation() {
        System.out.println("\nclassname: (ReviewColleagueInvestigation) method: (conductInvestigation) action: (被仲裁者传唤，对证据展开调查) ");
        System.out.println("【调查小组】调查小组根据证据已经进行了调查。");

        List<String> investigatePrintBlock = new ArrayList<>();
        investigatePrintBlock.add("调查小组");
        investigatePrintBlock.add("调查小组根据证据已经进行了详细的调查。");

        PrintBlockFormat printBlockFormat = PrintBlockFormat.getPrintFormat();
        printBlockFormat.printFormatLeftScreen(investigatePrintBlock,true);
        mediator.colleagueChanged("IC"); //Investigation conducted
    }
}
