package pl.globoox.dinnerchecker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import pl.globoox.dinnerchecker.Utilities.DownloadWebpage;

public class MainActivity extends AppCompatActivity {

    DownloadWebpage classWebPage = new DownloadWebpage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        classWebPage.main(null);
    }


}
