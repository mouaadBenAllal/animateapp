package com.example.administrator.androidanimation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class MainAnimate extends AppCompatActivity {
    ImageView meditateImg;
    ImageView avatarImg;
    boolean isMeditate;
    boolean isFade;
    boolean isTranslate;
    boolean isRotate;
    long duurAnimatie;
    SeekBar seekBar;
    RadioButton fadeButton;
    RadioButton translateButton;
    RadioButton rotateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_animate);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        meditateImg = (ImageView) findViewById(R.id.meditateImg);
        avatarImg= (ImageView) findViewById(R.id.avatarImg);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                duurAnimatie = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        fadeButton = (RadioButton) findViewById(R.id.fadeRadioButton);
        fadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFade = true;
                isTranslate = false;
                isRotate = false;

                if (isMeditate){

                    meditateImg.setAlpha(0f);
                    meditateImg.setTranslationX(0f);
                    meditateImg.setScaleX(1f);
                    meditateImg.setScaleY(1f);
                }
                else {
                    avatarImg.setAlpha(0f);
                    avatarImg.setTranslationX(0f);
                    avatarImg.setScaleX(1f);
                    avatarImg.setScaleY(1f);

                }
            }

        });

        translateButton = (RadioButton) findViewById(R.id.translateRadioButton);
        translateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFade = false;
                isTranslate = true;
                isRotate = false;

                if (isMeditate){

                    meditateImg.setAlpha(1f);
                    meditateImg.setTranslationX(-1000f);
                    meditateImg.setScaleX(1f);
                    meditateImg.setScaleY(1f);
                }
                else {
                    avatarImg.setAlpha(1f);
                    avatarImg.setTranslationX(1000f);
                    avatarImg.setScaleX(1f);
                    avatarImg.setScaleY(1f);

                }

        }
        });

        rotateButton = (RadioButton) findViewById(R.id.rotateRadioButton);
        rotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFade = false;
                isTranslate = false;
                isRotate = true;

                if (isMeditate){

                    meditateImg.setAlpha(1f);
                    meditateImg.setTranslationX(0f);
                    meditateImg.setScaleX(0f);
                    meditateImg.setScaleY(0f);
                }
                else {
                    avatarImg.setAlpha(1f);
                    avatarImg.setTranslationX(0f);
                    avatarImg.setScaleX(0f);
                    avatarImg.setScaleY(0f);

                }

            }
        });

        isFade = true;
        duurAnimatie = 2000l;
        seekBar.setProgress((int)duurAnimatie);
        isMeditate = true;
        fadeButton.setChecked(true);
        meditateImg.setAlpha(0f);
    }

    public void animate (View view) {
        if (isFade){
            fade();
        }
       else if (isTranslate) {
            rotate();
        }
        else {
            rotateAndScale();
        }
        isMeditate =! isMeditate;
    }

        private void fade() {
            if (isMeditate) {
                meditateImg.animate()
                        .alpha(0f)
                        .setDuration(duurAnimatie);
                avatarImg.animate()
                        .alpha(1f)
                        .setDuration(duurAnimatie);
            }
            else {
                meditateImg.animate()
                        .alpha(1f)
                        .setDuration(duurAnimatie);
                avatarImg.animate()
                        .alpha(0f)
                        .setDuration(duurAnimatie);
            }

        }



    private void rotate () {
        if  (isMeditate) {
            meditateImg.animate()
                    .translationX(1000l)
                    .setDuration(duurAnimatie);
            avatarImg.animate()
                    .translationX(0f)
                    .setDuration(duurAnimatie);
        }
        else {
            meditateImg.animate()
                    .translationX(0f)
                    .setDuration(duurAnimatie);
            avatarImg.animate()
                    .translationX(-1000f)
                    .setDuration(duurAnimatie);
        }

    }

    private void rotateAndScale(){
        if (isMeditate) {
            meditateImg.animate()
                    .rotation(720f)
                    .scaleX(0f)
                    .scaleY(0f)
                    .setDuration(duurAnimatie);
            avatarImg.animate()
                    .rotation(-720f)
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(duurAnimatie);

        }
        else{
            meditateImg.animate()
                    .rotation(-720f)
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(duurAnimatie);
            avatarImg.animate()
                    .rotation(-720f)
                    .scaleX(0f)
                    .scaleY(0f)
                    .setDuration(duurAnimatie);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_animate, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
