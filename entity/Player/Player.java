package entity.Player;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import main.MyFrame;

public class Player {
    private int defaultSize = 30;
    int ImgNumber=2;
    private int PlayerWidth=30, PLayerHeight=40;
    // Tạo biến lưu trữ tọa độ của nhân vật
    private int PlayerPositionX, PlayerPositionY;
    private int speed;
    // Tạo biến lưu trữ ảnh chuyển động của nhân vâth
    private BufferedImage up1, up2, up3, down1, down2,down3, left1, left2,left3, right1, right2,right3;
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
            up3 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerUp" + imageName + "3.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerDown" + imageName + "1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerDown" + imageName + "2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerDown" + imageName + "3.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerLeft" + imageName + "1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerLeft" + imageName + "2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerLeft" + imageName + "3.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerRight" + imageName + "1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerRight" + imageName + "2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/picture/PlayerRight" + imageName + "3.png"));

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
            if (spriteCounter >= 3) {
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
           img=swapImage( up1, up2, up3);
               changeSpeed_Size();
                break;
            case "down":
                img=swapImage( down1, down2, down3);    
               changeSpeed_Size();
                break;
            case "left":
               
                img=swapImage( left1, left2, left3);
                changeSpeed_Size();
                break;
            case "right":
                
                img=swapImage( right1, right2, right3);
              changeSpeed_Size();
                break;
        }

        // tạo nhân vật lên trên jframe;
        g2.drawImage(img, PlayerPositionX, PlayerPositionY, PlayerWidth, PLayerHeight, null);

    }

    public BufferedImage swapImage(BufferedImage action1,BufferedImage action2,BufferedImage action3){
        if (spriteNum==1) {
            if (ImgNumber==2) {
                return action2;
                
            }
            else{
               return action3;
            
            }
        
        }
        ImgNumber=(ImgNumber==2)? 3:2;
            return action1;
    }
    public void changeSpeed_Size(){
        defaultSize = (imgName.contains("Attack")) ? 35 : 30;
        PlayerWidth = defaultSize;
        PLayerHeight=(imgName == "Attack")? defaultSize+15 :defaultSize+10;
        speed = (imgName == "Attack") ? 6 : 3;
    }
    public int getPlayerWidth() {
        return PlayerWidth;
    }

    public int getPLayerHeight() {
        return PLayerHeight;
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

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }
    
}
