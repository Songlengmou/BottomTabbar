package com.anningtex.bottomtabbar.three;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.RadioGroup;

import com.anningtex.bottomtabbar.R;
import com.anningtex.bottomtabbar.two.BlankFragment;
import com.anningtex.bottomtabbar.two.TwoActivity;

/**
 * @author Administrator
 */
public class ThreeActivity extends AppCompatActivity {
    private RadioGroup mTabRadioGroup;
    private SparseArray<Fragment> mFragmentSparseArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        initView();
    }

    private void initView() {
        mTabRadioGroup = findViewById(R.id.tabs_rg);
        mFragmentSparseArray = new SparseArray<>();
        mFragmentSparseArray.append(R.id.today_tab, BlankFragment.newInstance("今日"));
        mFragmentSparseArray.append(R.id.record_tab, BlankFragment.newInstance("记录"));
        mFragmentSparseArray.append(R.id.contact_tab, BlankFragment.newInstance("通讯录"));
        mFragmentSparseArray.append(R.id.settings_tab, BlankFragment.newInstance("设置"));
        mTabRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            // 具体的fragment切换逻辑可以根据应用调整，例如使用show()/hide()
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    mFragmentSparseArray.get(checkedId)).commit();
        });
        // 默认显示第一个
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                mFragmentSparseArray.get(R.id.today_tab)).commit();
        findViewById(R.id.sign_iv).setOnClickListener(v -> startActivity(new Intent(ThreeActivity.this, TwoActivity.class)));
    }
}