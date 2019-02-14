package com.example.tarea1;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button clearButton;
    EditText name, phone;
    Spinner scholarship;
    RadioGroup gender;
    RadioButton male, female;
    AutoCompleteTextView book;
    CheckBox sport;
    MenuItem save;

    private String strName, strPhone, strScholarship, strGender, strBook, strMale, strFemale, strSport;

     Alumno a1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //UI References
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        scholarship = (Spinner) findViewById(R.id.scholarship);
        gender = (RadioGroup) findViewById(R.id.radioG_gender);
        book = (AutoCompleteTextView) findViewById(R.id.autocomplete_book);
        male = (RadioButton) findViewById(R.id.radioG_male);
        female = (RadioButton) findViewById(R.id.radioG_female);
        sport = (CheckBox) findViewById(R.id.checkbox_sport);
        clearButton = (Button) findViewById(R.id.activity_main_clear);
        save = (MenuItem) findViewById(R.id.activity_main_save);


        //first EditText "Ingrese su nombre"
        name.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    String s = name.getText().toString().trim();
                    if (s.length() > 0) {
                        strName = s;
                        return true;
                    }
                    name.setError("Name cannot be left blank!");
                }
                return false;
            }
        });


        //Second EditText "Ingrese su teléfono"
        phone.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    String s = phone.getText().toString().trim();
                    if (s.length() > 0) {
                        strPhone = s;
                        return true;
                    }
                    phone.setError("Phone cannot be left blank!");
                }
                return false;
            }
        });


        //Spinner "Escolaridad"
        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(this, R.array.scholarships_array, android.R.layout.simple_spinner_item);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        scholarship.setAdapter(adapterSpinner);
        scholarship.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                strScholarship = ((String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(parent.getContext(), "Please pick a value", Toast.LENGTH_SHORT).show();
            }
        });


        //Radio group "genero"
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioG_female)
                    strGender = female.getText().toString();
                else
                    strGender = (male.getText().toString());
            }
        });


        //AutoComplete textView "Libro favorito"
        String[] books = getResources().getStringArray(R.array.books_array);
        ArrayAdapter<String> adapterAuto = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, books);
        book.setAdapter(adapterAuto);
        book.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    String s = book.getText().toString().trim();
                    if (s.length() > 0) {
                        strBook = s;
                        return true;
                    }
                    book.setError("book cannot be left blank!");
                }
                return false;
            }
        });


        //CheckBox "hace deporte
        sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strSport = sport.isChecked() ?  "Si":  "No";
            }
        });



        //Button "Limpiar"
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogFragment fragment = new MyDialog();
                fragment.show(getSupportFragmentManager(), "clear");

            }
        });
    }

    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.activity_main_save) {
            a1 = new Alumno(strName, strScholarship, strGender, strBook, strPhone, strSport);
            Toast.makeText(this, a1.toString(), Toast.LENGTH_LONG).show();
            // clear();
        }
        return true;

    }

    public  void clear(){
        Toast.makeText(this, "We are clearing", Toast.LENGTH_SHORT);
        //name.setText("");
        //phone.setText("");
        /*gender = (RadioGroup) findViewById(R.id.radioG_gender);
        book = (AutoCompleteTextView) findViewById(R.id.autocomplete_book);
        male = (RadioButton) findViewById(R.id.radioG_male);
        female = (RadioButton) findViewById(R.id.radioG_female);
        sport = (CheckBox) findViewById(R.id.checkbox_sport);
        clearButton = (Button) findViewById(R.id.activity_main_clear);
        save = (MenuItem) findViewById(R.id.activity_main_save);*/
    }

}
