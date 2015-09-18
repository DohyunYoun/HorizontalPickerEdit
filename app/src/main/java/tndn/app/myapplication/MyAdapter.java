package tndn.app.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.io.File;
import java.util.ArrayList;

/**
 * Created by YounDitt on 2015-09-17.
 */
public class MyAdapter extends BaseAdapter {

    ArrayList<Item> test;
    Context context;
    View itemView;

    HorizontalNumberPicker ho;
    TextView price;
    TextView name;
    LayoutInflater inflater;

    public MyAdapter(Context context, ArrayList<Item> test) {

        this.context = context;
        this.test = test;
    }

    @Override
    public int getCount() {
        return test.size();
    }

    @Override
    public String getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemView = inflater.inflate(R.layout.list_item, parent, false);


        ho = (HorizontalNumberPicker)itemView.findViewById(R.id.pick);
        price = (TextView) itemView.findViewById(R.id.price);
        name = (TextView) itemView.findViewById(R.id.name);

        price.setText(test.get(position).getPrice());
        name.setText(test.get(position).getName());

        Log.e("price", "test : " + test.get(position));

        ho.setListener(new HorizontalNumberPicker.HorizontalNumberPickerListener() {
            @Override
            public void onHorizontalNumberPickerChanged(HorizontalNumberPicker horizontalNumberPicker, int value) {

                if(value==0){
                    price.setText(test.get(position).getPrice());
                }else {

                    //value is count

//                    Integer index = (Integer)ho.getTag();
                    int temp = Integer.parseInt(test.get(position).getPrice());
                    Log.e("temp","price = "+temp*value);
                    price.setText(temp * value+"");
                }
            }
        });


        return itemView;
    }

}
