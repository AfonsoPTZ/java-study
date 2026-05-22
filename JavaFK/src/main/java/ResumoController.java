import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ResumoController {

    @FXML private Label totalGanhosLabel;
    @FXML private Label totalDespesasLabel;
    @FXML private Label saldoLabel;

    @FXML
    public void initialize() {

        double totalGanhos = HelloApplication.ganhos.stream()
                .mapToDouble(g -> g.valor).sum();

        double totalDespesas = HelloApplication.despesas.stream()
                .mapToDouble(d -> d.valor).sum();

        double saldo = totalGanhos - totalDespesas;

        totalGanhosLabel.setText("Ganhos: R$ " + totalGanhos);
        totalDespesasLabel.setText("Despesas: R$ " + totalDespesas);
        saldoLabel.setText("Saldo: R$ " + saldo);
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