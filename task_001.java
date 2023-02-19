//                               Домашнее задание к семинару 2

// ЗАДАЧА: Реализовать функцию возведения числа а в степень b. a, b ∈ Z. Сводя количество выполняемых действий к минимуму. 
// Пример 1: а = 3, b = 2, ответ: 9 
// Пример 2: а = 2, b = -2, ответ: 0.25
// Пример 3: а = 3, b = 0, ответ: 1
// Пример 4: а = 0, b = 0, ответ: не определено

// Пример 5
// входные данные находятся в файле input.txt в виде
// b 3
// a 10
// Результат нужно сохранить в файле output.txt
// 1000

// нельзя использовать math.pow


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.io.PrintWriter; 

public class task_001 {
    public static void main(String[] args) throws FileNotFoundException { 
        int[] array = readFile();
        int a = array[0];
        int b = array[1];
        if(a == 0 && b == 0) writeFile("Не определено"); 
        else if(b < 0) writeFile(negativPow(a, b)); 
        else writeFile(positivPow(a, b)); 
    }

    // Метод считывания файла:
    public static int[] readFile() throws FileNotFoundException {
        File file = new File("input.txt"); 
        Scanner scanner = new Scanner(file); 
        String line = scanner.nextLine(); 
        int[] intArray = new int[2];
        String[] stringArray = line.split(" "); 
        if(stringArray[0] == "a"){
            intArray[0] = Integer.parseInt(stringArray[1]); 
            stringArray = scanner.nextLine().split(" ");
            intArray[1] = Integer.parseInt(stringArray[1]); 
        }
        else {
            intArray[1] = Integer.parseInt(stringArray[1]);
            stringArray = scanner.nextLine().split(" ");
            intArray[0] = Integer.parseInt(stringArray[1]);
        }
        
        scanner.close(); 
        return intArray;
    }

    
    public static String positivPow(int a, int b) {
        int temp = 1;
        String result = "";
        for(int i = 0; i < b; i++){
            temp *= a;
        }
        result = String.valueOf(temp);
        return result;
    }

   
    public static String negativPow(int a, int b) {
        double temp = 1;
        String result = "";
        for(int i = 0; i < b * -1; i++){
            temp *= a; 
        }
        result = String.valueOf(1/temp);
        return result;
    }

 
    public static void writeFile(String string) throws FileNotFoundException {
        File file = new File("output.txt");
        PrintWriter pw = new PrintWriter(file); 
        pw.println(string); 
        pw.close(); 
    }
}