package dev.javfuentes.login;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Objects;

import dev.javfuentes.login.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnIngresar.setOnClickListener(v -> {
            if (Objects.requireNonNull(binding.etNombreUsuario.getText()).toString().isEmpty() || Objects.requireNonNull(binding.etPassword.getText()).toString().isEmpty()) {
                Toast.makeText(LoginActivity.this, "No deben haber campos vacios", Toast.LENGTH_LONG).show();
            } else if(binding.etNombreUsuario.getText().toString().equals("usuario") && binding.etPassword.getText()
                    .toString().equals("123")){
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(LoginActivity.this, "Nombre de usuario o contraseña incorrecta.",
                        Toast.LENGTH_LONG).show();
            }
        });

        binding.btnTvPasswordOlvidada.setOnClickListener(v -> {
            // Animación de escala
            animateScaleButton(v);

            // Ocultar el layout del login
            binding.loginLayout.setVisibility(View.GONE);


            // Crear el fragment y el bundle
            PasswordOlvidadaFragment fragment = new PasswordOlvidadaFragment();
            Bundle bundle = new Bundle();

            // Obtener el texto del campo usuario y pasarlo al bundle
            String nombreUsuario = binding.etNombreUsuario.getText().toString();
            bundle.putString("nombre_usuario", nombreUsuario);

            // Asignar el bundle al fragment
            fragment.setArguments(bundle);


            // Cargar el fragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
        });

        binding.btnTvCrearCuenta.setOnClickListener(v -> {
            // Animación de escala
            animateScaleButton(v);
            Toast.makeText(LoginActivity.this, "Pronto", Toast.LENGTH_SHORT).show();
        });

        // Manejar el botón de retroceso del sistema
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Verificar si hay fragments en el back stack
                if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    // Mostrar el layout del login antes de hacer pop del fragment
                    showLoginLayout();
                    getSupportFragmentManager().popBackStack();
                } else {
                    // Si no hay fragments, comportamiento normal de salir de la app
                    finish();
                }
            }
        });
    }

    // Función privada para la animación de escala
    private void animateScaleButton(View view) {
        view.animate()
                .scaleX(0.95f)
                .scaleY(0.95f)
                .setDuration(100)
                .withEndAction(() -> {
                    view.animate()
                            .scaleX(1.0f)
                            .scaleY(1.0f)
                            .setDuration(100)
                            .start();
                })
                .start();
    }

    public void showLoginLayout() {
        binding.loginLayout.setVisibility(View.VISIBLE);
    }


}