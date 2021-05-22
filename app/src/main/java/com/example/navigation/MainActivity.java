package com.example.navigation;


import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navigation.ui.dashboard.DashboardFragment;
import com.example.navigation.ui.home.HomeFragment;
import com.example.navigation.ui.home.InfoFragment;
import com.example.navigation.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
//import android.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.example.navigation.R.id.calendarView;

public class  MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;
    List<Fragment> list;
    MenuItem menuItem;

    public static final String[] TITLES = {
            "人工智能",
            "大数据",
            "区块链",
            "物联网",
            "云计算",
            "AR"
    };
    public static final String[] DETAILS = {
            "人工智能内容",
            "大数据内容",
            "区块链内容",
            "物联网内容",
            "云计算内容",
            "AR内容"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.fragment_class);


        viewPager = findViewById(R.id.viewPager);
        bottomNavigationView = findViewById(R.id.nav_view);

        list = new ArrayList<Fragment>();
        list.add(new HomeFragment());
        list.add(new DashboardFragment());
        //list.add(new DetailFragment());
        list.add(new NotificationsFragment());
        list.add(new InfoFragment());

        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager(),list));


        //class界面监听器
        View view= this.getLayoutInflater().inflate(R.layout.fragment_class,null);
        ListView listView = view.findViewById(R.id.list);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_single_choice,TITLES);
        //ArrayAdapter<CharSequence> arrayAdapter = new ArrayAdapter.createFromResource(this,R.array.TITLES,android.R.layout.simple_list_item_checked);
        listView.setAdapter(arrayAdapter);
        final TextView textView = view.findViewById(R.id.detail);
        textView.setText("no");
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        textView.setText(DETAILS[0]);
                        break;
                    case 1:
                        textView.setText(DETAILS[1]);
                        break;
                    case 2:
                        textView.setText(DETAILS[2]);
                        break;
                    case 3:
                        textView.setText(DETAILS[3]);
                        break;
                    case 4:
                        textView.setText(DETAILS[4]);
                        break;
                    case 5:
                        textView.setText(DETAILS[5]);
                        break;
                }
            }
        });

        //HOME页面获取选定的日期
        final View view1 = this.getLayoutInflater().inflate(R.layout.fragment_home,null);
        final CalendarView date = view1.findViewById(calendarView);
        date.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                TextView textView = view1.findViewById(R.id.year);
                textView.setText(year);
                TextView textView1 = view1.findViewById(R.id.day);
                //使用java 中Calender 获取星期几
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(date.getDate());
                textView1.setText(calendar.get(Calendar.DAY_OF_WEEK)+","+month+" "+dayOfMonth);
            }
        });

        //点击底部导航项，显示对应的页面
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_home:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.navigation_classic:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.navigation_shopping:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.navigation_info:
                        viewPager.setCurrentItem(3);
                        break;


                }

                return true;
            }
        });

        //页面左右滑动时，让底部的导航项和显示的页面保持一致
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(menuItem==null){
                    menuItem = bottomNavigationView.getMenu().getItem(0);
                }
                menuItem.setChecked(false);
                menuItem=bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




    }

//    //内部类
//    public static class DetailActivity extends Activity{
//        @Override
//        protected void onCreate(@Nullable Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//
//            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
//                finish();
//                return;
//            }
//
//            if(savedInstanceState == null){
//                DetailFragment details = new DetailFragment();
//                details.setArguments(getIntent().getExtras());
//                getFragmentManager().beginTransaction().add(android.R.id.content,details).commit();
//            }
//        }
//    }

    private class MyAdapter extends FragmentPagerAdapter
    {
        List list;
        public MyAdapter(@NonNull FragmentManager fm, List list) {
            super(fm);
            this.list=list;
        }

        @NonNull
        @Override
        public Fragment getItem(int position)

        {
            return (Fragment) list.get(position);
        }

        @Override
        public int getCount()
        {
            return list.size();
        }
    }




}
