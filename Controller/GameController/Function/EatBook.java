package Controller.GameController.Function;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.GameController.GameController;

import Model.StateModel.MapModel;


public class EatBook {
    // Hàm set sự kiến ăn sách
    public static void eatBooks(GameController Mf, MapModel DefaultMap, int x[], int y[], JPanel childJPanel,
            JLabel obj[]) {
        // Set các điều kiện để nhân vật ăn sách
        for (int i = 0; i < x.length; i++) {
            //X là khoảng cách giữa nhân vật và sachs theo tọa độ X
            int X = (x[i] + Mf.getGameModel().getSecondMap().getSecondMapModel().getNewImageIcon().getIconWidth())
                    - (Mf.getGameModel().getPlayer().getPlayerModel().getPlayerWidth()
                            + Mf.getGameModel().getPlayer().getPlayerModel().getPlayerPositionX());
            //Y là khoảng cách giữa nhân vật và sách theo tọa độ Y
            int Y = (y[i] + Mf.getGameModel().getSecondMap().getSecondMapModel().getNewImageIcon().getIconHeight())
                    - (Mf.getGameModel().getPlayer().getPlayerModel().getPLayerHeight()
                            + Mf.getGameModel().getPlayer().getPlayerModel().getPlayerPositionY());
            //Nếu nhân vật và sách trong khoảng cách cố định và sách vẫn chưa được ăn trước đó
            if (((X >= -28 && X <= 2 )
                    || (X >= -45 && X <= 3 && Mf.getGameModel().getPlayer().getPlayerModel().getImgName() == "Attack"))
                    &&
                    Y >= -49 && Y <= -12 && DefaultMap.getAddObj()[i] == true
                    && DefaultMap.getRemoveObj()[i] == false) {
               
                //Mở âm thanh ăn sách
                Mf.getGameModel().getSoundInternal().setFile(4);
                Mf.getGameModel().getSoundInternal().start();
                //Xóa sách đó ra khỏi màn hình
                childJPanel.remove(obj[i]);
                // cho 2 biến đổi để biết mình đã xóa rồi và k thể ăn đc 
                DefaultMap.setAddObj(false, i);
                DefaultMap.setRemoveObj(true, i);
                 // Xóa hình sách trên map và cộng 100 điểm
                Mf.getGameModel().setScore(Mf.getGameModel().getScore() + 100);

                //Vì khi ăn thì sẽ có nhạc ăn hiện lên
                //nên sẽ tạo thành các luồng âm thành dư thừa làm game chậm
                //vậy lên sau khi ăn xong 
                //cứ sau 300 mili thì xóa
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Mf.getGameModel().getSoundInternal().close();
                        timer.cancel();
                    }
                }, 300);
            }
        }
    }

    // Hàm lấy ra điểm sau khi ăn sách
    public static void getEatBooks(GameController Mf) {
        //Set ăn sách cho từng map
        switch (Mf.getGameModel().getNameCardLayout()) {
            case "FirstMap":
                eatBooks(Mf, Mf.getGameModel().getFirstMap().getFirstMapModel(),
                        Mf.getGameModel().getFirstMap().getFirstMapModel().getX(),
                        Mf.getGameModel().getFirstMap().getFirstMapModel().getY(),
                        Mf.getGameModel().getFirstMap().getFirstMapModel().getChildFirstMapPanel(),
                        Mf.getGameModel().getFirstMap().getFirstMapModel().getObj());
                //Đổi giá trị score trên giao diện thành giá trị mới
                Mf.getGameView().updateScore();
              
                break;
            case "SecondMap":
                eatBooks(Mf, Mf.getGameModel().getSecondMap().getSecondMapModel(),
                        Mf.getGameModel().getSecondMap().getSecondMapModel().getX(),
                        Mf.getGameModel().getSecondMap().getSecondMapModel().getY(),
                        Mf.getGameModel().getSecondMap().getSecondMapModel().getChildSecondMapPanel(),
                        Mf.getGameModel().getSecondMap().getSecondMapModel().getObj());
                Mf.getGameView().updateScore();
               break;
            case "ThirdMap":
                eatBooks(Mf, Mf.getGameModel().getThirdMap().getThirdMapModel(),
                        Mf.getGameModel().getThirdMap().getThirdMapModel().getX(),
                        Mf.getGameModel().getThirdMap().getThirdMapModel().getY(),
                        Mf.getGameModel().getThirdMap().getThirdMapModel().getChildThirdMapPanel(),
                        Mf.getGameModel().getThirdMap().getThirdMapModel().getObj());
               Mf.getGameView().updateScore();
               break;
        }
    }

}
