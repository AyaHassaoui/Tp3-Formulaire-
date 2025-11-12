package com.exemple.tp3formulaire;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Screen2Activity extends AppCompatActivity {

    private TextView recap;
    private Button btnRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        recap = findViewById(R.id.recap);
        btnRetour = findViewById(R.id.btnRetour);

        Intent intent = getIntent();
        String nom     = intent.getStringExtra("nom");
        String email   = intent.getStringExtra("email");
        String phone   = intent.getStringExtra("phone");
        String adresse = intent.getStringExtra("adresse");
        String ville   = intent.getStringExtra("ville");

        String resume = "Nom : " + safe(nom) +
                "\nEmail : " + safe(email) +
                "\nTéléphone : " + safe(phone) +
                "\nAdresse : " + safe(adresse) +
                "\nVille : " + safe(ville);

        recap.setText(resume);

        btnRetour.setOnClickListener(v -> finish());
    }

    private String safe(String s) {
        return (s == null || s.trim().isEmpty()) ? "—" : s.trim();
    }
}
