package Function;

import javax.swing.JLabel;
import javax.swing.JPanel;

import State.Map;
import main.MyFrame;

public class Reset {
    
    // Hàm reset mọi thứ về trạng thái ban đầu và trở về Intro
    public static void ResetAll(MyFrame Mf) {
        // Dừng nhạc hiện tại
        Mf.getSoundMain().stop();
        Mf.setCountFoot(0);
        
        // Đặt lại vị trí ban đầu;
        Mf.getMonster().getMonsterImage();
        Mf.getMonster().setDefaultMonster();

        // Gọi hàm discardHeart để setup lại tym
        discardHeart(Mf);
       

        //Gọi hàm discardBook để setup lại book
        discardBook(Mf,Mf.getFirstMap(), Mf.getFirstMap().getChildFirstMapPanel(), Mf.getFirstMap().getObj());
        discardBook(Mf,Mf.getSecondMap(), Mf.getSecondMap().getChildSecondMapPanel(), Mf.getSecondMap().obj);
        discardBook(Mf,Mf.getThirdMap(), Mf.getThirdMap().getChildThirdMapPanel(), Mf.getThirdMap().obj);

        // xóa tất cả các dong chữ chạy của trailer và cho bắt đầu từ đầu
        Mf.getTrailer().timer.stop();
        Mf.getTrailer().currentLineIndex = 0;
        Mf.getTrailer().currentCharacterIndex = 0;
        Mf.getTrailer().textArea.setText("");

        dicardEnding(Mf);

        // Chuyển về trang Intro
       Mf.setNameCardLayout("Intro"); 
        Mf.getCardLayout().show(Mf.getCardPanel(),Mf.getNameCardLayout());
        
        // Cho nhân vật dừng di chuyển và set lại vị trí cũ
        Mf.getPlayermove().playerRight = Mf.getPlayermove().playerDown = Mf.getPlayermove().playerUp = Mf.getPlayermove().playerLeft = false;
        Mf.getPlayer().setDefaultPlayer();

        
        // Bật lại nhạc của intro
        Mf.getSoundMain().setFile(0);
        Mf.getSoundMain().start();
    }

    public static void dicardEnding(MyFrame Mf){
       Mf.getBadEnding().getTimerBad().stop();
       Mf.getBadEnding().setCurrentCharacterIndex(0);
       Mf.getHappyEnding().setCurrentCharacterIndex(0);
       Mf.getHappyEnding().getTimerHappy().stop();
        for(int i=0;i<Mf.getBadEnding().getText().length;i++){
            Mf.getBadEnding().getTextI(i).setText("");
        }
        for(int i=0;i<Mf.getHappyEnding().getText().length;i++){
            Mf.getHappyEnding().getTextI(i).setText("");
        }
    }

   
    // Hàm gắn lại trái tym về chỗ cũ nếu như đã bị ăn mất
    public static void discardHeart(MyFrame Mf) {
            Mf.getFirstMap().setAddHeart(true);
            Mf.getFirstMap().setRemoveHeart(false);
            Mf.getFirstMap().getChildFirstMapPanel().add(Mf.getFirstMap().getHeart());
        
            Mf.getSecondMap().setAddHeart(true);
            Mf.getSecondMap().setRemoveHeart(false);
            Mf.getSecondMap().getChildSecondMapPanel().add(Mf.getSecondMap().getHeart());
          
            Mf.getThirdMap().setAddHeart(true);
            Mf.getThirdMap().setRemoveHeart(false);
            Mf.getThirdMap().getChildThirdMapPanel().add(Mf.getThirdMap().getHeart());
        }

   
        // Hàm gắn lại book về chỗ cũ nếu như đã bị ăn mất
      public static void discardBook(MyFrame Mf,Map defaultMap,  JPanel childJPanel, JLabel obj[]) {
      for(int i=0;i<obj.length;i++){
        childJPanel.add(obj[i]);
        defaultMap.addObj[i]=true;
        defaultMap.removeObj[i]= false;
      }
      Mf.setScore(0);
    }
}
