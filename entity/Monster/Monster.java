package entity.Monster;

import java.awt.Graphics2D;

import java.awt.image.BufferedImage;

import java.util.Arrays;

import javax.imageio.ImageIO;

import main.MyFrame;

public class Monster {
    public boolean monsterVisible[] = new boolean[3];
    public final int defaultSize = 25;
    public int MonsterWidth, MonsterHeight;
    // Tạo biến lưu trữ tọa độ của nhân vật
    public int xJoystick, yJoystick, xDice, yDice, xSyrinnge, ySyrinnge;
    public int xVelocity[] = new int[3];
    public int yVelocity[] = new int[3];
    // Tạo biến lưu trữ ảnh chuyển động của nhân vâth
    public BufferedImage dice, joystick, syrinnge;
    MyFrame Mf;

    public Monster(MyFrame Mf) {
        this.Mf = Mf;
        setDefaultMonster();
        getMonsterImage();
    }

    public void getMonsterImage() {
        try {
            // lấy ảnh chuyển động ra từ folder picture
            dice = ImageIO.read(getClass().getResourceAsStream("/picture/diceMonster.png"));
            joystick = ImageIO.read(getClass().getResourceAsStream("/picture/joystickMonster.png"));
            syrinnge = ImageIO.read(getClass().getResourceAsStream("/picture/syringeMonster.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDefaultMonster() {
        Arrays.fill(monsterVisible, true);
        Arrays.fill(xVelocity, 4);
        Arrays.fill(yVelocity, 4);
        xVelocity[1] = 5;
        yVelocity[0] = 5;
        xDice = 10;
        xJoystick = 40;
        xSyrinnge = 70;
        yDice = yJoystick = 60;
        ySyrinnge = 55;
        MonsterHeight = MonsterWidth = defaultSize;
    }

    public void running() {
        if (Mf.countFoot >= 300) {

            if (xDice >= Mf.jframeWidth - MonsterWidth || xDice < 0) {
                xVelocity[0] = xVelocity[0] * (-1);
            }
            xDice -= xVelocity[0];
            if (yDice >= Mf.jframeHeight + 27 - MonsterHeight || yDice < 0) {
                yVelocity[0] = yVelocity[0] * (-1);
            }
            yDice -= yVelocity[0];
        }
        if (Mf.countFoot >= 600) {
            if (xJoystick >= Mf.jframeWidth - MonsterWidth || xJoystick < 0) {
                xVelocity[1] = xVelocity[1] * (-1);
            }
            xJoystick += xVelocity[1];
            if (yJoystick >= Mf.jframeHeight + 27 - MonsterHeight || yJoystick < 0) {
                yVelocity[1] = yVelocity[1] * (-1);
            }
            yJoystick += yVelocity[1];
        }
        if (Mf.countFoot >= 800) {
            if (xSyrinnge >= Mf.jframeWidth - MonsterWidth | xSyrinnge < 0) {
                xVelocity[2] = xVelocity[2] * (-1);
            }
            xSyrinnge += xVelocity[2];
            if (ySyrinnge >= Mf.jframeHeight + 27 - MonsterHeight || ySyrinnge < 0) {
                yVelocity[2] = yVelocity[2] * (-1);
            }
            ySyrinnge += yVelocity[2];
        }

    }

    public void draw(Graphics2D g2) {
        g2.drawImage(dice, xDice, yDice, MonsterWidth, MonsterHeight, null);
        g2.drawImage(joystick, xJoystick, yJoystick, MonsterWidth, MonsterHeight, null);
        g2.drawImage(syrinnge, xSyrinnge, ySyrinnge, MonsterWidth + 10, MonsterHeight + 10, null);
    }

}
