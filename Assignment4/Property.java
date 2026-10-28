/*

 Class: CMSC203 CRN XXXX
 Program: Assignment #4
 Instructor:Ahmed Tarek
 Summary of Description: Design and implement a Property Management application in Java that manages multiple properties owned or managed by a company.
 Due Date: 10/28/2026
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student Name: Yizhu Wang
*/

public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;

    public Property() {
        propertyName = "";
        city = "";
        rentAmount = 0.0;
        owner = "";
    }

    public Property(String propertyName, String city,
                    double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
    }

    public Property(Property other) {
        propertyName = other.propertyName;
        city = other.city;
        rentAmount = other.rentAmount;
        owner = other.owner;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getCity() {
        return city;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public String getOwner() {
        return owner;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Property Name: " + propertyName
                + "\nCity: " + city
                + "\nRent Amount: $" + String.format("%.2f", rentAmount)
                + "\nOwner: " + owner;
    }
}
