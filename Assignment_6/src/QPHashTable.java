/**
 * Simple hash table implementation using quadratic probing.
 *
 * @author Stephan Jamieson
 * @version 24/4/2015
 */
public class QPHashTable  extends HashTable {


    /**
     * Create an QPHashTable with DEFAULT_SIZE table.
     */
    public QPHashTable() { super(); }

    /**
     * Create an QPHashTable with the given default size table.
     */
    public QPHashTable(final int size) { super(size); }

    /**
     * Find the index for entry: if entry is in the table, then returns its position;
     * if it is not in the table then returns the index of the first free slot.
     * Returns -1 if a slot is not found (such as when the table is full under LP).
     *
     */
    protected int findIndex(String key) {
		// Implement using quadratic probing.
    int index = 0;
        for (String i : table) 
        {   
            if (i != null && i.equals(key)){return index;}
            index++;     
        }
        index = 0;
        int freeSlot = 0;
        
        int hash = hashFunction(key);
        index = hash;
        incProbeCount();
        while (table[index] != null)
        {
            
            incProbeCount();
            //System.out.println(key+" "+index+" "+freeSlot);
            if (index >=tableSize())
            {
                index = 0;
            }
            if (freeSlot==tableSize())
                return-1;

       freeSlot++;
       index = (hash + (freeSlot * freeSlot));
       
    }
       return index;
  }
  
}
