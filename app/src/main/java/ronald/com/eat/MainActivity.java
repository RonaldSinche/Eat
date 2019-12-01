package ronald.com.eat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity{

    Button btnSignIn, btnSignUp;
    TextView txtSlogan;
    VideoView vvBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vvBackground=findViewById(R.id.vvcarga);
        btnSignIn=(Button) findViewById(R.id.btnSignIn);
        btnSignUp=(Button) findViewById(R.id.btnSignUp);

        txtSlogan = (TextView) findViewById(R.id.txtSlogan);
        Typeface face=Typeface.createFromAsset(getAssets(),"fonts/NABILA.TTF");
        txtSlogan.setTypeface(face);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signin = new Intent(MainActivity.this, SignIn.class);
                startActivity(signin);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signup = new Intent(MainActivity.this, SignUp.class);
                startActivity(signup);
            }
        });

        Uri u =Uri.parse("android.resource://"+ getPackageName()+"/"+R.raw.videobackground);
        vvBackground.setVideoURI(u);
        vvBackground.start();

        vvBackground.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp)
            {
                mp.setLooping(true);
            }
        });
    }

    @Override
    protected void onResume()
    {
        vvBackground.resume();
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        vvBackground.suspend();
        super.onPause();
    }

    @Override
    protected void onDestroy()
    {
        vvBackground.stopPlayback();
        super.onDestroy();
    }
}
