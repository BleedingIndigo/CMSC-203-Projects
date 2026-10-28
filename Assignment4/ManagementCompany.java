

public class ManagementCompany {
    private String name;
    private String taxId;
    private Property[] properties;
    private int propertyCount;

    public static final int MAX_PROPERTIES = 5;
    public static final int ERR_FULL = -1;

    public ManagementCompany(String name, String taxId) {
        this.name = name;
        this.taxId = taxId;
        properties = new Property[MAX_PROPERTIES];
        propertyCount = 0;
    }

    public ManagementCompany(ManagementCompany other) {
        name = other.name;
        taxId = other.taxId;
        properties = new Property[MAX_PROPERTIES];
        propertyCount = other.propertyCount;

        for (int i = 0; i < propertyCount; i++) {
            properties[i] = new Property(other.properties[i]);
        }
    }

    public String getName() {
        return name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public int getPropertyCount() {
        return propertyCount;
    }

    public Property getProperty(int index) {
        if (index < 0 || index >= propertyCount) {
            return null;
        }

        return new Property(properties[index]);
    }

    public int addProperty(Property p) {
        if (propertyCount >= MAX_PROPERTIES || p == null) {
            return ERR_FULL;
        }

        properties[propertyCount] = new Property(p);
        propertyCount++;

        return propertyCount - 1;
    }

    public double totalRent() {
        double total = 0.0;

        for (int i = 0; i < propertyCount; i++) {
            total += properties[i].getRentAmount();
        }

        return total;
    }

    @Override
    public String toString() {
        String result = "Management Company: " + name
                + "\nTax ID: " + taxId
                + "\nNumber of Properties: " + propertyCount
                + "\n\nProperty Information:\n";

        for (int i = 0; i < propertyCount; i++) {
            result += "\nProperty " + (i + 1) + ":\n";
            result += properties[i].toString() + "\n";
        }

        result += "\nTotal Rent: $"
                + String.format("%.2f", totalRent());

        return result;
    }
}
