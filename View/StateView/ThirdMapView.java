package View.StateView;

import Model.GameModel.GameModel;
import Model.StateModel.ThirdMapModel;
import View.TileView.TileManager;
import View.TileView.TilePanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ThirdMapView {
    GameModel Mf;
    ThirdMapModel thirdMapModel;
    TileManager tileManager;
    TilePanel tilePanel;
    public ThirdMapView(GameModel Mf, ThirdMapModel thirdMapModel) {
        this.Mf = Mf;
        this.thirdMapModel = thirdMapModel;
        tileManager=new TileManager(Mf,"/InputFiletxt/map03.txt");
        tilePanel=new TilePanel(Mf, tileManager);
      
        // Set layout cho map
        thirdMapModel.getThirdMapPanel().setBounds(0, 0, Mf.getJframeWidth(), Mf.getJframeHeightParent());
        thirdMapModel.getThirdMapPanel().setLayout(null);


         

        // Set up bad ending

        // Đặt hình nền cho Second Map
        thirdMapModel.getLayeredPane().setBounds(0, 0, Mf.getJframeWidth(), Mf.getJframeHeightParent());

        // Set layout cho map
        thirdMapModel.getThirdMapPanel().setSize(Mf.getJframeWidth(), Mf.getJframeHeight());
        thirdMapModel.getThirdMapPanel().setBounds(0, 0, Mf.getJframeWidth(), Mf.getJframeHeightParent());
        thirdMapModel.getThirdMapPanel().setLayout(null);


         // Khởi tạo các thành phần của biến Timer
         thirdMapModel.getTimerJLabel().setFont(new Font("Arial", Font.PLAIN, 16));
         thirdMapModel.getTimerJLabel().setForeground(Color.BLACK); // Điều chỉnh màu chữ
         // Đặt vị trí của scoreLabel
         thirdMapModel.getTimerJLabel().setBounds(285, 620, 100, 20); // Đặt ở giữa
         // Thêm scoreLabel vào panel của ThirdMap
         thirdMapModel.getThirdMapPanel().add(thirdMapModel.getTimerJLabel());
       // Set time đếm ngược
        // Đặt hình nền cho Second Map
        // ImageIcon imageIcon = new ImageIcon("./picture/Map2.png");

        // Image imgBgr = imageIcon.getImage();
        // Image newImageBgr = imgBgr.getScaledInstance(Mf.getJframeWidth(), Mf.getJframeHeight(), Image.SCALE_SMOOTH);
        // ImageIcon scaledImageIcon = new ImageIcon(newImageBgr);

        // Tạo một JLabel để chứa hình ảnh và thêm nó vào contentPane
        JLabel background = new JLabel();
        background.setBounds(0, 0, Mf.getJframeWidth(), Mf.getJframeHeight());
        // Thêm JLabel vào content pane với BorderLayout
        // thirdMapModel.getThirdMapPanel().add(background);

        // Tạo một JPanel để chứa các thành phần khác
        thirdMapModel.getChildThirdMapPanel().setSize(Mf.getJframeWidth(), Mf.getJframeHeight());
        thirdMapModel.getChildThirdMapPanel().setLayout(null); // Set layout thành null để có thể đặt vị trí tự do
        thirdMapModel.getChildThirdMapPanel().setOpaque(false);

        // Set hình nền cho trái tim, set up trái tim
        this.thirdMapModel.getHeart().setSize(20, 20);
        ImageIcon objHeart = new ImageIcon("picture\\traitym.png");
        Image imgHeart = objHeart.getImage();
        Image newImageHeart = imgHeart.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        thirdMapModel.setNewImageIconHeart(new ImageIcon(newImageHeart));
        this.thirdMapModel.getHeart().setIcon(thirdMapModel.getNewImageIconHeart());

        // Set size cho các obj
        for (int i = 0; i < thirdMapModel.getN(); i++) {
            this.thirdMapModel.getObj()[i] = new JLabel();
            this.thirdMapModel.getObj()[i].setSize(15, 15);
        }

        // Đặt hình nền cho obj
        ImageIcon objBgr = new ImageIcon("picture\\Book.png");
        Image img = objBgr.getImage();
        Image newImage = img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        thirdMapModel.setNewImageIcon(new ImageIcon(newImage));

        for (int i = 0; i < thirdMapModel.getN(); i++) {
            this.thirdMapModel.getObj()[i].setIcon(thirdMapModel.getNewImageIcon());
        }

        // Đặt vị trí của các obj trên background
        try {
            Scanner sc = new Scanner(new FileInputStream(new File("./InputFiletxt/bookMap2.txt")));
            int i = 0; // Sử dụng biến i để xác định vị trí của mỗi JLabel trong mảng obj[]
            while (sc.hasNextInt()) {
                int p = sc.nextInt();
                int q = sc.nextInt();

                if (i < thirdMapModel.getN()) { // Đảm bảo rằng i không vượt quá số lượng JLabel trong mảng obj[]
                    thirdMapModel.getX()[i] = p;
                    thirdMapModel.getY()[i] = q;
                    i++; // Tăng biến i lên để đến JLabel tiếp theo trong mảng obj[]
                }
            }
            sc.close(); // Đóng luồng sau khi sử dụng xong.
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // In ra lỗi nếu tệp tin không được tìm thấy
        }

        // add obj vào map
        for (int i = 0; i < thirdMapModel.getN(); i++) {
            thirdMapModel.getObj()[i].setLocation(thirdMapModel.getX()[i], thirdMapModel.getY()[i]); // Thiết lập vị
                                                                                                        // trí của
                                                                                                        // JLabel thứ i
            thirdMapModel.getChildThirdMapPanel().add(thirdMapModel.getObj()[i]); // Thêm JLabel vào
                                                                                     // childSecondMapPanel
            thirdMapModel.setAddObj(true, i);
        }

        // Thêm trái tim vào map
        this.thirdMapModel.getHeart().setLocation(thirdMapModel.getHeartXLocation(),
                thirdMapModel.getHeartYLocation());
        thirdMapModel.getChildThirdMapPanel().add(thirdMapModel.getHeart());
        thirdMapModel.setAddHeart(true);
        tilePanel.add(thirdMapModel.getChildThirdMapPanel());

        // *****************************************************/
        thirdMapModel.getMapLabel3().setFont(new Font("Arial", Font.BOLD, 45));
        thirdMapModel.getMapLabel3().setForeground(Color.BLACK);
        thirdMapModel.getMapLabel3()
                .setPreferredSize(new Dimension(thirdMapModel.getMapLabel3().getPreferredSize().width + 20,
                        thirdMapModel.getMapLabel3().getPreferredSize().height));
        int labelX = (Mf.getJframeWidth() - thirdMapModel.getMapLabel3().getPreferredSize().width) / 2;
        int labelY = (Mf.getJframeHeight() - thirdMapModel.getMapLabel3().getPreferredSize().height) / 2;
        thirdMapModel.getMapLabel3().setBounds(labelX, labelY, thirdMapModel.getMapLabel3().getPreferredSize().width,
                thirdMapModel.getMapLabel3().getPreferredSize().height);
        thirdMapModel.getChildThirdMapPanel().add(thirdMapModel.getMapLabel3());

        tilePanel.setBounds(0,0,615,615);

        thirdMapModel.getLayeredPane().add(thirdMapModel.getChildThirdMapPanel());
        thirdMapModel.getLayeredPane().add(tilePanel);

        thirdMapModel.getThirdMapPanel().add(thirdMapModel.getLayeredPane());
        // Thêm lắng nghe sự kiện MouseListener vào JLabel background
        
    }
}