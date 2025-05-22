package Controlador.seguridad;

public class permisos {
    private int idUsuario; 
    private boolean puedeMantenimiento;
    private boolean puedeProcesos;
    private boolean puedeEliminar;
    private boolean puedeRegistrar;
    private boolean puedeModificar;
    
    // Array para manejar permisos de aplicaciones dinámicamente
    private boolean[] permisosAplicaciones = new boolean[10]; // APL103 - APL112

    // Getters y setters para idUsuario
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    // Getters y setters para los permisos generales
    public boolean isPuedeMantenimiento() {
        return puedeMantenimiento;
    }

    public void setPuedeMantenimiento(boolean puedeMantenimiento) {
        this.puedeMantenimiento = puedeMantenimiento;
    }

    public boolean isPuedeProcesos() {
        return puedeProcesos;
    }

    public void setPuedeProcesos(boolean puedeProcesos) {
        this.puedeProcesos = puedeProcesos;
    }

    public boolean isPuedeEliminar() {
        return puedeEliminar;
    }

    public void setPuedeEliminar(boolean puedeEliminar) {
        this.puedeEliminar = puedeEliminar;
    }

    public boolean isPuedeRegistrar() {
        return puedeRegistrar;
    }

    public void setPuedeRegistrar(boolean puedeRegistrar) {
        this.puedeRegistrar = puedeRegistrar;
    }

    public boolean isPuedeModificar() {
        return puedeModificar;
    }

    public void setPuedeModificar(boolean puedeModificar) {
        this.puedeModificar = puedeModificar;
    }

    // Métodos dinámicos para permisos de aplicaciones APL103 - APL112
    public boolean getPermisoAplicacion(int numero) {
        if (numero >= 103 && numero <= 112) {
            return permisosAplicaciones[numero - 103];
        }
        return false;
    }

    public void setPermisoAplicacion(int numero, boolean valor) {
        if (numero >= 103 && numero <= 112) {
            permisosAplicaciones[numero - 103] = valor;
        }
    }
}
