package org.example;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();
        addContact(phoneBook, "Иванов", "8(907)906-43-42");
        addContact(phoneBook, "Петров", "+7(905)678-7-78");
        addContact(phoneBook, "Сидоров", "+7(495)616-03-03");
        addContact(phoneBook, "Петров", "+764(341)002-78-90");
        addContact(phoneBook, "Иванов", "8(499)978-00-00");
        addContact(phoneBook, "Петров", "+3(594)102-34-21");
        addContact(phoneBook, "Макеев", "+7(905)678-7-78");
        sortingPhoneBook(phoneBook);
    }
    public static void addContact(HashMap<String, List<String>> phoneBook, String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            List<String> phoneNumbers = phoneBook.get(name); // Проверка сходства/добавление нового телефона в список с имеющемся именем
            phoneNumbers.add(phoneNumber);
        }
        else {
            List<String> phoneNumbers = new ArrayList<>(); // Новый контакт и телефон
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }
    public static void sortingPhoneBook(HashMap<String, List<String>> phoneBook) { // В убывающем порядке кол-во телефонов
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, List<String>>>() {
            @Override
            public int compare(Map.Entry<String, List<String>> entry1, Map.Entry<String, List<String>> entry2) {
                return Integer.compare(entry2.getValue().size(), entry1.getValue().size());
            }
        });
        for (Map.Entry<String, List<String>> entry : entries) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            StringBuilder sb = new StringBuilder();
            for(String number : phoneNumbers) {
                sb.append(number).append("; ");
            }
            sb.setLength(sb.length() - 2);
            System.out.println(name + ": " + sb.toString()+ ".");
        }
    }
}