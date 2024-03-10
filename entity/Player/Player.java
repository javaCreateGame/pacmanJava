package entity.Player;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import main.MyFrame;

public class Player {
    private int defaultSize = 25;
    private int PlayerWidth, PLayerHeight;
    // Tạo biến lưu trữ tọa độ của nhân vật
    private int PlayerPositionX, PlayerPositionY;
    private int speed;
    // Tạo biến lưu trữ ảnh chuyển động của nhân vâth
    private BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    private String imgName;
    private String direction;// biến để cho biết khi nào nên dùng hành động nào
    // Biến lưu trữ để khiến thay đổi giữa up1 và up2
    private int spriteCounter = 0, spriteNum = 1;
    PlayerMove playermove;
    MyFrame Mf;

    public Player(MyFrame Mf, PlayerMove playermove) {
        this.Mf = Mf;
        this.playermove = playermove;
        // xét tọa độ và tốc độ ban đầu của nhân vật
        imgName = "";
        setDefaultPlayer();
        getPlayerImage(imgName);
    }

    public void setDefaultPlayer() {
        PlayerPositionX = 150;
        PlayerPositionY = 335;
        speed = 3;
        direction = "down";
    }

    public void getPlayerImage(String imageName) {
        try {
            // lấy ảnh chuyển động ra từ folder picture
            up1 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerUp" + imageName + "1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerUp" + imageName + "2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerDown" + imageName + "1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerDown" + imageName + "2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerLeft" + imageName + "1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerLeft" + imageName + "2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerRight" + imageName + "1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerRight" + imageName + "2.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        // logic phần bấm bấm nút di chuyển

        if (playermove.playerRight || playermove.playerDown || playermove.playerUp || playermove.playerLeft) {

          
            if (playermove.playerUp) {
                direction = "up";
                PlayerPositionY -= speed;
            }
            if (playermove.playerDown) {
                direction = "down";
                PlayerPositionY += speed;
            }
            if (playermove.playerLeft) {
                direction = "left";
                PlayerPositionX -= speed;
            }
            if (playermove.playerRight) {
                direction = "right";
                PlayerPositionX += speed;
            }
            spriteCounter++;
            if (spriteCounter >= 8) {
                spriteNum = (spriteNum == 1) ? 2 : 1;
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage img = null;

        // logic phần thay đổi qua lại giữa up1 và up2(down,left,right);
        switch (direction) {

            case "up":
                img = (spriteNum == 1) ? up1 : up2;
                defaultSize = (imgName == "Attack") ? 20 : 25;
                PlayerWidth = PLayerHeight = (imgName == "Attack") ? defaultSize * 2 : defaultSize;
                speed = (imgName == "Attack") ? 5 : 3;
                break;
            case "down":
                defaultSize = (imgName == "Attack") ? 20 : 25;
                img = (spriteNum == 1) ? down1 : down2;
                PlayerWidth = PLayerHeight = (imgName == "Attack") ? defaultSize * 2 : defaultSize;
                speed = (imgName == "Attack") ? 5 : 3;
                break;
            case "left":
                defaultSize = (imgName == "Attack") ? 20 : 25;
                img = (spriteNum == 1) ? left1 : left2;
                PLayerHeight = PlayerWidth = (imgName == "Attack") ? defaultSize * 2 : defaultSize;
                speed = (imgName == "Attack") ? 5 : 3;
                break;
            case "right":
                defaultSize = (imgName == "Attack") ? 18 : 25;
                img = (spriteNum == 1) ? right1 : right2;
                PLayerHeight = PlayerWidth = (imgName == "Attack") ? defaultSize * 2 : defaultSize;
                speed = (imgName == "Attack") ? 5 : 3;
                break;
        }

        // tạo nhân vật lên trên jframe;
        g2.drawImage(img, PlayerPositionX, PlayerPositionY, PlayerWidth, PLayerHeight, null);

    }

    public int getDefaultSize() {
        return defaultSize;
    }

    public void setDefaultSize(int defaultSize) {
        this.defaultSize = defaultSize;
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
    
}
