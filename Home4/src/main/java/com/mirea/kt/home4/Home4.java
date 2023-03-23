/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mirea.kt.home4;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author afana
 */
public class Home4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Работу выполнила Афанасьева Злата, РИБО-01-21, Вариант №2" + "\n");
        
        String Str = "";
        String str = "";
        System.out.println("Введите путь файла:");
        String path = scan.next();
        
        try (FileReader reader = new FileReader(path)){
            int c;
            while ((c = reader.read()) != -1){
                if (c != 10 && c != 13){
                    str = (char)c + str;
                }
                if (c == 10 || c == 13){
                    if (c == 10){
                        Str = Str + str + "\n";
                    }
                    Str = Str + str;
                    str = "";
                }
            }
            Str = Str + str;
            System.out.println(Str);
        }
        catch (IOException ex){
            System.out.println("При чтении из файла возникла ошибка: " + ex.getMessage());
        }
        try {
            System.out.println("\n");
            path = path.substring(0, path.lastIndexOf("\\")) + "\\Final.txt";
            FileUtils.writeStringToFile(path, Str);
            System.out.println("Результат находится в файле по пути: " + path);
        }
        catch (IOException ex){
            System.out.println("При записи в файл возникла ошибка: " + ex.getMessage());
        }
    }
}