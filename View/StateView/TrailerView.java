package View.StateView;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.Color;


import Model.GameModel.GameModel;
import Model.StateModel.TrailerModel;


import java.awt.Font;


public class TrailerView {
    GameModel Mf;
    TrailerModel trailerModel;

    public TrailerView(GameModel Mf, TrailerModel trailerModel){
        this.Mf = Mf;
        this.trailerModel = trailerModel;

        //set font
        Font font = new Font("Arial", Font.BOLD, 13);
        trailerModel.getTextArea().setFont(font);
        trailerModel.getTextArea().setForeground(Color.BLACK);

        trailerModel.getTextArea().setBounds(105, 193, 410, 265);
        trailerModel.getTextArea().setOpaque(false);
        trailerModel.getTextArea().setEnabled(false);

        // set background
        ImageIcon image = new ImageIcon("./picture/Background_Trailer.png");
        JLabel backgroundLabel = new JLabel(image);
        backgroundLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        
        //tự động xuống dòng
        trailerModel.getTextArea().setLineWrap(true);
        trailerModel.getTextArea().setWrapStyleWord(true);
        
        //Đặt button (x, y là tọa độ của button)
        setUpButton(trailerModel.getNextButton(),415, 448);
        setUpButton(trailerModel.getSkipButton(),335, 448);       

        // Thêm buttonPanel vào trailerModel.getTrailerPanel()  
        trailerModel.getTrailerPanel().add(trailerModel.getSkipButton());
        trailerModel.getTrailerPanel().add(trailerModel.getNextButton());
        trailerModel.getTrailerPanel().add(trailerModel.getTextArea(), JLayeredPane.DEFAULT_LAYER);
        trailerModel.getTrailerPanel().add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);
    }

    public void setUpButton(JButton button, int x, int y){
        // Set màu chữ ban đầu
        button.setForeground(Color.BLACK);
        //Làm cho nút trong suốt
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusable(false);
        //chọn font chữ
        Font font = new Font("Arial", Font.BOLD, 13);
        button.setFont(font);
        //kích cỡ button
        button.setBounds(x, y, 130, 50);
         // Thêm trình nghe sự kiện chuột để thay đổi màu chữ khi di chuột vào
         
    }
}
