package Model.GameModel;

import javax.swing.JFrame;

import Controller.EntityController.MonsterController.MonsterController;
import Controller.EntityController.PlayerController.PlayerController;
import Controller.EntityController.PlayerController.PlayerMoveController;
import Controller.SoundController.SoundEffectController;

public class GameModel extends JFrame {
    private PlayerMoveController playermove = new PlayerMove();
    private PlayerController player = new Player(this, playermove);
    private MonsterController monster = new Monster(this);
     
    private SignIn_Up Login=new SignIn_Up(this);
    private SoundEffectController soundMain = new SoundEffect();
    private SoundEffectController soundInternal = new SoundEffect();
    private SoundEffect soundNext = new SoundEffect();
   
    Thread gameThread;
    
    JLabel scoreLabel;
    private JPanel cardPanel; // Use JPanel instead of JLayeredPane

    
    private String nameCardLayout;
    private int score = 0;
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
    private ScoreBoard scoreBoard = new ScoreBoard(this);

    private CardLayout cardLayout = new CardLayout();
}
