package com.anningtex.bottomtabbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.anningtex.bottomtabbar.eight.EightActivity;
import com.anningtex.bottomtabbar.five.FiveActivity;
import com.anningtex.bottomtabbar.four.FourActivity;
import com.anningtex.bottomtabbar.one.OneActivity;
import com.anningtex.bottomtabbar.seven.SevenActivity;
import com.anningtex.bottomtabbar.six.SixActivity;
import com.anningtex.bottomtabbar.three.ThreeActivity;
import com.anningtex.bottomtabbar.two.TwoActivity;

/**
 * @author Administrator
 * desc:底部导航栏
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnStyle1, mBtnStyle2, mBtnStyle3, mBtnStyle4, mBtnStyle5, mBtnStyle6, mBtnStyle7, mBtnStyle8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnStyle1 = findViewById(R.id.style1_btn);
        mBtnStyle2 = findViewById(R.id.style2_btn);
        mBtnStyle3 = findViewById(R.id.style3_btn);
        mBtnStyle4 = findViewById(R.id.style4_btn);
        mBtnStyle5 = findViewById(R.id.style5_btn);
        mBtnStyle6 = findViewById(R.id.style6_btn);
        mBtnStyle7 = findViewById(R.id.style7_btn);
        mBtnStyle8 = findViewById(R.id.style8_btn);
        mBtnStyle1.setOnClickListener(this);
        mBtnStyle2.setOnClickListener(this);
        mBtnStyle3.setOnClickListener(this);
        mBtnStyle4.setOnClickListener(this);
        mBtnStyle5.setOnClickListener(this);
        mBtnStyle6.setOnClickListener(this);
        mBtnStyle7.setOnClickListener(this);
        mBtnStyle8.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.style1_btn:
                startActivity(new Intent(MainActivity.this, OneActivity.class));
                break;
            case R.id.style2_btn:
                startActivity(new Intent(MainActivity.this, TwoActivity.class));
                break;
            case R.id.style3_btn:
                startActivity(new Intent(MainActivity.this, ThreeActivity.class));
                break;
            case R.id.style4_btn:
                startActivity(new Intent(MainActivity.this, FourActivity.class));
                break;
            case R.id.style5_btn:
                startActivity(new Intent(MainActivity.this, FiveActivity.class));
                break;
            case R.id.style6_btn:
                startActivity(new Intent(MainActivity.this, SixActivity.class));
                break;
            case R.id.style7_btn:
                startActivity(new Intent(MainActivity.this, SevenActivity.class));
                break;
            case R.id.style8_btn:
                startActivity(new Intent(MainActivity.this, EightActivity.class));
                break;
            default:
                break;
        }
    }
}