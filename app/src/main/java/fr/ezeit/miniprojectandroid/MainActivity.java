package fr.ezeit.miniprojectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Article article = (Article) getIntent().getSerializableExtra("article");
        //ListArticle.add(article);

        //Bouton vers "Ajouter un article"
        Button buttonMainAddItem = (Button)findViewById(R.id.buttonAddAddItem);
        buttonMainAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IntentAddItem = new Intent(MainActivity.this, Ajout_article.class);
                startActivity(IntentAddItem);
            }
        });

        //Bouton vers "Liste des articles"
        Button buttonMainlistItem = (Button)findViewById(R.id.buttonListItems);
        buttonMainlistItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IntentListItems = new Intent(MainActivity.this, ListeArticle.class);
                startActivity(IntentListItems);
            }
        });

        //Bouton vers "Mettre à jour un article"
        Button buttonMainUpdate = (Button)findViewById(R.id.buttonUpdateItem);
        buttonMainUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IntentUpdateItems = new Intent(MainActivity.this, ModifArticle.class);
                startActivity(IntentUpdateItems);
            }
        });
    }

    private boolean b1 = false;
    //ArrayList Article
    public ArrayList<Article> ListArticle = new ArrayList<>();
}