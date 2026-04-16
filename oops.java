public class oops {
    public static void main(String[] args) {
        // Pen p1=new Pen();//created a pen object called p1
        // p1.setcolor("Blue");
        // System.out.println(p1.getcolor());
        // p1.settip(7);
        // System.out.println(p1.gettip());

        // Bankaccount myacc=new Bankaccount();
        // myacc.Username="Aman";
        // myacc.setpassword("Amanv");

        Student s1=new Student();
        s1.name="Surbhi";
        s1.roll=456;
        s1.password="abcd";
        s1.marks[0]=100;
        s1.marks[1]=90;
        s1.marks[2]=80;

        Student s2=new Student(s1);
        s2.password="xyz";

        // System.out.println(s2.name);
        // System.out.println(s1.name);

        for(int i=0;i<3;i++){
            System.out.println(s2.marks[i]);
        }

       
    }
    
}

// class Bankaccount{

//     public String Username;
//     private String password;

//     public void setpassword(String pwd){
//         password=pwd;
//     }

// }

// class Pen{
//     //prop +func

//     private String color;
//     private int tip;

//     String getcolor(){
//         return this.color;
//     }

//     int gettip(){
//         return this.tip;
//     }
//     void setcolor(String newColor){
//         this.color=newColor;
        
//     }
//     void settip(int newTip){
//         this.tip=newTip;
        
//     }


// }

class Student{
    String name; 
    int roll;
    String password;
    int marks[];
    Student(Student s1){
        marks=new int[3];
        this.name=s1.name;
        this.roll=s1.roll;
        this.marks=s1.marks;
        
    }

    Student(){
         marks=new int[3];
        System.out.println("Hi,i am a construtor");
    }
    Student(String name){//constructor
         marks=new int[3];
        this.name=name;
        System.out.println("Constructor is called");
    }
}