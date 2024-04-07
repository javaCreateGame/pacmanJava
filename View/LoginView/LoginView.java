package View.LoginView;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Model.LoginModel.LoginModel;

public class LoginView {
  private LoginModel loginModel;

  public LoginView(LoginModel loginModel) {
    this.loginModel = loginModel;
    setUpButton();
    setUpLabel();
    setInput();
    setUpSignIn();
    setUpSignUp();
    setUpLogin();
    SetUpJDialog();

  }

  private void setUpButton() {
    loginModel.getLargeButton().setBounds(45, 150, 190, 40);
    loginModel.getLargeButton().setFocusable(false);
    loginModel.getLargeButton().setVisible(true);

    loginModel.getSmallButton().setBounds(200, 85, 90, 30);
    loginModel.getSmallButton().setFont(new Font("Arial", Font.BOLD, 10));
    loginModel.getSmallButton().setOpaque(false);
    loginModel.getSmallButton().setContentAreaFilled(false);
    loginModel.getSmallButton().setBorderPainted(false);
    loginModel.getSmallButton().setVisible(true);

  }

  // set các dòng chữ tiêu đề như là chữ tài khoản.mật khẩu,..
  private void setUpLabel() {
    loginModel.getUserNameLabel().setBounds(15, 0, 70, 20);
    loginModel.getPassWordLabel().setBounds(15, 50, 70, 20);
    loginModel.getConfirmPassLabel().setBounds(15, 100, 140, 20);
    loginModel.getConfirmPassLabel().setVisible(false);

    loginModel.getCode().encrypt((int) Math.floor((Math.random() * 3) + 1));
    loginModel.getEncodeVisible().setText(String.valueOf(loginModel.getCode().getLetter()));
    loginModel.getEncodeVisible().setBounds(17, 115, 60, 20);
    loginModel.getEncodeVisible().setBorder(BorderFactory.createLineBorder(Color.BLACK));
    loginModel.getEncodeVisible().setHorizontalAlignment(JLabel.CENTER);

  }

  // chỉnh tọa độ vị trí ,kích thước cho các dòng nhập
  private void setInput() {
    for (int i = 0; i < loginModel.getUsername().length; i++) {
      loginModel.getUsername()[i] = new JTextField();
      loginModel.getUsername()[i].setBounds(15, 0, 250, 20);

    }
    for (int i = 0; i < loginModel.getPassword().length; i++) {
      loginModel.getPassword()[i] = new JTextField();
      loginModel.getPassword()[i].setBounds(15, 50, 250, 20);
    }
    loginModel.getConfirmPassInput().setBounds(15, 120, 250, 20);
    loginModel.getConfirmPassInput().setVisible(false);
    loginModel.getEncodeCheckBox().setBounds(80, 115, 185, 20);

  }

  // chỉnh phần trang đăng nhập
  private void setUpSignIn() {
    loginModel.getSignIn().setLayout(null);
    loginModel.getSignIn().setBounds(0, 0, 300, 270);

    loginModel.getSignIn().add(loginModel.getUsername()[0]);
    loginModel.getSignIn().add(loginModel.getPassword()[0]);

    loginModel.getSignIn().setVisible(true);
  }

  // chỉnh phần trang đăng ký
  private void setUpSignUp() {
    loginModel.getSignUp().setLayout(null);
    loginModel.getSignUp().setBounds(0, 0, 300, 270);
    loginModel.getSignUp().add(loginModel.getUsername()[1]);
    loginModel.getSignUp().add(loginModel.getPassword()[1]);

    loginModel.getSignUp().setVisible(true);
  }

  // chỉnh phần trang tổng chứa trang đăng nhập ,đăng ký
  private void setUpLogin() {
    loginModel.getLogin().setLayout(loginModel.getCardLayout());
    loginModel.getLogin().setBounds(0, 20, 300, 270);
    loginModel.getLogin().add(loginModel.getSignIn(), "SignIn");

    loginModel.getCardLayout().show(loginModel.getLogin(), "SignIn");
    loginModel.getLogin().setVisible(true);
  }

  // chỉnh trang windown để hiện login
  private void SetUpJDialog() {
    loginModel.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    loginModel.setLayout(null);

    loginModel.setSize(300, 300);
    loginModel.setResizable(false);
    loginModel.setLocationRelativeTo(null);
    loginModel.add(loginModel.getUserNameLabel());
    loginModel.add(loginModel.getPassWordLabel());
    loginModel.add(loginModel.getConfirmPassLabel());
    loginModel.add(loginModel.getConfirmPassInput());
    loginModel.add(loginModel.getLargeButton());
    loginModel.add(loginModel.getEncodeVisible());
    loginModel.add(loginModel.getEncodeCheckBox());
    loginModel.add(loginModel.getSmallButton());
    loginModel.add(loginModel.getLogin());

    loginModel.setVisible(false);

  }

  public LoginModel getLoginModel() {
    return loginModel;
  }

}
