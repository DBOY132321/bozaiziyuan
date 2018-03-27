package com.example.administrator.relativelayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {
     private ViewPager myviewpager;
     private ArrayList<Fragment> fragments;
     private RadioButton btn_first;
    private RadioButton btn_second;
    private RadioButton btn_third;
    private RadioButton btn_four;
    private ImageView cursor;
    float cursorX=0;
    private int[] widthArgs;
    private Button[] btnArgs;//所有按钮的集合

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private  ImageView imageView;

    private double windowsWight;
    private double windowsHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtils.setWindowStatusBarColor(MainActivity.this,R.color.colorPrimary);
        initView();
        initViews();
        navigationView.getChildAt(0).setVerticalScrollBarEnabled(false);
        setListener();
        DisplayMetrics metrics=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        windowsWight=metrics.widthPixels;
        windowsHeight=metrics.heightPixels;
        View leftMenu=findViewById(R.id.navigation_view);
        ViewGroup.LayoutParams left=  leftMenu.getLayoutParams();
        left.height= (int) windowsHeight;
        leftMenu.setLayoutParams(left);
    }
    private void initViews() {
        this.drawerLayout=findViewById(R.id.drawer_layout);
        this.navigationView=findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);
    }

    private void setListener() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_1:
                        break;
                    case R.id.item_2:
                        break;
                    case R.id.item_3:
                        break;
                    case R.id.item_4:
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });


    }
    private void initView() {
        myviewpager=this.findViewById(R.id.myviewpager);
        try {
            Field mScroller = null;
            mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            FixedSpeedScroller scroller = new FixedSpeedScroller( myviewpager.getContext());
            mScroller.set( myviewpager, scroller);
        }catch(NoSuchFieldException e){

        }catch (IllegalArgumentException e){

        }catch (IllegalAccessException e){

        }
        btn_first=this.findViewById(R.id.btn_first);
        btn_second=this.findViewById(R.id.btn_second);
        btn_third=this.findViewById(R.id.btn_third);
        btn_four=this.findViewById(R.id.btn_four);

        btnArgs=new Button[]{btn_first,btn_second,btn_third,btn_four};
        cursor=this.findViewById(R.id.cursor_btn);
        cursor.setBackgroundColor(Color.CYAN);
        myviewpager.addOnPageChangeListener(this);
        imageView=findViewById(R.id.title_menu);

        btn_first.setOnCheckedChangeListener(new InnerOnCheckedChangeListener());
        btn_second.setOnCheckedChangeListener(new InnerOnCheckedChangeListener());
        btn_third.setOnCheckedChangeListener(new InnerOnCheckedChangeListener());
        btn_four.setOnCheckedChangeListener(new InnerOnCheckedChangeListener());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/*");
                intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
                intent.putExtra(Intent.EXTRA_TEXT, "这是波仔的Android项目的分享功能信息，如果有兴趣可以联系波仔下载APP");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(Intent.createChooser(intent,"分享"));


            }
        });
        fragments=new ArrayList<Fragment>();
        fragments.add(new FirstFragment());
        fragments.add(new SecondFragment());
        fragments.add(new ThirdFragment());
        fragments.add(new FourFragment());
        MyFragmentPagerAdapter adapter=new MyFragmentPagerAdapter(getSupportFragmentManager(),fragments);
        myviewpager.setOffscreenPageLimit(5);//大于你的当前fragment个数,滑动页面不会去销毁之前
        myviewpager.setAdapter(adapter);

        resetButtonColor();//重置按钮颜色

        btn_first.setTextColor(Color.parseColor("#48d1cc"));
        btn_first.post(new Runnable() {
            @Override
            public void run() {
                LinearLayout.LayoutParams lp= (LinearLayout.LayoutParams) cursor.getLayoutParams();
                lp.width=btn_first.getWidth()-btn_first.getPaddingLeft()*2;
                cursor.setLayoutParams(lp);
                cursor.setX(btn_first.getPaddingLeft());
            }
        });
        
    }



    private void resetButtonColor() {
        btn_first.setBackgroundColor(Color.parseColor("#DCDCDC"));
        btn_second.setBackgroundColor(Color.parseColor("#DCDCDC"));
        btn_third.setBackgroundColor(Color.parseColor("#DCDCDC"));
        btn_four.setBackgroundColor(Color.parseColor("#DCDCDC"));

        btn_first.setTextColor(Color.BLACK);
        btn_second.setTextColor(Color.BLACK);
        btn_third.setTextColor(Color.BLACK);
        btn_four.setTextColor(Color.BLACK);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (widthArgs==null){
            widthArgs=new int[]{
                    btn_first.getWidth(),
                    btn_second.getWidth(),
                    btn_third.getWidth(),
                    btn_four.getWidth()
            };
        }
        resetButtonColor();//每次滑动首先重置所有按钮颜色
        btnArgs[position].setTextColor(Color.parseColor("#48d1cc"));
        cursorAnim(position);
        ((CompoundButton)btnArgs[position]).setChecked(true);


    }
    public  void cursorAnim(int curItem) {
        cursorX=0;
        LinearLayout.LayoutParams lp= (LinearLayout.LayoutParams) cursor.getLayoutParams();
        lp.width=widthArgs[curItem]-btnArgs[0].getPaddingLeft()*2;
        cursor.setLayoutParams(lp);
        for(int i=0;i<curItem;i++){
            cursorX=cursorX+btnArgs[i].getWidth()+5;
        }
        cursor.setX(cursorX+btnArgs[curItem].getPaddingLeft());









    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
//定义事件的内部类
    private class InnerOnCheckedChangeListener implements CompoundButton.OnCheckedChangeListener {
       //buttonView 表示谁的状态被改变
      //isChecked上面的参数代表的状态是否选中

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
       switch (buttonView.getId()){
           case R.id.btn_first:
           if(isChecked){

               myviewpager.setCurrentItem(0);
               cursorAnim(0);
           }
           break;
           case R.id.btn_second:
           if(isChecked){
               myviewpager.setCurrentItem(1);
               cursorAnim(1);
           }
           break;
           case R.id.btn_third:
           if(isChecked){
               myviewpager.setCurrentItem(2);
               cursorAnim(2);
           }
           break;
           case R.id.btn_four:
               if(isChecked){
                   myviewpager.setCurrentItem(3);
                   cursorAnim(3);
               }
               break;
        default:
            break;
        }
    }


}

}
