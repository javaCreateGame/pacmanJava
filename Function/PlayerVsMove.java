package Function;

import main.MyFrame;

public class PlayerVsMove {
  // Hàm boolean trả về giá trị true nếu nhân vật chạm vào quái
  public static boolean removeImage(MyFrame Mf,int xMonsterImg, int yMonsterImg, boolean monsterVisible) {
    int X = (xMonsterImg + monster.MonsterWidth) - (Mf.getPlayer().PlayerWidth + Mf.getPlayer().PlayerPositionX);
    int Y = (yMonsterImg + monster.MonsterHeight) - (Mf.getPlayer().PLayerHeight + Mf.getPlayer().PlayerPositionY);
    if (X >= -20 && X <= 5 && Y >= -20 && Y <= 5 && monsterVisible == true) {
        return true;
    }
    return false;
}

// hÀM setlogic cho player đánh nhau vs quái khi k ăn trái tym
public void removePlayer() {
    // Mảng sTRING lưu trữ các kịch bản end riêng khi quái chạm vào
   
    // Tạo các biến boolean cho biết mình đụng vào quái nào
    boolean pVsDice = removeImage(monster.xDice, monster.yDice, monster.monsterVisible[0]);
    boolean pVsJoystick = removeImage(monster.xJoystick, monster.yJoystick, monster.monsterVisible[1]);
    boolean pVsSyrinnge = removeImage(monster.xSyrinnge, monster.ySyrinnge, monster.monsterVisible[2]);
    // Nếu đụng vào quái nào thì hiện lên thông báo kết thúc game và lựa chọn
    if (pVsDice == true || pVsSyrinnge == true || pVsJoystick == true) {
        soundMain.stop();
        soundMain.setFile(6);
        soundMain.start();
        nameCardLayout="BadEnding";
        if (pVsDice == true) {
            badEnding.setNumberBad(0);
        } else if (pVsJoystick == true) {
            badEnding.setNumberBad(1);
        } else if (pVsSyrinnge == true) {
            badEnding.setNumberBad(2);
        }
        badEnding.getCardLayout().show(badEnding.getCardPanel(), "bad"+badEnding.getNumberBad());
        cardLayout.show(cardPanel, nameCardLayout);
        badEnding.getTimerBad().start();
    }
}


// hÀM setlogic cho player đánh nhau vs quái khi ăn trái tym
public void removeMonster() {
    // Tạo các biến boolean cho biết mình đụng vào quái nào
    boolean pVsDice = removeImage(monster.xDice, monster.yDice, monster.monsterVisible[0]);
    boolean pVsJoystick = removeImage(monster.xJoystick, monster.yJoystick, monster.monsterVisible[1]);
    boolean pVsSyrinnge = removeImage(monster.xSyrinnge, monster.ySyrinnge, monster.monsterVisible[2]);
    // Nếu đụng vào quái nào thì xóa và ẩn quái đó
    if (pVsDice == true) {
        score+=1000;
        monster.dice = null;
        monster.monsterVisible[0] = false;
    } else if (pVsJoystick == true) {
        monster.joystick = null;
        monster.monsterVisible[1] = false;
        score+=1000;
    } else if (pVsSyrinnge == true) {
        monster.syrinnge = null;
        monster.monsterVisible[2] = false;
        score+=1000;
    }

}


// Hàm tổng hợp các hàm logic trên
public void PlayerVsMonster() {
    if (player.getImgName() == "") {
        removePlayer();
    } else if (player.getImgName() == "Attack") {
        removeMonster();
    }
}
  
   
}
