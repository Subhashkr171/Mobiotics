package com.example.c_dac.mobiotics;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setTitle("Crypot String");
    }

    public void clicked(View view) {
        switch (view.getId()){
            case R.id.btnencrypt:
                Intent intent=new Intent(MainActivity.this,Encrypt.class);
                intent.putExtra("passdata","Encrypt");
                startActivity(intent);
                break;
            case R.id.btndecrypt:
                Intent intent1=new Intent(MainActivity.this,Encrypt.class);
                intent1.putExtra("passdata","Decrypt");
                startActivity(intent1);
                break;
        }
    }
}
