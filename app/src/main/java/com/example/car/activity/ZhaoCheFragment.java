package com.example.car.activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.example.car.R;
import com.example.car.bean.Content;
import com.example.car.zhaochefragment.JingZhunFragment;
import com.example.car.zhaochefragment.PinPaiFragment;

import java.net.URL;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ZhaoCheFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ZhaoCheFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ZhaoCheFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private Fragment fragment;
    private PinPaiFragment pinPaiFragment;
    private LinearLayout mFragmentFindLLytSwitch;


    public ZhaoCheFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ZhaoCheFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ZhaoCheFragment newInstance(String param1, String param2) {
        ZhaoCheFragment fragment = new ZhaoCheFragment();
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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zhao_che, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }

    }

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

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        assignViews(view);
    }

    private TextView mFragmentFindTvBrand;
    private TextView mFragmentFindTvFilter;
    private ImageView mFragmentFindIvSearch;
    private FrameLayout mFragmentFindFlytContent;

    private void assignViews(View view) {
        mFragmentFindLLytSwitch = (LinearLayout) view.findViewById(R.id.fragment_find_llyt_switch);
        mFragmentFindTvBrand = (TextView) view.findViewById(R.id.fragment_find_tv_brand);
        mFragmentFindTvFilter = (TextView) view.findViewById(R.id.fragment_find_tv_filter);
        mFragmentFindIvSearch = (ImageView) view.findViewById(R.id.fragment_find_iv_search);
        mFragmentFindFlytContent = (FrameLayout) view.findViewById(R.id.fragment_find_flyt_content);
        mFragmentFindTvBrand.setOnClickListener(this);
        mFragmentFindTvFilter.setOnClickListener(this);
        pinPaiFragment = new PinPaiFragment();
        setFragment(pinPaiFragment);

    }


    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
        android.support.v4.app.FragmentManager manager = getFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_find_flyt_content, this.fragment);
        transaction.commit();

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragment_find_tv_brand:
                mFragmentFindLLytSwitch.setBackgroundResource(R.drawable.fragment_find_ic_left);
                        mFragmentFindTvBrand.setTextColor(getResources().getColor(R.color.switchChoose));
                        mFragmentFindTvFilter.setTextColor(getResources().getColor(R.color.switchNotChoose));
               PinPaiFragment pinPaiFragment=new PinPaiFragment();
                setFragment(pinPaiFragment);
                break;
            case R.id.fragment_find_tv_filter:
                mFragmentFindLLytSwitch.setBackgroundResource(R.drawable.fragment_find_ic_right);
                mFragmentFindTvBrand.setTextColor(getResources().getColor(R.color.switchNotChoose));
                mFragmentFindTvFilter.setTextColor(getResources().getColor(R.color.switchChoose));
                JingZhunFragment jingZhunFragment = new JingZhunFragment();
                setFragment(jingZhunFragment);
                break;
        }
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
}
