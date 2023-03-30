package Phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneDirectory {
    private List<Record> records;

    public PhoneDirectory() {
        this.records = new ArrayList<>();
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public void addRecords(Record record) {
        records.add(record);


    }

    public Record findRecord(String lastName) {

        for (Record record : records) {
            if  (record.getLastName().equals(lastName)) {
            return record;
            }


        }
        return null;
    }
    public List <Record> findAll (String lastName) {
       List <Record> recordsByName = new ArrayList<>();
        for (Record record : records) {

            if  (record.getLastName().equals(lastName)) {
            recordsByName.add(record);
            }


        }
              return recordsByName.isEmpty() ? null : recordsByName;
    }
}
