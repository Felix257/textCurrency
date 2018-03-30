package com.example.felix.mycurrencyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    String[] countries;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    ListView listView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView) findViewById(R.id.listView);
        editText=(EditText) findViewById(R.id.txtSearch);
        initList();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if(s.toString().equals("")){ //resets listview
                    initList();
                }
                else{ //performs search
                    searchItem(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void searchItem(String textToSearch){
        for(String item:countries){
            if(!item.contains(textToSearch)){
                listItems.remove(item);
            }
        }
        adapter.notifyDataSetChanged();
    }

    public void initList(){
        countries=new String[] {"Canada", "United States", "China", "Japan"};
        listItems=new ArrayList<>(Arrays.asList(countries));
        adapter=new ArrayAdapter<String>(this,R.layout.list_item, R.id.txtItem, listItems);
        listView.setAdapter(adapter);

    }
}
