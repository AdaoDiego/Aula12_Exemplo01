package com.wbertan.aula12_exemplo01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by william.bertan on 20/10/2016.
 */

public class NotificationReceiverActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("NotificationReceiver!");
    }
}