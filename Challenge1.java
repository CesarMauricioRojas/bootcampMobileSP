import java.util.Scanner;

public class Challenge1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("2.a) Please input TipoA or TipoB: ");
        String text = scanner.nextLine();
        //Call the first method
        System.out.println(generateChain(text));

        //Creating an array of random numbers for exercise 2.b
        int[] randomNumbersList= new int[8];
        for (int i = 0; i < 8; i++) {
            randomNumbersList[i] = (int)( (Math.random()*10) + Math.round(Math.random())*(Math.random() * 100));
        }

        System.out.println("2.b) Please input ASC for ascending order or DESC descending order: ");
        text = scanner.nextLine();
        //Call the second method
        orderNumbers(randomNumbersList,text);
    }

    //Creating the first method
    public static String generateChain(String text){
        String chain = "";
        int number;
        if(text.equals("TipoA")){
            chain += "54";
            for (int i = 0; i < 8; i++) {
                number = (int)(Math.random() * 10);
                chain += Integer.toString(number);
            }
        }else if(text.equals("TipoB")){
            chain += "08";
            for (int i = 0; i < 8; i++) {
                number = (int)(Math.random() * 10);
                chain += Integer.toString(number);
            }
        }
        return chain;
    }

    //Creating the second method
    public static int[] orderNumbers(int[] numbersList, String order){
        String numberChain = "";

        if (order.equals("ASC")){
            for (int i = 0; i <numbersList.length-1 ; i++) {
                for (int j = 0; j < numbersList.length-1; j++) {
                    if (numbersList[j]>numbersList[j+1]){
                        int aux = numbersList[j];
                        numbersList[j] = numbersList[j+1];
                        numbersList[j+1] = aux;
                    }
                }
            }
        } else if(order.equals("DESC")){
            for (int i = 0; i <numbersList.length-1 ; i++) {
                for (int j = 0; j < numbersList.length-1; j++) {
                    if (numbersList[j]<numbersList[j+1]){
                        int aux = numbersList[j];
                        numbersList[j] = numbersList[j+1];
                        numbersList[j+1] = aux;
                    }
                }
            }
        }
        //to print the content of the ordered array without the last ,
        if ((order.equals("ASC") || (order.equals("DESC")))){
            for (int i = 0; i <numbersList.length-1 ; i++) {
                System.out.print(numbersList[i] + ",");
            }
            System.out.println(numbersList[numbersList.length-1]);
        }

        return numbersList;
    }
}