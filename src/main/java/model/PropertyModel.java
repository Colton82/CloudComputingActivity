package model;

import java.sql.Date;

public class PropertyModel 
{
    public int id;
    public String nameOfProperty;
    public String location;
    public int squareFeet;
    public Date dateOfConstruction;
    public String photoFileName;
    public String description;
    public double value;

    public PropertyModel()
    {
        this.id = 0;
        this.nameOfProperty = "null";
        this.location = "none";
        this.squareFeet = 0;
        this.dateOfConstruction = new Date(2003, 8, 3);
        this.photoFileName = "C:example/path/variable";
        this.description = "This is a filler property entry";
        this.value = 0;
    }

    public PropertyModel(int id, String nameOfProperty, String location, int squareFeet, Date dateOfConstruction,
        String photoFileName, String description, double value) {
        this.id = id;
        this.nameOfProperty = nameOfProperty;
        this.location = location;
        this.squareFeet = squareFeet;
        this.dateOfConstruction = dateOfConstruction;
        this.photoFileName = photoFileName;
        this.description = description;
        this.value = value;
    }

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getNameOfProperty() {
        return nameOfProperty;
    }
    public void setNameOfProperty(String nameOfProperty) {
        this.nameOfProperty = nameOfProperty;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getSquareFeet() {
        return squareFeet;
    }
    public void setSquareFeet(int squareFeet) {
        this.squareFeet = squareFeet;
    }
    public Date getDateOfConstruction() {
        return dateOfConstruction;
    }
    public void setDateOfConstruction(Date dateOfConstruction) {
        this.dateOfConstruction = dateOfConstruction;
    }
    public String getPhotoFileName() {
        return photoFileName;
    }
    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    

}
