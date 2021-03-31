package africa.semicolon.mp3;

import java.util.ArrayList;

import static africa.semicolon.mp3.MusicState.*;

public class Mp3Player {
private boolean isOn;
private ArrayList<Music> musicList = new ArrayList<>();
private Music currentlyPlayingMusic;
private MusicState currentMusicState;
private int volume = 5;
    private Music next;


    public boolean isOn() {
        return isOn;
    }

    public void flipPowerButton() {
         if(isOn) isOn= false;
         else{
             isOn = true;
         }
    }

    public void download(Music music) {
        if (isOn)
            if (!musicList.contains(music))
                musicList.add(music);

         if(!isOn)
             if(!musicList.contains(music))
               musicList.remove(music) ;
            }


    public int getTotalNumberOfMusic() {
        return musicList.size();

    }

    public void delete(Music music) {
        if(isOn)
        if (getTotalNumberOfMusic() >=1)
        musicList.remove(music);
    }

    public void play(Music music) {
        currentlyPlayingMusic = music;
        currentMusicState= PLAYING;
    }

    public MusicState getCurrentMusicState() {
        return currentMusicState;

    }
    public Music getCurrentlyPlayingMusic() {
        return currentlyPlayingMusic;
    }


    public void pause(Music oceans) {

        currentMusicState = PAUSED;
    }
public  void stop(){
        currentMusicState = STOPPED;

}
public void repeat(){
        currentMusicState= REPEAT;
    }

    public void increaseVolume(){
    if (isOn)
    if(volume >= 0 && volume < 100 )
        volume ++;
    }
    public void decreaseVolume(){
        if (isOn)
            if(volume <= 100 && volume > 0 )
                volume --;
    }
    public int getVolume(){
    return volume;
    }


    public void skip() {
        for (int i = 0; i < musicList.size(); i++) {
            if (currentlyPlayingMusic == musicList.get(i)) {
                currentlyPlayingMusic = musicList.get(i + 2);
                break;
            }
        }
    }

    public void next() {
        for (int i = 0; i < musicList.size() ; i++) {
            if(currentlyPlayingMusic == musicList.get(i)) {
                currentlyPlayingMusic = musicList.get(i+1);
                break;
            }

        }
    }

    public void previous() {
        for (int i = 0; i < musicList.size(); i++) {
            if(currentlyPlayingMusic == musicList.get(i)){
                currentlyPlayingMusic = musicList.get(i-1);
                break;
            }

        }
    }
}





