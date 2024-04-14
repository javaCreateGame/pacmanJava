package Controller.LoginController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Model.GameModel.GameModel;
import Model.LoginModel.LoginModel;
import View.LoginView.LoginView;
import dao.InfoDAO;
import daoModel.Info;

import java.util.ArrayList;

public class LoginController implements ActionListener {
  GameModel Mf;
  private LoginModel loginModel;
  private LoginView loginView;

  public LoginController(GameModel Mf) {
    this.Mf = Mf;
    loginModel = new LoginModel(Mf);
    loginView = new LoginView(loginModel);

    loginModel.getLargeButton().addActionListener(this);
    loginModel.getSmallButton().addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // Sự kiên bấm vào nút nhỏ
    if (e.getSource() == loginModel.getSmallButton()) {
      // Nếu largerButton hiện có chữ đăng ký thì đổi thành đăng nhập và nguoc lại
      loginModel.getLargeButton().setText(loginModel.getNameLargeButton().equals("Đăng ký") ? "Đăng nhập" : "Đăng ký");
      // Nếu smallButton hiện có chữ đăng ký thì đổi thành đăng ký và ngược lại
      loginModel.getSmallButton().setText(loginModel.getNameLargeButton().equals("Đăng ký") ? "Đăng ký" : "Đăng nhập");

      // Cập nhật biến sau khi đặt văn bản nút
      loginModel.setNameLargeButton(loginModel.getLargeButton().getText()); // Lấy văn bản cập nhật từ nút
      loginModel.setNameSmallButton(loginModel.getSmallButton().getText()); // Lấy văn bản cập nhật từ nút

      // Sự kiện chuyển từ trang đăng nhập sang đăng ký
      if (loginModel.getLargeButton().getText() == "Đăng ký" && loginModel.getSmallButton().getText() == "Đăng nhập") {
        setLocationInput_Button(165, 165, 200, 135, true);
      }
      // Sự kiện chuyển từ trang đăng nhập sang đăng ký
      else {
        setLocationInput_Button(115, 115, 150, 85, false);
      }
      // thay chuỗi mã hóa thành chuỗi mã hóa mới
      loginModel.getCode().newKey();
      loginModel.getCode().encrypt((int) Math.floor((Math.random() * 3) + 1));
      loginModel.getEncodeVisible().setText(String.valueOf(loginModel.getCode().getLetter()));
    }
    // Sự kiện nhấn nút to
    if (e.getSource() == loginModel.getLargeButton()) {
      if (loginModel.getEncodeCheckBox().getText().equals(loginModel.getEncodeVisible().getText())) {
        loginModel.setOutDialog(true);

        // Import vào database

<<<<<<< HEAD
        // // Nếu là đăng ký, kiểm tra xem username đã tồn tại trong csdl chưa
         if(loginModel.getLargeButton().getText()=="Đăng ký") {
        // ArrayList<Info> list = InfoDAO.getInstance().selectAll();
         String usernameKiemTra = loginModel.getUsername()[0].getText();
         
         if (!Pattern.matches("^[a-zA-Z]{1}[a-zA-Z0-9]{4,}", usernameKiemTra)){ //kiểm tra regex của username
          JOptionPane.showConfirmDialog(null, "Tên đăng nhập không đúng định dạng", "Warning", JOptionPane.PLAIN_MESSAGE);
          return;
          }

          char[] passwordKiemTra = loginModel.getPassword()[0].getPassword();
          char[] passwordcfKiemTra = loginModel.getConfirmPassInput().getPassword();

          String string1 = new String(passwordKiemTra);
          String string2 = new String(passwordcfKiemTra);

          if (!Pattern.matches("[a-zA-Z0-9]{5,10}", string1)) { //kiểm tra regex của password
            JOptionPane.showConfirmDialog(null, "Mật khẩu không đúng định dạng", "Warning", JOptionPane.PLAIN_MESSAGE);
            return;
          }
          else if(!string1.equals(string2)){ //kiểm tra xác nhận mật khẩu trung khớp với mật khẩu chưa
            JOptionPane.showConfirmDialog(null, "Xác nhận mật khẩu không đúng", "Warning", JOptionPane.PLAIN_MESSAGE);
            return; 
          }
          else // nếu đúng hết thì đăng kí thành công
          // if (Pattern.matches("$[a-zA-Z][a-zA-Z0-9]{1,}", usernameKiemTra) && 
          // Pattern.matches("[a-zA-Z0-9]{5,10}", string1) &&
          // string1.equals(string2))
          {
            JOptionPane.showConfirmDialog(null, "Đăng kí thành công", "Warning", JOptionPane.PLAIN_MESSAGE);
          }

          
        // boolean contains = false;
        // for (Info info : list) {
        // if(info.getTenDangNhap().equals(usernameKiemTra)) {
        // contains = true;
        // break;
        // }
        // }
        // // Nếu tồn tại rồi, thông báo là đã tồn tại đồng thời reset login dialog
        // if(contains) {
        // JOptionPane.showConfirmDialog(null, "Tên đăng nhập đã tồn tại, vui lòng thử
        // lại với tên khác", "Warning", JOptionPane.PLAIN_MESSAGE);
        // resetLoginDialog();
        // }
        // // Ngược lại nếu chưa tồn tại, import thông tin xuống cơ sở dữ liệu
        // else {
        // int diem = 0;
        // String tenDangNhap = loginModel.getUsername()[0].getText();
        // String matKhau = loginModel.getPassword()[0].getText();
        // Info if1 = new Info(tenDangNhap, matKhau, diem);
        // InfoDAO.getInstance().insert(if1);
        // Mf.getIntro().getIntroModel().getLoginButton().setText(
        // loginModel.getUsername()[0].getText());
        // }
=======
        // Nếu là đăng ký, kiểm tra xem username đã tồn tại trong csdl chưa
        if(loginModel.getLargeButton().getText()=="Đăng ký") {
          // ArrayList<Info> list = InfoDAO.getInstance().selectAll();
          // String usernameKiemTra = loginModel.getUsername()[0].getText();
          // boolean contains = false;
          // for (Info info : list) {
          //   if(info.getTenDangNhap().equals(usernameKiemTra)) {
          //     contains = true;
          //     break;
          //   }
          // }
          // // Nếu tồn tại rồi, thông báo là đã tồn tại đồng thời reset login dialog
          // if(contains) {
          //   JOptionPane.showConfirmDialog(null, "Tên đăng nhập đã tồn tại, vui lòng thử lại", "Warning", JOptionPane.PLAIN_MESSAGE);
          //   resetLoginDialog();
          // }
          // // Ngược lại nếu chưa tồn tại, import thông tin xuống cơ sở dữ liệu
          // else {
          //   int diem = 0;
          //   String tenDangNhap = loginModel.getUsername()[0].getText();
          //   String matKhau = loginModel.getPassword()[0].getText();
          //   Info if1 = new Info(tenDangNhap, matKhau, diem);
          //   InfoDAO.getInstance().insert(if1);
          //   Mf.getIntro().getIntroModel().getLoginButton().setText(
          //   loginModel.getUsername()[0].getText());
          // }
>>>>>>> upstream/main
        }

        // Nếu là đăng nhập, kiểm tra điều kiện là mật khẩu phải chính xác với tài
        // khoản
        if(loginModel.getLargeButton().getText()=="Đăng nhập") {
          // String usernameKiemTra = loginModel.getUsername()[0].getText();
          // String matKhauKiemTra = loginModel.getPassword()[0].getText();
          // String query = "tenDangNhap = '"+usernameKiemTra+"' " ;
          // ArrayList<Info> list = InfoDAO.getInstance().selectByCondition(query);
          // for (Info info : list) {
          //   if (info.getMatKhau().equals(matKhauKiemTra)) {
          //   Mf.getIntro().getIntroModel().getLoginButton().setText(loginModel.getUsername()[0].getText());
          //   }
          //   // Nếu mật khẩu không chính xác, in ra thông báo đồng thời reset login dialog
          //   else {
          //   JOptionPane.showConfirmDialog(null, "Tên tài khoản hoặc mật khẩu không đúng, vui lòng kiểm tra lại", "Warning", JOptionPane.PLAIN_MESSAGE);
          //   resetLoginDialog();
          //   }
          // } 
        }
        loginModel.setVisible(false);
      }
      // Nếu nhập sai chuỗi mã hóa in ra thông báo
      else {
        JOptionPane.showConfirmDialog(null, "Bạn đã nhập sai check box", "Warning", JOptionPane.PLAIN_MESSAGE);
        loginModel.getCode().newKey();
        loginModel.getCode().encrypt((int) Math.floor((Math.random() * 3) + 1));
        loginModel.getEncodeVisible().setText(String.valueOf(loginModel.getCode().getLetter()));
      }
    }
  }

  // Hàm reset lại Login
  public void resetLoginDialog() {
    // đặt lại các input của username và passwword
    for (int i = 0; i < loginModel.getUsername().length; i++) {
      loginModel.getUsername()[i].setText("");
      loginModel.getPassword()[i].setText("");
    }
    // Đặt lại input phần checkBox
    loginModel.getEncodeCheckBox().setText("");
    // Thay chuỗi mã hóa thành chuỗi mới
    loginModel.getCode().newKey();
    loginModel.getCode().encrypt((int) Math.floor((Math.random() * 3) + 1));
    loginModel.getEncodeVisible().setText(String.valueOf(loginModel.getCode().getLetter()));
  }

  // Hàm đặt tọa độ cho vị trí các nút và vị trí phần check encode
  private void setLocationInput_Button(int x, int y, int z, int t, boolean visible) {
    loginModel.getEncodeVisible().setBounds(17, x, 60, 20);
    loginModel.getEncodeCheckBox().setBounds(80, y, 185, 20);
    loginModel.getLargeButton().setBounds(45, z, 190, 40);
    loginModel.getSmallButton().setBounds(200, t, 90, 30);
    loginModel.getConfirmPassInput().setVisible(visible);
    loginModel.getConfirmPassLabel().setVisible(visible);
  }

  public LoginModel getLoginModel() {
    return loginModel;
  }

  public LoginView getLoginView() {
    return loginView;
  }


}
