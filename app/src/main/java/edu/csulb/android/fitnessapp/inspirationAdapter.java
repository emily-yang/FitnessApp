package edu.csulb.android.fitnessapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by joannato on 11/28/17.
 */

public class inspirationAdapter extends BaseAdapter {

    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;

    public inspirationAdapter(inspirationList inspirationList, String[] prgmNameList, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=inspirationList;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public inspirationAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.activity_inspiration_ben_view, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView2);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView);
        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                switch (position) {
                    case 0:
                        String myUri = "https://www.youtube.com/watch?v=R2dMsNhN3DE";
                        Intent list1 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri));
                        context.startActivity(list1);
                        break;

                    case 1:
                        String myUri2 = "https://www.youtube.com/watch?v=tuwHzzPdaGc";
                        Intent list2 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri2));
                        context.startActivity(list2);
                        break;

                    case 2:
                        String myUri3 = "https://www.youtube.com/watch?v=paCfxhgW6bI";
                        Intent list3 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri3));
                        context.startActivity(list3);
                        break;

                    case 3:
                        String myUri4 = "https://www.youtube.com/watch?v=6hNudn7Peco";
                        Intent list4 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri4));
                        context.startActivity(list4);
                        break;

                    case 4:
                        String myUri5 = "https://www.youtube.com/watch?v=mpZ9VRisAyw";
                        Intent list5 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri5));
                        context.startActivity(list5);
                        break;

                    case 5:
                        String myUri6 = "https://www.youtube.com/watch?v=LY1V6UbRHFM";
                        Intent list6 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri6));
                        context.startActivity(list6);
                        break;

                    case 6:
                        String myUri7 = "https://www.youtube.com/watch?v=2fbujeH3F0E";
                        Intent list7 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri7));
                        context.startActivity(list7);
                        break;

                    case 7:
                        String myUri8 = "https://www.youtube.com/watch?v=wjsu6ceEkAQ";
                        Intent list8 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri8));
                        context.startActivity(list8);
                        break;

                    case 8:
                        String myUri9 = "https://www.youtube.com/watch?v=j7ULT6dznNc";
                        Intent list9 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri9));
                        context.startActivity(list9);
                        break;

                    case 9:
                        String myUri10 = "https://www.youtube.com/watch?v=n1q-lAzAWms";
                        Intent list10 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri10));
                        context.startActivity(list10);
                        break;

                    case 10:
                        String myUri11 = "https://www.youtube.com/watch?v=1fbU_MkV7NE";
                        Intent list11 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri11));
                        context.startActivity(list11);
                        break;

                    case 11:
                        String myUri12 = "https://www.youtube.com/watch?v=IODxDxX7oi4";
                        Intent list12 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri12));
                        context.startActivity(list12);
                        break;

                    case 12:
                        String myUri13 = "https://www.youtube.com/watch?v=ykJmrZ5v0Oo";
                        Intent list13 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri13));
                        context.startActivity(list13);
                        break;

                    case 13:
                        String myUri14 = "https://www.youtube.com/watch?v=wjUmnZH528Y";
                        Intent list14 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri14));
                        context.startActivity(list14);
                        break;

                    case 14:
                        String myUri15 = "https://www.youtube.com/watch?v=j97SSGsnCAQ";
                        Intent list15 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri15));
                        context.startActivity(list15);
                        break;

                    case 15:
                        String myUri16 = "https://www.youtube.com/watch?v=4hRQP09nPnM";
                        Intent list16 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri16));
                        context.startActivity(list16);
                        break;

                    case 16:
                        String myUri17 = "https://www.youtube.com/watch?v=k4qaVoAbeHM";
                        Intent list17 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri17));
                        context.startActivity(list17);
                        break;

                    case 17:
                        String myUri18 = "https://www.youtube.com/watch?v=hmZxKCXS0tY";
                        Intent list18 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri18));
                        context.startActivity(list18);
                        break;

                    case 18:
                        String myUri19 = "https://www.youtube.com/watch?v=fQ7ewHFw_I8";
                        Intent list19 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri19));
                        context.startActivity(list19);
                        break;

                    case 19:
                        String myUri20 = "https://www.youtube.com/watch?v=paCfxhgW6bI";
                        Intent list20 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri20));
                        context.startActivity(list20);
                        break;

                    case 20:
                        String myUri21 = "https://www.youtube.com/watch?v=UpH7rm0cYbM";
                        Intent list21 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri21));
                        context.startActivity(list21);
                        break;

                    case 21:
                        String myUri22 = "https://www.youtube.com/watch?v=aFoektJK9dU";
                        Intent list22 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri22));
                        context.startActivity(list22);
                        break;

                    case 22:
                        String myUri23 = "https://www.youtube.com/watch?v=D0GwAezTvtg";
                        Intent list23 = new Intent(Intent.ACTION_VIEW, Uri.parse(myUri23));
                        context.startActivity(list23);
                        break;

                }
            }
        });
        return rowView;
    }
}