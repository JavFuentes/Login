package dev.javfuentes.login;

public class Configuracion {
    private String nombre;
    private String apellido;
    private String app;
    private String fechaInscripcion;

    public Configuracion(String nombre, String apellido, String app, String fechaInscripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.app = app;
        this.fechaInscripcion = fechaInscripcion;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    // Método para obtener el nombre completo
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
}