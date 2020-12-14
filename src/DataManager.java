import java.util.ArrayList;

/**
 * A data manager is responsible for loading, writing, and accessing types of
 * data in the system.
 */
public abstract class DataManager<T> {

    /** file contains all customers' data **/
    private String fileName;

    private String filepath;
    private ArrayList<T> data;

    /**
     * Create new DataManager and load in the data from the data files specified by
     * the paths.
     * 
     * @param filePath
     * @param fileName
     * @throws BankException
     */
    public DataManager(String filePath, String fileName) throws BankException {
        this.filepath = filePath;
        this.fileName = fileName;
        this.data = new ArrayList<>();
        loadData();
    }

    /**
     * Load all the data in a data file into the manager.
     * 
     * @param filepath to the data file
     */
    abstract public void loadData() throws BankException;

    /**
     * Write out all the contents of this manager to a data file.
     * 
     * @param filepath to the data file to be written to
     */
    abstract public void writeData();

    /**
     * 
     * @return the string path to the data folder that this manager reads/writes
     *         from/to
     */
    public String getFilepath() {
        return filepath;
    }

    /**
     * 
     * @return the managed data
     */
    public ArrayList<T> getData() {
        return data;
    }

    public String getFileName() {
        return fileName;
    }

}
