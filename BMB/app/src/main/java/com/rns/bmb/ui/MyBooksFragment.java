package com.rns.bmb.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.rns.bmb.R;

import java.util.ArrayList;
import java.util.Arrays;

public class MyBooksFragment extends Fragment {
    ListView listViewReg;
    ArrayAdapter<String> listAdapter;
    Button btnAddBooks;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my_books, container, false);

        listViewReg = (ListView)rootView.findViewById(R.id.lv_my_books);
        btnAddBooks = (Button)rootView.findViewById(R.id.add_books);

        String[] planets = new String[] { "Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune"};

        ArrayList<String> planetList = new ArrayList<String>();
        planetList.addAll( Arrays.asList(planets) );

        listAdapter = new ArrayAdapter<String>(this.getActivity(), R.layout.simplerow, planetList);
        listViewReg.setAdapter(listAdapter);
        return rootView;
    }
    public void saveBook(View v){
    
    }
}
