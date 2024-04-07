package View.StateView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Model.GameModel.GameModel;
import Model.StateModel.FirstMapModel;
import main.MyFrame;

public class FirstMapView {
    GameModel Mf;
    FirstMapModel firstMapModel;

    public FirstMapView(GameModel Mf, FirstMapModel firstMapModel){
        this.Mf = Mf;
        this.firstMapModel = firstMapModel;

        //set up panel
       firstMapModel.getFirstMapPanel().setSize( Mf.getJframeWidth(), Mf.getJframeHeight());
       firstMapModel.getFirstMapPanel().setBounds(0, 0, Mf.getJframeWidth(), Mf.getJframeHeightParent());
       firstMapModel.getFirstMapPanel().setLayout(null);
       
       // Đặt hình nền cho First Map
        ImageIcon imageIcon = new ImageIcon("./picture/Map1.png");

        Image imgBgr = imageIcon.getImage();
        Image newImageBgr = imgBgr.getScaledInstance(Mf.getJframeWidth(), Mf.getJframeHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(newImageBgr);

        // Tạo một JLabel để chứa hình ảnh và thêm nó vào contentPane
        JLabel background = new JLabel(scaledImageIcon);
        background.setBounds(0,0,Mf.getJframeWidth(),Mf.getJframeHeight());
        // Thêm JLabel vào content pane với BorderLayout
        firstMapModel.getFirstMapPanel().add(background);

        // Tạo một JPanel để chứa các thành phần khác
        firstMapModel.getChildFirstMapPanel().setSize(Mf.getJframeWidth(), Mf.getJframeHeight());
        firstMapModel.getChildFirstMapPanel().setLayout(null); // Set layout thành null để có thể đặt vị trí tự do
        firstMapModel.getChildFirstMapPanel().setOpaque(false);

        // Set size cho các obj
        for (int i = 0; i < firstMapModel.getN(); i++) {
            this.firstMapModel.getObj()[i] = new JLabel();
            this.firstMapModel.getObj()[i].setSize(15, 15);
        }

        // Đặt hình nền cho obj
        ImageIcon objBgr = new ImageIcon("picture\\Book.png");
        Image img = objBgr.getImage();
        Image newImage = img.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon newImageIcon = new ImageIcon(newImage);

        // Set hình nền cho trái tim, set up trái tim
        this.firstMapModel.getHeart().setSize(20, 20);
        ImageIcon objHeart = new ImageIcon("picture\\traitym.png");
        Image imgHeart = objHeart.getImage();
        Image newImageHeart = imgHeart.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon newImageIconHeart = new ImageIcon(newImageHeart);
        this.firstMapModel.getHeart().setIcon(newImageIconHeart);

        for (int i = 0; i <firstMapModel.getN(); i++) {
            this.firstMapModel.getObj()[i].setIcon(newImageIcon);
        }

        // Đặt vị trí của các obj trên background
        try {
            Scanner sc = new Scanner(new FileInputStream(new File("./InputFiletxt/bookMap1.txt")));
            int i = 0; // Sử dụng biến i để xác định vị trí của mỗi JLabel trong mảng obj[]
            while (sc.hasNextInt()) {
                int p = sc.nextInt();
                int q = sc.nextInt();

                if (i < firstMapModel.getN()) { // Đảm bảo rằng i không vượt quá số lượng JLabel trong mảng obj[]
                    firstMapModel.getX()[i] = p;
                    firstMapModel.getY()[i] = q;
                    i++; // Tăng biến i lên để đến JLabel tiếp theo trong mảng obj[]
                }
            }
            sc.close(); // Đóng luồng sau khi sử dụng xong.
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // In ra lỗi nếu tệp tin không được tìm thấy
        }

        for (int i = 0; i < firstMapModel.getN(); i++) {
          firstMapModel.getObj()[i].setLocation(firstMapModel.getX()[i], firstMapModel.getY()[i]); // Thiết lập vị trí của JLabel thứ i
          firstMapModel.getChildFirstMapPanel().add(firstMapModel.getObj()[i]); // Thêm JLabel vào childFirstMapPanel
          firstMapModel.setAddObj(true, i);
        }

        // Thêm trái tim vào map
        this.firstMapModel.getHeart().setLocation(firstMapModel.getHeartXLocation(), firstMapModel.getHeartYLocation());
        firstMapModel.getChildFirstMapPanel().add(firstMapModel.getHeart());
        firstMapModel.setAddHeart(true);
        background.add(firstMapModel.getChildFirstMapPanel());

        //*****************************************************/
        firstMapModel.getMapLabel().setFont(new Font("Arial", Font.BOLD, 45));
        firstMapModel.getMapLabel().setForeground(Color.BLACK);
        firstMapModel.getMapLabel().setPreferredSize(new Dimension(firstMapModel.getMapLabel().getPreferredSize().width + 20, firstMapModel.getMapLabel().getPreferredSize().height));
        int labelX = (Mf.getJframeWidth() - firstMapModel.getMapLabel().getPreferredSize().width) / 2;
        int labelY = (Mf.getJframeHeight() - firstMapModel.getMapLabel().getPreferredSize().height) / 2;
        firstMapModel.getMapLabel().setBounds(labelX, labelY, firstMapModel.getMapLabel().getPreferredSize().width, firstMapModel.getMapLabel().getPreferredSize().height);
        firstMapModel.getChildFirstMapPanel().add(firstMapModel.getMapLabel());
    }
}
