package Programs.Program1;

/**
 * Name: Aidan Schaubhut
 * Date: 9/11/2013
 * Description: A program that uses classes tO create a person class and student subclass
 */
 
/** Creates the super class called Person with input of name and age */
class Person {

  /* Variables */

  private String name;
  private int age;
  public boolean isStudent;

  /* Constructors */

  // Override constructor
  public Person(String name, int age){
    this.name = name;
    this.age = age;
    this.isStudent = false;
  }

  /* Functions */

  // Adds 1 to the person's age
  public void birthday(){
    this.age++;
  }

  // Returns a string that can be used to tell the user the person's age and student status
  public String toString(){
    String result = "";

    result += this.name + " is ";
    if(this.isStudent){
      result += "a student ";
    } else {
      result += "not a student ";
    }

    result += "and is " + Integer.toString(this.age) + " years old";

    return result;
  }
}

/** Creates the subclass called Student with input name and age */
class Student extends Person {

  /* Constructors */

  public Student(String name, int age){
    super(name, age);
    this.isStudent = true;
  }
}

/** Main class - contains entry point */
public class Main {
  public static void main(String[] args) {

    Student student = new Student("Bob", 20);
    System.out.println(student);
    student.birthday();
    System.out.println(student);

    Person person = new Person("Rob", 22);
    System.out.println(person);

  }
}
