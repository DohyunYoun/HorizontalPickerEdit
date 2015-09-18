package tndn.app.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MyAdapter ad = null;
    ListView lv = null;
    ArrayList<Item> test;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         lv = (ListView)findViewById(R.id.lv);
        test = new ArrayList<Item>();
        for (int i = 1; i < 5; i++) {
            Item it = new Item();
            it.setName("name " + i);
            it.setPrice(i + "000");
            test.add(it);
        }


        ad = new MyAdapter(this, test);
        lv.setAdapter(ad);

    }

}
