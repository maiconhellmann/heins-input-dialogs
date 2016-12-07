package br.com.forusers.heinsinputdialogs;

import android.content.Context;
import android.content.DialogInterface;
import android.renderscript.Double2;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * Created by hellmanss on 07/12/16.
 */
public class CalculatorAlertDialog extends AlertDialog.Builder implements View.OnClickListener {
    /**
     * Dialog reference
     */
    private AlertDialog dialog;

    /**
     * input Value
     */
    private Double value;

    //Components
    private AppCompatEditText valueEditText;
    private TextView currencyTextView;
    private ImageButton backspaceButtun;
    private Button dotButton;
    private Button equalButton;
    private Button oneButton;
    private Button twoButton;
    private Button threeButton;
    private Button fourButton;
    private Button fiveButton;
    private Button sixButton;
    private Button sevenButton;
    private Button eightButton;
    private Button nineButton;
    private Button zeroButton;

    public CalculatorAlertDialog(@NonNull Context context) {
        super(context);

        super.setView(R.layout.dialog_calculator);
    }

    public CalculatorAlertDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);

        super.setView(R.layout.dialog_calculator);
    }

    @Override
    public AlertDialog show() {

        AlertDialog dialog = super.show();

        this.dialog = dialog;

        init();

        return dialog;

    }

    private void init() {
        value = 0.0;
        initComponents();
        initListeners();

        setViews();
    }

    private void initComponents() {
        valueEditText = (AppCompatEditText)dialog.findViewById(R.id.calculator_value);
        currencyTextView = (TextView)dialog.findViewById(R.id.calculator_currency);
        backspaceButtun = (ImageButton)dialog.findViewById(R.id.calculator_backspace);
        nineButton= (Button)dialog.findViewById(R.id.calculator_9);
        eightButton= (Button)dialog.findViewById(R.id.calculator_8);
        sevenButton= (Button)dialog.findViewById(R.id.calculator_7);
        sixButton= (Button)dialog.findViewById(R.id.calculator_6);
        fiveButton= (Button)dialog.findViewById(R.id.calculator_5);
        fourButton= (Button)dialog.findViewById(R.id.calculator_4);
        threeButton= (Button)dialog.findViewById(R.id.calculator_3);
        twoButton= (Button)dialog.findViewById(R.id.calculator_2);
        oneButton= (Button)dialog.findViewById(R.id.calculator_1);
        zeroButton= (Button)dialog.findViewById(R.id.calculator_0);
        equalButton= (Button)dialog.findViewById(R.id.calculator_eq);
        dotButton= (Button)dialog.findViewById(R.id.calculator_dot);
    }
    private void initListeners() {
        valueEditText.setOnClickListener(this);
        currencyTextView.setOnClickListener(this);
        backspaceButtun.setOnClickListener(this);
        nineButton.setOnClickListener(this);
        eightButton.setOnClickListener(this);
        sevenButton.setOnClickListener(this);
        sixButton.setOnClickListener(this);
        fiveButton.setOnClickListener(this);
        fourButton.setOnClickListener(this);
        threeButton.setOnClickListener(this);
        twoButton.setOnClickListener(this);
        oneButton.setOnClickListener(this);
        zeroButton.setOnClickListener(this);
        equalButton.setOnClickListener(this);
        dotButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == zeroButton.getId()){
            onClickZeroButton();
        }else if(view.getId() == oneButton.getId()){
            onClickOneButton();
        }else if(view.getId() == twoButton.getId()){
            onClickTwoButton();
        }else if(view.getId() == threeButton.getId()){
            onClickThreeButton();
        }else if(view.getId() == fourButton.getId()){
            onClickFourButton();
        }else if(view.getId() == fiveButton.getId()){
            onClickFiveButton();
        }else if(view.getId() == sixButton.getId()){
            onClickSixButton();
        }else if(view.getId() == sevenButton.getId()){
            onClickSevenButton();
        }else if(view.getId() == eightButton.getId()){
            onClickEightButton();
        }else if(view.getId() == nineButton.getId()){
            onClickNineButton();
        }else if(view.getId() == dotButton.getId()){
            onClickDotButton();
        }else if(view.getId() == equalButton.getId()){
            onClickEqualButton();
        }else if(view.getId() == currencyTextView.getId()){
            onClickCurrencyTextView();
        }else if(view.getId() == valueEditText.getId()){
            onClickValueEditText();
        }else if(view.getId() == backspaceButtun.getId()){
            onClickBackspaceButton();
        }
    }

    private void onClickThreeButton() {
        concatValue("3");
    }

    private void onClickFourButton() {
        concatValue("4");

    }

    private void onClickTwoButton() {
        concatValue("2");

    }

    private void onClickFiveButton() {
        concatValue("5");

    }

    private void onClickSixButton() {
        concatValue("6");

    }

    private void onClickSevenButton() {
        concatValue("7");

    }

    private void onClickDotButton() {
        //TODO
    }

    private void onClickEqualButton() {
        //TODO
    }

    private void onClickNineButton() {
        concatValue("9");
    }

    private void onClickEightButton() {
        concatValue("8");
    }

    private void onClickOneButton() {
        concatValue("1");
    }

    private void onClickZeroButton() {
        concatValue("0");
    }

    private void onClickCurrencyTextView() {
        //TODO
    }

    private void onClickValueEditText() {
        //TODO
    }

    private void onClickBackspaceButton() {
        String strValue = value.toString();

        strValue = strValue.length() > 0 ? strValue.substring(0, strValue.length()-1): "0.0";

        value = Double.valueOf(strValue);

        setViews();
    }

    private void concatValue(String strToConcat){
        String valueStr = value == 0.0 ? "" : value.toString();

        valueStr = valueStr.concat(strToConcat);

        value = Double.valueOf(valueStr);

        setViews();
    }

    private void setViews(){
        valueEditText.setText(value == 0.0 ? "0" : value.toString());
    }
}
