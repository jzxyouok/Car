package com.example.car.zhaochefragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.car.R;
import com.example.car.adapter.PinYinAdapter;
import com.example.car.bean.Content;
import com.example.car.view.PinnedHeaderListView;

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
public class PinPaiFragment extends Fragment {
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

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        pinListView = (PinnedHeaderListView) view.findViewById(R.id.pin_listview);
        PinYinAdapter adapter=new PinYinAdapter(getContext(),view,dataList);
        pinListView.setAdapter(adapter);
        pinListView.setOnScrollListener(adapter);
        pinListView.setPinnedHeaderView(LayoutInflater.from(getContext()).inflate(R.layout.listview__head_pinpai,pinListView,false));
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
}
