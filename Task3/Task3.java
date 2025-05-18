package Task3;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Task 1");
        MyHashTable table1 = new MyHashTable(13);
        table1.put("CS2025123", "강민수");
        table1.put("ME2024567", "이재훈");
        table1.put("EE2025345", "Park HyeonWoo");
        table1.put("CS2025124", "Choi Yuna");
        table1.put("CE2025888", "한성준");
        table1.put("IS2025789", "이어진");
        table1.put("BA2025001", "Park DongHyuk");
        table1.put("PH2025122", "양시경");
        table1.put("MA2025777", "Choi JinSoo");
        table1.put("CS2025999", "김도형");
        System.out.println("Current size: " + table1.size());
        table1.printTable();

        System.out.println("\nTask 2");
        MyHashTable table2 = new MyHashTable(13, 0.9f);
        table2.put("CS2025123", "강민수");
        table2.put("ME2024567", "이재훈");
        table2.put("EE2025345", "Park HyeonWoo");
        table2.put("CS2025124", "Choi Yuna");
        table2.put("CE2025888", "한성준");
        table2.put("IS2025789", "이어진");
        table2.put("BA2025001", "Park DongHyuk");
        table2.put("PH2025122", "양시경");
        table2.put("MA2025777", "Choi JinSoo");
        table2.put("CS2025999", "김도형");
        table2.put("ME2025002", "Lee Suji");
        table2.put("CS2025111", "정호균");
        table2.put("CE2025444", "최선민");
        table2.put("IS2025333", "김형언");
        table2.put("MA2025771", "Park JiWon");

        System.out.println("Current size: " + table2.size());
        table2.printTable();
    }
}
