package Model.EntityModel.MonsterModel;

import java.awt.image.BufferedImage;

public class MonsterModel {
    private boolean monsterVisible[] = new boolean[3];
    private final int defaultSize = 25;
    private int MonsterWidth, MonsterHeight;
    // Tạo biến lưu trữ tọa độ của nhân vật
    private int xJoystick, yJoystick, xDice, yDice, xSyrinnge, ySyrinnge;
    private int xVelocity[] = new int[3];
    private int yVelocity[] = new int[3];
    // Tạo biến lưu trữ ảnh chuyển động của nhân vâth
    private BufferedImage dice, joystick, syrinnge;
   
    public boolean[] getMonsterVisible() {
        return monsterVisible;
    }

    public void setMonsterVisible(boolean[] monsterVisible) {
        this.monsterVisible = monsterVisible;
    }

    public int getDefaultSize() {
        return defaultSize;
    }

    public int getMonsterWidth() {
        return MonsterWidth;
    }

    public void setMonsterWidth(int monsterWidth) {
        MonsterWidth = monsterWidth;
    }

    public int getMonsterHeight() {
        return MonsterHeight;
    }

    public void setMonsterHeight(int monsterHeight) {
        MonsterHeight = monsterHeight;
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

    public int[] getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(int[] xVelocity) {
        this.xVelocity = xVelocity;
    }

    public int[] getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(int[] yVelocity) {
        this.yVelocity = yVelocity;
    }

    public BufferedImage getDice() {
        return dice;
    }

    public void setDice(BufferedImage dice) {
        this.dice = dice;
    }

    public BufferedImage getJoystick() {
        return joystick;
    }

    public void setJoystick(BufferedImage joystick) {
        this.joystick = joystick;
    }

    public BufferedImage getSyrinnge() {
        return syrinnge;
    }

    public void setSyrinnge(BufferedImage syrinnge) {
        this.syrinnge = syrinnge;
    }

    

}
