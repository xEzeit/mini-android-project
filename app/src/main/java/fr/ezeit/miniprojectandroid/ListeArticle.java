package fr.ezeit.miniprojectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ListeArticle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_article);

        ListView List = (ListView) findViewById(R.id.listViewArticle);
        Button Backbutton = (Button) findViewById(R.id.buttonModifRetour);

        //Intent getphoneslist = getIntent();
        //ArrayList<String> Phones = (ArrayList<String>) getphoneslist.getSerializableExtra("PHONES_ARRAY_LIST");

        Article article = (Article) getIntent().getSerializableExtra("article");

        String name = null;
        String desc = null;
        int amount = 0;
        double price = 0;

        // Vérification si aucun article non defini alors name desc amount & price defini sur null & 0.
        if(article != null){
            name = article.getName();
            desc = article.getDescription();
            amount = article.getAmount();
            price = article.getPrice();
        } else {
            name = null;
            desc = null;
            amount = 0;
            price = 0;
        }

        article = new Article(this);

        phones = article.buildListFromCSV();

        //Ligne qui permet de lier une arraylist pour ensuite definir "adapter" dans une ListView
        ArrayAdapter<Article> adapter = new ArrayAdapter<Article>(this, android.R.layout.simple_list_item_1, phones);

        //Ajoute la liste "Phones" dans la ListView(UI) "List".
        List.setAdapter(adapter);

        //Bouton "Retour"
        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListeArticle.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private ArrayList<Article> phones = new ArrayList<Article>();

    private Article article;
}