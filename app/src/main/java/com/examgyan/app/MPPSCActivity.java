package com.examgyan.app;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MPPSCActivity extends Activity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(com.examgyan.app.R.layout.activity_mppsc);

        View preButton = findViewById(com.examgyan.app.R.id.preButton);

        preButton.setOnClickListener(v -> {
            Intent intent = new Intent(MPPSCActivity.this, MPPSCPreActivity.class);
            startActivity(intent);
        });
    }
}
