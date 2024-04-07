package Model.StateModel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

public class ScoreBoardModel {
    private JTextArea fieldText = new JTextArea();
    private JButton Back = new JButton("Back");
    private JLayeredPane scoreBoard = new JLayeredPane();
    private JLabel[] playerLabels = new JLabel[5];

    public JTextArea getFieldText() {
        return fieldText;
    }

    public JButton getBack() {
        return Back;
    }

    public JLayeredPane getScoreBoard() {
        return scoreBoard;
    }

    public JLabel[] getPlayerLabels() {
        return playerLabels;
    }

}
