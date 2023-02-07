package com.example.collageappuser.ui.home;

import android.content.Intent;
import android.net.Uri;
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
    
    ImageView map;
    ImageSlider imageSlider;
    List<SlideModel> slideModels;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        imageSlider = view.findViewById(R.id.imageSlider);
        map = view.findViewById(R.id.map);
        slideModels = new ArrayList<SlideModel>();

        slideModels.add(new SlideModel("https://picsum.photos/seed/picsum/200/300","first picture represent the view of the world! ", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://picsum.photos/id/237/200/300","second picture represent the view of the world! ", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://picsum.photos/200/300?grayscale", "third picture represent the view of the world! ",ScaleTypes.FIT));

        imageSlider.setImageList(slideModels);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });


        return view;
    }

    private void openMap() {

        Uri uri = Uri.parse("geo:0,0?q=daffodil international university,ashulia dhaka");

        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}