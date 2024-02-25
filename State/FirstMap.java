package State;
import javax.swing.JPanel;

import main.MyFrame;

public class FirstMap extends Map {
  public boolean addHear= true;
  public boolean removeHeart= false;
  public int heartXLocation = 556, heartYLocation = 305;
  MyFrame Mf;
 public JPanel firstMapPanel;
   public FirstMap(MyFrame Mf){
      this.Mf=Mf;
       //set up panel
       firstMapPanel =new JPanel();
       firstMapPanel.setBounds(0, 0, Mf.jframeWidth, Mf.jframeHeight);
       firstMapPanel.setOpaque(true);
        //Code Giao dien


}

}
