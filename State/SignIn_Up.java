package State;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

import daoModel.*;
import dao.*;

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
    if (e.getSource() == smallButton) {
      largeButton.setText(nameLargeButton.equals("Đăng ký") ? "Đăng nhập" : "Đăng ký");
      smallButton.setText(nameLargeButton.equals("Đăng ký") ? "Đăng ký" : "Đăng nhập");

      // Cập nhật biến sau khi đặt văn bản nút
      nameLargeButton = largeButton.getText(); // Lấy văn bản cập nhật từ nút
      nameSmallButton= smallButton.getText(); // Lấy văn bản cập nhật từ nút

      if (largeButton.getText()=="Đăng ký" && smallButton.getText()=="Đăng nhập" ) {
        setLocationInput_Button(165, 165, 200, 135,true);
      }
      else{
       setLocationInput_Button(115, 115, 150, 85,false);
      }
      code.newKey();
      code.encrypt((int) Math.floor((Math.random() * 3) + 1));
      EncodeVisible.setText(String.valueOf(code.getLetter()));
    }

    if (e.getSource() == largeButton) {

      if (encodeCheckBox.getText().equals(EncodeVisible.getText())) {
        outDialog = true;
        
        // Import vào database
      
        // Nếu là đăng ký, kiểm tra xem username đã tồn tại trong csdl chưa
        if(largeButton.getText()=="Đăng ký") {
          ArrayList<Info> list = InfoDAO.getInstance().selectAll();
          String usernameKiemTra = username[0].getText();
          boolean contains = false;
          for (Info info : list) {
            if(info.getTenDangNhap().equals(usernameKiemTra)) {
              contains = true;
              break;
            }
          }
          // Nếu tồn tại rồi, thông báo là đã tồn tại đồng thời reset login dialog
          if(contains) {
            JOptionPane.showConfirmDialog(null, "Tên đăng nhập đã tồn tại, vui lòng thử lại với tên khác", "Warning", JOptionPane.PLAIN_MESSAGE);
            resetLoginDialog();
          }
          // Ngược lại nếu chưa tồn tại, import thông tin xuống cơ sở dữ liệu
          else {
            int diem = 0;
            String tenDangNhap = username[0].getText();
            String matKhau = password[0].getText();
            Info if1 = new Info(tenDangNhap, matKhau, diem);
            InfoDAO.getInstance().insert(if1);
            Mf.getIntro().getLoginButton().setText(username[0].getText());
          }
        }

        // Nếu là đăng nhập, kiểm tra điều kiện là mật khẩu phải chính xác với tài khoản
        if(largeButton.getText()=="Đăng nhập") {
          String usernameKiemTra = username[0].getText();
          String matKhauKiemTra = password[0].getText();
          String query = "tenDangNhap = '"+usernameKiemTra+"' "  ;
          ArrayList<Info> list = InfoDAO.getInstance().selectByCondition(query);
          for (Info info : list) {
            if (info.getMatKhau().equals(matKhauKiemTra)) {
              Mf.getIntro().getLoginButton().setText(username[0].getText());
            }
            // Nếu mật khẩu không chính xác, in ra thông báo đồng thời reset login dialog
            else {
              JOptionPane.showConfirmDialog(null, "Tên tài khoản hoặc mật khẩu không đúng, vui lòng kiểm tra lại", "Warning", JOptionPane.PLAIN_MESSAGE);
              resetLoginDialog();
            }
          }
        }


        this.setVisible(false);
      } 
      else {
        JOptionPane.showConfirmDialog(null, "Bạn đã nhập sai check box", "Warning", JOptionPane.PLAIN_MESSAGE);
        resetLoginDialog();
      }
    }
  }

  public void resetLoginDialog(){
    for(int i=0; i< username.length;i++){
      username[i].setText("");
      password[i].setText("");
    }
    encodeCheckBox.setText("");
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
