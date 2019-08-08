package com.jwz.handlememoryleakdemo;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.lang.ref.WeakReference;

/**
 * @description
 *
 * @author jiang wenzhong
 * @date 2019-08-08
 */
public class BestPracticeActivity extends AppCompatActivity{

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_practice);

        mHandler = new Handler();
        mHandler.postDelayed(new LeakRunnable(this), 50000);
    }


   private static class LeakRunnable implements Runnable{

        WeakReference<Activity> mWeakActivity;
        LeakRunnable(Activity activity){
            mWeakActivity = new WeakReference<>(activity);
        }
       @Override
       public void run() {

           Activity activity = mWeakActivity.get();
           if(activity != null) {
               Toast.makeText(activity, "delay toast！", Toast.LENGTH_SHORT).show();
           }
       }
   }

    @Override
    protected void onDestroy() {

        if(mHandler != null){
            mHandler.removeCallbacksAndMessages(null);
        }

        super.onDestroy();
    }
}
