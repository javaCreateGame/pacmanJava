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
// import javax.swing.JLabel;
import java.awt.*;

public class MyFrame extends JFrame implements ActionListener, Runnable {
    PlayerMove playermove = new PlayerMove();
    public Player player = new Player(this, playermove);
    SoundEffect soundMain = new SoundEffect();
    public SoundEffect soundInternal = new SoundEffect();
    SoundEffect soundNext = new SoundEffect();
    public Monster monster = new Monster(this);
   
    Thread gameThread;
    JLabel scoreLabel;
    String Ending;
    public static String nameCardLayout;
    public int score = 0;
    public int jframeWidth = 615, jframeHeight = 615;
    public int jframeHeightParent = 690;
    public int countFoot = 0;
    int FPS = 60;
    JPanel cardPanel; // Use JPanel instead of JLayeredPane

    BadEnding badEnding=new BadEnding();
    HappyEnding happyEnding = new HappyEnding();
    // Tạo các object để sử dụng các biến của chúng
    Intro intro = new Intro(this);
    Trailer trailer = new Trailer(this);
    FirstMap firstMap = new FirstMap(this);
    SecondMap secondMap = new SecondMap(this);
    ThirdMap thirdMap = new ThirdMap(this);

    CardLayout cardLayout = new CardLayout();
 
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

        
        else if(e.getSource()==badEnding.getButtonEnding().getYesButton()){
            Reset();
        }
        // Xử lý sự kiện khi nút "Exit" được nhấn
        else if (e.getSource() == intro.Exit || e.getSource()==badEnding.getButtonEnding().getNoButton()) {
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
                    getTransform();
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

    
    // Ham viet logic biến hình cho nhân vật
    public void transform( int heartXLocation, int heartYLocation,
        boolean addHeart,boolean removeHeart) {
        double dem = Math.floor((Math.random() * 2) + 1);
        // Set các điều kiện để nhân vật có thể biến hình
        int X = (heartXLocation + secondMap.getNewImageIconHeart().getIconWidth())
                - (player.PlayerWidth + player.PlayerPositionX);
        int Y = (heartYLocation + secondMap.getNewImageIconHeart().getIconHeight())
                - (player.PLayerHeight + player.PlayerPositionY);
        if (X >= -30 && X <= 7 && Y >= -45 && Y <= -8 && addHeart == true
                && removeHeart == false) {
            // Nhân vật không thể biến hình và bị giảm 500 điểm
            if (dem == 1) {
                player.imgName = "";
                score-=500;
            }
            // Cho nhân vật biến hình và sau 10s về như cũ
            if (dem == 2) {
                player.imgName = "Attack";
                soundNext.setFile(5);
                soundNext.start();

                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        player.imgName = "";
                        timer.cancel();
                    }
                }, 10000);
            }
            // Xóa hình trái tym trên map
           
            if(nameCardLayout=="FirstMap"){
              firstMap.setAddHeart(false);
              firstMap.setRemoveHeart(true);
              firstMap.getChildFirstMapPanel().remove(firstMap.getHeart());
            }
            else if(nameCardLayout=="SecondMap"){
                secondMap.setAddHeart(false);
                secondMap.setRemoveHeart(true);
                secondMap.getChildSecondMapPanel().remove(secondMap.getHeart());
            }
            else if(nameCardLayout=="ThirdMap"){
                thirdMap.setAddHeart(false);
                thirdMap.setRemoveHeart(true);
                thirdMap.getChildThirdMapPanel().remove(thirdMap.getHeart());
            }

        }
        player.getPlayerImage(player.imgName);
    }

    // Hàm Thực hiện biến hình qua mỗi map
    public void getTransform() {
        switch (nameCardLayout) {
            case "FirstMap":
                transform( firstMap.getHeartXLocation(),
                        firstMap.getHeartYLocation(), firstMap.isAddHeart(),firstMap.isRemoveHeart());
                break;
            case "SecondMap":
                transform( secondMap.getHeartXLocation(),
                        secondMap.getHeartYLocation(), secondMap.isAddHeart(),secondMap.isRemoveHeart());
                break;
            case "ThirdMap":
                transform( thirdMap.getHeartXLocation(),
                          thirdMap.getHeartYLocation(),thirdMap.isAddHeart(),thirdMap.isRemoveHeart());
                 break;
                
        }
    }
    // chuyển Map1-->2
    public void nextMap() {
        int x= player.PlayerPositionX;
        int y = player.PlayerPositionY;
        boolean next=false;
        if (nameCardLayout=="SecondMap" || nameCardLayout=="FirstMap") {
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
    
    
    //chuyển map2-->3

    
    //Hàm set sự kiến ăn sách
    public void eatBooks(Map DefaultMap, int x[], int y[], JPanel childJPanel, JLabel obj[]){
        // Set các điều kiện để nhân vật ăn sách
        for(int i=0;i<x.length;i++){
            int X = (x[i]+secondMap.getNewImageIcon().getIconWidth()) - (player.PlayerWidth + player.PlayerPositionX);
            int Y = (y[i]+secondMap.getNewImageIcon().getIconHeight()) - (player.PLayerHeight + player.PlayerPositionY);
            if(((X>=-28 && X<=2 && player.imgName=="") || (X>=-45 && X<=3 && player.imgName=="Attack")) &&
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

    // Hàm boolean trả về giá trị true nếu nhân vật chạm vào quái
    public boolean removeImage(int xMonsterImg, int yMonsterImg, boolean monsterVisible) {
        int X = (xMonsterImg + monster.MonsterWidth) - (player.PlayerWidth + player.PlayerPositionX);
        int Y = (yMonsterImg + monster.MonsterHeight) - (player.PLayerHeight + player.PlayerPositionY);
        if (X >= -20 && X <= 5 && Y >= -20 && Y <= 5 && monsterVisible == true) {
            return true;
        }
        return false;
    }

    // hÀM setlogic cho player đánh nhau vs quái khi k ăn trái tym
    public void removePlayer() {
        // Mảng sTRING lưu trữ các kịch bản end riêng khi quái chạm vào
       
        // Tạo các biến boolean cho biết mình đụng vào quái nào
        boolean pVsDice = removeImage(monster.xDice, monster.yDice, monster.monsterVisible[0]);
        boolean pVsJoystick = removeImage(monster.xJoystick, monster.yJoystick, monster.monsterVisible[1]);
        boolean pVsSyrinnge = removeImage(monster.xSyrinnge, monster.ySyrinnge, monster.monsterVisible[2]);
        // Nếu đụng vào quái nào thì hiện lên thông báo kết thúc game và lựa chọn
        if (pVsDice == true || pVsSyrinnge == true || pVsJoystick == true) {
            soundMain.stop();
            soundMain.setFile(6);
            soundMain.start();
            nameCardLayout="BadEnding";
            if (pVsDice == true) {
                badEnding.setNumberBad(0);
            } else if (pVsJoystick == true) {
                badEnding.setNumberBad(1);
            } else if (pVsSyrinnge == true) {
                badEnding.setNumberBad(2);
            }
            badEnding.getCardLayout().show(badEnding.getCardPanel(), "bad"+badEnding.getNumberBad());
            cardLayout.show(cardPanel, nameCardLayout);
        badEnding.getTimerBad().start();
        }
    }
    
    
    // hÀM setlogic cho player đánh nhau vs quái khi ăn trái tym
    public void removeMonster() {
        // Tạo các biến boolean cho biết mình đụng vào quái nào
        boolean pVsDice = removeImage(monster.xDice, monster.yDice, monster.monsterVisible[0]);
        boolean pVsJoystick = removeImage(monster.xJoystick, monster.yJoystick, monster.monsterVisible[1]);
        boolean pVsSyrinnge = removeImage(monster.xSyrinnge, monster.ySyrinnge, monster.monsterVisible[2]);
        // Nếu đụng vào quái nào thì xóa và ẩn quái đó
        if (pVsDice == true) {
            score+=1000;
            monster.dice = null;
            monster.monsterVisible[0] = false;
        } else if (pVsJoystick == true) {
            monster.joystick = null;
            monster.monsterVisible[1] = false;
            score+=1000;
        } else if (pVsSyrinnge == true) {
            monster.syrinnge = null;
            monster.monsterVisible[2] = false;
            score+=1000;
        }

    }


    // Hàm tổng hợp các hàm logic trên
    public void PlayerVsMonster() {
        if (player.imgName == "") {
            removePlayer();
        } else if (player.imgName == "Attack") {
            removeMonster();
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
            if(this.score <= 4500) {
                nameCardLayout="BadEnding";
                badEnding.getCardLayout().show(badEnding.getCardPanel(), "bad4");
                cardLayout.show(cardPanel, nameCardLayout);
            }
            // Ngược lại bạn chiến thắng
            else {
                nameCardLayout="HappyEnding";
                happyEnding.getCardLayout().show(happyEnding.getCardPanel(), "happy0");
                cardLayout.show(cardPanel, nameCardLayout);
            }
        }
    }

}
