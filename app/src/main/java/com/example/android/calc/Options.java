package com.example.android.calc;

import android.widget.ImageView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by mohsinkarovaliya on 04/08/17.
 */

public class Options {

    public boolean isImageNeed() {
        return imageNeed;
    }

    public void setImageNeed(boolean imageNeed) {
        this.imageNeed = imageNeed;
    }


    public interface FragmentInteractionistener{
        void optSelect();
    }
    private String opt;
    private int imageView;
    private boolean imageNeed;

    public Options(){

    }
    public Options(String opt) {
        this.opt = opt;
    }
    public String getOpt() {return opt;}

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }


}
