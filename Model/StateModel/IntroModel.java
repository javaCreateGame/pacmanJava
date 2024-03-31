package Model.StateModel;

import javax.swing.JButton;
import javax.swing.JPanel;

import main.MyFrame;

public class IntroModel {
    MyFrame Mf;
    private JPanel introPanel;
    private JButton Start;
    private JButton Exit;
    private JButton loginButton; 
    public IntroModel(MyFrame Mf){
        this.Mf=Mf;
        introPanel=new JPanel();
        Start=new JButton("Start");
        Exit=new JButton("Exit");
        loginButton=new JButton("Đăng nhập");
    }
    public JPanel getIntroPanel() {
        return introPanel;
    }

    public JButton getStart() {
        return Start;
    }

    public JButton getExit() {
        return Exit;
    }

    public JButton getLoginButton() {
        return loginButton;
    }
}
