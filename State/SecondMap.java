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

public class SecondMap extends Map {
    private ImageIcon newImageIcon;
    private ImageIcon newImageIconHeart;
    private int heartXLocation = 556, heartYLocation = 305;
    private JPanel secondMapPanel;
    private JPanel childSecondMapPanel;
    private boolean addHeart= true;
    private boolean removeHeart= false;
    private JLabel heart;
    private int x[] = new int[n];
    private int y[] = new int[n];
    MyFrame Mf;
    public SecondMap(MyFrame Mf) {
        this.Mf=Mf;
        // Set layout cho map
        secondMapPanel = new JPanel();
        secondMapPanel.setBounds(0, 0, Mf.jframeWidth, Mf.jframeHeightParent);
        secondMapPanel.setLayout(null);

        // Dịch chuyển hình nền lên 27 pixel từ dưới lên
        // secondMapPanel.setBorder(BorderFactory.createEmptyBorder(-27, 0, 0, 0));
        // Đặt hình nền cho Second Map
        ImageIcon imageIcon = new ImageIcon("./picture/Map2.png");

        Image imgBgr = imageIcon.getImage();
        Image newImageBgr = imgBgr.getScaledInstance(Mf.jframeWidth, Mf.jframeHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(newImageBgr);

        // // Tạo một JLabel để chứa hình ảnh và thêm nó vào contentPane
        JLabel background = new JLabel(scaledImageIcon);
        background.setBounds(0,0,Mf.jframeWidth,Mf.jframeHeight);
        // Thêm JLabel vào content pane với BorderLayout
        secondMapPanel.add(background);

        // Tạo một JPanel để chứa các thành phần khác
        childSecondMapPanel = new JPanel();
        childSecondMapPanel.setSize(Mf.jframeWidth, Mf.jframeHeight);
        childSecondMapPanel.setLayout(null); // Set layout thành null để có thể đặt vị trí tự do
        childSecondMapPanel.setOpaque(false);

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
            Scanner sc = new Scanner(new FileInputStream(new File("./InputFiletxt/bookMap2.txt")));
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
            childSecondMapPanel.add(obj[i]); // Thêm JLabel vào childSecondMapPanel
            addObj[i]=true;
        }

        // Thêm trái tim vào map
       
        this.heart.setLocation(heartXLocation, heartYLocation);
        childSecondMapPanel.add(heart);
       addHeart=true;
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

    
//  Generat get and set

	public ImageIcon getNewImageIcon() {
		return newImageIcon;
	}

	public void setNewImageIcon(ImageIcon newImageIcon) {
		this.newImageIcon = newImageIcon;
	}

	public ImageIcon getNewImageIconHeart() {
		return newImageIconHeart;
	}

	public void setNewImageIconHeart(ImageIcon newImageIconHeart) {
		this.newImageIconHeart = newImageIconHeart;
	}

	public int getHeartXLocation() {
		return heartXLocation;
	}

	public void setHeartXLocation(int heartXLocation) {
		this.heartXLocation = heartXLocation;
	}

	public int getHeartYLocation() {
		return heartYLocation;
	}

	public void setHeartYLocation(int heartYLocation) {
		this.heartYLocation = heartYLocation;
	}

	public JPanel getSecondMapPanel() {
		return secondMapPanel;
	}

	public void setSecondMapPanel(JPanel secondMapPanel) {
		this.secondMapPanel = secondMapPanel;
	}

	public JPanel getChildSecondMapPanel() {
		return childSecondMapPanel;
	}

	public void setChildSecondMapPanel(JPanel childSecondMapPanel) {
		this.childSecondMapPanel = childSecondMapPanel;
	}
    public JLabel[] getObj() {
		return obj;
	}
	public boolean isAddHeart() {
		return addHeart;
	}

	public void setAddHeart(boolean addHeart) {
		this.addHeart = addHeart;
	}

	public boolean isRemoveHeart() {
		return removeHeart;
	}

	public void setRemoveHeart(boolean removeHeart) {
		this.removeHeart = removeHeart;
	}

	public JLabel getHeart() {
		return heart;
	}

	public void setHeart(JLabel heart) {
		this.heart = heart;
	}

	public int[] getX() {
		return x;
	}

	public void setX(int[] x) {
		this.x = x;
	}

	public int[] getY() {
		return y;
	}

	public void setY(int[] y) {
		this.y = y;
	}

    public MyFrame getMf() {
        return Mf;
    }

    public void setMf(MyFrame mf) {
        Mf = mf;
    }
}
