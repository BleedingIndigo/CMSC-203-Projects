
public class PropertyDriver {
    public static void main(String[] args) {
        ManagementCompany company =
                new ManagementCompany("Sunrise Management", "12345");

        Property property1 =
                new Property("Maple Apartments", "Rockville",
                        1800.00, "Alice Smith");

        Property property2 =
                new Property("Oak Townhomes", "Germantown",
                        2200.00, "Bob Johnson");

        Property property3 =
                new Property("Pine House", "Gaithersburg",
                        1950.00, "Carol Davis");

        System.out.println("Adding Properties:");

        System.out.println("Property 1 index: "
                + company.addProperty(property1));

        System.out.println("Property 2 index: "
                + company.addProperty(property2));

        System.out.println("Property 3 index: "
                + company.addProperty(property3));

        System.out.println("\nManagement Company Information:");
        System.out.println(company);

        System.out.println("\nTotal Rent: $"
                + String.format("%.2f", company.totalRent()));

        System.out.println("Property Count: "
                + company.getPropertyCount());

        Property propertyCopy = new Property(property1);

        System.out.println("\nCopied Property:");
        System.out.println(propertyCopy);

        ManagementCompany companyCopy =
                new ManagementCompany(company);

        System.out.println("\nCopied Management Company:");
        System.out.println(companyCopy);

        System.out.println("\nCopied Company Total Rent: $"
                + String.format("%.2f", companyCopy.totalRent()));
    }
}
