import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CadastroController {

    @FXML private TextField nomeField;
    @FXML private TextField emailField;
    @FXML private PasswordField senhaField;
    @FXML private Label erroLabel;

    @FXML
    protected void criarConta() throws Exception {
        String nome = nomeField.getText().trim();
        String email = emailField.getText().trim();
        String senha = senhaField.getText();

        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
            erroLabel.setText("Preencha nome, email e senha.");
            return;
        }

        boolean emailExiste = HelloApplication.usuarios.stream()
                .anyMatch(usuario -> usuario.email.equalsIgnoreCase(email));

        if (emailExiste) {
            erroLabel.setText("Este email já está cadastrado.");
            return;
        }

        HelloApplication.usuarios.add(new Usuario(nome, email, senha));
        HelloApplication.mostrarTela("login-view.fxml", "Login");
    }

    @FXML
    protected void voltarAoLogin() throws Exception {
        HelloApplication.mostrarTela("login-view.fxml", "Login");
    }
}