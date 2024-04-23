package Model.EntityModel.PlayerModel;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class PlayerModel {
    boolean collision=false;
    private int defaultSize = 20;
    int ImgNumber = 2;
    private int PlayerWidth = 20, PLayerHeight =30;
    // Tạo biến lưu trữ tọa độ của nhân vật
    private int PlayerPositionX, PlayerPositionY;
    private int speed;
    // Tạo biến lưu trữ ảnh chuyển động của nhân vâth
    private BufferedImage up1, up2, up3, down1, down2, down3, left1, left2, left3, right1, right2, right3;
    private String imgName;
    private String direction;// biến để cho biết khi nào nên dùng hành động nào
    // Biến lưu trữ để khiến thay đổi giữa up1 và up2
    private int spriteCounter = 0, spriteNum = 1;

    private Rectangle solidArea=new Rectangle(8,6,16,16);
   
   
    public int getDefaultSize() {
        return defaultSize;
    }

    public void setDefaultSize(int defaultSize) {
        this.defaultSize = defaultSize;
    }

    public int getImgNumber() {
        return ImgNumber;
    }

    public void setImgNumber(int imgNumber) {
        ImgNumber = imgNumber;
    }

    public int getPlayerWidth() {
        return PlayerWidth;
    }

    public void setPlayerWidth(int playerWidth) {
        PlayerWidth = playerWidth;
    }

    public int getPLayerHeight() {
        return PLayerHeight;
    }

    public void setPLayerHeight(int pLayerHeight) {
        PLayerHeight = pLayerHeight;
    }

    public int getPlayerPositionX() {
        return PlayerPositionX;
    }

    public void setPlayerPositionX(int playerPositionX) {
        PlayerPositionX = playerPositionX;
    }

    public int getPlayerPositionY() {
        return PlayerPositionY;
    }

    public void setPlayerPositionY(int playerPositionY) {
        PlayerPositionY = playerPositionY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public BufferedImage getUp1() {
        return up1;
    }

    public void setUp1(BufferedImage up1) {
        this.up1 = up1;
    }

    public BufferedImage getUp2() {
        return up2;
    }

    public void setUp2(BufferedImage up2) {
        this.up2 = up2;
    }

    public BufferedImage getUp3() {
        return up3;
    }

    public void setUp3(BufferedImage up3) {
        this.up3 = up3;
    }

    public BufferedImage getDown1() {
        return down1;
    }

    public void setDown1(BufferedImage down1) {
        this.down1 = down1;
    }

    public BufferedImage getDown2() {
        return down2;
    }

    public void setDown2(BufferedImage down2) {
        this.down2 = down2;
    }

    public BufferedImage getDown3() {
        return down3;
    }

    public void setDown3(BufferedImage down3) {
        this.down3 = down3;
    }

    public BufferedImage getLeft1() {
        return left1;
    }

    public void setLeft1(BufferedImage left1) {
        this.left1 = left1;
    }

    public BufferedImage getLeft2() {
        return left2;
    }

    public void setLeft2(BufferedImage left2) {
        this.left2 = left2;
    }

    public BufferedImage getLeft3() {
        return left3;
    }

    public void setLeft3(BufferedImage left3) {
        this.left3 = left3;
    }

    public BufferedImage getRight1() {
        return right1;
    }

    public void setRight1(BufferedImage right1) {
        this.right1 = right1;
    }

    public BufferedImage getRight2() {
        return right2;
    }

    public void setRight2(BufferedImage right2) {
        this.right2 = right2;
    }

    public BufferedImage getRight3() {
        return right3;
    }

    public void setRight3(BufferedImage right3) {
        this.right3 = right3;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getSpriteCounter() {
        return spriteCounter;
    }

    public void setSpriteCounter(int spriteCounter) {
        this.spriteCounter = spriteCounter;
    }

    public int getSpriteNum() {
        return spriteNum;
    }

    public void setSpriteNum(int spriteNum) {
        this.spriteNum = spriteNum;
    }

    public Rectangle getSolidArea() {
        return solidArea;
    }

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

}
