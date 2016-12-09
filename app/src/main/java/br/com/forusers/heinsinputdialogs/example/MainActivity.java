package br.com.forusers.heinsinputdialogs.example;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

import br.com.forusers.heinsinputdialogs.CalculatorInputDialog;
import br.com.forusers.heinsinputdialogs.HeinsDatePickerDialog;
import br.com.forusers.heinsinputdialogs.HeinsInputDialog;
import br.com.forusers.heinsinputdialogs.interfaces.OnInputDoubleListener;
import br.com.forusers.heinsinputdialogs.interfaces.OnSelectDateListener;

public class MainActivity extends AppCompatActivity {

    private java.util.Date lastDate;
    private Double lastValueCalculator;
    private Double lastDoubleHeinsInputDialog;

    //    Components
    private TextView lastValueValueCalculatorTextView;
    private TextView lastDateTextView;
    private TextView lastDoubleHeinsInputDialogTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        setViews();
    }

    private void initComponents() {
        lastValueValueCalculatorTextView = (TextView) findViewById(R.id.mainActivity_lastDoubleValueCalculatorInputDialog);
        lastDateTextView = (TextView) findViewById(R.id.mainActivity_lastDateValue);
        lastDoubleHeinsInputDialogTextView = (TextView) findViewById(R.id.mainActivity_lastDouble_heinsInputDialog);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_github:
                onClickGithub();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void onClickGithub() {
        try{
            String url = getString(R.string.github_url);
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        } catch (Exception e) {
            showErrorMessage(e);
        }
    }

    private void setViews() {
        lastDateTextView.setText(
                lastDate != null
                        ? getString(R.string.last_value, lastDate.toString())
                        : getString(R.string.last_value, ""));

        lastValueValueCalculatorTextView.setText(
                lastValueCalculator != null
                        ? getString(R.string.last_value, lastValueCalculator.toString())
                        : getString(R.string.last_value, ""));

        lastDoubleHeinsInputDialogTextView.setText(
                lastDoubleHeinsInputDialog != null
                        ? getString(R.string.last_value, lastDoubleHeinsInputDialog.toString())
                        : getString(R.string.last_value, ""));
    }

    public void onClickCalculatorInput(View view) {
        try{
            CalculatorInputDialog dialog = new CalculatorInputDialog(this);

            dialog.setPositiveButton(new OnInputDoubleListener() {
                @Override
                public boolean onInputDouble(AlertDialog dialog, Double value) {
                    lastValueCalculator = value;
                    setViews();
                    return false;
                }
            });

            dialog.show();
        } catch (Exception e) {
            showErrorMessage(e);
        }
    }

    public void onClickHeinsDatePickerDialog(View view) {
        try{

            HeinsDatePickerDialog dialog = new HeinsDatePickerDialog();
            dialog.setListener(new OnSelectDateListener() {
                @Override
                public void onSelectDate(Date date) throws Exception {
                    lastDate = date;
                    setViews();
                }
            });
            dialog.show(getSupportFragmentManager(), getClass().getSimpleName());
        } catch (Exception e) {
            showErrorMessage(e);
        }
    }

    public void onClickHeinsInputDialogDouble(View view) {
        try {
            HeinsInputDialog dialog = new HeinsInputDialog(this);
            dialog.setPositiveButton(new OnInputDoubleListener() {
                @Override
                public boolean onInputDouble(AlertDialog dialog, Double value) {
                    lastDoubleHeinsInputDialog = value;
                    setViews();
                    return false;
                }
            });
            dialog.setTitle(R.string.heins_input_dialog);
            dialog.setHint(R.string.input_value);
            dialog.show();
        } catch (Exception e) {
            showErrorMessage(e);
        }
    }

    private void showErrorMessage(Exception e){
        Log.e(getClass().getSimpleName(), getString(R.string.error), e);

        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle(R.string.error);
        b.setMessage(e.getMessage() != null ? e.getMessage() : e.getClass().getSimpleName());
        b.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        b.show();
    }
}
