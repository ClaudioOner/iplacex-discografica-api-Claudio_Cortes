package org.iplacex.proyectos.discografia.artistas;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Artistas")
public class Artista {
    @Id
    public String _id; // Aquí se debe usar la convención de nomenclatura, mejor que sea "id".
    public String nombre;
    public List<String> estilos;
    public int anioFundacion;
    public boolean estaActivo;

    // Método para establecer el ID
    public void setId(String id) {
        this._id = id;
    }

    // Método para obtener el ID (opcional)
    public String getId() {
        return _id;
    }
}
