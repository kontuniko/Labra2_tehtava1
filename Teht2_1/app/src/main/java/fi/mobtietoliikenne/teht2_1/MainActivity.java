package fi.mobtietoliikenne.teht2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etAddressInput;
    TextView tvDataOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnStartNavigation).setOnClickListener(this);
        tvDataOutput = (TextView) findViewById(R.id.tvDataOutput);

        //DownloadTask downloadTask = new DownloadTask();


    }

    @Override
    public void onClick(View view) {
        DownloadTask task = new DownloadTask();
        EditText editText = findViewById(R.id.etAddress);
        try {
            String vastaus = task.execute(editText.getText().toString()).get();
            tvDataOutput.setText(vastaus);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
