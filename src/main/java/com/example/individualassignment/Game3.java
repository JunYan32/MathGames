package com.example.individualassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Game3 extends AppCompatActivity {

    private EditText editTextNumber1, editTextNumber2;
    private TextView textViewTargetNumber, textViewResult;
    private int targetNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3);

        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        textViewTargetNumber = findViewById(R.id.textViewTargetNumber);
        textViewResult = findViewById(R.id.textViewResult);

        generateTargetNumber();
    }

    private void generateTargetNumber() {
        Random random = new Random();
        targetNumber = random.nextInt(21); // Generate a random number between 0 and 20
        textViewTargetNumber.setText(String.valueOf(targetNumber));
    }

    public void checkNumbers(View view) {
        String number1Str = editTextNumber1.getText().toString();
        String number2Str = editTextNumber2.getText().toString();

        if (!number1Str.isEmpty() && !number2Str.isEmpty()) {
            int number1 = Integer.parseInt(number1Str);
            int number2 = Integer.parseInt(number2Str);

            if (number1 + number2 == targetNumber) {
                textViewResult.setText("Correct! " + number1 + " + " + number2 + " = " + targetNumber);
                generateTargetNumber(); // Generate a new target number for the next round
            } else {
                textViewResult.setText("Incorrect! Try again.");
            }
        } else {
            textViewResult.setText("Please enter both numbers.");
        }
    }
}