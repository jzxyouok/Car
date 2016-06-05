package com.example.car.zhaochefragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.car.R;

import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link JZBianSuXiangFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link JZBianSuXiangFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JZBianSuXiangFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private LinearLayout choose;
    private View inflater;

    public JZBianSuXiangFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JZBianSuXiangFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JZBianSuXiangFragment newInstance(String param1, String param2) {
        JZBianSuXiangFragment fragment = new JZBianSuXiangFragment();
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
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_jing_zhun, null);
        choose = (LinearLayout) view.findViewById(R.id.find_filter_llyt_choosed);
        inflater = LayoutInflater.from(getContext()).inflate(R.layout.fragment_find_filter_add_main, null);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_jzbian_su_xiang, container, false);
        assignViews(inflate);
        // Inflate the layout for this fragment
        return inflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    private Button mFragmentFindBianBtnBian1;
    private Button mFragmentFindBianBtnBian2;
    private Button mFragmentFindBianBtnBian3;

    private void assignViews(View view) {

        mFragmentFindBianBtnBian1 = (Button) view.findViewById(R.id.fragment_find_bian_btn_bian1);
        mFragmentFindBianBtnBian2 = (Button) view.findViewById(R.id.fragment_find_bian_btn_bian2);
        mFragmentFindBianBtnBian3 = (Button) view.findViewById(R.id.fragment_find_bian_btn_bian3);


        mFragmentFindBianBtnBian1.setOnClickListener(this);
                mFragmentFindBianBtnBian2.setOnClickListener(this);

        mFragmentFindBianBtnBian3.setOnClickListener(this);
    }
    public void  setEnabled(){
        mFragmentFindBianBtnBian1.setEnabled(true);
        mFragmentFindBianBtnBian2.setEnabled(true);
        mFragmentFindBianBtnBian3.setEnabled(true);
    }
    @Override
    public void onClick(View v) {
        setEnabled();
switch (v.getId()){
    case R.id.fragment_find_bian_btn_bian1:
        mFragmentFindBianBtnBian1.setEnabled(false);
        choose.addView(inflater);
        break;

    case R.id.fragment_find_bian_btn_bian2:
        mFragmentFindBianBtnBian2.setEnabled(false);
        break;
    case R.id.fragment_find_bian_btn_bian3:
        mFragmentFindBianBtnBian3.setEnabled(false);
        break;
}
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
