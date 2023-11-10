public class Main {
    public static void main(String[] args) {
        Dictionary<String, Integer> dict = new Dictionary<>();
        // Insert all the values
        dict.insert("Bob", 50);
        dict.insert("Bill", 120);
        dict.insert("Roger", 80);
        dict.insert("Kevin", 350);
        dict.insert("Jerry", 65);
        dict.insert("Liam", 500);
        
        // Search for the people
        System.out.println("Bob makes $" + dict.search("Bob") + "k a year");
        System.out.println("Bill makes $" + dict.search("Bill") + "k a year");
        System.out.println("Roger makes $" + dict.search("Roger") + "k a year");
        System.out.println("Kevin makes $" + dict.search("Kevin") + "k a year");
        System.out.println("Jerry makes $" + dict.search("Jerry") + "k a year");
        System.out.println("Liam makes $" + dict.search("Liam") + "k a year");
        System.out.println();

        // Uh oh people got fired
        dict.delete("Bob");
        dict.delete("Roger");
        dict.delete("Jerry");

        // Liam got a raise
        dict.insert("Liam", 650);

        String[] names = {"Bob", "Bill", "Roger", "Kevin", "Jerry", "Liam"};
        for (String name : names) {
            Integer pay = dict.search(name);
            if (pay == null){
                System.out.println(name + " got fired");
            } else {
                System.out.println(name + " makes $" + dict.search(name) + "k a year");
            }
        }
        
    }
}
