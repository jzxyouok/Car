package com.example.car.AsyncTask;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.car.R;

import com.example.car.activity.MainActivity;
import com.example.car.bean.DataBean;
import com.example.car.viewHolder.ItmeYaowenHolder;
import com.example.car.zixunfragment.YaoWenFragment;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by 11355 on 2016/5/26.
 */
public class YaoWenAsyncTask extends AsyncTask {
private boolean isStop=false;
    private final Context context;
    private final View view;
    private URL url;
    private HttpURLConnection con;
    private String result1;
    private int i = 0;

    private List<DataBean> data;
    private List<DataBean> yaoWenBeenData;
    private ListView yaowenlist;
    private ImageLoader imageLoader;
    private DisplayImageOptions options;
   private View footView ;
    private View inflate;


    public YaoWenAsyncTask(Context context, View view) {
        this.context = context;
        this.view = view;
        footView =  LayoutInflater.from(context).inflate(R.layout.foot, null);
    }

    @Override
    protected Object doInBackground(Object[] params) {
//        RequestParams requestParams = new RequestParams("https://raw.githubusercontent.com/SamSongShan/Car/master/Carjson.json");
//        // requestParams.setSslSocketFactory(...);
//        requestParams.addQueryStringParameter("wd", "xUtils");
//        result1 = null;
//        x.http().get(requestParams, new Callback.CommonCallback<String>() {
//            @Override
//            public void onSuccess(String result) {
//
//
//                result1 = result;
//                System.out.println(result1);
//                System.out.println("1222222222222222222222222222222222222222222");
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//                System.out.println("1222222222222222222222222222222222222222222");
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//                System.out.println("1222222222222222222222222222222222222222222");
//            }
//
//            @Override
//            public void onFinished() {
//                System.out.println("1222222222222222222222222222222222222222222");
//            }
//        });
        BufferedReader bufferedReader = null;
        StringBuffer sb = new StringBuffer();
        String line = null;
        try {

            url = new URL("https://raw.githubusercontent.com/SamSongShan/Car/master/Carjson.json");
            con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(50000);
            con.setRequestMethod("GET");
            con.setReadTimeout(50000);
            con.connect();
            if (con.getResponseCode() == 200) {
                bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }

        return sb.toString();

    }
    Handler handler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            yaowenlist.deferNotifyDataSetChanged();
            yaowenlist.removeFooterView(footView);

        }
    };

    public void onloading() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                int j=i;
               try {
                  Thread.sleep(1000);
                   for (; j < i + 7 || j >yaoWenBeenData.size(); j++) {

                       data.add(yaoWenBeenData.get(j));

                   }
                  handler.sendEmptyMessage(0);


               }catch (Exception e){

               }

            }
        }).start();

    }

    public void initImageLoader(Context context) {
        // This configuration tuning is custom. You can tune every option, you may tune some of them,
        // or you can create default configuration by
        //  ImageLoaderConfiguration.createDefault(this);
        // method.
        // imageLoader初始化
      //  imageLoader.init(ImageLoaderConfiguration.createDefault(context));

        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
        config.threadPriority(Thread.NORM_PRIORITY - 2);
        config.denyCacheImageMultipleSizesInMemory();
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        config.writeDebugLogs(); // Remove for release app

        //Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config.build());


        options = new DisplayImageOptions.Builder()
//                .showImageOnLoading(R.drawable.ic_stub)
//                .showImageForEmptyUri(R.drawable.ic_empty)
//                .showImageOnFail(R.drawable.ic_error)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .displayer(new RoundedBitmapDisplayer(20))
                .build();
    }

    @Override
    protected void onPostExecute(Object o) {

        System.out.println(o);
        Gson gson = new Gson();
        final DataBean yaoWenBean = gson.fromJson(String.valueOf(o), DataBean.class);
        System.out.println("11111111111111111111111111111111");

        imageLoader = ImageLoader.getInstance();
        initImageLoader(context);
        // imageLoader.init(ImageLoaderConfiguration.createDefault(context));
        data = new ArrayList<>();
        yaoWenBeenData = yaoWenBean.getYaoWenBean();
        onloading();
        System.out.println(data.size());
        yaowenlist = (ListView) view.findViewById(R.id.yaowen_list);
        inflate = LayoutInflater.from(context).inflate(R.layout.photo_viewpage, null);

        yaowenlist.addHeaderView(inflate);
        yaowenlist.setAdapter(new BaseAdapter() {

            private ItmeYaowenHolder holder;

            @Override
            public int getCount() {
                return data.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {


                if (convertView == null) {
                    convertView = LayoutInflater.from(context).inflate(R.layout.itme_yaowen, null);

                    holder = new ItmeYaowenHolder(convertView);
                    convertView.setTag(holder);
                } else {
                    holder = (ItmeYaowenHolder) convertView.getTag();
                }


                holder.getItemTvTitle().setText(data.get(position).getTitle());
                imageLoader.displayImage(data.get(position).getCover_image(), holder.getItemIvImg(), options);

                return convertView;
            }
        });

        yaowenlist.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (isStop&&scrollState==SCROLL_STATE_IDLE){

                    yaowenlist.addFooterView(footView);
                    i = i + 7;
                    System.out.println("2222222222222222222222222222222222222222222222222222222222222");
                    onloading();

                }
                isStop=false;
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (visibleItemCount + firstVisibleItem == totalItemCount && totalItemCount > 0) {
                    isStop=true;


                }
            }

        });

        super.onPostExecute(o);
    }
}
