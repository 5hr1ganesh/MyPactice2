package com.dharamveer.mypractice2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    GridView gridView;
    Integer[] imageId = {
            R.drawable.arcticfox, R.drawable.lolopard, R.drawable.redpanda, R.drawable.wolfie
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        gridView = (GridView) findViewById(R.id.GGridview);
        gridView.setAdapter(new ImageAdapterGridView(this));
        
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            if (position == 0)
                Toast.makeText(MainActivity.this, "ArcticFox", Toast.LENGTH_SHORT).show();
            else if (position == 1)
                Toast.makeText(MainActivity.this, "Leopard", Toast.LENGTH_SHORT).show();
            else if (position == 2)
                Toast.makeText(MainActivity.this, "Red Panda", Toast.LENGTH_SHORT).show();
            else if (position == 3)
                Toast.makeText(MainActivity.this, "Wolf", Toast.LENGTH_SHORT).show();
        });
        

    }


    private class ImageAdapterGridView extends BaseAdapter {
        Context c;
        public ImageAdapterGridView(MainActivity mainActivity) {
            c = mainActivity;
        }


        @Override
        public int getCount() {
            return imageId.length;
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
            ImageView imageView;
            if (convertView == null){
                imageView = new ImageView(c);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(500,500));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

                imageView.setPadding(20, 20, 20, 20);
            }
            else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(imageId[position]);
            return imageView;
        }
    }
}