package com.example.car.zhaochefragment;

import android.annotation.TargetApi;
import android.content.Context;
import android.gesture.GestureOverlayView;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.car.R;
import com.example.car.activity.MainActivity;
import com.example.car.adapter.PinYinAdapter;
import com.example.car.bean.Content;
import com.example.car.view.PinnedHeaderListView;
import com.example.car.view.SideBar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PinPaiFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PinPaiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PinPaiFragment extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private ArrayList<Content> dataList;
    private PinnedHeaderListView pinListView;
    private GestureDetector gestureDetector;
    private LinearLayout ll;
    private LinearLayout linearLayout;

    public PinPaiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PinPaiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PinPaiFragment newInstance(String param1, String param2) {
        PinPaiFragment fragment = new PinPaiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        // 初始化数据
        dataList = new ArrayList<Content>();
        for (int i = 0; i < 100; i++)
        {
            Content m;
            if (i < 10)
                m = new Content("A", "大众" + i);
            else if (i < 20)
                m = new Content("X", "别克" + i);
            else if (i < 30)
                m = new Content("C", "宝马" + i);
            else if (i < 40)
                m = new Content("D", "比亚迪" + i);
            else if (i < 50)
                m = new Content("E", "奔驰" + i);
            else if (i < 60)
                m = new Content("F", "奥迪" + i);
            else if (i < 70)
                m = new Content("G", "雪佛兰" + i);
            else if (i < 80)
                m = new Content("H", "长安" + i);
            else
                m = new Content("I", "奔奔" + i);
            dataList.add(m);
        }
        Collections.sort(dataList, new Comparator<Content>() {
            @Override
            public int compare(Content lhs, Content rhs) {
                return lhs.getLetter().compareTo(rhs.getLetter());
            }
        });
//        ((MainActivity)getActivity()).registerFragmentOnTouchListener(this);
gestureDetector=new GestureDetector(getContext(), onGestureListener);
    }
    private WindowManager windowManager;
    // 提示对话框
    private TextView dialogText;
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ll = (LinearLayout) view.findViewById(R.id.find_brand_llyt_content);
ll.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {

        return gestureDetector.onTouchEvent(event);
    }
});

        linearLayout = (LinearLayout) view.findViewById(R.id.linearlayout);


        pinListView = (PinnedHeaderListView) view.findViewById(R.id.pin_listview);

        PinYinAdapter adapter=new PinYinAdapter(getContext(),view,dataList);
        pinListView.setAdapter(adapter);
        pinListView.setOnScrollListener(adapter);
        pinListView.setPinnedHeaderView(LayoutInflater.from(getContext()).inflate(R.layout.listview__head_pinpai,pinListView,false));
// 初始化提示对话框
        dialogText = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.fragment_find_brand_listview_remind, null);
        dialogText.setVisibility(View.INVISIBLE);
        // 初始化窗口管理器
        windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.TYPE_APPLICATION, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, PixelFormat.TRANSLUCENT);
        // 将提示对话框添加到窗口中
        windowManager.addView(dialogText, lp);

//侧边列表

        SideBar sideBar = (SideBar) view.findViewById(R.id.find_brand_sb);
        sideBar.setVisibility(View.VISIBLE);
        sideBar.setTextView(dialogText);
        sideBar.setListView(pinListView);


        pinListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ll.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.in_from_right));
                ll.setVisibility(View.VISIBLE);
            }
        });






    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pin_pai, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }

    }

    private GestureDetector.OnGestureListener onGestureListener = new GestureDetector.SimpleOnGestureListener()
    {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY)
        {
            // 手势滑动时失去焦点
            linearLayout.setPressed(false);
            linearLayout.setFocusable(false);
            linearLayout.setFocusableInTouchMode(false);

            return super.onScroll(e1, e2, distanceX, distanceY);
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
        {
            float x = e2.getX() - e1.getX();

            // 向右滑动到一定距离时隐藏内容
            if (x > 100)
            {
                ll.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.out_to_right));
                ll.setVisibility(View.GONE);
            }
            return true;
        }
    };


//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

//    @Override
//    public void onPause() {
//        ((MainActivity)getActivity()).unregisterMyOnTouchListener(this);
//        super.onPause();
//    }
}
