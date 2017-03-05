package com.padmal.drawingy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ArtLayout artLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initiateView();

    }

    private void initiateView() {
        artLayout = (ArtLayout) findViewById(R.id.art_layout);
    }
}
