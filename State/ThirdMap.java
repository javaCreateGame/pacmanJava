package State;

import javax.swing.JPanel;

import main.MyFrame;

public class ThirdMap extends Map {
    MyFrame Mf;
    public JPanel thirdMapPanel;
    public ThirdMap(MyFrame Mf){
        this.Mf=Mf;
        //set up panel
       thirdMapPanel =new JPanel();
       thirdMapPanel.setBounds(0, 0, 615, 615);
       thirdMapPanel.setOpaque(true);


        //Code Giao dien

        

    }
}
