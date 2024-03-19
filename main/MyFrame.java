package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import EndingUi.BadEnding;
import EndingUi.HappyEnding;
import Sound.SoundEffect;
import State.*;
import entity.Monster.Monster;
import entity.Player.*;
import Function.*;
// import javax.swing.JLabel;
import java.awt.*;

public class MyFrame extends JFrame implements ActionListener, Runnable {
    private PlayerMove playermove = new PlayerMove();
    private Player player = new Player(this, playermove);
    private Monster monster = new Monster(this);
     
    private SignIn_Up Login;
    private SoundEffect soundMain = new SoundEffect();
    private SoundEffect soundInternal = new SoundEffect();
    private SoundEffect soundNext = new SoundEffect();
   
    Thread gameThread;
    
   JLabel scoreLabel;
  
    private JPanel cardPanel; // Use JPanel instead of JLayeredPane

    
    private String nameCardLayout;
    private int score = 15000;
    private int jframeWidth = 615, jframeHeight = 615;
    private int jframeHeightParent = 690;
    private int countFoot = 0;
    private int FPS = 60;
   
    
    // Tạo các object để sử dụng các biến của chúng
    private Intro intro = new Intro(this);
    private Trailer trailer = new Trailer(this);
    private FirstMap firstMap = new FirstMap(this);
    private SecondMap secondMap = new SecondMap(this);
    private ThirdMap thirdMap = new ThirdMap(this);
    private BadEnding badEnding = new BadEnding();
    private HappyEnding happyEnding = new HappyEnding();

    private CardLayout cardLayout = new CardLayout();

    MyFrame() {
 
       
        cardPanel = new JPanel(); // Use JPanel instead of JLayeredPane
        cardPanel.setBounds(0, 0, jframeWidth, jframeHeightParent);

        // Sử dụng CardLayout cho cardPanel
        cardPanel.setLayout(cardLayout);

        // Thêm các panel vào cardPanel với tên đặc biệt
        cardPanel.add(thirdMap.getThirdMapPanel(), "ThirdMap");
        cardPanel.add(secondMap.getSecondMapPanel(), "SecondMap");
        cardPanel.add(firstMap.getFirstMapPanel(), "FirstMap");
        cardPanel.add(trailer.getTrailerPanel(), "Trailer");
        cardPanel.add(intro.getIntroPanel(), "Intro");
        cardPanel.add(badEnding.getBadEndingPanelSum(), "BadEnding");
        cardPanel.add(happyEnding.getHappyEndingPanelSum(), "HappyEnding");
        
        // Khởi tạo label cho điểm số và thêm vào panel
        scoreLabel = new JLabel();
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Điều chỉnh font và kích thước chữ
        scoreLabel.setForeground(Color.BLACK); // Điều chỉnh màu chữ
        // Đặt vị trí của scoreLabel
        scoreLabel.setBounds(50, 620, 100, 20); // Đặt ở góc trái dưới
        
        // Thể hiện thẻ đầu tiên (ở đây là Intro)
        nameCardLayout = "Intro";
        cardLayout.show(cardPanel, nameCardLayout);
        // Thêm sound cho phần intro
        if (nameCardLayout == "Intro") {
            soundMain.setFile(0);
            soundMain.start();
            soundMain.loop();
        }
        // Setup Jframe
       
        this.init();
        

            // Thêm ActionListener cho nút "Start" trong Intro
            intro.getStart().addActionListener(this);

            // Thêm ActionListener cho nút "Exit" trong Intro
            intro.getExit().addActionListener(this);


        // Thêm ActionListener cho nút "nextButton" trong Intro
        trailer.getNextButton().addActionListener(this);
       
        badEnding.getButtonEnding().getYesButton().addActionListener(this);
        badEnding.getButtonEnding().getNoButton().addActionListener(this);

        happyEnding.getButtonEnding().getYesButton().addActionListener(this);
        happyEnding.getButtonEnding().getNoButton().addActionListener(this);

        
    }

   

    // Hàm setup các dữ liệu ban đầu của jframe
    public void init() {
        ImageIcon logo = new ImageIcon("./picture/logo.jpg");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(jframeWidth, jframeHeightParent);
        this.setTitle("Journey to Adulthood");
        this.setIconImage(logo.getImage());
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.add(cardPanel);
        this.addKeyListener(playermove);
        this.setFocusable(true);
        this.StartGame();
        this.setVisible(true);
         Login=new SignIn_Up(this);
    }

    // Hàm viết logic các nút bấm
    @Override
    public void actionPerformed(ActionEvent e) {
        // Xử lý sự kiện khi nút "Start" được nhấn
        if (e.getSource() == intro.getStart()) {
           if (Login.isOutDialog()==true) {
             // Dừng âm thanh hiện tại
             soundMain.stop();
             // Chuyển sang cửa sổ Trailer
             nameCardLayout = "Trailer";
             cardLayout.show(cardPanel, nameCardLayout);
             trailer.getTimer().start();
 
             // Thay đổi âm thanh phần intro thành trailer
             soundMain.setFile(2);
             ;
             soundMain.start();
             // Tạo và bắt đầu sử dụng âm thanh gõ phím
             soundInternal.setFile(1);
             soundInternal.start();
             soundInternal.loop();
             // } else if (e.getSource() == trailer.skipButton) {
             // // Dừng âm thanh gõ phím
             // soundInternal.stop();
           }
        } else if (e.getSource() == trailer.getNextButton()) {
            // Dừng âm thanh phần trailer
            soundInternal.stop();
            soundMain.stop();
            nameCardLayout = "FirstMap";
            cardLayout.show(cardPanel, nameCardLayout);

            // Thay đổi âm thanh Trailer sang âm thanh của map
            soundMain.setFile(3);
            soundMain.start();
            soundMain.loop();
            // Tạo âm thanh ăn vật phẩm
            soundInternal.setFile(4);
        }

        else if (e.getSource() == badEnding.getButtonEnding().getYesButton()
                || e.getSource() == happyEnding.getButtonEnding().getYesButton()) {
            Reset.ResetAll(this);
        }
        // Xử lý sự kiện khi nút "Exit" được nhấn
        else if (e.getSource() == intro.getExit() || e.getSource() == badEnding.getButtonEnding().getNoButton()
                || e.getSource() == happyEnding.getButtonEnding().getNoButton()) {
            // Thoát ứng dụng
            // Tạo 1 bảng thông báo để xác nhận có muốn thoát k ,nếu có thì thoát
            int exitis = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát", "Xác nhận",
                    JOptionPane.YES_NO_OPTION);
            if (exitis == 0) {
                System.exit(exitis);
            }
        }
    }

    // Hàm để sử dụng gameloop
    public void StartGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    // Tạo hệ thống game loop để làm animation cho nhân vật với 60 khung hình trên
    // giây
    @Override
    public void run() {
        double drawInteval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInteval;
            lastTime = currentTime;
            if (delta >= 1) {
                // Vào map mới bắt đầu cho nhân vật ,quái chạy thực hiện logic
                if (nameCardLayout == "FirstMap" || nameCardLayout == "SecondMap" || nameCardLayout == "ThirdMap") {
                    update();
                    Transform.getTransform(this);
                    EatBook.getEatBooks(this);
                    PlayerVsMove.PlayerVsMonster(this);
                    updateScoreLabel();
                    NextMap.nextMap(this);
                    if (nameCardLayout == "ThirdMap") {
                        Function.Ending.finalEnding(this);
                    }
                }
                repaint();
                delta--;
            }

        }
    }

    // Hàm để update chuyển động ,tọa độ khi nhân vật ,monster di chuyển
    public void update() {
        player.update();
        monster.running();
        countFoot++;

    }


     // Phương thức để cập nhật điểm số trên scoreLabel
     public void updateScore() {
        scoreLabel.setText("Score: " + score);
    }
     // Phương thức để cập nhật scoreLabel vào JPanel dựa trên giá trị của
    // nameCardLayout
   
   
    public void updateScoreLabel() {
        switch (nameCardLayout) {
            case "FirstMap":
                firstMap.getFirstMapPanel().add(scoreLabel);
                break;
            case "SecondMap":
                secondMap.getSecondMapPanel().add(scoreLabel);
                break;
            case "ThirdMap":
                thirdMap.getThirdMapPanel().add(scoreLabel);
                break;

        }
    }
    // hàm vẽ nhân vật
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        if (nameCardLayout == "FirstMap" || nameCardLayout == "SecondMap" || nameCardLayout == "ThirdMap") {
            player.draw(g2);
            monster.draw(g2);
            repaint();
        }
        g2.dispose();

    }
   //getter
    public String getNameCardLayout() {
        return nameCardLayout;
    }

   
    public HappyEnding getHappyEnding() {
        return happyEnding;
    }

    public BadEnding getBadEnding() {
        return badEnding;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getCardPanel() {
        return cardPanel;
    }

    public SoundEffect getSoundMain() {
        return soundMain;
    }

    public SoundEffect getSoundInternal() {
        return soundInternal;
    }

    public SoundEffect getSoundNext() {
        return soundNext;
    }

    public Player getPlayer() {
        return player;
    }

    public FirstMap getFirstMap() {
        return firstMap;
    }

    public SecondMap getSecondMap() {
        return secondMap;
    }

    public ThirdMap getThirdMap() {
        return thirdMap;
    }

    public int getScore() {
        return score;
    }

    

    public Monster getMonster() {
        return monster;
    }

    public PlayerMove getPlayermove() {
        return playermove;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public int getCountFoot() {
        return countFoot;
    }

  

    public int getJframeWidth() {
        return jframeWidth;
    }

    public int getJframeHeight() {
        return jframeHeight;
    }

    public int getJframeHeightParent() {
        return jframeHeightParent;
    }

    //Setter
    public void setNameCardLayout(String nameCardLayout) {
        this.nameCardLayout = nameCardLayout;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public void setCountFoot(int countFoot) {
        this.countFoot = countFoot;
    }
}
