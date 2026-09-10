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

public class QuestionTen extends AppCompatActivity {

    private RadioButton radioBtn1, radioBtn2, radioBtn3, radioBtn4;
    private Button btnResponder;
    Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question_ten);

        // Recupera o placar e o nome que vêm sendo carregados de tela em tela
        // via Intent, desde a MainActivity.
        int score = getIntent().getIntExtra("USER_SCORE", 0);
        String name = getIntent().getStringExtra("USER_NAME");
        player = new Player(name, score);

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

        // Regra do enunciado: o botão RESPONDER só deve ficar habilitado
        // depois que o usuário escolher uma alternativa.
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
        return radioBtn3.isChecked();
    }

    public void nextQuestion(View view){
        if (isCorrectAnswer()){
            player.setScore(player.getScore() + 1);
        }
        Intent next = new Intent(getApplicationContext(), RankingActivity.class);
        next.putExtra("USER_SCORE", player.getScore());
        next.putExtra("USER_NAME", player.getName());
        startActivity(next);

        // Encerra esta tela de pergunta. Assim ela some da pilha (back stack)
        // e, se o usuário apertar o botão "voltar" do aparelho, ele nunca
        // retorna para uma pergunta já respondida.
        finish();
    }
}
