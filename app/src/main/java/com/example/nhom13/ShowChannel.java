package com.example.nhom13;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ShowChannel extends AppCompatActivity {
    ListView lvHienThi;

    String TenBao;
    Integer Logo;
    String[] Caption;
    String[] URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_listview);

        Intent callingIntent = getIntent();

        Bundle myBundle = callingIntent.getExtras();
        TenBao = myBundle.getString("TenBao");
        Logo = myBundle.getInt("Logo");
        Caption = myBundle.getStringArray("Caption");
        URL = myBundle.getStringArray("URL");

        this.setTitle(TenBao);

        lvHienThi = (ListView) findViewById(R.id.lvHienThi);
        lvHienThi.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Caption));

        lvHienThi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent callShowChannel = new Intent( ShowChannel.this, ShowHeadlines.class);

                Bundle myData = new Bundle();
                myData.putString("Caption",Caption[position]);
                myData.putString("URL",URL[position]);
                callShowChannel.putExtras(myData);

                startActivity(callShowChannel);
            }
        });
    }
}
