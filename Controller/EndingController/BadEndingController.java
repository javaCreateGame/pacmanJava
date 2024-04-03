package Controller.EndingController;

import javax.swing.Timer;

import Model.EndingModel.BadEndingModel;
import View.EndingView.BadEndingView;

public class BadEndingController {
    private BadEndingModel badEndingModel;
    private BadEndingView badEndingView;
    public BadEndingController(){
        badEndingModel=new BadEndingModel();
        badEndingView=new BadEndingView(badEndingModel);
        BadEndingModel.getTimerBad()=new Timer(25,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (currentCharacterIndex < Ending[numberBad].length()) {
                    text[numberBad].append(String.valueOf(Ending[numberBad].charAt(currentCharacterIndex)));
                    currentCharacterIndex++;
                }
                else{
                    BadEndingModel.getTimerBad().stop();
                    
                }
            }
            
        } );
    }
}
