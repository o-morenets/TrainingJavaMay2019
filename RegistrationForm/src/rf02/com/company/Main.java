package rf02.com.company;

import rf02.com.company.controller.Controller;
import rf02.com.company.model.Model;
import rf02.com.company.view.View;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Controller controller =
                new Controller(new Model(), new View());
        // Run
        controller.processUser();
    }
}
