package br.com.forusers.heinsinputdialogs.interfaces;

import android.support.v7.app.AlertDialog;

/**
 * Listener to get input value.
 */
public interface OnInputDoubleListener {

    /**
     * Listener to get the double inputed value
     * @param android.support.v7.app.AlertDialog
     * @param java.lang.Double
     * @return true if listener consumes the event
     */
    boolean onInputDouble(AlertDialog dialog, Double value);
}
