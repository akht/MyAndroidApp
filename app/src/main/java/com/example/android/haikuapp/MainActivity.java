package com.example.android.haikuapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.touch);
                view.startAnimation(animation);
                Snackbar.make(view, "Animated FAB", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();


        String[] haikuArray = {
                "古池や 蛙飛こむ 水のおと,松尾芭蕉",
                "閑さや 岩にしみ入る 蝉の声,松尾芭蕉",
                "柿くへば 鐘が鳴るなり 法隆寺,正岡子規",
                "夏草や 兵共が ゆめの跡,松尾芭蕉",
                "秋深き 隣は何を する人ぞ,松尾芭蕉",
                "海に出て 木枯らし帰る ところなし,山口誓子",
                "目には青葉 山ほととぎす 初鰹,山口素堂",
                "菜の花や 月は東に 日は西に,与謝蕪村",
                "五月雨を 集めて早し 最上川,松尾芭蕉",
                "露の世は 露の世ながら さりながら,小林一茶",
                "念力の ゆるめば死ぬる 大暑かな,村上鬼城",
                "この道や 行く人なしに 秋の暮れ,松尾芭蕉"
        };

        List<HaikuItem> haikuData = new ArrayList<>();
        for (String s : haikuArray) {
            String[] elem = s.split(",");
            HaikuItem item = new HaikuItem();
            item.setHaikuString(elem[0]);
            item.setAuthorString(elem[1]);

            haikuData.add(item);
        }

        HaikuAdapter haikuAdapter = new HaikuAdapter(this);
        haikuAdapter.setHaikuList(haikuData);

        ListView listView = (ListView) findViewById(R.id.listview_haiku);
        listView.setAdapter(haikuAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
