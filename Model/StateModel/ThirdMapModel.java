package Model.StateModel;

import javax.swing.*;

public class ThirdMapModel extends MapModel {
	private ImageIcon newImageIcon;
	private ImageIcon newImageIconHeart;
	private int heartXLocation = 412, heartYLocation = 32;
	private JPanel thirdMapPanel;
	private JPanel childThirdMapPanel;
	private boolean addHeart = true;
	private boolean removeHeart = false;
	private JLabel heart;
	private JLabel mapLabel;
	private Timer timer3;
	private int x[] = new int[getN()];
	private int y[] = new int[getN()];
	private JLabel timerJLabel;
	private Timer timerThirdMap;
	private int secondsLeft;
	private int thirdMapScoreTake;

	private JPanel cardPanel;

	public ThirdMapModel() {

		thirdMapPanel = new JPanel();

		childThirdMapPanel = new JPanel();
		heart = new JLabel();
		mapLabel = new JLabel("LỚP 12");
		timer3 = new Timer(1000, null);
		timerJLabel = new JLabel();
		timerThirdMap = new Timer(2000, null);
	}

	// getter and setter
	public ImageIcon getNewImageIcon() {
		return newImageIcon;
	}

	public void setNewImageIcon(ImageIcon newImageIcon) {
		this.newImageIcon = newImageIcon;
	}

	public ImageIcon getNewImageIconHeart() {
		return newImageIconHeart;
	}

	public void setNewImageIconHeart(ImageIcon newImageIconHeart) {
		this.newImageIconHeart = newImageIconHeart;
	}

	public int getHeartXLocation() {
		return heartXLocation;
	}

	public int getHeartYLocation() {
		return heartYLocation;
	}

	public JPanel getThirdMapPanel() {
		return thirdMapPanel;
	}

	public JPanel getChildThirdMapPanel() {
		return childThirdMapPanel;
	}

	public boolean isAddHeart() {
		return addHeart;
	}

	public void setAddHeart(boolean addHeart) {
		this.addHeart = addHeart;
	}

	public boolean isRemoveHeart() {
		return removeHeart;
	}

	public void setRemoveHeart(boolean removeHeart) {
		this.removeHeart = removeHeart;
	}

	public JLabel getHeart() {
		return heart;
	}

	public int[] getX() {
		return x;
	}

	public int[] getY() {
		return y;
	}

	public JLabel getTimerJLabel() {
		return timerJLabel;
	}

	public void setTimerJLabel(JLabel timerJLabel) {
		this.timerJLabel = timerJLabel;
	}

	public Timer getTimerThirdMap() {
		return timerThirdMap;
	}

	public void setTimerThirdMap(Timer timerThirdMap) {
		this.timerThirdMap = timerThirdMap;
	}

	public int getSecondsLeft() {
		return secondsLeft;
	}

	public void setSecondsLeft(int secondsLeft) {
		this.secondsLeft = secondsLeft;
	}

	public int getThirdMapScoreTake() {
		return thirdMapScoreTake;
	}

	public void setThirdMapScoreTake(int thirdMapScoreTake) {
		this.thirdMapScoreTake = thirdMapScoreTake;
	}

	public JPanel getCardPanel() {
		return cardPanel;
	}

	public void setCardPanel(JPanel cardPanel) {
		this.cardPanel = cardPanel;
	}

	public JLabel getMapLabel3() {
		return mapLabel;
	}

	public Timer getTimer3() {
		return timer3;
	}
}
