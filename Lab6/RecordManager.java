import java.util.Scanner;

public abstract class RecordManager<T> {
    private int operations = 0;
    private boolean isRunning = true;
    private MyLinkedList<T> recordList;

    public RecordManager(MyLinkedList<T> recordList) {
        this.recordList = recordList;
    }

    public MyLinkedList<T> getRecordList() {
        return recordList;
    }

    public void setRecordList(MyLinkedList<T> recordList) {
        this.recordList = recordList;
    }

    public void runRecordManager(Scanner scanner) {
        System.out.println("---------------------------------------------------");
        System.out.println("Welcome to Record Manager!------RA-298");
        int userChoice = -1;
        while (this.isRunning) {
            System.out.println("---------------------------------------------------");
            System.out.println("Enter Any Other Character To Quit.");
            System.out.println("1) View Record List.");
            System.out.println("2) Add to Record List.");
            System.out.println("3) Search in Record List.");
            System.out.println("4) Delete from Record List.");
            System.out.println("---------------------------------------------------");

            System.out.print("Choose the desired operation by typing the operation code: ");
            try {
                userChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric choice.");
                continue;
            }
            switch (userChoice) {
                case 1:
                    System.out.println(recordList.toString());
                    systemBuffer(scanner);
                    this.operations++;
                    break;

                case 2:
                    handleRecordInsertion(scanner);
                    System.out.println(recordList.toString());
                    systemBuffer(scanner);
                    this.operations++;
                    break;

                case 3:
                    handleRecordSearching(scanner);
                    systemBuffer(scanner);
                    this.operations++;
                    break;

                case 4:
                    handleRecordDeletion(scanner);
                    System.out.println(recordList.toString());
                    systemBuffer(scanner);
                    this.operations++;
                    break;

                default:
                    this.isRunning = !this.isRunning;
                    break;
            }
        }
        System.out.println("Operations Performed: " + this.operations);
    }

    public abstract T createRecord(Scanner sc);

    public abstract MyNode<T> getNodeByAttribute(String attrValue);

    private void handleRecordSearching(Scanner scanner) {
        try {
            MyNode<T> result;
            System.out.print("1) Search By Index.\n2) Search By Value.\n----------------------\nYour Choice: ");
            int choice = scanner.nextInt();
            if (choice > 2 || choice < 0) {
                System.out.println("Invalid Operation Selected!");
            } else if (choice == 1) {
                System.out.print("Enter Index: ");
                int nodeIndex = scanner.nextInt();
                result = recordList.getNodeByIndex(nodeIndex);
                if (result != null) {
                    System.out.println("Record Found:\n" + result.getValue().toString());
                } else {
                    System.out.println("Record not found!");
                }
            } else {
                System.out.print("Enter Record Attribute: ");
                String recordAttribute = scanner.next();
                T resultRecord = getNodeByAttribute(recordAttribute).getValue();
                if (resultRecord != null) {
                    System.out.println("Record Found:\n" + resultRecord.toString());
                } else {
                    System.out.println("Record not found!");
                }
            }
        } catch (Exception e) {
            System.out.println("Error during searching: " + e.getMessage());
        }
    }

    private void handleRecordInsertion(Scanner scanner) {
        try {
            if (recordList.getSize() > 0) {
                System.out.print("Valid Indices up to: " + (recordList.getSize() - 1)
                        + "\nEnter the Index to insert the new Record at: ");
                int listIndex = scanner.nextInt();
                scanner.nextLine();
                T newRecord = createRecord(scanner);
                recordList.add(newRecord, listIndex);
            } else {
                T newRecord = createRecord(scanner);
                recordList.add(newRecord);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid numeric choice.");
        }
    }

    private void handleRecordDeletion(Scanner scanner) {
        try {
            System.out.print("1) Delete By Index.\n2) Delete By Value.\n----------------------\nYour Choice: ");
            int choice = scanner.nextInt();
            systemBuffer(scanner);
            if (choice == 2) {
                System.out.print("Enter Roll Number: ");
                String recordAttribute = scanner.nextLine();
                T resultRecord = getNodeByAttribute(recordAttribute).getValue();
                if (resultRecord != null) {
                    recordList.del(resultRecord);
                } else {
                    System.out.println("Record not found!");
                }
            } else if (choice == 1) {
                System.out.print("Enter Index: ");
                int nodeIndex = scanner.nextInt();
                recordList.del(nodeIndex);
            } else {
                System.out.println("Invalid Operation Selected!");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    private void systemBuffer(Scanner scanner) {
        System.out.println("Press 'Enter' key to continue:");
        scanner.nextLine();
    }

    public int getOperations() {
        return operations;
    }

    public void setOperations(int operations) {
        this.operations = operations;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }
}
