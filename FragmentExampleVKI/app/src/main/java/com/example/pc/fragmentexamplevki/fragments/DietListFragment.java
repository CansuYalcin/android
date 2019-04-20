package com.example.pc.fragmentexamplevki.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.pc.fragmentexamplevki.R;
import com.example.pc.fragmentexamplevki.adapters.DietListAdapter;
import com.example.pc.fragmentexamplevki.models.Diet;

import java.util.ArrayList;
import java.util.List;

public class DietListFragment extends Fragment {

    final List<Diet> dietList = new ArrayList<Diet>();
    private OnFragmentInteractionListener mListener;

    public DietListFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_diet_list,null);
        dietList.add(new Diet(R.drawable.menu_3,"Yumurta, Peynir, Zeytin","5000C"));
        dietList.add(new Diet(R.drawable.menu_1,"Mevsim Yeşillikleri Salata","2000C"));
        dietList.add(new Diet(R.drawable.menu_2,"Badem, Fındık, Ceviz","4000C"));
        dietList.add(new Diet(R.drawable.menu_4,"Kivi, Çilek, Muz","1000C"));

        ListView myDietList = view.findViewById(R.id.list_fragment_diet_listview);
        DietListAdapter dietListAdapter = new DietListAdapter(getLayoutInflater(),dietList);
        myDietList.setAdapter(dietListAdapter);

        return view;
    }
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
