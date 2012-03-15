/**
 *
 */
package com.example.testvaadin.ui;

import com.example.testvaadin.TestVaadinApplication;
import com.example.testvaadin.filter.SearchFilter;
import com.example.testvaadin.pojo.PersonContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;

/**
 * @author Andrei_Khadziukou
 *
 */
@SuppressWarnings("serial")
public class SearchView extends Panel {
    private static final String WINDOW_CAPTION = "Search contacts";
    private static final String LABLE_SEARCH_TERM = "Search term";
    private static final String LABLE_FIELD_TO_SEARCHE = "Field to search";
    private static final String LABLE_SEARCH_NAME = "Search Name";
    private static final String CHECKBOX_CAPTION = "Save search";
    private static final String BUTTON_CAPTION = "Search";

    private TextField searchTerm;
    private NativeSelect searchField;
    private CheckBox cbSaveSearch;
    private TextField searchName;
    private Button search;

    private TestVaadinApplication app;
    /**
     *
     */
    public SearchView(final TestVaadinApplication app) {
        this.app = app;
        setCaption(WINDOW_CAPTION);
        setSizeFull();

        FormLayout formLayout = new FormLayout();
        setContent(formLayout);

        searchTerm = new TextField(LABLE_SEARCH_TERM);
        searchField = new NativeSelect(LABLE_FIELD_TO_SEARCHE);

        cbSaveSearch = new CheckBox(CHECKBOX_CAPTION);
        cbSaveSearch.setImmediate(true);
        cbSaveSearch.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                searchName.setVisible(event.getButton().booleanValue());
            }
        });

        searchName = new TextField(LABLE_SEARCH_NAME);

        search = new Button(BUTTON_CAPTION);
        search.addListener(new Button.ClickListener() {

            public void buttonClick(ClickEvent event) {
                performSearch();
            }
        });

        for (int i = 0; i < PersonContainer.COLUMN_ORDER.length; i++) {
            searchField.addItem(PersonContainer.COLUMN_ORDER[i]);
            searchField.setItemCaption(PersonContainer.COLUMN_ORDER[i], PersonContainer.COLUMN_HEADER[i]);
        }

        searchField.setValue("lastName");
        searchField.setNullSelectionAllowed(false);
        cbSaveSearch.setValue(Boolean.TRUE);

        addComponent(searchTerm);
        addComponent(searchField);
        addComponent(cbSaveSearch);
        addComponent(searchName);
        addComponent(search);

        addStyleName("view");
    }

    private void performSearch() {
        SearchFilter searchFilter = new SearchFilter(searchField.getValue(),
                (String) searchTerm.getValue(), (String) searchName.getValue());
        if (cbSaveSearch.booleanValue()) {
            app.saveSearch(searchFilter);
        }
        app.search(searchFilter);
    }

}
