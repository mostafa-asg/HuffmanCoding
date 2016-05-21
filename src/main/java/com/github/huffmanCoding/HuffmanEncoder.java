package com.github.huffmanCoding;

import com.github.huffmanCoding.tree.TreeNode;

import java.util.*;

/**
 * @author Mostafa Asgari
 * Email : mostafa.asg@gmail.com
 * website https://bigdatacode.wordpress.com/
 * @since 5/21/16
 */
public class HuffmanEncoder {

    private String text;

    public HuffmanEncoder(String text) {
        this.text = text;
    }

    /**
     * count each character in a given String
     *
     * @param text
     * @return
     */
    private Map<Character,Integer> countCharacters(String text) {

        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {

            Character ch = text.charAt(i);
            Integer count = map.get( ch );

            if( count == null )
                map.put( ch , 1 );
            else
                map.put( ch , count+1 );

        }

        return map;
    }

    /**
     * create leaf nodes which will be added to tree
     *
     * @param charMap
     * @return
     */
    private List<TreeNode<Integer>> createFrequencyNodes(Map<Character,Integer> charMap ) {

        List<TreeNode<Integer>> result = new ArrayList<>(charMap.size());

        Set<Map.Entry<Character, Integer>> entries = charMap.entrySet();

        for( Map.Entry<Character, Integer> entry : entries ){
            result.add( new TreeNode<Integer>(entry.getKey().toString(),entry.getValue()) );
        }

        return result;
    }

    /**
     * add newNode to sorted list in a way that list remains sorted
     *
     * @param sortedList
     * @param newNode
     */
    private void addToSortedList( List<TreeNode<Integer>> sortedList , TreeNode<Integer> newNode){

        int index = 0;

        while ( index < sortedList.size() && newNode.getData() > sortedList.get(index).getData()  ){
            index++;
        }

        sortedList.add( index , newNode );
    }

    /**
     * sort the list by character frequencies
     * @param nodes
     */
    private void sort( List<TreeNode<Integer>> nodes ) {

        nodes.sort(new Comparator<TreeNode<Integer>>() {
            @Override
            public int compare(TreeNode<Integer> left, TreeNode<Integer> right) {
                return left.getData().compareTo( right.getData() );
            }
        });

    }

    /**
     * get huffman code for every character
     * @return
     */
    public Map<Character,byte[]> getCharacterEncoding(){

        Map<Character, Integer> charMap = countCharacters(this.text);
        List<TreeNode<Integer>> frequencyNodes = createFrequencyNodes(charMap);
        sort(frequencyNodes);

        while (frequencyNodes.size() > 1){

            TreeNode<Integer> node1 = frequencyNodes.get(0);
            TreeNode<Integer> node2 = frequencyNodes.get(1);

            TreeNode<Integer> parentNode = new TreeNode<Integer>("[" + node1.getId() + "|" + node2.getId() + "]" ,
                                                node1.getData()+node2.getData(),node2,node1);

            frequencyNodes.remove(0);
            frequencyNodes.remove(0);
            addToSortedList( frequencyNodes , parentNode );
        }

        TreeNode<Integer> root = frequencyNodes.get(0);

        return traverse(root);
    }

    private byte[] zeroOrOneToByteArray(String zeroOrOne) {

        byte[] buffer = new byte[zeroOrOne.length()];

        for (int i = 0; i < zeroOrOne.length() ; i++) {

            switch (zeroOrOne.charAt(i)){
                case '0' :
                    buffer[i] = 0;
                    break;
                case '1' :
                    buffer[i] = 1;
                    break;
                default:
                    throw new RuntimeException("invalid character");
            }
        }

        return buffer;
    }

    /**
     * traverse the tree
     * @param node
     * @param map
     * @param path
     * @param <T>
     */
    private <T> void traverse(TreeNode<T> node , Map<Character,byte[]> map , String path) {

        if( node == null )
            return;

        if( node.isLeaf() ){
            map.put( node.getId().charAt(0) , zeroOrOneToByteArray(path) );
        }
        else{

            traverse( node.getLeft() , map , path + "0" );
            traverse( node.getRight() , map , path + "1" );
        }
    }

    /**
     * traverse the tree
     * @param root
     * @param <T>
     * @return
     */
    private <T> Map<Character,byte[]> traverse(TreeNode<T> root){

        Map<Character,byte[]> result = new HashMap<>();
        traverse( root,result , new String() );
        return result;
    }

}
