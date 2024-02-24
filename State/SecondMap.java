package State;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class SecondMap {
    public JPanel secondMapPanel;
    public JPanel childSecondMapPanel;
    public JLabel obj[];
    public JLabel heart;

    public SecondMap() {

        // Set layout cho map
        secondMapPanel = new JPanel();
        secondMapPanel.setSize(615, 615);
        secondMapPanel.setLayout(new BorderLayout());

        // Dịch chuyển hình nền lên 27 pixel từ dưới lên
        secondMapPanel.setBorder(BorderFactory.createEmptyBorder(-27, 0, 0, 0));
        // Đặt hình nền cho Second Map
        ImageIcon imageIcon = new ImageIcon("./picture/Map2.png");
        
        Image img1 = imageIcon.getImage();
        Image newImage1 = img1.getScaledInstance(615, 615, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(newImage1);

        // // Tạo một JLabel để chứa hình ảnh và thêm nó vào contentPane
        JLabel background = new JLabel(scaledImageIcon);

        // Thêm JLabel vào content pane với BorderLayout
        secondMapPanel.add(background, BorderLayout.CENTER);
        
        // Tạo một JPanel để chứa các thành phần khác
        childSecondMapPanel = new JPanel();
        childSecondMapPanel.setSize(615, 615);
        childSecondMapPanel.setLayout(null); // Set layout thành null để có thể đặt vị trí tự do
        childSecondMapPanel.setOpaque(false);
        

        // Set size cho các obj

        this.obj = new JLabel[20];
        int n = this.obj.length;
        for(int i = 0; i < n; i++) {
            this.obj[i] = new JLabel();
            this.obj[i].setSize(15, 15);
        }

        // Đặt hình nền cho obj
        ImageIcon objBgr = new ImageIcon("picture\\Book.png");
        Image img = objBgr.getImage();
        Image newImage = img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon newImageIcon = new ImageIcon(newImage);


        // Set hình nền cho trái tim, set up trái tim
        this.heart = new JLabel();
        this.heart.setSize(20, 20);
        ImageIcon objHeart = new ImageIcon("picture\\traitym.png");
        Image imgHeart = objHeart.getImage();
        Image newImageHeart = imgHeart.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon newImageIconHeart = new ImageIcon(newImageHeart);
        this.heart.setIcon(newImageIconHeart);


        // ajdhjawhhdawh
        for (int i = 0; i < n; i++) {
            this.obj[i].setIcon(newImageIcon);
        }

        // Đặt vị trí của các obj trên background
        int x[] = new int[n];
        int y[] = new int[n];
        try {
            Scanner sc = new Scanner(new FileInputStream(new File("./book.txt")));
            int i = 0; // Sử dụng biến i để xác định vị trí của mỗi JLabel trong mảng obj[]
            while (sc.hasNextInt()) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            
            if (i < n) { // Đảm bảo rằng i không vượt quá số lượng JLabel trong mảng obj[]
                x[i] = p;
                y[i] = q;
                i++; // Tăng biến i lên để đến JLabel tiếp theo trong mảng obj[]
            }
        }
        sc.close(); // Đóng luồng sau khi sử dụng xong.
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // In ra lỗi nếu tệp tin không được tìm thấy
        }
        
        for(int i=0;i<n;i++){
            obj[i].setLocation(x[i], y[i]); // Thiết lập vị trí của JLabel thứ i
            childSecondMapPanel.add(obj[i]); // Thêm JLabel vào childSecondMapPanel
        }

        
        // obj[0].setLocation(279, 31); // Thay đổi tùy ý
        // childSecondMapPanel.add(obj[0]);

        // obj[1].setLocation(279, 70); // Thay đổi tùy ý
        // childSecondMapPanel.add(obj[1]);

        // obj[2].setLocation(279, 100); // Thay đổi tùy ý
        // childSecondMapPanel.add(obj[2]);

        // obj[3].setLocation(279, 143); // Thay đổi tùy ý
        // childSecondMapPanel.add(obj[3]);

        // obj[4].setLocation(279, 194); // Thay đổi tùy ý
        // childSecondMapPanel.add(obj[4]);

        // obj[5].setLocation(279, 236); // Thay đổi tùy ý
        // childSecondMapPanel.add(obj[5]);

        // obj[6].setLocation(79, 389); // Thay đổi tùy ý
        // childSecondMapPanel.add(obj[6]);

        // obj[7].setLocation(111, 421); // Thay đổi tùy ý
        // childSecondMapPanel.add(obj[7]);

        // obj[8].setLocation(145, 340); // Thay đổi tùy ý
        // childSecondMapPanel.add(obj[8]);

        // obj[9].setLocation(255, 331); // Thay đổi tùy ý
        // childSecondMapPanel.add(obj[9]);

        // obj[10].setLocation(284, 343); // Thay đổi tùy ý
        // childSecondMapPanel.add(obj[10]);

        // obj[11].setLocation(293, 248); // Thay đổi tùy ý
        // childSecondMapPanel.add(obj[11]);

        // obj[12].setLocation(276, 144); // Thay đổi tùy ý
        // childSecondMapPanel.add(obj[12]);

        // obj[13].setLocation(290, 60); // Thay đổi tùy ý
        // childSecondMapPanel.add(obj[13]);

        // obj[14].setLocation(360, 53); // Thay đổi tùy ý
        // childSecondMapPanel.add(obj[14]);

        // obj[15].setLocation(329, 112); // Thay đổi tùy ý
        // childSecondMapPanel.add(obj[15]);

        // obj[16].setLocation(361, 279); // Thay đổi tùy ý
        // childSecondMapPanel.add(obj[16]);

        // obj[17].setLocation(323, 445); // Thay đổi tùy ý
        // childSecondMapPanel.add(obj[17]);

        // obj[18].setLocation(437, 485); // Thay đổi tùy ý
        // childSecondMapPanel.add(obj[18]);

        // obj[19].setLocation(559, 307); // Thay đổi tùy ý
        // childSecondMapPanel.add(obj[19]);

        // Thêm trái tim vào map
        this.heart.setLocation(556, 301);
        childSecondMapPanel.add(heart);

        background.add(childSecondMapPanel);

        // Thêm lắng nghe sự kiện MouseListener vào JLabel background
        background.addMouseListener(new MyMouseListener());

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

}

