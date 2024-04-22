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

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.book_me_android_mobile_app.R;

public class SignUp extends AppCompatActivity implements View.OnClickListener{
    EditText etFullName, etPassword, etEmail;
    boolean isALlFieldChecked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
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
        TextView underlineTextView2 = findViewById(R.id.underlineText2);
        // Apply underlining and color to each TextView
        updateUnderlinedTextView(underlineTextView1, "Log In");
        updateUnderlinedTextView(underlineTextView2, "Sign up here");
        etFullName = findViewById(R.id.fullName);
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

    private boolean CheckAllFields(){
        if(etFullName.length() == 0){
            etFullName.setError("This field is required");
            return false;
        }
        if(etEmail.length() == 0){
            etEmail.setError("This field is required");
            return false;
        }
        if(etPassword.length() == 0){
            etPassword.setError("This field is required");
            return false;
        } else if (etPassword.length() < 8){
            etPassword.setError("Password must be minimum 8 characters");
            return false;
        }
        return true;
    }
    public void navigateToLogIn(View view) {
        Intent intent = new Intent(this, LogIn.class);
        startActivity(intent);
    }

    public void navigateToProfile(View view) {
        isALlFieldChecked = CheckAllFields();
        if(isALlFieldChecked){
            Intent intent = new Intent(this, ProfileUserActivity.class);
            startActivity(intent);
        }
    }

    public void navigateToSupplierSignUp(View view) {
        Intent intent = new Intent(this, SupplierSignUp.class);
        startActivity(intent);
    }
}