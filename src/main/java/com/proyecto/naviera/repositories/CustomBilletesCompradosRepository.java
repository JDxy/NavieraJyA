package com.proyecto.naviera.repositories;

import java.util.ArrayList;

public interface CustomBilletesCompradosRepository {
    public ArrayList<String> findViajesByFecha(String fecha);
    public void deleteByFecha(String fecha);
}
