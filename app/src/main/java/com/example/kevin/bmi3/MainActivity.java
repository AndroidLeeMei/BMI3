package com.example.kevin.bmi3;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //BMI相關設定
    Button button;
    EditText fieldHeight,fieldWeight;
    TextView txtHeight,txtWeight;
    public static final String TAG = "LifeCycle";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setListeners();

    }

    void findViews(){
        button = (Button) findViewById(R.id.submit);
        fieldHeight = (EditText) findViewById(R.id.height);
        fieldWeight = (EditText) findViewById(R.id.weight);
        txtHeight=(TextView)findViewById(R.id.txtHeight);
        txtWeight=(TextView)findViewById(R.id.txtWeight);
    }

    void setListeners(){
        button.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent();
            intent.setClass(MainActivity.this,Report.class);
            Bundle bundle = new Bundle();
            bundle.putString("KEY_HEIGHT",fieldHeight.getText().toString());
            bundle.putString("KEY_WEIGHT",fieldWeight.getText().toString());
            intent.putExtras(bundle);
            startActivity(intent);
        }
    };





    public void openOldNotification(View target){
        Intent intent = new Intent();
        intent.setClass(this, NotificationActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("KEY_NOTIFICATION", "old");

        intent.putExtras(bundle);
        startActivity(intent);  //開始出發
        finish();

    }
    public void openNewNotification(View target){
        Intent intent = new Intent();
        intent.setClass(this, NotificationActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("KEY_NOTIFICATION", "new");

        intent.putExtras(bundle);
        startActivity(intent);  //開始出發
//        finish();
    }

    public void openAlarmManager(View target){
        Intent intent = new Intent();
        intent.setClass(this, NotificationActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("KEY_NOTIFICATION", "alarm");

        intent.putExtras(bundle);
        startActivity(intent);  //開始出發
//        finish();
    }

    public void openPropertyAnimation(View target){
        Intent intent = new Intent();
        intent.setClass(this, PropertyAnimation.class);
        startActivity(intent);  //開始出發
    }
}
