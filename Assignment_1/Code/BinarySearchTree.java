

class BinarySearchTree
{

   BinaryTreeNode<Account> root;
 
    public BinarySearchTree ()
    {
    root = null;
    }
    
    
    public int getHeight ()//return height of the binary tree
      {
      return getHeight (root);
      } 
    public int getHeight ( BinaryTreeNode<Account>node )
      {
      if (node == null)
        return -1;
      else
        return 1 + Math.max (
         getHeight (node.getLeft ()), getHeight (node.getRight ())
    );
      }
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
    public void insert(Account d)
    {
      if (root == null)
      {
          root = new BinaryTreeNode<Account>(d ,null, null);
          
      }
      else
      {
        insert(d, root);
        
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
    public void delete(Account d)
    {
        if (root.data == d)
        {
            root = null; // create a visitor function
        }
        else
            delete(d, root);
    }
    public BinaryTreeNode<Account> delete(Account d, BinaryTreeNode<Account> node)
    { 
      if (node == null)
        {return null;}

      int cmp = d.compareTo(node.data);
      if (cmp <0)

        return delete(d, node.left);
      else if (cmp > 0)

        return delete(d, node.right);

      else if ((node.left != null) && (node.right != null))

      {   node.data = findMin(node.right).data;
        node.right = removeMin(node.right);
      }
      else if (node.left != null)
        node.left = null;
          
    return node;   
    }
    public BinaryTreeNode<Account> findMin(BinaryTreeNode<Account> node)
    {
      if (node != null)
      {
        while (node.left != null)
          node = node.left;
        
      }
      return node;

    }
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
}