package com.github.huffmanCoding.tree;

/**
 * @author Mostafa Asgari
 * Email : mostafa.asg@gmail.com
 * website https://bigdatacode.wordpress.com/
 * @since 5/21/16
 */
public class TreeNode<T> {

    private T data;
    private String id;

    private TreeNode left;
    private TreeNode right;

    public TreeNode(String id) {
        this(id,null);
    }

    public TreeNode(String id,T data) {
        this(id,data,null,null);
    }

    public TreeNode(String id,T data , TreeNode left, TreeNode right) {
        this.id = id;
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf(){
        if (this.getLeft() == null && this.getRight()==null)
            return true;
        else
            return false;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object obj) {
        if( obj == null )
            return false;

        if( ! (obj instanceof TreeNode) )
            return false;

        return id.equalsIgnoreCase( ((TreeNode)obj).getId() );
    }

    @Override
    public String toString() {
        return "(" + this.id + "," + this.getData().toString() + ")";
    }
}
