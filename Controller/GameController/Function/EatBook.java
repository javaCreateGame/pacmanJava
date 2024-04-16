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
            int X = (x[i] + Mf.getGameModel().getSecondMap().getSecondMapModel().getNewImageIcon().getIconWidth())
                    - (Mf.getGameModel().getPlayer().getPlayerModel().getPlayerWidth()
                            + Mf.getGameModel().getPlayer().getPlayerModel().getPlayerPositionX());
            int Y = (y[i] + Mf.getGameModel().getSecondMap().getSecondMapModel().getNewImageIcon().getIconHeight())
                    - (Mf.getGameModel().getPlayer().getPlayerModel().getPLayerHeight()
                            + Mf.getGameModel().getPlayer().getPlayerModel().getPlayerPositionY());
            if (((X >= -28 && X <= 2 && Mf.getGameModel().getPlayer().getPlayerModel().getImgName() == "")
                    || (X >= -45 && X <= 3 && Mf.getGameModel().getPlayer().getPlayerModel().getImgName() == "Attack"))
                    &&
                    Y >= -49 && Y <= -12 && DefaultMap.getAddObj()[i] == true
                    && DefaultMap.getRemoveObj()[i] == false) {
                // Xóa hình sách trên map và cộng 100 điểm
                Mf.getGameModel().getSoundInternal().setFile(4);
                Mf.getGameModel().getSoundInternal().start();
                childJPanel.remove(obj[i]);
                DefaultMap.setAddObj(false, i);
                DefaultMap.setRemoveObj(true, i);
                Mf.getGameModel().setScore(Mf.getGameModel().getScore() + 100);
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
        switch (Mf.getGameModel().getNameCardLayout()) {
            case "FirstMap":
                eatBooks(Mf, Mf.getGameModel().getFirstMap().getFirstMapModel(),
                        Mf.getGameModel().getFirstMap().getFirstMapModel().getX(),
                        Mf.getGameModel().getFirstMap().getFirstMapModel().getY(),
                        Mf.getGameModel().getFirstMap().getFirstMapModel().getChildFirstMapPanel(),
                        Mf.getGameModel().getFirstMap().getFirstMapModel().getObj());
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
