package com.kang.part_3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GoBackActivity extends AppCompatActivity {
    //Member Variable
    private final boolean D  = true;
    private final String TAG = "GoBackActivity";

    // View Object
    private TextView text_msg;

    // Member Method - AppCompatActivity's override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_go);

        init();

        text_msg.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(D) Log.i(TAG,"onLongClick()");

                Intent intent = new Intent();
                intent.putExtra(AppConstant.KEY_PHONE,"010-0000-0000");
                setResult(RESULT_OK, intent);
                finish();
                return true;
            }
        });
    }
    private void init(){
        text_msg = findViewById(R.id.text_msg);
    }
}