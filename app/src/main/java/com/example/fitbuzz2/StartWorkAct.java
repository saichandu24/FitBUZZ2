package com.example.fitbuzz2;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class StartWorkAct extends AppCompatActivity {

        TextView intropage, subintropage, fitonetitle, fitonedesc, timerValue, btnexercise;
        View divpage, bgprogress;
        LinearLayout fitone;
        ImageView imgTimer;

        private static final long START_TIME_IN_MILLIS = 50000;
        private CountDownTimer countDownTimer;
        private boolean mTimerRunning;
        private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

        Animation btthree, bttfour, ttbone, ttbtwo, alphago;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_start_work);


            intropage = (TextView) findViewById(R.id.intropage);
            subintropage = (TextView) findViewById(R.id.subintropage);
            fitonetitle = (TextView) findViewById(R.id.fitonetitle);
            fitonedesc = (TextView) findViewById(R.id.fitonedesc);
            timerValue = (TextView) findViewById(R.id.timerValue);
            btnexercise = (TextView) findViewById(R.id.btnexercise);

            divpage = (View) findViewById(R.id.divpage);
            bgprogress = (View) findViewById(R.id.bgprogress);

            fitone = (LinearLayout) findViewById(R.id.fitone);

            imgTimer = (ImageView) findViewById(R.id.imgtimer);


            startTimer();
        }

        private void startTimer(){
            countDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis = millisUntilFinished;
                    updateCountDownText();
                }

                @Override
                public void onFinish() {
                    Toast.makeText(getApplicationContext(),"Done!", Toast.LENGTH_SHORT).show();
                }
            }.start();
            mTimerRunning = true;
        }

        private void updateCountDownText(){
            int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
            int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

            String timeLeft = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds) ;
            timerValue.setText(timeLeft);
    }
}
