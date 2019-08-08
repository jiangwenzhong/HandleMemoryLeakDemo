package com.jwz.handlememoryleakdemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * @description
 *
 * @author jiang wenzhong
 * @date 2019-08-08
 */
public class LeakActivity1 extends AppCompatActivity {

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak1);

        mHandler = new Handler();

        mHandler.sendEmptyMessageDelayed(1,50000);
    }

}
