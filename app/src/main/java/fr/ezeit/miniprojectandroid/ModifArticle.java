package fr.ezeit.miniprojectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class ModifArticle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_article);

        ArrayList<Article> ListArticle = new ArrayList<>();
        ArrayList<Article> finalListArticle = ListArticle;

        if (getIntent().getSerializableExtra("article")==null) { // Instanciation de la liste d’article
            ListArticle.add(new Article("iPhone 14 Pro Max", "256Go", 1609, 1));
        } else{
            ListArticle = (ArrayList<Article>) getIntent().getSerializableExtra("article");
        }

        EditText ptnom = (EditText)findViewById(R.id.editViewNomArticle);
        EditText ptdescription = (EditText)findViewById(R.id.editViewDesArticle);
        EditText ptprice = (EditText)findViewById(R.id.editViewPrixArticle);
        EditText ptamount = (EditText)findViewById(R.id.editViewQteArticle);

        /*final ArrayList<Article>[] ListArticlex = new ArrayList[]{new ArrayList<>()};
        for (Article articles : ListArticlex[0]){
            ptnom.setText(articles.getName());
            ptdescription.setText(articles.getDescription());
            ptdescription.setText((int) articles.getPrice());
            ptamount.setText(articles.getAmount());
        }*/



        //Intent intent = new Intent(ModifArticle.this, ListeArticle.class);
        //intent.putExtra("article", finalListArticle);
        //startActivity(intent);

        Button BackButton = (Button)findViewById(R.id.buttonModifRetour);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nom = ptnom.getText().toString();
                description = ptdescription.getText().toString();
                price = ptprice.getText().toString();
                amount = ptamount.getText().toString();

                Article article = new Article(nom, description, Double.parseDouble(price), Integer.parseInt(amount));
                finalListArticle.add(article);

                Intent IntentEditItem = new Intent(ModifArticle.this, MainActivity.class);
                IntentEditItem.putExtra("article", finalListArticle);
                startActivity(IntentEditItem);
            }
        });
    }
    private String nom;
    private String description;
    private String price;
    private String amount;
}