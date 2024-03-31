package Controller.LoginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.LoginModel.LoginModel;
import View.LoginView.LoginView;
import main.MyFrame;

public class LoginController implements ActionListener {
    MyFrame Mf;
    private LoginModel loginModel;
    private LoginView loginView;
    public LoginController(MyFrame Mf){
        this.Mf=Mf;
        loginModel=new LoginModel(Mf);
        loginView=new LoginView( loginModel);

        loginModel.getLargeButton().addActionListener(this);
        loginModel.getSmallButton().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == loginModel.getSmallButton()) {
            loginModel.getLargeButton().setText(loginModel.getNameLargeButton().equals("Đăng ký") ? "Đăng nhập" : "Đăng ký");
            loginModel.getSmallButton().setText(loginModel.getNameLargeButton().equals("Đăng ký") ? "Đăng ký" : "Đăng nhập");

      // Cập nhật biến sau khi đặt văn bản nút
      loginModel.setNameLargeButton(loginModel.getLargeButton().getText());  // Lấy văn bản cập nhật từ nút
      loginModel.setNameSmallButton(loginModel.getSmallButton().getText()); // Lấy văn bản cập nhật từ nút

      if (loginModel.getLargeButton().getText()=="Đăng ký" && loginModel.getSmallButton().getText()=="Đăng nhập" ) {
        setLocationInput_Button(165, 165, 200, 135,true);
      }
      else{
       setLocationInput_Button(115, 115, 150, 85,false);
      }
      loginModel.getCode().newKey();
      loginModel.getCode().encrypt((int) Math.floor((Math.random() * 3) + 1));
      loginModel.getEncodeVisible().setText(String.valueOf(loginModel.getCode().getLetter()));
    }

    if (e.getSource() == loginModel.getLargeButton()) {
      if (loginModel.getEncodeCheckBox().getText().equals(loginModel.getEncodeVisible().getText())) {
       loginModel.setOutDialog(true);
        Mf.getIntro().getIntroModel().getLoginButton().setText(loginModel.getUsername()[0].getText());
        loginModel.setVisible(false);
      } 
      else {
        JOptionPane.showConfirmDialog(null, "Bạn đã nhập sai check box", "Warning", JOptionPane.PLAIN_MESSAGE);
        loginModel.getCode().newKey();
      loginModel.getCode().encrypt((int) Math.floor((Math.random() * 3) + 1));
      loginModel.getEncodeVisible().setText(String.valueOf(loginModel.getCode().getLetter()));
      }
    }
    }
    public void resetLoginDialog(){
        for(int i=0; i< loginModel.getUsername().length;i++){
          loginModel.getUsername()[i].setText("");
          loginModel.getPassword()[i].setText("");
        }
        loginModel.getEncodeCheckBox().setText("");
        loginModel.getCode().newKey();
      loginModel.getCode().encrypt((int) Math.floor((Math.random() * 3) + 1));
      loginModel.getEncodeVisible().setText(String.valueOf(loginModel.getCode().getLetter()));
      }
    //Hàm đặt tọa độ cho vị trí các nút và vị trí phần check encode
      private void setLocationInput_Button(int x,int y,int z,int t ,boolean visible){
        loginModel.getEncodeVisible().setBounds(17, x, 60, 20);
        loginModel.getEncodeCheckBox().setBounds(80, y, 185, 20);
        loginModel.getLargeButton().setBounds(45, z, 190, 40);
        loginModel.getSmallButton().setBounds(200, t, 90, 30);
        loginModel.getConfirmPassInput().setVisible(visible);
        loginModel.getConfirmPassLabel().setVisible(visible);
      }
}
