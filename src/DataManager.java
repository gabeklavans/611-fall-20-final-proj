import java.util.ArrayList;

/**
 * A data manager is responsible for loading, writing, and accessing types of
 * data in the system.
 */
public abstract class DataManager<T> {

    private String filepath;
    private ArrayList<T> data;

    public DataManager(String filepath) {
        this.filepath = filepath;
        this.data = new ArrayList<>();
    }

    /**
     * Load all the data in a data file into the manager.
     * 
     * @param filepath to the data file
     */
    abstract public void loadData();

    /**
     * Write out all the contents of this manager to a data file.
     * 
     * @param filepath to the data file to be written to
     */
    abstract public void writeData();

    /**
     * 
     * @return the string path to the data file that this manager reads/writes
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

}
