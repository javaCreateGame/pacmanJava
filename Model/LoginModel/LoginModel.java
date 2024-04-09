package Model.LoginModel;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Encode.EncryptionProgram;
import Model.GameModel.GameModel;

public class LoginModel extends JDialog {
    private String nameLargeButton = "Đăng nhập";
    private String nameSmallButton = "Đăng Ký";

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
    private JTextField confirmPassInput = new JTextField();
    private JTextField username[] = new JTextField[2];
    private JTextField password[] = new JTextField[2];
    private JLabel EncodeVisible = new JLabel();

    public LoginModel(GameModel Mf) {
        super(Mf, "Login");
    }

    public String getNameLargeButton() {
        return nameLargeButton;
    }

    public String getNameSmallButton() {
        return nameSmallButton;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public EncryptionProgram getCode() {
        return code;
    }

    public boolean isOutDialog() {
        return outDialog;
    }

    public JButton getLargeButton() {
        return largeButton;
    }

    public JButton getSmallButton() {
        return smallButton;
    }

    public JPanel getSignIn() {
        return SignIn;
    }

    public JPanel getSignUp() {
        return SignUp;
    }

    public JPanel getLogin() {
        return Login;
    }

    public JTextField getEncodeCheckBox() {
        return encodeCheckBox;
    }

    public JLabel getUserNameLabel() {
        return userNameLabel;
    }

    public JLabel getPassWordLabel() {
        return passWordLabel;
    }

    public JLabel getConfirmPassLabel() {
        return confirmPassLabel;
    }

    public JTextField getConfirmPassInput() {
        return confirmPassInput;
    }

    public JTextField[] getUsername() {
        return username;
    }

    public String getUsernameI() {
        return username[0].getText();
    }

    public JTextField[] getPassword() {
        return password;
    }

    public JLabel getEncodeVisible() {
        return EncodeVisible;
    }

    public void setNameLargeButton(String nameLargeButton) {
        this.nameLargeButton = nameLargeButton;
    }

    public void setNameSmallButton(String nameSmallButton) {
        this.nameSmallButton = nameSmallButton;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public void setCode(EncryptionProgram code) {
        this.code = code;
    }

    public void setOutDialog(boolean outDialog) {
        this.outDialog = outDialog;
    }

    public void setLargeButton(JButton largeButton) {
        this.largeButton = largeButton;
    }

    public void setSmallButton(JButton smallButton) {
        this.smallButton = smallButton;
    }

    public void setSignIn(JPanel signIn) {
        SignIn = signIn;
    }

    public void setSignUp(JPanel signUp) {
        SignUp = signUp;
    }

    public void setLogin(JPanel login) {
        Login = login;
    }

    public void setEncodeCheckBox(JTextField encodeCheckBox) {
        this.encodeCheckBox = encodeCheckBox;
    }

    public void setUserNameLabel(JLabel userNameLabel) {
        this.userNameLabel = userNameLabel;
    }

    public void setPassWordLabel(JLabel passWordLabel) {
        this.passWordLabel = passWordLabel;
    }

    public void setConfirmPassLabel(JLabel confirmPassLabel) {
        this.confirmPassLabel = confirmPassLabel;
    }

    public void setConfirmPassInput(JTextField confirmPassInput) {
        this.confirmPassInput = confirmPassInput;
    }

    public void setUsername(JTextField[] username) {
        this.username = username;
    }

    public void setPassword(JTextField[] password) {
        this.password = password;
    }

    public void setEncodeVisible(JLabel encodeVisible) {
        EncodeVisible = encodeVisible;
    }

}
