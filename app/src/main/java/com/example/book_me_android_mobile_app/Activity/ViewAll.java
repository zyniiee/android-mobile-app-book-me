package com.example.book_me_android_mobile_app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book_me_android_mobile_app.Adapter.DealsAdapter;
import com.example.book_me_android_mobile_app.Adapter.ViewAllAdapter;
import com.example.book_me_android_mobile_app.Model.DealsModel;
import com.example.book_me_android_mobile_app.R;

import java.util.ArrayList;
import java.util.List;

public class ViewAll extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_all);
        ImageButton buttonClose = findViewById(R.id.buttonClose);
        buttonClose.setOnClickListener(view -> {
            finish();
        });


        ProgressBar progressBar = findViewById(R.id.progressBarTopDeals);

        boolean loadingComplete = true;
        if (loadingComplete) {
            progressBar.setVisibility(View.GONE);
        }

        setupDealsNearYouRecyclerView();

    }

    private void setupDealsNearYouRecyclerView() {
        RecyclerView dealsNearYouRecyclerView = findViewById(R.id.viewAllRecyclerView);
        dealsNearYouRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        List<DealsModel> dealsNearYouList = new ArrayList<>();
        dealsNearYouList.add(new DealsModel(
                "Kaitiaki Adventures - Kaituna Whitewater Rafting",
                "4.9 Rating / 309 Review",
                "16 Apr - 23 Apr",
                "$78",
                "Hurry! Only 5 spaces left",
                123,
                R.drawable.nz10
        ));
        dealsNearYouList.add(new DealsModel(
                "Wairakei Terraces - Thermal Hot Pools",
                "4.8 Rating / 2098 Review",
                "16 Apr - 23 Apr",
                "$13.5",
                "20+ Spaces",
                13.5,
                R.drawable.nz11
        ));
        dealsNearYouList.add(new DealsModel(
                "Orakei Korako - General Admission",
                "4.9 Rating / 234 Review",
                "16 Apr - 6 May",
                "$10",
                "20+ Spaces",
                135,
                R.drawable.nz7
        ));
        dealsNearYouList.add(new DealsModel(
                "Kaitiaki Adventures - Kaituna Whitewater Rafting",
                "4.9 Rating / 309 Review",
                "16 Apr - 23 Apr",
                "$78",
                "Hurry! Only 5 spaces left",
                43,
                R.drawable.nz1
        ));
        dealsNearYouList.add(new DealsModel(
                "Wairakei Terraces - Thermal Hot Pools",
                "4.8 Rating / 2098 Review",
                "16 Apr - 23 Apr",
                "$13.5",
                "20+ Spaces",
                125,
                R.drawable.nz2
        ));
        dealsNearYouList.add(new DealsModel(
                "Orakei Korako - General Admission",
                "4.9 Rating / 234 Review",
                "16 Apr - 6 May",
                "$10",
                "20+ Spaces",
                13.5,
                R.drawable.nz3
        ));
        dealsNearYouList.add(new DealsModel(
                "Rapids Jet - Taupo",
                "4.9 Rating / 460 Review",
                "16 Apr - 23 Apr",
                "$56",
                "8 Spaces",
                87,
                R.drawable.nz4
        ));

        dealsNearYouList.add(new DealsModel(
                "Rapids Jet - Taupo",
                "4.9 Rating / 460 Review",
                "16 Apr - 23 Apr",
                "$56",
                "8 Spaces",
                43,
                R.drawable.nz13
        ));


        ViewAllAdapter dealsAdapter = new ViewAllAdapter(dealsNearYouList, this,this::onItemClick);
        dealsNearYouRecyclerView.setAdapter(dealsAdapter);
    }

    public void onItemClick(DealsModel dealItem) {
        // Handle item click here, navigate to detail activity
        Intent intent = new Intent(this, DealsDetail.class);
        intent.putExtra("title", dealItem.getTitle());
        intent.putExtra("imageUrl", dealItem.getPicResId());
        startActivity(intent);
    }

}