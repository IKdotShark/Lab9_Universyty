import java.util.*;

public class lab_9 {
    public static char[] InputArrOfChar(int n) {
        Scanner in = new Scanner(System.in);
        char[] array = new char[n];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            array[i] = in.next().charAt(0);
        }
        return array;
    }

    public static void num1(int n) {
        char[] syms = InputArrOfChar(n);
        int dd = 0;
        int dnd = 0;
        for (char sym : syms) {
            if (sym == ':') {
                dd++;
            } else if (sym == ';') {
                dnd++;
            }
        }
        System.out.println("Количество символов ':' в массиве: " + dd);
        System.out.println("Количество символов ';' в массиве: " + dnd);
    }

    public static boolean isbinstr(String numb) {
        for (char d : numb.toCharArray()) {
            if (d != '0' && d != '1') {
                return false;
            }
        }
        return true;
    }

    public static void num2() {
        Scanner in = new Scanner(System.in);
        String binstr;
        while (true) {
            System.out.print("Введите число в двоичной системе счисления: ");
            binstr = in.nextLine();
            if (isbinstr(binstr)) {
                break;
            } else {
                System.out.println("Неверный ввод! Число должно содержать только символы 0 и 1.");
            }
        }

        int decNum = Integer.parseInt(binstr, 2);
        String sepNum = Integer.toString(decNum, 7);

        char[] sepArr = sepNum.toCharArray();

        System.out.println("Число в семеричной системе счисления: " + sepNum);
        System.out.println("Массив символов семеричного числа:");
        for (char d : sepArr) {
            System.out.print(d + " ");
        }
    }

    public static int num3_a(char[] arr) {
        int Counter = 0;
        for (char c : arr) {
            if (Character.isUpperCase(c)) {
                Counter++;
            }
        }
        return Counter;
    }

    public static boolean num3_b(char[] arr) {
        boolean check = false;
        for (char c : arr) {
            if (Character.toLowerCase(c) == 'ю') {
                check = true;
                break;
            }
        }
        return check;

    }

    public static boolean num3_c(char[] arr) {
        boolean check = false;
        int Count = 0;
        for (char c : arr) {
            if (c == ',') {
                Count++;
                if (Count >= 2) {
                    check = true;
                    break;
                }
            }
        }
        return check;
    }

    public static boolean num3_d(char[] arr) {
        boolean check = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if ((Character.toLowerCase(arr[i]) == 'в' && Character.toLowerCase(arr[i + 1]) == 'о') ||
                    (Character.toLowerCase(arr[i]) == 'о' && Character.toLowerCase(arr[i + 1]) == 'в')) {
                check = true;
                break;
            }
        }
        return check;
    }

    public static boolean num3_e(char[] arr) {
        boolean check = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (Character.isDigit(arr[i]) && Character.isDigit(arr[i + 1]) && arr[i] == arr[i + 1]) {
                check = true;
                break;
            }
        }
        return check;
    }

    public static boolean num3_f(char[] arr) {
        boolean check = false;
        for (int i = 1; i < arr.length - 2; i++) {
            if (Character.isLetter(arr[i]) && Character.isLetter(arr[i + 1]) && Character.toLowerCase(arr[i]) == Character.toLowerCase(arr[i + 1]) && arr[i] != arr[i + 1] && arr[i] == '0' && arr[i + 1] == '0') {
                check = true;
                break;
            }
        }
        return check;
    }
    private static boolean isVal_num4(String expr) {
        return expr.matches("(\\d+\\*?)+");
    }

    private static double unknownepr_num4(String expr){
        String[] numb = expr.split("\\*");
        double result = Double.parseDouble(numb[0]);
        for (int i = 1; i < numb.length; i++) {
            result *= Double.parseDouble(numb[i]);
        }
        return result;
    }
    public static void num4(){
        //for example
        char[][] matrix = {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'}
        };
        ArrayList<String> incor = new ArrayList<>();
        int cor = 0;
        for (int r = 0; r < matrix.length; r++) {
            String expr = "";
            for (int col = 0; col < matrix[r].length; col++) {
                if (Character.isDigit(matrix[r][col])) {
                    expr += matrix[r][col];
                } else {
                    if (isVal_num4(expr)) {
                        double result = unknownepr_num4(expr);
                        if (result == Double.parseDouble(String.valueOf(matrix[r][col]))) {
                            cor++;
                        } else {
                            incor.add(expr + " = " + result);
                        }
                    }
                    expr = "";
                }
            }
            if (isVal_num4(expr)) {
                double result = unknownepr_num4(expr);
                if (result == Double.parseDouble(String.valueOf(matrix[r][matrix[r].length - 1]))) {
                    cor++;
                } else {
                    incor.add(expr + " = " + result);
                }
            }
        }
        for (int col = 0; col < matrix[0].length; col++) {
            String expr = "";
            for (int r = 0; r < matrix.length; r++) {
                if (Character.isDigit(matrix[r][col])) {
                    expr += matrix[r][col];
                } else {
                    if (isVal_num4(expr)) {
                        double result = unknownepr_num4(expr);
                        if (result == Double.parseDouble(String.valueOf(matrix[r][col]))) {
                            cor++;
                        } else {
                            incor.add(expr + " = " + result);
                        }
                    }
                    expr = "";
                }
            }
            if (isVal_num4(expr)) {
                double result = unknownepr_num4(expr);
                if (result == Double.parseDouble(String.valueOf(matrix[matrix.length - 1][col]))) {
                    cor++;
                } else {
                    incor.add(expr + " = " + result);
                }
            }
        }
        System.out.println("Выражения, вычисленные неправильно:");
        for (String expr : incor) {
            System.out.println(expr);
        }
        System.out.println("Количество правильно вычисленных выражений: " + cor);
    }
    public static String num5(String input, int index){
                Map<String, Integer> wordCount = new HashMap<>();
                String[] words = input.split(" ");
                for (String word : words) {
                    if (wordCount.containsKey(word)) {
                        wordCount.put(word, wordCount.get(word) + 1);
                    } else {
                        wordCount.put(word, 1);
                    }
                }
                StringBuilder result = new StringBuilder();
                for (String word : words) {
                    if (wordCount.get(word) >= index) {
                        result.append(word.toUpperCase()).append(" ");
                    } else {
                        result.append(word).append(" ");
                    }
                }
                String output = result.toString().trim();
                return output;
            }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Input number of ex");
        int num = in.nextInt();
        int n;
        switch (num) {
            case 1:
                System.out.println("Input length of array of char");
                n = in.nextInt();
                num1(n);
                break;
            case 2:
                num2();
                break;
            case 3:
                System.out.println("Input length of array of char");
                n = in.nextInt();
                char[] arr = InputArrOfChar(n);
                System.out.println("Количество латинских прописных букв: " + num3_a(arr));
                System.out.println("Буква ю " + (num3_b(arr) ? "входит" : "не входит") + " в последовательность");
                System.out.println("В массиве " + (num3_c(arr) ? "есть" : "нет") + " 2 и более запятых");
                System.out.println("В массиве " + (num3_d(arr) ? "есть" : "нет") + " сочетания символов во или ов");
                System.out.println("В массиве " + (num3_e(arr) ? "есть" : "нет") + " одинаковые подряд стоящие цифры");
                System.out.println("Существуют " + (num3_f(arr) ? "" : "не ") + "такие натуральные i и j, что 1 < i < j < n и s[i] и s[i+1] это одинаковые буквы отличающиеся регистром, а s[i], s[i+1] это '0'");
                break;
            case 4:
                num4();
                break;
            //remake it
            case 5:
                System.out.println("Input line: ");
                String input = in.nextLine();
                System.out.println("Input index: ");
                int id = in.nextInt();
                System.out.println("Результат: " + num5(input,id));
            case 6:

            case 7:

            case 8:

            case 9:

            case 10:

            case 11:
        }
    }
        }
