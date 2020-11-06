package com.xf.tvamplification;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.xf.tvamplification.databinding.ActivityCeshiBinding;

import java.text.SimpleDateFormat;

public class CeshiActivity extends AppCompatActivity {

    private ActivityCeshiBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityCeshiBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        initEvent();

        //需要焦点
        mBinding.imageBtn1.requestFocus();
        mBinding.imageBtn1.requestFocusFromTouch();
        mBinding.imageBtn1.setFocusable(true);
    }

    private void initEvent() {
        mBinding.imageBtn1.setOnClickListener(v -> {
            Toast.makeText(this, "点击了", Toast.LENGTH_LONG).show();
        });

        long currentTime = System.currentTimeMillis();
        String timeNow = new SimpleDateFormat("HH:mm").format(currentTime);
        mBinding.tvTime.setText(timeNow);

        for (int i = 0; i < mBinding.relaBtn.getChildCount(); i++) {
            final ImageView imageButton = (ImageView) mBinding.relaBtn.getChildAt(i);
            imageButton.setOnFocusChangeListener((view, b) -> {
                Log.e("xf", "initEvent: " + view.getTag().toString() + " focus = " + b);
                if (b) {
                    view.setScaleX(1.4f);
                    view.setScaleY(1.4f);
                    imageButton.bringToFront();
                } else {
                    view.setScaleX(1.0f);
                    view.setScaleY(1.0f);
                }
            });
        }
    }
}