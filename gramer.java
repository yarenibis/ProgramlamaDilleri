package gramer;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		String özne[]= {"Ben", "Sen", "Hasan", "Nurşah", "Elif", "Abdulrezzak", "Şehribanu", "Zeynelabidin", "Naki"};
		String nesne[]= {"Bahçe", "Okul", "Park", "Sınıf", "Yarın", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma",
				"Cumartesi", "Pazar", "Merkez", "Ev", "Kitap", "Defter", "Güneş", "Beydağı"};
		String yüklem[]= {"Gitmek", "Gelmek", "Okumak", "Yazmak", "Yürümek", "Görmek"};
		
		Scanner input=new Scanner(System.in);
		System.out.println("Cumle yaziniz: ");
		
		//tokenize işlemi
		//klavyeden giriş alıp fazla boşlukları ayıkladık
		String cumle=input.nextLine().trim();
		//her bir kelimeyi diziye attık
		String tokenized[] = cumle.split("\\s+");
		
		
		
    //gramer kontrol- doğru sırayla mı yazılı?
		boolean CorrectOrder = false;
        for (int i = 0; i < tokenized.length - 2; i++) {
            if (isInArray(tokenized[i], özne) && isInArray(tokenized[i + 1], nesne) && isInArray(tokenized[i + 2], yüklem)) {
                CorrectOrder = true;
                break;
            }
        }
        // Sonucu yazdır
        if (CorrectOrder) {
            System.out.println("EVET");
        } else {
            System.out.println("HAYIR");
        }
	}


	//kelime dizide var mı?
	 public static boolean isInArray(String kelime, String[] dizi) {
	        for (String i : dizi) {
	            if (i.equals(kelime)) {
	                return true;
	            }
	        }
	        return false;
	  }

}
