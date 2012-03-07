/**
 *
 */
package com.example.testvaadin;

import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

/**
 * @author Andrei_Khadziukou
 *
 */
@SuppressWarnings("serial")
public class HelpWindow extends Window {

    private static final String HELP_HTML_SNIPPET = "This is an application built during <strong>" +
                                                    "<a href=\"http://dev.vading.com/\">Vaadin</a></strong>" +
                                                    "tutorial. Hopeful it doesn't any any real help.";

    private static final String WINDOW_CAPTION = "Address Book help";

    /**
     *
     */
    public HelpWindow() {
        setCaption(WINDOW_CAPTION);
        addComponent(new Label(HELP_HTML_SNIPPET, Label.CONTENT_XHTML));
    }

}
