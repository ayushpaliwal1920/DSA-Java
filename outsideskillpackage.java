import javapackage.skill.App;

// ye vali java class thora complex hai isk liye package vala concept ana chahiye

public class outsideskillpackage {
  public static void main(String[] args) {
    App obj = new App();
    System.out.println("outside package , non-child class :  " + obj.str_1);

    App3 obj3 = new App3();
    obj3.printFromChildClass();
  }
}

// App3 is a child class of App 

class App3 extends App {
   void printFromChildClass(){
     App3 obj3 = new App3();
     System.out.println("within the child class : "  +  obj3.str_1);
   }
} 