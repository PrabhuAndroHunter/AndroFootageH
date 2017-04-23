package com.pub.assignment;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button mSearchBtn;
    private EditText mUrlTextEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSearchBtn = (Button) findViewById(R.id.button_activitymain_searchBtn);
        mUrlTextEt = (EditText) findViewById(R.id.editText_activitymain_url);
        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = mUrlTextEt.getText().toString();
                if (url.isEmpty()) {
                    mUrlTextEt.setHint(R.string.This_field_is_required);
                    mUrlTextEt.setHintTextColor(0xFFE10F0F);
                } else {
                    Intent searchIntent = new Intent(Intent.ACTION_WEB_SEARCH);
                    searchIntent.putExtra(SearchManager.QUERY, url);
                    startActivity(searchIntent);
                }

            }
        });

    }
}
