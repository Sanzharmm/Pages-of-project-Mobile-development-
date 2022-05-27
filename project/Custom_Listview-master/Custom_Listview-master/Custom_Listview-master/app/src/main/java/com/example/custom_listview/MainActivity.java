package com.example.custom_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;


import com.example.custom_listview.databinding.ActivityMainBinding;
import com.example.custom_listview.databinding.ActivityUserBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageId = {R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc,
                R.drawable.abc,R.drawable.abc,R.drawable.abc,R.drawable.abc};
        String[] name = {"Минимум",
                "Стандарт",
                "Премиум",
                "СуперГолд",
                "Серебро",
                "СуперПремиум",
                "Студент",
                "Ученик",
                "Учитель"};
        String[] location = {"Все","Бишкек","Бишкек","Бишкек, Ош","Все",
                "Все","Все","Все","Бишкек"};
        String[] speed = {"50mb/s","80mb/s","100mb/s","150mb/s","90mb/s",
                "400mb/s","100mb/s","100mb/s","100mb/s"};
        String[] phoneNo = {"50mb/s","80mb/s","100mb/s","150mb/s","90mb/s",
                "400mb/s","100mb/s","100mb/s","100mb/s"};
        String[] country = {"Все","Бишкек","Бишкек","Бишкек, Ош","Все",
                "Все","Все","Все","Бишкек"};

        ArrayList<User> userArrayList = new ArrayList<>();

        for(int i = 0;i< imageId.length;i++){

            User user = new User(name[i],speed[i],location[i],phoneNo[i],country[i],imageId[i]);
            userArrayList.add(user);

        }


        ListAdapter listAdapter = new ListAdapter(MainActivity.this,userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this,UserActivity.class);
                i.putExtra("name",name[position]);
                i.putExtra("phone",phoneNo[position]);
                i.putExtra("country",country[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);

            }
        });

    }
}