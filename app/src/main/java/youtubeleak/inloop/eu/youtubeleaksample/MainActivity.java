package youtubeleak.inloop.eu.youtubeleaksample;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;


public class MainActivity extends FragmentActivity {

    private static final String YOUR_GOOGLE_API_KEY = "ENTER_YOUR_GOOGLE_API_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());

        YouTubePlayerSupportFragment youTubePlayerSupportFragment = (YouTubePlayerSupportFragment) getSupportFragmentManager().findFragmentById(R.id.viewpager);
        if (youTubePlayerSupportFragment == null) {
            youTubePlayerSupportFragment = YouTubePlayerSupportFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.viewpager, youTubePlayerSupportFragment).commit();
        }

        youTubePlayerSupportFragment.initialize(YOUR_GOOGLE_API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean isRecovered) {
                if (!isRecovered) {
                    youTubePlayer.cueVideo("dSajQAGo6x8");
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
