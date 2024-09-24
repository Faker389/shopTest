package com.example.sklep;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public static  int selected = 0;
    public  static  boolean isCenaShown = false;
    public  static  boolean isIloscShown = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        final ImageView auto1 = findViewById(R.id.imageView);
        final ImageView auto2 = findViewById(R.id.imageView2);
        final ImageView auto3 = findViewById(R.id.imageView3);
        final ImageView logo = findViewById(R.id.imageView4);
        final ImageView home = findViewById(R.id.imageView6);
        final Button cena = findViewById(R.id.button7);
        final Button ilosc = findViewById(R.id.button9);
        TextView cenaText = findViewById(R.id.textView2);
        TextView iloscText = findViewById(R.id.textView3);
        auto1.setOnClickListener(v->{
            logo.setImageResource(R.drawable.auto1);
            selected=1;
            cenaText.setText("");
            iloscText.setText("");
            isCenaShown=false;
            isIloscShown=false;
            String data = getString(R.string.dataCar1);
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("imageTitle", data);
            intent.putExtra("imagesrc", R.drawable.auto1);
            startActivity(intent);
        });
        auto2.setOnClickListener(v->{
            logo.setImageResource(R.drawable.auto2);
            selected=2;
            cenaText.setText("");
            iloscText.setText("");
            isCenaShown=false;
            isIloscShown=false;
            String data = getString(R.string.dataCar2);
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("imageTitle", data);
            intent.putExtra("imagesrc", R.drawable.auto2);
            startActivity(intent);
        });
        auto3.setOnClickListener(v->{
            logo.setImageResource(R.drawable.auto3);
            selected=3;
            cenaText.setText("");
            iloscText.setText("");
            isCenaShown=false;
            isIloscShown=false;
            String data = getString(R.string.dataCar3);
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("imageTitle", data);
            intent.putExtra("imagesrc", R.drawable.auto3);
            startActivity(intent);
        });
        home.setOnClickListener(view -> {
            logo.setImageResource(R.drawable.logo2);
            selected=0;
            iloscText.setText("");
            cenaText.setText("");

        });
        cena.setOnClickListener(v->{
            String str = "";
            switch(selected){
                case 0: str="Prosze wybrać produkt";break;
                case 1: str="Cena: $150,000";break;
                case 2: str="Cena: $50,000";break;
                case 3: str="Cena: $100 000";break;
            }
            if(!isCenaShown){
                cenaText.setText(str);
            }else{
                cenaText.setText("");

            }
            isCenaShown=!isCenaShown;

        });
        ilosc.setOnClickListener(v->{
            String str = "";
            switch(selected){
                case 0: str="Prosze wybrać produkt";break;
                case 1: str="Ilość: 30";break;
                case 2: str="Ilość: 15";break;
                case 3: str="Ilość: 8";break;
            }
            iloscText.setText(str);
            if(!isIloscShown){
                iloscText.setText(str);
            }else{
                iloscText.setText("");
            }
            isIloscShown=!isIloscShown;
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}