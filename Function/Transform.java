package Function;

import java.util.Timer;
import java.util.TimerTask;

import main.MyFrame;

public class Transform {
    
     public static void transform( MyFrame Mf,int heartXLocation, int heartYLocation,
        boolean addHeart,boolean removeHeart) {
        double dem = Math.floor((Math.random()*2)+1);
     
        // Set các điều kiện để nhân vật có thể biến hình
        int X = (heartXLocation + Mf.getSecondMap().getNewImageIconHeart().getIconWidth())
                - (Mf.getPlayer().getPlayerWidth() + Mf.getPlayer().getPlayerPositionX());
        int Y = (heartYLocation + Mf.getSecondMap().getNewImageIconHeart().getIconHeight())
                - (Mf.getPlayer().getPLayerHeight() + Mf.getPlayer().getPlayerPositionY());
        if (X >= -30 && X <= 7 && Y >= -45 && Y <= -8 && addHeart == true
                && removeHeart == false) {
            // Nhân vật không thể biến hình và bị giảm 500 điểm
            if (dem == 1) {
                Mf.getPlayer().setImgName("") ;
                Mf.setScore(Mf.getScore()-500);
               
            }
            // Cho nhân vật biến hình và sau 10s về như cũ
            if (dem == 2) {
                Mf.getPlayer().setImgName("Attack");
                Mf.getSoundNext().setFile(5);
                Mf.getSoundNext().start();

                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Mf.getPlayer().setImgName("");
                        timer.cancel();
                    }
                }, 10000);
            }
            // Xóa hình trái tym trên map
           
            if(Mf.getNameCardLayout()=="FirstMap"){
              Mf.getFirstMap().setAddHeart(false);
              Mf.getFirstMap().setRemoveHeart(true);
              Mf.getFirstMap().getChildFirstMapPanel().remove( Mf.getFirstMap().getHeart());
            }
            else if(Mf.getNameCardLayout()=="SecondMap"){
                Mf.getSecondMap().setAddHeart(false);
                Mf.getSecondMap().setRemoveHeart(true);
                Mf.getSecondMap().getChildSecondMapPanel().remove(Mf.getSecondMap().getHeart());
            }
            else if(Mf.getNameCardLayout()=="ThirdMap"){
                Mf.getThirdMap().setAddHeart(false);
                Mf.getThirdMap().setRemoveHeart(true);
                Mf.getThirdMap().getChildThirdMapPanel().remove( Mf.getThirdMap().getHeart());
            }

        }
        Mf.getPlayer().getPlayerImage( Mf.getPlayer().getImgName());
    }

    
    public static void getTransform(MyFrame Mf) {
        switch (Mf.getNameCardLayout()) {
            case "FirstMap":
                transform( Mf,Mf.getFirstMap().getHeartXLocation(),
                        Mf.getFirstMap().getHeartYLocation(), Mf.getFirstMap().isAddHeart(),Mf.getFirstMap().isRemoveHeart());
                break;
            case "SecondMap":
                transform( Mf,Mf.getSecondMap().getHeartXLocation(),
                        Mf.getSecondMap().getHeartYLocation(), Mf.getSecondMap().isAddHeart(),Mf.getSecondMap().isRemoveHeart());
                break;
            case "ThirdMap":
                transform( Mf,Mf.getThirdMap().getHeartXLocation(),
                          Mf.getThirdMap().getHeartYLocation(),Mf.getThirdMap().isAddHeart(),Mf.getThirdMap().isRemoveHeart());
                 break;
                
        }
    }



    
}
