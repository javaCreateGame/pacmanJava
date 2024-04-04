package View.EndingView;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import EndingUi.BadEnding;
import Model.EndingModel.BadEndingModel;


public class BadEndingView {
    BadEndingModel badEndingModel;
    public BadEndingView(BadEndingModel badEndingModel){
        this.badEndingModel=badEndingModel;
       setParentPanel();
       badEndingModel.getBadURL()[0] ="./picture/cobacBadEnding.jpg";
       badEndingModel.getBadURL()[1] ="./picture/gameBadEnding.jpg";
       badEndingModel.getBadURL()[2] ="./picture/nghienBadEnding.jpg";
       badEndingModel.getBadURL()[3] ="./picture/fallScoreEnding.png";
       setPanel();
       setUp();
    }
 //Set Up Các trang to của từng ending
    private void setParentPanel(){
        for(int i=0;i<badEndingModel.getBadEndingPanel().length;i++){
    badEndingModel.getBadEndingPanel()[i] = new JPanel();
       badEndingModel.getBadEndingPanel()[i].setBounds(0,0,615,690);
       badEndingModel.getBadEndingPanel()[i].setOpaque(true);
       badEndingModel.getBadEndingPanel()[i].setVisible(true);
       badEndingModel.getBadEndingPanel()[i].setLayout(null);
       badEndingModel.getBadEndingPanel()[i].setBackground(new Color(76,82,82));
       }
    }
    //Set Up câu chữ và ảnh của từng ending
    private void setPanel(){
        for(int i=0;i<badEndingModel.getText().length;i++){
            badEndingModel.getText()[i]=new JTextArea();
            badEndingModel.getText()[i].setBounds(80,420,455,40);
            badEndingModel.getText()[i].setEnabled(false);
            badEndingModel.getText()[i].setBackground(new Color(76,82,82));
            badEndingModel.getText()[i].setAlignmentY(JTextArea.CENTER_ALIGNMENT);
            badEndingModel.getText()[i].setLineWrap(true);
            badEndingModel.getText()[i].setWrapStyleWord(true);

            ImageIcon newImage = new ImageIcon(new ImageIcon(badEndingModel.getBadURL()[i]).getImage().getScaledInstance(400,400, Image.SCALE_SMOOTH));
            badEndingModel.getImg()[i]=new JLabel();
            badEndingModel.getImg()[i].setIcon(newImage);
            badEndingModel.getImg()[i].setBounds(107,0,400,400);
            badEndingModel.getImg()[i].setVisible(true);

           badEndingModel.getBadEndingPanel()[i].add(badEndingModel.getText()[i]);
           badEndingModel.getBadEndingPanel()[i].add(badEndingModel.getImg()[i]);
            
        }
        
       
        
    }
     //Set up nút và trang to chứa tất cả các trang ending
    private void setUp(){
         // Use JPanel instead of JLayeredPane
        badEndingModel.getCardPanel().setBounds(0, 0, 615, 690);
      
        // Sử dụng CardLayout cho cardPanel
        badEndingModel.getCardPanel().setLayout(badEndingModel.getCardLayout());
        
        for(int i=0;i<badEndingModel.getBadEndingPanel().length;i++){
            badEndingModel.getCardPanel().add(badEndingModel.getBadEndingPanel()[i], "bad"+i);
            
            
        }
        
        // Thể hiện thẻ đầu tiên (ở đây là Intro)
        
        badEndingModel.getCardLayout().show(badEndingModel.getCardPanel(),"bad3" );
       
       badEndingModel.getBadEndingPanelSum().setBounds(0,0,615,690);
       badEndingModel.getBadEndingPanelSum().setOpaque(true);
       badEndingModel.getBadEndingPanelSum().setVisible(true);
       badEndingModel.getBadEndingPanelSum().setLayout(null);
       badEndingModel.getBadEndingPanelSum().add(badEndingModel.getButtonEnding().getYesButton());
       badEndingModel.getBadEndingPanelSum().add(badEndingModel.getButtonEnding().getNoButton());
       badEndingModel.getBadEndingPanelSum().add(badEndingModel.getCardPanel());
    }
}
