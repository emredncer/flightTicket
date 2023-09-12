import java.util.Scanner;

public class FlightTicket {
    public static void main(String[] args) {
        infoChecker(); //yalnızca bu metodu çağırmam yeterli çünkü calculatePrice metodunu bu metod içerisinde çağırıyorum.
    }

    public static boolean infoChecker() {
        boolean ageCheck = false;
        boolean distanceCheck = false;
        boolean flightTypeCheck = false;
        //bu boolean ifadeleri tanımlama sebebim programın userdan input alırken
        //istediği inputun doğru aralıkta girilmediği sürece programın
        //diğer input verisini istemeyeceği bir yapı tasarlayacak olmam.
        int age = 0;
        double distance = 0;
        int flightType = 0;

        Scanner input = new Scanner(System.in);

        while (!distanceCheck) {  //distanceCheck true dönene kadar döngü tekrar input isteyecek
            System.out.print("Please enter flight distance in kilometers: ");
            distance = input.nextDouble();
            if (distance <= 0) {
                System.out.println("Please enter a valid distance!");
                distanceCheck = false;
            } else {
                distanceCheck = true;
            }
        }

        while (!ageCheck) {
            System.out.print("Please enter passengers age: ");
            age = input.nextInt();
            if (age <= 0 || age > 120) {
                System.out.println("Plase enter a valid age!");
                ageCheck = false;
            } else {
                ageCheck = true;
            }
        }

        while (!flightTypeCheck) {
            System.out.print("Please enter flight type. " +
                    "\n1-> One way ticket  " +
                    "\n2-> Return ticket\n");
            flightType = input.nextInt();
            if (flightType == 1 || flightType == 2) {
                flightTypeCheck = true;
            } else {
                System.out.println("Plase enter a valid flight type!");
                flightTypeCheck = false;
            }
        }

        if (flightTypeCheck && ageCheck && distanceCheck) { //alınan tüm inputlar istenilen şekilde mi diye kontrol sağladım
            calculatePrice(distance, age, flightType); //ve calculatePrice metodunu çağırdım
            return true;
        } else
            return false; //Scope içeriği tek satır olduğundan {} kullanmadım.

    }

    //FlightTicket classında bir nesne üretmeyeceğim için calculatePrice metodunu
    //static tanımladım.
    public static double calculatePrice(double distance, int age, int flightType) {
        double price = 0;
        double originalPrice = (distance * 0.10);

        if (age < 12) //Scope içeriği tek satır olduğundan {} kullanmadım.
            price = originalPrice * 0.5;

        else if (age >= 12 && age < 24)
            price = originalPrice * 0.9;

        else if (age > 65)
            price = originalPrice * 0.7;

        else
            price = originalPrice;

        //buradan sonra price değeri yaş indirimi uygulanmış price değeri olacak
        //yeni başka bir değişken oluşturmama gerek yok bu değeri kullanarak işlem yapacağım
        //ve tekrar bu değer üzerine yazacağım.

        if (flightType == 2)
            price = (price * 0.8) * 2;

        //else bloğu oluşturmama gerek yok çünkü
        //eğer tek yönlü bir uçuş olacaksa ekstra bir uçuş indirimi sözz konusu değil.
        //bi üstteki if bloğuna girilmemesi halinde yalnızca yaş indirimi uygulanmış price değeri kullanılacak.

        System.out.println("Total Amount: "+price);

        return price;
    }
}