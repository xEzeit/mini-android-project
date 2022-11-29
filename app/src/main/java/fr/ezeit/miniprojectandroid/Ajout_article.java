package fr.ezeit.miniprojectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Ajout_article extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_article);

        Button buttonAddAddItem = (Button)findViewById(R.id.buttonAddAddItem);
        EditText ptnom = (EditText)findViewById(R.id.PTNomAddItem);
        EditText ptdescription = (EditText)findViewById(R.id.PTdescriptionAddItem);
        EditText ptprice = (EditText)findViewById(R.id.PTPriceAddItem);
        EditText ptamount = (EditText)findViewById(R.id.PTAmountAddItem);

        buttonAddAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private String nom;
    private String description;
    private double price;
    private int amount;
}