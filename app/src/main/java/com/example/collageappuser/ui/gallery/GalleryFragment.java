package com.example.collageappuser.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.collageappuser.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {

    private RecyclerView indRecyclerView,convoRecyclerView;
    private GalleryAdapter galleryAdapter;
    List<String> imageList;
    String data;

    DatabaseReference databaseReference,ref;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_gallery, container, false);

        convoRecyclerView  = view.findViewById(R.id.convoRecyclerView);
        indRecyclerView  = view.findViewById(R.id.indRecyclerView);
        imageList = new ArrayList<>();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Gallery");

        getConvoImage();
        getIndImage();

        return view;
    }

    private void getConvoImage() {
        databaseReference.child("Convocation").addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    data = (String) dataSnapshot.getValue();
                    imageList.add(data);
                }


                galleryAdapter = new GalleryAdapter(getContext(),imageList);
                convoRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
                convoRecyclerView.setAdapter(galleryAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void getIndImage() {

        databaseReference.child("Independence Day").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    String data = (String) dataSnapshot.getValue();
                    imageList.add(data);
                }

                galleryAdapter = new GalleryAdapter(getContext(),imageList);
                indRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
                indRecyclerView.setAdapter(galleryAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}