package com.examgyan.app;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class HistorySyllabusActivity extends Activity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_history_syllabus);

        findViewById(R.id.bharatVarshButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistorySyllabusActivity.this, HistoryTopicActivity.class);
                startActivity(intent);
            }
        });
    }
}
