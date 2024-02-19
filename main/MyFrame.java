package main;

import java.awt.CardLayout;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Sound.SoundEffect;
import State.*;
import entity.Player.*;

public class MyFrame extends JFrame implements ActionListener, Runnable {
    PlayerMove playermove = new PlayerMove();
    Player player = new Player(this, playermove);
    SoundEffect sound = new SoundEffect();
    Thread gameThread;
    
    String nameCardLayout;

    int FPS = 60;
    JPanel cardPanel; // Use JPanel instead of JLayeredPane

    // Tạo các object để sử dụng các biến của chúng
    Intro intro = new Intro();
    Trailer trailer = new Trailer();
    FirstMap firstMap = new FirstMap();
    SecondMap secondMap = new SecondMap();
    ThirdMap thirdMap = new ThirdMap();

    
    CardLayout cardLayout = new CardLayout();
    

    MyFrame() {

        cardPanel = new JPanel(); // Use JPanel instead of JLayeredPane
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
        nameCardLayout = "Intro";
        cardLayout.show(cardPanel, nameCardLayout);

        // Setup Jframe
       this.init();
        // Thêm ActionListener cho nút "Start" trong Intro
        intro.Start.addActionListener(this);

        // Thêm ActionListener cho nút "Exit" trong Intro
        intro.Exit.addActionListener(this);

       
      

     
        
    }
    //Hàm setup các dữ liệu ban đầu của jframe
    public void init(){
        ImageIcon logo = new ImageIcon("./picture/logo.jpg");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(615, 615);
        this.setTitle("Journey to Adulthood");
        this.setIconImage(logo.getImage());
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.add(cardPanel);
        this.addKeyListener(playermove);
        this.setFocusable(true);
        this.StartGame();
         // BẮT ĐẦU ÂM THANH CHO MAP phần đầu tiên
        startSound(0);
        this.setVisible(true);
    }
    //Hàm viết logic các nút bấm
    @Override
    public void actionPerformed(ActionEvent e) {
        // Xử lý sự kiện khi nút "Start" được nhấn
        if (e.getSource() == intro.Start) {
            // Dừng và thoát âm thanh hiện tại
            stopSound();
            // Chuyển sang cửa sổ Trailer
            nameCardLayout = "Trailer";
            cardLayout.show(cardPanel, nameCardLayout);

        }
        // Xử lý sự kiện khi nút "Exit" được nhấn
        else if (e.getSource() == intro.Exit) {
            // Thoát ứng dụng
            // Tạo 1 bảng thông báo để xác nhận có muốn thoát k ,nếu có thì thoát
            int exitis = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát", "Xác nhận",
                    JOptionPane.YES_NO_OPTION);
            if (exitis == 0) {
                System.exit(exitis);
            }
        }
    }

    // Các hàm để sử dụng sound
    public void startSound(int i) {
        sound.setFile(i);
        sound.start();
        sound.loop();
    }

    public void stopSound() {
        sound.stop();
        sound.close();
    }
  //Hàm để sử dụng gameloop
    public void StartGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }
//Tạo hệ thống game loop để làm animation cho nhân vật với 60 khung hình trên giây
    @Override
    public void run() {
        double drawInteval=1000000000/FPS;
        double delta=0;
        long lastTime=System.nanoTime();
        long currentTime;
        while (gameThread !=null) {
            currentTime=System.nanoTime();
            delta += (currentTime-lastTime)/drawInteval;
            lastTime=currentTime;
            if (delta>=1) {
                update();
                repaint();
                delta--;
            }
        }
        
    }
  //Hàm để update chuyển động ,tọa độ khi nhân vật di chuyển
    public void update() {
        player.update();
    }
 //hàm vẽ nhân vật
    public void paint(Graphics g) {

        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;
        player.draw(g2);
        g2.dispose();
    }

}
