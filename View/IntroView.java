package View;

import javax.swing.JButton;


import Model.IntroModel;
import main.MyFrame;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IntroView {

    IntroModel introModel;
    MyFrame Mf;

    public IntroView(MyFrame Mf, IntroModel introModel) {
        this.Mf = Mf;
        this.introModel = introModel;

        // set up panels
        introModel.getIntroPanel().setSize(Mf.getJframeWidth(), Mf.getJframeHeightParent());
        introModel.getIntroPanel().setOpaque(true);
        introModel.getIntroPanel().setLayout(null);
        // Code phần giao diện
        this.init();

    }

    public void init() {
        // Set font (Có thể set nhiều font với kích thước khác nhau, chỉ cần đặt khác
        // tên đi là được)
        Font font = new Font("Arial", Font.BOLD, 24);

        // Set các thành phần cơ bản cho ứng dụng
        introModel.getIntroPanel().setVisible(true);

        // Tạo ra một JLabel để chứa hình ảnh làm nền
        JLabel background = new JLabel(new ImageIcon("./picture/Background_Intro.png"));
        background.setBounds(0, 0, Mf.getJframeWidth(), Mf.getJframeHeightParent());

        // Thêm hình ảnh làm nền vào introPanel
        introModel.getIntroPanel().add(background);

        // Tạo ra một nút Start và đặt nội dung cho nó là Start

        introModel.getStart().setFont(font);
        introModel.getStart().setBounds(121, 370, 130, 50);
        setUpButton(introModel.getStart());

        // Thêm nút Start vào introPanel với index = 0, là đặt nút này ở vị trí đầu tiên
        // (trên cùng)
        introModel.getIntroPanel().add(introModel.getStart());

        // Tạo ra một nút Exit và đặt nội dung cho nó là Exit

        introModel.getExit().setFont(font);
        introModel.getExit().setBounds(355, 370, 130, 50);

        setUpButton(introModel.getExit());

        // Thêm Exit vào introPanel với index = 1, là đặt nút này ở vị trí sau nút Start
        // (dưới cùng)
        introModel.getIntroPanel().add(introModel.getExit());

        // Tạo ra một nút loginButton nhấn sẽ đến cửa sổ đăng nhập
        introModel.getLoginButton().setFont(new Font("Arial", Font.BOLD, 16));
        introModel.getLoginButton().setBounds(Mf.getJframeWidth() - 130, Mf.getJframeHeight() - 620, 130, 50);

        setUpButton(introModel.getLoginButton());
        introModel.getIntroPanel().add(introModel.getLoginButton());

    }

    public void setUpButton(JButton button) {
        // Set màu chữ ban đầu
        button.setForeground(new Color(128, 0, 0));
        // Làm cho nút trở nên trong suốt
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);

        button.setFocusable(false);
        button.setVisible(true);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setForeground(new Color(94, 8, 8)); // Đổi màu chữ khi di chuột vào
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setForeground(new Color(128, 0, 0)); // Đổi lại màu chữ khi chuột rời khỏi nút
            }
        });
    }

    
    
}
