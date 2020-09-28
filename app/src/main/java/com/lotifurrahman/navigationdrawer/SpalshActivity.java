package com.lotifurrahman.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class SpalshActivity extends AppCompatActivity {
    private Animation top_anim, bottom_anim;
    ImageView imageView;
    TextView textView;

    Timer timer = new Timer();
    RotateAnimation rotate;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_spalsh);

        //animation
        top_anim = AnimationUtils.loadAnimation(this, R.anim.tom_anim);
        bottom_anim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        rotate = new RotateAnimation(1500, 500, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(2000);
        rotate.setInterpolator(new LinearInterpolator());

        imageView = findViewById(R.id.imageView2);
        textView = findViewById(R.id.textvew_id);
        textView.setAnimation(bottom_anim);

        imageView.startAnimation(rotate);

        timer.schedule(new Roll(), 1000);
        handler = new Handler(callback);
    }

    class Roll extends TimerTask {
        public void run() {
            handler.sendEmptyMessage(0);
        }
    }

    Handler.Callback callback = new Handler.Callback() {
        public boolean handleMessage(Message msg) {

            return true;
        }
    };
}