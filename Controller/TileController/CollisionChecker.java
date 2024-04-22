package Controller.TileController;

import Model.EntityModel.PlayerModel.PlayerModel;
import Model.GameModel.GameModel;

public class CollisionChecker {
    GameModel Mf;

    public CollisionChecker(GameModel Mf) {
        this.Mf = Mf;
    }

    public void checkTile(PlayerModel player) {
        int playerLeftX = player.getPlayerPositionX()+player.getSolidArea().x;
        int playerRightX = player.getPlayerPositionX() + player.getSolidArea().x+player.getSolidArea().width;
        int playerTopY = player.getPlayerPositionY() +player.getSolidArea().y;
        int playerBottomY = player.getPlayerPositionY()+ player.getSolidArea().y+player.getSolidArea().height ;

        // xác định vị trí của các cạnh của vùng va chạm của người chơi.
        // int playerLeftX = player.getPlayerPositionX() + player.soildArea.x;
        // int playerRightX = player.getPlayerPositionX()  + player.soildArea.width;
        // int playerTopY = player.getPlayerPositionY() + player.soildArea.y;
        // int playerBottomY = player.getPlayerPositionY()  + player.soildArea.height;


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

}
