/**
 *
 */
package com.example.testvaadin;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.example.testvaadin.pojo.Person;
import com.example.testvaadin.pojo.PersonContainer;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;

/**
 * @author Andrei_Khadziukou
 *
 */
@SuppressWarnings("serial")
public class PersonForm extends Form implements ClickListener {
    private static final String BUTTON_SAVE = "Save";
    private static final String BUTTON_CANCEL = "Cancel";
    private static final String BUTTON_EDIT = "Edit";
    private static final String COMBOBOX_CAPTION = "City";

    private Button save = new Button(BUTTON_SAVE, (ClickListener) this);
    private Button cancel = new Button(BUTTON_CANCEL, (ClickListener) this);
    private Button edit = new Button(BUTTON_EDIT, (ClickListener) this);
    private ComboBox comboBoxCity = new ComboBox(COMBOBOX_CAPTION);

    private TestVaadinApplication app;

    private boolean isAddNewPerson = false;
    private Person newPerson = null;

    /**
     *
     */
    public PersonForm(TestVaadinApplication app) {
        this.app = app;

        //enable buffering
        setWriteThrough(false);

        HorizontalLayout footer = new HorizontalLayout();
        //by default footer is not visible
        footer.setVisible(false);
        footer.setSpacing(true);

        footer.addComponent(save);
        footer.addComponent(edit);
        footer.addComponent(cancel);

        comboBoxCity.setNewItemsAllowed(true);
        comboBoxCity.setNullSelectionAllowed(false);

        for(Iterator<Person> it = app.getPersonContainer().getItemIds().iterator(); it.hasNext();) {
            comboBoxCity.addItem(it.next().getCity());
        }

        setFormFieldFactory(new DefaultFieldFactory() {

            @Override
            public Field createField(Item item, Object propertyId, Component uiContext) {
                if (propertyId.equals("city")) {
                    return comboBoxCity;
                }
                Field field = super.createField(item, propertyId, uiContext);
                if (propertyId.equals("email")) {
                    field.addValidator(new EmailValidator("Inkorrect e-mail!"));
                }
                return field;
            }
        });

        setFooter(footer);
    }

    public void buttonClick(ClickEvent event) {
        Button source = event.getButton();

        if (source == save) {
            // actions for 'save' event
            if (!isValid()) {
                return;
            }
            commit();
            if (isAddNewPerson) {
                Item addedItem = app.getPersonContainer().addItem(newPerson);
                setItemDataSource(addedItem);
                isAddNewPerson = false;
            }
            setReadOnly(true);
        } else if (source == cancel) {
            // actions for 'cancel' event
            discard();
            isAddNewPerson = false;
            setReadOnly(true);
        } else if (source == edit) {
            // actions for 'edit' event
            setReadOnly(false);
        }
    }

    @Override
    public void setItemDataSource(Item newDataSource) {
        isAddNewPerson = false;
        if (newDataSource != null) {
            List<?> orderedProperties = Arrays.asList(PersonContainer.COLUMN_ORDER);
            super.setItemDataSource(newDataSource, orderedProperties);
                    setReadOnly(true);
                    getFooter().setVisible(true);
        } else {
            super.setItemDataSource(newDataSource);
            getFooter().setVisible(false);
        }
    }

    @Override
    public void setReadOnly(boolean readOnly) {
        super.setReadOnly(readOnly);
        save.setVisible(!readOnly);
        cancel.setVisible(!readOnly);
        edit.setVisible(readOnly);
    }

    public void addContact() {
        newPerson = new Person();
        setItemDataSource(new BeanItem<Person>(newPerson));
        isAddNewPerson = true;
        setReadOnly(false);
    }

}
