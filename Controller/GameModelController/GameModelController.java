package Controller.GameModelController;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.GameModel.GameModel;
import View.GameView.GameView;

public class GameModelController implements ActionListener,Runnable {
    private GameModel gameModel;
    private GameView gameView;
    Thread gameThread;
    public GameModelController(){
        gameModel=new GameModel();
        gameView=new GameView(gameModel);
        gameModel.addKeyListener(gameModel.getPlayermove());
        StartGame();
        
            // Thêm ActionListener cho nút "Start" trong Intro
            gameModel.getIntro().getIntroModel().getStart().addActionListener(this);

            // Thêm ActionListener cho nút "Exit" trong Intro
            gameModel.getIntro().getIntroModel().getExit().addActionListener(this);
            // Thêm ActionListener cho nút "loginButton" để đăng nhập
            gameModel.getIntro().getIntroModel().getLoginButton().addActionListener(this);
         // Thêm ActionListener cho nút "Scoreboard" trong Intro
         gameModel.getIntro().getIntroModel().getScoreBoardButton().addActionListener(this);
  // Thêm ActionListener cho nút "Scoreboard" trong Intro
  gameModel.getIntro().getIntroModel().getScoreBoardButton().addActionListener(this);

  // Thêm ActionListener cho nút "back" trong Intro
  gameModel.getScoreBoard().getScoreBoardModel().getBack().addActionListener(this);
        // Thêm ActionListener cho nút "nextButton" trong Intro
        gameModel.getTrailer().getTrailerModel().getNextButton().addActionListener(this);
       
        gameModel.getBadEnding().getBadEndingModel().getButtonEnding().getButtonEndingModel().getYesButton().addActionListener(this);
        gameModel.getBadEnding().getBadEndingModel().getButtonEnding().getButtonEndingModel().getNoButton().addActionListener(this);

        gameModel.getHappyEnding().getHappyEndingModel().getButtonEnding().getButtonEndingModel().getYesButton().addActionListener(this);
        gameModel.getHappyEnding().getHappyEndingModel().getButtonEnding().getButtonEndingModel().getNoButton().addActionListener(this);

    }
     // Hàm để sử dụng gameloop
     public void StartGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    // Tạo hệ thống game loop để làm animation cho nhân vật với 60 khung hình trên giây
    @Override
    public void run() {
        double drawInteval = 1000000000 /gameModel.getFPS();
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInteval;
            lastTime = currentTime;
            if (delta >= 1) {
                // Vào map mới bắt đầu cho nhân vật ,quái chạy thực hiện logic
                if (gameModel.getNameCardLayout() == "FirstMap" || gameModel.getNameCardLayout() == "SecondMap" || gameModel.getNameCardLayout() == "ThirdMap") {
                    update();
                    // Transform.getTransform(this);
                    // EatBook.getEatBooks(this);
                    // PlayerVsMove.PlayerVsMonster(this);
                    gameView.updateScoreLabel();
                    // NextMap.nextMap(this);
                    // if (nameCardLayout == "ThirdMap") {
                    //     Function.Ending.finalEnding(this);
                    // }
                }
                gameModel.repaint();
                delta--;
            }

        }
    }
     // Hàm viết logic các nút bấm
    @Override
    public void actionPerformed(ActionEvent e) {
     // Xử lý sự kiện khi nút "Start" được nhấn
     if (e.getSource() ==  gameModel.getIntro().getIntroModel().getStart()) {
        //if (Login.isOutDialog()==true) {
         // Dừng âm thanh hiện tại
         gameModel.getSoundMain().stop();
         // Chuyển sang cửa sổ Trailer
         gameModel.setNameCardLayout("Trailer");
         gameModel.getCardLayout().show(gameModel.getCardPanel(), gameModel.getNameCardLayout());
         gameModel.getTrailer().getTrailerModel().getTimer().start();

         // Thay đổi âm thanh phần intro thành trailer
         gameModel.getSoundMain().setFile(2);
         
         gameModel.getSoundMain().start();
         // Tạo và bắt đầu sử dụng âm thanh gõ phím
         gameModel.getSoundInternal().setFile(1);
         gameModel.getSoundInternal().start();
         gameModel.getSoundInternal().loop();
        //}
        //else{
         //JOptionPane.showConfirmDialog(null, "Bạn chưa đăng nhập", "Warning", JOptionPane.PLAIN_MESSAGE);

        //}
    } 
    else if(e.getSource() ==  gameModel.getIntro().getIntroModel().getScoreBoardButton()){
      
        // Chuyển sang cửa sổ scoreBoard
        gameModel.setNameCardLayout("ScoreBoard");
        gameModel.getCardLayout().show(gameModel.getCardPanel(), gameModel.getNameCardLayout());
    }
    else if(e.getSource() == gameModel.getScoreBoard().getScoreBoardModel().getBack()){
        
        // Chuyển sang cửa sổ scoreBoard
        gameModel.setNameCardLayout("Intro");
         gameModel.getCardLayout().show(gameModel.getCardPanel(), gameModel.getNameCardLayout());
    }

    // else if (e.getSource()==intro.getLoginButton()) {
        
    //     if (intro.getLoginButton().getText().equals("Đăng nhập")) {
    //         Login.setVisible(true);
    //         Login.resetLoginDialog();
    //         return;
    //     }
        
    //     int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đăng xuất khỏi tài khoản", "Xác nhận",
    //         JOptionPane.YES_NO_OPTION);
    //     if (confirm==0) {
    //         Login.setVisible(true);
    //         Login.resetLoginDialog();
    //         Login.setOutDialog(false);
    //     }
        
    // }
  
    else if (e.getSource() ==gameModel.getTrailer().getTrailerModel().getNextButton()) {
        // Dừng âm thanh phần trailer
        gameModel.getSoundInternal().stop();
        gameModel.getSoundMain().stop();
        gameModel.setNameCardLayout("FirstMap");
        gameModel.getFirstMap().getFirstMapModel().getTimer().restart();
        gameModel.getCardLayout().show(gameModel.getCardPanel(), gameModel.getNameCardLayout());
        // Thay đổi âm thanh Trailer sang âm thanh của map
        gameModel.getSoundMain().setFile(3);
        gameModel.getSoundMain().start();
        gameModel.getSoundMain().loop();
        // Tạo âm thanh ăn vật phẩm
        gameModel.getSoundInternal().setFile(4);
    }

    // else if (e.getSource() == badEnding.getButtonEnding().getYesButton()
    //         || e.getSource() == happyEnding.getButtonEnding().getYesButton()) {
    //     Reset.ResetAll(this);
    // }
    // Xử lý sự kiện khi nút "Exit" được nhấn
    else if (e.getSource() ==  gameModel.getIntro().getIntroModel().getExit()) {
        // Thoát ứng dụng
        //|| e.getSource() == badEnding.getButtonEnding().getNoButton()
        //|| e.getSource() == happyEnding.getButtonEnding().getNoButton()
        // Tạo 1 bảng thông báo để xác nhận có muốn thoát k ,nếu có thì thoát
        int exitis = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát", "Xác nhận",
                JOptionPane.YES_NO_OPTION);
        if (exitis == 0) {
            System.exit(exitis);
        }
    }
    }
    
    // Hàm để update chuyển động ,tọa độ khi nhân vật ,monster di chuyển
    public void update() {
        gameModel.getPlayer().update();
        gameModel.getMonster().running();
        gameModel.setCountFoot(gameModel.getCountFoot()+1);;

    }
    
}
