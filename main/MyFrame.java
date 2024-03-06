package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

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
    PlayerMove playermove = new PlayerMove();
    private Player player = new Player(this, playermove);
    private SoundEffect soundMain = new SoundEffect();
    
    private  SoundEffect soundInternal = new SoundEffect();
    private SoundEffect soundNext = new SoundEffect();
    private Monster monster = new Monster(this);
   
    Thread gameThread;
    JLabel scoreLabel;
    String Ending;
    private String nameCardLayout;
    private int score = 0;
    public int jframeWidth = 615, jframeHeight = 615;
    public int jframeHeightParent = 690;
    public int countFoot = 0;
    private int FPS = 60;
    private JPanel cardPanel; // Use JPanel instead of JLayeredPane

   private BadEnding badEnding=new BadEnding();
    private HappyEnding happyEnding = new HappyEnding();
    // Tạo các object để sử dụng các biến của chúng
    Intro intro = new Intro(this);
    Trailer trailer = new Trailer(this);
    FirstMap firstMap = new FirstMap(this);
    SecondMap secondMap = new SecondMap(this);
    ThirdMap thirdMap = new ThirdMap(this);

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
        cardPanel.add(trailer.trailerPanel, "Trailer");
        cardPanel.add(intro.introPanel, "Intro");
        cardPanel.add(badEnding.getBadEndingPanelSum(), "BadEnding");
        cardPanel.add(happyEnding.getHappyEndingPanelSum(), "HappyEnding");
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
        intro.Start.addActionListener(this);

        // Thêm ActionListener cho nút "Exit" trong Intro
        intro.Exit.addActionListener(this);

        // Thêm ActionListener cho nút "nextButton" trong Intro
        trailer.nextButton.addActionListener(this);
        // Thêm ActionListener cho nút "skipButton" trong Intro
        // trailer.skipButton.addActionListener(this);
        
        badEnding.getButtonEnding().getYesButton().addActionListener(this);
        badEnding.getButtonEnding().getNoButton().addActionListener(this);

        happyEnding.getButtonEnding().getYesButton().addActionListener(this);
        happyEnding.getButtonEnding().getNoButton().addActionListener(this);
       
        //Khởi tạo label cho điểm số và thêm vào panel
        scoreLabel = new JLabel();
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Điều chỉnh font và kích thước chữ
        scoreLabel.setForeground(Color.BLACK); // Điều chỉnh màu chữ
        // Đặt vị trí của scoreLabel
        scoreLabel.setBounds(50, 620, 100, 20); // Đặt ở góc trái dưới
    }

    //Phương thức để cập nhật điểm số trên scoreLabel
    public void updateScore() {
        scoreLabel.setText("Score: " + score);
    }

    //Phương thức để cập nhật scoreLabel vào JPanel dựa trên giá trị của nameCardLayout
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
    }
    // Hàm viết logic các nút bấm
    @Override
    public void actionPerformed(ActionEvent e) {
        // Xử lý sự kiện khi nút "Start" được nhấn
        if (e.getSource() == intro.Start) {
            // Dừng âm thanh hiện tại
            soundMain.stop();
            // Chuyển sang cửa sổ Trailer
            nameCardLayout = "Trailer";
            cardLayout.show(cardPanel, nameCardLayout);
            trailer.timer.start();


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
        } else if (e.getSource() == trailer.nextButton) {
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

        
        else if(e.getSource()==badEnding.getButtonEnding().getYesButton() || e.getSource()==happyEnding.getButtonEnding().getYesButton()){
            Reset();
        }
        // Xử lý sự kiện khi nút "Exit" được nhấn
        else if (e.getSource() == intro.Exit || e.getSource()==badEnding.getButtonEnding().getNoButton() || e.getSource()==happyEnding.getButtonEnding().getNoButton()) {
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
                    getEatBooks();
                    PlayerVsMonster();
                    updateScoreLabel();
                    nextMap();
                }

                if(nameCardLayout == "ThirdMap") {
                    finalEnding();
                    
                    
                }
                // if (countFoot>=500) {
                //     nameCardLayout="SecondMap";
                //     cardLayout.show(cardPanel, nameCardLayout);
                // }
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

    

    // chuyển Map1-->2
    public void nextMap() {
        int x= player.PlayerPositionX;
        int y = player.PlayerPositionY;
        boolean next=false;
        if (nameCardLayout=="SecondMap" || nameCardLayout=="FirstMap") {
            if (nameCardLayout=="SecondMap" && score >=6000) {
                soundMain.stop();
                happyEnding.setNumberHappy(1);
                Function.Ending.HappyEnding(this, happyEnding.getNumberHappy());
            }
            if (x >= 612 && (y > 209 && y < 300)  && nameCardLayout == "FirstMap"){
                nameCardLayout="SecondMap";
                next=true;
            }
            if (x >= 596 && (y > 272 && y < 318)  && nameCardLayout == "SecondMap"){
               nameCardLayout="ThirdMap";
               next=true;
            }
            if(next==true){
                // Hàm chạy thời gian third map
                ThirdMap.updateTimer(10);
                ThirdMap.getTimerThirdMap().start(); 
                cardLayout.show(cardPanel, nameCardLayout);
                player.PlayerPositionX = 1; 
                player.PlayerPositionY = 315;
                countFoot = 0;
                monster.getMonsterImage();
                monster.setDefaultMonster();
               
                monster.xDice= 322; monster.yDice= 295;
                monster.xJoystick=379; monster.yJoystick=295;
                monster.xSyrinnge=339;monster.ySyrinnge=321;
            }
               
            }  
              
        }
    
    
    

    
    //Hàm set sự kiến ăn sách
    public void eatBooks(Map DefaultMap, int x[], int y[], JPanel childJPanel, JLabel obj[]){
        // Set các điều kiện để nhân vật ăn sách
        for(int i=0;i<x.length;i++){
            int X = (x[i]+secondMap.getNewImageIcon().getIconWidth()) - (player.PlayerWidth + player.PlayerPositionX);
            int Y = (y[i]+secondMap.getNewImageIcon().getIconHeight()) - (player.PLayerHeight + player.PlayerPositionY);
            if(((X>=-28 && X<=2 && player.getImgName()=="") || (X>=-45 && X<=3 && player.getImgName()=="Attack")) &&
                Y>=-49 && Y<=-12 && DefaultMap.addObj[i]==true && DefaultMap.removeObj[i]==false){
                // Xóa hình sách trên map và cộng 100 điểm
                soundInternal.setFile(4);
                soundInternal.start();
                childJPanel.remove(obj[i]);
                DefaultMap.addObj[i]=false;
                DefaultMap.removeObj[i]=true;
                score+=100;
            }
        }
    }
   //Hàm lấy ra điểm sau khi ăn sách
    public void getEatBooks(){
        switch (nameCardLayout) {
            case "FirstMap":
                eatBooks(firstMap, firstMap.getX(), firstMap.getY(), firstMap.getChildFirstMapPanel(), firstMap.getObj());
                updateScore();
                break;
            case "SecondMap":
                eatBooks(secondMap, secondMap.getX(), secondMap.getY(), secondMap.getChildSecondMapPanel(), secondMap.obj);
                updateScore();
                break;
            case "ThirdMap":
                eatBooks(thirdMap, thirdMap.getX(), thirdMap.getY(), thirdMap.getChildThirdMapPanel(), thirdMap.obj);
                updateScore();
                break;
        }
    }

    


    // Hàm reset mọi thứ về trạng thái ban đầu và trở về Intro
    public void Reset() {
        // Dừng nhạc hiện tại
        soundMain.stop();
        countFoot = 0;
        
        // Đặt lại vị trí ban đầu;
        monster.getMonsterImage();
        monster.setDefaultMonster();

        // Gọi hàm discardHeart để setup lại tym
        discardHeart();
       

        //Gọi hàm discardBook để setup lại book
        discardBook(firstMap, firstMap.getChildFirstMapPanel(), firstMap.getObj());
        discardBook(secondMap, secondMap.getChildSecondMapPanel(), secondMap.obj);
        discardBook(thirdMap, thirdMap.getChildThirdMapPanel(), thirdMap.obj);

        // xóa tất cả các dong chữ chạy của trailer và cho bắt đầu từ đầu
        trailer.timer.stop();
        trailer.currentLineIndex = 0;
        trailer.currentCharacterIndex = 0;
        trailer.textArea.setText("");

        dicardEnding();

        // Chuyển về trang Intro
        nameCardLayout = "Intro";
        cardLayout.show(cardPanel, nameCardLayout);
        
        // Cho nhân vật dừng di chuyển và set lại vị trí cũ
        playermove.playerRight = playermove.playerDown = playermove.playerUp = playermove.playerLeft = false;
        player.setDefaultPlayer();

        
        // Bật lại nhạc của intro
        soundMain.setFile(0);
        soundMain.start();
    }

    public void dicardEnding(){
       badEnding.getTimerBad().stop();
       badEnding.setCurrentCharacterIndex(0);
       happyEnding.setCurrentCharacterIndex(0);
       happyEnding.getTimerHappy().stop();
        for(int i=0;i<badEnding.getText().length;i++){
            badEnding.getTextI(i).setText("");
        }
        for(int i=0;i<happyEnding.getText().length;i++){
            happyEnding.getTextI(i).setText("");
        }
    }

   
    // Hàm gắn lại trái tym về chỗ cũ nếu như đã bị ăn mất
    public void discardHeart() {
            firstMap.setAddHeart(true);
            firstMap.setRemoveHeart(false);
            firstMap.getChildFirstMapPanel().add(firstMap.getHeart());
        
            secondMap.setAddHeart(true);
            secondMap.setRemoveHeart(false);
            secondMap.getChildSecondMapPanel().add(secondMap.getHeart());
          
            thirdMap.setAddHeart(true);
            thirdMap.setRemoveHeart(false);
            thirdMap.getChildThirdMapPanel().add(thirdMap.getHeart());
        }

   
        // Hàm gắn lại book về chỗ cũ nếu như đã bị ăn mất
      public void discardBook(Map defaultMap,  JPanel childJPanel, JLabel obj[]) {
      for(int i=0;i<obj.length;i++){
        childJPanel.add(obj[i]);
        defaultMap.addObj[i]=true;
        defaultMap.removeObj[i]= false;
      }
      score=0;
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

    // Hàm trả về kết thúc cuối cùng
    public void finalEnding() {
        if(ThirdMap.getSecondsLeft() <= 0) {
            // Nếu điểm nhỏ hơn 4500, bạn thua
            soundMain.stop();
            if(this.score <= 4500) {
                badEnding.setNumberBad(3);
               Function.Ending.BadEnding(this,badEnding.getNumberBad());
            }
            // Ngược lại bạn chiến thắng
            else {
                happyEnding.setNumberHappy(0);
               Function.Ending.HappyEnding(this,happyEnding.getNumberHappy());

            }
        }
    }

    public String getNameCardLayout(){
           return nameCardLayout;
    }
    public void setNameCardLayout(String nameCardLayout){
        this.nameCardLayout=nameCardLayout;
    }
    public HappyEnding getHappyEnding(){
        return happyEnding;
    }
    public BadEnding getBadEnding(){
        return badEnding;
    }
    public CardLayout getCardLayout(){
        return cardLayout;
    }
    public JPanel getCardPanel(){
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

    public void setScore(int score) {
        this.score = score;
    }

    public Monster getMonster() {
        return monster;
    }

    
    
}
