package Controller.TileController;

import java.util.Arrays;

import Model.EntityModel.MonsterModel.MonsterModel;
import Model.EntityModel.PlayerModel.PlayerModel;
import Model.GameModel.GameModel;

public class CollisionChecker {
    GameModel Mf;

    public CollisionChecker(GameModel Mf) {
        this.Mf = Mf;
    }

    public void checkTile(PlayerModel player) {
        // int playerLeftX = player.getPlayerPositionX()+player.getSolidArea().x;
        // int playerRightX = player.getPlayerPositionX() + player.getSolidArea().x+player.getSolidArea().width;
        // int playerTopY = player.getPlayerPositionY() +player.getSolidArea().y;
        // int playerBottomY = player.getPlayerPositionY()+ player.getSolidArea().y+player.getSolidArea().height ;

        // xác định vị trí của các cạnh của vùng va chạm của người chơi.
        int playerLeftX = player.getPlayerPositionX()+player.getSolidArea().x;
        int playerRightX = player.getPlayerPositionX() + player.getSolidArea().width ;
        int playerTopY = player.getPlayerPositionY() +player.getSolidArea().y;
        int playerBottomY = player.getPlayerPositionY()+ (player.getSolidArea().y) ;


        // xác định chỉ số cột và hàng của các ô tile mà người chơi đang tiếp xúc.
        int playerLeftCol = playerLeftX / 16;
        int playerRightCol = playerRightX / 16;
        int playerTopRow = playerTopY / 16;
        int playerBottomRow = playerBottomY / 16;

        int tileNum1, tileNum2;

        try {

            switch (player.getDirection()) {
                case "up":
                    playerTopRow = (playerTopY - player.getSpeed()) / 16;
                    tileNum1 = Mf.getTileManager().getMapTileNum()[playerLeftCol][playerTopRow];
                  
                    tileNum2 = Mf.getTileManager().getMapTileNum()[playerRightCol][playerTopRow];
                    if(Mf.getTileManager().getTile()[tileNum1].collision == true || Mf.getTileManager().getTile()[tileNum2]. collision == true){
                        player.setCollision(true); 
                    }
                    break;
                case "down":
                   playerBottomRow = (playerBottomY + player.getSpeed()) / 16;
                    tileNum1 = Mf.getTileManager().getMapTileNum()[playerLeftCol][playerBottomRow];
                    tileNum2 = Mf.getTileManager().getMapTileNum()[playerRightCol][playerBottomRow];
                    if(Mf.getTileManager().getTile()[tileNum1]. collision == true || Mf.getTileManager().getTile()[tileNum2]. collision == true){
                        player.setCollision(true); 
                    }
                break;

                case "left":
                playerLeftCol = (playerLeftX - player.getSpeed()) / 16;
                    tileNum1 = Mf.getTileManager().getMapTileNum()[playerLeftCol][playerTopRow];
                    tileNum2 = Mf.getTileManager().getMapTileNum()[playerLeftCol][playerBottomRow];
                    if(Mf.getTileManager().getTile()[tileNum1]. collision == true || Mf.getTileManager().getTile()[tileNum2]. collision == true){
                        player.setCollision(true); 
                    }
                break;

                case "right":
                playerRightCol = (playerRightX + player.getSpeed()) / 16;
                    tileNum1 = Mf.getTileManager().getMapTileNum()[playerRightCol][playerTopRow];
                    tileNum2 = Mf.getTileManager().getMapTileNum()[playerRightCol][playerBottomRow];
                    if(Mf.getTileManager().getTile()[tileNum1]. collision == true || Mf.getTileManager().getTile()[tileNum2]. collision == true){
                        player.setCollision(true); 
                    }
                break;

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void check(MonsterModel monsterModel){
        int monsterLeftX = monsterModel.getxDice();
        int monsterRightX = monsterModel.getxDice() + 10;
        int monsterTopY = monsterModel.getyDice() ;
        int monsterBottomY = monsterModel.getyDice()+ 10 ;

       


        int top=monsterTopY /16;
        int bottom=monsterBottomY /16;
        int left=monsterLeftX /16;
        int right= monsterRightX  /16;

          
     
        int num[]=new int[8];

         int monsterTopRow = (monsterTopY + monsterModel.getyVelocity()[0]) / 16;
        num[0] = Mf.getTileManager().getMapTileNum()[left][monsterTopRow];
        num[1]= Mf.getTileManager().getMapTileNum()[right][monsterTopRow];
        
       int monsterBottomRow = ( monsterBottomY - monsterModel.getyVelocity()[0]) / 16;
        num[2] = Mf.getTileManager().getMapTileNum()[left][monsterBottomRow];
        num[3]= Mf.getTileManager().getMapTileNum()[right][monsterBottomRow];

       
        int monsterLeftCol= (monsterLeftX - monsterModel.getxVelocity()[0]) / 16;
        num[4] = Mf.getTileManager().getMapTileNum()[monsterLeftCol][top];
        num[5]= Mf.getTileManager().getMapTileNum()[monsterLeftCol][bottom];


         int monsterRightCol = (monsterRightX + monsterModel.getxVelocity()[0]) / 16;
        num[6] = Mf.getTileManager().getMapTileNum()[monsterRightCol][top];
        num[7]= Mf.getTileManager().getMapTileNum()[monsterRightCol][bottom];
        
       
       
        for(int x:num){
            if (Mf.getTileManager().getTile()[x].collision==true) {
                monsterModel.setCollision(true);;
            }
        }
     // monsterModel.setCollisionOnDice(checkMonster(monsterModel.getxDice(), monsterModel.getyDice(), 0, monsterModel.getDefaultSize(), monsterModel.getxVelocity()[0], monsterModel.getyVelocity()[0]));
      //monsterModel.setCollisionOnJoystic(checkMonster(monsterModel.getxJoystick(), monsterModel.getyJoystick(), 0, monsterModel.getDefaultSize(), monsterModel.getxVelocity()[1], monsterModel.getyVelocity()[1]));
     //monsterModel.setCollisionOnSyrinnge(checkMonster(monsterModel.getxSyrinnge(), monsterModel.getySyrinnge(), 10, monsterModel.getDefaultSize(), monsterModel.getxVelocity()[2], monsterModel.getyVelocity()[2]));    
}
    private boolean checkMonster(int xMonster,int yMonster,int bonusSize,int size,int xSpeed,int Yspeed){
        int monsterLeftX = xMonster+bonusSize;
        int monsterRightX = xMonster + size+bonusSize;
        int monsterTopY = yMonster+bonusSize;
        int monsterBottomY = yMonster+ size +bonusSize;

       

        int left=monsterLeftX / (size+bonusSize);
        int right=monsterRightX  / (size+bonusSize);
        int top=monsterTopY / (size+bonusSize);
        int bottom=monsterBottomY / (size+bonusSize);
   
        int num[]=new int[8];
        Arrays.fill(num,0);
       checkTileNeaest(xSpeed,Yspeed, size, bonusSize, top, num[0], num[1], left, right, "y","Top");
       checkTileNeaest(xSpeed,Yspeed, size, bonusSize, bottom, num[2], num[3], left, right, "y","Bottom");
       checkTileNeaest(xSpeed,Yspeed, size, bonusSize, left, num[4], num[5], top,bottom, "x","Left");
       checkTileNeaest(xSpeed,Yspeed, size, bonusSize, right, num[6], num[7],  top,bottom, "x","Right");
       for(int x:num){
        if (Mf.getTileManager().getTile()[x].collision==true) {
            return true;
        }
    }
    return false;
       }
       
    
   public void checkTileNeaest (int Xspeed,int Yspeed,int size,int bonusSize,int sameRoworCol,int numFirst,int numSecond,int directionFirst,int directionSecond,String Velocity,String Velocity1){
   
    if (Velocity=="y") {
        int a=(Velocity1=="Bottom")?Yspeed*(-1):Yspeed;
        int Row = (sameRoworCol - a) / (size+bonusSize);
        if (Row <Mf.getMaxScreenRow() && Row>0) {
            numFirst = Mf.getTileManager().getMapTileNum()[directionFirst][Row];
            numSecond= Mf.getTileManager().getMapTileNum()[directionSecond][Row];   
        }
    }
    if (Velocity=="x") {
        int a=(Velocity1=="Right")? Xspeed*(-1):Xspeed;
        int Col = (sameRoworCol - a) / (size+bonusSize);
        if (Col <Mf.getMaxScreenCol() && Col >0) {
            numFirst = Mf.getTileManager().getMapTileNum()[directionFirst][Col];
            numSecond= Mf.getTileManager().getMapTileNum()[directionSecond][Col];   
        }
    }
}

}
