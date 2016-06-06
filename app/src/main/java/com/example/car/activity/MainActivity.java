package com.example.car.activity;

import android.annotation.TargetApi;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.renderscript.Sampler;
import android.support.design.BuildConfig;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.car.R;
import com.example.car.adapter.ZiXunAdapter;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.xutils.x;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private FrameLayout mfra;
    private View mJiangJia;
    private View mZiXun;
    private View mWenDa;
    private View mWoDe;
    private View mZhaoChe;
    private Fragment ziXunFragment;
    private Fragment fragment;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private FragmentOnTouchListener fragmentOnTouchListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assignViews();
        initevevts();
        if (savedInstanceState == null) {
            ziXunFragment = new ZiXunFragment();
            setFragment(ziXunFragment);
            onclickswitch(R.id.car_llyt_news);

        }

        //mfra.addView(mZiXun);

//        mCarTvNews.setTextColor(getResources().getColor(R.color.selectColor));
//        mCarIvNews.setSelected(true);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        x.Ext.init(getApplication());
        x.Ext.setDebug(BuildConfig.DEBUG);

        //初始化shareSDK

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private LinearLayout mCarLlytNews;
    private ImageView mCarIvNews;
    private TextView mCarTvNews;
    private LinearLayout mCarLlytFind;
    private ImageView mCarIvFind;
    private TextView mCarTvFind;
    private LinearLayout mCarLlytPrice;
    private ImageView mCarIvPrice;
    private TextView mCarTvPrice;
    private LinearLayout mCarLlytQuestion;
    private ImageView mCarIvQuestion;
    private TextView mCarTvQuestion;
    private LinearLayout mCarLlytSelf;
    private ImageView mCarIvSelf;
    private TextView mCarTvSelf;


    private void assignViews() {
        mCarLlytNews = (LinearLayout) findViewById(R.id.car_llyt_news);
        mCarIvNews = (ImageView) findViewById(R.id.car_iv_news);
        mCarTvNews = (TextView) findViewById(R.id.car_tv_news);
        mCarLlytFind = (LinearLayout) findViewById(R.id.car_llyt_find);
        mCarIvFind = (ImageView) findViewById(R.id.car_iv_find);
        mCarTvFind = (TextView) findViewById(R.id.car_tv_find);
        mCarLlytPrice = (LinearLayout) findViewById(R.id.car_llyt_price);
        mCarIvPrice = (ImageView) findViewById(R.id.car_iv_price);
        mCarTvPrice = (TextView) findViewById(R.id.car_tv_price);
        mCarLlytQuestion = (LinearLayout) findViewById(R.id.car_llyt_question);
        mCarIvQuestion = (ImageView) findViewById(R.id.car_iv_question);
        mCarTvQuestion = (TextView) findViewById(R.id.car_tv_question);
        mCarLlytSelf = (LinearLayout) findViewById(R.id.car_llyt_self);
        mCarIvSelf = (ImageView) findViewById(R.id.car_iv_self);
        mCarTvSelf = (TextView) findViewById(R.id.car_tv_self);
        mfra = (FrameLayout) findViewById(R.id.frameLayout);


        LayoutInflater inflater = LayoutInflater.from(this);
        mJiangJia = inflater.inflate(R.layout.fragment_jiang_jia, null);
        mZiXun = inflater.inflate(R.layout.fragment_zi_xun, null);
        mWenDa = inflater.inflate(R.layout.fragment_wen_da, null);
        mWoDe = inflater.inflate(R.layout.fragment_wo_de, null);
        mZhaoChe = inflater.inflate(R.layout.fragment_zhao_che, null);


    }

    private void initevevts() {
        mCarLlytNews.setOnClickListener(this);
        mCarLlytFind.setOnClickListener(this);
        mCarLlytPrice.setOnClickListener(this);
        mCarLlytQuestion.setOnClickListener(this);
        mCarLlytSelf.setOnClickListener(this);

    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();


        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();

        transaction.replace(R.id.frameLayout, this.fragment);
        transaction.commit();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //如果触摸就会触发
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev)
    {
        if (fragmentOnTouchListener != null)
        {
            fragmentOnTouchListener.onTouch(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    public interface FragmentOnTouchListener
    {
        public boolean onTouch(MotionEvent ev);
    }

    public void registerFragmentOnTouchListener(FragmentOnTouchListener fragmentOnTouchListener)
    {
        this.fragmentOnTouchListener = fragmentOnTouchListener;
    }

    public void unregisterMyOnTouchListener(FragmentOnTouchListener myOnTouchListener)
    {
        this.fragmentOnTouchListener = null;
    }

    public void onclickswitch(int choose) {

        switch (choose) {

            case R.id.car_llyt_find:
                ZhaoCheFragment zhaoCheFragment = new ZhaoCheFragment();
                setFragment(zhaoCheFragment);
                mCarTvFind.setTextColor(getResources().getColor(R.color.selectColor));
                mCarIvFind.setSelected(true);
                break;
            case R.id.car_llyt_news:
                ZiXunFragment ziXunFragment = new ZiXunFragment();
                setFragment(ziXunFragment);
                mCarTvNews.setTextColor(getResources().getColor(R.color.selectColor));
                mCarIvNews.setSelected(true);
                break;
            case R.id.car_llyt_question:
                WenDaFragment wenDaFragment = new WenDaFragment();
                setFragment(wenDaFragment);
                mCarTvQuestion.setTextColor(getResources().getColor(R.color.selectColor));
                mCarIvQuestion.setSelected(true);
                break;
            case R.id.car_llyt_price:
                JiangJiaFragment jiangJiaFragment = new JiangJiaFragment();
                setFragment(jiangJiaFragment);
                mCarTvPrice.setTextColor(getResources().getColor(R.color.selectColor));
                mCarIvPrice.setSelected(true);
                break;
            case R.id.car_llyt_self:
                WoDeFragment woDeFragment = new WoDeFragment();
                setFragment(woDeFragment);
                mCarTvSelf.setTextColor(getResources().getColor(R.color.selectColor));
                mCarIvSelf.setSelected(true);

                break;
            default:


                break;

        }

    }

    @Override
    public void onClick(View v) {
        resetImg();
        choose = v.getId();
        onclickswitch(choose);

    }


    private void resetImg() {
        mCarIvFind.setSelected(false);
        mCarIvQuestion.setSelected(false);
        mCarIvSelf.setSelected(false);
        mCarIvPrice.setSelected(false);
        mCarIvNews.setSelected(false);

        mCarTvFind.setTextColor(getResources().getColor(R.color.notselectcolor));
        mCarTvQuestion.setTextColor(getResources().getColor(R.color.notselectcolor));
        mCarTvPrice.setTextColor(getResources().getColor(R.color.notselectcolor));
        mCarTvSelf.setTextColor(getResources().getColor(R.color.notselectcolor));
        mCarTvNews.setTextColor(getResources().getColor(R.color.notselectcolor));

    }

    private boolean isrecycler = false;
    private int choose = -1;

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        outState.putBoolean("isrecycler", true);
        outState.putInt("choose", choose);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        isrecycler = savedInstanceState.getBoolean("isrecycler");
        choose = savedInstanceState.getInt("choose");
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isrecycler) {
            onclickswitch(choose);
        }

    }

    private long firstTime = 0;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 1000) {
            Toast.makeText(this, "再按一次弹出客户端", Toast.LENGTH_LONG).show();
            firstTime = secondTime;
        } else {
            finish();
        }
    }
}
