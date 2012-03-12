package com.example.testvaadin.filter;

public class SearchFilter {

    private final String searchTerm;
    private final Object propertyId;
    private final String searchName;
    public SearchFilter(Object propertyId, String searchTerm, String searchName) {
        this.searchTerm = searchTerm;
        this.propertyId = propertyId;
        this.searchName = searchName;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public Object getPropertyId() {
        return propertyId;
    }

    public String getSearchName() {
        return searchName;
    }

    @Override
    public String toString() {
        return getSearchName();
    }

}
