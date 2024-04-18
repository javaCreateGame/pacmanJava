package Controller.GameController.Function;

import Model.GameModel.GameModel;

public class NextMap {
    public static void nextMap(GameModel Mf) {
        int x = Mf.getPlayer().getPlayerModel().getPlayerPositionX();
        int y = Mf.getPlayer().getPlayerModel().getPlayerPositionY();
        boolean next = false;
        if (Mf.getNameCardLayout() == "SecondMap" || Mf.getNameCardLayout() == "FirstMap") {
            if (Mf.getNameCardLayout() == "SecondMap" && Mf.getScore() >= 9900) {
                
                Mf.getHappyEnding().getHappyEndingModel().setNumberHappy(1);
                Ending.HappyEnding(Mf, Mf.getHappyEnding().getHappyEndingModel().getNumberHappy());
            }
            if (x >= 588 && (y > 235 && y < 275) && Mf.getNameCardLayout() == "FirstMap") {
                Mf.setNameCardLayout("SecondMap");
                Mf.getSecondMap().getSecondMapModel().getTimer2().restart();
                next = true;

            }
            if (x >= 588 && (y > 278 && y < 318) && Mf.getNameCardLayout() == "SecondMap") {
                Mf.setNameCardLayout("ThirdMap");
                Mf.getThirdMap().getThirdMapModel().getTimer3().restart();
                next = true;

            }
            if (next == true) {
                // Hàm chạy thời gian third map
                Mf.getThirdMap().updateTimer(60);
                Mf.getThirdMap().getThirdMapModel().getTimerThirdMap().start();
                Mf.getCardLayout().show(Mf.getCardPanel(), Mf.getNameCardLayout());
                Mf.getPlayer().getPlayerModel().setPlayerPositionX(1);
                Mf.getPlayer().getPlayerModel().setPlayerPositionY(290);
                Mf.setCountFoot(0);
                Mf.getMonster().getMonsterView().getMonsterImage();
                Mf.getMonster().getMonsterView().setDefaultMonster();

                Mf.getMonster().getMonsterModel().setxDice(322);
                Mf.getMonster().getMonsterModel().setyDice(295);
                Mf.getMonster().getMonsterModel().setxJoystick(379);
                Mf.getMonster().getMonsterModel().setyJoystick(295);
                Mf.getMonster().getMonsterModel().setxSyrinnge(339);
                Mf.getMonster().getMonsterModel().setySyrinnge(321);

               
            }

        }

    }
}
