package com.example.navigation.leftrightfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
//import android.app.Fragment;

import com.example.navigation.R;

public class DetailFragment extends Fragment {
    public static DetailFragment newInstance(int index){
        DetailFragment f = new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index",index);
        f.setArguments(bundle);
        return f;
    }

    public int getShowIndex(){
        //return getArguments().getInt("index",0);    //获取显示的列表索引
        return 1;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(container == null){
            return null;
        }
        ScrollView scroller = new ScrollView(getActivity());
        TextView text = new TextView(getActivity());
        text.setPadding(10,10,10,10);
        scroller.addView(text);
        text.setText(Data.DETAIL[getShowIndex()]);
        return scroller;
//        View view=inflater.inflate(R.layout.fragment_class,container,false);
//        return view;
    }
}
