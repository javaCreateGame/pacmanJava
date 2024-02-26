package State;
import javax.swing.*;

import main.MyFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FirstMap extends Map {
    public JPanel firstMapPanel;
    public JPanel childFirstMapPanel;
    public JLabel obj[];
    public JLabel heart;
    public boolean addHear= true;
    public boolean removeHeart= false;
    public int heartXLocation = 298, heartYLocation = 279;
    MyFrame Mf;

    int score;
    public JLabel mapLabel;
    public JLabel scoreLabel; // Thêm label cho điểm số
    public Timer timer;
    public FirstMap(MyFrame Mf){
      this.Mf=Mf;
       //set up panel
       firstMapPanel =new JPanel();
       firstMapPanel.setSize( Mf.jframeWidth, Mf.jframeHeight);
       firstMapPanel.setLayout(new BorderLayout());
        //Code Giao dien

        // Dịch chuyển hình nền lên 27 pixel từ dưới lên
        // Đặt hình nền cho First Map
        ImageIcon imageIcon = new ImageIcon("./picture/Map1.png");

        Image img1 = imageIcon.getImage();
        Image newImage1 = img1.getScaledInstance(Mf.jframeWidth, Mf.jframeHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(newImage1);

        // // Tạo một JLabel để chứa hình ảnh và thêm nó vào contentPane
        JLabel background = new JLabel(scaledImageIcon);

        // Thêm JLabel vào content pane với BorderLayout
        firstMapPanel.add(background, BorderLayout.CENTER);
        
        // Tạo một JPanel để chứa các thành phần khác
        childFirstMapPanel = new JPanel();
        childFirstMapPanel.setSize(Mf.jframeWidth, Mf.jframeHeight);
        childFirstMapPanel.setLayout(null); // Set layout thành null để có thể đặt vị trí tự do
        childFirstMapPanel.setOpaque(false);

        // Set size cho các obj

        this.obj = new JLabel[20];
        int n = this.obj.length;
        for (int i = 0; i < n; i++) {
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

        for (int i = 0; i < n; i++) {
          this.obj[i].setIcon(newImageIcon);
        }

        // Đặt vị trí của các obj trên background
        int x[] = new int[n];
        int y[] = new int[n];
        try {
            Scanner sc = new Scanner(new FileInputStream(new File("./InputFiletxt/bookMap1.txt")));
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
          childFirstMapPanel.add(obj[i]); // Thêm JLabel vào childFirstMapPanel
        }

        // Thêm trái tim vào map
        
        this.heart.setLocation(heartXLocation, heartYLocation);
        childFirstMapPanel.add(heart);
        addHeart=true;
        background.add(childFirstMapPanel);
 
        //*****************************************************/
        mapLabel = new JLabel("LỚP 10");
        mapLabel.setFont(new Font("Arial", Font.BOLD, 45));
        mapLabel.setForeground(Color.BLACK);
        mapLabel.setPreferredSize(new Dimension(mapLabel.getPreferredSize().width + 20, mapLabel.getPreferredSize().height));
        int labelX = (Mf.jframeWidth - mapLabel.getPreferredSize().width) / 2;
        int labelY = (Mf.jframeHeight - mapLabel.getPreferredSize().height) / 2;
        mapLabel.setBounds(labelX, labelY, mapLabel.getPreferredSize().width, mapLabel.getPreferredSize().height);
        childFirstMapPanel.add(mapLabel);

        // Khởi tạo label cho điểm số và thêm vào panel của FirstMap
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Điều chỉnh font và kích thước chữ
        scoreLabel.setForeground(Color.BLACK); // Điều chỉnh màu chữ

        // Đặt vị trí của scoreLabel
        scoreLabel.setBounds(300, Mf.jframeHeight - 30, 100, 20); // Đặt ở góc trái dưới

        // Thêm scoreLabel vào panel của FirstMap
        childFirstMapPanel.add(scoreLabel);

        // Khởi tạo Timer
        timer = new Timer(1000, new ActionListener() {
          int count = 0;

          @Override
          public void actionPerformed(ActionEvent e) {
              count++;
              if (count <= 8) { // Hiển thị trong 3 giây đầu
                  float opacity = 1.0f - (count / 8.0f); // Ẩn dần chữ "Map 1"
                  mapLabel.setForeground(new Color(0, 0, 0, Math.max(0, Math.min(255, (int) (opacity * 255))))); // Đặt màu chữ
                  // mapLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
              } else {
                  timer.stop(); // Dừng Timer sau khi đã đủ thời gian hiển thị
                  mapLabel.setVisible(false); // Ẩn hoàn toàn chữ "Map 1"
              }
          }
      });

      // Bắt đầu Timer
      timer.start();
      

        
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