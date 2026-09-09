package com.example.quizbandeira;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RankingActivity extends AppCompatActivity {

    private TextView txtNome, txtAcertos;
    private Button btnResponderNovamente, btnTelaPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ranking);

        int score = getIntent().getIntExtra("USER_SCORE", 0);
        String name = getIntent().getStringExtra("USER_NAME");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtNome = findViewById(R.id.txtNome);
        txtAcertos = findViewById(R.id.txtAcertos);
        btnResponderNovamente = findViewById(R.id.btnResponderNovamente);
        btnTelaPrincipal = findViewById(R.id.btnTelaPrincipal);

        txtNome.setText(name);
        txtAcertos.setText(String.valueOf(score));
    }

    // Botão "RESPONDER NOVAMENTE": manda de volta para a primeira pergunta,
    // com o placar zerado outra vez, mantendo o nome do jogador.
    public void responderNovamente(View view) {
        Intent it = new Intent(getApplicationContext(), QuestionOne.class);
        it.putExtra("USER_SCORE", 0);
        it.putExtra("USER_NAME", txtNome.getText().toString());
        startActivity(it);
        finish();
    }

    // Botão "TELA PRINCIPAL": volta para a tela inicial do app.
    public void telaPrincipal(View view) {
        Intent it = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(it);
        finish();
    }
}
