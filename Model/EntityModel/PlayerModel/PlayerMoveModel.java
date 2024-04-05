package Model.EntityModel.PlayerModel;

public class PlayerMoveModel {
    private boolean playerUp = false, playerDown = false, playerLeft = false, playerRight = false;

    public boolean isPlayerUp() {
        return playerUp;
    }

    public void setPlayerUp(boolean playerUp) {
        this.playerUp = playerUp;
    }

    public boolean isPlayerDown() {
        return playerDown;
    }

    public void setPlayerDown(boolean playerDown) {
        this.playerDown = playerDown;
    }

    public boolean isPlayerLeft() {
        return playerLeft;
    }

    public void setPlayerLeft(boolean playerLeft) {
        this.playerLeft = playerLeft;
    }

    public boolean isPlayerRight() {
        return playerRight;
    }

    public void setPlayerRight(boolean playerRight) {
        this.playerRight = playerRight;
    }

}
