package Function;

import State.ThirdMap;
import main.MyFrame;

public class NextMap {
    public static void nextMap(MyFrame Mf) {
        int x = Mf.getPlayer().getPlayerPositionX();
        int y = Mf.getPlayer().getPlayerPositionY();
        boolean next = false;
        if (Mf.getNameCardLayout() == "SecondMap" || Mf.getNameCardLayout() == "FirstMap") {
            if (Mf.getNameCardLayout() == "SecondMap" && Mf.getScore() >= 9900) {
                Mf.getSoundMain().stop();
                Mf.getHappyEnding().setNumberHappy(1);
                Ending.HappyEnding(Mf, Mf.getHappyEnding().getNumberHappy());
            }
            if (x >= 588 && (y > 235 && y < 275) && Mf.getNameCardLayout() == "FirstMap") {
                Mf.setNameCardLayout("SecondMap"); 
                Mf.getSecondMap().getTimer2().restart();
                next = true;
                
            }
            if (x >= 588 && (y > 278 && y < 318) &&  Mf.getNameCardLayout() == "SecondMap") {
                Mf.setNameCardLayout("ThirdMap"); 
                Mf.getThirdMap().getTimer3().restart();
                next = true;
                
            }
            if (next == true) {
                // Hàm chạy thời gian third map
                ThirdMap.updateTimer(10);
                ThirdMap.getTimerThirdMap().start();
                Mf.getCardLayout().show(Mf.getCardPanel(), Mf.getNameCardLayout());
                Mf.getPlayer().setPlayerPositionX(1);
                Mf.getPlayer().setPlayerPositionY(290);
                Mf.setCountFoot(0);
                Mf.getMonster().getMonsterImage();
                Mf.getMonster().setDefaultMonster();

                Mf.getMonster().setxDice(322);
                Mf.getMonster().setyDice(295);
                Mf.getMonster().setxJoystick(379); 
                Mf.getMonster().setyJoystick(295); 
                Mf.getMonster().setxSyrinnge(339); 
                Mf.getMonster().setySyrinnge(321); 
            }

        }

    }
}
