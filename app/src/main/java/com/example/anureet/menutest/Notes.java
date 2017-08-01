package com.example.anureet.menutest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by anureet on 14-07-2017.
 */

public class Notes extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView tvnotes;
        Button btn_notes;

        View v = inflater.inflate(R.layout.frag_notes , container , false);
        tvnotes =(TextView)v.findViewById(R.id.tvnote);
        btn_notes =(Button)v.findViewById(R.id.btn_note);

        return v;
    }
}
