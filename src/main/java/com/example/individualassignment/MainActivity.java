package com.example.individualassignment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editTextNumber1, editTextNumber2;
    Button buttonCompare;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        buttonCompare = findViewById(R.id.buttonCompare);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String num1Str = editTextNumber1.getText().toString();
                    String num2Str = editTextNumber2.getText().toString();

                    if(num1Str.isEmpty() || num2Str.isEmpty()) {
                        textViewResult.setText("Please enter both numbers");
                        return;
                    }

                    int num1 = Integer.parseInt(num1Str);
                    int num2 = Integer.parseInt(num2Str);

                    if (num1 > num2) {
                        textViewResult.setText(num1 + " is greater than " + num2);
                    } else if (num1 < num2) {
                        textViewResult.setText(num1 + " is less than " + num2);
                    } else {
                        textViewResult.setText("Both numbers are equal");
                    }
                } catch (NumberFormatException e) {
                    textViewResult.setText("Invalid input. Please enter valid numbers.");
                }
            }
        });
    }
}

