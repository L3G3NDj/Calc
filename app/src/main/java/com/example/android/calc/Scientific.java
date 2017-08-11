package com.example.android.calc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mohsinkarovaliya on 04/08/17.
 */

public class Scientific extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category2);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container2, new ScientificFragment())
                .commit();
    }

}
