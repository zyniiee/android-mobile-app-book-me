package com.example.book_me_android_mobile_app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.book_me_android_mobile_app.R;

public class LogIn extends AppCompatActivity implements View.OnClickListener {
    EditText etPassword, etEmail;
    boolean isAllFieldChecked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in);
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

        updateUnderlinedTextView(underlineTextView1, "Sign Up");
        etPassword = findViewById(R.id.password);
        etEmail = findViewById(R.id.email);
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

    private boolean CheckAllFields(){
        if(etEmail.length() == 0){
            etEmail.setError("This field is required");
            return false;
        }
        if(etPassword.length() == 0){
            etPassword.setError("This field is required");
            return false;
        }
        return true;
    }
    public void navigateToProfile(View view) {
        boolean isAllFieldChecked = CheckAllFields();
        if (isAllFieldChecked) {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (email.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
                // Navigate to AdminDashboard for admin user
                Intent intent = new Intent(this, AdminDashboard.class);
                startActivity(intent);
            } else if (email.equalsIgnoreCase("supplier") && password.equalsIgnoreCase("supplier")) {
                // Navigate to SupplierDashboard for supplier user
                Intent intent = new Intent(this, SupplierDashboard.class);
                startActivity(intent);
            } else if (email.equalsIgnoreCase("user") && password.equalsIgnoreCase("user")) {
                // Navigate to ProfileUserActivity for regular user
                Intent intent = new Intent(this, ProfileUserActivity.class);
                startActivity(intent);
            } else {
                // Invalid email/pa                      ssword combination
                Toast.makeText(this, "Invalid email/password", Toast.LENGTH_SHORT).show();
            }
        } else {
            // Handle case where not all fields are filled
            Toast.makeText(this, "Please fill in all required fields", Toast.LENGTH_SHORT).show();
        }
    }

    public void navigateToSignUp(View view) {
        Intent intent = new Intent(this, SignUp.class);
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