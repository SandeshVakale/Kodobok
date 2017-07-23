package com.Sleepewoo.kodobok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemListener {


    RecyclerView recyclerView;
    ArrayList<DataModel> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        arrayList = new ArrayList<>();
        arrayList.add(new DataModel("Music", R.mipmap.sound, "#09A9FF"));
        arrayList.add(new DataModel("Map", R.mipmap.map, "#3E51B1"));
        arrayList.add(new DataModel("Alexa", R.mipmap.alexa, "#673BB7"));
        arrayList.add(new DataModel("Chat", R.mipmap.chat, "#4BAA50"));
        arrayList.add(new DataModel("User", R.mipmap.user, "#F94336"));
        arrayList.add(new DataModel("Settings", R.mipmap.settings, "#0A9B88"));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, arrayList, this);
        recyclerView.setAdapter(adapter);


        /**
         AutoFitGridLayoutManager that auto fits the cells by the column width defined.
         **/

        AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(this, 500);
        recyclerView.setLayoutManager(layoutManager);


        /**
         Simple GridLayoutManager that spans two columns
         **/
        /*GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);*/
    }

    @Override
    public void onItemClick(DataModel item) {

        Toast.makeText(getApplicationContext(), item.text + " is clicked", Toast.LENGTH_SHORT).show();

        if(item.text.contains("Settings"))
        {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);

        }
        if(item.text.contains("Map"))
        {
            Intent intent = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(intent);

        }
        if(item.text.contains("User"))
        {
            Intent intent = new Intent(MainActivity.this, GoogleSignIn.class);
            startActivity(intent);

        }

        if(item.text.contains("Music"))
        {
            Intent intent = new Intent(MainActivity.this, MainSound.class);
            startActivity(intent);

        }
        if(item.text.contains("Chat"))
        {
            Intent intent = new Intent(MainActivity.this, MainChat.class);
            startActivity(intent);

        }
    }
}
