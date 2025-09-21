import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutosDAO {

    // método já existente para cadastrar produtos
    public void cadastrarProduto(ProdutosDTO produto) {
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";
        try (Connection conn = new conectaDAO().connectDB();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, produto.getNome());
            pstm.setInt(2, produto.getValor());
            pstm.setString(3, produto.getStatus());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    // NOVO: venderProduto()
    public void venderProduto(int idProduto) {
        String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";
        try (Connection conn = new conectaDAO().connectDB();
             PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setInt(1, idProduto);
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto vendido com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao vender produto: " + e.getMessage());
        }
    }

    // NOVO: listarProdutosVendidos()
    public ArrayList<ProdutosDTO> listarProdutosVendidos() {
        ArrayList<ProdutosDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos WHERE status = 'Vendido'";

        try (Connection conn = new conectaDAO().connectDB();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                ProdutosDTO obj = new ProdutosDTO();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setValor(rs.getInt("valor"));
                obj.setStatus(rs.getString("status"));
                lista.add(obj);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar vendidos: " + e.getMessage());
        }

        return lista;
    }

    // método já existente para listar todos os produtos
    public ArrayList<ProdutosDTO> listarProdutos() {
        ArrayList<ProdutosDTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM produtos";

        try (Connection conn = new conectaDAO().connectDB();
             PreparedStatement pstm = conn.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                ProdutosDTO obj = new ProdutosDTO();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setValor(rs.getInt("valor"));
                obj.setStatus(rs.getString("status"));
                lista.add(obj);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e.getMessage());
        }

        return lista;
    }
}
