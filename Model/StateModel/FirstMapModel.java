package Model.StateModel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FirstMapModel extends MapModel {
    private JPanel firstMapPanel;
    private JPanel childFirstMapPanel;
    private JLabel heart;
    private boolean addHeart = true;
    private boolean removeHeart = false;
    private int heartXLocation = 298, heartYLocation = 279;

    private int x[] = new int[getN()];
    private int y[] = new int[getN()];
    private JLabel mapLabel;
    private Timer timer;

    public FirstMapModel() {

        // set up panel
        firstMapPanel = new JPanel();
        childFirstMapPanel = new JPanel();
        heart = new JLabel();
        mapLabel = new JLabel("LỚP 10");
        timer = new Timer(1000, null);
    }

    // GET SET
    public JPanel getFirstMapPanel() {
        return firstMapPanel;
    }

    public void setFirstMapPanel(JPanel firstMapPanel) {
        this.firstMapPanel = firstMapPanel;
    }

    public JPanel getChildFirstMapPanel() {
        return childFirstMapPanel;
    }

    public void setChildFirstMapPanel(JPanel childFirstMapPanel) {
        this.childFirstMapPanel = childFirstMapPanel;
    }

    public JLabel getHeart() {
        return heart;
    }

    public void setHeart(JLabel heart) {
        this.heart = heart;
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

    public int getHeartXLocation() {
        return heartXLocation;
    }

    public void setHeartXLocation(int heartXLocation) {
        this.heartXLocation = heartXLocation;
    }

    public int getHeartYLocation() {
        return heartYLocation;
    }

    public void setHeartYLocation(int heartYLocation) {
        this.heartYLocation = heartYLocation;
    }

    public int[] getX() {
        return x;
    }

    public void setX(int[] x) {
        this.x = x;
    }

    public int[] getY() {
        return y;
    }

    public void setY(int[] y) {
        this.y = y;
    }

    public JLabel getMapLabel() {
        return mapLabel;
    }

    public void setMapLabel(JLabel mapLabel) {
        this.mapLabel = mapLabel;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

}
