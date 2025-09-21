import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Classe de conexão com o banco
 * Ajuste URL/USUARIO/SENHA conforme seu ambiente.
 */
public class conectaDAO {

    public Connection connectDB() {
        Connection conn = null;
        try {
            // Carregar driver (opcional em versões mais novas, mas pode ajudar)
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/leiloes?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            String user = "root";
            String password = ""; // altere se necessário
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver JDBC não encontrado: " + ex.getMessage());
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO: " + erro.getMessage());
        }
        return conn;
    }
}
