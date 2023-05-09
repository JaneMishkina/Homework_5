// //Реализуйте структуру телефонной книги с помощью HashMap,
// // учитывая, что 1 человек может иметь несколько телефонов.

import java.util.*;


public class Example_1 {
    static Map<String, List<Integer>> phonebook = new HashMap<>();
    private static void addPhonebook(String s, Integer i){
        List<Integer> tempArr = phonebook.get(s);
        if (tempArr == null) tempArr = new ArrayList<>();
        tempArr.add(i);
        phonebook.put(s, tempArr);
    }

    private static void addPhonebook(String s, List<Integer> i){
        List<Integer> tempArr = phonebook.get(s);
        if (tempArr == null) tempArr = new ArrayList<>();
        tempArr.addAll(i);
        phonebook.put(s, tempArr);
    }
    public static void main(String[] args) {
        addPhonebook("Иванов", Arrays.asList(123, 456));
        addPhonebook("Иванов", 789);
        addPhonebook("Петров", 456);
        addPhonebook("Кошкина", Arrays.asList(456, 4455788));
        addPhonebook("Сидоров", Arrays.asList(123, 456, 789));
        addPhonebook("Сидоров", 917);

        System.out.println(phonebook);
    }
}