package abacus.pulles.com.annotateyou;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private TextView textView;
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Code to view fullscreen.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        textView = findViewById(R.id.textView);

        //Set Animation
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        Animation animation3 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade3);
        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.downtoup);
        Animation animation4 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.uptodown);

        imageView.startAnimation(animation);
        imageView2.startAnimation(animation2);
        imageView3.startAnimation(animation4);
        imageView4.startAnimation(animation3);

        //Set custom fonts
        Typeface CustomFont = Typeface.createFromAsset(getAssets(), "fonts/PatchyRobots.ttf");
        textView.setTypeface(CustomFont);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent loginIntent = new Intent(MainActivity.this, CanvasActivity.class);
                startActivity(loginIntent);
                finish();

            }
        },SPLASH_TIME_OUT);


    }
}
