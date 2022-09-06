package MISC;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        while(true)
        {
            showIntro();
            System.out.println("\nenter the text or \"exit\" to exit from program: ");

            String text = input.nextLine().trim();

            if(text.toLowerCase().equals("exit"))
            {
                System.out.println("_-_-_-Thank you for using our program\nHave a nice day-_-_-_");
                return;
            }

            Huffman obj = new Huffman();
            String data  = obj.encode(text);
            System.out.println(data);

            System.out.println("decoded data :"+obj.decode(data));
        }
    }
    public static void showIntro()
    {
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("*-*-*-*- HUFFMAN BACK N FORTH  by Rahul Gilhotra -*-*-*-*");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    }
}
