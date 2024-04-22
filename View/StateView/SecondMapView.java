package View.StateView;

import Model.GameModel.GameModel;
import Model.StateModel.SecondMapModel;

import View.StateView.FirstMapView.MyMouseListener;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SecondMapView {
    GameModel Mf;
    SecondMapModel secondMapModel;
    View.TileView.TileManager tileManager;
    JLayeredPane layeredPane;
    public SecondMapView(GameModel Mf, SecondMapModel secondMapModel) {
        this.Mf = Mf;
        this.secondMapModel = secondMapModel;

        tileManager = new View.TileView.TileManager(Mf);
        View.TileView.TilePanel tilePanel = new View.TileView.TilePanel(Mf, tileManager);

        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, Mf.getJframeWidth(), Mf.getJframeHeightParent());
        
        // Set layout cho map
        secondMapModel.getSecondMapPanel().setSize(Mf.getJframeWidth(), Mf.getJframeHeight());
        secondMapModel.getSecondMapPanel().setBounds(0, 0, Mf.getJframeWidth(), Mf.getJframeHeightParent());
        secondMapModel.getSecondMapPanel().setLayout(null);

        // Đặt hình nền cho Second Map
        // ImageIcon imageIcon = new ImageIcon("./picture/Map2.png");

        // Image imgBgr = imageIcon.getImage();
        // Image newImageBgr = imgBgr.getScaledInstance(Mf.getJframeWidth(), Mf.getJframeHeight(), Image.SCALE_SMOOTH);
        // ImageIcon scaledImageIcon = new ImageIcon(newImageBgr);

        // Tạo một JLabel để chứa hình ảnh và thêm nó vào contentPane
        JLabel background = new JLabel();
        background.setBounds(0, 0, Mf.getJframeWidth(), Mf.getJframeHeight());
        // Thêm JLabel vào content pane với BorderLayout
        // secondMapModel.getSecondMapPanel().add(background);

        // Tạo một JPanel để chứa các thành phần khác
        secondMapModel.getChildSecondMapPanel().setSize(Mf.getJframeWidth(), Mf.getJframeHeight());
        secondMapModel.getChildSecondMapPanel().setLayout(null); // Set layout thành null để có thể đặt vị trí tự do
        secondMapModel.getChildSecondMapPanel().setOpaque(false);

        // Set hình nền cho trái tim, set up trái tim
        this.secondMapModel.getHeart().setSize(20, 20);
        ImageIcon objHeart = new ImageIcon("picture\\traitym.png");
        Image imgHeart = objHeart.getImage();
        Image newImageHeart = imgHeart.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        secondMapModel.setNewImageIconHeart(new ImageIcon(newImageHeart));
        this.secondMapModel.getHeart().setIcon(secondMapModel.getNewImageIconHeart());

        // Set size cho các obj
        for (int i = 0; i < secondMapModel.getN(); i++) {
            this.secondMapModel.getObj()[i] = new JLabel();
            this.secondMapModel.getObj()[i].setSize(15, 15);
        }

        // Đặt hình nền cho obj
        ImageIcon objBgr = new ImageIcon("picture\\Book.png");
        Image img = objBgr.getImage();
        Image newImage = img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        secondMapModel.setNewImageIcon(new ImageIcon(newImage));

        for (int i = 0; i < secondMapModel.getN(); i++) {
            this.secondMapModel.getObj()[i].setIcon(secondMapModel.getNewImageIcon());
        }

        // Đặt vị trí của các obj trên background
        try {
            Scanner sc = new Scanner(new FileInputStream(new File("./InputFiletxt/bookMap2.txt")));
            int i = 0; // Sử dụng biến i để xác định vị trí của mỗi JLabel trong mảng obj[]
            while (sc.hasNextInt()) {
                int p = sc.nextInt();
                int q = sc.nextInt();

                if (i < secondMapModel.getN()) { // Đảm bảo rằng i không vượt quá số lượng JLabel trong mảng obj[]
                    secondMapModel.getX()[i] = p;
                    secondMapModel.getY()[i] = q;
                    i++; // Tăng biến i lên để đến JLabel tiếp theo trong mảng obj[]
                }
            }
            sc.close(); // Đóng luồng sau khi sử dụng xong.
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // In ra lỗi nếu tệp tin không được tìm thấy
        }

        // add obj vào map
        for (int i = 0; i < secondMapModel.getN(); i++) {
            secondMapModel.getObj()[i].setLocation(secondMapModel.getX()[i], secondMapModel.getY()[i]); // Thiết lập vị
                                                                                                        // trí của
                                                                                                        // JLabel thứ i
            secondMapModel.getChildSecondMapPanel().add(secondMapModel.getObj()[i]); // Thêm JLabel vào
                                                                                     // childSecondMapPanel
            secondMapModel.setAddObj(true, i);
        }

        // Thêm trái tim vào map
        this.secondMapModel.getHeart().setLocation(secondMapModel.getHeartXLocation(),
                secondMapModel.getHeartYLocation());
        secondMapModel.getChildSecondMapPanel().add(secondMapModel.getHeart());
        secondMapModel.setAddHeart(true);
        tilePanel.add(secondMapModel.getChildSecondMapPanel());

        // *****************************************************/
        secondMapModel.getMapLabel2().setFont(new Font("Arial", Font.BOLD, 45));
        secondMapModel.getMapLabel2().setForeground(Color.BLACK);
        secondMapModel.getMapLabel2()
                .setPreferredSize(new Dimension(secondMapModel.getMapLabel2().getPreferredSize().width + 20,
                        secondMapModel.getMapLabel2().getPreferredSize().height));
        int labelX = (Mf.getJframeWidth() - secondMapModel.getMapLabel2().getPreferredSize().width) / 2;
        int labelY = (Mf.getJframeHeight() - secondMapModel.getMapLabel2().getPreferredSize().height) / 2;
        secondMapModel.getMapLabel2().setBounds(labelX, labelY, secondMapModel.getMapLabel2().getPreferredSize().width,
                secondMapModel.getMapLabel2().getPreferredSize().height);
        secondMapModel.getChildSecondMapPanel().add(secondMapModel.getMapLabel2());
        
        tilePanel.setBounds(0,0,615,615);
        
        layeredPane.add(secondMapModel.getChildSecondMapPanel());
        layeredPane.add(tilePanel);
        
        secondMapModel.getSecondMapPanel().add(layeredPane);
        // Thêm lắng nghe sự kiện MouseListener vào JLabel background
        tilePanel.addMouseListener(new MyMouseListener());
    }
     // Lớp lắng nghe sự kiện MouseListener
     class MyMouseListener implements MouseListener {
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
