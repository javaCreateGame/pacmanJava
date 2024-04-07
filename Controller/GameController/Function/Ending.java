package Controller.GameController.Function;


import Model.GameModel.GameModel;


public class Ending {
    public static void HappyEnding(GameModel Mf,int numberHappy){
        Mf.setNameCardLayout("HappyEnding");
        Mf.getHappyEnding().getHappyEndingModel().setNumberHappy(numberHappy);
        Mf.getHappyEnding().getHappyEndingModel().getCardLayout().show(Mf.getHappyEnding().getHappyEndingModel().getCardPanel(), "happy"+numberHappy);
        Mf.getCardLayout().show(Mf.getCardPanel(), Mf.getNameCardLayout());
        Mf.getHappyEnding().getTimerHappy().start();
        Mf.getSoundMain().setFile(7);
        Mf.getSoundMain().start();
    }
    public static void BadEnding(GameModel Mf,int numberBad){
        Mf.setNameCardLayout("BadEnding");
        Mf.getBadEnding().getBadEndingModel().setNumberBad(numberBad);
        Mf.getBadEnding().getBadEndingModel().getCardLayout().show(Mf.getBadEnding().getBadEndingModel().getCardPanel(), "bad"+numberBad);
        Mf.getCardLayout().show(Mf.getCardPanel(), Mf.getNameCardLayout());
        Mf.getBadEnding().getTimerBad().start();
        Mf.getSoundMain().setFile(6);
        Mf.getSoundMain().start();
    }
    public static void finalEnding(GameModel Mf) {
        if (Mf.getThirdMap().getThirdMapModel().getSecondsLeft() <= 0) {
            // Nếu điểm nhỏ hơn 4500, bạn thua
            Mf.getSoundMain().stop();
            if (Mf.getScore() <= 4500) {
                Mf.getBadEnding().getBadEndingModel().setNumberBad(3);
                BadEnding(Mf, Mf.getBadEnding().getBadEndingModel().getNumberBad());
            }
            // Ngược lại bạn chiến thắng
            else {
               if (Mf.getScore()>4500 && Mf.getScore() <11000) {
                Mf.getHappyEnding().getHappyEndingModel().setNumberHappy(0);
                
               }
               else{
                Mf.getHappyEnding().getHappyEndingModel().setNumberHappy(2);
               }
               HappyEnding(Mf, Mf.getHappyEnding().getHappyEndingModel().getNumberHappy());
            }
        }
    }
}
