package com.example.jarnin.quickmed;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class FormsActivity extends AppCompatActivity {
    protected Button surveyButton;
    protected Button healthFormButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        surveyButton = (Button) findViewById(R.id.surveyButton);
        surveyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormsActivity.this, SurveyFormActivity.class);
                startActivity(intent);
            }
        });

        healthFormButton = (Button) findViewById(R.id.formButton);
        healthFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormsActivity.this, TestFormActivity.class);
                startActivity(intent);
            }
        });
    }
}
