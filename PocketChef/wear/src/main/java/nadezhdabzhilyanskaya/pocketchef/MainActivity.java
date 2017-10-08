package nadezhdabzhilyanskaya.pocketchef;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.BoxInsetLayout;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.speech.RecognizerIntent;
import android.support.v4.app.NavUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.StringWriter;
import java.io.InputStreamReader;


public class MainActivity extends WearableActivity{
    public ListView mList;
    public static final int VOICE_RECOGNITION_REQUEST_CODE = 1234;

    private static final SimpleDateFormat AMBIENT_DATE_FORMAT =
            new SimpleDateFormat("HH:mm", Locale.US);

    private BoxInsetLayout mContainerView;
    private TextView mTextView;
    private TextView mClockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAmbientEnabled();

        mContainerView = (BoxInsetLayout) findViewById(R.id.container);
        mTextView = (TextView) findViewById(R.id.text);
        //mClockView = (TextView) findViewById(R.id.clock);
        //mList = (ListView) findViewById(R.id.list);

        String name = "Hello World!!!!";

        getRequest();
//        TextView text = (TextView) findViewById(R.id.recipe);
//        text.setText(name);

        //startVoiceRecognitionActivity();
    }

    @Override
    public void onEnterAmbient(Bundle ambientDetails) {
        super.onEnterAmbient(ambientDetails);
        updateDisplay();
    }

    @Override
    public void onUpdateAmbient() {
        super.onUpdateAmbient();
        updateDisplay();
    }

    @Override
    public void onExitAmbient() {
        updateDisplay();
        super.onExitAmbient();
    }

    private void updateDisplay() {
        if (isAmbient()) {
            mContainerView.setBackgroundColor(getResources().getColor(android.R.color.black));
            mTextView.setTextColor(getResources().getColor(android.R.color.white));
            mClockView.setVisibility(View.VISIBLE);

            mClockView.setText(AMBIENT_DATE_FORMAT.format(new Date()));
        } else {
            mContainerView.setBackground(null);
            mTextView.setTextColor(getResources().getColor(android.R.color.black));
            mClockView.setVisibility(View.GONE);
        }
    }



    public void startVoiceRecognitionActivity() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Speech recognition demo");
        startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
    }

    public void getRequest() {
        String result = null;
        StringBuffer sb = new StringBuffer();
        InputStream in = null;
        try {
            URL url = new URL("http://chefaccesor.mybluemix.net/recipes");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //urlConnection.connect();
            //TextView text = (TextView) findViewById(R.id.recipe);
            //text.setText(urlConnection.toString());

            InputStream is = null;

            urlConnection.setReadTimeout(3000);
            // Timeout for connection.connect() arbitrarily set to 3000ms.
            urlConnection.setConnectTimeout(3000);
            // For this use case, set HTTP method to GET.
            urlConnection.setRequestMethod("GET");
            // Already true by default but setting just in case; needs to be true since this request
            // is carrying an input (response) body.
            urlConnection.setDoInput(true);
            // Open communications link (network traffic occurs here).
            urlConnection.connect();

            try {
                urlConnection.setDoInput(true);
                urlConnection.setDoOutput(true);

                urlConnection.getInputStream();
            }finally{
                urlConnection.disconnect();
            }

            BufferedReader r = new BufferedReader(new InputStreamReader(is));
            String x = "";
            x = r.readLine();
            String total = "";

            while(x!= null){
                total += x;
                x = r.readLine();
            }
        String name = "Hello";
        TextView text = (TextView) findViewById(R.id.recipe);
        text.setText(name);
            //readStream(in);
            urlConnection.disconnect();
       } catch (MalformedURLException e) {
//            //Do nothing
        } catch (IOException e) {}
//

        /*try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            readStream(in);
        } finally {
            urlConnection.disconnect();
        }*/
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);

//        if (requestCode == VOICE_RECOGNITION_REQUEST_CODE && resultCode == RESULT_OK) {
//
//            ArrayList matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
//
//
//            mList.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, matches));
//

           /* if (matches.contains("information")) {
                informationMenu();
            }*/
//        }
    }


}
