package Controller.EntityController.PlayerController;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Model.EntityModel.PlayerModel.PlayerModel;
import Model.GameModel.GameModel;
import View.EntityView.PlayerView.PlayerView;

public class PlayerController {
    GameModel Mf;
    PlayerModel playerModel;
    PlayerMoveController playerMoveController;
    PlayerView playerView;

    public PlayerController(GameModel Mf, PlayerMoveController playerMoveController) {
        this.Mf = Mf;
        this.playerMoveController = playerMoveController;
        playerModel = new PlayerModel();
        playerView = new PlayerView(playerModel);
    }

    public void update() {
        // Timer của mapLabel đang chạy thì nv ko di chuyển
        if (Mf.getFirstMap().getFirstMapModel().getTimer().isRunning() == true
                || Mf.getSecondMap().getSecondMapModel().getTimer2().isRunning() == true
                || Mf.getThirdMap().getThirdMapModel().getTimer3().isRunning() == true) {
        } else
        // logic phần bấm bấm nút di chuyển
        //Khi bấm các nút di chuyển
        if (playerMoveController.getPlayerMoveModel().isPlayerUp()
                || playerMoveController.getPlayerMoveModel().isPlayerDown()
                || playerMoveController.getPlayerMoveModel().isPlayerLeft()
                || playerMoveController.getPlayerMoveModel().isPlayerRight()) {

            if (playerMoveController.getPlayerMoveModel().isPlayerUp()) {
                playerModel.setDirection("up");
                // playerModel.setPlayerPositionY(playerModel.getPlayerPositionY() - playerModel.getSpeed());
            }
            if (playerMoveController.getPlayerMoveModel().isPlayerDown()) {
                playerModel.setDirection("down");
                // playerModel.setPlayerPositionY(playerModel.getPlayerPositionY() + playerModel.getSpeed());
            }
            if (playerMoveController.getPlayerMoveModel().isPlayerLeft()) {
                playerModel.setDirection("left");
                // playerModel.setPlayerPositionX(playerModel.getPlayerPositionX() - playerModel.getSpeed());
            }
            if (playerMoveController.getPlayerMoveModel().isPlayerRight()) {
                playerModel.setDirection("right");
                // playerModel.setPlayerPositionX(playerModel.getPlayerPositionX() + playerModel.getSpeed());
            }

            // check tile collision
            playerModel.setCollision(false);
            Mf.getCheck().checkTile(playerModel);
            // if collision is false, player can move

            if (playerModel.isCollision() == false) 
            {
                switch (playerModel.getDirection()) {
                    case "up":
                    playerModel.setPlayerPositionY(playerModel.getPlayerPositionY() - playerModel.getSpeed());
                

                    case "down":
                    playerModel.setPlayerPositionY(playerModel.getPlayerPositionY() + playerModel.getSpeed());
                        break;
                    case "left":
                    playerModel.setPlayerPositionX(playerModel.getPlayerPositionX() - playerModel.getSpeed());
                        break;

                    case "right":
                    playerModel.setPlayerPositionX(playerModel.getPlayerPositionX() + playerModel.getSpeed());
                        break;

                }
            }
            //Biến spriteCount chỉ số bước đi của nhân vật 
            
            playerModel.setSpriteCounter(playerModel.getSpriteCounter() + 1);
            //nếu số bước đi mà lớn hơn bằng 3
            if (playerModel.getSpriteCounter() >= 3) {
             //cho spritenum=1 nếu hiện nó đang bằng 2 và ngược lại
             //SpriterNum dùng để thay đổi luân phiên các hoạt ảnh của nhân vật như up1,up2,up3
                playerModel.setSpriteNum((playerModel.getSpriteNum() == 1) ? 2 : 1);
                //ResetSpriteCpunter
                playerModel.setSpriteCounter(0);
            }
        }
    }

    public void draw(Graphics2D g2) {
        //Tạo 1 biến img để có thể thay đổi luân phiên các hoạt ảnh
        //Như là khi đi lên thì thay ảnh mà nhân vật đi lên
        BufferedImage img = null;

        // logic phần thay đổi qua lại giữa up1 và up2(down,left,right);
        switch (playerModel.getDirection()) {
            //Nếu directtion là up
            case "up":
            //img = ảnh đc trả về từ hàm swapImage
                img = swapImage(playerModel.getUp1(), playerModel.getUp2(), playerModel.getUp3());
                changeSpeed_Size();
                break;
            case "down":
                img = swapImage(playerModel.getDown1(), playerModel.getDown2(), playerModel.getDown3());
                changeSpeed_Size();
                break;
            case "left":

                img = swapImage(playerModel.getLeft1(), playerModel.getLeft2(), playerModel.getLeft3());
                changeSpeed_Size();
                break;
            case "right":

                img = swapImage(playerModel.getRight1(), playerModel.getRight2(), playerModel.getRight3());
                changeSpeed_Size();
                break;
        }

        // tạo nhân vật lên trên jframe;
        g2.drawImage(img, playerModel.getPlayerPositionX(), playerModel.getPlayerPositionY(),
                playerModel.getPlayerWidth(), playerModel.getPLayerHeight(), null);

    }
     //Hàm thay đổi ảnh
    public BufferedImage swapImage(BufferedImage action1, BufferedImage action2, BufferedImage action3) {
       //nếu SpriteNum=1
        if (playerModel.getSpriteNum() == 1) {
            //Nếu ImgaeNumber=2
            // ImgaeNumber là biến để thay đổi giữa hoạt ảnh 2 và 3
            if (playerModel.getImgNumber() == 2) {
                //Trả về hoạt ảnh số 2 (up2,down2,..)
                return action2;

            }
            // nÊU iMAGEnUMBER=3 TRẢ VỀ HOẠT ảnh 3 
            else {

                return action3;

            }

        }
      //Thay đổi luân phiên ImgaeNumber giữa 2 và 3
      //Nếu hoạt ảnh số 2 có rồi thì kế tiếp là 3
        playerModel.setImgNumber((playerModel.getImgNumber() == 2) ? 3 : 2);
        //Nếu điều kiện trên k thỏa mãn trả về hoạt ảnh 1
        return action1;
    }
//Hàm thay đổi qua lại giữa dạng thường và dạng biến hình
    public void changeSpeed_Size() {
       //Nếu Imgaename là attack thì thay đổi default size và ngược lại
       //Imagename cho biến nhân vật hiện đanhg biến hình hay k 
        playerModel.setDefaultSize((playerModel.getImgName().contains("Attack")) ? 25 : 20);
        //Thay đổi width 
        playerModel.setPlayerWidth(playerModel.getDefaultSize());
        //Thay đổi height
        playerModel.setPLayerHeight((playerModel.getImgName().contains("Attack")) ? playerModel.getDefaultSize() + 15
                : playerModel.getDefaultSize() + 10);
        //Thay đổi speed
        playerModel.setSpeed(playerModel.getImgName().contains("Attack") ? 4 :2 );

    }

    public PlayerModel getPlayerModel() {
        return playerModel;
    }

    public PlayerView getPlayerView() {
        return playerView;
    }

}