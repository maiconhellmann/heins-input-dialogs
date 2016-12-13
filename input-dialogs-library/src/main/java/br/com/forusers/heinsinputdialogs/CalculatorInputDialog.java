package br.com.forusers.heinsinputdialogs;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

import br.com.forusers.heinsinputdialogs.interfaces.OnInputDoubleListener;


/**
 * Created by hellmanss on 07/12/16.
 */
public class CalculatorInputDialog extends AlertDialog.Builder implements View.OnClickListener{

    private static final int MAX_LENGTH = 10;

    /**
     * Dialog reference
     */
    private AlertDialog dialog;

    /**
     * input Value
     */
    private String value;

    /**
     * Listener to double value return
     */
    private OnInputDoubleListener onInputDoubleListener;

    private DialogInterface.OnClickListener onClickPositiveListener;
    private DialogInterface.OnClickListener onClickNegativeListener;
    private DialogInterface.OnClickListener onClickNeutralListener;

    //Components
    private AppCompatEditText valueEditText;
    private TextView currencyTextView;
    private ImageButton backspaceButtun;
    private Button dotButton;
    private Button clearButton;
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
    private Button positiveButton;
    private Button negativeButton;
    private Button neutralButton;
    private String separator;

    public CalculatorInputDialog(@NonNull Context context) {
        super(context);
        setCustomView();
    }

    public CalculatorInputDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        setCustomView();
    }

    public CalculatorInputDialog(@NonNull Context context, OnInputDoubleListener listener) {
        super(context);
        onInputDoubleListener = listener;
        setCustomView();
    }

    public CalculatorInputDialog(@NonNull Context context, @StyleRes int themeResId, OnInputDoubleListener listener) {
        super(context, themeResId);
        onInputDoubleListener = listener;
        setCustomView();
    }

    private void setCustomView(){
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
        value = "";
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
        clearButton = (Button)dialog.findViewById(R.id.calculator_ce);
        dotButton= (Button)dialog.findViewById(R.id.calculator_dot);

        positiveButton = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
        negativeButton = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        neutralButton = dialog.getButton(DialogInterface.BUTTON_NEUTRAL);

        Currency currency = Currency.getInstance(Locale.getDefault());
        currencyTextView.setText(currency.getSymbol());

        separator = String.valueOf(DecimalFormatSymbols.getInstance().getDecimalSeparator());

        dotButton.setText(separator);
    }


    public Double parseDouble(String value) throws ParseException{
        double doubleValue=0.0;

        if(!value.trim().isEmpty() && !value.equals(separator)){
            doubleValue = Double.valueOf(value.replace(",", "."));
        }
        return doubleValue;
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
        clearButton.setOnClickListener(this);
        dotButton.setOnClickListener(this);

        positiveButton.setOnClickListener(this);
        negativeButton.setOnClickListener(this);
        neutralButton.setOnClickListener(this);
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
        }else if(view.getId() == clearButton.getId()){
            onClickClearButton();
        }else if(view.getId() == currencyTextView.getId()){
            onClickCurrencyTextView();
        }else if(view.getId() == valueEditText.getId()){
            onClickValueEditText();
        }else if(view.getId() == backspaceButtun.getId()){
            onClickBackspaceButton();
        }else if(view.getId() == positiveButton.getId()){
            onclickPositiveButton();
        }else if(view.getId() == negativeButton.getId()){
            onclickNegativeButton();
        }else if(view.getId() == neutralButton.getId()){
            onclickNeutralButton();
        }
    }

    private void onclickPositiveButton() {

        try {
            if (onInputDoubleListener != null) {

                boolean consumedEvent = onInputDoubleListener.onInputDouble(this.dialog, parseDoubleValue());

                if (!consumedEvent) {
                    dialog.dismiss();
                }
            } else if (onClickPositiveListener != null) {
                onClickPositiveListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
            } else if (onClickNegativeListener != null) {
                onClickNegativeListener.onClick(dialog, DialogInterface.BUTTON_NEGATIVE);
            } else if (onClickNeutralListener != null) {
                onClickNeutralListener.onClick(dialog, DialogInterface.BUTTON_NEUTRAL);
            }
        }catch (Exception e){
            showErrorMessage(e);
        }
    }

    private Double parseDoubleValue() throws ParseException {
        Double doubleValue = 0.0;
        if(!value.trim().isEmpty() && !value.equals(",")) {
//            String strValue = value.replace(",", ".");
//            doubleValue = Double.valueOf(strValue);
            doubleValue = parseDouble(value);
        }
        return doubleValue;
    }

    private void onclickNegativeButton() {

    }

    private void onclickNeutralButton() {

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
        if(!value.contains(separator)){
            value+= separator;
        }
        setViews();
    }

    private void onClickClearButton() {
        value = "";
        setViews();
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
        Toast.makeText(getContext(), currencyTextView.getText(), Toast.LENGTH_SHORT).show();
    }

    private void onClickValueEditText() {
        Toast.makeText(getContext(), valueEditText.getText(), Toast.LENGTH_SHORT).show();
    }

    private void onClickBackspaceButton() {

        value = value.length() > 0 ? value.substring(0, value.length()-1) : "";

        setViews();
    }

    private void concatValue(String strToConcat){
        if(value.length() < MAX_LENGTH) {
            value += strToConcat;

            setViews();
        }
    }

    private void setViews(){
        valueEditText.setText(value);
    }

    public AlertDialog.Builder setPositiveButton(CharSequence text, OnInputDoubleListener listener) {
        if(text != null && !text.toString().trim().isEmpty()) {
            super.setPositiveButton(text, null);
        }else{
            super.setPositiveButton(android.R.string.ok, null);
        }
        this.onInputDoubleListener = listener;
        return this;
    }

    public AlertDialog.Builder setPositiveButton(@StringRes int text, OnInputDoubleListener listener) {
        this.setPositiveButton(getContext().getString(text), listener);
        return this;
    }
    public AlertDialog.Builder setPositiveButton(OnInputDoubleListener listener) {
        this.setPositiveButton(null, listener);
        return this;
    }

    @Override
    public AlertDialog.Builder setPositiveButton(CharSequence text, DialogInterface.OnClickListener listener) {
        super.setPositiveButton(text,null);
        this.onClickPositiveListener = listener;
        return this;
    }

    @Override
    public AlertDialog.Builder setPositiveButton(@StringRes int textId, DialogInterface.OnClickListener listener) {
        super.setPositiveButton(textId,null);
        this.onClickPositiveListener = listener;
        return this;
    }

    @Override
    public AlertDialog.Builder setNegativeButton(CharSequence text, DialogInterface.OnClickListener listener) {
        super.setNegativeButton(text, null);
        this.onClickNegativeListener = listener;
        return this;
    }

    @Override
    public AlertDialog.Builder setNegativeButton(@StringRes int textId, DialogInterface.OnClickListener listener) {
        super.setNegativeButton(textId, null);
        this.onClickNegativeListener = listener;
        return this;
    }

    @Override
    public AlertDialog.Builder setNeutralButton(CharSequence text, DialogInterface.OnClickListener listener) {
        super.setNeutralButton(text, null);
        this.onClickNeutralListener = listener;
        return this;
    }

    @Override
    public AlertDialog.Builder setNeutralButton(@StringRes int textId, DialogInterface.OnClickListener listener) {
        super.setNeutralButton(textId, null);
        this.onClickNeutralListener = listener;
        return this;
    }

    private void showErrorMessage(Exception e){
        Log.e(getClass().getSimpleName(), getContext().getString(R.string.error), e);

        AlertDialog.Builder b = new AlertDialog.Builder(this.getContext());
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
