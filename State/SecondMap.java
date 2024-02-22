package State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SecondMap extends JFrame{
    public JPanel secondMapPanel;
    public JLabel obj[];
    public JLabel heart;

    public SecondMap() {

        // Set layout cho map
        this.setLayout(new BorderLayout());


        // Đặt hình nền cho Second Map
        ImageIcon imageIcon = new ImageIcon(".\\picture\\Map2_re2.png");
        
        // // Tạo một JLabel để chứa hình ảnh và thêm nó vào contentPane
        JLabel background = new JLabel(imageIcon);

        // Thêm JLabel vào content pane với BorderLayout
        this.add(background, BorderLayout.CENTER);
        
        // Tạo một JPanel để chứa các thành phần khác
        secondMapPanel = new JPanel();
        secondMapPanel.setSize(615, 615);
        secondMapPanel.setLayout(null); // Set layout thành null để có thể đặt vị trí tự do
        secondMapPanel.setOpaque(false);
        

        // Set size cho các obj

        this.obj = new JLabel[20];
        int n = this.obj.length;
        for(int i = 0; i < n; i++) {
            this.obj[i] = new JLabel();
            this.obj[i].setSize(10, 10);
        }

        // Đặt hình nền cho obj
        ImageIcon objBgr = new ImageIcon("picture\\Book.png");
        Image img = objBgr.getImage();
        Image newImage = img.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        ImageIcon newImageIcon = new ImageIcon(newImage);


        // Set hình nền cho trái tim, set up trái tim
        this.heart = new JLabel();
        this.heart.setSize(10, 10);
        ImageIcon objHeart = new ImageIcon("picture\\traitym.png");
        Image imgHeart = objHeart.getImage();
        Image newImageHeart = imgHeart.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        ImageIcon newImageIconHeart = new ImageIcon(newImageHeart);
        this.heart.setIcon(newImageIconHeart);



        for (int i = 0; i < n; i++) {
            this.obj[i].setIcon(newImageIcon);
        }

        // Đặt vị trí của các obj trên background
        obj[0].setLocation(279, 31); // Thay đổi tùy ý
        secondMapPanel.add(obj[0]);

        obj[1].setLocation(279, 70); // Thay đổi tùy ý
        secondMapPanel.add(obj[1]);

        obj[2].setLocation(279, 100); // Thay đổi tùy ý
        secondMapPanel.add(obj[2]);

        obj[3].setLocation(279, 143); // Thay đổi tùy ý
        secondMapPanel.add(obj[3]);

        obj[4].setLocation(279, 194); // Thay đổi tùy ý
        secondMapPanel.add(obj[4]);

        obj[5].setLocation(279, 236); // Thay đổi tùy ý
        secondMapPanel.add(obj[5]);

        obj[6].setLocation(79, 389); // Thay đổi tùy ý
        secondMapPanel.add(obj[6]);

        obj[7].setLocation(111, 421); // Thay đổi tùy ý
        secondMapPanel.add(obj[7]);

        obj[8].setLocation(145, 340); // Thay đổi tùy ý
        secondMapPanel.add(obj[8]);

        obj[9].setLocation(255, 331); // Thay đổi tùy ý
        secondMapPanel.add(obj[9]);

        obj[10].setLocation(284, 343); // Thay đổi tùy ý
        secondMapPanel.add(obj[10]);

        obj[11].setLocation(293, 248); // Thay đổi tùy ý
        secondMapPanel.add(obj[11]);

        obj[12].setLocation(276, 144); // Thay đổi tùy ý
        secondMapPanel.add(obj[12]);

        obj[13].setLocation(290, 60); // Thay đổi tùy ý
        secondMapPanel.add(obj[13]);

        obj[14].setLocation(360, 53); // Thay đổi tùy ý
        secondMapPanel.add(obj[14]);

        obj[15].setLocation(329, 112); // Thay đổi tùy ý
        secondMapPanel.add(obj[15]);

        obj[16].setLocation(361, 279); // Thay đổi tùy ý
        secondMapPanel.add(obj[16]);

        obj[17].setLocation(323, 445); // Thay đổi tùy ý
        secondMapPanel.add(obj[17]);

        obj[18].setLocation(437, 485); // Thay đổi tùy ý
        secondMapPanel.add(obj[18]);

        obj[19].setLocation(559, 307); // Thay đổi tùy ý
        secondMapPanel.add(obj[19]);

        // Thêm trái tim vào map
        this.heart.setLocation(303, 512);
        secondMapPanel.add(heart);

        background.add(secondMapPanel);

        

        // Thêm lắng nghe sự kiện MouseListener vào JLabel background
        background.addMouseListener(new MyMouseListener());

        this.init();
        this.setVisible(true);
    }

    public void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Second Map");
        this.setSize(615, 615);
        this.setLocationRelativeTo(null);
    }

    // Lớp lắng nghe sự kiện MouseListener
    private class MyMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            // Lấy tọa độ x và y của sự kiện click chuột
            int x = e.getX();
            int y = e.getY();
            // In tọa độ x và y ra màn hình
            System.out.println("X: " + x + ", Y: " + y);
        }

        // Các phương thức khác của MouseListener không được sử dụng trong trường hợp này
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
    }

    public static void main(String[] args) {
        SecondMap sc = new SecondMap();
    }
}
