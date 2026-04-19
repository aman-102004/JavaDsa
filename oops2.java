// public class oops2 {
//     // public static void main(String[] args) {
//     //     horse h=new horse();
//     //     h.eat();
//     //     h.walk();
//     //     System.out.println(h.color);


//     //     mustang m1=new mustang();

//     // }
    
// }

// abstract class Animal{//we cannot create objects for an abstract class
//     String color;

//     Animal(){
//         System.out.println("Animal constructor is called");
//         color="brown";//this will be used to for naming the color of each subclas to by default brown we can change them later by creating change color function
//     }
    
//     void eat(){

//         System.out.println("animal eats");
//     }

//     abstract void walk();//in abstract classes we dont need to define functions like we do for non abstract function its subclass will define it themselves 
// }

// class horse extends Animal{//it becomes compulsory for this class to implement that walk abstract method of parent class othewise it will throw an error
    
//     horse(){
//         System.out.println("horse constructor is called");
//     }
//     void changecolor(){

//         color="dark brown";
//     }
//     void walk(){
//         System.out.println("Walks on 4 legs");
//     }
// }

// class mustang extends horse{
//     mustang(){
//         System.out.println("Mustang constructor is called");
//     }
// }

// //constructors are called in a hierarchial order from base class to child class then next class





//Interfaces
//interfaces are blueprint of a class 
//just lke classes are blueprint of objects
//interface(blueprint of class)->class(blueprint of object)->objects    
//interfaces always allow 100% abstraction which abstract classes fail to
//interfaces are used for multiple inheritance and total inheritance

public class oops2 {
    public static void main(String[] args) {
        beer b=new beer();
        b.eatnonveg();
        b.eatveg();
        
    }
    
}

// interface Chessplayer{
//     void moves();
// }


// class Queen implements Chessplayer{
//     public void moves(){
//         System.out.println("up,down,left,right,diagonal(in all directions)");
//     }
// }

// class Rook implements Chessplayer{
//     public void moves(){
//         System.out.println("left right all directions");

//     }

// }

//multiple inheritance implementation

interface carivore{
    void eatnonveg();
}

interface herbivore{
    void eatveg();
}

class beer implements herbivore,carivore{
    public void eatnonveg(){
        System.out.println("Yeah i can eat it");

    }

    public void eatveg(){
        System.out.println("yeah i eat veg" );
    }
}