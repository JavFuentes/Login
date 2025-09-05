package dev.javfuentes.login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/**
 * Adaptador personalizado que conecta los datos de estudiantes con el RecyclerView.
 * Extiende RecyclerView.Adapter y especifica que usará EstudianteViewHolder como ViewHolder.
 */
public class ConfiguracionAdapter extends RecyclerView.Adapter<ConfiguracionAdapter.EstudianteViewHolder> {
    // Lista de datos que se mostrará en el RecyclerView
    private final List<Configuracion> listaConfiguracions;

    /**
     * Constructor: recibe la lista de estudiantes que se van a mostrar
     * @param listaConfiguracions Lista con los datos a mostrar
     */
    public ConfiguracionAdapter(List<Configuracion> listaConfiguracions) {
        this.listaConfiguracions = listaConfiguracions;
    }

    /**
     * MÉTODO 1 de 3 OBLIGATORIOS: onCreateViewHolder
     * Se ejecuta cuando RecyclerView necesita crear una nueva vista (ViewHolder).
     * Solo se llama cuando necesita crear nuevos ViewHolders, no para cada elemento.
     *
     * @param parent El ViewGroup padre (normalmente el RecyclerView)
     * @param viewType Tipo de vista (útil cuando tienes diferentes layouts)
     * @return Un nuevo ViewHolder con la vista inflada
     */
    @NonNull
    @Override
    public EstudianteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar (convertir de XML a View) el layout del item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_estudiante, parent, false);

        // Crear y retornar un nuevo ViewHolder con esta vista
        return new EstudianteViewHolder(view);
    }

    /**
     * MÉTODO 2 de 3 OBLIGATORIOS: onBindViewHolder
     * Se ejecuta cada vez que necesita mostrar datos en una vista existente.
     * Es donde "llenamos" la vista con los datos específicos de cada estudiante.
     *
     * @param holder El ViewHolder que contiene las vistas a llenar
     * @param position La posición del elemento en la lista (índice)
     */
    @Override
    public void onBindViewHolder(@NonNull EstudianteViewHolder holder, int position) {
        // Obtener el estudiante específico de esta posición
        Configuracion configuracion = listaConfiguracions.get(position);

        // Llenar las vistas con los datos del estudiante
        holder.tvNombreCompleto.setText(configuracion.getNombreCompleto());

        // Lógica condicional: Si no tiene app asignada, mostrar "Pendiente"
        if (configuracion.getApp().equals("pendiente")) {
            holder.tvApp.setText("App: Pendiente");
        } else {
            holder.tvApp.setText("App: " + configuracion.getApp());
        }

        // Lógica condicional: Si no tiene fecha, mostrar "Sin fecha"
        if (configuracion.getFechaInscripcion().equals("pendiente")) {
            holder.tvFechaInscripcion.setText("Fecha: Sin inscribir");
        } else {
            holder.tvFechaInscripcion.setText("Inscrito: " + configuracion.getFechaInscripcion());
        }
    }

    /**
     * MÉTODO 3 de 3 OBLIGATORIOS: getItemCount
     * Dice al RecyclerView cuántos elementos hay en total para mostrar.
     * RecyclerView usa esto para saber cuándo dejar de hacer scroll.
     *
     * @return El número total de elementos en la lista
     */
    @Override
    public int getItemCount() {
        return listaConfiguracions.size();
    }

    /**
     * ViewHolder interno: una clase que "mantiene" las referencias a las vistas
     * del layout de cada item. Esto evita hacer findViewById repetidamente,
     * mejorando significativamente el rendimiento.
     *
     */
    public static class EstudianteViewHolder extends RecyclerView.ViewHolder {
        // Referencias a las vistas del layout item_estudiante.xml
        TextView tvNombreCompleto, tvApp, tvFechaInscripcion;

        /**
         * Constructor del ViewHolder: aquí es donde se hace findViewById
         * una sola vez por cada ViewHolder creado.
         *
         * @param itemView La vista completa del item (el LinearLayout completo)
         */
        public EstudianteViewHolder(@NonNull View itemView) {
            super(itemView);
            // Buscar y guardar las referencias a cada TextView
            // Esto solo se hace una vez por ViewHolder, no por cada bind
            tvNombreCompleto = itemView.findViewById(R.id.tvNombreCompleto);
            tvApp = itemView.findViewById(R.id.tvApp);
            tvFechaInscripcion = itemView.findViewById(R.id.tvFechaInscripcion);
        }
    }
}

/*
FLUJO RESUMIDO:
1. RecyclerView pregunta: "¿Cuántos elementos hay?" → getItemCount()
2. RecyclerView dice: "Necesito una vista nueva" → onCreateViewHolder()
3. RecyclerView dice: "Llena esta vista con datos" → onBindViewHolder()
4. Usuario hace scroll → RecyclerView reutiliza vistas existentes llamando onBindViewHolder()
*/