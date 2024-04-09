package View.StateView;

import Model.GameModel.GameModel;
import Model.StateModel.ScoreBoardModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class ScoreBoardView {
    private ScoreBoardModel scoreBoardModel;
    GameModel Mf;
    public static String[] players = new String[5];
    public static int[] scores = new int[5];

    

    public ScoreBoardView(GameModel Mf, ScoreBoardModel scoreBoardModel) {
        this.Mf = Mf;
        this.scoreBoardModel = scoreBoardModel;

        Font font = new Font("Arial", Font.BOLD, 13);
        scoreBoardModel.getFieldText().setFont(font);
        scoreBoardModel.getFieldText().setForeground(Color.BLACK);

        // Set position for fieldText
        scoreBoardModel.getFieldText().setBounds(105, 180, 300, 265);
        scoreBoardModel.getFieldText().setOpaque(false);
        scoreBoardModel.getFieldText().setEnabled(false);
        scoreBoardModel.getFieldText().setLineWrap(true);
        scoreBoardModel.getFieldText().setWrapStyleWord(true);

        // Load background image
        ImageIcon image = new ImageIcon("./picture/Background_ScoreBoard.png");
        JLabel backgroundLabel = new JLabel(image);
        backgroundLabel.setBounds(0, 0, Mf.getJframeWidth(), Mf.getJframeHeightParent());

        // Initialize the Back button

        scoreBoardModel.getBack().setBounds(Mf.getJframeWidth() - 107, Mf.getJframeHeight() - 597, 130, 50);
        scoreBoardModel.getBack().setForeground(Color.BLACK);
        scoreBoardModel.getBack().setOpaque(false);
        scoreBoardModel.getBack().setContentAreaFilled(false);
        scoreBoardModel.getBack().setBorderPainted(false);
        scoreBoardModel.getBack().setFocusable(false);

        // Change text color when mouse hovers over the button
        scoreBoardModel.getBack().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                scoreBoardModel.getBack().setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                scoreBoardModel.getBack().setForeground(Color.BLACK);
            }
        });

        // Initialize JLabels for player names and scores

        for (int i = 0; i < scoreBoardModel.getPlayerLabels().length; i++) {
            scoreBoardModel.getPlayerLabels()[i] = new JLabel();
            scoreBoardModel.getPlayerLabels()[i].setFont(new Font("Arial", Font.BOLD, 16));
            scoreBoardModel.getPlayerLabels()[i].setForeground(Color.BLACK);
            scoreBoardModel.getPlayerLabels()[i].setBounds(195, 280 + i * 40, 300, 30);
            scoreBoardModel.getScoreBoard().add(scoreBoardModel.getPlayerLabels()[i]);
        }

        // Set player names and scores
        // Lấy thông tin của người chơi từ database rồi hiện lên bảng xếp hạng

        
        scoreBoardModel.refreshScoreboard(players, scores);
        scoreBoardModel.setUserScore(players, scores);

        scoreBoardModel.getScoreBoard().add(scoreBoardModel.getBack());
        scoreBoardModel.getScoreBoard().add(scoreBoardModel.getFieldText(), JLayeredPane.DEFAULT_LAYER);
        scoreBoardModel.getScoreBoard().add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);
    }

}
