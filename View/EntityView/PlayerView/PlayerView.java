package View.EntityView.PlayerView;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import Model.EntityModel.PlayerModel.PlayerModel;

public class PlayerView {
    private PlayerModel playerModel;
    public PlayerView(PlayerModel playerModel){
        this.playerModel=playerModel;
        playerModel.setImgName("");
        setDefaultPlayer();
        getPlayerImage(playerModel.getImgName());
    }
     public void setDefaultPlayer() {
        playerModel.setPlayerPositionX(150);
        playerModel.setPlayerPositionY(335);
        playerModel.setSpeed(3);
        playerModel.setDirection("down");
    }

    public void getPlayerImage(String imageName) {
        try {
            // lấy ảnh chuyển động ra từ folder picture
            playerModel.setUp1(ImageIO.read(getClass().getResourceAsStream("/picture/PlayerUp" + imageName + "1.png")));
            playerModel.setUp2(ImageIO.read(getClass().getResourceAsStream("/picture/PlayerUp" + imageName + "2.png")));
            playerModel.setUp3(ImageIO.read(getClass().getResourceAsStream("/picture/PlayerUp" + imageName + "3.png")));
            playerModel.setDown1(ImageIO.read(getClass().getResourceAsStream("/picture/PlayerDown" + imageName + "1.png"))) ;
            playerModel.setDown2(ImageIO.read(getClass().getResourceAsStream("/picture/PlayerDown" + imageName + "2.png"))) ;
            playerModel.setDown3(ImageIO.read(getClass().getResourceAsStream("/picture/PlayerDown" + imageName + "3.png"))) ;
            playerModel.setLeft1(ImageIO.read(getClass().getResourceAsStream("/picture/PlayerLeft" + imageName + "1.png")));
            playerModel.setLeft2(ImageIO.read(getClass().getResourceAsStream("/picture/PlayerLeft" + imageName + "2.png")));
            playerModel.setLeft3(ImageIO.read(getClass().getResourceAsStream("/picture/PlayerLeft" + imageName + "3.png")));
            playerModel.setRight1(ImageIO.read(getClass().getResourceAsStream("/picture/PlayerRight" + imageName + "1.png"))); 
            playerModel.setRight2(ImageIO.read(getClass().getResourceAsStream("/picture/PlayerRight" + imageName + "2.png"))); 
            playerModel.setRight3(ImageIO.read(getClass().getResourceAsStream("/picture/PlayerRight" + imageName + "3.png"))); 

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    public PlayerModel getPlayerModel() {
        return playerModel;
    }

   
}
