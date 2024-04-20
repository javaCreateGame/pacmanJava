package Controller.EntityController.MonsterController;

import java.awt.Graphics2D;
import java.util.Arrays;

import Model.EntityModel.MonsterModel.MonsterModel;
import Model.GameModel.GameModel;
import View.EntityView.MonsterView.MonsterView;

public class MonsterController {
    GameModel Mf;
    private MonsterModel monsterModel;
    private MonsterView monsterView;

    public MonsterController(GameModel Mf) {
        this.Mf = Mf;
        monsterModel = new MonsterModel();
        monsterView = new MonsterView(monsterModel);
    }

    public void running() {
        //Khi vào màn sẽ có biến countFoot bắt đầu chạy
        //mỗi lần thread funticonThread trong game controller chạy nó sẽ tự động tăng 1

        //Nếu countFoot >=200 thì cho dice bắt đầu chạy
        if (Mf.getCountFoot() >= 200) {
          
         
         //Nếu tọa độ x của monster dice mà <0 hoặc là > kích thước của j frame
            if (monsterModel.getxDice() >= Mf.getJframeWidth() - monsterModel.getMonsterWidth()
                    || monsterModel.getxDice() < 0) {
                      //  nó sẽ tự động chuyển xVelocity thành 1 số cùng giá trị khác dấu
                      //xVelocity có thể coi là speed theo chiều x
                      //xVelocity là 1 mảng mà mỗi phần tử sẽ chứa xVelcocity của monster khác nhau
                monsterModel.getxVelocity()[0] = monsterModel.getxVelocity()[0] * (-1);
            }
            //Cho tọa độ X của monster dice tịnh tiến //xVelocity theo chiều x;
            monsterModel.setxDice(monsterModel.getxDice() + monsterModel.getxVelocity()[0]);
            
            //Tương tự nhưng bây giờ theo chiều Y
            if (monsterModel.getyDice() >= Mf.getJframeHeight() + 27 - monsterModel.getMonsterHeight()
                    || monsterModel.getyDice() < 0) {
                monsterModel.getyVelocity()[0] = monsterModel.getyVelocity()[0] * (-1);
            }
            monsterModel.setyDice(monsterModel.getyDice() + monsterModel.getyVelocity()[0]);
        }
        //Nếu countFoot >=300 thì cho joystic bắt đầu chạy
        if (Mf.getCountFoot() >= 300) {
            //Tương tự dice theo chiều x
            if (monsterModel.getxJoystick() >= Mf.getJframeWidth() - monsterModel.getMonsterWidth()
                    || monsterModel.getxJoystick() < 0) {
                monsterModel.getxVelocity()[1] = monsterModel.getxVelocity()[1] * (-1);
            }
            monsterModel.setxJoystick((monsterModel.getxJoystick() - monsterModel.getxVelocity()[1]));
            //Tương tự dice theo chiều y
            if (monsterModel.getyJoystick() >= Mf.getJframeHeight() + 27 - monsterModel.getMonsterHeight()
                    || monsterModel.getyJoystick() < 0) {
                monsterModel.getyVelocity()[1] = monsterModel.getyVelocity()[1] * (-1);
            }
            monsterModel.setyJoystick((monsterModel.getyJoystick() + monsterModel.getyVelocity()[1]));
        }
        //Nếu countFoot >=400 thì cho Syringe bắt đầu chạy
        if (Mf.getCountFoot() >= 400) {
            
            if (monsterModel.getxSyrinnge() >= Mf.getJframeWidth() - monsterModel.getMonsterWidth()+10
                    | monsterModel.getxSyrinnge() < 0) {
                monsterModel.getxVelocity()[2] = monsterModel.getxVelocity()[2] * (-1);
            }
            monsterModel.setxSyrinnge(monsterModel.getxSyrinnge() + monsterModel.getxVelocity()[2]);
            
            if (monsterModel.getySyrinnge() >= Mf.getJframeHeight() + 27 - monsterModel.getMonsterHeight()+10
                    || monsterModel.getySyrinnge() < 0) {
                monsterModel.getyVelocity()[2] = monsterModel.getyVelocity()[2] * (-1);
            }
            monsterModel.setySyrinnge(monsterModel.getySyrinnge() + monsterModel.getyVelocity()[2]);
        }
         //Nếu countFoot =900 thì tăng xVelcity và y Velocity lên,hiểu đơn giản là tăng speed
        if (Mf.getCountFoot() == 900) {

            Arrays.fill(monsterModel.getxVelocity(), 8);
            Arrays.fill(monsterModel.getyVelocity(), 8);
            monsterModel.getxVelocity()[1] = 9;
            monsterModel.getyVelocity()[0] = 9;
        }
    }

    //Hàm vẽ quái vật
    public void draw(Graphics2D g2) {
        g2.drawImage(monsterModel.getDice(), monsterModel.getxDice(), monsterModel.getyDice(),
                monsterModel.getMonsterWidth(), monsterModel.getMonsterHeight(), null);
        g2.drawImage(monsterModel.getJoystick(), monsterModel.getxJoystick(), monsterModel.getyJoystick(),
                monsterModel.getMonsterWidth(), monsterModel.getMonsterHeight(), null);
        g2.drawImage(monsterModel.getSyrinnge(), monsterModel.getxSyrinnge(), monsterModel.getySyrinnge(),
                monsterModel.getMonsterWidth() + 10, monsterModel.getMonsterHeight() + 10, null);
    }

    public MonsterModel getMonsterModel() {
        return monsterModel;
    }

    public MonsterView getMonsterView() {
        return monsterView;
    }

}
