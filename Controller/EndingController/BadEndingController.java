package Controller.EndingController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Model.EndingModel.BadEndingModel;
import View.EndingView.BadEndingView;

public class BadEndingController {
    private BadEndingModel badEndingModel;
    private BadEndingView badEndingView;
    private Timer timerBad;
    public BadEndingController(){
        badEndingModel=new BadEndingModel();
        badEndingView=new BadEndingView(badEndingModel);
        timerBad=new Timer(25,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (badEndingModel.getCurrentCharacterIndex() < badEndingModel.getEnding()[badEndingModel.getNumberBad()].length()) {
                    badEndingModel.getText()[badEndingModel.getNumberBad()].append(String.valueOf(badEndingModel.getEnding()[badEndingModel.getNumberBad()].charAt(badEndingModel.getCurrentCharacterIndex())));
                    badEndingModel.setCurrentCharacterIndex(badEndingModel.getCurrentCharacterIndex()+1);
                }
                else{
                    timerBad.stop();
                    
                }
            }
            
        } );
        
    }
    public BadEndingModel getBadEndingModel() {
        return badEndingModel;
    }
    public Timer getTimerBad() {
        return timerBad;
    }
    public BadEndingView getBadEndingView() {
        return badEndingView;
    }
    
}
