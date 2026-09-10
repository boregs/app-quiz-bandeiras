package com.example.quizbandeira;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuestionSeven extends AppCompatActivity {

    private RadioButton radioBtn1, radioBtn2, radioBtn3, radioBtn4;
    private Button btnResponder;
    Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question_seven);
        int score = getIntent().getIntExtra("USER_SCORE", 0);
        player = new Player("", score);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        radioBtn1 = findViewById(R.id.radioBtn1);
        radioBtn2 = findViewById(R.id.radioBtn2);
        radioBtn3 = findViewById(R.id.radioBtn3);
        radioBtn4 = findViewById(R.id.radioBtn4);

        btnResponder = findViewById(R.id.btnResponder);
        btnResponder.setEnabled(false);

        View.OnClickListener habilitarResponder = v -> btnResponder.setEnabled(true);
        radioBtn1.setOnClickListener(habilitarResponder);
        radioBtn2.setOnClickListener(habilitarResponder);
        radioBtn3.setOnClickListener(habilitarResponder);
        radioBtn4.setOnClickListener(habilitarResponder);

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }

    public boolean isCorrectAnswer(){
        return radioBtn1.isChecked();
    }

    public void nextQuestion(View view){
        if (isCorrectAnswer()){
            player.setScore(player.getScore() +1);
        }
        Intent eighthQuestion = new Intent(getApplicationContext(), QuestionEight.class);

        eighthQuestion.putExtra("USER_SCORE", player.getScore());
        startActivity(eighthQuestion);

        System.out.println(player.getScore());
    }
}