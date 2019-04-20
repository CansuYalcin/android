package com.example.pc.fragmentexamplevki.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pc.fragmentexamplevki.R;
import com.example.pc.fragmentexamplevki.models.Diet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HealthFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    public HealthFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("HealthFragment","onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //ilişkilendirdiğimiz layout dosyasını ekleyerek ekran tasarımını şekillendiriyoruz.
        Log.i("HealthFragment","onCreate");
        hashMapExample();
        return inflater.inflate(R.layout.fragment_health, container, false);
    }
// HASHMAP EXAMPLE-DEBUG APP İLE KONTROL EDEBİLİRSİN.
    //Debug yaparken F8 tuşu ile ilerleme yapıyoruz...
    private void hashMapExample() {
        HashMap hm = new HashMap();
        hm.put("H","Hidrojen");
        hm.put("Li","Lityum");
        hm.put("Au","Altın");
        hm.put("Ag","Gümüş");
        hm.put("U","Uranyum");
        Set set = hm.entrySet();

        Iterator i = set.iterator();
        while (i.hasNext()){
            Map.Entry me = (Map.Entry) i.next();
            Log.i("HASHMAP",me.getKey()+" : "+me.getValue());
        }
        Log.i("HASHMAPVALUE",hm.get("Au").toString());

        HashMap<String,Diet> hashMap = new HashMap<String,Diet>();
        hashMap.put("a1",new Diet(R.drawable.menu_3,"Yumurta, Peynir, Zeytin","5000C"));
        hashMap.put("a2",new Diet(R.drawable.menu_1,"Mevsim Yeşillikleri Salata","2000C"));
        Set set1 = hashMap.entrySet();

        Iterator i1 = set1.iterator();
        while (i1.hasNext()){
            Map.Entry me2 = (Map.Entry) i1.next();
            Log.i("HASHMAPDIET",me2.getKey()+" : "+me2.getValue().toString());
        }
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
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
