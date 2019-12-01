package fi.mobtietoliikenne.teht2_1;

import android.os.AsyncTask;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadTask extends AsyncTask<String,Void,String> {

    @Override
    protected String doInBackground(String... strings) {
    String nimi = strings[0];
    String vastaus = "";

        try {
            URL url; url = new URL (nimi);
            //URL url = new URL("http://android.com");
            //Log.d("LOADPAGE", "" + url);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            //InputStream stream = urlConnection.getInputStream();
            //tvDataOutput.setText(fromStream(stream));
            vastaus = fromStream(urlConnection.getInputStream());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vastaus;
    }

    @Override
    protected void onPostExecute(String vastaus) {
        super.onPostExecute(vastaus);
    }

    //From: https://stackoverflow.com/questions/309424/how-do-i-read-convert-an-inputstream-into-a-string-in-java
    public static String fromStream(InputStream in) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
            out.append(newLine);
        }
        return out.toString();
    }
}
