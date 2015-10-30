package com.firstapp.samuelagbede.wordfinder;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by SamuelAgbede on 8/12/2015.
 */
public class WelcomePage extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.welcomepage, container, false);
        return v;
    }
}
