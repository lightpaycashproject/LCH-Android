package colx.org.colxwallet.ui.splash_activity;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.VideoView;
import android.os.Handler;
import colx.org.colxwallet.ColxApplication;
import colx.org.colxwallet.R;
import colx.org.colxwallet.ui.start_activity.StartActivity;
import colx.org.colxwallet.ui.wallet_activity.WalletActivity;

/**
 * Created by Neoperol on 6/13/17.
 */

public class SplashActivity extends AppCompatActivity {
    VideoView videoView;
    ImageView imageView;
    private boolean ispaused = false;

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(imageView!=null)
                {
                    jump();
                }
            }
        },3000);


        videoView = (VideoView) findViewById(R.id.video_view);
        imageView = (ImageView) findViewById(R.id.imageView);
//        Uri video;
//        if(ColxApplication.getInstance().getAppConf().isSplashSoundEnabled()) {
//
//            //  video = Uri.parse("android.resource://" + getPackageName() + "/"
//          //      + R.raw.splash_video); }
//        else {
//            //video = Uri.parse("android.resource://" + getPackageName() + "/"
//            //        + R.raw.splash_video_muted);
//            Intent intent = new Intent(this, WalletActivity.class);
//            startActivity(intent);
//            finish();
//            return;
//        }

//        if (videoView != null) {
//            videoView.setVideoURI(video);
//            videoView.setZOrderOnTop(true);
//            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                public void onCompletion(MediaPlayer mp) {
//                    jump();
//                }
//            });
//
//            videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
//                @Override
//                public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
//                    jump();
//                    return true;
//                }
//            });
//
//            videoView.start();
//
//        }else{
//            jump();
//        }
    }


    private void jump() {

        if (ColxApplication.getInstance().getAppConf().isAppInit()){
            Intent intent = new Intent(this, WalletActivity.class);
            startActivity(intent);
        }else {
            // Jump to your Next Activity or MainActivity
            Intent intent = new Intent(this, StartActivity.class);
            startActivity(intent);
        }
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ispaused = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ispaused) {
            jump();
        }

    }
}
