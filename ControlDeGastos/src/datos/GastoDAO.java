package datos;

import java.sql.Date;
import javafx.collections.ObservableList;
import logica.Gasto;

public interface GastoDAO {
    
    public ObservableList<Gasto> consultarGasto(Date fecha);
    public boolean agregarGasto(Gasto gasto);
        
}
