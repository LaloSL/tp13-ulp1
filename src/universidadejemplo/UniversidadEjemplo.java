
package universidadejemplo;

import java.sql.*;
import javax.swing.JOptionPane;

public class UniversidadEjemplo {

    public static void main(String[] args) {
      
        try {

            //Cargo Driver de conexión:  
            Class.forName("org.mariadb.jdbc.Driver");

            //Establecer la conexión:
            String URL = "jdbc:mariadb://localhost:3306/tp13_universidad";
            String usuario = "root";
            String password = "";
            Connection con = DriverManager.getConnection(URL, usuario, password);

            //Carga de Tabla empleado 
            String sql = "INSERT INTO alumno (dni,apellido,nombre,fechaNacimiento,estado)"
                    + "VALUES (12345671,'Veron','Juan','2001-01-22',1),(12345672,'Milito','Gabriel','2002-02-12',1),(12345673,'Perez','Juan','2001-03-12',1)";

            PreparedStatement ps = con.prepareStatement(sql);
            int filas = ps.executeUpdate();

            if (filas > 0) {

                JOptionPane.showMessageDialog(null, "Alumno Agregado");

            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar el Driver");

        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null,"Error de conexión");
            //ex.printStackTrace();
            //System.out.println("Codigo de error "+ex.getErrorCode());
            int error = ex.getErrorCode();

            if (error == 0) {
                JOptionPane.showMessageDialog(null, "Error URL");

            } else if (error == 1045) {
                JOptionPane.showMessageDialog(null, "Error Acceso por password incorrecto ");
            } else if (error == 1049) {
                JOptionPane.showMessageDialog(null, "Error Nombre Base de Datos ");
            } else if (error == 1146) {
                JOptionPane.showMessageDialog(null, "Error Tabla inexistente");
            } else if (error == 1062) {
                JOptionPane.showMessageDialog(null, "Error entrada DNI duplicada");
            } else {
                JOptionPane.showMessageDialog(null, "Error SQL");
            }
            //JOptionPane.showMessageDialog(null, "Error de conexión");
        }

    }
//System.out.println("exito");
}

        
        
        
        
        
//        try {
//            //instancio un objeto de tipo driver
//            Class.forName("org.mariadb.jdbc.Driver");
//            try {
//               
//              Connection conexion= DriverManager.getConnection("jdbc:mariadb://localhost/tp13-ulp", "root","");  
//              
//              
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null,"Error al cargar Driver"+ex.getMessage());
//            }
//        } catch (ClassNotFoundException ex) {
//            JOptionPane.showMessageDialog(null,"Error de conexion"+ex.getMessage());
//        }
//    }
//    }
//    
//
