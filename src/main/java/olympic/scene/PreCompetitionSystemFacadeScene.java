package olympic.scene;

import olympic.main.precompetitionsystem.PreCompetitionSystemFacade;

/**
 * 赛前准备场景
 */
public class PreCompetitionSystemFacadeScene implements Scene {
	/**
	 * 比赛名
	 */
	private String gameName;
	
	/**
	 * 设置比赛名
	 *
	 * @param gameName 比赛名
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
	/**
	 * 赛前准备类的运行
	 */
	@Override
	public void play() {
		if (gameName == null) {
			System.out.println("请设置比赛名");
		} else {
			PreCompetitionSystemFacade.getInstance().preCompetitionSystemFacade(gameName);
		}
	}
}
