package net.agusharyanto.bekasicafe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText editTextJumlah;
    private EditText editTextHarga;
    private TextView textViewTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextJumlah = (EditText) findViewById(R.id.editTextJumlah);
        editTextHarga = (EditText) findViewById(R.id.editTextHarga);
        textViewTotal = (TextView) findViewById(R.id.textViewTotalHarga);

        editTextJumlah.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               if (count !=0){

                   hitung();
               }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void hitungHarga(View view) {
        hitung();
    }

    private void hitung(){
        int jumlah = Integer.parseInt(editTextJumlah.getText().toString());
        int harga = Integer.parseInt(editTextHarga.getText().toString());
        int totalbayar = jumlah * harga;
        String bayar = "Harga Total adalah "+customFormat("###,###,###,###",totalbayar);
        textViewTotal.setText(bayar);

    }


     public String customFormat(String pattern, int value ) {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        return output;
    }
}
