package com.jwz.handlememoryleakdemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * @description
 *
 * @author jiang wenzhong
 * @date 2019-08-08
 */
public class LeakActivity2 extends AppCompatActivity {

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak2);

        // 1.内部类持有引用外部类引用
        mHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {

                super.handleMessage(msg);
            }
        };

        // 2.内部类持有引用外部类引用
        // 3.消息会持有handle的引用，只有执行完消息后才会被释放
        //        private boolean enqueueMessage(MessageQueue queue, Message msg, long uptimeMillis) {
        //            msg.target = this;
        //            if (mAsynchronous) {
        //                msg.setAsynchronous(true);
        //            }
        //            return queue.enqueueMessage(msg, uptimeMillis);
        //        }
        mHandler.postDelayed(() -> {
            Toast.makeText(LeakActivity2.this, "delay toast！", Toast.LENGTH_SHORT).show();
        }, 50000);
    }
}
