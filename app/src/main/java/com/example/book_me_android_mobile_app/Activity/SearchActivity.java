package com.example.book_me_android_mobile_app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.book_me_android_mobile_app.Adapter.DealsAdapter;
import com.example.book_me_android_mobile_app.Model.DealsModel;
import com.example.book_me_android_mobile_app.R;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search);

        // Find all LinearLayouts corresponding to bottom navigation items
        LinearLayout homeLayout = findViewById(R.id.home);
        LinearLayout dealsLayout = findViewById(R.id.deals);
        LinearLayout searchLayout = findViewById(R.id.search);
        LinearLayout profileLayout = findViewById(R.id.profile);

        // Set click listeners for each bottom navigation item
        homeLayout.setOnClickListener(this);
        dealsLayout.setOnClickListener(this);
        searchLayout.setOnClickListener(this);
        profileLayout.setOnClickListener(this);

        // Get references to your underlineTextViews
        TextView underlineTextView1 = findViewById(R.id.underlineText1);

        underlineTextView1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(SearchActivity.this, ViewAll.class);
                startActivity(intent);
            }
        });
        updateUnderlinedTextView(underlineTextView1, "See All");

        ProgressBar progressBar1 = findViewById(R.id.progressBarTopDeals);


        boolean loadingComplete = true;
        if (loadingComplete) {
            progressBar1.setVisibility(View.GONE);
        }

        setupDealsYouMightLikeRecyclerView();



    }

    private void setupDealsYouMightLikeRecyclerView() {
        RecyclerView dealsYouMightLikeRecyclerView = findViewById(R.id.todayTopDealsView);
        dealsYouMightLikeRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<DealsModel> dealsYouMightLikeList = new ArrayList<>();

        dealsYouMightLikeList.add(new DealsModel(
                "Kaitiaki Adventures - Kaituna Whitewater Rafting",
                "4.9 Rating / 309 Review",
                "16 Apr - 23 Apr",
                "$78",
                "Hurry! Only 5 spaces left",
                56,
                R.drawable.aus4
        ));
        dealsYouMightLikeList.add(new DealsModel(
                "Wairakei Terraces - Thermal Hot Pools",
                "4.8 Rating / 2098 Review",
                "16 Apr - 23 Apr",
                "$13.5",
                "20+ Spaces",
                13.5,
                R.drawable.aus5
        ));
        dealsYouMightLikeList.add(new DealsModel(
                "Kaitiaki Adventures - Kaituna Whitewater Rafting",
                "4.9 Rating / 309 Review",
                "16 Apr - 23 Apr",
                "$78",
                "Hurry! Only 5 spaces left",
                79,
                R.drawable.aus6
        ));
        dealsYouMightLikeList.add(new DealsModel(
                "Wairakei Terraces - Thermal Hot Pools",
                "4.8 Rating / 2098 Review",
                "16 Apr - 23 Apr",
                "$13.5",
                "20+ Spaces",
                13.5,
                R.drawable.aus7
        ));
        dealsYouMightLikeList.add(new DealsModel(
                "Orakei Korako - General Admission",
                "4.9 Rating / 234 Review",
                "16 Apr - 6 May",
                "$10",
                "20+ Spaces",
                13.5,
                R.drawable.aus8
        ));
        dealsYouMightLikeList.add(new DealsModel(
                "Kaitiaki Adventures - Kaituna Whitewater Rafting",
                "4.9 Rating / 309 Review",
                "16 Apr - 23 Apr",
                "$78",
                "Hurry! Only 5 spaces left",
                23,
                R.drawable.aus9
        ));
        dealsYouMightLikeList.add(new DealsModel(
                "Wairakei Terraces - Thermal Hot Pools",
                "4.8 Rating / 2098 Review",
                "16 Apr - 23 Apr",
                "$13.5",
                "20+ Spaces",
                13.5,
                R.drawable.aus10
        ));
        dealsYouMightLikeList.add(new DealsModel(
                "Orakei Korako - General Admission",
                "4.9 Rating / 234 Review",
                "16 Apr - 6 May",
                "$10",
                "20+ Spaces",
                13.5,
                R.drawable.aus11
        ));
        dealsYouMightLikeList.add(new DealsModel(
                "Rapids Jet - Taupo",
                "4.9 Rating / 460 Review",
                "16 Apr - 23 Apr",
                "$56",
                "8 Spaces",
                42,
                R.drawable.aus1
        ));

        dealsYouMightLikeList.add(new DealsModel(
                "Milford Sound Fly - Cruise - Fly",
                "4.9 Rating / 460",
                "16 Apr - 23 Apr",
                "$56",
                "8 Spaces",
                87,
                R.drawable.aus2
        ));
        DealsAdapter dealsAdapter = new DealsAdapter(dealsYouMightLikeList, this,this::onItemClick);
        dealsYouMightLikeRecyclerView.setAdapter(dealsAdapter);

    }
    public void onItemClick(DealsModel dealItem) {
        // Handle item click here, navigate to detail activity
        Intent intent = new Intent(this, DealsDetail.class);
        intent.putExtra("title", dealItem.getTitle());
        intent.putExtra("imageUrl", dealItem.getPicResId());
        startActivity(intent);
    }
    private void updateUnderlinedTextView(TextView textView, String targetText) {
        String text = textView.getText().toString();
        SpannableString spannableString = new SpannableString(text);

        // Apply UnderlineSpan to the target text
        int startIndex = text.indexOf(targetText);
        int endIndex = startIndex + targetText.length();
        if (startIndex != -1) {
            spannableString.setSpan(new UnderlineSpan(), startIndex, endIndex, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

            // Apply custom text color (black)
            int blackColor = ContextCompat.getColor(this, R.color.black);
            spannableString.setSpan(new ForegroundColorSpan(blackColor), startIndex, endIndex, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

            // Set the modified SpannableString to the TextView
            textView.setText(spannableString);
        }
    }

    @Override
    public void onClick(View view) {
        // Handle click events for bottom navigation items
        Intent intent;
        if (view.getId() == R.id.home) {
            intent = new Intent(this, MainActivity.class);
        } else if (view.getId() == R.id.deals) {
            intent = new Intent(this, DealsActivity.class);
        } else if (view.getId() == R.id.search) {
            intent = new Intent(this, SearchActivity.class);
        } else if (view.getId() == R.id.profile) {
            intent = new Intent(this, ProfileActivity.class);
        } else {
            return; // Return if the click event is not handled
        }
        startActivity(intent);
    }


}