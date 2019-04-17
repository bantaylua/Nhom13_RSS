package com.example.nhom13;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowHeadlines extends Activity {
    ListView lvHienThi;

    ArrayList<SingleItem> newsList = new ArrayList<SingleItem>();
    Integer Logo;
    String Caption;
    String URL;
    SingleItem selectedNewsItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_listview);

        Intent callingIntent = getIntent();

        Bundle myBundle = callingIntent.getExtras();
        Logo = myBundle.getInt("Logo");
        Caption = myBundle.getString("Caption");
        URL = myBundle.getString("URL");

        this.setTitle(Caption);
// ?? kho hieu
        lvHienThi = (ListView)this.findViewById(R.id.lvHienThi);
        lvHienThi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedNewsItem = newsList.get(position);
                showNiceDialogBox(selectedNewsItem, getApplicationContext());
            }
        });
//        Toast.makeText(ShowHeadlines.this, "TAI SAO??? Rss Download bi cai gi vay?????", Toast.LENGTH_LONG).show();
        DownloadRssFeed downloader = new DownloadRssFeed(ShowHeadlines.this);
        downloader.execute(URL, Caption);
    }

    public void showNiceDialogBox(SingleItem selectedStoryItem, Context context){
        String title = selectedStoryItem.getTitle();
        String description = selectedStoryItem.getDescription();
        if (title.toLowerCase().equals(description.toLowerCase())){
            description = "";
        }
        try
        {
            final Uri storyLink = Uri.parse(selectedStoryItem.getLink());
            AlertDialog.Builder myBuilder = new AlertDialog.Builder(this);
            myBuilder
                    .setIcon(Logo)
                    .setTitle(Html.fromHtml(Caption) )
                    .setMessage( title + "\n\n" + Html.fromHtml(description) + "\n" )
                    .setPositiveButton("Close", null)
                    .setNegativeButton("More", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichOne) {
                            Intent browser = new Intent(Intent.ACTION_VIEW, storyLink);
                            startActivity(browser);
                        }
                    })//setNegativeButton
                    .show();
        } catch (Exception e) {
            Log.e("Error DialogBox", e.getMessage() );
        }
    }
}
