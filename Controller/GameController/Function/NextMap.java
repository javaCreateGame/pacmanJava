package Controller.GameController.Function;

import Model.GameModel.GameModel;

public class NextMap {
    public static void nextMap(GameModel Mf) {
        int x = Mf.getPlayer().getPlayerModel().getPlayerPositionX();//cho x là tọa độ x của nhân vâth
        int y = Mf.getPlayer().getPlayerModel().getPlayerPositionY();//y là tọa độ y của nhân vâth
        // next cho bieeets là muốn sang map khác
        boolean next = false;

        //Nếu ở map 2 mà bạn lớn hơn hoặc 9900 thì kết thúc game với happyending
        if (Mf.getNameCardLayout() == "SecondMap" || Mf.getNameCardLayout() == "FirstMap") {
            if (Mf.getNameCardLayout() == "SecondMap" && Mf.getScore() >= 9900) {
                
                Mf.getHappyEnding().getHappyEndingModel().setNumberHappy(1);
                Ending.HappyEnding(Mf, Mf.getHappyEnding().getHappyEndingModel().getNumberHappy());
            }

            //Nếu nhân vật ở first map đứng đúng tọa độ 
            if (x >= 588 && (y > 235 && y < 275) && Mf.getNameCardLayout() == "FirstMap") {
                Mf.setNameCardLayout("SecondMap");
                //restart timer của chứ lớp 11
                Mf.getSecondMap().getSecondMapModel().getTimer2().restart();
                //cho biết bạn muốn sang mao
                next = true;

            }
            //Nếu nhân vật ở second map đứng đúng tọa độ 
            if (x >= 588 && (y > 270 && y < 330) && Mf.getNameCardLayout() == "SecondMap") {
                Mf.setNameCardLayout("ThirdMap");
                Mf.getThirdMap().getThirdMapModel().getTimer3().restart();
                next = true;

            }
            
            if (next == true) {
                if (Mf.getNameCardLayout()=="SecondMap") {
                   Mf.getTileManager().loadMap("/InputFiletxt/map02.txt");
                        
                }
                if (Mf.getNameCardLayout()=="ThirdMap") {
                    Mf.getTileManager().loadMap("/InputFiletxt/map03.txt"); 
                      // Hàm chạy thời gian third map
            
                 }
                // Hàm chạy thời gian third map
                Mf.getThirdMap().updateTimer(60);
                Mf.getThirdMap().getThirdMapModel().getTimerThirdMap().start();
                //Chuyển sang map tiếp theo
                Mf.getCardLayout().show(Mf.getCardPanel(), Mf.getNameCardLayout());
                //set lại tọa độ nhân vâth
                Mf.getPlayer().getPlayerModel().setPlayerPositionX(1);
                Mf.getPlayer().getPlayerModel().setPlayerPositionY(290);
                //set lại countFôt
                Mf.setCountFoot(0);
                //set lại quái,kích thước của quái
                Mf.getMonster().getMonsterView().getMonsterImage();
                Mf.getMonster().getMonsterView().setDefaultMonster();
                //set lại vị trí của quái
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
