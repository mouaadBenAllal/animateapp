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
    boolean fadeanimate = false;
    boolean translateanimate = false;
    boolean rotateanimate = false;
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

        avatarImg.animate().alpha(0f).setDuration(0l);

        fadeButton = (RadioButton) findViewById(R.id.fadeRadioButton);
        fadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fadeanimate = true;
                rotateanimate = false;
                translateanimate = false;

                if (isMeditate){
                    avatarImg.animate().alpha(0f);

                }
                else {
                    meditateImg.animate().alpha(1f);
                }
                avatarImg.animate().translationX(0f).setDuration(0l);
                meditateImg.animate().translationX(0f).setDuration(0l);
                avatarImg.animate().scaleX(1f).scaleY(1f).setDuration(1l);
                meditateImg.animate().scaleX(1f).scaleY(1f).setDuration(1l);



            }

        });

        translateButton = (RadioButton) findViewById(R.id.translateRadioButton);
        translateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                translateanimate = true;
                fadeanimate = false;
                rotateanimate = false;
                avatarImg.animate().alpha(1f);
                meditateImg.animate().alpha(1f);
                if (isMeditate){
                    avatarImg.animate().translationX(-1000f).alpha(1f).setDuration(0l);
                    avatarImg.animate().alpha(1f).scaleX(1f).scaleY(1f).setDuration(1l);

                }
                else {
                    meditateImg.animate().translationX(1000f).alpha(1f).setDuration(0l);
                    meditateImg.animate().alpha(1f).scaleX(1f).scaleY(1f).setDuration(1l);
                }

        }
        });

        rotateButton = (RadioButton) findViewById(R.id.rotateRadioButton);
        rotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avatarImg.animate().alpha(1f);
                meditateImg.animate().alpha(1f);
                rotateanimate = true;
                fadeanimate = false;
                translateanimate = false;

                if(isMeditate){
                    meditateImg.animate().translationX(0f).setDuration(0l);
                    meditateImg.animate().alpha(1f).scaleX(0f).scaleY(0f).setDuration(1l);
                }
                else{
                    avatarImg.animate().translationX(0f).setDuration(0l);
                    avatarImg.animate().alpha(1f).scaleX(0f).scaleY(0f).setDuration(1l);
                }

            }
        });
        isMeditate = true;
        duurAnimatie = 1500l;
        seekBar.setProgress((int)duurAnimatie);

        fadeButton.setChecked(true);
        translateButton.setChecked(false);
        rotateButton.setChecked(false);
    }

    public void animate (View view) {
        if (fadeanimate == true){
            fade();
        }
        if (translateanimate == true){
            rotate();
        }
        if (rotateanimate == true){
            rotateAndScale();
        }
    }

        private void fade() {
            if (isMeditate) {
                meditateImg.animate().alpha(0f).setDuration(duurAnimatie);
                avatarImg.animate().alpha(1f).setDuration(duurAnimatie);
                isMeditate=false;
            }
            else {
                meditateImg.animate().alpha(1f).setDuration(duurAnimatie);
                avatarImg.animate().alpha(0f).setDuration(duurAnimatie);
                isMeditate= true;
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
                    isMeditate = false;
        }
        else {
            meditateImg.animate()
                    .translationX(0l)
                    .setDuration(duurAnimatie)
                    .alpha(1f);
            avatarImg.animate()
                    .translationX(-1000f)
                    .setDuration(duurAnimatie);
                    isMeditate = true;
        }

    }

    private void rotateAndScale(){
        if (isMeditate) {
            meditateImg.animate()
                    .rotation(1080f)
                    .scaleX(0f)
                    .scaleY(0f)
                    .setDuration(duurAnimatie);
            avatarImg.animate()
                    .rotation(-1080f)
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(duurAnimatie);
                    isMeditate = false;
        }
        else{
            meditateImg.animate()
                    .rotation(-1080f)
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(duurAnimatie);
            avatarImg.animate()
                    .rotation(1080f)
                    .scaleX(0f)
                    .scaleY(0f)
                    .setDuration(duurAnimatie);
                    isMeditate = true;

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
