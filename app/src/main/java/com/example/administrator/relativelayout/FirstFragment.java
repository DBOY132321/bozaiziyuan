package com.example.administrator.relativelayout;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.relativelayout.R;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.net.URI;
import java.net.URL;

/**
 * Created by Administrator on 2018/3/15.
 */

public class FirstFragment extends Fragment implements View.OnClickListener{
    private RollPagerView rollPV;
    TextView java_tv,android_tv,sql_tv,html_tv,javaee_tv,jsp_tv;


    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.layout_first,container,false);
        rollPV=v.findViewById(R.id.rollPV);
        //设置每个图片的切换时间
        rollPV.setPlayDelay(3000);
        //设置图片的切换动画时间
        rollPV.setAnimationDurtion(500);
        //设置指示器
        rollPV.setHintView(new ColorPointHintView(this.getContext(),getResources().getColor(R.color.colorPrimary), Color.WHITE));
        //设置适配器
        rollPV.setAdapter(new RollPagerAdapter());




        //textview的声明控件
        java_tv=v.findViewById(R.id.java_id);
        android_tv=v.findViewById(R.id.android_id);
        sql_tv=v.findViewById(R.id.sql_id);
        html_tv=v.findViewById(R.id.html_id);
        javaee_tv=v.findViewById(R.id.Python_id);
        jsp_tv=v.findViewById(R.id.jsp_id);

        java_tv.setOnClickListener(this);
        android_tv.setOnClickListener(this);
        sql_tv.setOnClickListener(this);
        html_tv.setOnClickListener(this);
        javaee_tv.setOnClickListener(this);
        jsp_tv.setOnClickListener(this);
        return v;
    }
    //设置textview的点击事件 webview的使用 跳转访问网址
    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.java_id:
//            Uri uri= Uri.parse("http://www.runoob.com/java/java-tutorial.html");
//            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//            startActivity(intent);
            Intent intent =new Intent(getActivity(), IntentFragment.class);
            intent.putExtra("url","http://www.runoob.com/java/java-tutorial.html");
            startActivity(intent);
            break;
        case R.id.android_id:
//            Uri uri1= Uri.parse("http://www.runoob.com/w3cnote/android-tutorial-intro.html");
//            Intent intent1 = new Intent(Intent.ACTION_VIEW, uri1);
//            startActivity(intent1);
            Intent intent1 =new Intent(getActivity(), IntentFragment.class);
            intent1.putExtra("url","http://www.runoob.com/w3cnote/android-tutorial-intro.html");
            startActivity(intent1);
            break;
        case R.id.sql_id:
//            Uri uri2= Uri.parse("http://www.runoob.com/sql/sql-tutorial.html");
//            Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
//            startActivity(intent2);
            Intent intent2 =new Intent(getActivity(), IntentFragment.class);
            intent2.putExtra("url","http://www.runoob.com/sql/sql-tutorial.html");
            startActivity(intent2);
            break;
        case R.id.html_id:
//            Uri uri3= Uri.parse("http://www.runoob.com/html/html-tutorial.html");
//            Intent intent3 = new Intent(Intent.ACTION_VIEW, uri3);
//            startActivity(intent3);
            Intent intent3 =new Intent(getActivity(), IntentFragment.class);
            intent3.putExtra("url","http://www.runoob.com/html/html-tutorial.html");
            startActivity(intent3);
            break;
        case R.id.Python_id:
//            Uri uri4= Uri.parse("http://www.runoob.com/python/python-tutorial.html");
//            Intent intent4 = new Intent(Intent.ACTION_VIEW, uri4);
//            startActivity(intent4);
            Intent intent4 =new Intent(getActivity(), IntentFragment.class);
            intent4.putExtra("url","http://www.runoob.com/python/python-tutorial.html");
            startActivity(intent4);
            break;
        case R.id.jsp_id:
//            Uri uri5= Uri.parse("http://www.runoob.com/jsp/jsp-tutorial.html");
//            Intent intent5 = new Intent(Intent.ACTION_VIEW, uri5);
//            startActivity(intent5);
            Intent intent5 =new Intent(getActivity(), IntentFragment.class);
            intent5.putExtra("url","http://www.runoob.com/jsp/jsp-tutorial.html");
            startActivity(intent5);
            break;



    }
    }

    private class RollPagerAdapter extends StaticPagerAdapter {
        private int images[]={
                R.mipmap.one,
                R.mipmap.two,
                R.mipmap.three,
                R.mipmap.four

        };
        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view=new ImageView(container.getContext());
            view.setImageResource(images[position]);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //设置轮播图的点击事件
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(getActivity(), IntentFragment.class);
                    intent.putExtra("url","https://github.com/DBOY132321/MyDemo");
                    startActivity(intent);
                }
            });
            return view;
        }

        @Override
        public int getCount() {
            return images.length;
        }
    }





}
