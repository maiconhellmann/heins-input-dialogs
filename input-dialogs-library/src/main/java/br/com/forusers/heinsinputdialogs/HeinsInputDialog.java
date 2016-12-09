package br.com.forusers.heinsinputdialogs;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import br.com.forusers.heinsinputdialogs.interfaces.OnInputDoubleListener;

public class HeinsInputDialog extends AlertDialog.Builder implements View.OnClickListener {

    private String hint;
    private String value;
    private AlertDialog dialog;

    private Button positiveButton;
    private Button negativeButton;
    private Button neutralButton;
    private TextInputEditText editText;
    private TextInputLayout editTextLayout;
    private LinearLayout rootView;

    private OnInputDoubleListener onInputDoubleListener;
    private DialogInterface.OnClickListener onClickPositiveListener;
    private DialogInterface.OnClickListener onClickNegativeListener;
    private DialogInterface.OnClickListener onClickNeutralListener;

    public HeinsInputDialog(@NonNull Context context) {
        super(context);
        setCustomView();
    }

    public HeinsInputDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        setCustomView();
    }

    @Override
    public AlertDialog show() {
        this.dialog = super.show();

        init();

        return dialog;
    }

    private void init() {
        value= value == null ? "" : value;
        hint= hint == null ? "" : hint;

        initComponents();
        initListeners();

        setViews();
    }

    private void setViews(){
        editTextLayout.setHint(hint);
    }

    public void setHint(String string){
        hint = string;
    }
    public void setHint(@StringRes int res){
        hint = getContext().getString(res);
    }
    public void setValue(String string){
        value=string;
    }

    private void initComponents() {
        editText = (TextInputEditText)dialog.findViewById(R.id.inputDialog_editText);
        editTextLayout = (TextInputLayout)dialog.findViewById(R.id.inputDialog_editTextLayout);
        rootView = (LinearLayout)dialog.findViewById(R.id.inputDialog_root);

        positiveButton = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
        negativeButton = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        neutralButton = dialog.getButton(DialogInterface.BUTTON_NEUTRAL);
    }

    private void initListeners() {
        if(positiveButton != null) {
            positiveButton.setOnClickListener(this);
        }

        if(negativeButton != null) {
            negativeButton.setOnClickListener(this);
        }

        if(neutralButton != null) {
            neutralButton.setOnClickListener(this);
        }
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == positiveButton.getId()){
            onclickPositiveButton();
        }else if(view.getId() == negativeButton.getId()){
            onclickNegativeButton();
        }else if(view.getId() == neutralButton.getId()){
            onclickNeutralButton();
        }
    }

    private void onclickPositiveButton() {
        if(onInputDoubleListener != null){
            boolean consumedEvent = onInputDoubleListener.onInputDouble(this.dialog, parseDoubleValue());

            if(!consumedEvent){
                dialog.dismiss();
            }
        }else if (onClickPositiveListener != null){
            onClickPositiveListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
        }else if (onClickNegativeListener != null){
            onClickNegativeListener.onClick(dialog, DialogInterface.BUTTON_NEGATIVE);
        }else if (onClickNeutralListener != null){
            onClickNeutralListener.onClick(dialog, DialogInterface.BUTTON_NEUTRAL);
        }
    }

    private Double parseDoubleValue() {
        Double doubleValue = 0.0;
        if(!value.trim().isEmpty() && !value.equals(",")) {
            String strValue = value.replace(",", ".");
            doubleValue = Double.valueOf(strValue);
        }
        return doubleValue;
    }

    private void onclickNegativeButton() {

    }

    private void onclickNeutralButton() {

    }

    private void setCustomView(){
        super.setView(R.layout.dialog_input);
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
}
