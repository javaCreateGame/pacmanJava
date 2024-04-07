package Model.StateModel;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class TrailerModel {

    private JLayeredPane trailerPanel;
    private JTextArea textArea;
    private JButton skipButton;
    private JButton nextButton;
    public boolean addHeart = false;
    public boolean removeHeart = false;
    private Timer timer;

    String[] linesToShow = {
            "Bạn là học sinh cấp 2 vừa thi và đỗ vào trường cấp 3 mong muốn.",
            "Đầu tiên chúc mừng bạn đã đỗ vào ngôi trường mơ ước nhưng đừng chủ quan, vì lúc này đây sẽ là những bước đầu trên con đường trưởng thành của bạn.",
            "Mục tiêu đầu tiên tôi muốn bạn hoàn thành đó là đỗ đại học mà bạn mong ước. Nó khá là chông gai đấy.",
            "Bạn sẽ có 3 năm để hoàn thành mục tiêu này.",
            "Trên con đường này bạn sẽ phải vừa tích lũy kiến thức để hoàn thành mục tiêu đồng thời phải tránh né các ngoại vật gây ảnh hưởng đến mục tiêu của bạn.",
            "Nếu bạn bị chúng ảnh hưởng thì mục tiêu của bạn sẽ tan tành.",
            "Đôi khi trên con đường này bạn gặp 1 người tiếp bước cùng bạn trên con đường. Người này sẽ cùng bạn vượt qua những ngoại vật gây ảnh hưởng nhưng nếu bạn quá đắm chìm vào chuyện của 2 người thì mục tiêu của bạn sẽ khó có thể được hoàn thành.",
            "Chúc bạn may mắn !!!"
    };
    private int currentLineIndex = 0;
    private int currentCharacterIndex = 0;

    public TrailerModel() {

        trailerPanel = new JLayeredPane();
        textArea = new JTextArea();
        skipButton = new JButton("Skip");
        nextButton = new JButton("Next");
        timer = new Timer(100, null);
    }
    // GET SET

    public JLayeredPane getTrailerPanel() {
        return trailerPanel;
    }

    public void setTrailerPanel(JLayeredPane trailerPanel) {
        this.trailerPanel = trailerPanel;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public JButton getSkipButton() {
        return skipButton;
    }

    public void setSkipButton(JButton skipButton) {
        this.skipButton = skipButton;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public void setNextButton(JButton nextButton) {
        this.nextButton = nextButton;
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

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public String[] getLinesToShow() {
        return linesToShow;
    }

    public void setLinesToShow(String[] linesToShow) {
        this.linesToShow = linesToShow;
    }

    public int getCurrentLineIndex() {
        return currentLineIndex;
    }

    public void setCurrentLineIndex(int currentLineIndex) {
        this.currentLineIndex = currentLineIndex;
    }

    public int getCurrentCharacterIndex() {
        return currentCharacterIndex;
    }

    public void setCurrentCharacterIndex(int currentCharacterIndex) {
        this.currentCharacterIndex = currentCharacterIndex;
    }

}
