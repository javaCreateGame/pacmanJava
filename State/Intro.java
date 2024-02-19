package State;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class Intro{
   public JPanel introPanel;
    public JButton Start;
    public JButton Exit;
    public Intro(){
        //set up panels
        introPanel = new JPanel(null);
        introPanel.setSize(615, 615);
        introPanel.setOpaque(true);
        //Code phần giao diện
        this.init();
    }

    public void init() {
        // Set font (Có thể set nhiều font với kích thước khác nhau, chỉ cần đặt khác tên đi là được)
        Font font = new Font("Arial", Font.BOLD, 24);


        // Set các thành phần cơ bản cho ứng dụng
        introPanel.setVisible(true);
        
        // Tạo ra một JLabel để chứa hình ảnh làm nền
        JLabel background = new JLabel(new ImageIcon("./picture/bgr.png"));
        background.setBounds(0, 0, 615, 615);

        // Thêm hình ảnh làm nền vào introPanel
        introPanel.add(background);

        // Tạo ra một nút Start và đặt nội dung cho nó là Start
        Start = new JButton("Start");
        Start.setFont(font);
        Start.setBounds(235, 340, 130, 50);
        
        // Set màu chữ ban đầu
        Start.setForeground(new Color(128,0,0));
        // Làm cho nút trở nên trong suốt
        Start.setOpaque(false);
        Start.setContentAreaFilled(false);
        Start.setBorderPainted(false);
        
        Start.setFocusable(false);

        // Thêm trình nghe sự kiện chuột để thay đổi màu chữ khi di chuột vào
        Start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Start.setForeground(new Color(94,8,8)); // Đổi màu chữ khi di chuột vào
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Start.setForeground(new Color(128,0,0)); // Đổi lại màu chữ khi chuột rời khỏi nút
            }
        });
        
        // Thêm nút Start vào introPanel với index = 0, là đặt nút này ở vị trí đầu tiên (trên cùng)
        introPanel.add(Start, 0);
        
        // Tạo ra một nút Exit và đặt nội dung cho nó là Exit
        Exit = new JButton("Exit");
        Exit.setFont(font);
        Exit.setBounds(235, 390, 130, 50);
        
        // Set màu chữ ban đầu
        Exit.setForeground(new Color(128,0,0));
        // Làm cho nút trở nên trong suốt
        Exit.setOpaque(false);
        Exit.setContentAreaFilled(false);
        Exit.setBorderPainted(false);
        
        Exit.setFocusable(false);
        
        // Thêm trình nghe sự kiện chuột để thay đổi màu chữ khi di chuột vào
        Exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Exit.setForeground(new Color(94,8,8)); // Đổi màu chữ khi di chuột vào
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Exit.setForeground(new Color(128,0,0)); // Đổi lại màu chữ khi chuột rời khỏi nút
            }
        });

        // Thêm nút Exit vào introPanel với index = 1, là đặt nút này ở vị trí sau nút Start (dưới cùng)
        introPanel.add(Exit, 1);
    }
}
