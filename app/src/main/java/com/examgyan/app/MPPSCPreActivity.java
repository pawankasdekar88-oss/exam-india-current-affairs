package com.examgyan.app;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MPPSCPreActivity extends Activity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_mppsc_pre);

        findViewById(R.id.historyButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MPPSCPreActivity.this, HistorySyllabusActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.mpHistoryButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MPPSCPreActivity.this, MPHistorySyllabusActivity.class);
                startActivity(intent);
            }
        });
    }
}
