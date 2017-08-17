package datos;

import java.time.LocalDate;
import javafx.collections.ObservableList;
import logica.Gasto;

public interface GastoDAO {
    
    public ObservableList<Gasto> consultarGasto(LocalDate fecha);
    public boolean agregarGasto(Gasto gasto);
        
}
