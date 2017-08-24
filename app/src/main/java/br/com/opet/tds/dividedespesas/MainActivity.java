package br.com.opet.tds.dividedespesas;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText editDespesa;
    private SeekBar seekQtdePessoas;
    private TextView textQtdePessoas;
    private TextView textDivisaoDespesa;
    private CheckBox checkBoxAdicional;
    private double adicional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editDespesa = (EditText) findViewById(R.id.editDespesa);
        seekQtdePessoas = (SeekBar) findViewById(R.id.seekQtdePessoas);
        textQtdePessoas = (TextView) findViewById(R.id.textTotalPessoas);
        textDivisaoDespesa = (TextView) findViewById(R.id.textDivisaoDespesa);
        checkBoxAdicional = (CheckBox) findViewById(R.id.checkboxAdicional);

        adicional = 1.0;

        checkBoxAdicional.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                adicional = isChecked ? 1.1 :  1.0;
                double totalDespesa = Double.parseDouble(editDespesa.getText().toString()) * adicional;
                double despesa = totalDespesa / seekQtdePessoas.getProgress();
                textDivisaoDespesa.setText(String.format("%.2f", despesa));
            }
        });

        seekQtdePessoas.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(!editDespesa.getText().toString().isEmpty() && progress != 0){
                    double totalDespesa = Double.parseDouble(editDespesa.getText().toString()) * adicional;
                    double despesa = totalDespesa / progress;
                    textDivisaoDespesa.setText(String.format("%.2f", despesa));
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
