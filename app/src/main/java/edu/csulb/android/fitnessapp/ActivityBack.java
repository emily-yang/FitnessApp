package edu.csulb.android.fitnessapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Benjamin on 11/25/2017.
 */


public class ActivityBack extends Activity {
    Context context;
    ListView list;
    ArrayAdapter<String> adapter;

    String backList[] = {"Deadlift", "Bent Over Row", "Pull Up"};
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);
        list = (ListView)findViewById(R.id.backList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_back_list, R.id.textView3, backList);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position) {
                    case 0:
                        String myUri1 = "https://www.youtube.com/watch?v=wjsu6ceEkAQ";
                        Intent list1 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri1));
                        startActivity(list1);
                        break;
                    case 1:
                        String myUri2 = "https://www.youtube.com/watch?v=paCfxhgW6bI";
                        Intent list2 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri2));
                        startActivity(list2);
                        break;
                    case 2:
                        String myUri3 = "https://www.youtube.com/watch?v=QZhzZtExnfc";
                        Intent list3 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri3));
                        startActivity(list3);
                        break;

            }
        }

    });




}
}



