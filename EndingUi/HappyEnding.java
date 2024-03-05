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
        public CardLayout cardLayout = new CardLayout();
  
   public JPanel happyEndingPanelSum;
    public Timer timerHappy;
    public int currentCharacterIndex = 0;
    int numberHappy=0;
   public JPanel cardPanel;
   public ButtonEnding buttonEnding=new ButtonEnding();
    public JPanel happyEndingPanel[]=new JPanel[4];
    String Ending[] = {
    "Chúc mừng bạn đã hoàn thành xuất sắc mục tiêu được đề ra! Thành thật mà nói, tôi khá bất ngờ vì không nghĩ bạn có thể đạt được kết quả cao đến vậy. Nhưng sự quyết tâm và kỷ luật của bạn trong suốt những năm tháng qua đã chứng minh điều ngược lại. Đó sẽ là chìa khóa giúp bạn tiếp bước trên con đường trưởng thành của mình.Nhiệm vụ của tôi với bạn đã hoàn thành. Chúc bạn sẽ trải qua khoảng thời gian đẹp đẽ thời sinh viên. Bây giờ, tôi sẽ tiếp tục hành trình của mình để giúp đỡ những người khác, đặc biệt là những học sinh có ước mơ ,có hoài bão như bạn. Bạn có muốn cùng tôi tham gia?",
    "Wow, thật tuyệt vời! Tôi thực sự bất ngờ khi bạn hoàn thành mục tiêu xuất sắc  như vậy. Chắc chắn bạn sẽ trở thành một tinh anh của xã hội, góp phần xây dựng đất nước ngày càng phát triển.Nhiệm vụ của tôi với bạn đã hoàn thành. Bạn có muốn cùng tôi tiếp bước để giúp đỡ những người khác, đặc biệt là những học sinh có ước mơ ,có hoài bão như bạn? Tôi tin rằng với sự góp sức của bạn, mọi thử thách đều sẽ diễn ra suôn sẻ."
};
   public JTextArea text[] =new JTextArea[2];
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
        buttonEnding.YesButton.setBounds(210, 550, 80, 50);
        buttonEnding.NoButton.setBounds(260, 550, 80, 50);
        happyEndingPanelSum.add(buttonEnding.YesButton);
        happyEndingPanelSum.add(buttonEnding.NoButton);
        happyEndingPanelSum.add(cardPanel);
    }
    
   
}