package Controller.EndingController;

import Model.EndingModel.ButtonEndingModel;
import View.EndingView.ButtonEndingView;

public class ButtonEndingControllor {
    private ButtonEndingModel buttonEndingModel;
    private ButtonEndingView buttonEndingView;
    public ButtonEndingControllor(){
       buttonEndingModel=new ButtonEndingModel();
       buttonEndingView=new ButtonEndingView(buttonEndingModel);
    }
    public ButtonEndingModel getButtonEndingModel() {
        return buttonEndingModel;
    }
    public ButtonEndingView getButtonEndingView() {
        return buttonEndingView;
    }
    
}
