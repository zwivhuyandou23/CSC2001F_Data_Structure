
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
   BinaryTreeNode<T> getLeft(){
      return left;
   }
   BinaryTreeNode<T> getRight(){
   
      return right;
   }
}