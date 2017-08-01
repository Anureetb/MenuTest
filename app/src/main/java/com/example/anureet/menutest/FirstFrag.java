package com.example.anureet.menutest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by anureet on 07-07-2017.
 */

public class FirstFrag extends Fragment {
    FloatingActionButton Addbtn;
    EditText etwp ,ethm ,etfw , etpp , etwhen , etdate;

    DbHelper mydb;
    Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_first , container , false);
         context = container.getContext();
        etwp = (EditText)v.findViewById(R.id.etwp);
        etfw =(EditText)v.findViewById(R.id.etfw);
        ethm =(EditText)v.findViewById(R.id.ethm);
        etpp =(EditText)v.findViewById(R.id.etpp);
        etwhen = (EditText)v.findViewById(R.id.etwhen);
         Addbtn =(FloatingActionButton)v.findViewById(R.id.Addbtn);

       // tvwp.setText(getArguments().getString("name"));
        //tvfw.setText(getArguments().getString("for what"));
        mydb = new DbHelper(context);
        AddData();
        return v;
    }
    public void AddData(){
        Addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean isInserted =  mydb.insertData(etwp.getText().toString()
                                 ,ethm.getText().toString()
                                 ,etfw.getText().toString()
                                 ,etpp.getText().toString()
                                 ,etwhen.getText().toString()
                                  );
                if(isInserted == true)
                    Toast.makeText(context , "Data inserted" , Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(context , "Data not inserted" , Toast.LENGTH_LONG).show();

            }
        });
    }

//    public static FirstFrag newInstance(String name , String fw){
//
//        FirstFrag f = new FirstFrag();
//        Bundle b = new Bundle();
//        b.putString("name" , name);
//        b.putString("for what" , fw);
//        f.setArguments(b);
//        return  f;
//    }
}
