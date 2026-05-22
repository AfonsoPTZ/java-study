import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DespesasController {

    @FXML private TextField descricaoField;
    @FXML private TextField valorField;

    @FXML
    protected void adicionarDespesa() throws Exception {

        String descricao = descricaoField.getText();
        double valor = Double.parseDouble(valorField.getText());

        HelloApplication.despesas.add(new Despesa(descricao, valor));

        descricaoField.clear();
        valorField.clear();
    }

    @FXML
    protected void irParaGanhos() throws Exception {
        HelloApplication.mostrarTela("ganhos-view.fxml", "Ganhos");
    }

    @FXML
    protected void irParaDespesas() throws Exception {
        HelloApplication.mostrarTela("despesas-view.fxml", "Despesas");
    }

    @FXML
    protected void irParaResumo() throws Exception {
        HelloApplication.mostrarTela("resumo-view.fxml", "Resumo");
    }

    @FXML
    protected void sair() throws Exception {
        HelloApplication.mostrarTela("login-view.fxml", "Login");
    }
}