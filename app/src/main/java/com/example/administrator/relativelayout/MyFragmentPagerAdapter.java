package com.example.administrator.relativelayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/15.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    //存储所有的fragment
    private List<Fragment> list;
    public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
//        fm.executePendingTransactions();
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
//可以解决重复加载轮播图的问题？
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }
}
