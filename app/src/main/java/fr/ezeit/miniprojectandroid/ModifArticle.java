package fr.ezeit.miniprojectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ModifArticle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif_article);

        Button BackButton = (Button)findViewById(R.id.buttonModifRetour);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IntentEditItem = new Intent(ModifArticle.this, MainActivity.class);
                startActivity(IntentEditItem);
            }
        });

    }

}