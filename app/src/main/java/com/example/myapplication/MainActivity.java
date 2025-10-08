package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity  {
EditText edUserInput;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edUserInput = (EditText) findViewById(R.id.edUserInput);
        Spinner spCountingOptions = (Spinner) findViewById(R.id.spCountingOptions);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.User_selections,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCountingOptions.setAdapter(adapter);

        spCountingOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
               String selectedItem = parentView.getItemAtPosition(position).toString();

               if(selectedItem.equals("Chars")) {

                   String userInput = edUserInput.getText().toString();
                  int charsCountStatic = CharsCounter.countCharsStatic("Hello World");

                  CharsCounter cc = new CharsCounter();
                   int charsCount = cc.countChars("Hello World");


                   Toast.makeText(MainActivity.this, String.valueOf(charsCountStatic), Toast.LENGTH_SHORT).show();
               }
            }



            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });


    }


}