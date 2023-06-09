
public class BinaryTreeNode<T>
{

   T data;
   BinaryTreeNode<T> left ;
   BinaryTreeNode<T> right;
   /**
    * Initializes the left and right nodes and Account data 
    * @param d
    * @param l
    * @param r
    */
   public BinaryTreeNode(T d, BinaryTreeNode<T> l, BinaryTreeNode<T> r){
   
      data =d;
      left = l;
      right = r;
      
   }
   /**
    * get method for left node
    * @return
    * return left node address
    */
   public BinaryTreeNode<T> getLeft(){
      return left;
   }
   /**
    * get method for right node
    * @return
    * return right node address
    */
    public BinaryTreeNode<T> getRight(){
   
      return right;
   }
   /**
    * get method for the Account data in the BST nodes
    * @return
    * return Account data address
    */

   public T getNodeData()
   {
      return data;
   }
   
}