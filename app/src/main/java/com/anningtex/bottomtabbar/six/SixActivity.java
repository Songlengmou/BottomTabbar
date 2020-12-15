package com.anningtex.bottomtabbar.six;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.anningtex.bottomtabbar.R;
import com.anningtex.bottomtabbar.four.OneFragment;
import com.anningtex.bottomtabbar.four.ThreeFragment;
import com.anningtex.bottomtabbar.four.TwoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.google.android.material.bottomnavigation.LabelVisibilityMode.LABEL_VISIBILITY_LABELED;

/**
 * @author Administrator
 */
public class SixActivity extends AppCompatActivity {
    @BindView(R.id.main_fragment_container)
    CustomViewPager mainFragmentContainer;
    @BindView(R.id.main_bottom_nav)
    BottomNavigationView mMainBottomNav;

    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mMainBottomNav.setLabelVisibilityMode(LABEL_VISIBILITY_LABELED);
        Menu menu = mMainBottomNav.getMenu();
        menu.add(0, 0, 0, "one");
        mMainBottomNav.getMenu().getItem(0).setIcon(R.mipmap.ic_launcher);
        menu.add(0, 1, 1, "two");
        mMainBottomNav.getMenu().getItem(1).setIcon(R.mipmap.ic_launcher);
        menu.add(0, 2, 2, "three");
        mMainBottomNav.getMenu().getItem(2).setIcon(R.mipmap.ic_launcher);

        fragmentList.add(new OneFragment());
        fragmentList.add(new TwoFragment());
        fragmentList.add(new ThreeFragment());

        setupBottomNavigationView();
        TabPagerAdapter pagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), null, fragmentList);
        mainFragmentContainer.setAdapter(pagerAdapter);
        mainFragmentContainer.setCurrentItem(0);
        mainFragmentContainer.setOffscreenPageLimit(3);
    }

    private void setupBottomNavigationView() {
        mMainBottomNav.setOnNavigationItemSelectedListener(item -> {
            switch (item.getGroupId()) {
                case 0:
                case 1:
                case 2:
                case 3:
                    mainFragmentContainer.setCurrentItem(item.getItemId());
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + item.getItemId());
            }
            return true;
        });
    }
}