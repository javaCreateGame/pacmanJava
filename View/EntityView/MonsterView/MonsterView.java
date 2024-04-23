package View.EntityView.MonsterView;

import java.util.Arrays;

import javax.imageio.ImageIO;

import Model.EntityModel.MonsterModel.MonsterModel;

public class MonsterView {
    private MonsterModel monsterModel;

    public MonsterView(MonsterModel monsterModel) {

        this.monsterModel = monsterModel;
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
        monsterModel.setxDice(566);
        monsterModel.setxJoystick(576);
        monsterModel.setxSyrinnge(306);

        monsterModel.setyDice(64);
        monsterModel.setyJoystick(502);
        monsterModel.setySyrinnge(431);
        monsterModel.setMonsterHeight(monsterModel.getDefaultSize());
        monsterModel.setMonsterWidth(monsterModel.getDefaultSize());

    }

}
