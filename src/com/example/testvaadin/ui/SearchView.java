/**
 *
 */
package com.example.testvaadin.ui;

import com.example.testvaadin.TestVaadinApplication;
import com.vaadin.ui.Panel;

/**
 * @author Andrei_Khadziukou
 *
 */
@SuppressWarnings("serial")
public class SearchView extends Panel {
    private static final String WINDOW_CAPTION = "Search contacts";

    /**
     *
     */
    public SearchView(final TestVaadinApplication app) {
        setCaption(WINDOW_CAPTION);
        setSizeFull();
    }


}
