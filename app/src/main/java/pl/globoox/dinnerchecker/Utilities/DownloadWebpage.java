package pl.globoox.dinnerchecker.Utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadWebpage {
    private static final String newLine = System.getProperty("line.separator");


    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://piotr-lubawka.pl");
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    String readStream = readStream(con.getInputStream());
                    System.out.println(readStream);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    private static String readStream(InputStream in) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in));) {
            String nextLine = "";
            while ((nextLine = reader.readLine()) != null) {
                sb.append(nextLine + newLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


}