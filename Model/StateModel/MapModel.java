package Model.StateModel;

import javax.swing.JLabel;

public class MapModel {
    private JLabel obj[] = new JLabel[20];
    private int n = this.obj.length;
    private boolean addObj[] = new boolean[n];
    private boolean removeObj[] = new boolean[n];

    public JLabel[] getObj() {
        return obj;
    }

    public int getN() {
        return n;
    }

    public boolean[] getAddObj() {
        return addObj;
    }

    public void setAddObj(boolean addObj, int i) {
        this.addObj[i] = addObj;
    }

    public boolean[] getRemoveObj() {
        return removeObj;
    }

    public void setRemoveObj(boolean removeObj, int i) {
        this.removeObj[i] = removeObj;
    }
}
