package Controller.SoundController;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import Model.SoundModel.SoundEffectModel;
import View.SoundView.SoundEffectView;

public class SoundEffectController {
    SoundEffectModel soundEffectModel;
    SoundEffectView soundEffectView;

    public SoundEffectController() {
        soundEffectModel = new SoundEffectModel();
        soundEffectView = new SoundEffectView(soundEffectModel);
    }

    // Sử dụng sound
    public void setFile(int i) {
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(soundEffectModel.getSoundURL()[i]);
            soundEffectModel.setClip(AudioSystem.getClip());
            soundEffectModel.getClip().open(audio);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void start() {
        soundEffectModel.getClip().start();
    }

    public void close() {
        soundEffectModel.getClip().close();
    }

    public void stop() {
        soundEffectModel.getClip().stop();

    }

    public void loop() {
        soundEffectModel.getClip().loop(Clip.LOOP_CONTINUOUSLY);
    }
}
