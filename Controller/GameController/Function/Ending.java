package Controller.GameController.Function;

import Model.GameModel.GameModel;
import dao.*;
import daoModel.*;

public class Ending {
    //Ending Happy
    public static void HappyEnding(GameModel Mf, int numberHappy) {
        //Đóng nhạc hiện tại
        Mf.getSoundMain().close();
        //Chuyển sang trang happyending tương ứng
        Mf.setNameCardLayout("HappyEnding");
        Mf.getHappyEnding().getHappyEndingModel().setNumberHappy(numberHappy);
        Mf.getHappyEnding().getHappyEndingModel().getCardLayout()
                .show(Mf.getHappyEnding().getHappyEndingModel().getCardPanel(), "happy" + numberHappy);
        Mf.getCardLayout().show(Mf.getCardPanel(), Mf.getNameCardLayout());
        //Bắt đầu chạy timerhappy
        Mf.getHappyEnding().getTimerHappy().start();
        //Bắt đầu chạy nhạc
        Mf.getSoundMain().setFile(7);
        Mf.getSoundMain().start();
        updateScoreDB(Mf);
    }

    public static void updateScoreDB(GameModel Mf) {
        // Phần lấy điểm và import vào database
        // Tạo ra hai object Info để lấy tên đăng nhập và điểm từ database
        Info condition = new Info(Mf.getLogin().getLoginModel().getUsernameI());
        Info temp = InfoDAO.getInstance().selectByID(condition);

        // Nếu như điểm của tên đăng nhập người chơi đang chơi hiện tại ở trong database mà lớn hơn điểm người chơi vừa
        // nhận được thì không làm gì cả
        if (temp.getDiem() > Mf.getScore()) {
            System.out.println("");
        }
        // Ngược lại nếu điểm trong database nhỏ hơn điểm người chơi vừa nhận được,
        // thì lưu xuống csdl bằng hàm updateScore
        else {
            Info t = new Info(Mf.getLogin().getLoginModel().getUsernameI());
            InfoDAO.getInstance().updateScore(t, Mf.getScore());
        }
    }
//BadEnding
    public static void BadEnding(GameModel Mf, int numberBad) {
        Mf.getSoundMain().close();
        Mf.setNameCardLayout("BadEnding");
        Mf.getBadEnding().getBadEndingModel().setNumberBad(numberBad);
        Mf.getBadEnding().getBadEndingModel().getCardLayout().show(Mf.getBadEnding().getBadEndingModel().getCardPanel(),
                "bad" + numberBad);
        Mf.getCardLayout().show(Mf.getCardPanel(), Mf.getNameCardLayout());
        Mf.getBadEnding().getTimerBad().start();
        Mf.getSoundMain().setFile(6);
        Mf.getSoundMain().start();
        updateScoreDB(Mf);
    }
//Ending khi hết thời gian màn 3
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
                //Nếu score nằm trong khoảng 4500 đến 11000 thì đỗ đại học
                if (Mf.getScore() > 4500 && Mf.getScore() < 11000) {
                    Mf.getHappyEnding().getHappyEndingModel().setNumberHappy(0);

                }
                //>11000 thì là thủ khoa 
                else {
                    Mf.getHappyEnding().getHappyEndingModel().setNumberHappy(2);
                }
                HappyEnding(Mf, Mf.getHappyEnding().getHappyEndingModel().getNumberHappy());
            }
        }
    }
}
