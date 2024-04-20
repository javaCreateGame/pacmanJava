package Controller.StateController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Model.GameModel.GameModel;
import Model.StateModel.TrailerModel;
import View.StateView.TrailerView;

public class TrailerController {
    GameModel Mf;
    TrailerModel trailerModel;
    TrailerView trailerView;

    public TrailerController(GameModel Mf) {
        this.Mf = Mf;
        trailerModel = new TrailerModel();
        trailerView = new TrailerView(Mf, trailerModel);

        // Thêm trình nghe sự kiện chuột để thay đổi màu chữ khi di chuột vào
        trailerModel.getSkipButton().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                trailerModel.getSkipButton().setForeground(Color.BLUE); // Đổi màu chữ khi di chuột vào
            }

            @Override
            public void mouseExited(MouseEvent e) {
                trailerModel.getSkipButton().setForeground(Color.BLACK); // Đổi lại màu chữ khi chuột rời khỏi nút
            }
        });

        // Thêm trình nghe sự kiện chuột để thay đổi màu chữ khi di chuột vào
        trailerModel.getNextButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                trailerModel.getNextButton().setForeground(Color.BLUE); // Đổi màu chữ khi di chuột vào
            }

            @Override
            public void mouseExited(MouseEvent e) {
                trailerModel.getNextButton().setForeground(Color.BLACK); // Đổi lại màu chữ khi chuột rời khỏi nút
            }
        });

        //line to show là 1 chuỗi chứa phần giới thiệu 
        //curentcharacter chỉ số lượng từ hiện tại của text area ban đầu =0
        //curentlineindex chỉ index hiện tại của lineto show=0
        //textArea là biến để in ra các dòng chữ của linetoshow trên màn hình=0

        trailerModel.getTimer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //nÊÚ curentcharacter< số luượng từ của linetoshow[curentlineindex]
                
                if (trailerModel

                        .getCurrentCharacterIndex() < trailerModel.getLinesToShow()[trailerModel.getCurrentLineIndex()]
                                .length()) {
                    //Nối chuỗi trong textArea với char  vị trí curentcharacter của linetoshow[curentlineindex]
                    trailerModel.getTextArea()
                            .append(String.valueOf(trailerModel.getLinesToShow()[trailerModel.getCurrentLineIndex()]
                                    .charAt(trailerModel.getCurrentCharacterIndex())));
                    //Tăng curentcharacter lên 1
                    trailerModel.setCurrentCharacterIndex(trailerModel.getCurrentCharacterIndex() + 1);
                }
                //Ngược lại
                 else {
                   
                    //lúc này textarea đã lấy xong các linetoshow[curentlineindex]
                     //Tăng curentlineindex lên 1 
                    trailerModel.setCurrentLineIndex(trailerModel.getCurrentLineIndex() + 1);
                     //Nếu textArea lấy hết tất cả rồi và 
                    if (trailerModel.getCurrentLineIndex() >= trailerModel.getLinesToShow().length) {
                        //Dừng timer
                        trailerModel.getTimer().stop();
                        //Đóng nhạc gõ phím
                        Mf.getSoundInternal().stop();
                    }//Ngược lại xuống dòng và tiếp tục 
                    else {
                        trailerModel.getTextArea().append("\n");
                        //set curentcharacter về 0
                        trailerModel.setCurrentCharacterIndex(0);
                    }
                }
            }
        });
        //Sự kiện khi ấn nút skip
        trailerModel.getSkipButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Dừng timer
                trailerModel.getTimer().stop();
                // Hiển thị toàn bộ đoạn văn bản một lần
                trailerModel.getTextArea().setText(""); // Xóa văn bản hiện tại
                for (String line : trailerModel.getLinesToShow()) {
                    trailerModel.getTextArea().append(line + "\n");
                }
                //Tắt nhạc gõ phím
                Mf.getSoundInternal().close();
            }
        });
    }

    public TrailerModel getTrailerModel() {
        return trailerModel;
    }

    public void setTrailerModel(TrailerModel trailerModel) {
        this.trailerModel = trailerModel;
    }
}
