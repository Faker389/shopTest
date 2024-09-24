package com.example.sklep;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // EdgeToEdge.enable(this); // Remove or replace with valid edge-to-edge handling
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String text = intent.getStringExtra("imageTitle");
        int imageResource = intent.getIntExtra("imagesrc", 0);

        ImageView returnButton = findViewById(R.id.imageView7);
        EditText ed1 = findViewById(R.id.editTextText);
        TextView cena = findViewById(R.id.textView6);
        ImageView logo = findViewById(R.id.imageView5);
        TextView data = findViewById(R.id.textView4);

        logo.setImageResource(imageResource);
        data.setText(text);
        // Navigate back to MainActivity
        returnButton.setOnClickListener(v -> {
            Intent intent2 = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent2);
        });

        // Add a TextWatcher to handle input changes
        ed1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                // No need to handle this method if you're not using it
                cena.setText("");

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                String str = "";
                try {
                    // Correctly convert CharSequence to String
                    int number = Integer.parseInt(charSequence.toString());

                    // Update the text based on the number
                    str = "Cena: " + number * 150000;
                    cena.setText(str);
                } catch (NumberFormatException e) {
                    // Handle invalid input (non-numeric)
                    str = "Wpisz poprawna ilosc";
                    cena.setText(str);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // No need to handle this method if you're not using it
            }
        });

        // Handling window insets for padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            if (insets != null) {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            }
            return insets;
        });
    }
}
