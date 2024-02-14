import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import State.*;

public class MyFrame extends JFrame implements ActionListener {
    
    
    JPanel cardPanel;  // Use JPanel instead of JLayeredPane
    Intro intro = new Intro();
    Trailer trailer = new Trailer();
    FirstMap firstMap = new FirstMap();
    SecondMap secondMap = new SecondMap();
    ThirdMap thirdMap = new ThirdMap();

    CardLayout cardLayout = new CardLayout();

    MyFrame() {
        cardPanel = new JPanel();  // Use JPanel instead of JLayeredPane
        cardPanel.setBounds(0, 0, 615, 615);

        // Sử dụng CardLayout cho cardPanel
        cardPanel.setLayout(cardLayout);

        // Thêm các panel vào cardPanel với tên đặc biệt
        cardPanel.add(thirdMap.thirdMapPanel, "ThirdMap");
        cardPanel.add(secondMap.secondMapPanel, "SecondMap");
        cardPanel.add(firstMap.firstMapPanel, "FirstMap");
        cardPanel.add(trailer.trailerPanel, "Trailer");
        cardPanel.add(intro.introPanel, "Intro");

        // Thể hiện thẻ đầu tiên (ở đây là Intro)
        cardLayout.show(cardPanel, "Intro");

        ImageIcon logo = new ImageIcon("./picture/logo.jpg");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(615, 615);
        this.setTitle("Journey to Adulthood");
        this.setIconImage(logo.getImage());
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.add(cardPanel);

        // Thêm ActionListener cho nút "Start" trong Intro
        intro.Start.addActionListener(this);
        
        // Thêm ActionListener cho nút "Exit" trong Intro
        intro.Exit.addActionListener(this);
        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Xử lý sự kiện khi nút "Start" được nhấn
        if (e.getSource() == intro.Start) {
            // Chuyển sang cửa sổ Trailer
            cardLayout.show(cardPanel, "Trailer");
        }
        // Xử lý sự kiện khi nút "Exit" được nhấn
        else if (e.getSource() == intro.Exit) {
            // Thoát ứng dụng
            System.exit(0);
        }
    }
}
