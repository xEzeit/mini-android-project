package fr.ezeit.miniprojectandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (getIntent().getSerializableExtra("article")==null) { // Instanciation de la liste d’article
            ListArticle.add(new Article("iPhone 14 Pro Max", "256Go", 1609, 1));
        } else{
            ListArticle = (ArrayList<Article>) getIntent().getSerializableExtra("article");
        }

        /*for(Article a : ListArticle){
            Log.d("contenu ", a.getDescription());
        }*/

        //Bouton vers "Ajouter un article"
        Button buttonMainAddItem = (Button)findViewById(R.id.buttonAddAddItem);
        buttonMainAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IntentAddItem = new Intent(MainActivity.this, Ajout_article.class);
                IntentAddItem.putExtra("article", ListArticle);
                startActivity(IntentAddItem);
            }
        });

        //Bouton vers "Liste des articles"
        Button buttonMainlistItem = (Button)findViewById(R.id.buttonListItems);
        buttonMainlistItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IntentListItems = new Intent(MainActivity.this, ListeArticle.class);
                IntentListItems.putExtra("article", ListArticle);
                startActivity(IntentListItems);
            }
        });

        //Bouton vers "Mettre à jour un article"
        Button buttonMainUpdate = (Button)findViewById(R.id.buttonUpdateItem);
        buttonMainUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IntentUpdateItems = new Intent(MainActivity.this, ModifArticle.class);
                IntentUpdateItems.putExtra("article", ListArticle);;
                startActivity(IntentUpdateItems);
            }
        });
    }

    @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.main_menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            switch(item.getItemId()){
                case(R.id.menuAjout) :
                    Intent ajoutArticle = new Intent(MainActivity.this, Ajout_article.class);
                    startActivity(ajoutArticle);
                    return true;
                case (R.id.menuListe) :
                    Intent listeArticle = new Intent(MainActivity.this, ListeArticle.class);
                    startActivity(listeArticle);
                    return true;
                case (R.id.menuModif):
                    Intent majArticle = new Intent(MainActivity.this, ModifArticle.class);
                    startActivity(majArticle);
                    return true;
                default :
                    return super.onOptionsItemSelected(item);
            }
        }
    private boolean b1 = false;
    //ArrayList Article
    private ArrayList<Article> ListArticle = new ArrayList<>();
}