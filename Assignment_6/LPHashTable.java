import java.util.List;
/**
 * Simple hash table implementation using linear probing.
 *
 * @author Stephan Jamieson
 * @version 24/4/2015
 */
public class LPHashTable extends HashTable {

    /**
     * Create an LPHashTable with DEFAULT_SIZE table.
     *
     */
    public LPHashTable() { super(); }

    /**
     * Create an LPHashTable with the given default size table.
     */

    public LPHashTable(final int size) { super(size); }

    /**
     * Find the index for entry: if entry is in the table, then returns its position;
     * if it is not in the table then returns the index of the first free slot.
     * Returns -1 if a slot is not found (such as when the table is full under LP).
     *
     */
    protected int findIndex(String key) {
		// Implement using linear probing.
    int index = 0;
        for (String i : table) 
        {
            if (i != null)
                {   
                    if (i.equals(key))
                        return  index;
                }
                index++;
        }
        if (index>0)
        {   
            incProbeCount();
            index = hashFunction(key);

            if(getProbeCount()> tableSize())
                System.out.println("probing failed!!");
            return index;    
        }
        else
            index = -1;
    return index;
    }

}
