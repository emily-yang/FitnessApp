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

public class ActivityLegs extends Activity {
    Context context;
    ListView list;
    ArrayAdapter<String> adapter;

    String legList[] = {"Squat", "Seated Leg Curl", "Dumbell Reverse Lunge", "Hack Squat", "Leg Extension"};
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);
        list = (ListView)findViewById(R.id.backList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_back_list, R.id.textView3, legList);
        list.setAdapter(arrayAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position) {
                    case 0:
                        String myUri1 = "https://www.youtube.com/watch?v=R2dMsNhN3DE";
                        Intent list1 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri1));
                        startActivity(list1);
                        break;
                    case 1:
                        String myUri2 = "https://www.youtube.com/watch?v=ELOCsoDSmrg";
                        Intent list2 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri2));
                        startActivity(list2);
                        break;
                    case 2:
                        String myUri3 = "https://www.youtube.com/watch?v=sjlsISvHyZs";
                        Intent list3 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri3));
                        startActivity(list3);
                        break;
                    case 3:
                        String myUri4 = "https://www.youtube.com/watch?v=LfEhHboTcow";
                        Intent list4 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri4));
                        startActivity(list4);
                        break;
                    case 4:
                        String myUri5 = "https://www.youtube.com/watch?v=YyvSfVjQeL0";
                        Intent list5 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri5));
                        startActivity(list5);
                        break;
                    case 5:
                        String myUri6 = "https://www.youtube.com/watch?v=mTissC9K1FQ";
                        Intent list6 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri6));
                        startActivity(list6);
                        break;

                }
            }

        });




    }
}
