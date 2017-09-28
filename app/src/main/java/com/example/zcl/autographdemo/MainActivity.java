package com.example.zcl.autographdemo;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
public class MainActivity extends AppCompatActivity {
    private ImageView iv_aaa;
    private QMView viewById;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_aaa = (ImageView) findViewById(R.id.iv_aaa);
        viewById = (QMView) findViewById(R.id.qm);

    }


public void start(View view){

    Bitmap bitmap = viewById.getBitmap();
 iv_aaa.setImageBitmap(bitmap);
}
}
