package Controller.GameController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JOptionPane;

import Controller.GameController.Function.EatBook;
import Controller.GameController.Function.Ending;
import Controller.GameController.Function.NextMap;
import Controller.GameController.Function.PlayerVsMonster;
import Controller.GameController.Function.Reset;
import Controller.GameController.Function.Transform;
import Model.GameModel.GameModel;
import View.GameView.GameView;

public class GameController implements ActionListener, Runnable {
    private GameModel gameModel;
    private GameView gameView;
    Thread gameThread;
    Thread functionThread = new Thread(() -> {
      while (gameThread!= null) {
        if (gameModel.getNameCardLayout() == "FirstMap" || gameModel.getNameCardLayout() == "SecondMap"
        || gameModel.getNameCardLayout() == "ThirdMap") {
            gameModel.setCountFoot(gameModel.getCountFoot() + 1);
            
        }
        Transform.getTransform(gameModel);
        EatBook.getEatBooks(this);
        PlayerVsMonster.PlayerFightMonster(gameModel);
        gameView.updateScoreLabel();
        NextMap.nextMap(gameModel);
        if (gameModel.getNameCardLayout() == "ThirdMap") {
            Ending.finalEnding(gameModel);
        }
        
      }
    });

    public GameController() {
        gameModel = new GameModel();
        gameView = new GameView(gameModel);
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

        gameModel.getBadEnding().getBadEndingModel().getButtonEnding().getButtonEndingModel().getYesButton()
                .addActionListener(this);
        gameModel.getBadEnding().getBadEndingModel().getButtonEnding().getButtonEndingModel().getNoButton()
                .addActionListener(this);

        gameModel.getHappyEnding().getHappyEndingModel().getButtonEnding().getButtonEndingModel().getYesButton()
                .addActionListener(this);
        gameModel.getHappyEnding().getHappyEndingModel().getButtonEnding().getButtonEndingModel().getNoButton()
                .addActionListener(this);

    }

    // Hàm để sử dụng gameloop
    public void StartGame() {
        gameThread = new Thread(this);
        gameThread.start();
        functionThread.start();
    }

    // Tạo hệ thống game loop để làm animation cho nhân vật với 60 khung hình trên
    // giây
    @Override
    public void run() {
        double drawInteval = 1000000000 / gameModel.getFPS();//khoảng thời gian để vẽ lại
        double nextDrawTime =System.nanoTime() +drawInteval;//Thời gian vẽ tiếp theo
        
        while (gameThread != null) {
          
                    update();
                    gameModel.repaint();
        
                    try {
                        double remainningTime=nextDrawTime-System.nanoTime();//Tính thời gian còn lại cho đến lần vẽ kế tiếp
                    remainningTime=remainningTime/1000000;//chuyển về dạng milis do thread.sleep chỉ chấp nhận milis
                    if (remainningTime<0) {
                        remainningTime=0;
                    }
                    Thread.sleep((long) remainningTime);
                    nextDrawTime+=drawInteval;//Thiết lập thời gian vẽ kế tiếp
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
            }

        }
    

    // Hàm viết logic các nút bấm
    @Override
    public void actionPerformed(ActionEvent e) {
        // Xử lý sự kiện khi nút "Start" được nhấn
        if (e.getSource() == gameModel.getIntro().getIntroModel().getStart()) {
            if (gameModel.getLogin().getLoginModel().isOutDialog() == true) {
                // Dừng âm thanh hiện tại
                gameModel.getSoundMain().close();
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
            } else {
                JOptionPane.showConfirmDialog(null, "Bạn chưa đăng nhập", "Warning", JOptionPane.PLAIN_MESSAGE);

            }
        } else if (e.getSource() == gameModel.getIntro().getIntroModel().getScoreBoardButton()) {

            // Chuyển sang cửa sổ scoreBoard
            gameModel.setNameCardLayout("ScoreBoard");
            gameModel.getCardLayout().show(gameModel.getCardPanel(), gameModel.getNameCardLayout());
        } else if (e.getSource() == gameModel.getScoreBoard().getScoreBoardModel().getBack()) {

            // Chuyển sang cửa sổ scoreBoard
            gameModel.setNameCardLayout("Intro");
            gameModel.getCardLayout().show(gameModel.getCardPanel(), gameModel.getNameCardLayout());
        }

        else if (e.getSource() == gameModel.getIntro().getIntroModel().getLoginButton()) {

            if (gameModel.getIntro().getIntroModel().getLoginButton().getText().equals("Đăng nhập")) {
                gameModel.getLogin().getLoginModel().setVisible(true);
                gameModel.getLogin().resetLoginDialog();
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đăng xuất khỏi tài khoản", "Xác nhận",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == 0) {
                gameModel.getLogin().getLoginModel().setVisible(true);
                gameModel.getLogin().resetLoginDialog();
                gameModel.getLogin().getLoginModel().setOutDialog(false);
            }

        }

        else if (e.getSource() == gameModel.getTrailer().getTrailerModel().getNextButton()) {
            // Dừng âm thanh phần trailer
            gameModel.getSoundInternal().close();
            gameModel.getSoundMain().close();
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

        else if (e.getSource() == gameModel.getBadEnding().getBadEndingModel().getButtonEnding().getButtonEndingModel()
                .getYesButton()
                || e.getSource() == gameModel.getHappyEnding().getHappyEndingModel().getButtonEnding()
                        .getButtonEndingModel().getYesButton()) {
            Reset.ResetAll(gameModel);
        }
        // Xử lý sự kiện khi nút "Exit" được nhấn
        else if (e.getSource() == gameModel.getIntro().getIntroModel().getExit()
                || e.getSource() == gameModel.getBadEnding().getBadEndingModel().getButtonEnding()
                        .getButtonEndingModel().getNoButton()
                || e.getSource() == gameModel.getHappyEnding().getHappyEndingModel().getButtonEnding()
                        .getButtonEndingModel().getNoButton()) {
            // Thoát ứng dụng

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
       

    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public GameView getGameView() {
        return gameView;
    }

}
