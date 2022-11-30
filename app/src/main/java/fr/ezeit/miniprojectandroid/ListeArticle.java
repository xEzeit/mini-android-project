package fr.ezeit.miniprojectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ListeArticle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_article);

        TextView List = (TextView) findViewById(R.id.listViewArticle);
        Button Backbutton = (Button) findViewById(R.id.buttonModifRetour);

        Article article = (Article) getIntent().getSerializableExtra("article");
        List.setText("Nom du téléphone: " + article.getName() + "\n"
                + "Description du téléphone: " + article.getDescription() + "\n"
                + "Quantité: " + article.getAmount() + "\n"
                + "Prix: " + article.getPrice());

        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListeArticle.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}