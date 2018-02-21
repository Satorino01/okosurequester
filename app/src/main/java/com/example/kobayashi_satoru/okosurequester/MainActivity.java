package com.example.kobayashi_satoru.okosurequester;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity implements TextWatcher {
    private String urlTxt;
    //データベースの呼び出し
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference dbSendUrl = database.getReference("url");
    String TAG = "satoru";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //editTextのリアルタイム監視に必要なメソッド
        EditText edittext = findViewById(R.id.editText);
        edittext.addTextChangedListener(this);
    }
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        //zeroshinegi53
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        urlTxt=editable.toString();
    }

    public void onClickSend(View view) {
        if(urlTxt!=null) {
            //データベースに書き込み
            dbSendUrl.setValue(urlTxt);
            TextView statustextview = findViewById(R.id.StatusTextView);
            statustextview.setText(urlTxt+"：リクエスト送信しました");
        }else{
            Toast toast = Toast.makeText(this,"URLを入力してね", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}