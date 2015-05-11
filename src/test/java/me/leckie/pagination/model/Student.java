package me.leckie.pagination.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author leckie
 * @date May 11, 2015
 */
public class Student implements Serializable {

    private static final long serialVersionUID = -5446813065136659327L;

    private Long id;

    private String name;

    private int gender;

    private Date birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + gender + "," + birthday;
    }

}
