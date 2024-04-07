package Controller.GameController.Function;

import Model.GameModel.GameModel;
import java.util.Timer;
import java.util.TimerTask;
public class Transform {
    public static void transform( GameModel Mf,int heartXLocation, int heartYLocation,
    boolean addHeart,boolean removeHeart) {
    double dem = Math.floor((Math.random()*2)+1);
 
    // Set các điều kiện để nhân vật có thể biến hình
    int X = (heartXLocation + Mf.getSecondMap().getSecondMapModel().getNewImageIconHeart().getIconWidth())
            - (Mf.getPlayer().getPlayerModel().getPlayerWidth() + Mf.getPlayer().getPlayerModel().getPlayerPositionX());
    int Y = (heartYLocation + Mf.getSecondMap().getSecondMapModel().getNewImageIconHeart().getIconHeight())
            - (Mf.getPlayer().getPlayerModel().getPLayerHeight() + Mf.getPlayer().getPlayerModel().getPlayerPositionY());
    if (X >= -30 && X <= 7 && Y >= -45 && Y <= -8 && addHeart == true
            && removeHeart == false) {
        // Nhân vật không thể biến hình và bị giảm 500 điểm
        if (dem == 1) {
           
            Mf.setScore(Mf.getScore()-500);
           
        }
        // Cho nhân vật biến hình và sau 10s về như cũ
        if (dem == 2) {
            Mf.getPlayer().getPlayerModel().setImgName("Attack");
            Mf.getSoundNext().setFile(5);
            Mf.getSoundNext().start();

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Mf.getPlayer().getPlayerModel().setImgName("");
                    timer.cancel();
                }
            }, 10000);
        }
        // Xóa hình trái tym trên map
       
        if(Mf.getNameCardLayout()=="FirstMap"){
          Mf.getFirstMap().getFirstMapModel().setAddHeart(false);
          Mf.getFirstMap().getFirstMapModel().setRemoveHeart(true);
          Mf.getFirstMap().getFirstMapModel().getChildFirstMapPanel().remove( Mf.getFirstMap().getFirstMapModel().getHeart());
        }
        else if(Mf.getNameCardLayout()=="SecondMap"){
            Mf.getSecondMap().getSecondMapModel().setAddHeart(false);
            Mf.getSecondMap().getSecondMapModel().setRemoveHeart(true);
            Mf.getSecondMap().getSecondMapModel().getChildSecondMapPanel().remove(Mf.getSecondMap().getSecondMapModel().getHeart());
        }
        else if(Mf.getNameCardLayout()=="ThirdMap"){
            Mf.getThirdMap().getThirdMapModel().setAddHeart(false);
            Mf.getThirdMap().getThirdMapModel().setRemoveHeart(true);
            Mf.getThirdMap().getThirdMapModel().getChildThirdMapPanel().remove(Mf.getThirdMap().getThirdMapModel().getHeart());
        }

    }
    Mf.getPlayer().getPlayerView().getPlayerImage( Mf.getPlayer().getPlayerModel().getImgName());
}


public static void getTransform(GameModel Mf) {
    switch (Mf.getNameCardLayout()) {
        case "FirstMap":
            transform( Mf,Mf.getFirstMap().getFirstMapModel().getHeartXLocation(),
                    Mf.getFirstMap().getFirstMapModel().getHeartYLocation(), Mf.getFirstMap().getFirstMapModel().isAddHeart(),Mf.getFirstMap().getFirstMapModel().isRemoveHeart());
            break;
        case "SecondMap":
            transform( Mf,Mf.getSecondMap().getSecondMapModel().getHeartXLocation(),
                    Mf.getSecondMap().getSecondMapModel().getHeartYLocation(), Mf.getSecondMap().getSecondMapModel().isAddHeart(),Mf.getSecondMap().getSecondMapModel().isRemoveHeart());
            break;
        case "ThirdMap":
            transform( Mf,Mf.getThirdMap().getThirdMapModel().getHeartXLocation(),
                      Mf.getThirdMap().getThirdMapModel().getHeartYLocation(),Mf.getThirdMap().getThirdMapModel().isAddHeart(),Mf.getThirdMap().getThirdMapModel().isRemoveHeart());
             break;
            
    }
}
}
