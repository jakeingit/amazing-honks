package com.example.amazinghonks;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.Toast;

import com.jakegosskuehn.amazinghonks.R;

public class MainActivity extends Activity implements OnTouchListener{
    
 
    
    private SoundPool soundPool;
    private int soundID2;
    boolean loaded = false;
    boolean songloaded = false;
    int honkcount = 0;
    
    private int _honkb;
    private int _honkc;
    private int _honkd;
    private int _honke;
    private int _honkf;
 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
                  
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        setContentView(R.layout.activity_main);
        View view = findViewById(R.id.toptext);
        view.setOnTouchListener(this);
 //uncomment these lines below so it will HONK with text... nut will not HONK with noise.. fuck
        // addListenerOnButton();
        // Set the hardware buttons to control the music
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        // Load the sound
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,
                    int status) {
                loaded = true;
//                Toast.makeText(MainActivity.this,
//                        "FULLY LOADED TO HONK!!!", Toast.LENGTH_SHORT).show();
            }
        });
        
        _honkb = soundPool.load(this, R.raw.bikehorn_b, 1);
        _honkc = soundPool.load(this, R.raw.bikehorn_c, 1);
        _honkd = soundPool.load(this, R.raw.bikehorn_d, 1);
        _honke = soundPool.load(this, R.raw.bikehorn_e, 1);
        _honkf = soundPool.load(this, R.raw.bikehorn_f, 1);
        soundID2 = soundPool.load(this, R.raw.clown, 1);
        
        
        Toast.makeText(MainActivity.this,
                "HONK!!!", Toast.LENGTH_SHORT).show();
    }
    
    public void amazinghonks(View view)
    {
//        MediaPlayer mp = MediaPlayer.create(this, R.raw.bikehorn);
//        mp.start();
        
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        float actualVolume = (float) audioManager
                .getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = (float) audioManager
                .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float volume = actualVolume / maxVolume;
        
        int randomizationnumber = random1to5();
        
        boolean uno = (loaded && (randomizationnumber == 1));
        boolean dos = (loaded && (randomizationnumber == 2));
        boolean tres = (loaded && (randomizationnumber == 3));
        boolean quatro = (loaded && (randomizationnumber == 4));
        boolean cinco = (loaded && (randomizationnumber == 5));
        
        if(uno)
        {
            honkcount++;
            soundPool.play(_honkb, volume, volume, 1, 0, 1f);
            
//          MediaPlayer mp = MediaPlayer.create(this, R.raw.bikehorn_b);
//          mp.start();
            Log.e("Test", "Played sound1");
        }
        if(dos)
        {
            honkcount++;
            soundPool.play(_honkc, volume, volume, 1, 0, 1f);
            Log.e("Test", "Played sound2");
        }
        if(tres)
        {
            honkcount++;
            soundPool.play(_honkd, volume, volume, 1, 0, 1f);
            Log.e("Test", "Played sound3");
        }
        if(quatro)
        {
            honkcount++;
            soundPool.play(_honke, volume, volume, 1, 0, 1f);
            Log.e("Test", "Played sound4");
        }
        if(cinco)
        {
            honkcount++;
            soundPool.play(_honkf, volume, volume, 1, 0, 1f);
            Log.e("Test", "Played sound5");
        }
        
            
            if ((honkcount > 50) && cinco) {
                honkcount = -200;
                
                Toast.makeText(MainActivity.this,
                "You have activated AMAZING HONKS!!!", Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this,
                "There is no silencing of the honks", Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this,
                        "The honks... They will never end.", Toast.LENGTH_LONG).show();
                
//                soundPool.play(soundID2, volume, volume, 1, 1, 1f);
              MediaPlayer mp = MediaPlayer.create(this, R.raw.clown);
              mp.start();
                Log.e("Test", "Played amazinghonks");
            }
            
    }
 //AWESOME RANDOMIZATION CODE
    double phi = 1.6180339887498948482045868343656381177203091798057628621354486227052604628189024497072072041893911374847540880753868917521266338622235369317931800607667263544333890865959395829056383226613199282902678806752087668925017116962070322210432162695486262963136144381497587012203408058879544547492461856953648644492410443207713449470495658467885098743394422125448770664780915884607499887124007652170575179788341662562494075890697040002812104276217711177780531531714101;
    String phistring = String.valueOf(phi);
    int currentadjustable = 1;
    
    public int phiRandom()
    {
        int currentspittable = 0;
        double currentWodentime = (Time.SECOND) + (Time.MINUTE) + (Time.HOUR) + Time.WEDNESDAY; // should take current time
        int currenttimevalue = (int)currentWodentime%10;
        
        
        String startedphistring = phistring;
        char currentdigit = startedphistring.charAt(currentadjustable);
        currentadjustable++;
        
        currentspittable = ((currenttimevalue) * ((int)currentdigit) )%10;
        
        
        
        return currentspittable;
    }
    
    
    
    
    
    
    //
    
    public int random1to5() //spits out a number from 1 to 5... more 333s than 222,444 and 1,5s
    {
        int number = 3;
        double randomednumber = Math.random()*10; //range from 0  to 10?
        int rounded = (int)randomednumber; // will give a flat number
        if(rounded <= 0)
            number = 1;
            if(rounded == 1)
                number = 2;
                if(rounded == 2)
                    number = 2;
                    if(rounded == 3)
                        number = 3;
                        if(rounded == 4)
                            number = 3;
                            if(rounded == 5)
                                number = 3;
                                if(rounded == 6)
                                    number = 3;
                                    if(rounded == 7)
                                        number = 4;
                                        if(rounded == 8)
                                            number = 4;
                                            if(rounded == 9)
                                                number = 5;
                                                if(rounded >= 10)
                                                    number = 5;
        
        
        
        
        return number;
    }
    
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        
        
        
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            // Getting the user sound settings
            AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
            float actualVolume = (float) audioManager
                    .getStreamVolume(AudioManager.STREAM_MUSIC);
            float maxVolume = (float) audioManager
                    .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
            float volume = actualVolume / maxVolume;
            // Is the sound loaded already?
            int randomizationnumber = random1to5();
            
            boolean uno = (loaded && (randomizationnumber == 1));
            boolean dos = (loaded && (randomizationnumber == 2));
            boolean tres = (loaded && (randomizationnumber == 3));
            boolean quatro = (loaded && (randomizationnumber == 4));
            boolean cinco = (loaded && (randomizationnumber == 5));
            
            if(uno)
            {
                honkcount++;
                soundPool.play(_honkb, volume, volume, 1, 0, 1f);
                Log.e("Test", "Played sound");
                Toast.makeText(MainActivity.this,
                        "H-H-H-HONK!!", Toast.LENGTH_SHORT).show();
            }
            if(dos)
            {
                honkcount++;
                soundPool.play(_honkc, volume, volume, 1, 0, 1f);
                Log.e("Test", "Played sound");
                Toast.makeText(MainActivity.this,
                        "Amazing Honks!", Toast.LENGTH_SHORT).show();
            }
            if(tres)
            {
                honkcount++;
                soundPool.play(_honkd, volume, volume, 1, 0, 1f);
                Log.e("Test", "Played sound");
                Toast.makeText(MainActivity.this,
                        "Traitous Honks", Toast.LENGTH_SHORT).show();
            }
            if(quatro)
            {
                honkcount++;
                soundPool.play(_honke, volume, volume, 1, 0, 1f);
                Log.e("Test", "Played sound");
                Toast.makeText(MainActivity.this,
                        "Stellar Honks!", Toast.LENGTH_SHORT).show();
            }
            if(cinco)
            {
                honkcount++;
                soundPool.play(_honkf, volume, volume, 1, 0, 1f);
                Log.e("Test", "Played sound");
                Toast.makeText(MainActivity.this,
                        "Robust HONKS!!!", Toast.LENGTH_SHORT).show();
            }
            
                
            //OnTouch on Textview doesnt add to play the song
            
//                if ((honkcount > 5) && cinco) {
//                    honkcount = 0;
//                    //ZZZ Touch Sound on TextView
//                    Toast.makeText(MainActivity.this,
//                    "You have activated AMAZING HONKS!!!", Toast.LENGTH_LONG).show();
//                    
//                    soundPool.play(soundID2, volume, volume, 1, 0, 1f);
//                    Log.e("Test", "Played sound MUSICZ");
//                }

                        
                        
            
        }
        return false;
    }

    
    
    
//
//    ImageButton imageButton;
//    
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
// 
//        addListenerOnButton();
// 
//    }
// 
//    public void addListenerOnButton() {
// 
//        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton1);
// 
//        imageButton.setOnClickListener(new OnClickListener() {
// 
//            @Override
//            public void onClick(View arg0) {
//                double randomnumber = Math.random()*101;
//           //WILL HAVE THREE KINDS OF HONKS!     
//                if(randomnumber < 33)
//                {
//               Toast.makeText(MainActivity.this,
//                "HONK!", Toast.LENGTH_SHORT).show();
//
//                }
//                if((randomnumber < 66)&&(randomnumber > 33))
//                {
//               Toast.makeText(MainActivity.this,
//                "HONK!!!", Toast.LENGTH_SHORT).show();
//                }
//                if((randomnumber < 101)&&(randomnumber > 66))
//                {
//               Toast.makeText(MainActivity.this,
//                "HONK!!!!!!!!!!!!!!!!!!!!", Toast.LENGTH_SHORT).show();
//                }
//                
// 
//            }
// 
//        });
// 
//    }
// 
}