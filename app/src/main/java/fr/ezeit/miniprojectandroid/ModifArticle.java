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

        Button BackButton = (Button)findViewById(R.id.buttonModifRetour);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nom = ptnom.getText().toString();
                description = ptdescription.getText().toString();
                price = ptprice.getText().toString();
                amount = ptamount.getText().toString();

                Log.d("contenu nom", nom);
                try{
                    if(nom.isEmpty() && description.isEmpty()){
                        nom = "pomme";
                        description = "calotte";
                        price = "44";
                        amount="1";
                        Article article = new Article(nom, description, Double.parseDouble(price), Integer.parseInt(amount));
                        finalListArticle.add(article);
                    } else {
                        Article article = new Article(nom, description, Double.parseDouble(price), Integer.parseInt(amount));
                        finalListArticle.add(article);
                    }
                } catch (Exception e){
                    System.out.println("34");
                }

                Intent IntentEditItem = new Intent(ModifArticle.this, MainActivity.class);
                IntentEditItem.putExtra("article", finalListArticle);
                startActivity(IntentEditItem);
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
                Intent ajoutArticle = new Intent(ModifArticle.this, Ajout_article.class);
                startActivity(ajoutArticle);
                return true;
            case (R.id.menuListe) :
                Intent listeArticle = new Intent(ModifArticle.this, ListeArticle.class);
                startActivity(listeArticle);
                return true;
            case (R.id.menuModif):
                Intent majArticle = new Intent(ModifArticle.this, ModifArticle.class);
                startActivity(majArticle);
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }

    private String nom;
    private String description;
    private String price;
    private String amount;
}