import controller.Controller;
import model.Model;
import view.View;

/**
 * Created by o-morenets on 03.06.2019
 */
public class Main {

    /**
     * Main function
     * @param args not used
     */
    public static void main(String[] args) {
        
        // Initialization
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        // Run
        controller.processUser();
    }

}
