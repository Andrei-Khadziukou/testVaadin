/**
 *
 */
package com.example.testvaadin;

import com.example.testvaadin.pojo.PersonContainer;
import com.vaadin.data.Property;
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
        setSizeFull();
        setContainerDataSource(app.getPersonContainer());
        setSelectable(true);
        setImmediate(true);
        addListener((Property.ValueChangeListener) app);
        setNullSelectionAllowed(false);
        setVisibleColumns(PersonContainer.COLUMN_ORDER);
        setColumnHeaders(PersonContainer.COLUMN_HEADER);
    }

}
