package dev.javfuentes.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ConfiguracionFragment extends Fragment {

    private ConfiguracionAdapter adapter;
    private final List<Configuracion> listaConfiguracions = new ArrayList<>();

    public ConfiguracionFragment() { /* constructor vacío requerido */ }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla el layout del fragment
        return inflater.inflate(R.layout.fragment_configuracion, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializa RecyclerView usando la VIEW inflada
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewEstudiantes);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setHasFixedSize(true);

        adapter = new ConfiguracionAdapter(listaConfiguracions);
        recyclerView.setAdapter(adapter);

        // Carga los datos
        cargarDatos();
    }

    private void cargarDatos() {
        listaConfiguracions.clear();

        // Configuraciones típicas de un teléfono
        listaConfiguracions.add(new Configuracion("Wi-Fi", "Redes", "Conexión inalámbrica", "Activo"));
        listaConfiguracions.add(new Configuracion("Bluetooth", "Redes", "Vinculación de dispositivos", "Inactivo"));
        listaConfiguracions.add(new Configuracion("Datos móviles", "Redes", "Conexión a internet", "Activo"));
        listaConfiguracions.add(new Configuracion("Sonido", "Dispositivo", "Volumen, tonos y vibración", "Personalizado"));
        listaConfiguracions.add(new Configuracion("Pantalla", "Dispositivo", "Brillo, fondo de pantalla, modo oscuro", "Modo claro"));
        listaConfiguracions.add(new Configuracion("Batería", "Sistema", "Uso de batería y ahorro de energía", "85%"));
        listaConfiguracions.add(new Configuracion("Almacenamiento", "Sistema", "Uso de memoria interna", "64 GB de 128 GB"));
         listaConfiguracions.add(new Configuracion("Sistema", "Avanzado", "Actualización, accesibilidad, opciones de desarrollador", "Android 13"));

        adapter.notifyDataSetChanged();
    }

}
