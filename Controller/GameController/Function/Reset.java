package Controller.GameController.Function;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.GameModel.GameModel;
import Model.StateModel.MapModel;

public class Reset {
    // Hàm reset mọi thứ về trạng thái ban đầu và trở về Intro
    public static void ResetAll(GameModel Mf) {
        
        Mf.getFirstMap().getFirstMapModel().getMapLabel().setVisible(true);
        Mf.getSecondMap().getSecondMapModel().getMapLabel2().setVisible(true);
        Mf.getThirdMap().getThirdMapModel().getMapLabel3().setVisible(true);
        // Dừng nhạc hiện tại
        Mf.getSoundMain().stop();
        Mf.setCountFoot(0);
        
        // Đặt lại vị trí ban đầu;
        Mf.getMonster().getMonsterView().getMonsterImage();
        Mf.getMonster().getMonsterView().setDefaultMonster();

        // Gọi hàm discardHeart để setup lại tym
        discardHeart(Mf);
       

        //Gọi hàm discardBook để setup lại book
        discardBook(Mf,Mf.getFirstMap().getFirstMapModel(), Mf.getFirstMap().getFirstMapModel().getChildFirstMapPanel(), Mf.getFirstMap().getFirstMapModel().getObj());
        discardBook(Mf,Mf.getSecondMap().getSecondMapModel(), Mf.getSecondMap().getSecondMapModel().getChildSecondMapPanel(), Mf.getSecondMap().getSecondMapModel().getObj());
        discardBook(Mf,Mf.getThirdMap().getThirdMapModel(), Mf.getThirdMap().getThirdMapModel().getChildThirdMapPanel(), Mf.getThirdMap().getThirdMapModel().getObj());

        // xóa tất cả các dong chữ chạy của trailer và cho bắt đầu từ đầu
        Mf.getTrailer().getTrailerModel().getTimer().stop();
        Mf.getTrailer().getTrailerModel().setCurrentLineIndex(0);
        Mf.getTrailer().getTrailerModel().setCurrentCharacterIndex(0);
        Mf.getTrailer().getTrailerModel().getTextArea().setText("");

        dicardEnding(Mf);

        // Chuyển về trang Intro
       Mf.setNameCardLayout("Intro"); 
        Mf.getCardLayout().show(Mf.getCardPanel(),Mf.getNameCardLayout());
        
        // Cho nhân vật dừng di chuyển và set lại vị trí cũ
        Mf.getPlayermove().getPlayerMoveModel().setPlayerDown(false);
        Mf.getPlayermove().getPlayerMoveModel().setPlayerLeft(false);
        Mf.getPlayermove().getPlayerMoveModel().setPlayerUp(false);
        Mf.getPlayermove().getPlayerMoveModel().setPlayerRight(false);
        Mf.getPlayer().getPlayerView().setDefaultPlayer();

        
        // Bật lại nhạc của intro
        Mf.getSoundMain().setFile(0);
        Mf.getSoundMain().start();
    }

    public static void dicardEnding(GameModel Mf){
       Mf.getBadEnding().getTimerBad().stop();
       Mf.getBadEnding().getBadEndingModel().setCurrentCharacterIndex(0);
       Mf.getHappyEnding().getHappyEndingModel().setCurrentCharacterIndex(0);
       Mf.getHappyEnding().getTimerHappy().stop();
        for(int i=0;i<Mf.getBadEnding().getBadEndingModel().getText().length;i++){
            Mf.getBadEnding().getBadEndingModel().getText()[i].setText("");
        }
        for(int i=0;i<Mf.getHappyEnding().getHappyEndingModel().getText().length;i++){
            Mf.getHappyEnding().getHappyEndingModel().getText()[i].setText("");
        }
    }

   
    // Hàm gắn lại trái tym về chỗ cũ nếu như đã bị ăn mất
    public static void discardHeart(GameModel Mf) {
            Mf.getFirstMap().getFirstMapModel().setAddHeart(true);
            Mf.getFirstMap().getFirstMapModel().setRemoveHeart(false);
            Mf.getFirstMap().getFirstMapModel().getChildFirstMapPanel().add(Mf.getFirstMap().getFirstMapModel().getHeart());
        
            Mf.getSecondMap().getSecondMapModel().setAddHeart(true);
            Mf.getSecondMap().getSecondMapModel().setRemoveHeart(false);
            Mf.getSecondMap().getSecondMapModel().getChildSecondMapPanel().add(Mf.getSecondMap().getSecondMapModel().getHeart());
          
            Mf.getThirdMap().getThirdMapModel().setAddHeart(true);
            Mf.getThirdMap().getThirdMapModel().setRemoveHeart(false);
            Mf.getThirdMap().getThirdMapModel().getChildThirdMapPanel().add(Mf.getThirdMap().getThirdMapModel().getHeart());
              
            
        }

   
        // Hàm gắn lại book về chỗ cũ nếu như đã bị ăn mất
      public static void discardBook(GameModel Mf,MapModel defaultMap,  JPanel childJPanel, JLabel obj[]) {
      for(int i=0;i<obj.length;i++){
        childJPanel.add(obj[i]);
        defaultMap.setAddObj(true, i);
        defaultMap.setRemoveObj(false, i);
      }
      Mf.setScore(0);
    }
}
