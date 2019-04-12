package com.rushdroid.myapplication.activity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rushdroid.myapplication.NonSwipeableViewPager;
import com.rushdroid.myapplication.R;
import com.rushdroid.myapplication.fragment.rootFragment.BaseRootFragment;
import com.rushdroid.myapplication.fragment.rootFragment.DashBoardRootFragment;
import com.rushdroid.myapplication.fragment.rootFragment.HomeRootFragment;
import com.rushdroid.myapplication.fragment.rootFragment.NotificationRootFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.viewPager)
    NonSwipeableViewPager viewPager;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    @BindView(R.id.container)
    ConstraintLayout container;
    private static final BaseRootFragment[] ALL_FRAGMENT =
            {
                    new HomeRootFragment(),
                    new DashBoardRootFragment(),
                    new NotificationRootFragment(),
            };
    private HomeRootFragment homeRootFragment = new HomeRootFragment();
    private NotificationRootFragment notificationRootFragment = new NotificationRootFragment();
    private DashBoardRootFragment dashBoardRootFragment = new DashBoardRootFragment();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewPager.setAdapter(new FragmentAdapter((getSupportFragmentManager())));
        viewPager.setOffscreenPageLimit(3);
    }


    public class FragmentAdapter extends FragmentStatePagerAdapter {
        FragmentAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return ALL_FRAGMENT.length;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return ALL_FRAGMENT[position];
        }
    }


    @Override
    public void onBackPressed() {
        if (!ALL_FRAGMENT[viewPager.getCurrentItem()].getNavController().popBackStack()) {
            finish();
        }
    }
}
