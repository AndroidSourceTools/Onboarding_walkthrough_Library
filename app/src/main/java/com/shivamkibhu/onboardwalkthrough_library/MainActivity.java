package com.shivamkibhu.onboardwalkthrough_library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.shivamkibhu.onboardwalkthrough.OnboardWalkthrough;
import com.shivamkibhu.onboardwalkthrough.Page;
import com.shivamkibhu.onboardwalkthrough.PageListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        OnboardWalkthrough view = findViewById(R.id.mainView);

        Page page1 = new Page();
        Page page2 = new Page();
        Page page3 = new Page();
        Page page4 = new Page();


        page1.setBackgroundColor("#E8290B").setTitle("Fresh")
                .setDescription("Find all as fresh")
                .setTitleColor("#ffffff")
                .setDescriptionColor("#ffffff")
                .setTitleSize(23)
                .setDescriptionSize(18);


        page2.setBackgroundColor("#FBD28B")
                .setTitle("Clean")
                .setDescription("Clean is clear");


        page3.setTitle("Green")
                .setDescription("Will green forever")
                .setBackgroundColor("#F5BCBA")
                .setImage(R.drawable.ic_launcher_foreground)
                .setImageLayoutParams(500, 100, 300, 300, 300, 0);


        page4.setImage(R.drawable.ic_launcher_background)
                .setImageLayoutParams(100, 100, 0, 500, 0, 0)
                .setBackgroundColor("#00CCCD")
                .setTitle("Move")
                .setDescription("Feel satisfied")
                .setTitleSize(18)
                .setDescriptionSize(15);


        view.setStartTitle("Lets take")
                .setStartClickListener(new PageListener() {
                    @Override
                    public void OnClick() {
                        Toast.makeText(MainActivity.this, "Take clicked", Toast.LENGTH_SHORT).show();
                    }
                }).setSkipClickListener(new PageListener() {
            @Override
            public void OnClick() {
                Toast.makeText(MainActivity.this, "Skip  Clicked", Toast.LENGTH_SHORT).show();
            }
        });


        view.add(page1);
        view.add(page2);
        view.add(page3);
        view.add(page4);

        view.build();
    }
}
