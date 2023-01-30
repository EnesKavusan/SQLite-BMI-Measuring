package com.example.vize2vki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    Button bt;
    Float kilo,boy,BKI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=findViewById(R.id.editTextNumberSigned);
        et2=findViewById(R.id.editTextNumberSigned2);
        bt=findViewById(R.id.button);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et1.getText().toString().equals("") || et2.getText().toString().equals("")) {

                    Toast.makeText(MainActivity.this, "Değerleri giriniz", Toast.LENGTH_SHORT).show();

                }else{
                    kilo=Float.parseFloat(et1.getText().toString());
                    boy=Float.parseFloat(et2.getText().toString());
                    BKI= kilo/(boy*boy);
                    if(BKI < 18.50) {
                        System.out.println("Zayıf");
                    }
                    else if(BKI < 24.99 && BKI>18.50) {
                        System.out.println("Sağlıklı Kilolu");
                    }
                    else if(BKI < 25 && BKI < 29.99) {
                        System.out.println("Aşırı Kilolu");
                    }
                    else if(BKI > 30) {
                        System.out.println("Obez");
                    }






                }
                Intent yeniaktivite = new Intent(MainActivity.this,MainActivity2.class);
                yeniaktivite.putExtra("Sonuc",BKI);
                startActivity(yeniaktivite);
        }

    });
    }
}