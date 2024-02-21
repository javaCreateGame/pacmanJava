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
        Timer timer=new Timer();
    TimerTask timerTask=new TimerTask() {
           
        @Override
        public void run() {
            int[] newDicePosition = runner(xDice, yDice, xVelocity[0], yVelocity[0]);
            xDice = newDicePosition[0];
            yDice = newDicePosition[1];
            
            if (Mf.countFoot >= 1000) {
                int[] newJoystickPosition = runner(xjoystick, yJoystick, xVelocity[1], yVelocity[1]);
                xjoystick = newJoystickPosition[0];
                yJoystick = newJoystickPosition[1];
            }
            
            if (Mf.countFoot >= 2000) {
                int[] newSyrinngePosition = runner(xSyrinnge, ySyrinnge, xVelocity[2], yVelocity[2]);
                xSyrinnge = newSyrinngePosition[0];
                ySyrinnge = newSyrinngePosition[1];
            }
        }
    };
    timer.schedule(timerTask, 3000);
}

private int[] runner(int xMonster, int yMonster, int xVelocity, int yVelocity) {
    int[] newPosition = new int[2]; // Mảng chứa x và y mới
    int newVelocityX = xVelocity; // Biến trung gian để thay đổi giá trị xVelocity
    int newVelocityY = yVelocity;
    if (xMonster >= Mf.jframeWidth - MonsterWidth || xMonster < 0) {
        newVelocityX = -xVelocity; // Đảo ngược hướng xVelocity
        // Đảm bảo rằng xMonster không vượt quá giới hạn
        xMonster = Math.min(Mf.jframeWidth - MonsterWidth, xMonster);
    }
    xMonster = xMonster + newVelocityX;

    if (yMonster >= Mf.jframeWidth - MonsterWidth || yMonster < 0) {
        newVelocityY = -yVelocity; // Đảo ngược hướng xVelocity
        // Đảm bảo rằng xMonster không vượt quá giới hạn
        xMonster = Math.min(Mf.jframeWidth - MonsterWidth, xMonster);
    }
    yMonster = yMonster +  newVelocityY;
    
    // Cập nhật giá trị mới của x và y
    newPosition[0] = xMonster;
    newPosition[1] = yMonster;

    return newPosition; // Trả về mảng chứa giá trị mới của x và y
}
    public void draw(Graphics2D g2){
        g2.drawImage(dice, xDice, yDice,MonsterWidth,MonsterHeight ,null);
        g2.drawImage(joystick, xjoystick, yJoystick,MonsterWidth,MonsterHeight ,null);
        g2.drawImage(syrinnge, xSyrinnge, ySyrinnge,MonsterWidth,MonsterHeight ,null);
    }
}
