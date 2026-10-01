package com.examgyan.app;
import android.content.Intent;
import android.view.View;

import android.app.Activity;
import android.os.Bundle;

public class HistoryTopicActivity extends Activity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_history_topic);
        findViewById(R.id.mcqButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoryTopicActivity.this, MCQActivity.class);
                startActivity(intent);
            }
        });
    }
}
