package bagli_sirala;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Bagli_Sirala {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = null;
        Pair[] pairs = new Pair[100]; 
        Pair[] pairs_copy = new Pair[100];
        int count = 0;

        try {
            System.out.print("Dosya adını girin: ");
            String dosyaAdi = scanner.nextLine();

            reader = new BufferedReader(new FileReader(dosyaAdi));
            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line.trim());
                int address = count; // Sayaç değeri adres olarak kullanıldı
                pairs[count] = new Pair(number, address);
                pairs_copy[count] = new Pair(number, address);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            scanner.close(); // Scanner kapatılıyor
        }

       //sayıları sıralama
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (pairs[j].number > pairs[j + 1].number) {
                    // Swap işlemi
                    Pair temp = pairs[j];
                    pairs[j] = pairs[j + 1];
                    pairs[j + 1] = temp;
                }
            }
        }

        // ekrana yazdırma işlemi
        System.out.println("Sıralı Sıra:");
        for (int i = 0; i < count; i++) {
            System.out.println(pairs_copy[i].number+" "+ pairs_copy[i].address+ "\t\t" + pairs[i].number+" "+pairs[i].address);
        }
    }

    static class Pair {
        int number;
        int address;

        public Pair(int number, int address) {
            this.number = number;
            this.address = address;
        }
    }
}


