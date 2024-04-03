package Model.EndingModel;

import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import EndingUi.ButtonEnding;

public class BadEndingModel {
    private CardLayout cardLayout = new CardLayout();
   private JPanel badEndingPanelSum=new JPanel();
   private int numberBad;
   private Timer timerBad;
   private int currentCharacterIndex = 0;
   private JPanel cardPanel=new JPanel();
   private ButtonEnding buttonEnding=new ButtonEnding();
   private JPanel badEndingPanel[]=new JPanel[4];
    String Ending[] = {
        "Bạn đã trượt đại học do vướng vào con đường cờ bạc.Bạn có muốn làm lại cuộc đời?",
        "Bạn đã trượt đại học do quá đắm chìm vào sự thú vị ,hay ho của game.Bạn có muốn làm lại cuộc đời?",
        "Bạn đã bị nghiện do vô tình dẵm vào kim tiêm của người nghiện.Bạn có muốn làm lại cuộc đời?",
        "Tôi không ngờ bạn lại ngủ quên trên chiến thắng lâu như vậy.Bạn đã không hoàn thành mục tiêu.Bạn có muốn làm lại cuộc đời?"
    };
   private JTextArea text[] =new JTextArea[4];
   JLabel img[]=new JLabel[4];
   String badURL[] = new String[30];
public CardLayout getCardLayout() {
    return cardLayout;
}
public JPanel getBadEndingPanelSum() {
    return badEndingPanelSum;
}
public int getNumberBad() {
    return numberBad;
}
public Timer getTimerBad() {
    return timerBad;
}
public int getCurrentCharacterIndex() {
    return currentCharacterIndex;
}
public JPanel getCardPanel() {
    return cardPanel;
}
public ButtonEnding getButtonEnding() {
    return buttonEnding;
}
public JPanel[] getBadEndingPanel() {
    return badEndingPanel;
}
public String[] getEnding() {
    return Ending;
}
public JTextArea[] getText() {
    return text;
}
public JLabel[] getImg() {
    return img;
}
public String[] getBadURL() {
    return badURL;
}
   
}
