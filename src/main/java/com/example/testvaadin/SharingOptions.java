/**
 *
 */
package com.example.testvaadin;

import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

/**
 * @author Andrei_Khadziukou
 *
 */
@SuppressWarnings("serial")
public class SharingOptions extends Window {
    private static final String BUTTON_OK = "Ok";
    private static final String WINDOW_CAPTION = "Sharing option";
    private static final String LABEL_TEXT = "With these setting you can modify contact sharing options." +
                                             "(non-functional, example of modal dialog)";
    private static final String CHECKBOX_GMAIL = "Gmail";
    private static final String CHECHBOX_POINT_MAC = ".Mac";

    /**
     *
     */
    public SharingOptions() {
        setModal(true);
        setWidth("50%");
        center();
        setCaption(WINDOW_CAPTION);
        addComponent(new Label(LABEL_TEXT));
        addComponent(new CheckBox(CHECKBOX_GMAIL));
        addComponent(new CheckBox(CHECHBOX_POINT_MAC));
        Button close = new Button(BUTTON_OK);
        addComponent(close);

    }



}
