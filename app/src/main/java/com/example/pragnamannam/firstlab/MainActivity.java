package com.example.pragnamannam.firstlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.opencv.android.OpenCVLoader;

public class MainActivity extends AppCompatActivity {

    Button imageButton;
    Button audioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton = (Button) findViewById(R.id.button1);
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent imageIntent = new Intent(MainActivity.this, ImageActivity.class);
                startActivity(imageIntent);
            }
        });
        audioButton = (Button) findViewById(R.id.button2);
        audioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent audioIntent = new Intent(MainActivity.this, AudioActivity.class);
                startActivity(audioIntent);
            }
        });
        if (!OpenCVLoader.initDebug()) {
            Log.e(this.getClass().getSimpleName(), "  OpenCVLoader.initDebug(), not working.");
        } else {
            Log.d(this.getClass().getSimpleName(), "  OpenCVLoader.initDebug(), working.");
        }
        // http://stackoverflow.com/questions/30004658/pick-an-image-from-gallery-in-android-studio

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
