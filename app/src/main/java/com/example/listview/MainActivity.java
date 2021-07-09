package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //adapter class
    ArrayList<AdapterItems>    listnewsData = new ArrayList<AdapterItems>();
    MyCustomAdapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=findViewById(R.id.listView);
        //add data and view it
        listnewsData.add(new AdapterItems(R.drawable.one,"developer"," develop apps"));
        listnewsData.add(new AdapterItems(R.drawable.one,"marketman"," market"));
        listnewsData.add(new AdapterItems(R.drawable.one,"doctor"," patient"));


        myadapter=new MyCustomAdapter(listnewsData);
        listView.setAdapter(myadapter);
        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final AdapterItems s=listnewsData.get(position);
                TextView textViewJobTitle=view.findViewById(R.id.titleTextView);
                TextView textViewDesc=view.findViewById(R.id.descTextView);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private class MyCustomAdapter extends BaseAdapter {
        public  ArrayList<AdapterItems>  listnewsDataAdapter ;

        public MyCustomAdapter(ArrayList<AdapterItems>  listnewsDataAdpater) {
            this.listnewsDataAdapter=listnewsDataAdpater;
        }


        @Override
        public int getCount() {
            return listnewsDataAdapter.size();
        }

        @Override
        public String getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater mInflater = getLayoutInflater();
            View myView = mInflater.inflate(R.layout.layout_ticket, null);

            final   AdapterItems s = listnewsDataAdapter.get(position);

            ImageView imageView=myView.findViewById(R.id.imageViewId);
            imageView.setImageResource(s.id);

            TextView title=( TextView)myView.findViewById(R.id.titleTextView);
            title.setText("Job: "+s.title);
            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Your job is "+s.title, Toast.LENGTH_LONG).show();
                }
            });
            TextView desc=( TextView)myView.findViewById(R.id.descTextView);
            desc.setText("Description: "+s.description);

            return myView;
        }

    }
}