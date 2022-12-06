package fr.ezeit.miniprojectandroid;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

import android.content.Context;
import android.util.Log;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Article implements Serializable {
    private String name;
    private String description;
    private double price;
    private int amount;
    private Context context;

    public Article(String name, String description, double price, int amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Article(Context context){
        this.context = context;
    }

    public ArrayList<Article> buildListFromCSV(){
        ArrayList<Article> Phones = new ArrayList<>();
        try {
            FileInputStream fis = context.openFileInput("articles.csv");
            InputStreamReader is = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(is);
            CSVParser parser = CSVFormat.DEFAULT.withDelimiter(';').withHeader().parse(br);
            for(CSVRecord record : parser) {
                Article article = new Article(record.get("name"), record.get("description"), Double.parseDouble(record.get("price")), parseInt(record.get("amount")));
                Phones.add(article);
            }
        } catch (IOException e) {
            Log.wtf("MyActivity", " [ERREUR] LECTURE DE FICHIER : "+ e);
            e.printStackTrace();
        }
        return Phones;
    }

    public void pushToCSV(String csvData) throws IOException {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("articles.csv", Context.MODE_APPEND));
            outputStreamWriter.write(csvData);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e);
        }
    }

}