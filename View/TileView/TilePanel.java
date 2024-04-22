package View.TileView;

import javax.swing.JPanel;

import Model.GameModel.GameModel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;



import Model.StateModel.FirstMapModel;

public class TilePanel extends JPanel{
    private TileManager tileManager;

    GameModel Mf;

    public TilePanel(GameModel Mf, TileManager tileManager)  {
        this.tileManager = tileManager;
        setPreferredSize(new Dimension(Mf.getJframeWidth(), Mf.getJframeHeight()));

       }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tileManager.draw(g2);
    }
}

