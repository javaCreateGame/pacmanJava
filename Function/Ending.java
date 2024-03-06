package Function;

import State.ThirdMap;
import main.MyFrame;

public class Ending {
    public static void HappyEnding(MyFrame Mf,int numberHappy){
        Mf.setNameCardLayout("HappyEnding");
        Mf.getHappyEnding().setNumberHappy(numberHappy);
        Mf.getHappyEnding().getCardLayout().show(Mf.getHappyEnding().getCardPanel(), "happy"+numberHappy);
        Mf.getCardLayout().show(Mf.getCardPanel(), Mf.getNameCardLayout());
        Mf.getHappyEnding().getTimerHappy().start();
        Mf.getSoundMain().setFile(7);
        Mf.getSoundMain().start();
    }
    public static void BadEnding(MyFrame Mf,int numberBad){
        Mf.setNameCardLayout("BadEnding");
        Mf.getBadEnding().setNumberBad(numberBad);
        Mf.getBadEnding().getCardLayout().show(Mf.getBadEnding().getCardPanel(), "bad"+numberBad);
        Mf.getCardLayout().show(Mf.getCardPanel(), Mf.getNameCardLayout());
        Mf.getBadEnding().getTimerBad().start();
        Mf.getSoundMain().setFile(6);
        Mf.getSoundMain().start();
    }
    public static void finalEnding(MyFrame Mf) {
        if (ThirdMap.getSecondsLeft() <= 0) {
            // Nếu điểm nhỏ hơn 4500, bạn thua
            Mf.getSoundMain().stop();
            if (Mf.getScore() <= 4500) {
                Mf.getBadEnding().setNumberBad(3);
                BadEnding(Mf, Mf.getBadEnding().getNumberBad());
            }
            // Ngược lại bạn chiến thắng
            else {
                Mf.getHappyEnding().setNumberHappy(0);
                HappyEnding(Mf, Mf.getHappyEnding().getNumberHappy());
            }
        }
    }
}
