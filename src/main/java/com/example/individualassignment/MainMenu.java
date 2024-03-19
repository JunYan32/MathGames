package com.example.individualassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void launchGame1(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void launchGame2(View view) {
        Intent intent = new Intent(this, Game2.class);
        startActivity(intent);
    }

    public void launchGame3(View view) {
        Intent intent = new Intent(this, Game3.class);
        startActivity(intent);
    }
}
