package Model.GameModel;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.EndingController.BadEndingController;
import Controller.EndingController.HappyEndingController;
import Controller.EntityController.MonsterController.MonsterController;
import Controller.EntityController.PlayerController.PlayerController;
import Controller.EntityController.PlayerController.PlayerMoveController;
import Controller.LoginController.LoginController;
import Controller.SoundController.SoundEffectController;
import Controller.StateController.FirstMapController;
import Controller.StateController.IntroController;
import Controller.StateController.ScoreBoardController;
import Controller.StateController.SecondMapController;
import Controller.StateController.ThirdMapController;
import Controller.StateController.TrailerController;
import Model.EntityModel.PlayerModel.PlayerModel;
import Model.StateModel.FirstMapModel;
import Model.StateModel.SecondMapModel;
import Model.StateModel.ThirdMapModel;

import View.StateView.FirstMapView;
import View.StateView.SecondMapView;
import View.StateView.ThirdMapView;

public class GameModel extends JFrame {

    public Controller.TileController.CollisionChecker cChecker = new Controller.TileController.CollisionChecker(this); 

    private PlayerMoveController playermove = new PlayerMoveController(); // == KeyHandler
    private PlayerController player = new PlayerController(this, playermove);
    private MonsterController monster = new MonsterController(this);

    private LoginController Login = new LoginController(this);
    private SoundEffectController soundMain = new SoundEffectController();
    private SoundEffectController soundInternal = new SoundEffectController();
    private SoundEffectController soundNext = new SoundEffectController();

    JLabel scoreLabel = new JLabel();
    private JPanel cardPanel = new JPanel(); // Use JPanel instead of JLayeredPane

    public final int maxScreenCol = 38;
    public final int maxScreenRow = 39;

    public static String nameCardLayout;
    private int score = 0;
    private int jframeWidth = 615; // 615px
    private int jframeHeight = 615; // 615px
    private int jframeHeightParent = 690;// 690px
    private int countFoot = 0;
    private int FPS = 60;

    // TileManager tileManager = new TileManager(this);
    public View.TileView.TileManager tileManager = new View.TileView.TileManager(this); // Khởi tạo TileManager trong GameModel
    public View.TileView.TilePanel tilePanel = new View.TileView.TilePanel(this, tileManager);

    public FirstMapModel firstMapModel = new FirstMapModel();
    public SecondMapModel secondMapModel = new SecondMapModel();
    // public ThirdMapModel thirdMapModel = new ThirdMapModel();
    
    FirstMapView firstMapView = new FirstMapView(this, firstMapModel); // Truyền TileManager vào FirstMapView
    // SecondMapView secondMapView = new SecondMapView(this, secondMapModel);
    // ThirdMapView thirdMapView = new ThirdMapView(this, thirdMapModel);
    // SecondMapView secondMapView = new SecondMapView(this, secondMapModel, tileManager); // Truyền TileManager vào FirstMapView


    // Tạo các object để sử dụng các biến của chúng
    private IntroController intro = new IntroController(this);
    private TrailerController trailer = new TrailerController(this);
    private FirstMapController firstMap = new FirstMapController(this);
    private SecondMapController secondMap = new SecondMapController(this);
    private ThirdMapController thirdMap = new ThirdMapController(this);
    private BadEndingController badEnding = new BadEndingController();
    private HappyEndingController happyEnding = new HappyEndingController();
    private ScoreBoardController scoreBoard = new ScoreBoardController(this);

    private CardLayout cardLayout = new CardLayout();

    // hàm vẽ nhân vật
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        if (nameCardLayout == "FirstMap" || nameCardLayout == "SecondMap" || nameCardLayout == "tilePanel" ) {
            player.draw(g2);
            monster.draw(g2);
            repaint();
        }
        g2.dispose();

    }

    public PlayerMoveController getPlayermove() {
        return playermove;
    }

    public void setPlayermove(PlayerMoveController playermove) {
        this.playermove = playermove;
    }

    public PlayerController getPlayer() {
        return player;
    }

    public void setPlayer(PlayerController player) {
        this.player = player;
    }

    public MonsterController getMonster() {
        return monster;
    }

    public void setMonster(MonsterController monster) {
        this.monster = monster;
    }

    public SoundEffectController getSoundMain() {
        return soundMain;
    }

    public void setSoundMain(SoundEffectController soundMain) {
        this.soundMain = soundMain;
    }

    public SoundEffectController getSoundInternal() {
        return soundInternal;
    }

    public void setSoundInternal(SoundEffectController soundInternal) {
        this.soundInternal = soundInternal;
    }

    public SoundEffectController getSoundNext() {
        return soundNext;
    }

    public void setSoundNext(SoundEffectController soundNext) {
        this.soundNext = soundNext;
    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    public void setScoreLabel(JLabel scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    public JPanel getCardPanel() {
        return cardPanel;
    }

    public void setCardPanel(JPanel cardPanel) {
        this.cardPanel = cardPanel;
    }

    public String getNameCardLayout() {
        return nameCardLayout;
    }

    public void setNameCardLayout(String nameCardLayout) {
        this.nameCardLayout = nameCardLayout;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getJframeWidth() {
        return jframeWidth;
    }

    public void setJframeWidth(int jframeWidth) {
        this.jframeWidth = jframeWidth;
    }

    public int getJframeHeight() {
        return jframeHeight;
    }

    public void setJframeHeight(int jframeHeight) {
        this.jframeHeight = jframeHeight;
    }

    public int getJframeHeightParent() {
        return jframeHeightParent;
    }

    public void setJframeHeightParent(int jframeHeightParent) {
        this.jframeHeightParent = jframeHeightParent;
    }

    public int getCountFoot() {
        return countFoot;
    }

    public void setCountFoot(int countFoot) {
        this.countFoot = countFoot;
    }

    public int getFPS() {
        return FPS;
    }

    public void setFPS(int fPS) {
        FPS = fPS;
    }

    public IntroController getIntro() {
        return intro;
    }

    public void setIntro(IntroController intro) {
        this.intro = intro;
    }

    public TrailerController getTrailer() {
        return trailer;
    }

    public void setTrailer(TrailerController trailer) {
        this.trailer = trailer;
    }

    public FirstMapController getFirstMap() {
        return firstMap;
    }

    public void setFirstMap(FirstMapController firstMap) {
        this.firstMap = firstMap;
    }

    public SecondMapController getSecondMap() {
        return secondMap;
    }

    public void setSecondMap(SecondMapController secondMap) {
        this.secondMap = secondMap;
    }

    public ThirdMapController getThirdMap() {
        return thirdMap;
    }

    public void setThirdMap(ThirdMapController thirdMap) {
        this.thirdMap = thirdMap;
    }

    public BadEndingController getBadEnding() {
        return badEnding;
    }

    public void setBadEnding(BadEndingController badEnding) {
        this.badEnding = badEnding;
    }

    public HappyEndingController getHappyEnding() {
        return happyEnding;
    }

    public void setHappyEnding(HappyEndingController happyEnding) {
        this.happyEnding = happyEnding;
    }

    public ScoreBoardController getScoreBoard() {
        return scoreBoard;
    }

    public void setScoreBoard(ScoreBoardController scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public LoginController getLogin() {
        return Login;
    }

    public void setLogin(LoginController login) {
        Login = login;
    }

}
