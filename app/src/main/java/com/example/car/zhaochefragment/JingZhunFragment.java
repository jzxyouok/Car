package com.example.car.zhaochefragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.car.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link JingZhunFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link JingZhunFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JingZhunFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private List<View> data;
    private View add;
    private LinearLayout choose;
    private View addPrice;
    private View addlevel;
    private View addpai;

    private CharSequence text;
    private CharSequence text3;
    private CharSequence text2;
    private CharSequence text1;


    public JingZhunFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JingZhunFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JingZhunFragment newInstance(String param1, String param2) {
        JingZhunFragment fragment = new JingZhunFragment();
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
        return inflater.inflate(R.layout.fragment_jing_zhun, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        assignViews(view);
        final String[] tabData = new String[]{"价格", "级别", "排量", "变速箱"};
        mVpJZ.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return data.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == (object);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(data.get(position), 0);
                return data.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(data.get(position));
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tabData[position];
            }
        });
        mTabJZ.setupWithViewPager(mVpJZ);
        super.onViewCreated(view, savedInstanceState);
    }

    private TabLayout mTabJZ;
    private ViewPager mVpJZ;

    private Button mFragmentFindBianBtnBian1;
    private Button mFragmentFindBianBtnBian2;
    private Button mFragmentFindBianBtnBian3;

    private Button mFragmentFindPriceBtnPrice1;
    private Button mFragmentFindPriceBtnPrice2;
    private Button mFragmentFindPriceBtnPrice3;

    private Button mFragmentFindLevelBtnLevel1;
    private Button mFragmentFindLevelBtnLevel2;
    private Button mFragmentFindLevelBtnLevel3;

    private Button mFragmentFindPaiBtnPai1;
    private Button mFragmentFindPaiBtnPai2;
    private Button mFragmentFindPaiBtnPai3;

    private void assignViews(View view) {
        add = LayoutInflater.from(getContext()).inflate(R.layout.fragment_find_filter_add_main, null);
        choose = (LinearLayout) view.findViewById(R.id.find_filter_llyt_choosed);
        addPrice = LayoutInflater.from(getContext()).inflate(R.layout.fragment_find_filter_add_main, null);
        addlevel = LayoutInflater.from(getContext()).inflate(R.layout.fragment_find_filter_add_main, null);
        addpai = LayoutInflater.from(getContext()).inflate(R.layout.fragment_find_filter_add_main, null);


        View inflate1 = LayoutInflater.from(getContext()).inflate(R.layout.fragment_jzjiage, null);
        View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.fragment_jzjibie, null);
        View inflate3 = LayoutInflater.from(getContext()).inflate(R.layout.fragment_jzpai_liang, null);
        View inflate4 = LayoutInflater.from(getContext()).inflate(R.layout.fragment_jzbian_su_xiang, null);
        data = new ArrayList<>();
        data.add(inflate1);
        data.add(inflate2);
        data.add(inflate3);
        data.add(inflate4);
        mTabJZ = (TabLayout) view.findViewById(R.id.tab_JZ);
        mVpJZ = (ViewPager) view.findViewById(R.id.vp_JZ);

        mFragmentFindBianBtnBian1 = (Button) inflate4.findViewById(R.id.fragment_find_bian_btn_bian1);
        mFragmentFindBianBtnBian2 = (Button) inflate4.findViewById(R.id.fragment_find_bian_btn_bian2);
        mFragmentFindBianBtnBian3 = (Button) inflate4.findViewById(R.id.fragment_find_bian_btn_bian3);
        enable();
        mFragmentFindBianBtnBian1.setOnClickListener(this);
        mFragmentFindBianBtnBian2.setOnClickListener(this);
        mFragmentFindBianBtnBian3.setOnClickListener(this);

        mFragmentFindPriceBtnPrice1 = (Button) inflate1.findViewById(R.id.fragment_find_price_btn_price1);
        mFragmentFindPriceBtnPrice2 = (Button) inflate1.findViewById(R.id.fragment_find_price_btn_price2);
        mFragmentFindPriceBtnPrice3 = (Button) inflate1.findViewById(R.id.fragment_find_price_btn_price3);
        enableprice();

        mFragmentFindPriceBtnPrice1.setOnClickListener(this);
        mFragmentFindPriceBtnPrice2.setOnClickListener(this);
        mFragmentFindPriceBtnPrice3.setOnClickListener(this);


        mFragmentFindLevelBtnLevel1 = (Button) inflate2.findViewById(R.id.fragment_find_level_btn_level1);
        mFragmentFindLevelBtnLevel2 = (Button) inflate2.findViewById(R.id.fragment_find_level_btn_level2);
        mFragmentFindLevelBtnLevel3 = (Button) inflate2.findViewById(R.id.fragment_find_level_btn_level3);
        enablelevel();
        mFragmentFindLevelBtnLevel1.setOnClickListener(this);
        mFragmentFindLevelBtnLevel2.setOnClickListener(this);
        mFragmentFindLevelBtnLevel3.setOnClickListener(this);


        mFragmentFindPaiBtnPai1 = (Button) inflate3.findViewById(R.id.fragment_find_pai_btn_pai1);
        mFragmentFindPaiBtnPai2 = (Button) inflate3.findViewById(R.id.fragment_find_pai_btn_pai2);
        mFragmentFindPaiBtnPai3 = (Button) inflate3.findViewById(R.id.fragment_find_pai_btn_pai3);

        enablepai();
        mFragmentFindPaiBtnPai1.setOnClickListener(this);
        mFragmentFindPaiBtnPai2.setOnClickListener(this);
        mFragmentFindPaiBtnPai3.setOnClickListener(this);


    }

    private boolean bian = false;

    @Override
    public void onClick(View v) {
        enable();
        enableprice();
        enablelevel();
        enablepai();
        switch (v.getId()) {
            case R.id.fragment_find_pai_btn_pai1:
                if (bian) {
                    choose.removeView(addpai);
                }

                mFragmentFindPaiBtnPai1.setEnabled(false);
                text = mFragmentFindPaiBtnPai1.getText();
                choose.addView(addpai);
                bian = true;
                break;
            case R.id.fragment_find_pai_btn_pai2:
                if (bian) {
                    choose.removeView(addpai);
                }
                text = mFragmentFindPaiBtnPai2.getText();
                mFragmentFindPaiBtnPai2.setEnabled(false);
                choose.addView(addpai);
                bian = true;
                break;
            case R.id.fragment_find_pai_btn_pai3:
                if (bian) {
                    choose.removeView(addpai);
                }
                text = mFragmentFindPaiBtnPai3.getText();
                mFragmentFindPaiBtnPai3.setEnabled(false);
                choose.addView(addpai);
                bian = true;
                break;


            case R.id.fragment_find_level_btn_level1:
                if (bian) {
                    choose.removeView(addlevel);
                }
                text1 = mFragmentFindLevelBtnLevel1.getText();
                mFragmentFindLevelBtnLevel1.setEnabled(false);
                choose.addView(addlevel);
                bian = true;
                break;
            case R.id.fragment_find_level_btn_level2:
                if (bian) {
                    choose.removeView(addlevel);
                }
                text1 = mFragmentFindLevelBtnLevel2.getText();
                mFragmentFindLevelBtnLevel2.setEnabled(false);
                choose.addView(addlevel);
                bian = true;
                break;
            case R.id.fragment_find_level_btn_level3:
                if (bian) {
                    choose.removeView(addlevel);
                }
                text1 = mFragmentFindLevelBtnLevel3.getText();
                mFragmentFindLevelBtnLevel3.setEnabled(false);
                choose.addView(addlevel);
                bian = true;
                break;


            case R.id.fragment_find_price_btn_price1:
                if (bian) {
                    choose.removeView(addPrice);
                }
                text2 = mFragmentFindPriceBtnPrice1.getText();
                mFragmentFindPriceBtnPrice1.setEnabled(false);
                choose.addView(addPrice);
                bian = true;
                break;
            case R.id.fragment_find_price_btn_price2:
                if (bian) {
                    choose.removeView(addPrice);
                }
                text2 = mFragmentFindPriceBtnPrice2.getText();
                mFragmentFindPriceBtnPrice2.setEnabled(false);
                choose.addView(addPrice);

                bian = true;
                break;
            case R.id.fragment_find_price_btn_price3:
                if (bian) {
                    choose.removeView(addPrice);
                }
                text2 = mFragmentFindPriceBtnPrice3.getText();
                mFragmentFindPriceBtnPrice3.setEnabled(false);
                choose.addView(addPrice);
                bian = true;
                break;


            case R.id.fragment_find_bian_btn_bian1:
                if (bian) {
                    choose.removeView(add);
                }
                text3 = mFragmentFindBianBtnBian1.getText();
                mFragmentFindBianBtnBian1.setEnabled(false);
                choose.addView(add);
                bian = true;
                break;
            case R.id.fragment_find_bian_btn_bian2:
                if (bian) {
                    choose.removeView(add);
                }
                text3 = mFragmentFindBianBtnBian2.getText();
                mFragmentFindBianBtnBian2.setEnabled(false);
                choose.addView(add);
                bian = true;
                break;
            case R.id.fragment_find_bian_btn_bian3:
                if (bian) {
                    choose.removeView(add);
                }
                text3 = mFragmentFindBianBtnBian3.getText();
                mFragmentFindBianBtnBian3.setEnabled(false);
                choose.addView(add);
                bian = true;
                break;
        }
        TextView tv = (TextView) add.findViewById(R.id.fragment_find_filter_add_txt);
        tv.setText(text3);
        TextView tv1 = (TextView) addlevel.findViewById(R.id.fragment_find_filter_add_txt);
        tv1.setText(text1);
        TextView tv2 = (TextView) addpai.findViewById(R.id.fragment_find_filter_add_txt);
        tv2.setText(text);
        TextView tv3 = (TextView) addPrice.findViewById(R.id.fragment_find_filter_add_txt);
        tv3.setText(text2);
        addpai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose.removeView(v);
            }
        });
        addlevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose.removeView(v);
            }
        });
        addPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose.removeView(v);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choose.removeView(v);
            }
        });
    }

    public void enable() {
        mFragmentFindBianBtnBian1.setEnabled(true);
        mFragmentFindBianBtnBian2.setEnabled(true);
        mFragmentFindBianBtnBian3.setEnabled(true);

    }

    public void enablelevel() {
        mFragmentFindLevelBtnLevel1.setEnabled(true);
        mFragmentFindLevelBtnLevel2.setEnabled(true);
        mFragmentFindLevelBtnLevel3.setEnabled(true);

    }

    public void enableprice() {
        mFragmentFindPriceBtnPrice1.setEnabled(true);
        mFragmentFindPriceBtnPrice2.setEnabled(true);
        mFragmentFindPriceBtnPrice3.setEnabled(true);

    }

    public void enablepai() {
        mFragmentFindPaiBtnPai1.setEnabled(true);
        mFragmentFindPaiBtnPai2.setEnabled(true);
        mFragmentFindPaiBtnPai3.setEnabled(true);

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
