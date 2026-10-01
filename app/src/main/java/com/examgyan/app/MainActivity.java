package com.examgyan.app;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.app.AlertDialog;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(com.examgyan.app.R.layout.activity_main);

        View menuButton = findViewById(com.examgyan.app.R.id.menuButton);

        menuButton.setOnClickListener(v -> {
            String[] items = {
                "🏠 Home",
                "📚 All Exams",
                "📝 Study Material",
                "❓ MCQ Practice",
                "📋 Mock Tests",
                "📰 Current Affairs",
                "📊 My Progress",
                "🔖 Bookmarks",
                "⚙️ Settings",
                "🔐 Admin Panel",
                "ℹ️ About Exam India"
            };

            new AlertDialog.Builder(MainActivity.this)
                .setTitle("Exam India")
                .setItems(items, (dialog, which) -> {
            if (which == 5) {
                startActivity(new Intent(MainActivity.this, CurrentAffairsActivity.class));
                return;
            }
                    if (which == 9) {
                        startActivity(new Intent(MainActivity.this, AdminActivity.class));
                        return;
                    }
                    if (which == 0) {
                        dialog.dismiss();
                    } else {
                        Toast.makeText(
                            MainActivity.this,
                            items[which],
                            Toast.LENGTH_SHORT
                        ).show();
                    }
                })
                .show();
        });

        View aiButton = findViewById(com.examgyan.app.R.id.aiButton);
        if (aiButton != null) {
            aiButton.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, AIActivity.class);
                startActivity(intent);
            });
        }

        View mpPscCard = findViewById(com.examgyan.app.R.id.mpPscCard);

        if (mpPscCard != null) {
            mpPscCard.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, MPPSCActivity.class);
                startActivity(intent);
            });
        }
    }
}
