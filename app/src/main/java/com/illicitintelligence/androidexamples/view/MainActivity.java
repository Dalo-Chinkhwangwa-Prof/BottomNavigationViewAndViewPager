package com.illicitintelligence.androidexamples.view;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.illicitintelligence.androidexamples.R;
import com.illicitintelligence.androidexamples.adapter.HomeFragmentAdapter;
import com.illicitintelligence.androidexamples.util.MainSingleton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    MainSingleton mainSingleton = MainSingleton.getInstance();

    @BindView(R.id.main_viewpager)
    ViewPager mainViewPager;

    @BindView(R.id.main_bottom_navigationview)
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mainViewPager.setAdapter(new HomeFragmentAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT));
        mainViewPager.addOnPageChangeListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.incoming_menu_item:
                            mainViewPager.setCurrentItem(0, true);
                        break;

                    case R.id.outgoing_menu_item:
                        mainViewPager.setCurrentItem(1, true);
                        break;

                    case R.id.missed_menu_item:
                        mainViewPager.setCurrentItem(2, true);
                        break;
                }

                return true;
            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("TAG_X", "onPageSelected : "+position);
        switch(position){
            case 0:
                bottomNavigationView.setSelectedItemId(R.id.incoming_menu_item);
                break;
            case 1:
                bottomNavigationView.setSelectedItemId(R.id.outgoing_menu_item);
                break;
            case 2:
                bottomNavigationView.setSelectedItemId(R.id.missed_menu_item);
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
