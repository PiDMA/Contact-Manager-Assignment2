/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author josia
 */
public class Dictionary {

     WordInfo root;
     int count;

    public Dictionary() {
        root = null;
    }
         

    public void add(String word, String meaning) {
        WordInfo w = new WordInfo(word.toLowerCase(), meaning);
        if (root == null) {
            root = w;
            count++;
            System.out.println("Added");
            return;
        }
        WordInfo curr, parent;
        parent = curr = root;
        while (curr != null) {
            parent = curr;
            if (word.compareToIgnoreCase(curr.word) < 0) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if (word.compareToIgnoreCase(parent.word) < 0) {
            parent.left = w;
            count++;
            System.out.println("Added lesser");
        } else {
            parent.right = w;
            count++;
            System.out.println("Added greater");
        }
        

    }
              public int balanceHeight (WordInfo root)
   {
       if (root == null)
       {
           return 0;
       }
 
       // checking left subtree
       int leftSubtreeHeight = balanceHeight (root.left);
       if (leftSubtreeHeight == -1) return -1;
       // if left subtree is not balanced then the entire tree is also not balanced
 
       //checking right subtree
       int rightSubtreeHeight = balanceHeight (root.right);
       if (rightSubtreeHeight == -1) return -1;
       // if right subtree is not balanced then the entire          tree is also not balanced
 
       //checking the difference of left and right subtree for current node
       if (Math.abs(leftSubtreeHeight - rightSubtreeHeight) > 1)
       {
           return -1;
       }
       //if it is balanced then return the height
       return (Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1);
   }
        
 
     public void delete(String word){
         root = recursiveDelete(root,word);
    }
    
    private WordInfo recursiveDelete(WordInfo root, String word){
        if (root==null) return null; // case 0
        if (word.compareToIgnoreCase(root.word) < 0)
            root.left = recursiveDelete(root.left,word);
        else
             if (word.compareToIgnoreCase(root.word) > 0){
                 root.right = recursiveDelete(root.right,word);
             }else{
                 // found it!!!!!!!!
                 // if the node to be deleted has one child or no children
                 if (root.left==null) return root.right;
                 if (root.right==null) return root.left;
                 //case 3
                 WordInfo succ= root.right;
                 while(succ.left!=null){
                     succ=succ.left;
                 }
                 root.word=succ.word;
                 root.right= recursiveDelete(root.right,succ.word);
             }         
        return root;
    }
    public void inOrderTraversal(){
        inOrder(root);
        System.out.println("");
    }
    private void inOrder(WordInfo curr){
        if (curr!=null){
         inOrder(curr.left);
        System.out.print(curr.word.toUpperCase()+" "+"\n");
        inOrder(curr.right);
        }
       
    }
    public int getCount(){
        return count;
    }

}
