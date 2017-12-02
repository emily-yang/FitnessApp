package edu.csulb.android.fitnessapp;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;

import android.widget.ListView;
import android.widget.TextView;


/**
 * Created by joannato on 11/25/17.
 * Programmatically initialize the navigation drawer
 */

public class NavActivity extends AppCompatActivity{

    /**
     *  Frame layout: Which is going to be used as parent layout for child activity layout.
     *  This layout is protected so that child activity can access this
     *  */
    protected FrameLayout frameLayout;

    /**
     * ListView to add navigation drawer item in it.
     * We have made it protected to access it in child class. We will just use it in child class to make item selected according to activity opened.
     */

    protected ListView mDrawerList;

    /**
     * Static variable for selected item position. Which can be used in child activity to know which item is selected from the list.
     * */
    protected static int position;

    /**
     *  This flag is used just to check that launcher activity is called first time
     *  so that we can open appropriate Activity on launch and make list item position selected accordingly.
     * */
    private static boolean isLaunch = true;

    /**
     *  Base layout node of this Activity.
     * */
    protected DrawerLayout mDrawerLayout;

    /**
     * Drawer listener class for drawer open, close etc.
     */
    private ActionBarDrawerToggle actionBarDrawerToggle;

    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer);

        frameLayout = (FrameLayout)findViewById(R.id.mainContent);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mDrawerList = (ListView) findViewById(R.id.drawerList);

        // set a custom shadow that overlays the main content when the drawer opens
        //mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        // set up the drawer's list view with items and click listener
        View header = getLayoutInflater().inflate(R.layout.nav_header, mDrawerList, false);
        mDrawerList.addHeaderView(header);
        myAdapter = new MyAdapter(this);
        mDrawerList.setAdapter(myAdapter);


        mDrawerList.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openActivity(position);
                Log.d("CLICKED POSITION",Integer.valueOf(position).toString());
                myAdapter.setItemSelector(position);
            }

        });


        // ActionBarDrawerToggle ties together the the proper interactions between the sliding drawer and the action bar app icon
        actionBarDrawerToggle = new ActionBarDrawerToggle(
                NavActivity.this,						/* host Activity */
                mDrawerLayout, 				/* DrawerLayout object */
                R.string.navigation_drawer_open,       /* "open drawer" description for accessibility */
                R.string.navigation_drawer_close)      /* "close drawer" description for accessibility */
        {

            @Override
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(getString(R.string.app_name));
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
                super.onDrawerOpened(drawerView);

            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                super.onDrawerStateChanged(newState);
            }
        };
        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);


        /**
         * As we are calling BaseActivity from manifest file and this base activity is intended just to add navigation drawer in our app.
         * We have to open some activity with layout on launch. So we are checking if this BaseActivity is called first time then we are opening our first activity.
         * */
        if(isLaunch){
            /**
             *Setting this flag false so that next time it will not open our first activity.
             *We have to use this flag because we are using this BaseActivity as parent activity to our other activity.
             *In this case this base activity will always be call when any child activity will launch.
             */
            isLaunch = false;
            openActivity(0);

        }

    }

    /**
     * @param position
     *
     * Launching activity when any list item is clicked.
     */
    protected void openActivity(int position) {
        mDrawerList.setItemChecked(position,true);

        mDrawerLayout.closeDrawer(mDrawerList);

        switch (position) {
            case 1:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;

            case 2:
                Intent intent2 = new Intent(this, myWorkoutsActivity.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;

            case 3:
                Intent intent3 = new Intent(this, inspirationActivity.class);
                startActivity(intent3);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;

            case 4:
                Intent intent4 = new Intent(this, myEventsActivity.class);
                startActivity(intent4);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;

            case 5:
                Intent intent5 = new Intent(this, myLogsActivity.class);
                startActivity(intent5);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;

            case 6:
                Intent intent6 = new Intent(this, AboutActivity.class);
                startActivity(intent6);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;

            case 7:
                Intent intent7 = new Intent(this, SettingsActivity.class);
                startActivity(intent7);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;

            default:
                break;
        }


    }

}

/**
 * Create a new custom adapter to populate with icons and titles
 */
class MyAdapter extends BaseAdapter{
    /**
     * List item array for navigation drawer items.
     * */
    protected String[] featureList = {
            "Home",
            "Workouts",
            "Inspiration",
            "Events",
            "Logs",
            "About",
            "Settings"
    };

    /**
     * array of icons
     */
    protected int[] featureIconList = {
            R.drawable.ic_home_icon,
            R.drawable.ic_my_workout_icon,
            R.drawable.ic_inspiration_icon,
            R.drawable.ic_my_events_icon,
            R.drawable.ic_my_logs_icon,
            R.drawable.ic_about_icon,
            R.drawable.ic_setting_icons
    };

    //Get the context
    Context mContext = null;
    int itemSelector;

    public MyAdapter(Context context){
        mContext = context;
        itemSelector = 0;
    }

    public void setItemSelector(int index)
    {
        itemSelector = index;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return featureList.length;
    }

    @Override
    public Object getItem(int i) {
        return featureList[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //create the rows using the layout drawer_list_item
    @Override
    public View getView(int position, View convertView, ViewGroup parent){


        View row = null;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.drawer_list_item, parent, false);
        }else {
            row = convertView;
        }

        TextView titleTextView = (TextView) row.findViewById(R.id.navTextView);
        ImageView titleImageView = (ImageView) row.findViewById(R.id.navImageView);
        titleTextView.setText(featureList[position]);
        titleImageView.setImageResource(featureIconList[position]);

     return row;

    }


}