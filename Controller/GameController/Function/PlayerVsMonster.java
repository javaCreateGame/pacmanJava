package Controller.GameController.Function;

import Model.GameModel.GameModel;

public class PlayerVsMonster {
      // Hàm boolean trả về giá trị true nếu nhân vật chạm vào quái
  public static boolean removeImage(GameModel Mf,int xMonsterImg, int yMonsterImg, boolean monsterVisible) {
    int X = (xMonsterImg + Mf.getMonster().getMonsterModel().getMonsterWidth()) - (Mf.getPlayer().getPlayerModel().getPlayerWidth() + Mf.getPlayer().getPlayerModel().getPlayerPositionX());
    int Y = (yMonsterImg + Mf.getMonster().getMonsterModel().getMonsterHeight()) - (Mf.getPlayer().getPlayerModel().getPLayerHeight() + Mf.getPlayer().getPlayerModel().getPlayerPositionY());
    if (X >= -20 && X <= 5 && Y >= -20 && Y <= 5 && monsterVisible == true) {
        return true;
    }
    return false;
}

// hÀM setlogic cho player đánh nhau vs quái khi k ăn trái tym
public static void removePlayer(GameModel Mf) {
    // Mảng sTRING lưu trữ các kịch bản end riêng khi quái chạm vào
   
    // Tạo các biến boolean cho biết mình đụng vào quái nào
    boolean pVsDice = removeImage(Mf,Mf.getMonster().getMonsterModel().getxDice(), Mf.getMonster().getMonsterModel().getyDice(), Mf.getMonster().getMonsterModel().getMonsterVisible()[0]);
    boolean pVsJoystick = removeImage(Mf,Mf.getMonster().getMonsterModel().getxJoystick(), Mf.getMonster().getMonsterModel().getyJoystick(), Mf.getMonster().getMonsterModel().getMonsterVisible()[1]);
    boolean pVsSyrinnge = removeImage(Mf,Mf.getMonster().getMonsterModel().getxSyrinnge(), Mf.getMonster().getMonsterModel().getySyrinnge(), Mf.getMonster().getMonsterModel().getMonsterVisible()[2]);
    // Nếu đụng vào quái nào thì hiện lên thông báo kết thúc game và lựa chọn
    if (pVsDice == true || pVsSyrinnge == true || pVsJoystick == true) {
        Mf.getSoundMain().stop();
    
       
        if (pVsDice == true) {
            Mf.getBadEnding().getBadEndingModel().setNumberBad(0);
        } else if (pVsJoystick == true) {
            Mf.getBadEnding().getBadEndingModel().setNumberBad(1);
        } else if (pVsSyrinnge == true) {
            Mf.getBadEnding().getBadEndingModel().setNumberBad(2);
        }
      Ending.BadEnding(Mf, Mf.getBadEnding().getBadEndingModel().getNumberBad());
    }
}


// hÀM setlogic cho player đánh nhau vs quái khi ăn trái tym
public static void removeMonster(GameModel Mf) {
    // Tạo các biến boolean cho biết mình đụng vào quái nào
    boolean pVsDice = removeImage(Mf,Mf.getMonster().getMonsterModel().getxDice(), Mf.getMonster().getMonsterModel().getyDice(), Mf.getMonster().getMonsterModel().getMonsterVisible()[0]);
    boolean pVsJoystick = removeImage(Mf,Mf.getMonster().getMonsterModel().getxJoystick(), Mf.getMonster().getMonsterModel().getyJoystick(), Mf.getMonster().getMonsterModel().getMonsterVisible()[1]);
    boolean pVsSyrinnge = removeImage(Mf,Mf.getMonster().getMonsterModel().getxSyrinnge(), Mf.getMonster().getMonsterModel().getySyrinnge(), Mf.getMonster().getMonsterModel().getMonsterVisible()[2]);
    // Nếu đụng vào quái nào thì xóa và ẩn quái đó
    if (pVsDice == true) {
       
        Mf.setScore(Mf.getScore()+1000);
        Mf.getMonster().getMonsterModel().setDice(null);
        Mf.getMonster().getMonsterModel().getMonsterVisible()[0]=false;
    } else if (pVsJoystick == true) {
        Mf.getMonster().getMonsterModel().setJoystick(null);
        Mf.getMonster().getMonsterModel().getMonsterVisible()[1]=false;
        Mf.setScore(Mf.getScore()+1000);
    } else if (pVsSyrinnge == true) {
        Mf.getMonster().getMonsterModel().setSyrinnge(null);
        Mf.getMonster().getMonsterModel().getMonsterVisible()[2]=false;
        Mf.setScore(Mf.getScore()+1000);
    }

}


// Hàm tổng hợp các hàm logic trên
public static void PlayerFightMonster(GameModel Mf) {
    if (Mf.getPlayer().getPlayerModel().getImgName() == "") {
        removePlayer(Mf);
    } else if (Mf.getPlayer().getPlayerModel().getImgName() == "Attack") {
        removeMonster(Mf);
    }
}
  
}
