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
        if (Mf.getCountFoot() >= 100) {

            if (xDice >= Mf.jframeWidth - MonsterWidth || xDice < 0) {
                xVelocity[0] = xVelocity[0] * (-1);
            }
            xDice -= xVelocity[0];
            if (yDice >= Mf.jframeHeight + 27 - MonsterHeight || yDice < 0) {
                yVelocity[0] = yVelocity[0] * (-1);
            }
            yDice -= yVelocity[0];
        }
        if (Mf.getCountFoot() >= 200) {
            if (xJoystick >= Mf.jframeWidth - MonsterWidth || xJoystick < 0) {
                xVelocity[1] = xVelocity[1] * (-1);
            }
            xJoystick += xVelocity[1];
            if (yJoystick >= Mf.jframeHeight + 27 - MonsterHeight || yJoystick < 0) {
                yVelocity[1] = yVelocity[1] * (-1);
            }
            yJoystick += yVelocity[1];
        }
        if (Mf.getCountFoot() >= 300) {
            if (xSyrinnge >= Mf.jframeWidth - MonsterWidth | xSyrinnge < 0) {
                xVelocity[2] = xVelocity[2] * (-1);
            }
            xSyrinnge += xVelocity[2];
            if (ySyrinnge >= Mf.jframeHeight + 27 - MonsterHeight || ySyrinnge < 0) {
                yVelocity[2] = yVelocity[2] * (-1);
            }
            ySyrinnge += yVelocity[2];
        }
           if (Mf.getCountFoot()==800) {
           
            Arrays.fill(xVelocity, 8);
            Arrays.fill(yVelocity, 8);
            xVelocity[1] = 9;
            yVelocity[0] = 9;
           }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(dice, xDice, yDice, MonsterWidth, MonsterHeight, null);
        g2.drawImage(joystick, xJoystick, yJoystick, MonsterWidth, MonsterHeight, null);
        g2.drawImage(syrinnge, xSyrinnge, ySyrinnge, MonsterWidth + 10, MonsterHeight + 10, null);
    }

    public boolean getMonsterVisible(int i) {
        return monsterVisible[i];
    }

    public void setMonsterVisible(boolean monsterVisible,int i) {
        this.monsterVisible[i] = monsterVisible;
    }

    public int getxDice() {
        return xDice;
    }

    public void setxDice(int xDice) {
        this.xDice = xDice;
    }

    public int getyDice() {
        return yDice;
    }

    public void setyDice(int yDice) {
        this.yDice = yDice;
    }

    public int getxSyrinnge() {
        return xSyrinnge;
    }

    public void setxSyrinnge(int xSyrinnge) {
        this.xSyrinnge = xSyrinnge;
    }

    public int getySyrinnge() {
        return ySyrinnge;
    }

    public void setySyrinnge(int ySyrinnge) {
        this.ySyrinnge = ySyrinnge;
    }

    public int getxJoystick() {
        return xJoystick;
    }

    public void setxJoystick(int xJoystick) {
        this.xJoystick = xJoystick;
    }

    public int getyJoystick() {
        return yJoystick;
    }

    public void setyJoystick(int yJoystick) {
        this.yJoystick = yJoystick;
    }

  

}
