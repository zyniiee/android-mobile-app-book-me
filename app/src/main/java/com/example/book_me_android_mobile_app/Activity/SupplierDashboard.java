package com.example.book_me_android_mobile_app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.book_me_android_mobile_app.R;

public class SupplierDashboard extends AppCompatActivity  implements View.OnClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_supplier_dashboard);
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