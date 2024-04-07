package Controller.StateController;

import Model.GameModel.GameModel;
import Model.StateModel.SecondMapModel;
import View.StateView.SecondMapView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondMapController {
    GameModel Mf;
    SecondMapModel secondMapModel;
    SecondMapView secondMapView;

    public SecondMapController(GameModel Mf) {
        this.Mf = Mf;
        secondMapModel = new SecondMapModel();
        secondMapView = new SecondMapView(Mf, secondMapModel);

        // Gán ActionListener cho Timer
        secondMapModel.getTimer2().addActionListener(new ActionListener() {
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                if (count <= 3) { // Hiển thị trong 3 giây đầu
                    float opacity = 1.0f - (count / 8.0f); // Ẩn dần chữ
                    secondMapModel.getMapLabel2()
                            .setForeground(new Color(0, 0, 0, Math.max(0, Math.min(255, (int) (opacity * 255))))); // Đặt
                                                                                                                   // màu
                                                                                                                   // chữ
                    // mapLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
                } else {
                    secondMapModel.getTimer2().stop(); // Dừng Timer sau khi đã đủ thời gian hiển thị
                    secondMapModel.getMapLabel2().setVisible(false); // Ẩn hoàn toàn chữ
                    count = 0;
                }
            }
        });
    }

    public SecondMapModel getSecondMapModel() {
        return secondMapModel;
    }
}
