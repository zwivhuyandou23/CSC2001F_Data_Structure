

class BinarySearchTree
{

   BinaryTreeNode<Account> root;
 
    public BinarySearchTree ()
    {
    root = null;
    }
    
    /**
     * Returs height of the BST
     * @return
     */
    public int getHeight ()//return height of the binary tree
      {
      return getHeight (root);
      } 
    public int getHeight ( BinaryTreeNode<Account>node )
      {
      if (node == null)
        return -1;
      else
        return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
      }
    /**
     * returns size of tree i.e total number of nodes(Accounts)
     * @return
     */
    public int size()
    {
      return size(root);

    }
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
     * and creates a node and inserts an account into the BST nod
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
     * deletes a node containing the given account
     * @param d
     */
    public void delete(Account d)
    {
       
          delete(d, root);
    }
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
     * finds the least/smallest node in the far left leaf
     * @param node
     * @return
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
     * removes the smallest leaf in the BST
     * @param node
     * @return
     */
    public BinaryTreeNode<Account> removeMin(BinaryTreeNode<Account> node)

    {
      if (node == null)
        return null;
      else if (node.left != null)
      {
        node = findMin(node.left);
        return node; // if we find node.left as min no. we return its parent node "node"
      }
      else 
        return node.right;

    }
    /**
     * finds node containing the given account
     * @param d
     * @return
     */
  public BinaryTreeNode<Account> find ( Account d )
  {
    if (root == null)
      return null;
    else
      return find (d, root);    }
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
   * Recursively prints all account details
   */
 void getListOfAccounts()
 {  
  getListOfAccounts(root);
  System.out.println("Total Number of Accounts: "+size()+".\n");
 }
 void getListOfAccounts(BinaryTreeNode<Account> node) // uses preorder algorithm
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