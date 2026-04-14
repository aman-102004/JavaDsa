public class oops {
    public static void main(String[] args) {
        Pen p1=new Pen();//created a pen object called p1
        p1.setcolor("Blue");
        System.out.println(p1.getcolor());
        p1.settip(7);
        System.out.println(p1.gettip());

        // Bankaccount myacc=new Bankaccount();
        // myacc.Username="Aman";
        // myacc.setpassword("Amanv");
        
    }
    
}

// class Bankaccount{

//     public String Username;
//     private String password;

//     public void setpassword(String pwd){
//         password=pwd;
//     }

// }

class Pen{
    //prop +func

    private String color;
    private int tip;

    String getcolor(){
        return this.color;
    }

    int gettip(){
        return this.tip;
    }
    void setcolor(String newColor){
        this.color=newColor;
        
    }
    void settip(int newTip){
        this.tip=newTip;
        
    }


}