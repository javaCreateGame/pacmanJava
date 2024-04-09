package Model.StateModel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import Controller.*;
import daoModel.*;
import dao.*;

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
    
    public void setUserScore(String[] players, int[] scores) {
        for(int i = 0; i < this.getPlayerLabels().length; i++) {
            this.getPlayerLabels()[i].setText(players[i] + " - " + scores[i]);
        }
    }

    public void refreshScoreboard(String[] players, int[] scores) {
        ArrayList<Info> kq = new ArrayList<Info>();
        kq = InfoDAO.getInstance().selectAll();

        // Tạo danh sách các đối tượng Info
        List<Info> sortedInfos = new ArrayList<>();
        for (Info info : kq) {
            sortedInfos.add(info);
        }

        // Sắp xếp danh sách theo điểm giảm dần
        Collections.sort(sortedInfos, new Comparator<Info>() {
            @Override
            public int compare(Info info1, Info info2) {
                return Integer.compare(info2.getDiem(), info1.getDiem());
            }
        });

        int check = 0;
        for (Info info : sortedInfos) {
            if (check > 4) {
                break;
            }
            else {
                players[check] = info.getTenDangNhap();
                scores[check] = info.getDiem();
                check++;
            }
        }
    }
}
