public class stringbuider {
    //we use string buider because it is mutable unlike strings
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder("");
        for(char ch='a';ch<='z';ch++){
            sb.append(ch);

        }
        System.out.println(sb);
        //we can write same codes for strings with string builder also
        
    }
}

//more codes of string buider is in the strings.java file 