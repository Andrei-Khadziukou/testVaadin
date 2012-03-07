/**
 *
 */
package com.example.testvaadin;

import com.vaadin.ui.VerticalSplitPanel;

/**
 * @author Andrei_Khadziukou
 *
 */
@SuppressWarnings({"serial"})
public class ListView extends VerticalSplitPanel {

    private static final byte SPLIT_POSITION = 40;

    /**
     *
     */
    public ListView(PersonList personList, PersonForm personForm) {
        setFirstComponent(personList);
        setSecondComponent(personForm);
        setSplitPosition(SPLIT_POSITION);
    }

}
