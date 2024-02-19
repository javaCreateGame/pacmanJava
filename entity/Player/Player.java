package entity.Player;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import main.MyFrame;

public class Player {
    public final int PlayerWidth = 48, PLayerHeight = 48;
    //Tạo biến lưu trữ tọa độ của nhân vật
    public int x, y;
    public int speed;
    //Tạo biến lưu trữ ảnh chuyển động của nhân vâth
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;//biến để cho biết khi nào nên dùng hành động nào
    //Biến lưu trữ để khiến thay đổi giữa up1 và up2
    public int spriteCounter = 0, spriteNum = 1;
    PlayerMove playermove;
    MyFrame Mf;

    public Player(MyFrame Mf, PlayerMove playermove) {
        this.Mf = Mf;
        this.playermove = playermove;
        //xét tọa độ và tốc độ ban đầu của nhân vật
        setDefaultPlayer();
        getPlayerImage();
    }

    public void setDefaultPlayer() {
        x = 30;
        y = 30;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            //lấy ảnh chuyển động ra từ folder picture
            up1 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerUp1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerUp2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerDown1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerDown2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerLeft1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerLeft2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerRight1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerRight2.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        //logic phần bấm bấm nút di chuyển
        if (playermove.playerRight || playermove.playerDown || playermove.playerUp || playermove.playerLeft) {
            if (playermove.playerUp) {
                direction = "up";
                y -= speed;
            }
            if (playermove.playerDown) {
                direction = "down";
                y += speed;
            }
            if (playermove.playerLeft) {
                direction = "left";
                x -= speed;
            }
            if (playermove.playerRight) {
                direction = "right";
                x += speed;
            }
            spriteCounter++;
            if (spriteCounter >= 12) {
                spriteNum = (spriteNum == 1) ? 2 : 1;
                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage img = null;
        //logic phần thay đổi qua lại giữa up1 và up2(down,left,right);
        switch (direction) {
            case "up":
                img = (spriteNum == 1) ? up1 : up2;
                break;
            case "down":
                img = (spriteNum == 1) ? down1 : down2;
                break;
            case "left":
                img = (spriteNum == 1) ? left1 : left2;
                break;
            case "right":
                img = (spriteNum == 1) ? right1 : right2;
                break;
        }
        //tạo nhân vật lên trên jframe;
        g2.drawImage(img, x, y, PlayerWidth, PLayerHeight, null);
    }
}
