package br.com.opet.tds.dividedespesas;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText editDespesa;
    private SeekBar seekQtdePessoas;
    private TextView textQtdePessoas;
    private TextView textDivisaoDespesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editDespesa = (EditText) findViewById(R.id.editDespesa);
        seekQtdePessoas = (SeekBar) findViewById(R.id.seekQtdePessoas);
        textQtdePessoas = (TextView) findViewById(R.id.textTotalPessoas);
        textDivisaoDespesa = (TextView) findViewById(R.id.textDivisaoDespesa);

        seekQtdePessoas.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(!editDespesa.getText().toString().isEmpty() && progress != 0){
                    double totalDespesa = Double.parseDouble(editDespesa.getText().toString());
                    double despesa = totalDespesa / progress;
                    textDivisaoDespesa.setText(String.valueOf(despesa));
                    textQtdePessoas.setText(String.valueOf(progress));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(seekBar.getProgress() == 0){
                    seekBar.setProgress(1);
                }
            }
        });
    }
}
