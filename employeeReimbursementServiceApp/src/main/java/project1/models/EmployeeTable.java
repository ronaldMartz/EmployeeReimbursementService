package project1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class EmployeeTable {
    //EmployeeTable Class info from the employee table.
    @Id
    @Column(name = "EMPLOYEE_ID", columnDefinition = "primary key")
    private Integer id;

    @Column(name = "FIRST_NAME")
    private String first_name;

    @Column(name = "LAST_NAME")
    private String last_name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "HASH")
    private String hash;

    @Column(name = "PHONE_NUMBER")
    private Integer phone_number;

    @Column(name = "IS_MANAGER")
    private Boolean is_manager;

    @Column(name = "IS_LOCKED")
    private Boolean is_locked;

    public EmployeeTable() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Integer getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Integer phone_number) {
        this.phone_number = phone_number;
    }

    public Boolean getIs_manager() {
        return is_manager;
    }

    public void setIs_manager(Boolean is_manager) {
        this.is_manager = is_manager;
    }

    public Boolean getIs_locked() {
        return is_locked;
    }

    public void setIs_locked(Boolean is_locked) {
        this.is_locked = is_locked;
    }

    @Override
    public String toString() {
        return "EmployeeTable{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", hash='" + hash + '\'' +
                ", phone_number=" + phone_number +
                ", is_manager=" + is_manager +
                ", is_locked=" + is_locked +
                '}';
    }
}
