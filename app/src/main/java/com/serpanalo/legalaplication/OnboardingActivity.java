package com.serpanalo.legalaplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.serpanalo.legalaplication.model.Constants;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OnboardingActivity extends AppCompatActivity {

        private onBoardingPageAdapter onBoardingPageAdapter;
        private TextView[] dots;
        private int[] layouts;

        @BindView(R.id.view_pager)
        ViewPager viewPager;
        @BindView(R.id.layoutDots)
        LinearLayout dotsLayout;

        @OnClick(R.id.btn_skip)
        public void startMainActivity() {
            launchHomeScreen();
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getSupportActionBar().hide();

            if (Build.VERSION.SDK_INT >= 21) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            }

            setContentView(R.layout.activity_onboarding);

            ButterKnife.bind(this);
            setupUI();
            setupAdapter();

        }


        public void setupUI() {

            layouts = new int[]{
                    R.layout.onboarding_slide1,
                    R.layout.onboarding_slide2};

            addBottomDots(0);
            changeStatusBarColor();
        }


        public void setupAdapter() {

            onBoardingPageAdapter = new onBoardingPageAdapter();
            viewPager.setAdapter(onBoardingPageAdapter);
            viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        }


        private void addBottomDots(int currentPage) {
            dots = new TextView[layouts.length];

            int colorInactive = getResources().getColor(R.color.cardview_dark_background);
            int colorActive = getResources().getColor(R.color.start_button);

            dotsLayout.removeAllViews();
            for (int i = 0; i < dots.length; i++) {
                dots[i] = new TextView(this);
                dots[i].setText(Html.fromHtml("&#8226;"));
                dots[i].setTextSize(35);
                dots[i].setTextColor(colorInactive);
                dotsLayout.addView(dots[i]);
            }

            if (dots.length > 0) {
                dots[currentPage].setTextColor(colorActive);
            }
        }

        private int getItem(int i) {
            return viewPager.getCurrentItem() + i;
        }

        private void launchHomeScreen() {
            Utils.saveBooleanValue(this, Constants.FIRST_TIME, false);
            Intent intent = new Intent(this, DispatchActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        //	viewpager change listener
        ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        };

        private void changeStatusBarColor() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            }
        }

        /**
         * View pager adapter
         */
        public class onBoardingPageAdapter extends PagerAdapter {
            private LayoutInflater layoutInflater;

            public onBoardingPageAdapter() {
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = layoutInflater.inflate(layouts[position], container, false);
                container.addView(view);

                return view;
            }

            @Override
            public int getCount() {
                return layouts.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object obj) {
                return view == obj;
            }


            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                View view = (View) object;
                container.removeView(view);
            }
        }
}
