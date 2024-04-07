package Model.SoundModel;

import java.net.URL;

import javax.sound.sampled.Clip;

public class SoundEffectModel {
    // biến lưu trữ đường dẫn của các sound
    URL soundURL[] = new URL[30];
    Clip clip;

    public SoundEffectModel() {
        // Lấy ra các sound
        soundURL[0] = getClass().getResource("SoundEffectIntro.wav");
        soundURL[1] = getClass().getResource("SoundEffectKey.wav");
        soundURL[2] = getClass().getResource("SoundEffectTrailer.wav");
        soundURL[3] = getClass().getResource("SoundEffectMap.wav");
        soundURL[4] = getClass().getResource("SoundEffectEatObject.wav");
        soundURL[5] = getClass().getResource("SoundEffectPlayerTransform.wav");
        soundURL[6] = getClass().getResource("SoundEffectBadEnding.wav");
        soundURL[7] = getClass().getResource("SoundEffectHappyEnding.wav");
    }

    // getter and setter
    public URL[] getSoundURL() {
        return soundURL;
    }

    public void setSoundURL(URL[] soundURL) {
        this.soundURL = soundURL;
    }

    public Clip getClip() {
        return clip;
    }

    public void setClip(Clip clip) {
        this.clip = clip;
    }
}
