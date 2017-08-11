package com.example.android.calc;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



import static com.example.android.calc.R.id.equation;


public class CommonFragment extends Fragment implements OptionsAdapter.SetOptions {

    public interface ChangeOpt {
        public void selectMain(String e);
        public void equateMain(String d);
    }
    ChangeOpt mCallBack;
    public void setThis(ChangeOpt mList) {
        mCallBack = mList;
    }


    private List<Options> optionList = new ArrayList<>();
    private RecyclerView recyclerView;
    private OptionsAdapter mAdapter;


    public CommonFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_common, container, false);


        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

        mAdapter = new OptionsAdapter(optionList);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));

        mAdapter.setListener(this);
        recyclerView.setAdapter(mAdapter);





        optionList.add(new Options("C"));

        optionList.add(new Options("("));
        optionList.add(new Options(")"));
        optionList.add(new Options("."));
        optionList.add(new Options("1"));
        optionList.add(new Options("2"));
        optionList.add(new Options("3"));
        optionList.add(new Options("/"));
        optionList.add(new Options("4"));
        optionList.add(new Options("5"));
        optionList.add(new Options("6"));
        optionList.add(new Options("*"));
        optionList.add(new Options("7"));
        optionList.add(new Options("8"));
        optionList.add(new Options("9"));
        optionList.add(new Options("X^n"));
        optionList.add(new Options("+"));
        optionList.add(new Options("0"));
        optionList.add(new Options("-"));
        Options obj = new Options();
        obj.setImageNeed(true);
        obj.setImageView(R.drawable.backspace);


        obj.setOpt("b");




        optionList.add(obj);



      return rootView;



    }
    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void select(String e) {

        mCallBack.selectMain(e);

    }

    @Override
    public void equate(String d) {
        mCallBack.equateMain(d);
    }

}
