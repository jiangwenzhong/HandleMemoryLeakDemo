package com.jwz.handlememoryleakdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @description
 *
 * @author jiang wenzhong
 * @date 2019-08-08
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void leak1(View view) {

        startActivity(new Intent(this, LeakActivity1.class));
    }
    public void leak2(View view) {

        startActivity(new Intent(this, LeakActivity2.class));
    }
    public void bestPractice(View view) {

        startActivity(new Intent(this, BestPracticeActivity.class));
    }
}
