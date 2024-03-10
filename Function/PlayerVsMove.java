package Function;

import main.MyFrame;

public class PlayerVsMove {
  // Hàm boolean trả về giá trị true nếu nhân vật chạm vào quái
  public static boolean removeImage(MyFrame Mf,int xMonsterImg, int yMonsterImg, boolean monsterVisible) {
    int X = (xMonsterImg + Mf.getMonster().getMonsterWidth()) - (Mf.getPlayer().getPlayerWidth() + Mf.getPlayer().getPlayerPositionX());
    int Y = (yMonsterImg + Mf.getMonster().getMonsterHeight()) - (Mf.getPlayer().getPLayerHeight() + Mf.getPlayer().getPlayerPositionY());
    if (X >= -20 && X <= 5 && Y >= -20 && Y <= 5 && monsterVisible == true) {
        return true;
    }
    return false;
}

// hÀM setlogic cho player đánh nhau vs quái khi k ăn trái tym
public static void removePlayer(MyFrame Mf) {
    // Mảng sTRING lưu trữ các kịch bản end riêng khi quái chạm vào
   
    // Tạo các biến boolean cho biết mình đụng vào quái nào
    boolean pVsDice = removeImage(Mf,Mf.getMonster().getxDice(), Mf.getMonster().getyDice(), Mf.getMonster().getMonsterVisible(0));
    boolean pVsJoystick = removeImage(Mf,Mf.getMonster().getxJoystick(), Mf.getMonster().getyJoystick(), Mf.getMonster().getMonsterVisible(1));
    boolean pVsSyrinnge = removeImage(Mf,Mf.getMonster().getxSyrinnge(), Mf.getMonster().getySyrinnge(), Mf.getMonster().getMonsterVisible(2));
    // Nếu đụng vào quái nào thì hiện lên thông báo kết thúc game và lựa chọn
    if (pVsDice == true || pVsSyrinnge == true || pVsJoystick == true) {
        Mf.getSoundMain().stop();
    
       
        if (pVsDice == true) {
            Mf.getBadEnding().setNumberBad(0);
        } else if (pVsJoystick == true) {
            Mf.getBadEnding().setNumberBad(1);
        } else if (pVsSyrinnge == true) {
            Mf.getBadEnding().setNumberBad(2);
        }
      Ending.BadEnding(Mf, Mf.getBadEnding().getNumberBad());
    }
}


// hÀM setlogic cho player đánh nhau vs quái khi ăn trái tym
public static void removeMonster(MyFrame Mf) {
    // Tạo các biến boolean cho biết mình đụng vào quái nào
    boolean pVsDice = removeImage(Mf,Mf.getMonster().getxDice(), Mf.getMonster().getyDice(), Mf.getMonster().getMonsterVisible(0));
    boolean pVsJoystick = removeImage(Mf,Mf.getMonster().getxJoystick(), Mf.getMonster().getyJoystick(), Mf.getMonster().getMonsterVisible(1));
    boolean pVsSyrinnge = removeImage(Mf,Mf.getMonster().getxSyrinnge(), Mf.getMonster().getySyrinnge(), Mf.getMonster().getMonsterVisible(2));
    // Nếu đụng vào quái nào thì xóa và ẩn quái đó
    if (pVsDice == true) {
        Mf.setScore(Mf.getScore()+1000);
        Mf.getMonster().setDice(null);
        Mf.getMonster().setMonsterVisible(false, 0);
    } else if (pVsJoystick == true) {
        Mf.getMonster().setJoystick(null);
        Mf.getMonster().setMonsterVisible(false, 1);
        Mf.setScore(Mf.getScore()+1000);
    } else if (pVsSyrinnge == true) {
        Mf.getMonster().setSyrinnge(null);
        Mf.getMonster().setMonsterVisible(false, 2);
        Mf.setScore(Mf.getScore()+1000);
    }

}


// Hàm tổng hợp các hàm logic trên
public static void PlayerVsMonster(MyFrame Mf) {
    if (Mf.getPlayer().getImgName() == "") {
        removePlayer(Mf);
    } else if (Mf.getPlayer().getImgName() == "Attack") {
        removeMonster(Mf);
    }
}
  
   
}
