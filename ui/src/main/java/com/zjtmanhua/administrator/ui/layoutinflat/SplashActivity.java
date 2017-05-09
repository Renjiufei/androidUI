package com.zjtmanhua.administrator.ui.layoutinflat;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;

import com.zjtmanhua.administrator.ui.R;

/**
 * 启动页动画示例
 */

public class SplashActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ParallaxContainer container = (ParallaxContainer) findViewById(R.id.parallax_container);
        container.setUp(new int[]{
                R.layout.view_intro_1,
                R.layout.view_intro_2,
                R.layout.view_intro_3,
                R.layout.view_intro_4,
                R.layout.view_intro_5,
                R.layout.view_login
        });

        //设置动画
        ImageView iv_man = (ImageView) findViewById(R.id.iv_man);
        iv_man.setBackgroundResource(R.drawable.man_run);
        container.setIv_man(iv_man);

    }


}
