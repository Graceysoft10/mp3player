package africa.semicolon.mp3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static africa.semicolon.mp3.MusicState.*;
import static org.junit.jupiter.api.Assertions.*;

public class Mp3Test {
 Mp3Player myMp3Player;

   @BeforeEach
    void startEachTestWith(){
       myMp3Player= new Mp3Player();
    }
    @Test
    void mp3Player_CanBeCreated(){
        Mp3Player myMp3player = new Mp3Player();
        assertNotNull(myMp3player);
    }



    @Test
    void mp3Player_turnsOn_whenFlipPowerButtonIsPressed_onOffState(){
        //given
        boolean isOff = !myMp3Player.isOn();
        assertTrue(isOff);
        //when
        myMp3Player.flipPowerButton();
        //assert
        assertTrue(myMp3Player.isOn());
    }
    @Test
    void mp3Player_turnsOn_whenFlipPowerButtonIsPressed_onOnState(){
        //given
        myMp3Player.flipPowerButton();
        boolean isOn = myMp3Player.isOn();
        assertTrue(isOn);
        //when
        myMp3Player.flipPowerButton();
        //assert
        assertFalse(myMp3Player.isOn());
    }
    @Test
    void mp3Player_canDownloadWhenMusic(){
        //given
        myMp3Player.flipPowerButton();
        assertTrue(myMp3Player.isOn());
        Music music = new Music();
        //when
        myMp3Player.download(music);
        assertEquals(1,myMp3Player.getTotalNumberOfMusic());
        //given
        Music secondMusic = new Music();
        myMp3Player.download(secondMusic);
        assertEquals(2, myMp3Player.getTotalNumberOfMusic());


    }
    @Test
    void mp3Player_cantDownloadWhenMusic_whenIsOff(){
    //given
        myMp3Player.flipPowerButton();
    assertTrue(myMp3Player.isOn());
    Music music = new Music();
    assertNotNull(music);
    //when
        myMp3Player.download(music);
    assertEquals(1,myMp3Player.getTotalNumberOfMusic());
    //given
    Music secondMusic = new Music();
        myMp3Player.download(secondMusic);
    assertEquals(2, myMp3Player.getTotalNumberOfMusic());


}
    @Test
    void mp3Player_canDeleteDownloadedMusic(){
       myMp3Player.flipPowerButton();
        assertTrue(myMp3Player.isOn());

        Music music = new Music();
        Music secondMusic = new Music();
        myMp3Player.download(music);
        myMp3Player.download(secondMusic);
        assertEquals(2,myMp3Player.getTotalNumberOfMusic());
       //when
        myMp3Player.delete(music);
        //assert
        assertEquals(1,myMp3Player.getTotalNumberOfMusic());

   }
   @Test
    void cant_deleteWhenMusicIsEmpty(){
//given
       myMp3Player.flipPowerButton();
       assertTrue(myMp3Player.isOn());
       Music music = new Music();
       assertNotNull(music);
       //when
       myMp3Player.download(music);
       assertEquals(1,myMp3Player.getTotalNumberOfMusic());
       //given
       Music secondMusic = new Music();
       assertEquals(1, myMp3Player.getTotalNumberOfMusic());


   }
   @Test
    void cant_DeleteWhenMusicIsOff(){
       myMp3Player.flipPowerButton();
       assertTrue(myMp3Player.isOn());
       Music music = new Music();
       assertNotNull(music);
       //when
       myMp3Player.download(music);
       assertEquals(1,myMp3Player.getTotalNumberOfMusic());
       myMp3Player.flipPowerButton();
       //given
       myMp3Player.delete(music);
       assertEquals(1,myMp3Player.getTotalNumberOfMusic());

   }
   @Test
    void mp3Player_cannotDownloadSameSongTwice(){
       myMp3Player.flipPowerButton();
       assertTrue(myMp3Player.isOn());
       Music music = new Music();
       //when
       myMp3Player.download(music);
       assertEquals(1,myMp3Player.getTotalNumberOfMusic());

       myMp3Player.download(music);
       assertEquals(1,myMp3Player.getTotalNumberOfMusic());
   }
@Test
    void mp3Player_canplayMusic(){
    myMp3Player.flipPowerButton();
    assertTrue(myMp3Player.isOn());
    Music oceans = new Music();
    myMp3Player.download(oceans);
    assertEquals(1,myMp3Player.getTotalNumberOfMusic());

    myMp3Player.play(oceans);
    assertEquals(PLAYING,myMp3Player.getCurrentMusicState());
    assertEquals(oceans,myMp3Player.getCurrentlyPlayingMusic());
}
@Test
    void mp3Player_canPauseMusic() {
    myMp3Player.flipPowerButton();
    assertTrue(myMp3Player.isOn());
    Music oceans = new Music();
    myMp3Player.download(oceans);
    assertEquals(1, myMp3Player.getTotalNumberOfMusic());
    myMp3Player.play(oceans);

    myMp3Player.pause(oceans);
    assertEquals(PAUSED, myMp3Player.getCurrentMusicState());
    assertEquals(oceans, myMp3Player.getCurrentlyPlayingMusic());
    }
    @Test
    void mp3Player_CanStopMusic(){
        myMp3Player.flipPowerButton();
        assertTrue(myMp3Player.isOn());
        Music oceans = new Music();
        myMp3Player.download(oceans);
        assertEquals(1, myMp3Player.getTotalNumberOfMusic());
        myMp3Player.play(oceans);

        myMp3Player.stop();
        assertEquals(STOPPED,myMp3Player.getCurrentMusicState() );

    }
    @Test
    void mp3player_CanRepeatSong(){
        myMp3Player.flipPowerButton();
        assertTrue(myMp3Player.isOn());
        Music oceans = new Music();
        myMp3Player.download(oceans);
        assertEquals(1, myMp3Player.getTotalNumberOfMusic());
        myMp3Player.play(oceans);

        assertEquals(PLAYING,myMp3Player.getCurrentMusicState());
        assertEquals(oceans,myMp3Player.getCurrentlyPlayingMusic());

        myMp3Player.stop();
        assertEquals(STOPPED,myMp3Player.getCurrentMusicState() );
        myMp3Player.repeat();
        assertEquals(REPEAT,myMp3Player.getCurrentMusicState());
    }
    @Test
     void mp3Player_canIncreaseVolume(){
        myMp3Player.flipPowerButton();
        assertTrue(myMp3Player.isOn());
        Music oceans = new Music();
        myMp3Player.download(oceans);
        assertEquals(1, myMp3Player.getTotalNumberOfMusic());
        myMp3Player.play(oceans);

        assertEquals(PLAYING,myMp3Player.getCurrentMusicState());
        assertEquals(oceans,myMp3Player.getCurrentlyPlayingMusic());

        myMp3Player.stop();
        assertEquals(STOPPED,myMp3Player.getCurrentMusicState() );
        myMp3Player.repeat();
        assertEquals(REPEAT,myMp3Player.getCurrentMusicState());

        myMp3Player.getVolume();
        assertEquals(true, myMp3Player.getVolume());
    }
@Test
    void mp3Player_canDecreaseVolume(){
    myMp3Player.flipPowerButton();
    assertTrue(myMp3Player.isOn());
    Music oceans = new Music();
    myMp3Player.download(oceans);
    assertEquals(1, myMp3Player.getTotalNumberOfMusic());
    myMp3Player.play(oceans);

    assertEquals(PLAYING,myMp3Player.getCurrentMusicState());
    assertEquals(oceans,myMp3Player.getCurrentlyPlayingMusic());

    myMp3Player.stop();
    assertEquals(STOPPED,myMp3Player.getCurrentMusicState() );
    myMp3Player.repeat();
    assertEquals(REPEAT,myMp3Player.getCurrentMusicState());

    myMp3Player.getVolume();
    assertEquals(true, myMp3Player.getVolume());

    myMp3Player.getVolume();
    assertEquals(true, myMp3Player.getVolume());

    }
    @Test
    void mp3Player_CanSkipMusic(){
        myMp3Player.flipPowerButton();
        assertTrue(myMp3Player.isOn());
        Music oceans = new Music();
        myMp3Player.download(oceans);
        assertEquals(1, myMp3Player.getTotalNumberOfMusic());
        myMp3Player.play(oceans);

        assertEquals(PLAYING,myMp3Player.getCurrentMusicState());
        assertEquals(oceans,myMp3Player.getCurrentlyPlayingMusic());

        myMp3Player.stop();
        assertEquals(STOPPED,myMp3Player.getCurrentMusicState() );
        myMp3Player.repeat();
        assertEquals(REPEAT,myMp3Player.getCurrentMusicState());

        myMp3Player.getVolume();
        assertEquals(true, myMp3Player.getVolume());

        myMp3Player.getVolume();
        assertEquals(true, myMp3Player.getVolume());

        myMp3Player.skip();
        assertEquals(SKIPPED,myMp3Player.getCurrentMusicState());
    }
}



