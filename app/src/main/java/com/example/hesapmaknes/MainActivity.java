package com.example.hesapmaknes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button
            sıfır, button1, button2, button3, button4, button5, button6, button7, button8, button9,
            çarpı, bölü, temizle, çıkar, topla, modalma,buttoneşittir, nokta;

    EditText display;
    private float ilkdeger = 0;
    private float ikincideger = 0;
    private String islem;

    boolean toplama, cikarma, carpma, bolme,modAlma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sıfır = findViewById(R.id.sıfır);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        çarpı = findViewById(R.id.çarpı);
        bölü = findViewById(R.id.bölü);
        çıkar = findViewById(R.id.çıkar);
        topla = findViewById(R.id.topla);
        modalma=findViewById(R.id.modalma);
        buttoneşittir = findViewById(R.id.buttoneşittir);
        nokta = findViewById(R.id.nokta);
        temizle = findViewById(R.id.temizle);

        display = findViewById(R.id.hesapekrani);//Displayı hesap ekranında gösterdim.

        display.setShowSoftInputOnFocus(false);//Bu komutu klavyenin çıkamaması için yazdık.

        //Display=komutu ile bastığım tuşu ekranda gösterdim.

        sıfır.setOnClickListener(view -> {
            ekranaYaz(0);
        });
        button1.setOnClickListener(view -> {
            ekranaYaz(1);
        });
        button2.setOnClickListener(view -> {
            ekranaYaz(2);
        });
        button3.setOnClickListener(view -> {
            ekranaYaz(3);
        });
        button4.setOnClickListener(view -> {
            ekranaYaz(4);
        });
        button5.setOnClickListener(view -> {
            ekranaYaz(5);
        });
        button6.setOnClickListener(view -> {
            ekranaYaz(6);
        });
        button7.setOnClickListener(view -> {
            ekranaYaz(7);
        });
        button8.setOnClickListener(view -> {
            ekranaYaz(8);
        });
        button9.setOnClickListener(view -> {
            ekranaYaz(9);
        });
        topla.setOnClickListener(view -> {

            toplaClick();
        });
        çıkar.setOnClickListener(view -> {
            çıkarClick();
        });
        çarpı.setOnClickListener(view -> {
            çarpClick();
        });
        bölü.setOnClickListener(view -> {
            bölClick();
        });
        modalma.setOnClickListener(view -> {
            modalmaClick();

        });
        buttoneşittir.setOnClickListener(view -> {
            sonucugösterClick();
        });
        nokta.setOnClickListener(view -> {
            display.setText(display.getText() + ".");
        });
        temizle.setOnClickListener(view -> {
            display.setText(""); //ekrani temizleme kodu
        });
    }

    public void ekranaYaz(int sayi){
        //temizleClick();
        display.setText(display.getText() + String.valueOf(sayi));

    }

    public void sonucugösterClick() {

        ikincideger = Float.parseFloat(display.getText().toString());

        if (carpma){

            temizleClick();
            carpma = false;
            float sonuc = (float) (ilkdeger * ikincideger);
            display.setText(display.getText() + String.valueOf(sonuc));


        }
        ikincideger = Float.parseFloat(display.getText().toString());
         if(toplama){

            temizleClick();
            toplama = false;
            float sonuc = (float) (ilkdeger + ikincideger);
            display.setText(display.getText() + String.valueOf(sonuc));
        }
        ikincideger = Float.parseFloat(display.getText().toString());
         if (cikarma){
            temizleClick();
            toplama = false;
            float sonuc = (float) (ilkdeger - ikincideger);
            display.setText(display.getText() + String.valueOf(sonuc));

        }
        ikincideger = Float.parseFloat(display.getText().toString());
        if (bolme){
            temizleClick();
            bolme = false;
            float sonuc = (float) (ilkdeger / ikincideger);
            display.setText(display.getText() + String.valueOf(sonuc));

        }
        if ( modAlma){
            temizleClick();
            modAlma = false;
            float sonuc = (float) (ilkdeger % ikincideger);
            display.setText(display.getText() + String.valueOf(sonuc));

        }
    }
    public void toplaClick() {
        toplama = true;

        ilkdeger = Float.parseFloat(display.getText().toString());
        temizleClick();
    }

    public void çıkarClick() {
        cikarma = true;

        ilkdeger = Float.parseFloat(display.getText().toString());
        temizleClick();

    }

    public void çarpClick() {

        carpma = true;

        ilkdeger = Float.parseFloat(display.getText().toString());
        temizleClick();
    }

    public void bölClick() {

        bolme = true;

        ilkdeger = Float.parseFloat(display.getText().toString());
        temizleClick();
    }
    public void  modalmaClick() {

         modAlma = true;

        ilkdeger = Float.parseFloat(display.getText().toString());
        temizleClick();
    }


    public void temizleClick() {

        display.setText("");
    }
}