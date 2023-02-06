package com.example.collageappuser.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.collageappuser.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    ImageSlider imageSlider;
    List<SlideModel> slideModels;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        imageSlider = view.findViewById(R.id.imageSlider);
        slideModels = new ArrayList<SlideModel>();

        slideModels.add(new SlideModel("https://picsum.photos/seed/picsum/200/300", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://picsum.photos/id/237/200/300", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://picsum.photos/200/300?grayscale", ScaleTypes.FIT));

        imageSlider.setImageList(slideModels);


        return view;
    }
}