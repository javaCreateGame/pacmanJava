package View.StateView;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import Model.StateModel.TrailerModel;
import main.MyFrame;

import java.awt.Font;
import java.awt.Color;

public class TrailerView {
    MyFrame Mf;
    TrailerModel trailerModel;

    public TrailerView(MyFrame Mf, TrailerModel trailerModel){
        this.Mf = Mf;
        this.trailerModel = trailerModel;

        //set font
        Font font = new Font("Arial", Font.BOLD, 13);
        trailerModel.getTextArea().setFont(font);
        trailerModel.getTextArea().setForeground(Color.BLACK);

        trailerModel.getTextArea().setBounds(105, 180, 410, 265);
        trailerModel.getTextArea().setOpaque(false);
        trailerModel.getTextArea().setEnabled(false);

        // set background
        ImageIcon image = new ImageIcon("./picture/Background_Trailer.png");
        JLabel backgroundLabel = new JLabel(image);
        backgroundLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        
        //tự động xuống dòng
        trailerModel.getTextArea().setLineWrap(true);
        trailerModel.getTextArea().setWrapStyleWord(true);

        //set size buttons
        trailerModel.getSkipButton().setBounds(343, 440, 130, 50);
        trailerModel.getNextButton().setBounds(430, 440, 130, 50);
        
        // Set màu chữ ban đầu
        trailerModel.getSkipButton().setForeground(Color.BLACK);
        trailerModel.getNextButton().setForeground(Color.BLACK);
        
        // Làm cho nút skip trở nên trong suốt
        trailerModel.getSkipButton().setOpaque(false);
        trailerModel.getSkipButton().setContentAreaFilled(false);
        trailerModel.getSkipButton().setBorderPainted(false);
        trailerModel.getSkipButton().setFocusable(false);

        // Làm cho nút next trở nên trong suốt
        trailerModel.getNextButton().setOpaque(false);
        trailerModel.getNextButton().setContentAreaFilled(false);
        trailerModel.getNextButton().setBorderPainted(false);
        trailerModel.getNextButton().setFocusable(false);
        
        trailerModel.getNextButton().setFont(font);
        trailerModel.getSkipButton().setFont(font);

        // Thêm buttonPanel vào trailerModel.getTrailerPanel()  
        trailerModel.getTrailerPanel().add(trailerModel.getSkipButton());
        trailerModel.getTrailerPanel().add(trailerModel.getNextButton());
        trailerModel.getTrailerPanel().add(trailerModel.getTextArea(), JLayeredPane.DEFAULT_LAYER);
        trailerModel.getTrailerPanel().add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);
    }
}
