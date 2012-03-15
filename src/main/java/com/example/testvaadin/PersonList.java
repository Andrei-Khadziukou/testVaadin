/**
 *
 */
package com.example.testvaadin;

import com.example.testvaadin.pojo.Person;
import com.example.testvaadin.pojo.PersonContainer;
import com.vaadin.data.Property;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.ui.Link;
import com.vaadin.ui.Table;

/**
 * @author Andrei_Khadziukou
 *
 */
@SuppressWarnings("serial")
public class PersonList extends Table {

    /**
     *
     */
    public PersonList(TestVaadinApplication app) {
        addGeneratedColumn("email", new ColumnGenerator() {

            public Object generateCell(Table source, Object itemId, Object columnId) {
                Person person = (Person) itemId;
                Link link = new Link();
                link.setCaption(person.getEmail());
                link.setResource(new ExternalResource("mailto:" + person.getEmail()));
                return link;
            }
        });
        setSizeFull();
        setContainerDataSource(app.getPersonContainer());
        setSelectable(true);
        setImmediate(true);
        addListener((Property.ValueChangeListener) app);
        setNullSelectionAllowed(false);
        setVisibleColumns(PersonContainer.COLUMN_ORDER);
        setColumnHeaders(PersonContainer.COLUMN_HEADER);

        setColumnCollapsingAllowed(true);
        setColumnReorderingAllowed(true);
    }

}
