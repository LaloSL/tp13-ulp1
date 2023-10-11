
package universidadejemplo;

import java.sql.*;
import javax.swing.JOptionPane;

public class UniversidadEjemplo {

    public static void main(String[] args) {
      
        try {

            //Cargo Driver de conexión:  
            Class.forName("org.mariadb.jdbc.Driver");

            //Establecer la conexión:
            String URL = "jdbc:mariadb://localhost:3306/tp13-ulp";
            String usuario = "root";
            String password = "";
            Connection conexion = DriverManager.getConnection(URL, usuario, password);
            
            
            //Carga de Tabla empleado 
            //String sql = "INSERT INTO alumno (dni,apellido,nombre,fechaNacimiento,estado)"
               //     + "VALUES (12345671,'Veron','Juan','2001-01-22',1),(12345672,'Milito','Gabriel','2002-02-12',1),(12345673,'Perez','Juan','2001-03-12',1)";

//            PreparedStatement ps = con.prepareStatement(sql);
//            int filas = ps.executeUpdate();
//
//            if (filas > 0) {
//
//                JOptionPane.showMessageDialog(null, "Alumno Agregado");
//
//            }
            
        
          
           
            //Ejercicio 5 (NO SE CUAL ES EL ERROR, CREO Q ES ALGO DEL CATCH FALTA UN TRY
//            String sql= “INSERT INTO inscripcion(idInscripto, nota, idAlumno, idMateria)”;
//            +” VALUES (1,8,1,1)”;
//            String sql1= “INSERT INTO inscripcion(idInscripto, nota, idAlumno, idMateria)”;
//            +” VALUES (2,7,1,2)”;
//            String sql2= “INSERT INTO inscripcion(idInscripto, nota, idAlumno, idMateria)”;
//            +” VALUES (3,10,2,2)”;
//            String sql3= “INSERT INTO inscripcion(idInscripto, nota, idAlumno, idMateria)”;
//            +” VALUES (4,9,2,3)”;
//            String sql4= “INSERT INTO inscripcion(idInscripto, nota, idAlumno, idMateria)”;
//            +” VALUES (5,2,3,1)”;
//            String sql5= “INSERT INTO inscripcion(idInscripto, nota, idAlumno, idMateria)”;
//            +” VALUES (6,6,3,4)”;
//
//            PreparedStatement ps = conexion.prepareStatement(sql);
//            ps.executeUpdate();
//
//            PreparedStatement ps1 = conexion.prepareStatement(sql1);
//            ps1.executeUpdate();
//            PreparedStatement ps2 = conexion.prepareStatement(sql2);
//            ps2.executeUpdate();
//            PreparedStatement ps3 = conexion.prepareStatement(sql3);
//            ps3.executeUpdate();
//            PreparedStatement ps4 = conexion.prepareStatement(sql4);
//            ps4.executeUpdate();
//            PreparedStatement ps5 = conexion.prepareStatement(sql5);
//            ps5.executeUpdate();

            
            

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
