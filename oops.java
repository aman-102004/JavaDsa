public class oops {
//     public static void main(String[] args) {
//         // Pen p1=new Pen();//created a pen object called p1
//         // p1.setcolor("Blue");
//         // System.out.println(p1.getcolor());
//         // p1.settip(7);
//         // System.out.println(p1.gettip());

//         // Bankaccount myacc=new Bankaccount();
//         // myacc.Username="Aman";
//         // myacc.setpassword("Amanv");

//         Student s1=new Student();
//         s1.name="Surbhi";
//         s1.roll=456;
//         s1.password="abcd";
//         s1.marks[0]=100;
//         s1.marks[1]=90;
//         s1.marks[2]=80;

//         Student s2=new Student(s1);
//         s2.password="xyz";

//         s1.marks[2]=100;
//         // System.out.println(s2.name);
//         // System.out.println(s1.name);

//         for(int i=0;i<3;i++){
//             System.out.println(s2.marks[i]);
//         }

       
//     }
    
// }

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

// class Student{
//     String name; 
//     int roll;
//     String password;
//     int marks[];

    //shallow copy constructor
    // Student(Student s1){
    //     marks=new int[3];
    //     this.name=s1.name;
    //     this.roll=s1.roll;
    //     this.marks=s1.marks;
        
    // }

    //deep copy constructor
    
    // Student(Student s1){
    //     marks=new int[3];
    //     this.name=s1.name;
    //     this.roll=s1.roll;
    //     for(int i=0;i<marks.length;i++){
    //     this.marks[i]=s1.marks[i];
    //    }

    // }


    //non parameterized constructor
    // Student(){
    //      marks=new int[3];
    //     System.out.println("Hi,i am a construtor");
    // }

    // //parameterized constructor
    // Student(String name){//constructor
    //      marks=new int[3];
    //     this.name=name;
    //     System.out.println("Constructor is called");
    // }



public static void main(String[] args) {
    // fish shark=new fish();
    // shark.eat();

    // Dog dobby=new Dog();
    // dobby.eat();
    // dobby.legs=4;
    // System.out.println(dobby.legs);

    calculator calc=new calculator();
    
    System.out.println(calc.sum(1, 2));
    System.out.println(calc.sum((float)0.1,(float)1.1));
    System.out.println(calc.sum(1,2,3));

    deer d =new deer();
    d.eat();
}


//Base Class

}
// class Animal{
    
//     String color;
//     void eat(){
//         System.out.println("eats");

//     }

//     void breathe(){
//         System.out.println("breathes");
//     }

// }

// class Mammals extends Animal{
//     int legs;

// }

// class Dog extends Mammals{
//     String breed;
// }

class animal{
    void eat(){
        System.out.println("eats everything");
    }

}

class deer extends animal{
    void eat(){
        System.out.println("eats grass");
    }
}

class calculator{
    int sum(int a,int b){
        return a+b;
    }
    float sum(float a,float b){
        return a+b;
    }

    int sum(int a ,int b,int c){
        return a+b+c;
    }
}

//dervived class

// class fish extends Animal{
//     int fins;

//     void swim(){
//         System.out.println("Swims in water");
//     }
// }