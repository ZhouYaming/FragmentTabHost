package com.zhouyaming.fragmenttabhost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private FragmentTabHost fragmentTabHost;
    private Class fragmentArray[] = {HomeFragment.class, MyCourseFragment.class, ExamLibFragment.class};
    private String mTabStrArray[] = {"首页", "我的课程", "题库精练"};
    private int mTabImgArray[] = {R.drawable.tab1_home_selector, R.drawable.tab3_my_course_selector, R.drawable.tab2_exam_lib_selector};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        fragmentTabHost.setup(this, getSupportFragmentManager(), R.id.frame_content);
        fragmentTabHost.getTabWidget().setDividerDrawable(null);
        fragmentTabHost.setBackgroundColor(getResources().getColor(R.color.white));

        int count = fragmentArray.length;
        fragmentTabHost.clearAllTabs();
        for (int i = 0; i < count; i++) {
            TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(mTabStrArray[i]).setIndicator(getTabItemView(i));
            fragmentTabHost.addTab(tabSpec, fragmentArray[i], null);
        }
    }
    private View getTabItemView(int index) {
        View view = View.inflate(this, R.layout.tab_item_view, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv);
        imageView.setImageResource(mTabImgArray[index]);
        TextView textView = (TextView) view.findViewById(R.id.tv_tab);
        textView.setText(mTabStrArray[index]);

        return view;
    }
}
