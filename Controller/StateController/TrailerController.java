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

        trailerModel.getTimer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (trailerModel
                        .getCurrentCharacterIndex() < trailerModel.getLinesToShow()[trailerModel.getCurrentLineIndex()]
                                .length()) {
                    trailerModel.getTextArea()
                            .append(String.valueOf(trailerModel.getLinesToShow()[trailerModel.getCurrentLineIndex()]
                                    .charAt(trailerModel.getCurrentCharacterIndex())));
                    trailerModel.setCurrentCharacterIndex(trailerModel.getCurrentCharacterIndex() + 1);
                } else {
                    trailerModel.setCurrentLineIndex(trailerModel.getCurrentLineIndex() + 1);
                    if (trailerModel.getCurrentLineIndex() >= trailerModel.getLinesToShow().length) {
                        trailerModel.getTimer().stop();
                        Mf.getSoundInternal().stop();
                    } else {
                        trailerModel.getTextArea().append("\n");
                        trailerModel.setCurrentCharacterIndex(0);
                    }
                }
            }
        });
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
