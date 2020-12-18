package com.anningtex.bottomtabbar.eight;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author Administrator
 */
public class TabFragment extends Fragment {
    public static final String CONTENT = "content";
    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mTextView = new TextView(getActivity());
        mTextView.setGravity(Gravity.CENTER);
        String content = getArguments().getString(CONTENT);
        mTextView.setText(content);
        return mTextView;
    }
}
