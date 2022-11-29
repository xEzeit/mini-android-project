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

        Button buttonMainAddItem = (Button)findViewById(R.id.buttonAddAddItem);

        buttonMainAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Ajout_article.class);
                startActivity(intent);
                //ListArticle.add(new Article("iPhone 14 Pro Max", "Apple Device,", 1609, 1));
            }
        });
    }

    private ArrayList<Article> ListArticle = new ArrayList<>();
}