import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// BaseEntity
abstract class BaseEntity {
    private int id;
    private String name;

    public BaseEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void BilgiGoster();
}

// Musteri
class Musteri extends BaseEntity {
    private String email;

    public Musteri(int id, String name, String email) {
        super(id, name);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void BilgiGoster() {
        System.out.println("Müşteri ID: " + getId() + ", İsim: " + getName() + ", Email: " + email);
    }
}

// Film
class Film {
    private String ad;
    private int sure;
    private String tur;

    public Film(String ad, int sure, String tur) {
        this.ad = ad;
        this.sure = sure;
        this.tur = tur;
    }

    public String getAd() {
        return ad;
    }

    public int getSure() {
        return sure;
    }

    public String getTur() {
        return tur;
    }

    public void BilgiGoster() {
        System.out.println("Film Adı: " + ad + ", Süre: " + sure + " dakika, Tür: " + tur);
    }
}

// Salon
class Salon extends BaseEntity {
    private Film film;
    private List<Musteri> musteriler;

    public Salon(int id, String name, Film film) {
        super(id, name);
        this.film = film;
        this.musteriler = new ArrayList<>();
    }

    public Film getFilm() {
        return film;
    }

    public List<Musteri> getMusteriler() {
        return musteriler;
    }

    public void MusteriEkle(Musteri musteri) {
        musteriler.add(musteri);
    }

    @Override
    public void BilgiGoster() {
        System.out.println("Salon ID: " + getId() + ", Adı: " + getName());
        System.out.println("Gösterimdeki Film: " + film.getAd());
        System.out.println("Kayıtlı Müşteriler:");
        for (Musteri musteri : musteriler) {
            System.out.println("- " + musteri.getName());
        }
    }
}

// IBiletSistemi
interface IBiletSistemi {
    void MusteriKaydet(Musteri musteri);
    void SalonGoruntule();
}

// BiletSistemi
class BiletSistemi implements IBiletSistemi {
    private List<Salon> salonlar;
    private List<Musteri> musteriler;

    public BiletSistemi() {
        this.salonlar = new ArrayList<>();
        this.musteriler = new ArrayList<>();
    }

    public void SalonEkle(Salon salon) {
        salonlar.add(salon);
    }

    @Override
    public void MusteriKaydet(Musteri musteri) {
        musteriler.add(musteri);
    }

    @Override
    public void SalonGoruntule() {
        for (Salon salon : salonlar) {
            salon.BilgiGoster();
        }
    }

    public void MusteriGoruntule(int salonId) {
        for (Salon salon : salonlar) {
            if (salon.getId() == salonId) {
                salon.BilgiGoster();
                return;
            }
        }
        System.out.println("Salon bulunamadı!");
    }
}

// Main
public class Main {
    public static void main(String[] args) {
        BiletSistemi sistem = new BiletSistemi();

        Film film1 = new Film("Inception", 148, "Bilim Kurgu");
        Film film2 = new Film("Titanic", 195, "Romantik");

        Salon salon1 = new Salon(1, "Salon 1", film1);
        Salon salon2 = new Salon(2, "Salon 2", film2);

        sistem.SalonEkle(salon1);
        sistem.SalonEkle(salon2);

        Musteri musteri1 = new Musteri(1, "Ali Veli", "ali@example.com");
        Musteri musteri2 = new Musteri(2, "Ayşe Kaya", "ayse@example.com");

        salon1.MusteriEkle(musteri1);
        salon2.MusteriEkle(musteri2);

        Scanner scanner = new Scanner(System.in);
        int secim;
        do {
            System.out.println("\n=== Sinema Sistemi ===");
            System.out.println("1. Salonları Görüntüle");
            System.out.println("2. Müşteri Görüntüle");
            System.out.println("3. Çıkış");
            System.out.print("Seçiminiz: ");
            secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    sistem.SalonGoruntule();
                    break;
                case 2:
                    System.out.print("Salon ID giriniz: ");
                    int salonId = scanner.nextInt();
                    sistem.MusteriGoruntule(salonId);
                    break;
                case 3:
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        } while (secim != 3);

        scanner.close();
    }
}
