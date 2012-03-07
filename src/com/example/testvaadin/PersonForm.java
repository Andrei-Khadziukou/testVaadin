/**
 *
 */
package com.example.testvaadin;

import com.vaadin.ui.Button;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

/**
 * @author Andrei_Khadziukou
 *
 */
@SuppressWarnings("serial")
public class PersonForm extends Form {
    private static final String BUTTON_SAVE = "Save";
    private static final String BUTTON_CANCEL = "Cancel";
    private static final String TEXTFIELD_FIRST_NAME = "First Name";
    private static final String TEXTFIELD_LAST_NAME = "Last Name";

    private Button save = new Button(BUTTON_SAVE);
    private Button cancel = new Button(BUTTON_CANCEL);

    /**
     *
     */
    public PersonForm() {
        addField(TEXTFIELD_FIRST_NAME, new TextField(TEXTFIELD_FIRST_NAME));
        addField(TEXTFIELD_LAST_NAME, new TextField(TEXTFIELD_LAST_NAME));
        HorizontalLayout footer = new HorizontalLayout();
        footer.setSpacing(true);
        footer.addComponent(save);
        footer.addComponent(cancel);
        setFooter(footer);
    }


}
