package com.example.kobayashi_satoru.okosurequester;


import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity implements TextWatcher,View.OnClickListener {
    private String urlTxt;
    //データベースの呼び出し
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference dbSendUrl = database.getReference("url");
    DatabaseReference dbOkitaSum = database.getReference("okita");
    //タイマー処理用
    private Timer mTimer = new Timer();
    Handler mHandler = new Handler();
    int okitaSum = 0;
    int kakosum = 0;
    boolean first = true;

    String TAG = "satoru";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //editTextのリアルタイム監視に必要なメソッド
        EditText edittext = findViewById(R.id.editText);
        edittext.addTextChangedListener(this);
        //image画像のセット
        final ImageView okitaimageview = findViewById(R.id.OkitaImageView);

        //タイマー処理
        mTimer = new Timer(true);
        mTimer.schedule(new TimerTask(){
            @Override
            public void run() {
                mHandler.post( new Runnable() {
                    public void run() {
                        //データベースに読み込み
                        ValueEventListener valueEventListener = dbOkitaSum.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                // This method is called once with the initial value and again
                                // whenever data at this location is updated.
                                try {
                                    okitaSum = dataSnapshot.getValue(int.class);
                                } catch (NullPointerException e) {
                                    return;
                                }

                                kakosum=okitaSum;
                                if(first) {
                                    first = false;
                                    Log.d("変数の中身は", okitaSum + "でええすあああああああ");
                                    if (okitaSum >= 10) {
                                        //イメージのサイズを指定
                                        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(800, 800);
                                        //表示位置を指定
                                        params.topMargin = 160;
                                        params.leftMargin = 200;
                                        //イメージの表示
                                        okitaimageview.setLayoutParams(params);
                                        okitaimageview.setImageResource(R.drawable.okita4);
                                        Log.d("画像の中身を４に", "画像を切り替えたあああああああ");
                                    } else if (okitaSum >= 5) {
                                        //イメージのサイズを指定
                                        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(800, 800);
                                        //表示位置を指定
                                        params.topMargin = 160;
                                        params.leftMargin = 200;
                                        //イメージの表示
                                        okitaimageview.setLayoutParams(params);
                                        okitaimageview.setImageResource(R.drawable.okita3);
                                        Log.d("画像の中身を３に", "画像を切り替えたあああああああ");
                                    } else if (okitaSum >= 1) {
                                        //イメージのサイズを指定
                                        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(800, 800);
                                        //表示位置を指定
                                        params.topMargin = 160;
                                        params.leftMargin = 200;
                                        //イメージの表示
                                        okitaimageview.setLayoutParams(params);
                                        okitaimageview.setImageResource(R.drawable.okita2);
                                        Log.d("画像の中身を２に", "画像を切り替えたあああああああ");
                                    } else {
                                        //イメージのサイズを指定
                                        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(800, 800);
                                        //表示位置を指定
                                        params.topMargin = 160;
                                        params.leftMargin = 200;
                                        //イメージの表示
                                        okitaimageview.setLayoutParams(params);
                                        okitaimageview.setImageResource(R.drawable.okita1);
                                        Log.d("画像の中身を１に", "画像を切り替えたあああああああ");
                                    }
                                }
                                if(kakosum==okitaSum){
                                }
                                else{
                                    Log.d("変数の中身は", okitaSum + "でええすあああああああ");
                                    if (okitaSum >= 10) {
                                        //イメージのサイズを指定
                                        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(800, 800);
                                        //表示位置を指定
                                        params.topMargin = 160;
                                        params.leftMargin = 200;
                                        //イメージの表示
                                        okitaimageview.setLayoutParams(params);
                                        okitaimageview.setImageResource(R.drawable.okita4);
                                        Log.d("画像の中身を４に", "画像を切り替えたあああああああ");
                                    } else if (okitaSum >= 5) {
                                        //イメージのサイズを指定
                                        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(800, 800);
                                        //表示位置を指定
                                        params.topMargin = 160;
                                        params.leftMargin = 200;
                                        //イメージの表示
                                        okitaimageview.setLayoutParams(params);
                                        okitaimageview.setImageResource(R.drawable.okita3);
                                        Log.d("画像の中身を３に", "画像を切り替えたあああああああ");
                                    } else if (okitaSum >= 1) {
                                        //イメージのサイズを指定
                                        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(800, 800);
                                        //表示位置を指定
                                        params.topMargin = 160;
                                        params.leftMargin = 200;
                                        //イメージの表示
                                        okitaimageview.setLayoutParams(params);
                                        okitaimageview.setImageResource(R.drawable.okita2);
                                        Log.d("画像の中身を２に", "画像を切り替えたあああああああ");
                                    } else {
                                        //イメージのサイズを指定
                                        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(800, 800);
                                        //表示位置を指定
                                        params.topMargin = 160;
                                        params.leftMargin = 200;
                                        //イメージの表示
                                        okitaimageview.setLayoutParams(params);
                                        okitaimageview.setImageResource(R.drawable.okita1);
                                        Log.d("画像の中身を１に", "画像を切り替えたあああああああ");

                                    }
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError error) {
                                // Failed to read value
                                Log.w(TAG, "Failed to read value.", error.toException());
                            }
                        });
                    }
                });
            }
        },1000,10000); //1秒後から10秒間隔で実行

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

    @Override
    public void onClick(View v) {

    }
    public void onClickTimeInputButton(View v){
        Toast toast = Toast.makeText(this,"未実装", Toast.LENGTH_LONG);
        toast.show();
    }
    public void onClickAlarmSetButton(View v){
        Toast toast = Toast.makeText(this,"未実装", Toast.LENGTH_LONG);
        toast.show();
    }
    public void onClickUrlInputButton(View v){
        Toast toast = Toast.makeText(this,"未実装", Toast.LENGTH_LONG);
        toast.show();
    }
}