package Controller.StateController;

import main.MyFrame;
import Model.StateModel.ThirdMapModel;
import View.StateView.ThirdMapView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThirdMapController {
    MyFrame Mf;
    ThirdMapModel thirdMapModel;
    ThirdMapView thirdMapView;
    
    public ThirdMapController(MyFrame Mf) {
        this.Mf = Mf;
        thirdMapModel = new ThirdMapModel(Mf);
        thirdMapView = new ThirdMapView(Mf, thirdMapModel);

        // Gán ActionListener cho Timer
        thirdMapModel.getTimer3().addActionListener(new ActionListener() {
            int count = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                if (count <= 3) { // Hiển thị trong 3 giây đầu
                    float opacity = 1.0f - (count / 8.0f); // Ẩn dần chữ
                    thirdMapModel.getMapLabel3().setForeground(new Color(0, 0, 0, Math.max(0, Math.min(255, (int) (opacity * 255))))); // Đặt màu chữ
                    // mapLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
                } else {
                    thirdMapModel.getTimer3().stop(); // Dừng Timer sau khi đã đủ thời gian hiển thị                  
                    thirdMapModel.getMapLabel3().setVisible(false); // Ẩn hoàn toàn chữ
                    count = 0;
                }
            }
        });
    }

    // Phương thức để cập nhật thời gian trên timerJlabel
    public static void updateTimer(int time){
        ThirdMapModel.setSecondsLeft(time);
        ThirdMapModel.getTimerThirdMap().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ThirdMapModel.getSecondsLeft() > 0) {
                    ThirdMapModel.setSecondsLeft(ThirdMapModel.getSecondsLeft()-1);
                    ThirdMapModel.getTimerJLabel().setText("Time: " + ThirdMapModel.getSecondsLeft());
                } else {
                    ThirdMapModel.getTimerThirdMap().stop();
                }
            }
        });
    } 

    public ThirdMapModel getThirdMapModel() {
        return thirdMapModel;
    }
}
