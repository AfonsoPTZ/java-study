import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML private TextField emailField;
    @FXML private PasswordField senhaField;
    @FXML private Label erroLabel;

    @FXML
    protected void fazerLogin() throws Exception {
        String email = emailField.getText().trim();
        String senha = senhaField.getText();

        boolean autenticado = HelloApplication.usuarios.stream()
                .anyMatch(usuario -> usuario.email.equalsIgnoreCase(email) && usuario.senha.equals(senha));

        if (autenticado) {
            erroLabel.setText("");
            HelloApplication.mostrarTela("ganhos-view.fxml", "Ganhos");
        } else {
            erroLabel.setText("Email ou senha incorretos!");
        }
    }

    @FXML
    protected void irParaCadastro() throws Exception {
        HelloApplication.mostrarTela("cadastro-view.fxml", "Cadastro");
    }
}