package Sound;


import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundEffect {
  //biến lưu trữ đường dẫn của các sound
    URL soundURL[]=new URL[30];
   Clip clip;
    
    public SoundEffect(){
      //Lấy ra các sound
     soundURL[0]=getClass().getResource("rumo-ao-sol-13162.wav");

    }
       //Sử dụng sound
    public void setFile(int i){
      try {
        
        AudioInputStream audio=AudioSystem.getAudioInputStream(soundURL[i]);
        clip=AudioSystem.getClip();
        clip.open(audio);
        
      } catch (Exception e) {
        System.out.println(e);
      }
    }
    public void start(){
      clip.start();
    }
    public void close(){
        clip.close();
    }
    public void stop(){
      clip.stop();
     
    }
    public void loop(){
    clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

}
