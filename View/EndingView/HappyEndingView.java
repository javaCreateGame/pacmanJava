package View.EndingView;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Model.EndingModel.HappyEndingModel;

public class HappyEndingView {
    private HappyEndingModel happyEndingModel;

    public HappyEndingView(HappyEndingModel happyEndingModel) {
        this.happyEndingModel = happyEndingModel;
        setParentPanel();
        happyEndingModel.getHappyURL()[0] = "./picture/happyEnding.jpg";
        happyEndingModel.getHappyURL()[1] = "./picture/Ending2.png";
        happyEndingModel.getHappyURL()[2] = "./picture/Ending3.png";
        setPanel();
        setUp();
    }

    // Set Up Các trang to của từng ending
    private void setParentPanel() {
        for (int i = 0; i < happyEndingModel.getHappyEndingPanel().length; i++) {
            happyEndingModel.getHappyEndingPanel()[i] = new JPanel();
            happyEndingModel.getHappyEndingPanel()[i].setBounds(0, 0, 615, 690);
            happyEndingModel.getHappyEndingPanel()[i].setOpaque(true);
            happyEndingModel.getHappyEndingPanel()[i].setVisible(true);
            happyEndingModel.getHappyEndingPanel()[i].setLayout(null);
            happyEndingModel.getHappyEndingPanel()[i].setBackground(new Color(173, 85, 63));
        }
    }

    // Set Up câu chữ và ảnh của từng ending
    private void setPanel() {
        for (int i = 0; i < happyEndingModel.getText().length; i++) {
            happyEndingModel.getText()[i] = new JTextArea();
            happyEndingModel.getText()[i].setBounds(80, 420, 455, 170);
            happyEndingModel.getText()[i].setEnabled(false);
            happyEndingModel.getText()[i].setBackground(new Color(173, 85, 63));
            happyEndingModel.getText()[i].setAlignmentY(JTextArea.CENTER_ALIGNMENT);
            happyEndingModel.getText()[i].setLineWrap(true);
            happyEndingModel.getText()[i].setWrapStyleWord(true);

            ImageIcon newImage = new ImageIcon(new ImageIcon(happyEndingModel.getHappyURL()[i]).getImage()
                    .getScaledInstance(400, 400, Image.SCALE_SMOOTH));
            happyEndingModel.getImg()[i] = new JLabel();
            happyEndingModel.getImg()[i].setIcon(newImage);
            happyEndingModel.getImg()[i].setBounds(107, 0, 400, 400);
            happyEndingModel.getImg()[i].setVisible(true);

            happyEndingModel.getHappyEndingPanel()[i].add(happyEndingModel.getText()[i]);
            happyEndingModel.getHappyEndingPanel()[i].add(happyEndingModel.getImg()[i]);

        }

    }

    // Set up nút và trang to chứa tất cả các trang ending
    private void setUp() {

        happyEndingModel.getCardPanel().setBounds(0, 0, 615, 690);

        // Sử dụng CardLayout cho cardPanel
        happyEndingModel.getCardPanel().setLayout(happyEndingModel.getCardLayout());

        for (int i = 0; i < happyEndingModel.getHappyEndingPanel().length; i++) {
            happyEndingModel.getCardPanel().add(happyEndingModel.getHappyEndingPanel()[i], "happy" + i);

        }

        happyEndingModel.getCardLayout().show(happyEndingModel.getCardPanel(), "happy0");

        happyEndingModel.getHappyEndingPanelSum().setBounds(0, 0, 615, 690);
        happyEndingModel.getHappyEndingPanelSum().setOpaque(true);
        happyEndingModel.getHappyEndingPanelSum().setVisible(true);
        happyEndingModel.getHappyEndingPanelSum().setLayout(null);
        happyEndingModel.getButtonEnding().getButtonEndingModel().getYesButton().setBounds(210, 580, 80, 50);
        happyEndingModel.getButtonEnding().getButtonEndingModel().getNoButton().setBounds(260, 580, 80, 50);
        happyEndingModel.getHappyEndingPanelSum()
                .add(happyEndingModel.getButtonEnding().getButtonEndingModel().getYesButton());
        happyEndingModel.getHappyEndingPanelSum()
                .add(happyEndingModel.getButtonEnding().getButtonEndingModel().getNoButton());
        happyEndingModel.getHappyEndingPanelSum().add(happyEndingModel.getCardPanel());
    }

}
