package State;

import javax.swing.*;

import main.MyFrame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import EndingUi.BadEnding;


public class ThirdMap extends Map {
    public ImageIcon newImageIcon;
    public ImageIcon newImageIconHeart;
    public int heartXLocation = 412, heartYLocation = 32;
    public JPanel thirdMapPanel;
    public JPanel childThirdMapPanel;
    public boolean addHeart= true;
    public boolean removeHeart= false;
    public JLabel heart;
    public int x[] = new int[n];
    public int y[] = new int[n];
    public JLabel scoreLabel; // Thêm label cho điểm số
    public static JLabel timerJLabel;
    public static Timer timerThirdMap;
    public static int secondsLeft;
    public static int thirdMapScoreTake;
    public BadEnding badEndingThirdMap;
    public JPanel cardPanel;
    MyFrame Mf;
    public ThirdMap(MyFrame Mf) {
        this.Mf=Mf;
        // Set layout cho map
        thirdMapPanel = new JPanel();
        thirdMapPanel.setBounds(0, 0, Mf.jframeWidth, Mf.jframeHeightParent);
        thirdMapPanel.setLayout(null);

        // Set time đếm ngược
       
        // Set up bad ending
        badEndingThirdMap = new BadEnding();

        // Đặt hình nền cho Third Map
        ImageIcon imageIcon = new ImageIcon("./picture/Map3.png");

        Image imgBgr = imageIcon.getImage();
        Image newImageBgr = imgBgr.getScaledInstance(Mf.jframeWidth, Mf.jframeHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(newImageBgr);

        // // Tạo một JLabel để chứa hình ảnh và thêm nó vào contentPane
        JLabel background = new JLabel(scaledImageIcon);
        background.setBounds(0,0,Mf.jframeWidth,Mf.jframeHeight);
        // Thêm JLabel vào content pane với BorderLayout
        thirdMapPanel.add(background);

        // Tạo một JPanel để chứa các thành phần khác
        childThirdMapPanel = new JPanel();
        childThirdMapPanel.setSize(Mf.jframeWidth, Mf.jframeHeight);
        childThirdMapPanel.setLayout(null); // Set layout thành null để có thể đặt vị trí tự do
        childThirdMapPanel.setOpaque(false);

        // Set size cho các obj

         
        
        for (int i = 0; i < n; i++) {
            this.obj[i] = new JLabel();
            this.obj[i].setSize(15, 15);
        }

        // Đặt hình nền cho obj
        ImageIcon objBgr = new ImageIcon("picture\\Book.png");
        Image img = objBgr.getImage();
        Image newImage = img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        newImageIcon = new ImageIcon(newImage);

        // Set hình nền cho trái tim, set up trái tim
        this.heart = new JLabel();
        this.heart.setSize(20, 20);
        ImageIcon objHeart = new ImageIcon("picture\\traitym.png");
        Image imgHeart = objHeart.getImage();
        Image newImageHeart = imgHeart.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
         newImageIconHeart = new ImageIcon(newImageHeart);
        this.heart.setIcon(newImageIconHeart);

        // ajdhjawhhdawh
        for (int i = 0; i < n; i++) {
            this.obj[i].setIcon(newImageIcon);
        }

        // Đặt vị trí của các obj trên background
        try {
            Scanner sc = new Scanner(new FileInputStream(new File("./InputFiletxt/bookMap3.txt")));
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

        for (int i = 0; i < n; i++) {
            obj[i].setLocation(x[i], y[i]); // Thiết lập vị trí của JLabel thứ i
            childThirdMapPanel.add(obj[i]); // Thêm JLabel vào childFirstMapPanel
            addObj[i]=true;
        }

        // Thêm trái tim vào map
       
        this.heart.setLocation(heartXLocation, heartYLocation);
        childThirdMapPanel.add(heart);
       addHeart=true;
        background.add(childThirdMapPanel);

        // Thêm lắng nghe sự kiện MouseListener vào JLabel background
        background.addMouseListener(new MyMouseListener());

        // Khởi tạo label cho điểm số và thêm vào panel của ThirdMap
        scoreLabel = new JLabel();
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Điều chỉnh font và kích thước chữ
        scoreLabel.setForeground(Color.BLACK); // Điều chỉnh màu chữ

       

        // Khởi tạo các thành phần của biến Timer
        timerJLabel = new JLabel();
        timerJLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        timerJLabel.setForeground(Color.BLACK); // Điều chỉnh màu chữ
        // Đặt vị trí của scoreLabel
        timerJLabel.setBounds(285, 620, 100, 20); // Đặt ở giữa
        // Thêm scoreLabel vào panel của ThirdMap
        thirdMapPanel.add(timerJLabel);

        // Đặt vị trí của scoreLabel
        scoreLabel.setBounds(50, 620, 100, 20); // Đặt ở góc trái dưới

        // Thêm scoreLabel vào panel của ThirdMap
        thirdMapPanel.add(scoreLabel);
    }

    // Phương thức để cập nhật điểm số trên scoreLabel
    public void updateScore(int score){
        scoreLabel.setText("Score: " + score);
        thirdMapScoreTake = score;
    }

    // // Phương thức để cập nhật thời gian trên timerJlabel
    public static void updateTimer(int time){
        secondsLeft = time;
        timerThirdMap = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (secondsLeft > 0) {
                    secondsLeft--;
                    timerJLabel.setText("Time: " + secondsLeft);
                } else {
                    timerThirdMap.stop();
                }
            }
        });
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

        // Các phương thức khác của MouseListener không được sử dụng trong trường hợp
        // này
        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

}
