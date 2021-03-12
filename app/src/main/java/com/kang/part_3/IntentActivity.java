package com.kang.part_3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntentActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    //Member Variable
    private final boolean D  = true;
    private final String TAG = "IntentActivity";

    // View Object
    private ListView listView;

    // data
    private String[] arr_str;
    private ArrayList<String> array;
    private List<String> list;
    private ArrayAdapter<String> adapter;

    // Member Method - AppCompatActivity's override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_intent);

        init();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case AppConstant.REQ_DATA_CODE:
                if(resultCode==RESULT_OK){
                    Log.i(TAG,"ok "+ data.getStringExtra(AppConstant.KEY_PHONE));
                }
                else{
                    Toast.makeText(this,"Fail", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    // Member Method - Custom
    private void init() {
        array = new ArrayList<String>();

        arr_str = this.getResources().getStringArray(R.array.list_intent);
        list = Arrays.asList(arr_str);
        array.addAll(list);

        listView = findViewById(R.id.list_intent);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this::onItemClick);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i(TAG, "onCreate() OK");
        Intent intent;

        switch (position) {
            case AppConstant.ITEM_GO:
                intent = new Intent(IntentActivity.this, GoActivity.class);
                startActivity(intent);
                break;
            case AppConstant.ITEM_GO_WITH_DATA:
                intent = new Intent(IntentActivity.this, GoActivity.class);
                intent.putExtra(AppConstant.KEY_NAME, "Kim");
                intent.putExtra(AppConstant.KEY_NAME, "010-1234-5678");

                ArrayList<String> names = new ArrayList<String>();
                names.add("Hong");
                names.add("Kang");
                names.add("Won");
                names.add("Park");
                intent.putExtra(AppConstant.KEY_NAMES, names);
                startActivity(intent);
                break;
            case AppConstant.ITEM_GO_WITH_OBJECT:
                ArrayList<Person> persons = new ArrayList<Person>();
                persons.add(new Person("Tom", "F", 10));
                persons.add(new Person("Lee", "F", 35));
                persons.add(new Person("Choi", "M", 14));

                intent = new Intent(IntentActivity.this, GoObjectActivity.class);
                intent.putExtra(AppConstant.KEY_PERSONS, persons);
                startActivity(intent);
                break;
            case AppConstant.ITEM_GO_BACK:
                intent = new Intent(IntentActivity.this, GoBackActivity.class);
                startActivityForResult(intent, AppConstant.REQ_DATA_CODE);
                break;
        }
    }
}