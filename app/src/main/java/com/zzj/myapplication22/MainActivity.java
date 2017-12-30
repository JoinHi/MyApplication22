package com.zzj.myapplication22;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ScrollImageView scrollImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new MyAdapter());
    }


    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 50;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View imageLayout = getLayoutInflater().inflate(R.layout.item_image, null);
            scrollImageView = imageLayout.findViewById(R.id.image);
            switch (position%4) {
                case 0:
                    scrollImageView.setImageResource(R.mipmap.test1);
                    break;
                case 1:
                    scrollImageView.setImageResource(R.mipmap.test2);
                    break;
                case 2:
                    scrollImageView.setImageResource(R.mipmap.test3);
                    break;
                case 3:
                    scrollImageView.setImageResource(R.mipmap.test4);
                    break;
                default:
                    imageLayout = getLayoutInflater().inflate(R.layout.item_text, null);
                    break;
            }
            return imageLayout;

        }
    }
}
