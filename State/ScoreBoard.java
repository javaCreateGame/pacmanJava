package State;

import javax.swing.*;
import main.MyFrame;
import java.awt.*;
import java.awt.event.MouseAdapter;

import main.MyFrame;

public class ScoreBoard {
    private JTextArea fieldText;
    private JButton Back;
    private JLayeredPane scoreBoard;
    private JLabel[] playerLabels;
    private MyFrame Mf;

    public ScoreBoard(MyFrame Mf) {
        this.Mf = Mf;
        scoreBoard = new JLayeredPane();

        // Set font for fieldText
        fieldText = new JTextArea();
        Font font = new Font("Arial", Font.BOLD, 13);
        fieldText.setFont(font);
        fieldText.setForeground(Color.BLACK);

        // Set position for fieldText
        fieldText.setBounds(105, 180, 300, 265);
        fieldText.setOpaque(false);
        fieldText.setEnabled(false);
        fieldText.setLineWrap(true);
        fieldText.setWrapStyleWord(true);

        // Load background image
        ImageIcon image = new ImageIcon("./picture/Background_ScoreBoard.png");
        JLabel backgroundLabel = new JLabel(image);
        backgroundLabel.setBounds(0, 0, Mf.getJframeWidth(), Mf.getJframeHeightParent());

        // Initialize the Back button
        Back = new JButton("Back");
        Back.setBounds(Mf.getJframeWidth() - 107, Mf.getJframeHeight() - 597, 130, 50);
        Back.setForeground(Color.BLACK);
        Back.setOpaque(false);
        Back.setContentAreaFilled(false);
        Back.setBorderPainted(false);
        Back.setFocusable(false);

        // Change text color when mouse hovers over the button
        Back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Back.setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Back.setForeground(Color.BLACK);
            }
        });

        // Initialize JLabels for player names and scores
        playerLabels = new JLabel[5];
        for (int i = 0; i < playerLabels.length; i++) {
            playerLabels[i] = new JLabel();
            playerLabels[i].setFont(new Font("Arial", Font.BOLD, 16));
            playerLabels[i].setForeground(Color.BLACK);
            playerLabels[i].setBounds(195, 280 + i * 40, 300, 30);
            scoreBoard.add(playerLabels[i]);
        }

        // Set player names and scores
        String[] players = { "NGUYỄN VĂN HOÀN", "NGUYỄN VĂN HOÀN", "NGUYỄN VĂN HOÀN" , "NGUYỄN VĂN HOÀN", "NGUYỄN VĂN HOÀN"};
        int[] scores = { 300, 255, 430, 422, 344 };
        for (int i = 0; i < playerLabels.length; i++) {
            playerLabels[i].setText(players[i] + " - " + scores[i]);
        }

        scoreBoard.add(Back);
        scoreBoard.add(fieldText, JLayeredPane.DEFAULT_LAYER);
        scoreBoard.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);
    }

    public JButton getBack() {
        return Back;
    }

    public JLayeredPane getscoreBoard() {
        return scoreBoard;
    }
}
