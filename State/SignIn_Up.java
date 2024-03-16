package State;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.CardLayout;
import java.awt.Color;

import java.awt.Font;

import Encode.EncryptionProgram;
import main.MyFrame;

public class SignIn_Up extends JDialog implements ActionListener {
  private String nameLargeButton = "Đăng nhập";
  private String nameSmallButton= "Đăng Ký";
  
  private CardLayout cardLayout = new CardLayout();
  private EncryptionProgram code = new EncryptionProgram();
  private boolean outDialog = false;
  private JButton largeButton = new JButton("Đăng nhập");
  private JButton smallButton = new JButton("Đăng ký");

  private JPanel SignIn = new JPanel();
  private JPanel SignUp = new JPanel();
  private JPanel Login = new JPanel();

  private JTextField encodeCheckBox = new JTextField();
  private JLabel userNameLabel = new JLabel("Tài khoản");
  private JLabel passWordLabel = new JLabel("Mật khẩu");
  private JTextField username[] = new JTextField[2];
  private JTextField password[] = new JTextField[2];
  private JLabel EncodeVisible = new JLabel();

  public SignIn_Up(MyFrame Mf) {
    super(Mf, "Login");
    setUpButton();
    setUpLabel();
    setInput();
    setUpSignIn();
    setUpSignUp();
    setUpLogin();
    SetUpJDialog();

    smallButton.addActionListener(this);
    largeButton.addActionListener(this);
  }

  private void setUpButton() {
    largeButton.setBounds(45, 150, 190, 40);
    largeButton.setFocusable(false);
    largeButton.setVisible(true);

    smallButton.setBounds(200, 85, 90, 30);
    smallButton.setFont(new Font("Arial", Font.BOLD, 10));
    smallButton.setOpaque(false);
    smallButton.setContentAreaFilled(false);
    smallButton.setBorderPainted(false);
    smallButton.setVisible(true);

  }

  private void setUpLabel() {
    userNameLabel.setBounds(15, 0, 70, 20);
    passWordLabel.setBounds(15, 50, 70, 20);

    code.encrypt((int) Math.floor((Math.random() * 3) + 1));
    EncodeVisible.setText(String.valueOf(code.getLetter()));
    EncodeVisible.setBounds(17, 115, 60, 20);
    EncodeVisible.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    EncodeVisible.setHorizontalAlignment(JLabel.CENTER);

  }

  private void setInput() {
    for (int i = 0; i < username.length; i++) {
      username[i] = new JTextField();
      username[i].setBounds(15, 0, 250, 20);

    }
    for (int i = 0; i < password.length; i++) {
      password[i] = new JTextField();
      password[i].setBounds(15, 50, 250, 20);
    }

    encodeCheckBox.setBounds(80, 115, 185, 20);

  }

  private void setUpSignIn() {
    SignIn.setLayout(null);
    SignIn.setBounds(0, 0, 300, 270);

    SignIn.add(username[0]);
    SignIn.add(password[0]);

    SignIn.setVisible(true);
  }

  private void setUpSignUp() {
    SignUp.setLayout(null);
    SignUp.setBounds(0, 0, 300, 270);
    SignUp.add(username[1]);
    SignUp.add(password[1]);

    SignUp.setVisible(true);
  }

  private void setUpLogin() {
    Login.setLayout(cardLayout);
    Login.setBounds(0, 20, 300, 270);
    Login.add(SignIn, "SignIn");

    cardLayout.show(Login, "SignIn");
    Login.setVisible(true);
  }

  private void SetUpJDialog() {
    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    this.setLayout(null);

    this.setSize(300, 300);
    this.setResizable(false);
    this.setLocationRelativeTo(null);
    this.add(userNameLabel);
    this.add(passWordLabel);
    this.add(largeButton);
    this.add(EncodeVisible);
    this.add(encodeCheckBox);
    this.add(smallButton);
    this.add(Login);

    this.setVisible(true);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == smallButton) {
      largeButton.setText(nameLargeButton.equals("Đăng ký") ? "Đăng nhập" : "Đăng ký");
      smallButton.setText(nameLargeButton.equals("Đăng ký") ? "Đăng ký" : "Đăng nhập");

      // Cập nhật biến sau khi đặt văn bản nút
      nameLargeButton = largeButton.getText(); // Lấy văn bản cập nhật từ nút
      nameSmallButton= smallButton.getText(); // Lấy văn bản cập nhật từ nút

      code.newKey();
      code.encrypt((int) Math.floor((Math.random() * 3) + 1));
      EncodeVisible.setText(String.valueOf(code.getLetter()));
    }

    if (e.getSource() == largeButton) {
      if (encodeCheckBox.getText().equals(EncodeVisible.getText())) {
        outDialog = true;
        this.dispose();
      } else {
        JOptionPane.showConfirmDialog(null, "Bạn đã nhập sai check box", "Warning", JOptionPane.PLAIN_MESSAGE);
        code.newKey();
        code.encrypt((int) Math.floor((Math.random() * 3) + 1));
        EncodeVisible.setText(String.valueOf(code.getLetter()));
      }
    }
  }

  public boolean isOutDialog() {
    return outDialog;
  }

}
