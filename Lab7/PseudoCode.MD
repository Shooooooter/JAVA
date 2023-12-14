Class Sale:
    Fields: productName, date, quantity
    Constructor: Sale(productName, date, quantity)
    Getters: getProductName(), getDate(), getQuantity()

Class SalesProcessor:
    Fields: LinkedList-Type-Sale sales
    Constructor: SalesProcessor()
    Methods:
        process(filename):
            Read CSV file, skip header
            For each line:
                Split fields, extract productName, date, quantity
                AddSale(productName, date, quantity)

        addSale(productName, date, quantity):
            Add new Sale to the sales LinkedList

        sort():
            Sort sales by date

        search(productName):
            Search and return Sale by productName

        saveToFile(filename):
            Save sales data to CSV file

        printRecords(start, end):
            Print specified range of records

        insertRecord():
            Input productName, date, quantity
            AddSale(productName, date, quantity)

Class CsvGenerator:
    main():
        Generate and save random sales data to CSV

Class Main:
    main():
        Run CsvGenerator.main()
        Create SalesProcessor instance
        Process CSV file
        Sort sales data
        Print records 5-8
        Insert a new record
        Print records 5-8 again
        Ask user to save data
            If yes, input filename and save to file