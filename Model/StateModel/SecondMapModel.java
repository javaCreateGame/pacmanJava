package Model.StateModel;



import javax.swing.*;
public class SecondMapModel extends MapModel {
    private ImageIcon newImageIcon;
    private ImageIcon newImageIconHeart;
    private int heartXLocation = 556, heartYLocation = 305;
    private JPanel secondMapPanel;
    private JPanel childSecondMapPanel;
    private boolean addHeart = true;
    private boolean removeHeart = false;
    private JLabel heart;
    private JLabel mapLabel;
    private Timer timer;
    private int x[] = new int[getN()];
    private int y[] = new int[getN()];
   
	
    public SecondMapModel() {
       
        secondMapPanel = new JPanel();
        childSecondMapPanel = new JPanel();
        heart = new JLabel();
        mapLabel = new JLabel("LỚP 11");
        timer = new Timer(1000, null);
    }

    //getter and setter
    public ImageIcon getNewImageIcon() {
		return newImageIcon;
	}

    public void setNewImageIcon(ImageIcon newImageIcon) {
        this.newImageIcon = newImageIcon;
    }

	public ImageIcon getNewImageIconHeart() {
		return newImageIconHeart;
	}

    public void setNewImageIconHeart(ImageIcon newImageIconHeart) {
        this.newImageIconHeart = newImageIconHeart;
    }

	public int getHeartXLocation() {
		return heartXLocation;
	}

	public int getHeartYLocation() {
		return heartYLocation;
	}

	public JPanel getSecondMapPanel() {
		return secondMapPanel;
	}

	public JPanel getChildSecondMapPanel() {
		return childSecondMapPanel;
	}

	public boolean isAddHeart() {
		return addHeart;
	}

	public void setAddHeart(boolean addHeart) {
		this.addHeart = addHeart;
	}

	public boolean isRemoveHeart() {
		return removeHeart;
	}

	public void setRemoveHeart(boolean removeHeart) {
		this.removeHeart = removeHeart;
	}

	public JLabel getHeart() {
		return heart;
	}

	public int[] getX() {
		return x;
	}

	public int[] getY() {
		return y;
	}

    public JLabel getMapLabel2(){
        return mapLabel;
    }

    public Timer getTimer2(){
        return timer;
    }
}
