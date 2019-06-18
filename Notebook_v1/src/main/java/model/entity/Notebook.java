package model.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Notebook data structure based on ArrayList of records
 *
 * Created by o-morenets on 03.06.2019
 */
public class Notebook {
    private List<Record> records;

    /**
     * Constructs notebook data structure
     */
    public Notebook() {
        this.records = new ArrayList<>();
    }

    /**
     * Adds record to notebook
     * @param record notebook record
     */
    public void add(Record record) {
        records.add(record);
    }

    // Getters

    public List<Record> getRecords() {
        return records;
    }
}
