package com.example.testvaadin;

import com.example.testvaadin.pojo.PersonContainer;
import com.example.testvaadin.ui.SearchView;
import com.vaadin.Application;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class TestVaadinApplication extends Application implements Button.ClickListener, Property.ValueChangeListener,
        ItemClickListener {

    private static final String MAIN_WINDOW_CAPTION = "Address Book Demo Application";
    private static final String BUTTON_ADD_CONTACT = "Add contact";
    private static final String BUTTON_SEARCH = "Search";
    private static final String BUTTON_SHARE = "Share";
    private static final String BUTTON_HELP = "Help";
    private static final short VIEW_SIZE_OF_HORIZONTAL_SPLIT = 200;

    private Button addContact = new Button(BUTTON_ADD_CONTACT);
    private Button search = new Button(BUTTON_SEARCH);
    private Button share = new Button(BUTTON_SHARE);
    private Button help = new Button(BUTTON_HELP);
    private HorizontalSplitPanel horizontalSplit = new HorizontalSplitPanel();
    private NavigationTree navigationTree = new NavigationTree(this);
    private ListView listView = null;
    private PersonList personList = null;
    private PersonForm personForm = null;
    private HelpWindow helpWindow = null;
    private SharingOptions sharingOptions = null;
    private PersonContainer personContainer = PersonContainer.createWithTestData();
    private SearchView searchView = null;

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {
        initMainWindow();
        setTheme("runo");
    }

    /**
     *
     */
    private void initMainWindow() {
        setMainWindow(new Window(MAIN_WINDOW_CAPTION));
        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();

        mainLayout.addComponent(createToolbar());
        mainLayout.addComponent(horizontalSplit);

        mainLayout.setExpandRatio(horizontalSplit, 1);

        horizontalSplit.setSplitPosition(VIEW_SIZE_OF_HORIZONTAL_SPLIT, HorizontalSplitPanel.UNITS_PIXELS);
        horizontalSplit.setFirstComponent(navigationTree);
        setMainCompounent(getListView());

        getMainWindow().setContent(mainLayout);
    }

    /**
     * @param c
     */
    private void setMainCompounent(Component c) {
        horizontalSplit.setSecondComponent(c);
    }

    /**
     * @return
     */
    private Component createToolbar() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addComponent(addContact);
        horizontalLayout.addComponent(search);
        search.addListener((Button.ClickListener) this);
        horizontalLayout.addComponent(share);
        share.addListener((Button.ClickListener) this);
        horizontalLayout.addComponent(help);
        help.addListener((Button.ClickListener) this);
        return horizontalLayout;
    }

    /**
     * @return the listView
     */
    private ListView getListView() {
        if (listView == null) {
            personList = new PersonList(this);
            personForm = new PersonForm();
            listView = new ListView(personList, personForm);
        }
        return listView;
    }

    /**
     * @return the helpWindow
     */
    private HelpWindow getHelpWindow() {
        if (helpWindow == null) {
            helpWindow = new HelpWindow();
        }
        return helpWindow;
    }

    /**
     * @return the sharingOptions
     */
    private SharingOptions getSharingOptions() {
        if (sharingOptions == null) {
            sharingOptions = new SharingOptions();
        }
        return sharingOptions;
    }

    /**
     * @return the personContainer
     */
    public PersonContainer getPersonContainer() {
        return personContainer;
    }

    /**
     * @return the searchView
     */
    private SearchView getSearchView() {
        if (searchView == null) {
            searchView = new SearchView(this);
        }
        return searchView;
    }

    /**
     * @see com.vaadin.ui.Button.ClickListener#buttonClick(com.vaadin.ui.Button.ClickEvent)
     */
    public void buttonClick(ClickEvent event) {
        final Button source = event.getButton();
        if (source == search) {
            showSearchView();
        } else if (source == share) {
            showShareWindow();
        } else if (source == help) {
            showHelpView();
        }
    }

    /**
     *
     */
    private void showShareWindow() {
        getMainWindow().addWindow(getSharingOptions());
    }

    /**
     *
     */
    private void showHelpView() {
        getMainWindow().addWindow(getHelpWindow());
    }

    /**
     *
     */
    private void showSearchView() {
        setMainCompounent(getSearchView());
    }

    /**
     * @see com.vaadin.data.Property.ValueChangeListener#valueChange(com.vaadin.data.Property.ValueChangeEvent)
     */
    public void valueChange(ValueChangeEvent event) {
        Property property = event.getProperty();
        if (property == personList) {
            Item item = personList.getItem(personList.getValue());
            if (item != personForm.getItemDataSource()) {
                personForm.setItemDataSource(item);
            }
        }
    }

    /**
     * @see com.vaadin.event.ItemClickEvent.ItemClickListener#itemClick(com.vaadin.event.ItemClickEvent)
     */
    public void itemClick(ItemClickEvent event) {
        Object itemId = event.getItemId();
        if (NavigationTree.SHOW_ALL.equals(itemId)) {
            showListView();
        } else if (NavigationTree.SEARCH.equals(itemId)) {
            showSearchView();
        }

    }

    /**
     *
     */
    private void showListView() {
        setMainCompounent(getListView());
    }

}
