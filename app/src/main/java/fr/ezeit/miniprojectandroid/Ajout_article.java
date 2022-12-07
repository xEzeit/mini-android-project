package fr.ezeit.miniprojectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Ajout_article extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_article);

        ArrayList<Article> ListArticle = new ArrayList<>();

        if (getIntent().getSerializableExtra("article")==null) { // Instanciation de la liste d’article
            ListArticle.add(new Article("iPhone 14 Pro Max", "256Go", 1609, 1));
        } else{
            ListArticle = (ArrayList<Article>) getIntent().getSerializableExtra("article");
        }

        Button buttonAddAddItem = (Button)findViewById(R.id.buttonAddAddItem);
        Button Backbutton = (Button) findViewById(R.id.buttonBackAddItem);
        EditText ptnom = (EditText)findViewById(R.id.PTNomAddItem);
        EditText ptdescription = (EditText)findViewById(R.id.PTdescriptionAddItem);
        EditText ptprice = (EditText)findViewById(R.id.PTPriceAddItem);
        EditText ptamount = (EditText)findViewById(R.id.PTAmountAddItem);

        ArrayList<Article> finalListArticle = ListArticle;
        buttonAddAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nom = ptnom.getText().toString();
                description = ptdescription.getText().toString();
                price = ptprice.getText().toString();
                amount = ptamount.getText().toString();

                Article article = new Article(nom, description, Double.parseDouble(price), Integer.parseInt(amount));
                finalListArticle.add(article);

                Intent intent = new Intent(Ajout_article.this, ListeArticle.class);
                intent.putExtra("article", finalListArticle);
                startActivity(intent);
            }
        });

        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ajout_article.this, MainActivity.class);
                intent.putExtra("article", finalListArticle);
                startActivity(intent);
            }
        });

    }

    private String nom;
    private String description;
    private String price;
    private String amount;
}