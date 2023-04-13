
/* Will make it an inner class for binarytree later on*/
class BinaryTreeNode<T>
{

   T data;
   BinaryTreeNode<T> left ;
   BinaryTreeNode<T> right;
   
   BinaryTreeNode(T d, BinaryTreeNode<T> l, BinaryTreeNode<T> r){
   
      data =d;
      left = l;
      right = r;
      
   }
   /**
    * return left node address
    * @return
    */
   BinaryTreeNode<T> getLeft(){
      return left;
   }
   /**
    * return right node address
    * @return
    */
   BinaryTreeNode<T> getRight(){
   
      return right;
   }

   T getNodeData()
   {
      return data;
   }
   
}