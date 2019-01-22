package test.splashscreen.ardhan.splashscreen;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Splashscreen extends AppCompatActivity {

    TextView textHigh;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar ab = getSupportActionBar();
        ab.hide();
        setContentView(R.layout.activity_splashscreen);

        image = findViewById(R.id.image);
        textHigh = findViewById(R.id.textHigh);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        image.startAnimation(anim);
        textHigh.startAnimation(anim);

        ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
        int warna = 0xFFFFFFFF;
        pb.getIndeterminateDrawable().setColorFilter(warna, PorterDuff.Mode.SRC_IN);
        pb.getProgressDrawable().setColorFilter(warna, PorterDuff.Mode.SRC_IN);

        textHigh = findViewById(R.id.textHigh);
        Typeface HighDestiny = Typeface.createFromAsset(getAssets(),"Fonts/HighDestiny.otf");
        textHigh.setTypeface(HighDestiny);

        Thread thread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(Splashscreen.this, MainActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}
