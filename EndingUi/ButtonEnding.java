package EndingUi;

import javax.swing.*;



import java.awt.event.MouseEvent;

import java.awt.*;

import java.awt.event.MouseAdapter;

public class ButtonEnding {
    public JButton YesButton;
    public JButton NoButton;
   
    public ButtonEnding(){
        
        YesButton=new JButton("Yes");
        NoButton=new JButton("No");
        YesButton.setBounds(210, 440, 80, 50);
        NoButton.setBounds(260, 440, 80, 50);
        
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
    }
}
