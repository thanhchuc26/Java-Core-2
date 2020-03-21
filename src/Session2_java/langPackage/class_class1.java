/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session2_java.langPackage;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author June
 */
class Person1 {

    private int ID;
    private String name;
    private boolean gender;
    private String address;
    private String email;
    private String phone;
    private float salary;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Person1() {
    }

    public Person1(int ID, String name, boolean gender, String address, String email, String phone, float salary) {
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person [id=" + ID + ", firstName=" + name + ", address=" + address + "]";
    }
}

public class class_class1 {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Person1 person = new Person1(1, "Nguyen Tri Phuong", true, "38 Yen Bai", "phuongnt@softech.vn", "0123456789", 3_000_000f);
        // Obtain class object
        Class<?> personClass = person.getClass();
        // Obtain an array fields
        Field[] fields = personClass.getDeclaredFields();
        // Get value from fields
        System.out.println("====Start get value from fields====");
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                System.out.println(field.get(person));
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(class_class1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // Set value for field
        System.out.println("====Start set value for field====");
        Person1 person2 = (Person1) personClass.newInstance();

        for (Field field : fields) {
            field.setAccessible(true);

            if (field.getName().equals("ID")) {
                field.set(person2, 2);
            } else if (field.getName().equals("gender")) {
                field.set(person2, true);
            } else if (field.getName().equals("salary")) {
                field.set(person2, 5000000);
            } else {
                field.set(person2, "Blah");
            }
        }
        System.out.println("====Print to screen====");
        System.out.println(person.toString());
        System.out.println(person2.toString());
    }
}
