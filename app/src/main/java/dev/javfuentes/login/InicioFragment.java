package dev.javfuentes.login;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import dev.javfuentes.login.databinding.FragmentInicioBinding;

public class InicioFragment extends Fragment {
    private FragmentInicioBinding binding;

    public InicioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentInicioBinding.inflate(inflater, container, false);

        binding.buttonContinuar.setOnClickListener(v -> {
            String nombre = binding.editTextNombre.getText().toString().trim();

            if (nombre.isEmpty()) {
                Toast.makeText(getActivity(), "Por favor ingrese su nombre", Toast.LENGTH_SHORT).show();
                return;
            }

            Bundle args = new Bundle();
            args.putString("nombre", nombre);

            Navigation.findNavController(v).navigate(R.id.action_inicioFragment_to_bienvenidaFragment, args);

        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}