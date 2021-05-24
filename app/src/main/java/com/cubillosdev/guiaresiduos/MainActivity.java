package com.cubillosdev.guiaresiduos;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Animatoo.animateFade(this);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, MenuPrincipalActivity.class);
                startActivity(i);
                finish();
            }
        };
        Timer time = new Timer();
        time.schedule(task, 2000);

        Animatoo.animateSlideUp(this);
    }
}