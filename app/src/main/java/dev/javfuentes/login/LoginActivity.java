package dev.javfuentes.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText et_nombre_usuario, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_nombre_usuario = findViewById(R.id.et_nombre_usuario);
        et_password = findViewById(R.id.et_password);

        Button btn_ingresar = findViewById(R.id.btn_ingresar);
        TextView btn_tv_password_olvidada = findViewById(R.id.btn_tv_password_olvidada);
        TextView btn_tv_crear_cuenta = findViewById(R.id.btn_tv_crear_cuenta);

        btn_ingresar.setOnClickListener(v -> {
                if (et_nombre_usuario.getText().toString().isEmpty() || et_password.getText().toString().isEmpty()) {
                    Toast.makeText(LoginActivity.this, "No deben haber campos vacios", Toast.LENGTH_LONG).show();
                } else if(et_nombre_usuario.getText().toString().equals("usuario") && et_password.getText()
                        .toString().equals("123")){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Nombre de usuario o contraseña incorrecta.",
                            Toast.LENGTH_LONG).show();
                }
        });

        btn_tv_password_olvidada.setOnClickListener(v -> {
            // Animación de escala
            v.animate()
                    .scaleX(0.95f)
                    .scaleY(0.95f)
                    .setDuration(100)
                    .withEndAction(() -> {
                        v.animate()
                                .scaleX(1.0f)
                                .scaleY(1.0f)
                                .setDuration(100)
                                .start();
                    })
                    .start();

            Toast.makeText(LoginActivity.this, "Pronto", Toast.LENGTH_SHORT).show();
        });


        btn_tv_crear_cuenta.setOnClickListener(v -> {
            // Animación de escala
            v.animate()
                    .scaleX(0.95f)
                    .scaleY(0.95f)
                    .setDuration(100)
                    .withEndAction(() -> {
                        v.animate()
                                .scaleX(1.0f)
                                .scaleY(1.0f)
                                .setDuration(100)
                                .start();
                    })
                    .start();
            Toast.makeText(LoginActivity.this, "Pronto", Toast.LENGTH_SHORT).show();
        });
    }
}