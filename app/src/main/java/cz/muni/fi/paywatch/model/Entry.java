package cz.muni.fi.paywatch.model;

import java.util.Date;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Jirka on 14.04.2017.
 */

public class Entry extends RealmObject {

    @PrimaryKey
    private Integer id;
    private Double sum;
    private Integer categoryId;
    private Integer accountId;
    private String note;
    private Date date;

    public Entry(Double sum, Date date, Integer categoryId, Integer accountId ) {
        this.sum = sum;
        this.categoryId = categoryId;
        this.accountId = accountId;
        this.date = date;
        Realm realm = Realm.getDefaultInstance();
        Number nextId = realm.where(Entry.class).max("id");
        if ( nextId == null ) {
            this.id = 0;
        } else {
            this.id = nextId.intValue() + 1;
        }
        this.note = "";

    }

    public Entry() {
        super();
    }

    public Double getSum() {
        return sum;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public String getNote() { return note; }

    public Date getDate() { return date; }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

