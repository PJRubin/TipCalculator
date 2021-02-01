package css.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    EditText etBillAmount;
    EditText etNumber;
    CheckBox cbService;
    Button bCalculate;
    TextView tvTotal;
    TextView tvSplitTotal;
    SeekBar sbNumber;

    //comment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBillAmount = (EditText) findViewById(R.id.editTextBillAmount);
        etNumber =  (EditText) findViewById(R.id.editTextNumber);
        cbService = (CheckBox) findViewById(R.id.checkBoxService);
        bCalculate = (Button) findViewById(R.id.buttonCalculate);
        tvTotal = (TextView) findViewById(R.id.textViewTotal);
        tvSplitTotal = (TextView) findViewById(R.id.textViewSplitTotal);
        sbNumber = (SeekBar) findViewById(R.id.seekBarNumber);

        sbNumber.setMin(1);
        // not sure how to set the minimum without messing up the visual on the app

        sbNumber.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int num = sbNumber.getProgress();
                etNumber.setText(num + "");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        bCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbService.isChecked())
                {
                    double tip = (Double.parseDouble(etBillAmount.getText().toString())) * 0.20;
                    double splitTip = tip / Double.parseDouble(etNumber.getText().toString());

                    tvTotal.setText(NumberFormat.getCurrencyInstance().format( tip ));
                    tvSplitTotal.setText(NumberFormat.getCurrencyInstance().format( splitTip ));
                }
                else
                {
                    double tip = (Double.parseDouble(etBillAmount.getText().toString())) * 0.15;
                    double splitTip = tip / Double.parseDouble(etNumber.getText().toString());

                    tvTotal.setText(NumberFormat.getCurrencyInstance().format( tip ));
                    tvSplitTotal.setText(NumberFormat.getCurrencyInstance().format( splitTip ));
                }
            }
        });




    }
}