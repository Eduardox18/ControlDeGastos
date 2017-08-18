package datos;

import java.sql.Date;
import javafx.collections.ObservableList;
import logica.Gasto;

/**
 * Interface de la clase Gasto. Se declaran los métodos utilizados en la implementación del control
 * de gastos.
 * @author lalo
 */

public interface GastoDAO {
    
    /**
     * Método declarado que recupera un ObservableList de objetos Gasto a partir de una fecha determinada.
     * @param fecha Fecha elegida por el usuario para consultar los gastos de ese día.
     * @return ObservableList de objetos tipo Gasto, que contienen las coincidencias de la búsqueda.
     */
    public ObservableList<Gasto> consultarGasto(Date fecha);
    
    /**
     * Método declarado que permite agregar un nuevo gasto del día o días anteriores a la base de 
     * datos del control de gastos.
     * @param gasto Objeto tipo gasto que contiene los datos que se registrarán.
     * @return Verdadero (true) si la operación de guardado fue exitosa o falso (false) si ocurrió
     * un error.
     */
    public boolean agregarGasto(Gasto gasto);
        
}
