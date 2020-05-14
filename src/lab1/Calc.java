package lab1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {
    public static void main(String[] args) {
        String inputString;
        Pattern p = Pattern.compile("(-?\\d+\\.?\\d*)?\\s*(\\S)\\s*(-?\\d+\\.?\\d*)");
        Matcher m;
        double result = 0;
            do {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите выражение");
                if (scanner.hasNextLine()) {
                    inputString = scanner.nextLine();
                    m = p.matcher(inputString);
                    if (m.find()) {
                        result = calculate(inputString.split("\\s+"),
                                result);
                        System.out.println(result);
                    } else {
                        System.out.println("ошибка");
                    }
            }
        }  while(true);
        }


    private static double calculate(String[] split, double previousResult) {
        String operand;
        double num1;
        double num2;
        if (split.length == 3) {
            num1 = Double.parseDouble(split[0]);
            operand = split[1];
            num2 = Double.parseDouble(split[2]);
        } else if (split.length == 2) {
            num1 = previousResult;
            operand = split[0];
            num2 = Double.parseDouble(split[1]);
        } else {
            throw new Exception("Ошибка");
        }
                switch (operand) {
                    case "+":
                        return num1 + num2;
                    case "-":
                        return num1 - num2;
                    case "/":
                        return num1 / num2;
                    case "*":
                        return num1 * num2;
                    default:
                        throw new Exception("Ошибка");
                }
            }
        }
