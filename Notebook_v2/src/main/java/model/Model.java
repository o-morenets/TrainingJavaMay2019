package model;

import db.DataBase;
import exception.NotUniqueLoginException;
import model.entity.Record;

import java.util.ArrayList;
import java.util.List;

/**
 * Model data structure based on ArrayList of records
 *
 * Created by o-morenets on 03.06.2019
 */
public class Model {

    private List<Record> records;

    /**
     * Constructs notebook data structure
     */
    public Model() {
        this.records = new ArrayList<>();
    }

    /**
     * Adds record to this notebook
     *
     * @param record notebook record
     * @throws NotUniqueLoginException when record.login is not unique
     */
    public void add(Record record) throws NotUniqueLoginException {
        String login = record.getLogin();
        if (DataBase.isLoginUnique(login)) {
            records.add(record);
        } else {
            throw new NotUniqueLoginException("Login is not unique", login);
        }
    }

    // Getters & Setters

    public List<Record> getRecords() {
        return records;
    }
}
