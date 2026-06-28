public class Trie {

    static class Node{
        Node children[]=new Node[26];
        boolean eow=false;
        //freq variable only for prefix probblem
        int freq;

        public Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            freq=1;

        }
    }
     


    public static Node root=new Node();

    public static void insert(String word){//O(L) l=length of word
        Node curr=root;
        for(int level=0;level<word.length();level++){
            int idx=word.charAt(level)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            else{
                curr.children[idx].freq++;
            }
            curr=curr.children[idx];
                 
            }

        curr.eow=true;

        
    }

    public static boolean search(String key){
        Node curr=root;
        for(int level=0;level<key.length();level++){
            int idx=key.charAt(level)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
                 
            }

        return curr.eow==true;

    }

    public static boolean wordBreak(String key){
        if(key.length()==0){
            return true;
        }
        for(int i=1;i<=key.length();i++){
            //substring
            if(search(key.substring(0,i)) && wordBreak(key.substring(i))){
                return true;
            }

        }
        return false;
    }

    public static void FindPrefix(Node root,String ans){
       if(root==null){
        return;
       }

       if(root.freq==1){
        System.out.println(ans);
        return;
       }
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                FindPrefix(root.children[i], ans+(char)(i+'a'));
            }
        }

    }

    public static boolean startsWith(String key){
        Node curr=root;
        for(int i=0;i<key.length();i++){
            int idx=key.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;

            }
            curr=curr.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        //Insert
        // String words[]={"the","a","there","their","any","thee"};
        // for(int i=0;i<words.length;i++){
        //     insert(words[i]);

        // }

        // System.out.println(search("thereeeee"));


        //Word Break Problem
        // String arr[]={"i","like","sam","samsung","mobile","ice"};
        // for(int i=0;i<arr.length;i++){
        //     insert(arr[i]);

        // }

        // String key="ilikesamsung";

        // System.out.println(wordBreak(key));


        //Prefix Problem
        //we will add a new variable inside node class to track frequecny
        //wherever the freq starts to come 1 that whole string till there will be the answer
        // String arr[]={"zebra","dog","duck","dove"};
        // for(int i=0;i<arr.length;i++){
        //     insert(arr[i]);
        // }

        // root.freq=-1;

        // FindPrefix(root,"");


        //Starts with prefix problem
        String words[]={"apple","app","mango","man","work"};

        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }

        System.out.println(startsWith("m"));


    }
}
//In trie Every Node contains the data of its childrens