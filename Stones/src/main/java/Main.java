import controller.Controller;
import model.Riviere;
import view.View;

public class Main {

    public static void main(String[] args) {
        Riviere riviere = new Riviere();
        View view = new View();
        Controller controller = new Controller(riviere, view);
        controller.processUser();
    }
}
