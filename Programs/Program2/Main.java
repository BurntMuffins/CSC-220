/**
 * Name: Aidan Schaubhut
 * Date: 9/17/2023
 * Description: A program that uses the Person class to create a list of persons
 * in the People class. The Good Place is the best show ever
 */

/**
	Holds an array of Person objects
 */
class People {
	
	/** 
		The array of Person objects
	*/
	public Person[] group;
	private int index;
	
	/**
		Sets the size of the group array and index to 0
	*/
	public People(){
		group = new Person[5];
		index = 0;
	}
	
	/**
		Adds a person to the group array
		
		@param p This is the Person object that is being added
		@return boolean This returns if the person was added to the array or not
	*/
	public boolean addPerson(Person p){
		if (index < 5) {
			group[index] = p;
			index++;
			return true;
		} else{
			return false;
		}
	}
	
	/** 
		Finds a person that is in the group array by name
		
		@param name This is the name of the person to look for
		@return Person This returns the object of the person or null if not found
	*/
	public Person findPersonByName(String name){
		for(int i = 0; i < 5; i++){
			if (name == group[i].name){
				return group[i];
			}
		}
		return null;
	}
	
	/**
		Finds a person in the group array by age
		
		@param age This is the age of the person to look for
		@return Person This returns the object of the person or null if not found
	*/
	public Person findPersonByAge(int age){
		for (int i = 0; i < 5; i++){
			if(age == group[i].age){
				return group[i];
			}
		}
		return null;
	}
}

/** Person Class - Creates a person*/
// Copy over your Person class from assignment 1
class Person {

  /**
		The name of the Person
	*/
  public String name;
	/**
		The age of the person
	*/
  public int age;
	/**
		If the person is a student or not
	*/
  public boolean isStudent;

  /** 
		Takes the person's name and age. Sets the student status to false.
	
		@param name is used to name the person you are creating
		@param age is how old the person is
	*/
  public Person(String name, int age){
    this.name = name;
    this.age = age;
    this.isStudent = false;
  }

  /* Functions */

  /** 
		Increments the person's age by 1
	*/
  public void birthday(){
    this.age++;
  }

  /** 
		Formats a string to cleanly display information about the person
		
		@return String This returns a string containing information about the person
	*/
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


/** Main class - contains entry point */
// DO NOT MODIFY ANY CODE BELOW
public class Main {
  public static void main(String[] args) {
    // instantiate a new People object
    People people = new People();

    // add some Person objects
    boolean addedAllPeople = true;
    addedAllPeople &= people.addPerson(new Person("Eleanor",    38));
    addedAllPeople &= people.addPerson(new Person("Tahani",     33));
    addedAllPeople &= people.addPerson(new Person("Chidi",      39));
    addedAllPeople &= people.addPerson(new Person("Jason",      31));
    addedAllPeople &= people.addPerson(new Person("Michael", 20000));
    addedAllPeople &= people.addPerson(new Person("Janet",   10000));
    
    // create pointers to two Persons
    Person p1;
    Person p2;
    
    // initialize them with the results of our searches
    p1 = people.findPersonByName("Chidi");
    p2 = people.findPersonByAge(10000);
    
    // check if our results are correct
    Mysterious.checkAnswer(addedAllPeople, p1, p2);
  }
}
