//package com.example.navigation.leftrightfragment;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
////import android.app.Fragment;
//import androidx.fragment.app.FragmentTransaction;
////import android.app.FragmentTransaction;
//
//import com.example.navigation.MainActivity;
//import com.example.navigation.R;
//
//public class ListFragment extends android.app.ListFragment{
//    boolean dualPane;
//    int curCheckPosition = 0;
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_checked,Data.TITLES));
//
//        //获取帧布局
//        View detailFrame = getActivity().findViewById(R.id.detail);
//
//        //那么低啊没是否在一屏上显示列表和详细内容
//        dualPane = detailFrame != null && detailFrame.getVisibility() == View.VISIBLE;
//        if (savedInstanceState != null){
//            curCheckPosition = savedInstanceState.getInt("curChoice",0); //更新当前选择的索引
//        }
//        if (dualPane){
//            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
//            showDetails(curCheckPosition);
//        }
//    }
//
//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putInt("curChoice",curCheckPosition);
//    }
//
//    @Override
//    public void onListItemClick(ListView l, View v, int position, long id) {
//        super.onListItemClick(l, v, position, id);
//        showDetails(position);
//    }
//
//    void showDetails(int index){
//        curCheckPosition = index;
//        if(dualPane){
//            getListView().setItemChecked(index,true);
//            DetailFragment details = (DetailFragment)getFragmentManager().findFragmentById(R.id.detail); //获取用于显示详细内容的Fragment
//
//            if(details == null || details.getShowIndex()!=index){
//                details = DetailFragment.newInstance(index);
//                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                ft.replace(R.id.detail,details);
//                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//                ft.commit();
//
//            }else{
//                Intent intent = new Intent(getActivity(), MainActivity.DetailActivity.class);
//                intent.putExtra("index",index);
//                startActivity(intent);
//            }
//        }
//    }
//}
