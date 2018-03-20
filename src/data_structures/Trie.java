package data_structures;

import java.util.HashMap;

public class Trie {

    private Node root;


    public Trie(){
        root = new Node('*');
    }

    public void addString(String word){
        Node currentNode = root;
        for(Character ch: word.toCharArray()){
            currentNode.addChild(ch, new Node(ch));
            currentNode = currentNode.getChild(ch);
        }
        currentNode.addChild('*', new Node('*'));
        System.out.println(String.format("Word %s added!", word));
    }

    public boolean isPrefix(String word){
        Node currentNode = root;
        for(Character ch: word.toCharArray()){
            if(currentNode.hasChild(ch))
                currentNode = currentNode.getChild(ch);
            else
                return false;
        }
        return true;
    }

    public boolean containsWord(String word){
        Node currentNode = root;
        for(Character ch: word.toCharArray()){
            if(currentNode.hasChild(ch))
                currentNode = currentNode.getChild(ch);
            else
                return false;
        }
        return currentNode.isCompleteWord();
    }

    public static class Node {
        private HashMap<Character, Node> children;
        private boolean isCompleteWord;
        private Character nodeChar;

        public Node(Character ch){
            nodeChar = ch;
            children = new HashMap<Character, Node>();
        }

        public Node getChild(Character ch){ return children.get(ch); }
        public void addChild(Character ch, Node node){ children.putIfAbsent(ch,node); }
        public boolean isCompleteWord(){ return children.containsKey('*'); }
        public boolean hasChild(Character ch){ return children.containsKey(ch); }


    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addString("Chill");
        trie.addString("Children");
        trie.addString("Chilly");
        System.out.println(trie.containsWord("Not in trie"));
        System.out.println(trie.containsWord("Children"));
        System.out.println(trie.isPrefix("Not in trie"));
        System.out.println(trie.isPrefix("Chi"));


    }


}


