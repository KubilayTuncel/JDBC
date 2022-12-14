public class StringBuilder {
    /*
    StringBuilder Sınıfı
Eyl 06, 2013
StringBuilder, System.Text isim uzayı altında yer alan ve temel olarak metinsel ifadeleri birleştirmek için kullanılan bir sınıftır.
String sınıfıyla yapılan metin birleştirme işlemleri StringBuilder sınıfıyla da yapılabilmekte ve bu noktada StringBuilder sınıfının String sınıfına
 göre ciddi bir performans üstünlüğü bulunmaktadır. Çünkü String objesi değişmeyen (immutable) bir nesnedir
  ve '+' ile yeni bir karakter katarı (string) eklendiğinde her defasında yeni bir String nesnesi yaratılmaktadır.
  StringBuilder nesnesi ise bir kez yaratılır ve daha sonra yeni veriler bu nesneye eklenir.

StringBuilder nesnelerinin başlangıç kapasitesi 16 karakterdir. 16 karakterden daha fazla bilgi aktarıldığında kapasite ikiye katlanır ve 32 olur.
 Örneğin 10 karakter içeren nesnenin kapasitesi 16, 20 karakter içeren nesnenin kapasitesi 32 ve 40 karakter içeren nesnenin kapasitesi 64'tür.
 StringBuilder nesnesinin kapasitesiCapacity özelliğinde, içerdiği verinin boyu ise Length özelliğinde saklanmaktadır.

Yeni bir StringBuilder nesnesi

       StringBuilder sbldr = new StringBuilder();
şeklinde yaratılabileceği gibi,

       StringBuilder sbldr = new StringBuilder("text", 5000);
şeklinde ilk değer vererek de yaratılabilir. Burada "text" nesnenin başlangıç değerini, 5000 ise yaratılan nesnenin karakter uzunluğunu belirtmektedir.

StringBuilder nesneleri temel olarak String değişkeninin sahip olduğu metot ve özelliklere sahiptir. Bunun yanında özel olarak Append, AppendFormat
ve AppendLineadlarında üç metodu daha vardır.

Append()

Append kelime anlamıyla eklemek anlamına gelmektedir. Bu metodla StringBuilder nesnesinin içeriğinin sonuna yeni veri eklenebilir. Örneğin;

       StringBuilder sbldr = new StringBuilder("isim");
şeklinde yeni bir nesne yarattıktan sonra,

       sbldr.Append(" soyisim");
kodu çalıştırılırsa sbldr nesnesinin içeriği "isim soyisim" olur.

AppendLine()

AppendLine metodu eklenen verinin sonuna bir alt satıra geçmeye yarayan kodu ekler.

AppendFormat()

AppendFormat metodu veri formatlı bir şekilde eklenmek istendiğinde kullanılır. Örneğin;

       sbldr.AppendFormat("{0:N0}", 1234567);
komutu 1234567 sayısını StringBuilder nesnesine 1.234.567 olarak ekler.

       sbldr.AppendFormat("{0:F2}", 1234.567);

komutu 1234.567 sayısını StringBuilder nesnesine 1234.57 olarak ekler. Burada 'F' harfi sayının float bir değer olduğunu,
2 sayısı ise virgülden sonra iki basamak olacağını belirtir.

Replace()

Replace metodu ile StringBuilder nesnesinin içerdiği karakter katarında bir karakter başka bir karaktere dönüştürülebilir.

       sbldr.Replace('f', 'F');

komutu Stringteki bütün 'f' harflerini 'F' ’ye çevirir.

Insert()

Insert metoduyla bir karakter katarı, StringBuilder nesnesine istenilen karakterden itibaren eklenebilir.

       sbldr.Insert(12, "ekle");

komutu 12. karakterden sonra “ekle” kelimesini karakter katarına ekler.

Remove()

Remove metodu StringBuilder nesnesinin içerdiği karakter katarının istenilen bölümünün silinmesini sağlar. Örneğin;

       sbldr.Remove(10, 6);

komutu çalıştırıldığında karakter katarının 10. karakterinden sonraki ilk 6 karakter silinir.
     */
}
