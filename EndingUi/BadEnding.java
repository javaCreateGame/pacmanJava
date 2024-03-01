package EndingUi;

import java.net.URL;

import javax.swing.ImageIcon;

import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextArea;




import java.awt.*;




public class BadEnding {
        public CardLayout cardLayout = new CardLayout();
  
   public JPanel badEndingPanelSum;
    
   public JPanel cardPanel;
   public ButtonEnding buttonEnding=new ButtonEnding();
    public JPanel badEndingPanel[]=new JPanel[4];
    String Ending[] = {
        "Bạn đã trượt đại học do vướng vào con đường cờ bạc.Bạn có muốn làm lại cuộc đời?",
        "Bạn đã trượt đại học do quá đắm chìm vào sự thú vị ,hay ho của game.Bạn có muốn làm lại cuộc đời?",
        "Bạn đã bị nghiện do vô tình dẵm vào kim tiêm của người nghiện.Bạn có muốn làm lại cuộc đời?",
        "Tôi không ngờ bạn lại ngủ quên trên chiến thắng lâu như vậy.Bạn đã không hoàn thành mục tiêu.Bạn có muốn làm lại cuộc đời?"
};
   JTextArea text[] =new JTextArea[4];
   JLabel img[]=new JLabel[4];
    String badURL[] = new String[30];
    public BadEnding(){
      
        for(int i=0;i<4;i++){
        badEndingPanel[i] = new JPanel();
       badEndingPanel[i].setBounds(0,0,615,690);
       badEndingPanel[i].setOpaque(true);
       badEndingPanel[i].setVisible(true);
       badEndingPanel[i].setLayout(null);
       badEndingPanel[i].setBackground(new Color(145,147,148));
       }
       
       
       badURL[0] ="./picture/cobacBadEnding.jpg";
       badURL[1] ="./picture/gameBadEnding.jpg";
       badURL[2] ="./picture/nghienBadEnding.jpg";
       badURL[3] ="./picture/fallScoreEnding.png";
       
         
        setPanel();
        setUp();
    } 
    public void setPanel(){
        for(int i=0;i<4;i++){
            text[i]=new JTextArea(Ending[i]);
            text[i].setBounds(80,420,455,40);
            text[i].setEnabled(false);
            text[i].setBackground(new Color(145,147,148));
            text[i].setForeground(new Color(222,13,13));
            text[i].setAlignmentY(JTextArea.CENTER_ALIGNMENT);
            text[i].setLineWrap(true);
            text[i].setWrapStyleWord(true);

            ImageIcon newImage = new ImageIcon(new ImageIcon(badURL[i]).getImage().getScaledInstance(400,400, Image.SCALE_SMOOTH));
            img[i]=new JLabel();
            img[i].setIcon(newImage);
            img[i].setBounds(107,0,400,400);
            img[i].setVisible(true);

            badEndingPanel[i].add(text[i]);
            badEndingPanel[i].add(img[i]);
            badEndingPanel[i].setBackground(new Color(145,147,148));
        }
        
       
        
    }
    public void setUp(){
        cardPanel = new JPanel(); // Use JPanel instead of JLayeredPane
        cardPanel.setBounds(0, 0, 615, 690);
      
        // Sử dụng CardLayout cho cardPanel
        cardPanel.setLayout(cardLayout);
        
        for(int i=0;i<4;i++){
            cardPanel.add(badEndingPanel[i], "bad"+i);
            
            
        }
        
        // Thể hiện thẻ đầu tiên (ở đây là Intro)
        
        cardLayout.show(cardPanel,"bad3" );
        badEndingPanelSum=new JPanel();
        badEndingPanelSum.setBounds(0,0,615,690);
        badEndingPanelSum.setOpaque(true);
        badEndingPanelSum.setVisible(true);
        badEndingPanelSum.setLayout(null);
        badEndingPanelSum.add(buttonEnding.YesButton);
        badEndingPanelSum.add(buttonEnding.NoButton);
        badEndingPanelSum.add(cardPanel);
        

    }
    
   
}