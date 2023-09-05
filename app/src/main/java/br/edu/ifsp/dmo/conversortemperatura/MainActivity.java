package br.edu.ifsp.dmo.conversortemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.ifsp.dmo.conversortemperatura.model.CelsiusStrategy;
import br.edu.ifsp.dmo.conversortemperatura.model.ConversorTemperatura;
import br.edu.ifsp.dmo.conversortemperatura.model.FahrenheitStrategy;
import br.edu.ifsp.dmo.conversortemperatura.model.KelvinStrategy;

public class MainActivity extends AppCompatActivity {

    private EditText inputEditText;
    private Button celsiusButton;
    private Button fahrenheitButton;
    private Button kelvinButton;
    private TextView saidaTextView;
    private TextView msgSaidaTextView;
    private ConversorTemperatura conversorStrategy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findById();
        setClick();
    }

    private void setClick() {
        celsiusButton.setOnClickListener(
                 view -> processo(CelsiusStrategy.getInstance(), "ºC")
        );

        fahrenheitButton.setOnClickListener(
                view -> processo(FahrenheitStrategy.getInstance(), "ºF" )
        );

        kelvinButton.setOnClickListener(
                view -> processo(KelvinStrategy.getInstance(), "K" )
        );
    }

    private double lerTemperatura() throws NumberFormatException{
        double retorno;
        try {
            retorno = Double.parseDouble(inputEditText.getText().toString());
        } catch (NumberFormatException e){
            Toast.makeText(this, "Erro na leitura de dados", Toast.LENGTH_SHORT).show();
            throw new NumberFormatException();
        }
        return retorno;
    }

    private void processo(ConversorTemperatura strategy, String escala) {
        conversorStrategy = strategy;
        double value;
        try {
            value = lerTemperatura();
            saidaTextView.setText(String.format("%.2f %s", conversorStrategy.converter(value), escala));
            if (escala.equals("ºC")){
                msgSaidaTextView.setText(getString(R.string.msgFtoC));
            }else if (escala.equals("K")){
                msgSaidaTextView.setText(getString(R.string.msgCtoK));
            }
            else {
                msgSaidaTextView.setText(getString(R.string.msgCtoF));
            }
        } catch (NumberFormatException e){
            value = 0;
        }
    }

    private void findById() {
        inputEditText = findViewById(R.id.edittext_temperatura);
        celsiusButton = findViewById(R.id.btn_celsius);
        fahrenheitButton = findViewById(R.id.btn_fahrenheit);
        kelvinButton = findViewById(R.id.btn_kelvin);
        saidaTextView = findViewById(R.id.textview_resultado);
        msgSaidaTextView = findViewById(R.id.textview_resultado2);
    }
}