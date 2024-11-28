Sinema Bilet Sistemi

Bu proje, basit bir Sinema Bilet Sistemi simülasyonudur. Java programlama dili kullanılarak, sinema salonlarının ve müşterilerin yönetilmesini sağlayan bir yapı geliştirilmiştir. Kod, salon ekleme, müşteri kaydetme, salon bilgilerini görüntüleme gibi temel işlevleri yerine getirir.


Özellikler

Film Yönetimi
Sistem, her salon için gösterimde olan bir film bilgisi tutar (adı, süresi, türü).

Müşteri Yönetimi
Her müşteri, sistemde bir ID, isim ve e-posta adresi ile temsil edilir ve belirli bir salona atanabilir.

Salon Yönetimi
Sinema salonları, ID ve ad bilgisiyle oluşturulur. Her salona bir film atanır ve kayıtlı müşteriler görüntülenebilir.

Kullanıcı Arayüzü
Basit bir metin tabanlı menü üzerinden salonları görüntüleme ve müşterileri sorgulama işlemleri yapılabilir.


Kullanılan Yapılar

Abstract Class:
BaseEntity sınıfı, Musteri ve Salon sınıfları için temel özellikleri sağlar.

Interface:
IBiletSistemi arayüzü, sistemin temel işlevlerini tanımlar.

Inheritance (Kalıtım):
Musteri ve Salon, BaseEntity sınıfını miras alır.

Polymorphism (Çok Biçimlilik):
BilgiGoster() metodu, her sınıfta özelleştirilmiştir.


