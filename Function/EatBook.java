package Function;

import javax.swing.JLabel;
import javax.swing.JPanel;

import State.Map;
import main.MyFrame;

public class EatBook {
    
    // Hàm set sự kiến ăn sách
    public static void eatBooks(MyFrame Mf,Map DefaultMap, int x[], int y[], JPanel childJPanel, JLabel obj[]) {
        // Set các điều kiện để nhân vật ăn sách
        for (int i = 0; i < x.length; i++) {
            int X = (x[i] + Mf.getSecondMap().getNewImageIcon().getIconWidth()) - (Mf.getPlayer().getPlayerWidth() + Mf.getPlayer().getPlayerPositionX());
            int Y = (y[i] + Mf.getSecondMap().getNewImageIcon().getIconHeight()) - (Mf.getPlayer().getPLayerHeight() + Mf.getPlayer().getPlayerPositionY());
            if (((X >= -28 && X <= 2 && Mf.getPlayer().getImgName() == "")
                    || (X >= -45 && X <= 3 && Mf.getPlayer().getImgName() == "Attack")) &&
                    Y >= -49 && Y <= -12 && DefaultMap.getAddObj()[i] == true && DefaultMap.getRemoveObj()[i] == false) {
                // Xóa hình sách trên map và cộng 100 điểm
                Mf.getSoundInternal().setFile(4);
                Mf.getSoundInternal().start();
                childJPanel.remove(obj[i]);
                DefaultMap.setAddObj(false, i);
                DefaultMap.setRemoveObj(true, i);
                Mf.setScore(Mf.getScore()+100);
            }
        }
    }

    // Hàm lấy ra điểm sau khi ăn sách
    public static void getEatBooks(MyFrame Mf) {
        switch (Mf.getNameCardLayout()) {
            case "FirstMap":
                eatBooks(Mf,Mf.getFirstMap(), Mf.getFirstMap().getX(), Mf.getFirstMap().getY(), Mf.getFirstMap().getChildFirstMapPanel(),
                        Mf.getFirstMap().getObj());
                Mf.updateScore();
                break;
            case "SecondMap":
                eatBooks(Mf,Mf.getSecondMap(), Mf.getSecondMap().getX(), Mf.getSecondMap().getY(), Mf.getSecondMap().getChildSecondMapPanel(),
                        Mf.getSecondMap().getObj());
                Mf.updateScore();
                break;
            case "ThirdMap":
                eatBooks(Mf,Mf.getThirdMap(), Mf.getThirdMap().getX(), Mf.getThirdMap().getY(), Mf.getThirdMap().getChildThirdMapPanel(), Mf.getThirdMap().getObj());
                Mf.updateScore();
                break;
        }
    }

}
