package material.coursera.joel.com;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button siguiente;
    EditText nombre,fecha, telefono, email, descripcion;
    String nombreD, fechaD, telefonoD, emailD, descripcionD;
    int año, mes , dia;
    static final int DIALOG_ID = 0;
    DatePickerDialog.OnDateSetListener dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendario = Calendar.getInstance();
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mes = calendario.get(Calendar.MONTH);
        año = calendario.get(Calendar.YEAR);

        siguiente = (Button) findViewById(R.id.btnSiguiente);
        nombre = (EditText) findViewById(R.id.editNombre);
        telefono = (EditText) findViewById(R.id.editTelefono);
        email = (EditText) findViewById(R.id.editEmail);
        descripcion = (EditText) findViewById(R.id.editDescripcion);
        fecha = (EditText) findViewById(R.id.editFecha);
        editar();
        dialog = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                dia = dayOfMonth;
                mes= monthOfYear+1;
                año = year;
                mostrarFecha();
            }
        };


    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case 0:
                return  new DatePickerDialog(this, dialog, año, mes, dia);
        }
        return null;
    }

    public void mostrarPicker(View control){
        showDialog(DIALOG_ID);
    }
    public  void mostrarFecha(){
        fecha.setText(dia + "/" + mes + "/" + año );
    }

    public void editar(){
        Bundle params = getIntent().getExtras();
        if (params != null) {

            nombreD = params.getString("nombre");
            telefonoD = params.getString("telefono");
            emailD = params.getString("email");
            descripcionD = params.getString("descripcion");
            fechaD = params.getString("fecha");

            nombre.setText(nombreD);
            telefono.setText(telefonoD);
            email.setText(emailD);
            descripcion.setText(descripcionD);
            fecha.setText(fechaD);
        }
    }

    public void enviar(View view){
        nombreD = nombre.getText().toString();
        telefonoD = telefono.getText().toString();
        emailD = email.getText().toString();
        descripcionD = descripcion.getText().toString();
        fechaD = fecha.getText().toString();

        Intent intent = new Intent(getApplicationContext(), ConfirmarActivity.class);
        intent.putExtra("nombre", nombreD);
        intent.putExtra("telefono", telefonoD);
        intent.putExtra("email", emailD);
        intent.putExtra("descripcion", descripcionD);
        intent.putExtra("fecha", fechaD);
        startActivity(intent);
        finish();
    }


}
