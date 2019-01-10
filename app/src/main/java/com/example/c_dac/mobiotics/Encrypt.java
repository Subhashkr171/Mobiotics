package com.example.c_dac.mobiotics;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import static android.media.MediaCodec.MetricsConstants.MODE;

public class Encrypt extends AppCompatActivity {
    EditText et_string;
    TextView tv_string;
    Button btn_submit;
    String str7;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setTitle("Crypot String"+"    ");
        et_string = (EditText) findViewById(R.id.etstring);
        tv_string = (TextView) findViewById(R.id.tvstring);
        btn_submit = (Button) findViewById(R.id.btn_submit);
         data=getIntent().getStringExtra("passdata");
        getSupportActionBar().setTitle("Crypot String"+"    "+data);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str7=""+et_string.getText().toString().trim();
                Log.d("hffhgfk",""+str7.length()+" ff "+getIntent().getStringExtra("passdata"));

                if(str7.length()==0){
                    Toast.makeText(Encrypt.this, "Please enter the String", Toast.LENGTH_SHORT).show();
                }else{
                    if(data.equals("Encrypt")){
                        encrypt1(str7);
                    }else {
                        decrypt1(str7);
                    }

                }
            }
        });
    }

    public void encrypt1(String str){
        int c=1;
        String str1="";
        StringBuilder sb=new StringBuilder();
        sb.append(str);
        for(int i=0;i<sb.length();i++){
            c=1;
            if(i==sb.length()-1){
            }
            else{
                if(sb.charAt(i)==sb.charAt(i+1)){
                    c+=c;
                    sb.deleteCharAt(i+1);
                }else{
                }
            }
            str1+=""+sb.charAt(i)+""+c;
        }
        tv_string.setText(str1);
    }
    public void decrypt1(String sr){
        char ch[]=new char[sr.length()];
        int arr[]=new int[sr.length()];
        String sta1="",sta2="",sta3="";
        if(sr.charAt(0)=='1'||sr.charAt(0)=='2'||sr.charAt(0)=='3'||sr.charAt(0)=='4'||sr.charAt(0)=='5'||
                sr.charAt(0)=='6'||sr.charAt(0)=='7'||sr.charAt(0)=='8'||sr.charAt(0)=='9'||sr.charAt(0)=='0'){
            tv_string.setText("please enter right string");
        }
        else{
            for(int i=0;i<sr.length();i++){
                ch[i]=sr.charAt(i);
                arr[i]=Character.getNumericValue(sr.charAt(i));
            }

            for(int k=0;k<ch.length;k+=2){
                for(int l=0;l<arr[k+1];l++){
                    sta1+=ch[k];
                }
                System.out.println();
            }

            tv_string.setText(sta1);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
