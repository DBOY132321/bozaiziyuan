package com.example.administrator.relativelayout;

import android.graphics.Color;
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

import com.example.administrator.relativelayout.R;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

/**
 * Created by Administrator on 2018/3/15.
 */

public class FirstFragment extends Fragment{
    private RollPagerView rollPV;

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
        return v;
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
            return view;
        }

        @Override
        public int getCount() {
            return images.length;
        }
    }




}
