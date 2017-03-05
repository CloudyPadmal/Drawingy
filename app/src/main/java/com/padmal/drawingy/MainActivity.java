package com.padmal.drawingy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ArtLayout artLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initiateView();

    }

    private void initiateView() {
        artLayout = (ArtLayout) findViewById(R.id.art_layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.art_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_change_color:

                View changeColor = findViewById(R.id.toolbar);
                PopupMenu popup = new PopupMenu(MainActivity.this, changeColor);
                popup.getMenuInflater()
                        .inflate(R.menu.color_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    public boolean onMenuItemClick(MenuItem item) {

                        artLayout.setDrawColor(item.getTitle().toString());
                        return true;
                    }
                });

                popup.show();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
