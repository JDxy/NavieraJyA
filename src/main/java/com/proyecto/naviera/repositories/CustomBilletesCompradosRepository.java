package com.proyecto.naviera.repositories;

import java.util.ArrayList;

public interface CustomBilletesCompradosRepository {
    public ArrayList<String> findViajesByFecha(String fecha);
    // Puedes agregar otros métodos de consulta personalizados aquí
}
