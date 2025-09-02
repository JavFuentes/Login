package dev.javfuentes.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import dev.javfuentes.login.databinding.FragmentPasswordOlvidadaBinding;

public class PasswordOlvidadaFragment extends Fragment {
    private FragmentPasswordOlvidadaBinding binding;

    public PasswordOlvidadaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inicializar el binding
        binding = FragmentPasswordOlvidadaBinding.inflate(inflater, container, false);

        // Recuperar el argumento del bundle
        if (getArguments() != null) {
            String nombreUsuario = getArguments().getString("nombre_usuario", "");
            // Establecer el texto en tu EditText del correo
            binding.etEmail.setText(nombreUsuario);
        }

        // Configurar el botón "Atrás"
        binding.btnTvVolver.setOnClickListener(v -> {
            // Mostrar nuevamente el layout del login
            if (getActivity() instanceof LoginActivity) {
                ((LoginActivity) getActivity()).showLoginLayout();
            }
            // Remover el fragment
            requireActivity().getSupportFragmentManager().popBackStack();
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Limpiar el binding para evitar memory leaks
        binding = null;
    }
}