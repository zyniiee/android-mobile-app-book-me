package com.example.book_me_android_mobile_app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
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

import com.bumptech.glide.Glide;
import com.example.book_me_android_mobile_app.Adapter.DealsAdapter;
import com.example.book_me_android_mobile_app.Model.DealsModel;
import com.example.book_me_android_mobile_app.R;

import java.util.ArrayList;
import java.util.List;

public class DealsDetail extends AppCompatActivity {
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_deals_detail);

        ImageButton buttonClose = findViewById(R.id.buttonClose);

        buttonClose.setOnClickListener(view -> {
            finish();
        });
        // Retrieve data from intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        int imageUrl = intent.getIntExtra("imageUrl", 0);

        // Use the data to populate your detail activity layout
        TextView titleTextView = findViewById(R.id.deals_title);
        ImageView imageView = findViewById(R.id.deals_image);

        titleTextView.setText(title);
        Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.placeholder_image)
                .error(R.drawable.placeholder_image)
                .into(imageView);
        // Get references to your underlineTextViews
        TextView underlineTextView1 = findViewById(R.id.underlineText1);
        TextView underlineTextView2 = findViewById(R.id.underlineText2);
        TextView underlineTextView3 = findViewById(R.id.underlineText3);

        // Apply underlining and color to each TextView
        updateUnderlinedTextView(underlineTextView1, "More from Pure Milford");
        updateUnderlinedTextView(underlineTextView2, "See All");
        updateUnderlinedTextView(underlineTextView3, "See All");


        ProgressBar progressBar3 = findViewById(R.id.progressBarDealsYouMightLike);

        boolean loadingComplete = true;
        if (loadingComplete) {
            progressBar3.setVisibility(View.GONE);
        }

        setupDealsYouMightLikeRecyclerView();



    }
    private void setupDealsYouMightLikeRecyclerView() {
        RecyclerView dealsYouMightLikeRecyclerView = findViewById(R.id.dealsYouMightLike);
        dealsYouMightLikeRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<DealsModel> dealsYouMightLikeList = new ArrayList<>();

        dealsYouMightLikeList.add(new DealsModel(
                "Kaitiaki Adventures - Kaituna Whitewater Rafting",
                "4.9 Rating / 309 Review",
                "16 Apr - 23 Apr",
                "$78",
                "Hurry! Only 5 spaces left",
                56,
                R.drawable.nz6
        ));
        dealsYouMightLikeList.add(new DealsModel(
                "Wairakei Terraces - Thermal Hot Pools",
                "4.8 Rating / 2098 Review",
                "16 Apr - 23 Apr",
                "$13.5",
                "20+ Spaces",
                13.5,
                R.drawable.nz12
        ));
        dealsYouMightLikeList.add(new DealsModel(
                "Kaitiaki Adventures - Kaituna Whitewater Rafting",
                "4.9 Rating / 309 Review",
                "16 Apr - 23 Apr",
                "$78",
                "Hurry! Only 5 spaces left",
                79,
                R.drawable.nz1
        ));
        dealsYouMightLikeList.add(new DealsModel(
                "Wairakei Terraces - Thermal Hot Pools",
                "4.8 Rating / 2098 Review",
                "16 Apr - 23 Apr",
                "$13.5",
                "20+ Spaces",
                13.5,
                R.drawable.nz4
        ));
        dealsYouMightLikeList.add(new DealsModel(
                "Orakei Korako - General Admission",
                "4.9 Rating / 234 Review",
                "16 Apr - 6 May",
                "$10",
                "20+ Spaces",
                13.5,
                R.drawable.nz13
        ));
        dealsYouMightLikeList.add(new DealsModel(
                "Kaitiaki Adventures - Kaituna Whitewater Rafting",
                "4.9 Rating / 309 Review",
                "16 Apr - 23 Apr",
                "$78",
                "Hurry! Only 5 spaces left",
                23,
                R.drawable.nz7
        ));
        dealsYouMightLikeList.add(new DealsModel(
                "Wairakei Terraces - Thermal Hot Pools",
                "4.8 Rating / 2098 Review",
                "16 Apr - 23 Apr",
                "$13.5",
                "20+ Spaces",
                13.5,
                R.drawable.nz12
        ));
        dealsYouMightLikeList.add(new DealsModel(
                "Orakei Korako - General Admission",
                "4.9 Rating / 234 Review",
                "16 Apr - 6 May",
                "$10",
                "20+ Spaces",
                13.5,
                R.drawable.nz9
        ));
        dealsYouMightLikeList.add(new DealsModel(
                "Rapids Jet - Taupo",
                "4.9 Rating / 460 Review",
                "16 Apr - 23 Apr",
                "$56",
                "8 Spaces",
                42,
                R.drawable.nz4
        ));

        dealsYouMightLikeList.add(new DealsModel(
                "Rapids Jet - Taupo",
                "4.9 Rating / 460 Review",
                "16 Apr - 23 Apr",
                "$56",
                "8 Spaces",
                87,
                R.drawable.nz3
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
}