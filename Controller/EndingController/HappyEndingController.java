package Controller.EndingController;

import javax.swing.Timer;

import Model.EndingModel.HappyEndingModel;
import View.EndingView.HappyEndingView;



public class HappyEndingController {
      private HappyEndingModel happyEndingModel;
    private HappyEndingView happyEndingView;
    public BadEndingController(){
        happyEndingModel=new HappyEndingModel();
        happyEndingView=new HappyEndingView(happyEndingModel);
        happyEndingModel.getTimerHappy()=new Timer(25,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (currentCharacterIndex < Ending[numberBad].length()) {
                    text[numberBad].append(String.valueOf(Ending[numberBad].charAt(currentCharacterIndex)));
                    currentCharacterIndex++;
                }
                else{
                    happyEndingModel.getTimerHappy().stop();
                    
                }
            }
            
        } );
    }
}
