package com.babyapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends Activity {
    
    private EditText editAge;
    private TextView textResult;
    private Button btnCalculate;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        editAge = findViewById(R.id.editAge);
        textResult = findViewById(R.id.textResult);
        btnCalculate = findViewById(R.id.btnCalculate);
        
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBabySize();
            }
        });
    }
    
    private void calculateBabySize() {
        String ageStr = editAge.getText().toString();
        if (ageStr.isEmpty()) {
            textResult.setText("Masukkan umur bayi");
            return;
        }
        
        int age = Integer.parseInt(ageStr);
        String size;
        
        if (age <= 3) size = "Newborn (56-62 cm)";
        else if (age <= 6) size = "Size 3M (62-68 cm)";
        else if (age <= 9) size = "Size 6M (68-74 cm)";
        else if (age <= 12) size = "Size 12M (74-80 cm)";
        else size = "Ukuran toddler";
        
        textResult.setText("Ukuran: " + size);
    }
}
