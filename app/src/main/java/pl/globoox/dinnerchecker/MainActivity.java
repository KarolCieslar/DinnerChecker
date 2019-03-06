package pl.globoox.dinnerchecker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

import pl.globoox.dinnerchecker.Utilities.DownloadWebpage;

public class MainActivity extends AppCompatActivity {

    DownloadWebpage classWebPage = new DownloadWebpage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        new Thread(new Runnable() {
            @Override
            public void run() {
                final StringBuilder builder = new StringBuilder();

                try {
                    Document doc = Jsoup.connect("http://www.piotr-lubawka.pl").get();
                    Element masthead = doc.select("div.post-content").first();
                    String dinner = masthead.text();

                    Log.d("TAG", String.valueOf(dinner));


                } catch (IOException e) {
                    builder.append("Error : ").append(e.getMessage()).append("\n");
                }

            }
        }).start();



    }


}
