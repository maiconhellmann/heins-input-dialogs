# heins-input-dialogs
It is a library with several commonly used Input Dialogs implementations. Impelments follow the guidelines of Google Materials Design and always with a clean and intuitive layout.

  <img src="https://github.com/maiconhellmann/heins-input-dialogs/blob/master/docs/img/main_activity.png" alt="Calculator Input Dialog" width="240px">
  <img src="https://github.com/maiconhellmann/heins-input-dialogs/blob/master/docs/img/calculator_input_dialog.png" alt="Calculator Input Dialog" width="240px">
  <img src="https://github.com/maiconhellmann/heins-input-dialogs/blob/master/docs/img/heins_date_picker_dialog.png" alt="Calculator Input Dialog" width="240px">



## Sample Project
You can download the latest sample APK from this repo here: https://github.com/maiconhellmann/heins-input-dialogs/blob/master/app/app-release.apk

It's also on Google Play:

<a href="https://play.google.com/store/apps/details?id=br.com.forusers.heinsinputdialogs">
    <img src="https://play.google.com/intl/en_us/badges/images/badge_new.png"/>
</a>

Having the sample project installed is a good way to be notified of new releases. Although Watching this repository will allow GitHub to email you whenever I publish a release.

## Gradle Dependency
### Repository
The Gradle dependency not yet available on JCenter.

The minimum API level supported by this library is API 13 (Android 3.1 Honeycomb).

### Dependency
Project _build.gradle_:
```
allprojects {
    repositories {
        // ... other repositories here
        maven { url "http://dl.bintray.com/hellmannmaicon/android" }
    }
}
```
Module/app _build.gradle_:
```
dependencies {
    // ... other dependencies here
    compile 'br.com.forusers.heinsinputdialogs:input-dialogs-library:0.1.3'
}
```

## Calculator Input Dialog
It is an Input Dialog for Double or Long value input.
This component has a double listener: _OnInputDoubleListener_ that must be parameterized by the _setPositiveButton()_ method.

<img src="https://github.com/maiconhellmann/heins-input-dialogs/blob/master/docs/img/calculator_input_dialog.png" alt="Calculator Input Dialog" width="240px">

### Usage

```
//Create instance
CalculatorInputDialog dialog = new CalculatorInputDialog(context);

//Event listener(positive button)
dialog.setPositiveButton(new OnInputDoubleListener() {
    @Override
    public boolean onInputDouble(AlertDialog dialog, Double value) {
        //Do something
        return false;//returns if consume event
    }
});
//Show dialog
dialog.show();
```

##HeinsInputDialog
It is an Input Dialog that provides facilitators for inputting values.
It provides listeners for the _String_, _Double_, and _Long_ data types, provides method to customize keyboard type, provides getters of all components, fires _posiviteButton_ when you click OK on a clean design...  
//TODO Images  

### Usage
```
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
```

##HeinsDatePickerDialog  
It is a specialization of the _DialogFragment_ class that implements _DatePickerDialog.OnDateSetListener_.
This _DatePicker_ provides facilitators for the use of dates.  
//TODO Images  

### Usage
```
HeinsDatePickerDialog dialog = new HeinsDatePickerDialog();
dialog.setListener(new OnSelectDateListener() {
  @Override
  public void onSelectDate(Date date) throws Exception {
    lastDate = date;
    setViews();
  }
});
dialog.show(getSupportFragmentManager(), getClass().getSimpleName());
```
