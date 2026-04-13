public class oops {
    public static void main(String[] args) {
        Pen p1=new Pen();//created a pen object called p1
        p1.setcolor("Blue");
        System.out.println(p1.color);
    }
    
}

class Pen{
    //prop +func

    String color;
    int tip;

    void setcolor(String newColor){
        color=newColor;
        
    }
    void settip(int newTip){
        tip=newTip;
        
    }


}