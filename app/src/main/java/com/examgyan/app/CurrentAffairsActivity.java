package com.examgyan.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class CurrentAffairsActivity extends Activity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_current_affairs);

        LinearLayout container = findViewById(R.id.currentAffairsContainer);
        TextView status = findViewById(R.id.updateStatus);

        try {
            InputStream input = getAssets().open("current_affairs.json");
            byte[] data = new byte[input.available()];
            input.read(data);
            input.close();

            JSONArray array = new JSONArray(
                    new String(data, StandardCharsets.UTF_8)
            );

            container.removeAllViews();

            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.getJSONObject(i);

                String category = obj.optString("category");
                String title = obj.optString("title");
                String detail = obj.optString("detail");
                String source = obj.optString("source");
                String date = obj.optString("date");

                TextView item = new TextView(this);

                String text = "🏆 " + category
                        + "\n\n" + title
                        + "\n" + detail;

                if (!date.isEmpty()) {
                    text += "\n📅 " + date;
                }

                if (!source.isEmpty()) {
                    text += "\n🔗 स्रोत: " + source;
                }

                item.setText(text);
                item.setTextColor(0xFFFFFFFF);
                item.setTextSize(17);
                item.setPadding(12, 18, 12, 24);

                container.addView(item);
            }

            status.setText("🔄 Current Affairs data loaded");

        } catch (Exception e) {
            status.setText("डेटा लोड नहीं हो पाया");
        }
    }
}
