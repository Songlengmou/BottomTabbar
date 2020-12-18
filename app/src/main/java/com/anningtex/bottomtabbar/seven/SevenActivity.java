package com.anningtex.bottomtabbar.seven;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.anningtex.bottomtabbar.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Administrator
 */
public class SevenActivity extends AppCompatActivity {
    @BindView(R.id.rg)
    RadioGroup mRg;
    @BindView(R.id.rb1)
    RadioButton mRb1;
    @BindView(R.id.rb2)
    RadioButton mRb2;
    @BindView(R.id.rb3)
    RadioButton mRb3;
    @BindView(R.id.vp)
    ViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven);
        ButterKnife.bind(this);
        drawableBounds();
        initView();
    }

    private void initView() {
        FourAdapter vpAdapter = new FourAdapter(getSupportFragmentManager(), this);
        mVp.setAdapter(vpAdapter);
        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //viewPager切换中 设置rg的显示
                ((RadioButton) mRg.getChildAt(position)).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mRg.setOnCheckedChangeListener((radioGroup, i) -> {
            // 根据点击的id  设置vp当前显示
            int pos;
            if (i == R.id.rb1) {
                pos = 0;
            } else if (i == R.id.rb2) {
                pos = 1;
            } else {
                pos = 2;
            }
            mVp.setCurrentItem(pos);
        });
    }

    private void drawableBounds() {
        Drawable drawable1 = getResources().getDrawable(R.drawable.bottom_tab1);
        Drawable drawable2 = getResources().getDrawable(R.drawable.bottom_tab2);
        Drawable drawable3 = getResources().getDrawable(R.drawable.bottom_tab3);
        //第一个 0 是距左边距离，第二个 0 是距上边距离，35 分别是长宽
        drawable1.setBounds(0, 0, 35, 35);
        drawable2.setBounds(0, 0, 35, 35);
        drawable3.setBounds(0, 0, 35, 35);
        mRb1.setCompoundDrawables(null, drawable1, null, null);
        mRb2.setCompoundDrawables(null, drawable2, null, null);
        mRb3.setCompoundDrawables(null, drawable3, null, null);
    }
}