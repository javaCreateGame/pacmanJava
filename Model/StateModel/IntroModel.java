package Model.StateModel;

import javax.swing.JButton;
import javax.swing.JPanel;

public class IntroModel {

    private JPanel introPanel;
    private JButton Start;
    private JButton Exit;
    private JButton loginButton;
    private JButton scoreBoardButton;

    public IntroModel() {

        introPanel = new JPanel();
        Start = new JButton("Start");
        Exit = new JButton("Exit");
        loginButton = new JButton("Đăng nhập");
        scoreBoardButton = new JButton("SCORE BOARD");
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

    public JButton getScoreBoardButton() {
        return scoreBoardButton;
    }

}
