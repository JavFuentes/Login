package dev.javfuentes.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import dev.javfuentes.login.databinding.FragmentBienvenidaBinding;

public class BienvenidaFragment extends Fragment {
    private static final String ARG_NOMBRE = "nombre";
    private String nombre;
    private FragmentBienvenidaBinding binding;

    public BienvenidaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentBienvenidaBinding.inflate(inflater, container, false);

        if (getArguments() != null) {
            nombre = getArguments().getString(ARG_NOMBRE);
        }

        if (nombre != null && !nombre.isEmpty()) {
            binding.textViewBienvenida.setText("Bienvenido, " + nombre + "!");
        } else {
            binding.textViewBienvenida.setText("Bienvenido!");
        }

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Limpiar la referencia del binding para evitar memory leaks
        binding = null;
    }
}