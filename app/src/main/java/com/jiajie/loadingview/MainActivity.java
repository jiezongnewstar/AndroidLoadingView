package com.jiajie.loadingview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.jiajie.load.LoadingDialog;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new LoadingDialog.Builder(this)
                .loadText("加载中")
                .build()
                .show();


    }
    public void show(View view){
        new LoadingDialog.Builder(this)
                .loadText("加载中")
                .build()
                .show();
    }
}
