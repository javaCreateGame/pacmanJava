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
  
  private MyFrame Mf;
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
  private JLabel confirmPassLabel = new JLabel("Xác nhận mật khẩu");
  private JTextField confirmPassInput=new JTextField();
  private JTextField username[] = new JTextField[2];
  private JTextField password[] = new JTextField[2];
  private JLabel EncodeVisible = new JLabel();

  public SignIn_Up(MyFrame Mf) {
    
    super(Mf, "Login");
    this.Mf=Mf;
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
//Set font chữ tọa độ,màu của các button
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

  //set các dòng chữ tiêu đề như là chữ tài khoản.mật khẩu,..
  private void setUpLabel() {
    userNameLabel.setBounds(15, 0, 70, 20);
    passWordLabel.setBounds(15, 50, 70, 20);
    confirmPassLabel.setBounds(15, 100, 140, 20);
    confirmPassLabel.setVisible(false);
    
    code.encrypt((int) Math.floor((Math.random() * 3) + 1));
    EncodeVisible.setText(String.valueOf(code.getLetter()));
    EncodeVisible.setBounds(17, 115, 60, 20);
    EncodeVisible.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    EncodeVisible.setHorizontalAlignment(JLabel.CENTER);

  }

  //chỉnh tọa độ vị trí ,kích thước cho các dòng nhập
  private void setInput() {
    for (int i = 0; i < username.length; i++) {
      username[i] = new JTextField();
      username[i].setBounds(15, 0, 250, 20);

    }
    for (int i = 0; i < password.length; i++) {
      password[i] = new JTextField();
      password[i].setBounds(15, 50, 250, 20);
    }
   confirmPassInput.setBounds(15, 120, 250, 20);
   confirmPassInput.setVisible(false);
    encodeCheckBox.setBounds(80, 115, 185, 20);

  }
 //chỉnh phần trang đăng nhập
  private void setUpSignIn() {
    SignIn.setLayout(null);
    SignIn.setBounds(0, 0, 300, 270);

    SignIn.add(username[0]);
    SignIn.add(password[0]);

    SignIn.setVisible(true);
  }

   //chỉnh phần trang đăng ký
  private void setUpSignUp() {
    SignUp.setLayout(null);
    SignUp.setBounds(0, 0, 300, 270);
    SignUp.add(username[1]);
    SignUp.add(password[1]);
    
    SignUp.setVisible(true);
  }

  //chỉnh phần trang tổng chứa trang đăng nhập ,đăng ký
  private void setUpLogin() {
    Login.setLayout(cardLayout);
    Login.setBounds(0, 20, 300, 270);
    Login.add(SignIn, "SignIn");

    cardLayout.show(Login, "SignIn");
    Login.setVisible(true);
  }

  //chỉnh trang windown để hiện login
  private void SetUpJDialog() {
    this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
    this.setLayout(null);

    this.setSize(300, 300);
    this.setResizable(false);
    this.setLocationRelativeTo(null);
    this.add(userNameLabel);
    this.add(passWordLabel);
    this.add(confirmPassLabel);
    this.add(confirmPassInput);
    this.add(largeButton);
    this.add(EncodeVisible);
    this.add(encodeCheckBox);
    this.add(smallButton);
    this.add(Login);

    this.setVisible(false);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    //Sự kiên bấm vào nút nhỏ
    if (e.getSource() == smallButton) {
      //Nếu largerButton hiện có chữ đăng ký thì đổi thành đăng nhập và nguoc lại
      largeButton.setText(nameLargeButton.equals("Đăng ký") ? "Đăng nhập" : "Đăng ký");
       //Nếu smallButton hiện có chữ đăng ký thì đổi thành đăng ký và ngược lại
      smallButton.setText(nameLargeButton.equals("Đăng ký") ? "Đăng ký" : "Đăng nhập");

      // Cập nhật biến sau khi đặt văn bản nút
      nameLargeButton = largeButton.getText(); // Lấy văn bản cập nhật từ nút
      nameSmallButton= smallButton.getText(); // Lấy văn bản cập nhật từ nút

       //Sự kiện chuyển từ trang đăng nhập sang đăng ký
      if (largeButton.getText()=="Đăng ký" && smallButton.getText()=="Đăng nhập" ) {
        setLocationInput_Button(165, 165, 200, 135,true);
      }
      //Sự kiện chuyển từ trang đăng nhập sang đăng ký
      else{
       setLocationInput_Button(115, 115, 150, 85,false);
      }
      //thay chuỗi mã hóa thành chuỗi mã hóa mới
      code.newKey();
      code.encrypt((int) Math.floor((Math.random() * 3) + 1));
      EncodeVisible.setText(String.valueOf(code.getLetter()));
    }

    //Sự kiện nhấn nút to
    if (e.getSource() == largeButton) {
      //Nếu nhập đúng chuỗi mã hóa
      if (encodeCheckBox.getText().equals(EncodeVisible.getText())) {
        //Cho biến outDialog bằng true để đảm báo trang Login sẽ đóng
        outDialog = true; 

        //Lấy settext của loginButton trong intro bằng đúng tên tài khoản vừa nhập
        Mf.getIntro().getLoginButton().setText(username[0].getText());
        //Ânr trang login
        this.setVisible(false);
        
      } 
      //Nếu nhập sai chuỗi mã hóa in ra thông báo
      else {
        JOptionPane.showConfirmDialog(null, "Bạn đã nhập sai check box", "Warning", JOptionPane.PLAIN_MESSAGE);
        resetLoginDialog();
      }
    }
  }
//Hàm reset lại Login
  public void resetLoginDialog(){
   //đặt lại các input của username và passwword 
    for(int i=0; i< username.length;i++){
      username[i].setText("");
      password[i].setText("");
    }
    //Đặt lại input phần checkBox
    encodeCheckBox.setText("");
    //Thay chuỗi mã hóa thành chuỗi mới
    code.newKey();
    code.encrypt((int) Math.floor((Math.random() * 3) + 1));
    EncodeVisible.setText(String.valueOf(code.getLetter()));
  }
//Hàm đặt tọa độ cho vị trí các nút và vị trí phần check encode
  private void setLocationInput_Button(int x,int y,int z,int t ,boolean visible){
    EncodeVisible.setBounds(17, x, 60, 20);
    encodeCheckBox.setBounds(80, y, 185, 20);
    largeButton.setBounds(45, z, 190, 40);
    smallButton.setBounds(200, t, 90, 30);
    confirmPassInput.setVisible(visible);
    confirmPassLabel.setVisible(visible);
  }
  public boolean isOutDialog() {
    return outDialog;
  }

  public void setOutDialog(boolean outDialog) {
    this.outDialog = outDialog;
  }

}
