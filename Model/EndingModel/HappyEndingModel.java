package Model.EndingModel;

import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Controller.EndingController.ButtonEndingControllor;




public class HappyEndingModel {
     private CardLayout cardLayout = new CardLayout();
   private JPanel happyEndingPanelSum= new JPanel();

   private int currentCharacterIndex = 0;
   private int numberHappy=0;
   private JPanel cardPanel=new JPanel();
   private ButtonEndingControllor buttonEnding=new ButtonEndingControllor();
   private JPanel happyEndingPanel[]=new JPanel[3];
    String Ending[] = {
    "Chúc mừng bạn đã hoàn thành xuất sắc mục tiêu được đề ra! Thành thật mà nói, tôi khá bất ngờ vì không nghĩ bạn có thể đạt được kết quả cao đến vậy. Nhưng sự quyết tâm và kỷ luật của bạn trong suốt những năm tháng qua đã chứng minh điều ngược lại. Đó sẽ là chìa khóa giúp bạn tiếp bước trên con đường trưởng thành của mình.Nhiệm vụ của tôi với bạn đã hoàn thành. Chúc bạn sẽ trải qua khoảng thời gian đẹp đẽ thời sinh viên. Bây giờ, tôi sẽ tiếp tục hành trình của mình để giúp đỡ những người khác, đặc biệt là những học sinh có ước mơ ,có hoài bão như bạn. Bạn có muốn cùng tôi tham gia?",
    "Wow, thật tuyệt vời! Tôi thực sự bất ngờ khi bạn hoàn thành mục tiêu nhanh và xuất sắc  như vậy. Chắc chắn bạn sẽ trở thành một tinh anh của xã hội, góp phần xây dựng đất nước ngày càng phát triển.Nhiệm vụ của tôi với bạn đã hoàn thành. Bạn có muốn cùng tôi tiếp bước để giúp đỡ những người khác, đặc biệt là những học sinh có ước mơ ,có hoài bão như bạn? Tôi tin rằng với sự góp sức của bạn, mọi thử thách đều sẽ diễn ra suôn sẻ.",
    "Chúc mừng bạn đã hoàn thành mục tiêu! Bạn không chỉ hoàn thành mà còn đạt thành tích xuất sắc, trở thành thủ khoa cả nước và nhận được học bổng của đại học Ha Vớt. Tôi rất tự hào vì là người hướng dẫn của bạn. Nhiệm vụ của tôi cũng đã hoàn thành. Bạn có muốn về với tôi để chia sẻ kiến thức,kinh nghiệm và trải nghiệm đạt thủ khoa cho những người có ước mơ ,có hoài bão và trên con đường trưởng thành không?"


};
   private JTextArea text[] =new JTextArea[3];
   JLabel img[]=new JLabel[3];
    String happyURL[] = new String[30];
   
    public CardLayout getCardLayout() {
        return cardLayout;
    }
    public JPanel getHappyEndingPanelSum() {
        return happyEndingPanelSum;
    }
  
    public int getCurrentCharacterIndex() {
        return currentCharacterIndex;
    }
    public int getNumberHappy() {
        return numberHappy;
    }
    public JPanel getCardPanel() {
        return cardPanel;
    }
    
    public JPanel[] getHappyEndingPanel() {
        return happyEndingPanel;
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
    public String[] getHappyURL() {
        return happyURL;
    }
   
    
    public ButtonEndingControllor getButtonEnding() {
        return buttonEnding;
    }
    public void setCurrentCharacterIndex(int currentCharacterIndex) {
        this.currentCharacterIndex = currentCharacterIndex;
    }
    public void setNumberHappy(int numberHappy) {
        this.numberHappy = numberHappy;
    }
  
    
}
