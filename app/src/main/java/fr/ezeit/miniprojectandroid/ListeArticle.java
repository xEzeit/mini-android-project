package fr.ezeit.miniprojectandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ListeArticle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_article);

        Button Backbutton = (Button) findViewById(R.id.buttonModifRetour);
        TextView List = (TextView) findViewById(R.id.listViewArticle);

        final ArrayList<Article>[] ListArticle = new ArrayList[]{new ArrayList<>()};
        ArrayList<Article> finalListArticle = ListArticle[0];

        if (getIntent().getSerializableExtra("article")==null) { // Instanciation de la liste d’article
            ListArticle[0].add(new Article("iPhone 14 Pro Max", "256Go", 1609, 1));
        } else{
            ListArticle[0] = (ArrayList<Article>) getIntent().getSerializableExtra("article");
        }

        //ListArticle = (ArrayList<Article>) getIntent().getSerializableExtra("article");
        for (Article articles : ListArticle[0]){
            List.setText("Nom du téléphone: " + articles.getName() + "\n"
                    + "Description du téléphone: " + articles.getDescription() + "\n"
                    + "Quantité: " + articles.getAmount() + "\n"
                    + "Prix: " + articles.getPrice());
        }

        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListeArticle.this, MainActivity.class);
                //Cette partie de remettre les infos du getIntent "article" puis ensuite de remettre
                // les infos obtenu dans l'ARRAYLIST de la classe ListeArticle.
                for (Article articles : ListArticle[0]){
                    articles.getName();
                    Article article = new Article(articles.getName(), articles.getDescription(), articles.getPrice(), articles.getAmount());
                    finalListArticle.add(article);
                }
                intent.putExtra("article", finalListArticle);
                System.out.println("ALLER BONBON!!!!");
                startActivity(intent);
            }
        });
    }

    // Menu ... en haut a droite
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    // Menu ... en haut a droite
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case(R.id.menuAjout) :
                Intent ajoutArticle = new Intent(ListeArticle.this, Ajout_article.class);
                startActivity(ajoutArticle);
                return true;
            case (R.id.menuListe) :
                Intent listeArticle = new Intent(ListeArticle.this, ListeArticle.class);
                startActivity(listeArticle);
                return true;
            case (R.id.menuModif):
                Intent majArticle = new Intent(ListeArticle.this, ModifArticle.class);
                startActivity(majArticle);
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }
}