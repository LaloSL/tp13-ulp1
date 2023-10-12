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

            //Ejercicio 3: cargar 3 alumnos
//            String sql = "INSERT INTO alumno (dni,apellido,nombre,fechaNacimiento,estado)"
//                    + "VALUES (12345671,'Veron','Juan','2001-01-22',1),(12345672,'Milito','Gabriel','2002-02-12',1),(12345673,'Perez','Juan','2001-03-12',1)";
//
//            PreparedStatement ps = conexion.prepareStatement(sql);
//            int filas = ps.executeUpdate();
//
//            if (filas > 0) {
//
//                JOptionPane.showMessageDialog(null, "Alumno Agregado");
//
//            }

//            //Ejercicio 4: Insertar Materias
//            String sql6 = "INSERT INTO materia (nombre, año, estado)"
//                    + "VALUES ('Ingles',2023,true)";
//            String sql7 = "INSERT INTO materia (nombre, año, estado)"
//                    + "VALUES ('Matematica',2023,true)";
//            String sql8 = "INSERT INTO materia (nombre, año, estado)"
//                    + "VALUES ('Lengua',2023,true)";
//            String sql9 = "INSERT INTO materia (nombre, año, estado)"
//                    + "VALUES ('Fisica',2023,true)";
//            String sql10 = "INSERT INTO materia (nombre, año, estado)"
//                    + "VALUES ('Quimica',2023,true)";
//            String sql11 = "INSERT INTO materia (nombre, año, estado)"
//                    + "VALUES ('Biología',2023,true)";
//            String sql12 = "INSERT INTO materia (nombre, año, estado)"
//                    + "VALUES ('Literatura',2023,true)";
//
//            PreparedStatement ps6 = conexion.prepareStatement(sql6);
//            ps6.executeUpdate();
//            PreparedStatement ps7 = conexion.prepareStatement(sql7);
//            ps7.executeUpdate();
//            PreparedStatement ps8 = conexion.prepareStatement(sql8);
//            ps8.executeUpdate();
//            PreparedStatement ps9 = conexion.prepareStatement(sql9);
//            ps9.executeUpdate();
//            PreparedStatement ps10 = conexion.prepareStatement(sql10);
//            ps10.executeUpdate();
//            PreparedStatement ps11 = conexion.prepareStatement(sql11);
//            ps11.executeUpdate();
//            PreparedStatement ps12 = conexion.prepareStatement(sql12);
//            ps12.executeUpdate();

//            
//            
//
//            
//
//////          Ejercicio 5: Inscribir a los 3 alumnos en 2 materias c/u
//           
//            String sql0= "INSERT INTO inscripcion(nota, idAlumno, idMateria)"
//            + "VALUES (8,34,24)";
//            String sql1= "INSERT INTO inscripcion(nota, idAlumno, idMateria)"
//            +" VALUES (7,34,25)";
//            String sql2= "INSERT INTO inscripcion(nota, idAlumno, idMateria)"
//            +" VALUES (10,35,26)";
//            String sql3= "INSERT INTO inscripcion(nota, idAlumno, idMateria)"
//            +" VALUES (9,35,27)";
//            String sql4= "INSERT INTO inscripcion(nota, idAlumno, idMateria)"
//            +"VALUES (2,36,28)";
//            String sql5= "INSERT INTO inscripcion(nota, idAlumno, idMateria)"
//            +" VALUES (6,36,29)";
//
//            PreparedStatement ps0 = conexion.prepareStatement(sql0);
//            ps0.executeUpdate();
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
            
            // Ejercicio 6: 
//            String sql = "SELECT a.idAlumno, a.apellido, a.nombre, a.dni " +
//             "FROM alumno a " +
//             "JOIN inscripcion i ON (a.idAlumno = i.idAlumno) " +
//             "WHERE nota >= 8";
//
////           String sql= "SELECT * FROM alumno a JOIN inscripcion i ON (a.idAlumno= i.idAlumno) WHERE nota>=8";
//              //para enviarla
//                PreparedStatement ps=conexion.prepareStatement(sql);
//               //ahora ejecuto esa sentencia
//               //me devuelve un valor entero
//                ResultSet resultado=ps.executeQuery();
//               //recorro el resulset
//              //pregunto si ahy fila y si hay que me muestre los datos
//              while(resultado.next()){
//              //entro al while si hay una fila y el puntero se para en esa fila
//              //obtengo el entero de idempleado
//                System.out.println("ID "+resultado.getInt("idAlumno"));
//                System.out.println("Apellido "+resultado.getString("apellido"));
//                System.out.println("Nombre "+resultado.getString("nombre"));
//                System.out.println("DNI "+resultado.getInt("dni"));
//                System.out.println("-------------------");
//
//                
//            }
              
//              ejercicio 7: Desinscribir un alumno de una de la materias.
                  //borrado logico
//                String sql23= "UPDATE alumno SET estado= 0 WHERE idAlumno=34";
                //borrado fisico
                String sql23="DELETE FROM alumno WHERE idAlumno=34";  
                PreparedStatement ps23 = conexion.prepareStatement(sql23);
                ps23.executeUpdate();
                
                  
              

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
            JOptionPane.showMessageDialog(null, "Error de conexión");
        }

    }
}

