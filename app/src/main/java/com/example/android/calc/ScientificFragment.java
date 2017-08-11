package com.example.android.calc;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.tag;
import static android.R.id.button1;
import static com.example.android.calc.R.id.option;


public class ScientificFragment extends Fragment  implements OptionsAdapter.SetOptions {

    public interface ChangeOpt2 {
        public void selectMain2(String v);
        public void equateMain2(String d);
    }
    ChangeOpt2 mCallBack2;
    public void setThis2(ChangeOpt2 mList) {
        mCallBack2 = mList;
    }

    private List<Options> optionList = new ArrayList<>();
    private RecyclerView recyclerView2;
    private OptionsAdapter mAdapter2;

    public ScientificFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_scientific, container, false);


        recyclerView2 = (RecyclerView) rootView.findViewById(R.id.recycler_view2);

        mAdapter2 = new OptionsAdapter(optionList);
        recyclerView2.setLayoutManager(new GridLayoutManager(getActivity(), 4));

        mAdapter2.setListener(this);

        recyclerView2.setAdapter(mAdapter2);


        optionList.add(new Options("C"));

        optionList.add(new Options("("));
        optionList.add(new Options(")"));
        optionList.add(new Options("sin"));
        optionList.add(new Options("1"));
        optionList.add(new Options("2"));
        optionList.add(new Options("3"));
        optionList.add(new Options("cos"));
        optionList.add(new Options("4"));
        optionList.add(new Options("5"));
        optionList.add(new Options("6"));
        optionList.add(new Options("tan"));
        optionList.add(new Options("7"));
        optionList.add(new Options("8"));
        optionList.add(new Options("9"));
        optionList.add(new Options("*"));
        optionList.add(new Options("+"));
        optionList.add(new Options("0"));
        optionList.add(new Options("-"));

        Options obj = new Options();
        obj.setImageNeed(true);
        obj.setOpt("b");
        obj.setImageView(R.drawable.backspace);



        optionList.add(obj);






        return rootView;



    }
    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void select(String v) {

        mCallBack2.selectMain2(v);

    }

    @Override
    public void equate(String d) {
        mCallBack2.equateMain2(d);
    }

}

