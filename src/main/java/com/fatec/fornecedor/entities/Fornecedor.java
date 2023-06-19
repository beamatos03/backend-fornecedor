package com.fatec.fornecedor.entities;
import java.io.Serializable;


public class Fornecedor implements Serializable {

    private Integer id;
    private String name;
    private boolean active;
    private String category;
    private String contact;

    public Fornecedor(Integer id, String name,String category, String contact, Boolean active){
        this.id = id;
        this.name = name;
        this.category = category;
        this.contact = contact;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
}
