import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class EmployeeRecord implements Comparable<EmployeeRecord> {
    private String id;
    private String name;
    private String designation;
    private String department;
    private String companyName;

    private static Set<String> assignedIds = new HashSet<>();

    public EmployeeRecord(String name, String designation, String department, String companyName) {
        this.id = generateUniqueRandomId();
        this.name = name;
        this.designation = designation;
        this.department = department;
        this.companyName = companyName;
    }

    private String generateUniqueRandomId() {
        String newId;
        do {
            newId = generateRandomId();
        } while (!isIdUnique(newId));
        return newId;
    }

    private boolean isIdUnique(String id) {
        return assignedIds.add(id);
    }

    private String generateRandomId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "").substring(0, 8);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDepartment() {
        return department;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public int compareTo(EmployeeRecord other) {
        return this.id.compareTo(other.id);
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nDesignation: " + designation + "\nDepartment: " + department +
                "\nCompany: " + companyName + "\n------------------------";
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EmployeeRecord that = (EmployeeRecord) obj;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
