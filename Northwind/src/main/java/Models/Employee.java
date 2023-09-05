package Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeID")
    private int employeeID;
    @Column(name = "LastName")
    private String lastnameName;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "BirthDate")
    private LocalDate birthdate;
    @Column(name = "Photo")
    private String photo;
    @Column(name = "Notes")
    private String notes;

    public Employee() {
    }

    public Employee(int employeeID) {
        this.employeeID = employeeID;
    }

    public Employee(String lastnameName, String firstName, LocalDate birthdate, String photo, String notes) {
        this.lastnameName = lastnameName;
        this.firstName = firstName;
        this.birthdate = birthdate;
        this.photo = photo;
        this.notes = notes;
    }

    public Employee(int employeeID, String lastnameName, String firstName, LocalDate birthdate, String photo, String notes) {
        this.employeeID = employeeID;
        this.lastnameName = lastnameName;
        this.firstName = firstName;
        this.birthdate = birthdate;
        this.photo = photo;
        this.notes = notes;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getLastnameName() {
        return lastnameName;
    }

    public void setLastnameName(String lastnameName) {
        this.lastnameName = lastnameName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", lastnameName='" + lastnameName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthdate=" + birthdate +
                ", photo='" + photo + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}