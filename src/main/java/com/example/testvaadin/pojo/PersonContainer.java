/**
 *
 */
package com.example.testvaadin.pojo;

import java.io.Serializable;

import com.vaadin.data.util.BeanItemContainer;

/**
 * @author Andrei_Khadziukou
 *
 */
@SuppressWarnings("serial")
public class PersonContainer extends BeanItemContainer<Person> implements Serializable {

    public static final String[] COLUMN_ORDER = {"firstName", "lastName", "phoneNumber"};
    public static final String[] COLUMN_HEADER = {"First Name", "Last Name", "Phone"};
    /**
     * @param type
     * @throws IllegalArgumentException
     */
    private PersonContainer() throws InstantiationException, IllegalArgumentException {
        super(Person.class);
    }

    public static PersonContainer createWithTestData() {
        PersonContainer personContainer = null;
        try {
           personContainer = new PersonContainer();
           Person person = new Person();
           person.setFirstName("Andrei");
           person.setLastName("Khadziukou");
           personContainer.addItem(person);
           person = new Person();
           person.setFirstName("Anton");
           person.setLastName("Khadziukou");
           personContainer.addItem(person);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return personContainer;
    }

}
