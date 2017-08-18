package logica;

import datos.Conexion;
import datos.GastoDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author lalo
 */
public class Gasto implements GastoDAO{
    private Date fecha;
    private Double gasto;
    private String descripcion;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getGasto() {
        return gasto;
    }

    public void setGasto(Double gasto) {
        this.gasto = gasto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public ObservableList<Gasto> consultarGasto(Date fecha) {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        Gasto gastoResultado;
        ObservableList<Gasto> listaGastos = FXCollections.observableArrayList();
        
        try {
            conexion = new Conexion().connection();
            String consulta = "SELECT gasto, descripcion FROM Gasto WHERE fecha = ?";
            sentencia = conexion.prepareStatement(consulta);
            sentencia.setDate(1, fecha);
            rs = sentencia.executeQuery();
            
            while(rs.next()) {
                gastoResultado = new Gasto();
                gastoResultado.setGasto(rs.getDouble("gasto"));
                gastoResultado.setDescripcion(rs.getString("descripcion"));
                listaGastos.add(gastoResultado);
            }
        } catch (SQLException ex) {
            //ERROR
        } finally {
            //Error
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    //Error
                }
            }
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException ex) {
                    //Error
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    //Error
                }
            }
        }
        return listaGastos;
    }
    
    @Override
    public boolean agregarGasto(Gasto gasto) {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        
        try {
        conexion = new Conexion().connection();
        String nuevoGasto = "INSERT INTO Gasto (fecha, gasto, descripcion) VALUES (?, ?, ?)";
        sentencia = conexion.prepareStatement(nuevoGasto);
        sentencia.setDate(1, gasto.getFecha());
        sentencia.setDouble(2, gasto.getGasto());
        sentencia.setString(3, gasto.getDescripcion());
        
        sentencia.executeUpdate();
        return true;
        } catch (SQLException ex) {
            System.out.println("Error");
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException ex) {
                    //DIALOGO CERRAR CONEXION
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    //DIALOGO CERRAR CONEXION
                }
            }
    }
        return false;
    }
    
    public Double sumatoria (LocalDate fecha) {
        ObservableList<Gasto> gastos = consultarGasto(fecha);
        Double resultado = 0.0;
        
        for(int i = 0; i < gastos.size(); i++){
            resultado += gastos.get(i).getGasto();
        }
        
        return resultado;
    }
}
