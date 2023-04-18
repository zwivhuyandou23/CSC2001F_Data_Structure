

class BinarySearchTree
{

   BinaryTreeNode<Account> root;
    /**
     * Initializes the BinaryTreeNode<Account> root
     */
    public BinarySearchTree ()
    {
    root = null;
    }
    
    /**
     * Returs height of the BST
     * @return
     * Value of the BST height
     */
    public int getHeight ()//return height of the binary tree
      {
      return getHeight (root);
      } 
      /**
       * Returs height of the BST
       * @param node
       * Takes in BinaryTreeNode<Account> instance
       * @return
       *  Value of the BST height
       */
    public int getHeight ( BinaryTreeNode<Account>node )
      {
      if (node == null)
        return -1;
      else
        return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
      }
    /**
     * Calls the size(BinaryTreeNode<Account> node) method
     * @return
     * Value of the BST size
     */
    public int size()
    {
      return size(root);

    }
    /**
     * Count the size of the BST
     * @param node
     * Take in a BinaryTreeNode<Account> node
     * @return
     * Value of the BST sizze
     */
    public int size(BinaryTreeNode<Account> node)
    {

      if (node == null){ 
        return 0;
      }
      else
      {
      return 1 + size(node.getLeft()) + size(node.getRight()) ;
      }
    }
    /**
     * Compares new Account with existing accounts 
     * creates a node
     * inserts an account into that node
     * @param d
     */
    public void insert(Account d)
    {
      if (root == null)
      {
          root = new BinaryTreeNode<Account>(d ,null, null);
          
      }
      
      else if (find(d) == null)
      {
        insert(d, root);
        
      }
      else
      {
        System.out.println("Account Name: "+d.getAccountName()+" "+"already exists!!!");
      }
   
    }
    /**
     * Compares new Account with existing accounts 
     * creates a node
     * inserts an account into that node
     * @param d
     * Takes in an Account instance
     * @param node
     * Takes in a BinaryTreeNode<Account> instance
     */
    public void insert(Account d, BinaryTreeNode<Account> node)
    {
      if (d.compareTo(node.data)<=0)
      {

        if (node.left == null)
        
          node.left = new BinaryTreeNode<Account>(d ,null, null);
        else
          insert(d, node.left);
      }

      else
      {
        if (node.right == null)

        node.right = new BinaryTreeNode<Account>(d ,null, null);
      else
        insert(d, node.right);

      }

    }
    /**
     * Calls the BinaryTreeNode<Account> delete(Account d, BinaryTreeNode<Account> node) method
     * @param d
     * Takes in an Account instance
     */
    
    public void delete(Account d)
    {
       
          delete(d, root);
    }
    /**
     * Deletes a node with account d data.
     * @param d
     * BinaryTreeNode<Account> instance
     * @param node
     * BinaryTreeNode<Account> node
     * @return
     */
    public BinaryTreeNode<Account> delete(Account d, BinaryTreeNode<Account> node)
    { 
      if (node == null)
        {return null;}

      int cmp = d.compareTo(node.data);
      if (cmp <0)

        node.left =  delete(d, node.left);
      else if (cmp > 0)

        node.right = delete(d, node.right);

      else if ((node.left != null) && (node.right != null))

      {   node.data = findMin(node.right).data;
        node.right = removeMin(node.right);
      }
      else if (node.left != null)

        node= node.left;
      
      else  
        node = node.right;
          
    return node;   
    }
    /**
     * Finds the least/smallest node in the far left leaf
     * @param node
     * Takes in BinaryTreeNode<Account> instance
     * @return
     * BinaryTreeNode<Account> node
     */
    public BinaryTreeNode<Account> findMin(BinaryTreeNode<Account> node)
    {
      if (node != null)
      {
        while (node.left != null)
          node = node.left;
        
      }
      return node;

    }
    /**
     * removes the smallest leaf node in the BST
     * @param node
     * Takes in BinaryTreeNode<Account> instance
     * @return
     * BinaryTreeNode<Account> node
     */
    public BinaryTreeNode<Account> removeMin(BinaryTreeNode<Account> node)

    {
      if (node == null)
        return null;
      else if (node.left != null)
      {
        node = findMin(node.left);
        return node; 
      }
      else 
        return node.right;

    }
    /**
     * Calls the find(Account d, BinaryTreeNode<Account> node) method
     * 
     * @param d
     * Takes in Account object
     * @return
     * BinaryTreeNode<Account> node
     */
  public BinaryTreeNode<Account> find ( Account d )
  {
    if (root == null)
      return null;
    else
      return find (d, root);    
    }
    /**
     * Finds a node containing the given account
     * @param d
     * Takes in an Account instance
     * @param node
     * Takes in BinaryTreeNode<Account> instance
     * @return
     * BinaryTreeNode<Account> node
     * @
     * 
     * @return
     */
  public BinaryTreeNode<Account> find ( Account d, BinaryTreeNode<Account> node )
  {
    int cmp = d.compareTo (node.data);
    if (cmp == 0)
      return node;

    else if (cmp < 0)
      return (node.left == null) ? null : find (d, node.left);
    
    else if (cmp>0)
      return (node.right == null) ? null : find (d, node.right);
    
    else 
    return null;
}

  /**
   * Calls the getListOfAccounts(BinaryTreeNode<Account> node)
   * Prints the number of accounts
   */
 void getListOfAccounts()
 {  
  getListOfAccounts(root);
  System.out.println("Total Number of Accounts: "+size()+".\n");
 }
 /**
  * Recursively prints all account details using preorder algorithm
  * @param node
  * Takes in an instance of BinaryTreeNode<Account>
  */
 void getListOfAccounts(BinaryTreeNode<Account> node) 
   {
    
     if (node != null)
     {
      visit(node);
      getListOfAccounts(node.getLeft());
      getListOfAccounts(node.getRight());
     }
   }
   /**
    * prints data of the parameter
    * @param node
    */
  void visit(BinaryTreeNode<Account> node)
  {
    System.out.println(node.data);
  }
}