package View.EndingView;

import javax.swing.JButton;

import org.w3c.dom.events.MouseEvent;

import Model.EndingModel.ButtonEndingModel;

public class ButtonEndingView {
    ButtonEndingModel buttonEndingModel;
    public ButtonEndingView(ButtonEndingModel buttonEndingModel){
        this.buttonEndingModel=buttonEndingModel;
        buttonEndingModel.getYesButton().setBounds(210, 440, 80, 50);
        buttonEndingModel.getNoButton().setBounds(260, 440, 80, 50);
        setUpButton(buttonEndingModel.getYesButton());
        setUpButton(buttonEndingModel.getNoButton());
    }
    private void setUpButton(JButton button){
       button.setForeground(Color.BLACK);
       // Làm cho nút skip trở nên trong suốt
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusable(false);
       
        // Thêm trình nghe sự kiện chuột để thay đổi màu chữ khi di chuột vào
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setForeground(Color.BLUE); // Đổi màu chữ khi di chuột vào
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setForeground(Color.BLACK); // Đổi lại màu chữ khi chuột rời khỏi nút
            }
        });
        
    }
}
