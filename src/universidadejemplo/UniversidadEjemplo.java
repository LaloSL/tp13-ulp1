
package universidadejemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UniversidadEjemplo {

    public static void main(String[] args) {
       try {
            //instancio un objeto de tipo driver
            Class.forName("org.mariadb.jdbc.Driver");
            try {
               
              Connection conexion= DriverManager.getConnection("jdbc:mariadb://localhost/tp13-ulp", "root","");  
              
              
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Error al cargar Driver"+ex.getMessage());
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion"+ex.getMessage());
        }
    }
    }
    

