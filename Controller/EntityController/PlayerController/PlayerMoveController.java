package Controller.EntityController.PlayerController;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Model.EntityModel.PlayerModel.PlayerMoveModel;

public class PlayerMoveController implements KeyListener {
    private PlayerMoveModel playerMoveModel;

    public PlayerMoveController() {
        playerMoveModel = new PlayerMoveModel();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            playerMoveModel.setPlayerUp(true);
        }
        if (code == KeyEvent.VK_A) {
            playerMoveModel.setPlayerLeft(true);
        }
        if (code == KeyEvent.VK_S) {
            playerMoveModel.setPlayerDown(true);
        }
        if (code == KeyEvent.VK_D) {
            playerMoveModel.setPlayerRight(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            playerMoveModel.setPlayerUp(false);
        }
        if (code == KeyEvent.VK_A) {
            playerMoveModel.setPlayerLeft(false);
        }
        if (code == KeyEvent.VK_S) {
            playerMoveModel.setPlayerDown(false);
        }
        if (code == KeyEvent.VK_D) {
            playerMoveModel.setPlayerRight(false);
        }
    }

    public PlayerMoveModel getPlayerMoveModel() {
        return playerMoveModel;
    }

}
