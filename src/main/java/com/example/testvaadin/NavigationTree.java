/**
 *
 */
package com.example.testvaadin;

import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Tree;

/**
 * @author Andrei_Khadziukou
 *
 */
@SuppressWarnings("serial")
public class NavigationTree extends Tree {

    public static final Object SHOW_ALL = "Show all";
    public static final Object SEARCH = "Search";
    /**
     *
     */
    public NavigationTree(TestVaadinApplication app) {
        addItem(SHOW_ALL);
        addItem(SEARCH);

        setSelectable(true);
        setNullSelectionAllowed(false);

        addListener((ItemClickListener) app);
    }


}
