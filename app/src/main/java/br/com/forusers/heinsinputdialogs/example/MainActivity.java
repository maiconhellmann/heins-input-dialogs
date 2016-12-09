package br.com.forusers.heinsinputdialogs.example;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.com.forusers.heinsinputdialogs.CalculatorAlertDialog;
import br.com.forusers.heinsinputdialogs.example.R;
import br.com.forusers.heinsinputdialogs.interfaces.OnInputDoubleListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCalculatorInput(View view) {
        CalculatorAlertDialog dialog = new CalculatorAlertDialog(this);

        dialog.setPositiveButton(new OnInputDoubleListener() {
            @Override
            public boolean onInputDouble(AlertDialog dialog, Double value) {
                Toast.makeText(getApplicationContext(),
                        value != null ? value.toString() : getString(R.string.null_value),
                        Toast.LENGTH_SHORT)
                            .show();
                return false;
            }
        });

        dialog.show();
    }
}
