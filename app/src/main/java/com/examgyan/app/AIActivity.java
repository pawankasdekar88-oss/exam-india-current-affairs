package com.examgyan.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AIActivity extends Activity {

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_ai);

        EditText questionInput = findViewById(R.id.questionInput);
        Button askButton = findViewById(R.id.askButton);
        TextView answerText = findViewById(R.id.answerText);

        askButton.setOnClickListener(v -> {
            String q = questionInput.getText().toString().trim().toLowerCase();

            if (q.isEmpty()) {
                answerText.setText("कृपया पहले अपना सवाल लिखें।");
                return;
            }

            String answer;

            if (q.contains("भारत की राजधानी")) {
                answer = "भारत की राजधानी नई दिल्ली है।";
            } else if (q.contains("मध्य प्रदेश की राजधानी")) {
                answer = "मध्य प्रदेश की राजधानी भोपाल है।";
            } else if (q.contains("राष्ट्रपिता")) {
                answer = "महात्मा गांधी को सामान्यतः राष्ट्रपिता के रूप में संबोधित किया जाता है।";
            } else {
                answer = "यह सवाल अभी मेरे लोकल ज्ञान में उपलब्ध नहीं है। बाद में AI API जोड़कर मैं ऐसे सवालों के भी जवाब दे सकूँगा।";
            }

            answerText.setText(answer);
        });
    }
}
