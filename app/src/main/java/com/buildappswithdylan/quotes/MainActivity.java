package com.buildappswithdylan.quotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.buildappswithdylan.quotes.category.love;
import com.buildappswithdylan.quotes.category.motivational;
import com.buildappswithdylan.quotes.category.science;
import com.buildappswithdylan.quotes.category.spiritual;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button love_btn,moti_btn,science_btn,spiri_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        love_btn=findViewById(R.id.love_btn);
        moti_btn=findViewById(R.id.moti_btn);
        science_btn=findViewById(R.id.science_btn);
        spiri_btn=findViewById(R.id.spiri_btn);

        love_btn.setOnClickListener(this);
        moti_btn.setOnClickListener(this);
        science_btn.setOnClickListener(this);
        spiri_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.love_btn:
                Intent intent1=new Intent(MainActivity.this, love.class);
                startActivity(intent1);
                break;

            case R.id.moti_btn:
                Intent intent2=new Intent(MainActivity.this, motivational.class);
                startActivity(intent2);
                break;

            case R.id.science_btn:
                Intent intent3=new Intent(MainActivity.this, science.class);
                startActivity(intent3);
                break;

            case R.id.spiri_btn:
                Intent intent4=new Intent(MainActivity.this, spiritual.class);
                startActivity(intent4);
                break;







        }

    }
}