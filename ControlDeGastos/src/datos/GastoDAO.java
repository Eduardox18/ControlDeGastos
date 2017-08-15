package datos;

import java.time.LocalDate;
import javafx.collections.ObservableList;
import logica.Gasto;

public class GastoDAO {
    
    public ObservableList<Gasto> consultarGasto(LocalDate fecha);
    public boolean agregarGasto(double Gasto, LocalDate fecha, String descripcion);
    
}
