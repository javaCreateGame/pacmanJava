package Controller.SoundController;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import Model.SoundModel.SoundEffectModel;

public class SoundEffectController {
    SoundEffectModel soundEffectModel;

    public SoundEffectController() {
        soundEffectModel = new SoundEffectModel();
    }

    // chọn sound để phát
    public void setFile(int i) {
        try {
            //Dòng này lấy một đối tượng AudioInputStream cho hiệu ứng âm thanh được chỉ định bởi chỉ mục i.
            AudioInputStream audio = AudioSystem.getAudioInputStream(soundEffectModel.getSoundURL()[i]);
            soundEffectModel.setClip(AudioSystem.getClip());
            //Phương thức tĩnh này của lớp AudioSystem cố gắng tạo một đối tượng Clip mới, được sử dụng để phát và thao tác dữ liệu âm thanh.
            // Phương thức này của đối tượng Clip mở clip và chuẩn bị nó để phát lại bằng cách sử dụng dữ liệu âm thanh được cung cấp từ AudioInputStream.
            soundEffectModel.getClip().open(audio);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
//Hàm bắt đầu phát âm thanh
    public void start() {
        soundEffectModel.getClip().start();
    }
//Hàm đóng âm thanh
    public void close() {
        soundEffectModel.getClip().close();
    }
//dừng
    public void stop() {
        soundEffectModel.getClip().stop();

    }
//cho nhạc phát lại k
    public void loop() {
        soundEffectModel.getClip().loop(Clip.LOOP_CONTINUOUSLY);
    }
}
