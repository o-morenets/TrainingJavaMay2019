package model;

import model.entity.Notebook;
import model.entity.Record;

/**
 * Notebook model
 *
 * Created by o-morenets on 03.06.2019
 */
public class Model {
    private Notebook notebook;

    /**
     * Constructor
     */
    public Model() {
        this.notebook = new Notebook();
    }

    /**
     * Add a record to notebook data structure
     * @param record record to be added
     */
    public void addToNotebook(Record record) {
        notebook.add(record);
    }

    // Getter

    public Notebook getNotebook() {
        return notebook;
    }
}
