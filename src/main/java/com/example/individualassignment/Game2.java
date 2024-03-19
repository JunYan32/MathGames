package com.example.individualassignment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;

public class Game2 extends AppCompatActivity {
    EditText editTextNumbers;
    RadioGroup radioGroupOrder;
    Button buttonOrder;
    TextView textViewOrderedNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        editTextNumbers = findViewById(R.id.editTextNumbers);
        radioGroupOrder = findViewById(R.id.radioGroupOrder);
        buttonOrder = findViewById(R.id.buttonOrder);
        textViewOrderedNumbers = findViewById(R.id.textViewOrderedNumbers);

        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numbersStr = editTextNumbers.getText().toString();

                if (!numbersStr.isEmpty()) {
                    try {
                        String[] numbersArray = numbersStr.split(",");
                        ArrayList<Integer> numbersList = new ArrayList<>();

                        for (String numStr : numbersArray) {
                            numbersList.add(Integer.parseInt(numStr.trim()));
                        }

                        int checkedRadioButtonId = radioGroupOrder.getCheckedRadioButtonId();
                        RadioButton radioButton = findViewById(checkedRadioButtonId);
                        String orderType = radioButton.getText().toString();

                        if (orderType.equals("Ascending")) {
                            Collections.sort(numbersList);
                        } else {
                            Collections.sort(numbersList, Collections.reverseOrder());
                        }

                        StringBuilder orderedNumbers = new StringBuilder();
                        for (int num : numbersList) {
                            orderedNumbers.append(num).append(", ");
                        }

                        textViewOrderedNumbers.setText(orderedNumbers.toString());
                    } catch (NumberFormatException e) {
                        textViewOrderedNumbers.setText("Invalid input. Please enter valid numbers separated by commas.");
                    }
                }
            }
        });
    }
}
