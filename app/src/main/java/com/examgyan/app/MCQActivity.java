package com.examgyan.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MCQActivity extends Activity {

    TextView questionNumber, questionText, resultText;
    Button optionA, optionB, optionC, optionD, nextButton;

    String[][] questions = {
        {
            "वेदों की संख्या कितनी है?",
            "2", "3", "4", "5", "C"
        },
        {
            "उपनिषद मुख्यतः किससे संबंधित हैं?",
            "दर्शन एवं आध्यात्मिक ज्ञान", "युद्ध कला", "कृषि", "व्यापार", "A"
        },
        {
            "ऋग्वेद किस प्रकार का ग्रंथ है?",
            "वेद", "पुराण", "स्मृति", "उपनिषद", "A"
        },
        {
            "सामवेद का मुख्य संबंध किससे है?",
            "संगीत एवं गायन", "चिकित्सा", "ज्योतिष", "व्याकरण", "A"
        },
        {
            "यजुर्वेद मुख्यतः किससे संबंधित है?",
            "यज्ञ संबंधी विधियाँ", "संगीत", "कथा साहित्य", "चित्रकला", "A"
        }
    };

    int currentQuestion = 0;
    int score = 0;
    boolean answered = false;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_mcq);

        questionNumber = findViewById(R.id.questionNumber);
        questionText = findViewById(R.id.questionText);
        resultText = findViewById(R.id.resultText);

        optionA = findViewById(R.id.optionA);
        optionB = findViewById(R.id.optionB);
        optionC = findViewById(R.id.optionC);
        optionD = findViewById(R.id.optionD);
        nextButton = findViewById(R.id.nextButton);

        showQuestion();

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    Button selected = (Button) v;
                    checkAnswer(selected);
                }
            }
        };

        optionA.setOnClickListener(listener);
        optionB.setOnClickListener(listener);
        optionC.setOnClickListener(listener);
        optionD.setOnClickListener(listener);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answered) {
                    currentQuestion++;

                    if (currentQuestion < questions.length) {
                        showQuestion();
                    } else {
                        questionNumber.setText("Test पूरा हुआ");
                        questionText.setText("आपका स्कोर: " + score + " / " + questions.length);
                        optionA.setVisibility(View.GONE);
                        optionB.setVisibility(View.GONE);
                        optionC.setVisibility(View.GONE);
                        optionD.setVisibility(View.GONE);
                        resultText.setText("🎉 Test समाप्त");
                        nextButton.setVisibility(View.GONE);
                    }
                }
            }
        });
    }

    void showQuestion() {
        answered = false;

        String[] q = questions[currentQuestion];

        questionNumber.setText("प्रश्न " + (currentQuestion + 1) + " / " + questions.length);
        questionText.setText(q[0]);

        optionA.setText("A. " + q[1]);
        optionB.setText("B. " + q[2]);
        optionC.setText("C. " + q[3]);
        optionD.setText("D. " + q[4]);

        resultText.setText("");
        nextButton.setText("➡️  अगला प्रश्न");

        optionA.setEnabled(true);
        optionB.setEnabled(true);
        optionC.setEnabled(true);
        optionD.setEnabled(true);
    }

    void checkAnswer(Button selected) {
        answered = true;

        String answer = "";

        if (selected == optionA) answer = "A";
        if (selected == optionB) answer = "B";
        if (selected == optionC) answer = "C";
        if (selected == optionD) answer = "D";

        String correct = questions[currentQuestion][5];

        if (answer.equals(correct)) {
            score++;
            resultText.setText("✅ सही उत्तर!");
        } else {
            resultText.setText("❌ गलत उत्तर! सही उत्तर: " + correct);
        }

        optionA.setEnabled(false);
        optionB.setEnabled(false);
        optionC.setEnabled(false);
        optionD.setEnabled(false);
    }
}
