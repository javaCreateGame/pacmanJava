package Controller.EntityController.MonsterController;

import java.awt.Graphics2D;
import java.util.Arrays;

import Model.EntityModel.MonsterModel.MonsterModel;
import Model.GameModel.GameModel;
import View.EntityView.MonsterView.MonsterView;
import main.MyFrame;

public class MonsterController {
    GameModel Mf;
    private MonsterModel monsterModel;
    private MonsterView monsterView;
    public MonsterController(GameModel Mf){
        this.Mf=Mf;
        monsterModel=new MonsterModel();
        monsterView=new MonsterView(Mf, monsterModel);
    }
    public void running() {
        if (Mf.getCountFoot() >= 200) {

            if (monsterModel.getxDice() >= Mf.getJframeWidth() - monsterModel.getMonsterWidth() || monsterModel.getxDice() < 0) {
                monsterModel.getxVelocity()[0] =monsterModel.getxVelocity()[0] * (-1);
            }
            monsterModel.setxDice(monsterModel.getxDice()-monsterModel.getxVelocity()[0]);
            
            if (monsterModel.getyDice() >= Mf.getJframeHeight() + 27 - monsterModel.getMonsterHeight() || monsterModel.getyDice() < 0) {
                monsterModel.getyVelocity()[0] =monsterModel.getyVelocity()[0] * (-1);
            }
            monsterModel.setyDice(monsterModel.getyDice()-monsterModel.getyVelocity()[0]);
        }
        if (Mf.getCountFoot() >= 300) {
            if (monsterModel.getxJoystick() >= Mf.getJframeWidth() - monsterModel.getMonsterWidth() || monsterModel.getxJoystick() < 0) {
                monsterModel.getxVelocity()[1] =monsterModel.getxVelocity()[1] * (-1);
            }
            monsterModel.setxJoystick((monsterModel.getxJoystick()-monsterModel.getxVelocity()[1]));
            if (monsterModel.getyDice() >= Mf.getJframeHeight() + 27 - monsterModel.getMonsterHeight() || monsterModel.getyDice() < 0) {
                monsterModel.getyVelocity()[1] =monsterModel.getyVelocity()[1] * (-1);
            }
            monsterModel.setyJoystick((monsterModel.getyJoystick()-monsterModel.getyVelocity()[1]));
        }
        if (Mf.getCountFoot() >= 400) {
            if (monsterModel.getxJoystick() >= Mf.getJframeWidth() - monsterModel.getMonsterWidth() | monsterModel.getxJoystick() < 0) {
                monsterModel.getxVelocity()[2] =monsterModel.getxVelocity()[2] * (-1);
            }
            monsterModel.setxSyrinnge(monsterModel.getxSyrinnge()-monsterModel.getxVelocity()[2]);
            if (monsterModel.getySyrinnge() >= Mf.getJframeHeight() + 27 - monsterModel.getMonsterHeight() || monsterModel.getySyrinnge() < 0) {
                monsterModel.getyVelocity()[2] =monsterModel.getyVelocity()[2] * (-1);
            }
            monsterModel.setySyrinnge(monsterModel.getySyrinnge()-monsterModel.getyVelocity()[2]);
        }
           if (Mf.getCountFoot()==900) {
           
            Arrays.fill(monsterModel.getxVelocity(), 8);
            Arrays.fill(monsterModel.getyVelocity(), 8);
            monsterModel.getxVelocity()[1] = 9;
            monsterModel.getyVelocity()[0] = 9;
           }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(monsterModel.getDice(), monsterModel.getxDice(), monsterModel.getyDice(), monsterModel.getMonsterWidth(), monsterModel.getMonsterHeight(), null);
        g2.drawImage(monsterModel.getJoystick(),monsterModel.getxJoystick(), monsterModel.getyJoystick(), monsterModel.getMonsterWidth(), monsterModel.getMonsterHeight(), null);
        g2.drawImage(monsterModel.getSyrinnge(),monsterModel.getxSyrinnge(), monsterModel.getySyrinnge(), monsterModel.getMonsterWidth() + 10, monsterModel.getMonsterHeight() + 10, null);
    }
    public MonsterModel getMonsterModel() {
        return monsterModel;
    }
    public MonsterView getMonsterView() {
        return monsterView;
    }
    
}
