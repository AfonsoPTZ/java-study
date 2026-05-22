import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {

    public static final List<Despesa> despesas = new ArrayList<>();
    public static final List<Ganho> ganhos = new ArrayList<>();
    public static final List<Usuario> usuarios = new ArrayList<>();

    static {
        usuarios.add(new Usuario("Usuário padrão", "arroba@gmail.com", "123456"));
    }

    public static Stage stage;

    @Override
    public void start(Stage s) throws Exception {
        stage = s;
        mostrarTela("login-view.fxml", "Login");
    }

    public static void mostrarTela(String fxml, String titulo) throws Exception {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getClassLoader().getResource(fxml));
        Scene scene = new Scene(loader.load(), 600, 450);
        stage.setTitle(titulo);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}