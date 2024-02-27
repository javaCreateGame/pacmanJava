package EndingUi;

import java.awt.Color;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


import java.awt.event.MouseEvent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;


import main.MyFrame;

public class BadEnding implements ActionListener{
    MyFrame Mf;
    public JButton YesButton;
    public JButton NoButton;
    ButtonEnding buttonEnding=new ButtonEnding(Mf);
    public JPanel badEndingPanel;
    String Ending[] = {
        "Bạn đã trượt đại học do vướng vào con đường cờ bạc.Bạn có muốn làm lại cuộc đời?",
        "Bạn đã trượt đại học do quá đắm chìm vào sự thú vị ,hay ho của game.Bạn có muốn làm lại cuộc đời?",
        "Bạn đã bị nghiện do vô tình dẵm vào kim tiêm của người nghiện.Bạn có muốn làm lại cuộc đời?",
        "Tôi không ngờ bạn lại ngủ quên trên chiến thắng lâu như vậy.Bạn đã không hoàn thành mục tiêu.Bạn có muốn làm lại cuộc đời?"
};
   JTextArea text;
   JLabel img;
    URL badURL[] = new URL[30];
    public BadEnding(MyFrame Mf){
        this.Mf=Mf;

        YesButton=new JButton("Yes");
        NoButton=new JButton("No");
        YesButton.setBounds(210, 440, 130, 50);
        NoButton.setBounds(260, 440, 130, 50);
        
        // Set màu chữ ban đầu
        YesButton.setForeground(Color.BLACK);
        NoButton.setForeground(Color.BLACK);
        
        // Làm cho nút skip trở nên trong suốt
        YesButton.setOpaque(false);
        YesButton.setContentAreaFilled(false);
        YesButton.setBorderPainted(false);
        YesButton.setFocusable(false);

        // Thêm trình nghe sự kiện chuột để thay đổi màu chữ khi di chuột vào
        YesButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                YesButton.setForeground(Color.BLUE); // Đổi màu chữ khi di chuột vào
            }

            @Override
            public void mouseExited(MouseEvent e) {
                YesButton.setForeground(Color.BLACK); // Đổi lại màu chữ khi chuột rời khỏi nút
            }
        });
        
        // Làm cho nút next trở nên trong suốt
        NoButton.setOpaque(false);
        NoButton.setContentAreaFilled(false);
        NoButton.setBorderPainted(false);
        NoButton.setFocusable(false);

        // Thêm trình nghe sự kiện chuột để thay đổi màu chữ khi di chuột vào
        NoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                NoButton.setForeground(Color.BLUE); // Đổi màu chữ khi di chuột vào
            }

            @Override
            public void mouseExited(MouseEvent e) {
                NoButton.setForeground(Color.BLACK); // Đổi lại màu chữ khi chuột rời khỏi nút
            }
        });
    



        badEndingPanel = new JPanel(null);
        badEndingPanel.setBounds(0,0,Mf.jframeWidth,Mf.jframeHeightParent);
        badEndingPanel.setOpaque(true);
        badEndingPanel.setVisible(true);
        badEndingPanel.setLayout(null);
        badEndingPanel.setBackground(new Color(252,254,254));
       
        badURL[0] = getClass().getResource("/picture/cobacBadEnding.jpg");
        badURL[1] = getClass().getResource("/picture/gameBadEnding.gif");
        badURL[2] = getClass().getResource("/picture/gameBadEnding.jpg");
        badURL[3] = getClass().getResource("/picture/fallScoreEnding.png");
         
        YesButton.addActionListener(this);
    } 
    public void setPanel(int i){
        img=new JLabel();
        text=new JTextArea(Ending[i]);
        text.setBackground(new Color(252,254,254));
        ImageIcon background=new ImageIcon(badURL[i]);
        ImageIcon newImage = new ImageIcon(background.getImage().getScaledInstance(200,200, Image.SCALE_SMOOTH));
        
        img.setIcon(newImage);
        img.setBounds((Mf.jframeWidth/2)-90,0,200,400);
        img.setVisible(true);
        text.setBounds((Mf.jframeWidth/2)-250,420,Mf.jframeWidth,20);
        badEndingPanel.add(img);
        badEndingPanel.add(text);
        badEndingPanel.add(buttonEnding.YesButton);
        badEndingPanel.add(buttonEnding.NoButton);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==YesButton) {
            System.out.println("hoan");
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
      
   
}