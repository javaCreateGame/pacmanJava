package View.EntityView.MonsterView;

import java.util.Arrays;

import javax.imageio.ImageIO;

import Model.EntityModel.MonsterModel.MonsterModel;
import main.MyFrame;

public class MonsterView {
    private MonsterModel monsterModel;
    private MyFrame Mf;
    public MonsterView(MyFrame Mf,MonsterModel monsterModel){
       this.Mf=Mf;
       this.monsterModel=monsterModel;
       getMonsterImage();
       setDefaultMonster();
    }
    public void getMonsterImage() {
        try {
            // lấy ảnh chuyển động ra từ folder picture
           monsterModel.setDice(ImageIO.read(getClass().getResourceAsStream("/picture/diceMonster.png"))); 
            monsterModel.setJoystick(ImageIO.read(getClass().getResourceAsStream("/picture/joystickMonster.png")));
            monsterModel.setSyrinnge(ImageIO.read(getClass().getResourceAsStream("/picture/syringeMonster.png"))); 

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDefaultMonster() {
        Arrays.fill(monsterModel.getMonsterVisible(), true);
        Arrays.fill(monsterModel.getxVelocity(), 4);
        Arrays.fill(monsterModel.getyVelocity(), 4);
        monsterModel.getxVelocity()[1] = 5;
        monsterModel.getyVelocity()[0] = 5;
        monsterModel.setxDice(10) ;
        monsterModel.setxJoystick(40); 
        monsterModel.setxSyrinnge(70);
       
        monsterModel.setyDice(60);
        monsterModel.setyJoystick(60);
        monsterModel.setySyrinnge(55);
       monsterModel.setMonsterHeight(monsterModel.getDefaultSize());
       monsterModel.setMonsterWidth(monsterModel.getDefaultSize());
      
    }

}
