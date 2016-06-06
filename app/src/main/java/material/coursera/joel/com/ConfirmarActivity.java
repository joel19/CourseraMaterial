package material.coursera.joel.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarActivity extends AppCompatActivity {
    Button editar;
    TextView tvNombre, tvTelefono, tvFecha, tvEmail, tvDescripcion;
    String nombre, telefono, email, descripcion, fecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);

        editar = (Button) findViewById(R.id.btnConfirmar);
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        recibirContacto();


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

    public void recibirContacto(){
        Bundle params = getIntent().getExtras();
        if (params != null) {
            nombre = params.getString("nombre");
            telefono = params.getString("telefono");
            email = params.getString("email");
            descripcion = params.getString("descripcion");
            fecha = params.getString("fecha");

            tvNombre.setText(nombre);
            tvTelefono.setText(telefono);
            tvEmail.setText(email);
            tvDescripcion.setText(descripcion);
            tvFecha.setText(fecha);
        }

    }


    public void confirmar(View view){
        nombre = tvNombre.getText().toString();
        telefono = tvTelefono.getText().toString();
        email = tvEmail.getText().toString();
        descripcion = tvDescripcion.getText().toString();
        fecha = tvFecha.getText().toString();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("telefono", telefono);
        intent.putExtra("email", email);
        intent.putExtra("descripcion", descripcion);
        intent.putExtra("fecha", fecha);
        startActivity(intent);
        finish();
    }
}
