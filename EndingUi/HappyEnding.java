package EndingUi;


import javax.swing.ImageIcon;

import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class HappyEnding {
   private CardLayout cardLayout = new CardLayout();
   private JPanel happyEndingPanelSum;
   private Timer timerHappy;
   private int currentCharacterIndex = 0;
   private int numberHappy=0;
   private JPanel cardPanel;
   private ButtonEnding buttonEnding=new ButtonEnding();
   private JPanel happyEndingPanel[]=new JPanel[4];
    String Ending[] = {
    "Chúc mừng bạn đã hoàn thành xuất sắc mục tiêu được đề ra! Thành thật mà nói, tôi khá bất ngờ vì không nghĩ bạn có thể đạt được kết quả cao đến vậy. Nhưng sự quyết tâm và kỷ luật của bạn trong suốt những năm tháng qua đã chứng minh điều ngược lại. Đó sẽ là chìa khóa giúp bạn tiếp bước trên con đường trưởng thành của mình.Nhiệm vụ của tôi với bạn đã hoàn thành. Chúc bạn sẽ trải qua khoảng thời gian đẹp đẽ thời sinh viên. Bây giờ, tôi sẽ tiếp tục hành trình của mình để giúp đỡ những người khác, đặc biệt là những học sinh có ước mơ ,có hoài bão như bạn. Bạn có muốn cùng tôi tham gia?",
    "Wow, thật tuyệt vời! Tôi thực sự bất ngờ khi bạn hoàn thành mục tiêu xuất sắc  như vậy. Chắc chắn bạn sẽ trở thành một tinh anh của xã hội, góp phần xây dựng đất nước ngày càng phát triển.Nhiệm vụ của tôi với bạn đã hoàn thành. Bạn có muốn cùng tôi tiếp bước để giúp đỡ những người khác, đặc biệt là những học sinh có ước mơ ,có hoài bão như bạn? Tôi tin rằng với sự góp sức của bạn, mọi thử thách đều sẽ diễn ra suôn sẻ."
};
   private JTextArea text[] =new JTextArea[2];
   JLabel img[]=new JLabel[2];
    String happyURL[] = new String[30];
    public HappyEnding(){
      
        for(int i=0;i<2;i++){
    happyEndingPanel[i] = new JPanel();
       happyEndingPanel[i].setBounds(0,0,615,690);
       happyEndingPanel[i].setOpaque(true);
       happyEndingPanel[i].setVisible(true);
       happyEndingPanel[i].setLayout(null);
       happyEndingPanel[i].setBackground(new Color(173,85,63));
       }
       
       
       happyURL[0] ="./picture/happyEnding.jpg";

        setPanel();
        setUp();

        timerHappy=new Timer(25,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (currentCharacterIndex < Ending[numberHappy].length()) {
                    text[numberHappy].append(String.valueOf(Ending[numberHappy].charAt(currentCharacterIndex)));
                    currentCharacterIndex++;
                }
                else{
                    timerHappy.stop();
                    
                }
            }
            
        } );
    } 
    public void setPanel(){
        for(int i=0;i<2;i++){
            text[i]=new JTextArea(Ending[i]);
            text[i].setBounds(80,420,455,140);
            text[i].setEnabled(false);
            text[i].setBackground(new Color(173,85,63));
            text[i].setAlignmentY(JTextArea.CENTER_ALIGNMENT);
            text[i].setLineWrap(true);
            text[i].setWrapStyleWord(true);

            ImageIcon newImage = new ImageIcon(new ImageIcon(happyURL[0]).getImage().getScaledInstance(400,400, Image.SCALE_SMOOTH));
            img[i]=new JLabel();
            img[i].setIcon(newImage);
            img[i].setBounds(107,0,400,400);
            img[i].setVisible(true);

            happyEndingPanel[i].add(text[i]);
            happyEndingPanel[i].add(img[i]);
            
        }
        
       
        
    }
    public void setUp(){
        cardPanel = new JPanel(); // Use JPanel instead of JLayeredPane
        cardPanel.setBounds(0, 0, 615, 690);
      
        // Sử dụng CardLayout cho cardPanel
        cardPanel.setLayout(cardLayout);
        
        for(int i=0;i<2;i++){
            cardPanel.add(happyEndingPanel[i], "happy"+i);
            
            
        }
        
       
        
        cardLayout.show(cardPanel,"happy0" );
        happyEndingPanelSum=new JPanel();
        happyEndingPanelSum.setBounds(0,0,615,690);
        happyEndingPanelSum.setOpaque(true);
        happyEndingPanelSum.setVisible(true);
        happyEndingPanelSum.setLayout(null);
        buttonEnding.getYesButton().setBounds(210, 550, 80, 50);
        buttonEnding.getNoButton().setBounds(260, 550, 80, 50);
        happyEndingPanelSum.add(buttonEnding.getYesButton());
        happyEndingPanelSum.add(buttonEnding.getNoButton());
        happyEndingPanelSum.add(cardPanel);
    }
	public CardLayout getCardLayout() {
		return cardLayout;
	}
	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}
	public JPanel getHappyEndingPanelSum() {
		return happyEndingPanelSum;
	}
	public void setHappyEndingPanelSum(JPanel happyEndingPanelSum) {
		this.happyEndingPanelSum = happyEndingPanelSum;
	}
	public Timer getTimerHappy() {
		return timerHappy;
	}
	public void setTimerHappy(Timer timerHappy) {
		this.timerHappy = timerHappy;
	}
	public int getCurrentCharacterIndex() {
		return currentCharacterIndex;
	}
	public void setCurrentCharacterIndex(int currentCharacterIndex) {
		this.currentCharacterIndex = currentCharacterIndex;
	}
	public int getNumberHappy() {
		return numberHappy;
	}
	public void setNumberHappy(int numberHappy) {
		this.numberHappy = numberHappy;
	}
	public JPanel getCardPanel() {
		return cardPanel;
	}
	public void setCardPanel(JPanel cardPanel) {
		this.cardPanel = cardPanel;
	}
	public ButtonEnding getButtonEnding() {
		return buttonEnding;
	}
	public void setButtonEnding(ButtonEnding buttonEnding) {
		this.buttonEnding = buttonEnding;
	}
	public JPanel[] getHappyEndingPanel() {
		return happyEndingPanel;
	}
	public void setHappyEndingPanel(JPanel[] happyEndingPanel) {
		this.happyEndingPanel = happyEndingPanel;
	}
	public JTextArea[] getText() {
		return text;
	}
	public void setText(JTextArea[] text) {
		this.text = text;
	}
    
    public JTextArea getTextI(int i) {
		return text[i];
	}
   
}