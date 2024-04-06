package Controller.StateController;

import java.awt.Color;

import Model.StateModel.FirstMapModel;
import View.StateView.FirstMapView;
import main.MyFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstMapController {
    MyFrame Mf;
    FirstMapModel firstMapModel;
    FirstMapView firstMapView;
    
    public FirstMapController(MyFrame Mf){
        this.Mf = Mf;
        firstMapModel = new FirstMapModel(Mf);
        firstMapView = new FirstMapView(Mf, firstMapModel);
        
        // Gán ActionListener cho Timer
        firstMapModel.getTimer().addActionListener(new ActionListener() {
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                count++;               
                if (count <= 3) { // Hiển thị trong 3 giây đầu
                    float opacity = 1.0f - (count / 8.0f); // Ẩn dần chữ "Map 1"
                    firstMapModel.getMapLabel().setForeground(new Color(0, 0, 0, Math.max(0, Math.min(255, (int) (opacity * 255))))); // Đặt màu chữ
                    // mapLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
                } else {
                    firstMapModel.getTimer().stop(); // Dừng Timer sau khi đã đủ thời gian hiển thị
                    firstMapModel.getMapLabel().setVisible(false); // Ẩn hoàn toàn chữ "Map 1"
                    count = 0;
                }
            }
        });
    }

    public FirstMapModel getFirstMapModel() {
        return firstMapModel;
    }
}
