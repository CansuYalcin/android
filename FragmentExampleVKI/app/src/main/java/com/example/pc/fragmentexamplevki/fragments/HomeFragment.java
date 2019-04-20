package com.example.pc.fragmentexamplevki.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pc.fragmentexamplevki.R;

public class HomeFragment extends Fragment {
    EditText userWeightEt;
    EditText userlengthtEt;
    TextView userResultTv;
    Button calculateBtn;

    private  OnFragmentInteractionListener mListener;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("HomeFragment","onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i("HomeFragment","onCreateView");

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        userWeightEt = (EditText) view.findViewById(R.id.etKilo);
        userlengthtEt = (EditText) view.findViewById(R.id.etBoy);
        userResultTv = (TextView) view.findViewById(R.id.home_fragment_result_tv);

        calculateBtn = (Button) view.findViewById(R.id.vkiHesapla);
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
        return view;
    }

    private void calculate() {
        if (TextUtils.isEmpty(userWeightEt.getText().toString()) || TextUtils.isEmpty(userlengthtEt.getText().toString())) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("hata");
                builder.setMessage("Kilo ya da boy boş bırakılamaz");
                builder.setNegativeButton("TAMAM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
        } else {
            float userWeight = Float.parseFloat(userWeightEt.getText().toString());
            float userLenght = Float.parseFloat(userlengthtEt.getText().toString());
            if (userLenght > 0) {
                userLenght = userLenght / 100;
                float result = (userWeight / (userLenght * userLenght));

                String resultDescription = "";
                if (result > 15) {
                    resultDescription = "Aşırı Zayıf";
                } else if (result > 15 && result <= 30) {
                    resultDescription = "Zayıf";
                } else if (result > 30 && result <= 40) {
                    resultDescription = "Normal";
                } else if (result > 40) {
                    resultDescription = "Aşırı Şişman";
                } else {
                    resultDescription = " Çok Aşırı Şişman";
                }
                userResultTv.setText("Vücut kitle indeksi: " + result + "\n" + resultDescription);
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("HomeFragment","onAttach");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("HomeFragment","onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("HomeFragment","onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("HomeFragment","onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("HomeFragment","onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("HomeFragment","onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("HomeFragment","onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("HomeFragment","onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        Log.i("HomeFragment","onDetach");
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
