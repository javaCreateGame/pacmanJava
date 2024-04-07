package View.GameView;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Model.GameModel.GameModel;

public class GameView {
    private GameModel gameModel;

    public GameView(GameModel gameModel) {
        this.gameModel = gameModel;
        gameModel.getCardPanel().setBounds(0, 0, gameModel.getJframeWidth(), gameModel.getJframeHeightParent());

        // Sử dụng CardLayout cho cardPanel
        gameModel.getCardPanel().setLayout(gameModel.getCardLayout());
        // Thêm các panel vào cardPanel với tên đặc biệt
        gameModel.getCardPanel().add(gameModel.getThirdMap().getThirdMapModel().getThirdMapPanel(), "ThirdMap");
        gameModel.getCardPanel().add(gameModel.getSecondMap().getSecondMapModel().getSecondMapPanel(), "SecondMap");
        gameModel.getCardPanel().add(gameModel.getFirstMap().getFirstMapModel().getFirstMapPanel(), "FirstMap");
        gameModel.getCardPanel().add(gameModel.getTrailer().getTrailerModel().getTrailerPanel(), "Trailer");
        gameModel.getCardPanel().add(gameModel.getIntro().getIntroModel().getIntroPanel(), "Intro");
        gameModel.getCardPanel().add(gameModel.getBadEnding().getBadEndingModel().getBadEndingPanelSum(), "BadEnding");
        gameModel.getCardPanel().add(gameModel.getHappyEnding().getHappyEndingModel().getHappyEndingPanelSum(),
                "HappyEnding");
        gameModel.getCardPanel().add(gameModel.getScoreBoard().getScoreBoardModel().getScoreBoard(), "ScoreBoard");

        // Khởi tạo label cho điểm số và thêm vào panel

        gameModel.getScoreLabel().setFont(new Font("Arial", Font.PLAIN, 16)); // Điều chỉnh font và kích thước chữ
        gameModel.getScoreLabel().setForeground(Color.BLACK); // Điều chỉnh màu chữ
        // Đặt vị trí của scoreLabel
        gameModel.getScoreLabel().setBounds(50, 620, 100, 20); // Đặt ở góc trái dưới

        // Thể hiện thẻ đầu tiên (ở đây là Intro)
        gameModel.setNameCardLayout("Intro");
        ;
        gameModel.getCardLayout().show(gameModel.getCardPanel(), gameModel.getNameCardLayout());
        // Thêm sound cho phần intro
        if (gameModel.getNameCardLayout() == "Intro") {
            gameModel.getSoundMain().setFile(0);
            gameModel.getSoundMain().start();
            gameModel.getSoundMain().loop();
        }
        init();
    }

    private void init() {
        ImageIcon logo = new ImageIcon("./picture/logo.jpg");
        gameModel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameModel.setSize(gameModel.getJframeWidth(), gameModel.getJframeHeightParent());
        gameModel.setTitle("Journey to Adulthood");
        gameModel.setIconImage(logo.getImage());
        gameModel.setResizable(false);
        gameModel.setLayout(null);
        gameModel.setLocationRelativeTo(null);
        gameModel.add(gameModel.getCardPanel());
        gameModel.setFocusable(true);
        gameModel.setVisible(true);

    }

    // Phương thức để cập nhật điểm số trên scoreLabel
    public void updateScore() {
        gameModel.getScoreLabel().setText("Score: " + gameModel.getScore());
    }
    // Phương thức để cập nhật scoreLabel vào JPanel dựa trên giá trị của
    // nameCardLayout

    public void updateScoreLabel() {
        switch (gameModel.getNameCardLayout()) {
            case "FirstMap":
                gameModel.getFirstMap().getFirstMapModel().getFirstMapPanel().add(gameModel.getScoreLabel());
                break;
            case "SecondMap":
                gameModel.getSecondMap().getSecondMapModel().getSecondMapPanel().add(gameModel.getScoreLabel());
                break;
            case "ThirdMap":
                gameModel.getThirdMap().getThirdMapModel().getThirdMapPanel().add(gameModel.getScoreLabel());
                break;

        }
    }
}
