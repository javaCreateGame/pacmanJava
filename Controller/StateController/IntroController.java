package Controller.StateController;

import Model.StateModel.IntroModel;
import View.StateView.IntroView;
import main.MyFrame;

public class IntroController {
    MyFrame Mf;
    IntroModel introModel;
    IntroView introView;
    public IntroController(MyFrame Mf){
        this.Mf=Mf;
        introModel=new IntroModel(Mf);
        introView=new IntroView(Mf, introModel);
    }
    public IntroModel getIntroModel() {
        return introModel;
    }
    
}
