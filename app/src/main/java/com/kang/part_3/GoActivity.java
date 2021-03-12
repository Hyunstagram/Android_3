package com.kang.part_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GoActivity extends AppCompatActivity {
    //Member Variable
    private final boolean D  = true;
    private final String TAG = "GoActivity";

    // View Object
    private TextView text_msg;

    // Member Method - AppCompatActivity's override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_go);

        init();
    }

    // Member Method - Custom
    private void init() {
        Intent intent = this.getIntent();
        //String data = intent.getStringExtra(AppConstant.KEY_NAME);

        ArrayList<String> data = (ArrayList<String>)intent.getSerializableExtra(AppConstant.KEY_NAMES);


        text_msg = findViewById(R.id.text_msg);
        // if(data != null) text_msg.setText(data);
        if(data != null) {
            String str = "";
            for (int i = 0; i < data.size(); i++)
                str += data.get(i) + "\n";

            text_msg.setText(str);
        }
    }
}