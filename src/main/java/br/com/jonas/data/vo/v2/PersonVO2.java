package br.com.jonas.data.vo.v2;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class PersonVO2 implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    private Date birthDay;

    public PersonVO2() {
    }


    public PersonVO2(String firstName, String lastName, String address, String gender,Date birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
        this.birthDay = birthDay;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonVO2 personVO2 = (PersonVO2) o;
        return Objects.equals(id, personVO2.id) && Objects.equals(firstName, personVO2.firstName) && Objects.equals(lastName, personVO2.lastName) && Objects.equals(address, personVO2.address) && Objects.equals(gender, personVO2.gender) && Objects.equals(birthDay, personVO2.birthDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, gender, birthDay);
    }
}
