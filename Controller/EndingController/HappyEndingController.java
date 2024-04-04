package Controller.EndingController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Model.EndingModel.HappyEndingModel;
import View.EndingView.HappyEndingView;



public class HappyEndingController {
      private HappyEndingModel happyEndingModel;
      private Timer timerHappy;
    private HappyEndingView happyEndingView;
    public HappyEndingController(){
        happyEndingModel=new HappyEndingModel();
        happyEndingView=new HappyEndingView(happyEndingModel);
       timerHappy=new Timer(25,new ActionListener() {

           
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (happyEndingModel.getCurrentCharacterIndex() < happyEndingModel.getEnding()[happyEndingModel.getNumberHappy()].length()) {
                happyEndingModel.getText()[happyEndingModel.getNumberHappy()].append(String.valueOf(happyEndingModel.getEnding()[happyEndingModel.getNumberHappy()].charAt(happyEndingModel.getCurrentCharacterIndex())));
                happyEndingModel.setCurrentCharacterIndex(happyEndingModel.getCurrentCharacterIndex()+1);
            }
            else{
                timerHappy.stop();
                
            }
        }
            
        } );
    }
    public HappyEndingModel getHappyEndingModel() {
        return happyEndingModel;
    }
    public Timer getTimerHappy() {
        return timerHappy;
    }
    
}
