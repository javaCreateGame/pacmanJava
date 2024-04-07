package Controller.StateController;

import Model.GameModel.GameModel;
import Model.StateModel.ScoreBoardModel;
import View.StateView.ScoreBoardView;

public class ScoreBoardController {
    private ScoreBoardModel scoreBoardModel;
    private ScoreBoardView scoreBoardView;
    private GameModel Mf;

    public ScoreBoardController(GameModel Mf) {
        this.Mf = Mf;
        scoreBoardModel = new ScoreBoardModel();
        scoreBoardView = new ScoreBoardView(Mf, scoreBoardModel);
    }

    public ScoreBoardModel getScoreBoardModel() {
        return scoreBoardModel;
    }

    public ScoreBoardView getScoreBoardView() {
        return scoreBoardView;
    }

}
