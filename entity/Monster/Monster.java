package entity.Monster;
import java.awt.Graphics2D;

import java.awt.image.BufferedImage;
import java.sql.Array;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Arrays;

import javax.imageio.ImageIO;

import main.MyFrame;
public class Monster   {
    public final int defaultSize=20;
    public  int MonsterWidth , MonsterHeight ;
    //Tạo biến lưu trữ tọa độ của nhân vật
    public int xjoystick, yJoystick,xDice,yDice,xSyrinnge,ySyrinnge;
    public int xVelocity[]=new int[3];
    public int yVelocity[]=new int[3];
    //Tạo biến lưu trữ ảnh chuyển động của nhân vâth
    public BufferedImage dice,joystick,syrinnge; 
    MyFrame Mf;
    public Monster(MyFrame Mf){
        this.Mf=Mf;
        setDefaultMonster();
        getMonsterImage();
    }
    public void getMonsterImage() {
        try {
            //lấy ảnh chuyển động ra từ folder picture
            dice= ImageIO.read(getClass().getResourceAsStream("/picture/diceMonster.png"));
            joystick= ImageIO.read(getClass().getResourceAsStream("/picture/joystickMonster.png"));
            syrinnge = ImageIO.read(getClass().getResourceAsStream("/picture/syringeMonster.png"));
                   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setDefaultMonster(){
       Arrays.fill(xVelocity,4);
       Arrays.fill(yVelocity,4);
        xDice=50;
        xjoystick=70;
        xSyrinnge=90;
        yDice=yJoystick=ySyrinnge=80;
        MonsterHeight=MonsterWidth=defaultSize;
    }
    public void running(){
    if(Mf.countFoot>=300){
        if (xDice>=Mf.jframeWidth-MonsterWidth ||xDice<0) {
            xVelocity[0]=xVelocity[0]*(-1);
         }
         xDice+=xVelocity[0];
          if (yDice>=Mf.jframeHeight-MonsterHeight ||yDice<0) {
            yVelocity[0]=yVelocity[0]*(-1);
         }
         yDice+=yVelocity[0];
    }
    }     
    public void draw(Graphics2D g2){
        g2.drawImage(dice, xDice, yDice,MonsterWidth,MonsterHeight ,null);
        g2.drawImage(joystick, xjoystick, yJoystick,MonsterWidth,MonsterHeight ,null);
        g2.drawImage(syrinnge, xSyrinnge, ySyrinnge,MonsterWidth,MonsterHeight ,null);
    }
}
