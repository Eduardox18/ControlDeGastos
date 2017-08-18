package logica;

import datos.Conexion;
import datos.GastoDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Clase que contiene los métodos relacionados con los gastos. La clase implemente los métodos de
 * la interface GastoDAO e implementa otros necesarios para la correcta funcionalidad del Sistema.
 * 
 */
public class Gasto implements GastoDAO{
    
    /**
     * Atributos de la clase.
     */
    private Date fecha;
    private Double gasto;
    private String descripcion;

    /**
     * Constructor vacío de la clase.
     */
    public Gasto() {}
    
    /**
     * Constructor completo de la clase.
     * @param fecha Fecha del gasto.
     * @param gasto Cantidad monetaria del gasto.
     * @param descripcion Descripción del gasto que se realizó.
     */
    public Gasto(Date fecha, Double gasto, String descripcion) {
        this.fecha = fecha;
        this.gasto = gasto;
        this.descripcion = descripcion;
    }
    
    /**
     * Bloque de Getters y Setters. Su documentación no es necesaria. 
     */
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

    /**
     * Método sobreescrito que recupera un ObservableList de objetos tipo Gasto a partir de una fecha proporcionada
     * por el usuario.
     * @param Fecha que se desea consultar.
     * @return ObservableList de Gastos
     */
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
            return null;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    return null;
                }
            }
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException ex) {
                    return null;
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    return null;
                }
            }
        }
        return listaGastos;
    }
    
    /**
     * Método sobreescrito que permite guardar en la base de datos del Sistema un nuevo gasto con
     * la información que ingresó el usuario.
     * @param Objeto tipo gasto con la información del usuario.
     * @return Regresa verdadero (true) si la operación de guardado fue exitosa o falso (false) si 
     * ocurrió algún error o inconveniente. 
     */
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
            return false;
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException ex) {
                    return false;
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    return false;
                }
            }
    }
    }
    
    /**
     * Método auxiliar que suma los elementos de gasto de un ObservableList.
     * @param gastos
     * @return 
     */
    public String sumarTotal (ObservableList<Gasto> gastos) {
        Double resultado = 0.0;
        if(!gastos.isEmpty()){
            for(int i = 0; i < gastos.size(); i++){
                resultado += gastos.get(i).getGasto();
            }
        }
        return resultado.toString();
    }
}
