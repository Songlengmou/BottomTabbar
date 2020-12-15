package com.anningtex.bottomtabbar.four;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.anningtex.bottomtabbar.R;

/**
 * @author Administrator
 */
public class FourActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioButton mRb1, mRb2, mRb3;

    private FragmentManager fManager;
    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private ThreeFragment threeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        initView();
        drawableBounds();
    }

    private void initView() {
        mRb1 = findViewById(R.id.rb1);
        mRb2 = findViewById(R.id.rb2);
        mRb3 = findViewById(R.id.rb3);
        mRb1.setOnClickListener(this);
        mRb2.setOnClickListener(this);
        mRb3.setOnClickListener(this);
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

        fManager = getSupportFragmentManager();
        setChoiceItem(1);
    }

    /**
     * Fragment切换
     */
    private void setChoiceItem(int index) {
        FragmentTransaction transaction = fManager.beginTransaction();
        hideFragments(transaction);
        switch (index) {
            case 1:
                if (oneFragment == null) {
                    oneFragment = new OneFragment();
                    transaction.add(R.id.main_frame_layout, oneFragment);
                } else {
                    transaction.show(oneFragment);
                }
                break;
            case 2:
                if (twoFragment == null) {
                    twoFragment = new TwoFragment();
                    transaction.add(R.id.main_frame_layout, twoFragment);
                } else {
                    transaction.show(twoFragment);
                }
                break;
            case 3:
                if (threeFragment == null) {
                    threeFragment = new ThreeFragment();
                    transaction.add(R.id.main_frame_layout, threeFragment);
                } else {
                    transaction.show(threeFragment);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }

    /**
     * 隐藏片段
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (oneFragment != null) {
            transaction.hide(oneFragment);
        }
        if (twoFragment != null) {
            transaction.hide(twoFragment);
        }
        if (threeFragment != null) {
            transaction.hide(threeFragment);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb1:
                setChoiceItem(1);
                break;
            case R.id.rb2:
                setChoiceItem(2);
                break;
            case R.id.rb3:
                setChoiceItem(3);
                break;
            default:
                break;
        }
    }
}