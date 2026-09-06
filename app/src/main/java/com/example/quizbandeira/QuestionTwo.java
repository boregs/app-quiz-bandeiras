package com.example.quizbandeira;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuestionTwo extends AppCompatActivity {

    private RadioButton radioBtn1, radioBtn2, radioBtn3, radioBtn4;
    private Button btnResponder;
    Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question2);
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
    }

    public boolean isCorrectAnswer(){
        return radioBtn2.isChecked();
    }

    public void nextQuestion(View view){
        if (isCorrectAnswer()){
            player.setScore(player.getScore() +1);
        }
        Intent thirdQuestion = new Intent(getApplicationContext(), QuestionThree.class);

        thirdQuestion.putExtra("USER_SCORE", player.getScore());
        startActivity(thirdQuestion);

        System.out.println(player.getScore());
    }
}