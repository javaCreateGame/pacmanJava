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
            
           if (xDice <= 80 ) {
             xDice+=xVelocity[0];
           }
           else{
            yDice+=yVelocity[0];
            if (yDice >=90) {
                xVelocity[0]=1;
                if (xDice<=120) {
                    xDice+=xVelocity[0];
                }}}
        //         else {
        //             yDice+=yVelocity[0];
        //             if(yDice>=120){
        //                 xDice-=xVelocity[0];
        //                 if (xDice==80) {
        //                     yDice-=yVelocity[0];
                            
        //                 }
        //             }
        //         }
                
        //     }
        //    }
            
            
          
        
}

// private int[] runner(int xMonster, int yMonster, int xVelocity, int yVelocity) {
//     int[] newPosition = new int[2]; // Mảng chứa x và y mới
//     // Biến trung gian để thay đổi giá trị xVelocity
    
//     if (xMonster >= Mf.jframeWidth - MonsterWidth || xMonster < 0) {
//         xVelocity=xVelocity *-1;
//     }
//     xMonster = xMonster + xVelocity;

//     if (yMonster >= Mf.jframeWidth - MonsterWidth || yMonster < 0) {
//        yVelocity=yVelocity * -1;
//     }
//     yMonster = yMonster +  yVelocity;
    
//     // Cập nhật giá trị mới của x và y
//     newPosition[0] = xMonster;
//     newPosition[1] = yMonster;

//     return newPosition; // Trả về mảng chứa giá trị mới của x và y
// }
    public void draw(Graphics2D g2){
        g2.drawImage(dice, xDice, yDice,MonsterWidth,MonsterHeight ,null);
        g2.drawImage(joystick, xjoystick, yJoystick,MonsterWidth,MonsterHeight ,null);
        g2.drawImage(syrinnge, xSyrinnge, ySyrinnge,MonsterWidth,MonsterHeight ,null);
    }
}
