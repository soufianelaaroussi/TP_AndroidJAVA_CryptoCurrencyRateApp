package com.isitw.exam;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Map<String, Double> currencyRates = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        TextView resultTextView = findViewById(R.id.result);
        Button btnUsd = findViewById(R.id.btnUsd);
        Button btnEur = findViewById(R.id.btnEur);
        Button btnMad = findViewById(R.id.btnMad);
        Spinner cryptoSpinner = findViewById(R.id.cryptoSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.crypto_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cryptoSpinner.setAdapter(adapter);

        cryptoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long rowId) {
                fetchCurrencyData(requestQueue, cryptoSpinner.getSelectedItem().toString(), resultTextView);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No action needed
            }
        });

        btnUsd.setOnClickListener(view -> displayCurrencyRate("USD", resultTextView));
        btnEur.setOnClickListener(view -> displayCurrencyRate("EUR", resultTextView));
        btnMad.setOnClickListener(view -> displayCurrencyRate("MAD", resultTextView));
    }

    private void fetchCurrencyData(RequestQueue requestQueue, String cryptoName, TextView resultTextView) {
        String url = "https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/" + getCryptoAbbreviation(cryptoName) + ".json";
        JsonObjectRequest request = new JsonObjectRequest(url, null,
                response -> {
                    try {
                        JSONObject jsonObject = response.getJSONObject(getCryptoAbbreviation(cryptoName));
                        currencyRates.put("USD", jsonObject.getDouble("usd"));
                        currencyRates.put("EUR", jsonObject.getDouble("eur"));
                        currencyRates.put("MAD", jsonObject.getDouble("mad"));
                    } catch (Exception e) {
                        Log.e("FetchError", "Error fetching currency data: " + e.getMessage());
                        resultTextView.setText("Error fetching data");
                    }
                },
                error -> Log.e("FetchError", "Volley Error: " + error.getMessage()));

        requestQueue.add(request);
    }

    private void displayCurrencyRate(String currency, TextView resultTextView) {
        if (currencyRates.containsKey(currency)) {
            resultTextView.setText(String.valueOf(currencyRates.get(currency)));
        } else {
            resultTextView.setText("Rate not available");
        }
    }

    private String getCryptoAbbreviation(String name) {
        switch (name) {
            case "Bitcoin":
                return "btc";
            case "Ethereum":
                return "eth";
            case "Ripple":
                return "rpl";
            case "Litecoin":
                return "ltc";
            default:
                return "btc";
        }
    }
}