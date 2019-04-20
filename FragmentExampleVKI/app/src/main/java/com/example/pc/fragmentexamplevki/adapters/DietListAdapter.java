package com.example.pc.fragmentexamplevki.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pc.fragmentexamplevki.R;
import com.example.pc.fragmentexamplevki.models.Diet;

import java.util.List;

public class DietListAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<Diet> dietList;

    public DietListAdapter(LayoutInflater layoutInflater,List<Diet> dietList){
        this.layoutInflater = layoutInflater;
        this.dietList = dietList;
    }

    @Override
    public int getCount() {
        return dietList.size();
    }

    @Override
    public Object getItem(int i) {
        return dietList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View dietView = layoutInflater.inflate(R.layout.custom_diet_layout,null);
        ImageView foodPicture = dietView.findViewById(R.id.custom_diet_food_picture);
        TextView foodName = dietView.findViewById(R.id.custom_diet_food_name);
        TextView foodCalorie = dietView.findViewById(R.id.custom_diet_food_calorie);

        Diet diet = dietList.get(i);
        foodPicture.setImageResource(diet.getFoodPicture());
        foodName.setText(diet.getFoodName());
        foodCalorie.setText(diet.getTotalCalorie());

        return dietView;
    }
}
