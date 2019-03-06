package pl.globoox.dinnerchecker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import pl.globoox.dinnerchecker.Utilities.DownloadWebpage;

public class MainActivity extends AppCompatActivity {

    DownloadWebpage classWebPage = new DownloadWebpage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ArrayList<String> list = new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                final StringBuilder builder = new StringBuilder();

                try {
                    Document doc = Jsoup.connect("http://www.piotr-lubawka.pl").get();
                    Elements masthead = doc.select("div.post-content").select("p");
                    for (Element el : masthead) {
                        list.add(String.valueOf(el));
                    }

                    String data = list.get(1);
                    Log.d("TAG", data);
                    for (int i = 3; i < 12; i++) {
                        String dinner = list.get(i);
                        dinner = dinner.replaceAll("&nbsp;", "");
                        dinner = dinner.replaceAll("<p>", "");
                        dinner = dinner.replaceAll("</p>", "");
                        Log.d("TAG", dinner);
                    }


                } catch (IOException e) {
                    builder.append("Error : ").append(e.getMessage()).append("\n");
                }

            }
        }).start();


    }


}