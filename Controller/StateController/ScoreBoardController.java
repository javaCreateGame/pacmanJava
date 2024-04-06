package Controller.StateController;

import Model.StateModel.ScoreBoardModel;
import View.StateView.ScoreBoardView;
import main.MyFrame;

public class ScoreBoardController {
    private ScoreBoardModel scoreBoardModel;
    private ScoreBoardView scoreBoardView;
    private MyFrame Mf;
    public ScoreBoardController(MyFrame Mf){
           this.Mf=Mf;
           scoreBoardModel=new ScoreBoardModel();
           scoreBoardView=new ScoreBoardView(Mf, scoreBoardModel);
    }
    public ScoreBoardModel getScoreBoardModel() {
        return scoreBoardModel;
    }
    
}
