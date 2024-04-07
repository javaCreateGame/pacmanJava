package Controller.StateController;

import Model.GameModel.GameModel;
import Model.StateModel.IntroModel;
import View.StateView.IntroView;


public class IntroController {
    GameModel Mf;
    IntroModel introModel;
    IntroView introView;
    public IntroController(GameModel Mf){
        this.Mf=Mf;
        introModel=new IntroModel();
        introView=new IntroView(Mf, introModel);
    }
    public IntroModel getIntroModel() {
        return introModel;
    }
    
}
