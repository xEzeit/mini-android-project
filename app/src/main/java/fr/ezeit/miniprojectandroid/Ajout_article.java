package fr.ezeit.miniprojectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Ajout_article extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_article);

        Button buttonAddAddItem = (Button)findViewById(R.id.buttonAddAddItem);
        Button Backbutton = (Button) findViewById(R.id.buttonBackAddItem);
        EditText ptnom = (EditText)findViewById(R.id.PTNomAddItem);
        EditText ptdescription = (EditText)findViewById(R.id.PTdescriptionAddItem);
        EditText ptprice = (EditText)findViewById(R.id.PTPriceAddItem);
        EditText ptamount = (EditText)findViewById(R.id.PTAmountAddItem);

        buttonAddAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nom = ptnom.getText().toString();
                description = ptdescription.getText().toString();
                price = ptprice.getText().toString();
                amount = ptamount.getText().toString();

                String header = "name;description;price;amount\n";
                String phone = nom + ";" + description + ";" + price +  ";" + amount + "\n";
                try {
                    article.pushToCSV(phone);;
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Article article = new Article(nom, description, Double.parseDouble(price), Integer.parseInt(amount));

                Intent intent = new Intent(Ajout_article.this, ListeArticle.class);
                intent.putExtra("article", article);
                startActivity(intent);
            }
        });

        Backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ajout_article.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private ArrayList<Article> phones = new ArrayList<Article>();

    //Intent getphoneslist = getIntent();
    //ArrayList<String> Phones = (ArrayList<String>) getphoneslist.getSerializableExtra("PHONES_ARRAY_LIST");


    private Article article = new Article(this);
    private Context context;
    private String nom;
    private String description;
    private String price;
    private String amount;
}