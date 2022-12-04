
package com.mycompany.peluqueriacanina.servicio;

import com.mycompany.peluqueriacanina.datos.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observaciones, String nomDueño, 
                        String celDueño, String alergico, String atencion) {
        
        Duenio duenio = new Duenio();
        duenio.setNombre(nomDueño);
        duenio.setCelDuenio(celDueño);
        
        Mascota masco = new Mascota();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservacion(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atencion);
        masco.setUnDuenio(duenio);
        
        controlPersis.guardar(duenio, masco);
        
    }
    
    public List<Mascota> traerMascotas() {
        return controlPersis.traerMascotas();
    }

    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascota(num_cliente); 
    }

    public Mascota traerMascota(int num_cliente) { 
        return controlPersis.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color, 
            String observaciones, String alergico, String atencion, String nomDueño, String celDueño) {
        
        //seteo valores de la mascota
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservacion(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atencion);
        
        //modifico mascota
        controlPersis.modificarMascota(masco);
        
        //seteo valores del duenio
        Duenio duenio = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        duenio.setCelDuenio(celDueño);
        duenio.setNombre(nomDueño);
        
        //llamar al modificar dueño
        this.modificarDuenio(duenio);
        
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenio) {
        controlPersis.modificarDuenio(duenio);
    }
    
}
