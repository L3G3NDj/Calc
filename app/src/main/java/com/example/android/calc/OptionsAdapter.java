package com.example.android.calc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View.OnClickListener;
import java.util.List;
import java.util.Set;


import static android.R.attr.drawable;
import static android.R.attr.tag;
import static android.R.attr.value;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static android.media.CamcorderProfile.get;
import org.mariuszgromada.math.mxparser.Expression;

import static android.os.Build.VERSION_CODES.O;
import static com.example.android.calc.R.id.activity_main;
import static com.example.android.calc.R.id.equation;
import static com.example.android.calc.R.id.image;
import static com.example.android.calc.R.id.option;
import static com.example.android.calc.R.id.solution;
import static com.example.android.calc.R.layout.options;



public class OptionsAdapter extends RecyclerView.Adapter<OptionsAdapter.MyViewHolder> {

    public interface SetOptions {
        public void select(String d);
        public void equate(String v);
    }

    private List<Options> optionList;
    public String Entered = "";
    double prev=0;

    SetOptions CallBack;

   public void setListener(SetOptions List) {
       CallBack = List;
   }


    public class  MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView option;
        RelativeLayout listOpt;

        private ImageView image;




        public MyViewHolder(View view) {
            super(view);
            option = view.findViewById(R.id.option);
            image = view.findViewById(R.id.image);
            listOpt = (RelativeLayout) view.findViewById(R.id.listOpt);

            listOpt.setOnClickListener(this);




        }

         double v=0;

        @Override
        public void onClick(View view) {


            Options myOption = (Options) optionList.get(getAdapterPosition());

            String tag= (String) view.getTag();


            if(tag.equals("b")){
                //for(int i = 0; i < 500; i++){

                //listOpt.setBackgroundColor(R.color.colorAccent);}

                ///listOpt.setBackgroundColor(View.getContext(listOpt).getResources().(R.color.colorPrimaryDark);
                do {
                    if (Entered != null && Entered.length() > 0) {
                        Entered = Entered.substring(0, Entered.length() - 1);
                        if(Entered.length() == 0)
                            v=0;

                       else{ Expression expression = new Expression(Entered);
                        v = expression.calculate();}

                        CallBack.select(String.valueOf(v));
                        CallBack.equate(Entered);
                    }

                } while (String.valueOf(v) == "NaN" || String.valueOf(v) == "0");
            }

            else if(tag.equals("C")) {
                    Entered = "";

                    int v = 0;
                    prev=0;
                    CallBack.select(String.valueOf(v));
                    CallBack.equate(Entered);
                }

            else if (tag.equals("X^n")){
            Entered+="^";
                CallBack.select(String.valueOf(v));
                CallBack.equate(Entered);
            }

            else
                {

                Entered += tag;
                Expression expression = new Expression(Entered);
                v = expression.calculate();

                if (String.valueOf(v) == "NaN") {
                    v = prev;
                    CallBack.select(String.valueOf(v));
                    CallBack.equate(Entered);

                }
                else {
                    prev = v;
                    CallBack.select(String.valueOf(v));
                    CallBack.equate(Entered);

                }


            }

        }



    }



    public OptionsAdapter(List<Options> optionList) {
        this.optionList = optionList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(options, parent, false);

        return new MyViewHolder(itemView);





    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Options option = optionList.get(position);


        holder.option.setText(option.getOpt());
        holder.listOpt.setTag(option.getOpt());





        if(option.isImageNeed()==true) {
            holder.image.setVisibility(View.VISIBLE);
            holder.option.setVisibility(View.GONE);
            holder.option.setText("");
            holder.image.setBackgroundResource(option.getImageView());
        }
        else{
            holder.image.setVisibility(View.GONE);
            holder.option.setVisibility(View.VISIBLE);
        }


    }



    @Override
    public int getItemCount() {
        return optionList.size();
    }
}
