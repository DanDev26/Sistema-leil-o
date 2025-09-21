import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class VendasVIEW extends JFrame {

    private JTable tabelaVendidos;
    private JScrollPane scrollPane;

    public VendasVIEW() {
        setTitle("Produtos Vendidos");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        tabelaVendidos = new JTable();
        scrollPane = new JScrollPane(tabelaVendidos);
        add(scrollPane);

        listarProdutosVendidos();
    }

    private void listarProdutosVendidos() {
        ProdutosDAO dao = new ProdutosDAO();
        ArrayList<ProdutosDTO> lista = dao.listarProdutosVendidos();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nome");
        model.addColumn("Valor");
        model.addColumn("Status");

        for (ProdutosDTO p : lista) {
            model.addRow(new Object[]{p.getId(), p.getNome(), p.getValor(), p.getStatus()});
        }

        tabelaVendidos.setModel(model);
    }
}
