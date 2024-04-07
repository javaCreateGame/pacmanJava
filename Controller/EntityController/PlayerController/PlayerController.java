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
   public PlayerController(GameModel Mf,PlayerMoveController playerMoveController){
    this.Mf=Mf;
    this.playerMoveController=playerMoveController;
    playerModel=new PlayerModel( );
    playerView=new PlayerView(playerModel);
   }
   public void update() {
    //Timer của mapLabel đang chạy thì nv ko di chuyển
    if (Mf.getFirstMap().getFirstMapModel().getTimer().isRunning() == true || Mf.getSecondMap().getSecondMapModel().getTimer2().isRunning() == true || Mf.getThirdMap().getThirdMapModel().getTimer3().isRunning() == true){}
    else
    // logic phần bấm bấm nút di chuyển
    if (playerMoveController.getPlayerMoveModel().isPlayerUp() || playerMoveController.getPlayerMoveModel().isPlayerDown() || playerMoveController.getPlayerMoveModel().isPlayerLeft() || playerMoveController.getPlayerMoveModel().isPlayerRight()) {

       
       
        if (playerMoveController.getPlayerMoveModel().isPlayerUp()) {
            playerModel.setDirection("up");
            playerModel.setPlayerPositionY(playerModel.getPlayerPositionY()-playerModel.getSpeed());
        }
        if (playerMoveController.getPlayerMoveModel().isPlayerDown()) {
            playerModel.setDirection("down");
            playerModel.setPlayerPositionY(playerModel.getPlayerPositionY()+playerModel.getSpeed());
        }
        if (playerMoveController.getPlayerMoveModel().isPlayerLeft() ) {
            playerModel.setDirection("left");
            playerModel.setPlayerPositionX(playerModel.getPlayerPositionX()-playerModel.getSpeed());
        }
        if (playerMoveController.getPlayerMoveModel().isPlayerRight()) {
            playerModel.setDirection("right");
            playerModel.setPlayerPositionX(playerModel.getPlayerPositionX()+playerModel.getSpeed());
        }
       playerModel.setSpriteCounter(playerModel.getSpriteCounter()+1);
        if (playerModel.getSpriteCounter() >= 3) {
            
            playerModel.setSpriteNum((playerModel.getSpriteNum()==1)?2:1);
            playerModel.setSpriteCounter(0);
        }
    }
}
public void draw(Graphics2D g2) {
    BufferedImage img = null;

    // logic phần thay đổi qua lại giữa up1 và up2(down,left,right);
    switch (playerModel.getDirection()) {

        case "up":
       img=swapImage( playerModel.getUp1(), playerModel.getUp2(), playerModel.getUp3());
           changeSpeed_Size();
            break;
        case "down":
            img=swapImage( playerModel.getDown1(), playerModel.getDown2(), playerModel.getDown3());    
           changeSpeed_Size();
            break;
        case "left":
           
            img=swapImage(playerModel.getLeft1(), playerModel.getLeft2(), playerModel.getLeft3());
            changeSpeed_Size();
            break;
        case "right":
            
            img=swapImage(playerModel.getRight1(), playerModel.getRight2(), playerModel.getRight3());
          changeSpeed_Size();
            break;
    }

    // tạo nhân vật lên trên jframe;
    g2.drawImage(img, playerModel.getPlayerPositionX(), playerModel.getPlayerPositionY(), playerModel.getPlayerWidth(), playerModel.getPLayerHeight(), null);

}

public BufferedImage swapImage(BufferedImage action1,BufferedImage action2,BufferedImage action3){
    if (playerModel.getSpriteNum()==1) {
        if (playerModel.getImgNumber()==2) {
            return action2;
            
        }
        else{
           return action3;
        
        }
    
    }
   
    playerModel.setImgNumber((playerModel.getImgNumber()==2)?3:2);
        return action1;
}
public void changeSpeed_Size(){
    playerModel.setDefaultSize((playerModel.getImgName().contains("Attack")) ? 35 : 30);
    playerModel.setPlayerWidth(playerModel.getDefaultSize());
    playerModel.setPLayerHeight((playerModel.getImgName().contains("Attack")) ?playerModel.getDefaultSize()+15  : playerModel.getDefaultSize()+10);  
    playerModel.setSpeed(playerModel.getImgName().contains("Attack")? 6 : 3);
    
}
public PlayerModel getPlayerModel() {
    return playerModel;
}
public PlayerView getPlayerView() {
    return playerView;
}

}
