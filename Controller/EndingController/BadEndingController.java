package Controller.EndingController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Model.EndingModel.BadEndingModel;
import View.EndingView.BadEndingView;

public class BadEndingController {
    private BadEndingModel badEndingModel;
    private BadEndingView badEndingView;
    private Timer timerBad;

    public BadEndingController() {
        badEndingModel = new BadEndingModel();
        badEndingView = new BadEndingView(badEndingModel);
        // khi xuất hiện ending thì sau đó mỗi 25milis thì timerbad sẽ chạy lại
        timerBad = new Timer(25, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               //text chính là biến JtextArea để in ra các dòng chữ ending ban đâu là rỗng;
               //text là 1 mảng mỗi index của nó tương ứng với 1 các ending khác nhau
               //biến CurrentCharacterIndex chỉ số lượng các từ hiện có trong text
               //numberbad chỉ ending số mấy
               //text[numberbad] chỉ ending số mấy cần hiện

               //nếu số lượng từ có trong mảng text nhỏ hơn số lưỡng chữ trong ending[numberbad]
                if (badEndingModel
                        .getCurrentCharacterIndex() < badEndingModel.getEnding()[badEndingModel.getNumberBad()]
                                .length()) {
                //khi đó nối các ký tự hiện có trong text[numberbad] với vị trí số "CurrentCharacterIndex" của ending[numberbad]
                    badEndingModel.getText()[badEndingModel.getNumberBad()]
                            .append(String.valueOf(badEndingModel.getEnding()[badEndingModel.getNumberBad()]
                                    .charAt(badEndingModel.getCurrentCharacterIndex())));
                 //tăng CurrentCharacterIndex lên 1
                    badEndingModel.setCurrentCharacterIndex(badEndingModel.getCurrentCharacterIndex() + 1);
                }
                //khi nào CurrentCharacterIndex > ending[numberbad] thì dừng timer 
                else {
                    timerBad.stop();

                }
            }

        });

    }

    public BadEndingModel getBadEndingModel() {
        return badEndingModel;
    }

    public Timer getTimerBad() {
        return timerBad;
    }

    public BadEndingView getBadEndingView() {
        return badEndingView;
    }

}
