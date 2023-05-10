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
    int full = 0;
    //resetProbeCount();
        for (String i : table) 
        {
            
            if (i != null && i.equals(key)){return index;}
            
            index++;    
        }
        index = 0;
        int freeSlot = 0;

        index = hashFunction(key);
        System.out.println("probecount = "+getProbeCount());
        
        incProbeCount();
        while (table[index] != null)
        {
            incProbeCount();
            System.out.println(key+" "+index+" "+getProbeCount());

            index++;

            if (index==tableSize())
            {
                index = 0;
            }
            if (freeSlot==tableSize())
                return-1;
          
       freeSlot++;
    }
    
       return index;
    }

}
