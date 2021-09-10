package com.cloud.geekhaberler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.cloud.geekhaberler.databinding.ActivityMainBinding
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var infoCard: CardInfoFragment
    private lateinit var newsList: ArrayList<News>
    private lateinit var fragments: ArrayList<Fragment>
    private lateinit var idList: List<Int>
    private var onDetail = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        newsList = ArrayList()
        fragments = ArrayList()

        idList = listOf(
            binding.frameLayout1.id, binding.frameLayout2.id,
            binding.frameLayout3.id, binding.frameLayout4.id,
            binding.frameLayout5.id, binding.frameLayout6.id,
            binding.frameLayout7.id, binding.frameLayout8.id,
            binding.frameLayout9.id, binding.frameLayout10.id,
            binding.frameLayout11.id, binding.frameLayout12.id,
            binding.frameLayout13.id, binding.frameLayout14.id,
            binding.frameLayout15.id
        )
        newsList.addAll(
            listOf(
                News(
                    "Matrix: Resurrections’dan İlk Fragman Geldi: Kafamızda Bir Sürü Soru İşareti!",
                    "Popüler kültürün bugünkü haline gelmesi sırasında birçok film, dizi, kitap, çizgi roman ve oyun bu kültürü etkiledi. Fakat her yapımın kendi çapında katkıda bu kültürü bazı ağır taşlar, yerinden salladılar. İnsanlar; Star Trek çıktığında Vulcan selamı yaptılar, Star Wars’u izlediklerinde kendi ışın kılıçlarını imal ettiler, Yüzüklerin Efendisi’ni gördüklerinde ise “You shall not pass” diyerek etrafta dolaştılar. Ama sanıyorum ki gösterime girdiği 1999 yılına kadar hiçbir yapım Matrix kadar popüler kültürü baştan aşağıya değiştirmemişti. Bu yüzden Matrix hakkında gelen en küçük haber bile bizi heyecanlandırmaya yetiyor. Öte yandan bugün gelen haber hiç de küçük değil. Karşınızda son filminin üzerinden tam on sekiz yıl geçen Matrix serisinin dördüncü filmi The Matrix: Resurrections fragmanı!",
                    "https://geekyapar.com/wp-content/uploads/2021/09/matrix-4-trailer-270x180.jpg"
                ),
                News(
                    "Eski Günler Geri Mi Dönüyor? Shang Chi İşçi Bayramı Haftasında Amerika Rekorunu Kırdı!",
                    "Artık ne yazık ki hayatımızın bir parçası haline gelen ve bir süre daha bizimle beraber kalacağını kabullendiğimiz Covid-19 virüsünün; sağlık, ekonomi, eğitim gibi daha ciddi meselelere etkisini bir kenara bıraktığımızda şüphesiz ki virüsten en çok zarar gören şeylerden biri topluca yapılan etkinliklerdi. Seyircisiz oynanmaya mahkum spor müsabakalarından tutun anca dijital olarak düzenlenebilen konserlere oradan da benim en sevdiğim hobilerimden biri olan sinemada film izlemeye kadar birçok sosyal aktivite, şu son iki yılda çok kan kaybetti. Hatta en son bahsettiğim sinemada film izlemeye gelince, zaten halihazırda dönen çevrimiçi dizi ve film izleme platformları ile sinema salonları arasındaki gerginlikler arşa çıktı desek yeridir. Pandemiden dolayı sinemanın eski şaşalı günlerine bir daha dönmeyeceğini hatta bazı yayıncı şirketlerin buna dair çeşitli aksiyonlar alması, bu gerginliğin ana sebeplerinden oldu. Bu derin bir konu ve önümüzdeki yıllarda cevabını alacağız fakat biz bugüne dönersek işin en azından blockbuster denilen dev bütçeli filmlerine baktığımızda, geleceğin o kadar da karamsar olmayabileceğini söyleyebiliriz. Çünkü geçtiğimiz hafta dünyanın birçok bölgesinde vizyona giren Shang Chi and the Legend of the Ten Rings filmi Amerika’da İşçi Bayramı(Labor Day) haftası rekorunu kırdı!",
                    "https://geekyapar.com/wp-content/uploads/2021/09/shangchi-2-1-770x515.jpg"
                ),
                News(
                    "Lion King Prequeli Yavaş Yavaş Geliyor: Seslendirme Sanatçıları Belli Oldu Bile!",
                    "Devam filmleri bana göre her zaman tehlikeli bir kavram olagelmiştir. En baştan iki ya da üç film olarak düşünülen projelere diyecek sözüm yok. Fakat ilki tuttu diye alelacele yapılan devam filmlerinden pek de hayır gelmedi bize. Öte yandan planlanmamış bir devam filminden daha kötü bir şey var bu dünyada. O da tabii ki “prequel” yani, ana yapımın öncesini anlatan filmler. Zira başarısız bir sequelden sonra, her şeye rağmen orijinal filmi izleyebilirsiniz fakat kötü bir prequel, kendisinden sonraki filmlerin de tadını kaçırır. Bu kadar pimpiriklenmemin sebebine gelecek olursak, Lion King prequeli için seslendirme kadrosu belli oldu sevgili geekler. Ama biz hâlâ “Böyle bir şeye gerek var mıydı?” diye sorguluyoruz kendimizi.",
                    "https://geekyapar.com/wp-content/uploads/2020/10/g_lionking2019_02_17788_490698f9.0-270x180.jpeg"
                ),
                News(
                    "The Witcher: Nightmare of the Wolf SPOILERSIZ İnceleme: Bu Filmi Her Şeyden Önce Çekmeliydiniz!",
                    "The Witcher markası, ‘Kitabından oyun yapacağız‘ dendiğinde çok da ciddiye almayıp, sonrasında beklemediği bir bilinirlikle tanışan serinin yazarı Andrej Sapkowski’nin birebir kanıtı olduğu şekliyle bendini aşan bir marka. Kısa hikâyeler, romanlar, çizgi romanlar, yerel bir film, ardından birisi dünya çapında dillere pelesenk olacak seviyede övülen üç oyun; şimdi de Netflix bünyesindeki dizisi filan derken, bir süre daha önünü alacak gibi gözükmüyoruz. Neyse ki trene, bütün bunlar olmadan çok kısa bir süre önce atlamıştık da böylece, Aralık 2021’de çıkacak olan ikinci sezondan ve bir sonraki yıl izleyeceğimiz, ilk witcherın yaratılışını konu alan Blood Origin dizisinden önce, henüz taze yayınlanan The Witcher: Nightmare of the Wolf filmini, güncelden yakalayabiliyoruz.\n" +
                            "\n" +
                            "Bu sayfalarda kaç tane witcher yazısı yazdım, inanın artık sayamıyorum ve tam da bu yüzden The Witcher: Nightmare of the Wolf ile ilgili fikirlerimi belirtmeden önce, seriyi ne kadar sevdiğimi ayrıca anlatmaya da takat bulamıyorum. Dileyeniniz varsa şuradan, The Witcher dizisi çıkmadan önce yazdığım hype trenlerine beklerim. Film, daha bir gün önce seyirciye sunulduğu için bu yazıda spoilerlı fikirlerimi kendime saklayacağım, rahat rahat okuyabilirsiniz.",
                    "https://geekyapar.com/wp-content/uploads/2021/08/the-witcher-nightmare-of-the-wolf-35-images_gwtw-270x180.jpg"
                ),
                News(
                    "VENOM: LET THERE BE CARNAGE Filminden İkinci Fragman da Geldi: Aynı SİMBİYOTUN Kırmızısı…",
                    "Süper kahraman janrası, beyaz perdeye adımını attığı günden bu yana birbirinden garip şeyler izledik. Göğsündeki “S” logosunu fırlatan Superman‘i, gümüş meme uçlu Batman‘i, emo Spider-Man‘i ve daha nicesini gördü bu gözler. Fakat bu saydıklarımızdan hiçbirini savunmadık ve el birliğiyle bütün geekler olarak haklı dalgamızı geçtik. Benim anlamadığım tek şey, dalga geçtiğimiz bu eserlerin arasında sayılması gereken Venom filminin, nasıl bu kadar kabul gördüğü. Yine de bu konu üzerinde daha fazla durmuyor ve Venom: Let There Be Carnage filminden gelen ikinci fragmanı sizinle paylaşıyorum.",
                    "https://geekyapar.com/wp-content/uploads/2021/08/Venom-270x180.jpg"
                ),
                News(
                    "The Suicide Squad 2 SPOILERSIZ İnceleme: Yetişkinler İçin Çocuk Filmi",
                    "Eğer bu filmden beklentiniz, mantık şalterini kapatıp eğlenmekse bu yazının geri kalanını okumanıza gerek yok; film bunu gayet başarıyor. Ama eğer içinizdeki geek, tıpkı benim gibi, izlediği her süper kahraman filmini ciddiye alıyorsa buyurun, filmi beraber biraz deşelim. Kim ölüyor, sonunda ne oluyor falan, izlememişler için filmi bozmayacağım ama bu yazıyı okunca film kafanızda şekillenebilir, ona göre.\n Film güya büyükler için. Pipisiyle, üç-beş çift arka plan memesiyle ve aşırı abartı şiddeti ile +18 ibaresini hakkıyla hak ediyor. Peki, o zaman neden filmin aksiyon rejisi, Commando (1985) veya sevgili yerli dizimiz Akıncı’da olduğu gibi, kabak gibi açıkta duran birini 500 tane makineli tüfekli askerin vuramayışına izin veriyor? Neden filmde karakter gelişimi yaşayan bir-iki tipin karakter gelişimlerini daha ilk beş dakikadan tahmin etmek mümkün? Neden bazı oyuncular karakterlerinin etik duruşlarını aksiyon ve telaşın ortasında iki cümleyle özetleyerek rol arkadaşlarına açıklayıveriyorlar? Neden bazı süper güçler eline bir tabanca almaktan daha verimsizken DÜNYANIN EN ÖNEMLİ görevini gerçekleştirmesi gereken bir ekipte mevcut? Tüm bunların cevabı aynı: Bu film, şiddetine filan rağmen bir çocuk filmi. Evet öyle.\n" +
                            "\n" +
                            "Bazı esprilerin ve genel olarak aksiyon rejisinin, mantıksız olmasına rağmen kimi yetişkinlere de çekici geleceğini kabul etmek lazım. Ama bu kadar. Filmin bir derinliği ya da ciddiyeti asla yok. James Gunn “eğlenelim, gerisini boş verelim” demiş; bu çok net. İki espri veya şaşırtıcı bir sahne uğruna yazılmış birtakım karakterlerin bazı karar alma sahneleri o kadar saçma ki, film zaten kendini pek ciddiye almadığını kanıtlıyor.",
                    "https://geekyapar.com/wp-content/uploads/2021/07/suicide-squad.2jpg-270x180.jpg"
                ),
                News(
                    "Dune Filminden İkinci Fragman Geldi: Altın Yol Gözüktü!",
                    "Bundan daha birkaç gün önce yayınlanan Dune posterlerine ne kadar coştuğumu hatırlıyorsunuz değil mi? O zaman dün akşam yayınlanan Dune filminden gelen yeni fragmanın, bende bıraktığı etkiyi az çok tahmin edebiliyorsunuzdur. Beklenileceği üzere, saatlerce bilgisayar başında bekledikten sonra fragmanı birkaç küçük çığlık ile beraber izledim ve kendimi bilgisayarın başına zor attım. Şimdi detaylı detaylı Dune filminin ikinci fragmanını inceleme zamanı ama önce gelin şu güzelliğe, dünya gözüyle bir kez daha bakalım. \nBenim Dune filmine olan heyecanımı artık bildiğinizden dolayı, müsaadeniz olursa öncelikle fragmanın kafamda oluşturduğu soru işaretlerine değineceğim. Zira övmeye başladığım anda kendimi durduramayıp, böyle kısımları atlıyorum. Beni, fragmanda gördüklerimden daha çok göremediğim şeyler tedirgin ediyor. Liet Kynes ve Feyd-Rautha gibi ilk kitaptaki iki kilit karakterin, şimdiye kadar tanıtım ve fragmanlarda neredeyse hiç gösterilmemesi beni gerçekten korkutuyor. Feyd-Rautha’nın, hikâyedeki kritik rolünden dolayı çıkartılmayacağından neredeyse emin olduğum için içim bir nebze rahat. Fakat Liet-Kynes’ın karakterinin bu kadar geri planda kalması, belki yönetmen ve senaristlerin göze alabileceği bir karar olabilir ama Fremenler ve dolayısıyla Muad’Dib’in karakter gelişimi için çok ama çok büyük bir hata olur. Bu yüzden umarım bir sonraki tanıtımlarda artık doya doya bir Liet Kynes görürüz.\n" +
                            "\n" +
                            "Aslında bize sunulan bu yeni videoda kafamızı karıştıran birçok ayrıntı var desek yalan olmaz. Dune filminin iki parçadan oluşacağına dayanan teorilerimiz doğrultusunda biz bu kadar savaş sahnesi beklemiyorduk. Ayrıca yine fragmanda Fremenler’in kask benzeri kıyafetler giymesi, Muad’Dib’in onların önünde inanılmaz teknolojik bir zırh ile savaşması kitaplarda hiç görmediğimiz unsurlardı. Senaristlerin aldığı bu kararlara bir anlam vermeye çalışırken sonunda aklımıza olabilecek en mantıklı açıklama geldi. Bu fragmanda gördüğümüz çoğu şey Paul’un, baharat rüyalarında gördüğü şeyler olabilir.",
                    "https://geekyapar.com/wp-content/uploads/2021/07/dune-second-trailer-timothee-chalamet-270x180.jpg"
                ),
                News(
                    "Black Widow’un Senaryo Taslaklarından Birinde Asıl Düşman Yelena’ymış!",
                    "Yaklaşık bir senelik bir ertelemenin ardından geçtiğimiz cuma günü sonunda vizyona giren Black Widow filmi gişede de tam gaz devam ediyor bildiğiniz gibi. Daha şimdiden pandemi süreci rekorlarını kırdı geçti ve muhtemelen de bu son iki sene içerisindeki en yüksek hasılata sahip 3-4 filmden biri olarak tamamlayacak vizyon sürecini.\n" +
                            "\n" +
                            "Ben, tıpkı sitedeki diğer arkadaşlarım gibi filmi sevdim. Filmin anlatmak istediği Kırmızı Oda (televizyondaki değil) ve onun baskısına maruz kalmış kurbanların yaşadıkları, solo bir Black Widow hikâyesi için yeterli ve üzerine anlatmaya değer şeyleri barındıran bir konuydu keza bunu başarılı bir şekilde yapabildi. Bazı eksikleri de yok değildi tabii, mesela yumruk yumruğa dövüş dövüş sahneleri beklediğim kadar tatmin edici olmadı ya da aile üzerine kurulan diyaloglar zaman zaman tekrara düşmüş hissettirdi fakat genel itibariyle mutlu ayrıldım ve uzun bir aradan sonra büyük ekranda MCU filmi izlemenin coşkusunu da yaşamış oldum. \nBu bir inceleme değil tabii, filmden bahsediyor olmamın sebebi hikayedeki ana odağın bir zamanlar bu olmadığına dair öğrendiklerimiz. Gelin Scarlett Johannson’ın kendisinden dinleyelim olup biteni: ‘’Bu filmin birçok farklı versiyonu vardı. Mevcut durumu fazlasıyla barındıran bir hâli vardı [çizgi romanlardaki durumu kastediyor]. Yelena ve Natasha düşmanlardı ve Yelena onun yerine geçmeye çalışıyordu, tıpkı herhangi bir ajan hikâyesi versiyonundaki gibi. Ben de ‘Bunun için role dönemem’ modundaydım… Benim geliştirdiğim, oldukça varoluşsal ve garip başka bir versiyon daha vardı. Feige de ’Bunun üzerinde çalışmak için işe gelebileceğimi sanmıyorum’ modundaydı. Garipti [kendi versiyonunu kastediyor], sevmiştim.’’\n" +
                            "\n" +
                            "Sizi bilemem ama ben Yelena’nın tam teşekküllü bir düşman olup da sonradan kardeşini kolladığı bir versiyonu görmeye de hayır demezdim. Hâlihazırda muhteşem bir iş çıkarmış Florence Pugh’u da daha farklı bir rolde görürdük. Klişe ve bilindik olurdu tabii ama mevcut haldeki Dreykov’un da çok orijinal olmadığı bariz. Yelena’yı böyle -görece- masum hâliyle görmenin de tadı ayrıydı elbette ama #ReleasetheYelenaCut diyeyim siz anlayın.",
                    "https://geekyapar.com/wp-content/uploads/2021/07/Black-Widow-Natasha-Yelena--270x180.jpg"
                ),
                News(
                    "Zack Snyder, Star Wars Evreninde Olmayan Bir Star Wars Filmi Yapıyor: Rebel Moon Geliyor!",
                    "Geekyapar’ın kuruluşundan beri -ki uzun bir süresinde içerisinde yer almadığımı belirtmek isterim, genel olarak sözünü esirgemeyen, beğendiğini savunan, beğenmediğini yerden yere vuran bir topluluk olageldik. Fakat biz ne kadar söylediklerimize “Bence, bizce, sübjektif olarak” kelimelerini eklesek de insanlar sanki söylediklerimizi kanun olarak kabul ettirmeye çalıştığımızı düşündü ve kendilerince de linç ettiler bizi. En çok da kimden çektik biliyor musunuz? Tabii ki Snydercılardan. Bir türlü derdimizi anlatamadık, övdük kötü olduk gömdük kötü olduk. Canları sağ olsun. Ama bugün biz geçmişe sünger çekiyor ve Snyder’ın, Netflix için hazırlayacağı Rebel Moon filmi sayesinde, hiçbir şey yaşanmamış gibi Snyder gömüyoruz.",
                    "https://geekyapar.com/wp-content/uploads/2021/07/E1cUqLNVUAI6-iw-270x180.jpg"
                ),
                News(
                    "What If…? Dördüncü Bölüm SPOILERLI İnceleme: BIRAK O ZAMANI YERİNE ÇOCUĞUM!",
                    "“Ya şöyle olsaydı?” şeklinde, Marvel evrenine dair sorulan soruların cevaplanmaya devam ettiği What If…? dizisinin dördüncü bölümüne gelmiş bulunuyoruz. Şimdiye kadar elimizde bir adet Captain Carter, bir adet T’Challa Star-Lord ve bir adet “Ya Avengers hiç birleşemeden ölseydi?” hikâyesi var. Bu bölüm itibariyle de bildiğimizden farklı bir Doctor Strange hikâyesi izlemiş olduk. Haydi, gelin bu bölüm neler gördük, nasıl bir Doctor Strange bizleri karşıladı, bakalım!\n" +
                            "\n" +
                            "Bu bölümle ilgili söylemek istediğim ilk şey, son iki bölüme göre biraz daha açık bir What If? sorusu sorulması ve cevabı da yine açık bir dille anlatılması. Bu konunun -aslına bakarsanız bu dizinin genel konusunun- son iki bölümde biraz daha dolambaçlı ve net olmadan işlenmesi beni diziden bir miktar koparmıştı. Çünkü o kadar çok What If? sorusu birbirine bağlıydı ve pek çoğundan da ciddi bir merak unsuru olmasına rağmen sadece laf arasında bahsediliyordu ki; bu bölüm her şeyin açık seçik anlatılması hoşuma gider oldu. Tabii bu kişisel bir yorum olduğu için o anlatım şeklini beğenenler de olabilir, biz en iyisi bu bölüm anlatılanlara gelelim.",
                    "https://geekyapar.com/wp-content/uploads/2021/09/what-if-ep4-img1-270x180.jpg"
                ),
                News(
                    "Işın Kılıcından Vantilatör Yapmak: Star Wars: Visions’dan İlk Fragman Geldi!",
                    "Star Wars’ın, şimdiye kadar yaratılan kurgusal evrenler arasında, yeni hikâyeler yaratmak için en uygun evren olduğunu her fırsatta söyledik. Söylemeye de devam edeceğiz. George Lucas’ın yarattığı evren, içerisinde o kadar büyük bir potansiyel barındırıyor ki; herkes küçük bir köşesinde kendi hikâyesini anlatabilir ve birbirinden bağımsız, binlerce güzel öykü ortaya çıkabilir. Belki güzel değil ama farklı olduklarından yüzde yüz emin olduğumuz Star Wars: Visions fragmanı, tam olarak bunları hissettirdi bize.",
                    "https://geekyapar.com/wp-content/uploads/2021/08/Star-Wars-Visions-Expands-Universe-Into-Japanese-Anime-With-7-Prominent-Studios-This-September-on-Disney-1-270x180.jpg"
                ),
                News(
                    "Sonunda DİŞE DOKUNUR Haberler: AVATAR Netflix Uyarlaması Yavaş Yavaş Geliyor!",
                    "Uyarlamalar biraz lanetli şeyler, bence nefret edeceğimizi bildiklerimizi bile çılgın bir heyecanla bekliyoruz. Bazen gerçekten hoşa gidecek şeyler çıkıyorlar, burası doğru ancak karşısına geçilen ilk an genellikle dehşetli bir önyargı dolu. Sırf nasıl rezil edildiğini görmek, en sevdiğimiz ayrıntıların nasıl dudak büktüğümüz özelliklere dönüştürülebildiğini izlemek için bile inanılmaz şeyler. Sanıyorum ki berbat edilmiş bir uyarlama, en olumlu incelemeden daha övgü dolu oluyor bir hikâye için.\n" +
                            "\n" +
                            "Bugün Avatar’ın Netflix uyarlamasından gelen haberlere geçmeden önce, tüm kalbimle “Bu uyarlamadan uzak olsun!” diye dilediğimi söylemem gerek. Fakat her ne kadar temkinli yaklaşsam da beni kendi dalgasına öyle bir aldı götürdü ki dizi, kötü ihtimalleri aklıma getirmiyorum bile —umuttan daha büyük hastalık yokmuş.",
                    "https://geekyapar.com/wp-content/uploads/2021/08/live_actionnetflix_avatar_the_last_airbender.0-270x180.jpeg"
                ),
                News(
                    "Strangers Things, Dördüncü Sezonuyla Geri Dönüyor: Bu Dizi Ne Zaman Bitecek?",
                    "Anlamakta güçlük çekiyorum. Anlamadığım mevzu Netflix ile ilgili falan da değil direkt kendimle ilgili. Güzel bir içerik gördüğümde hemen bu içeriğin daha fazlasını istiyorum. Ama işte sonra istediğim gerçekleşip, sevdiğim dizi ya da filmlerin devamı gelince bu sefer de kalitesini devam ettiremediklerini düşünüyorum. Tamam, bu noktada tüm suçu kendime atmayacağım. Zira gerçekten bir çok yapım, içeriklerinin kalitesini uzun süre aynı seviyede tutmakta büyük sorunlar yaşıyor. The Stranger Things ile ilgili durum tam olarak bu. Gelin önce dördüncü sezondan gelen fragmanı bir izleyelim, sonra yine konuşuruz.",
                    "https://geekyapar.com/wp-content/uploads/2021/08/flatten-270x180.jpg"
                ),
                News(
                    "THE BOYS Üçüncü Sezon İçin VOUGTH INTERNATIONAL Kanalından Al Haberi: Üçüncü Sezona Giden Süreçte, Karakterlerimiz NELER Yapıyormuş?",
                    "The Boys değişik bir dizi, sanırım bu kısmında hepimiz hemfikir olabiliriz. Bir çizgi romandan uyarlama olduğu ve zaten o çizgi roman da kendi içerisinde değişik bir iş yaptığı için dikkat çekip böyle bir uyarlamaya kavuştuğu için, tüm başarıyı diziye ne kadar yükleyebiliriz, orası bir başka tartışma konusu. Fakat diziyi değişik kılan şeylerden biri, her ne kadar hikâye temellerini çizgi romandan alsa da bir kere bu tarz sert bir hikâyeyi ekranlarda sunması ve bu yolla çizgi roman okuru olmayanları da çekebilmesi, ötesinde de hikâyede yaptığı değişiklikleri -mesela ikinci sezondaki Stormfront olay örgüsünü- bugünün, özellikle süper kahraman uyarlamalarıyla dolu dünyasına, uygun bir şekilde yedirebilmesi. The Boys’un çizgi roman medyasından çıkıp televizyon dünyasına taşan, burada da kendince bir başka değişiklik oluşturan özelliklerinden biri de bundan birkaç ay önce açılmış olan, Vought International isimli resmi youtube kanalı.\n" +
                            "\n" +
                            "Ne kadar duydunuz, reklamı ne kadar yapıldı bilemiyorum ama Vought International, dizinin dünyasını bizim dünyamıza taşıyıp, iki tarafın ortak zemininde işler yapmak için oluşturulmuş bir kanal. Vought International’ın şimdilik, ilki iki ay kadar önce yayımlanmış olan üç videosu bulunuyor, bunların hepsi de Amazon’un The Boys dizisinin evreninde geçen olaylarla ilgili haberleri içeriyor. Ama tabii “üçüncü sezonda bu olacak, takipte kalın” duyuruları değil bunlar, tıpkı kanalın isminde yer aldığı şekliyle sanki The Boys kurgu değilmiş de Vought, onlarla alakalı bir haber bültenini hayata geçirmiş minvalindeler.\n" +
                            "\n" +
                            "Vought International kanalından yayınlanan son videoda ise ikinci sezonla üçüncü sezon arasında karakterlerimizin neler yaptığını ve üçüncü sezonda da bizi nelerin bekleyeceğini öğreniyoruz. Bir noktada resmi kanaldan geldikleri için bunları bir çeşit teaser sayabiliriz sanırım?",
                    "https://geekyapar.com/wp-content/uploads/2021/08/boys-season-3-270x180.jpg"
                ),
                News(
                    "Rick and Morty 5. Sezon Finali Bir Saat Sürdü, Ama Yayın Tarihi Ertelendi",
                    "Sevilen çizgi dizi Rick and Morty ’nin beşinci sezon final bölümü ilk fragmanı yayınlandı. 5 Eylül’de yayınlanacak sezon finali bölümü 1 saat sürecek. \n" +
                            "\n" +
                            "Bilim-kurgu türündeki sevilen animasyon dizisi Rick and Morty’nin beşinci sezon final bölümü ilk fragmanı yayınlandı. Rick and Morty ‘nin özel bölümü olacak Sezon 5 ‘in finali 1 saat uzunluğunda olacak.\n" +
                            "\n" +
                            "Rick and Morty beşinci sezon final bölümü 1 saat olacak\n" +
                            "2014 yılından bu yana yapımcısı Adult Swim kanalında yayınlanan popüler animasyon dizisi Rick and Morty’nin beşinci sezonu önceki sezonlardan farklı oldu. Adult Swim, Rick and Morty ‘nin beşinci sezonunda şu an için 8 bölüm yayınladı. Dizinin sezonları genellikle dördüncü sezon gibi 10 bölümden oluşuyordu. Ancak geçen günlerde yapılan bir açıklamayla, son iki bölümün tek bir bölüm olarak yayınlanacağı ve 1 saat uzunluğunda olacağı belirtildi. Bunun haricinde dizinin sezon finalinin çıkış tarihi 1 ay ertelendi. Normalde dokuzuncu ve onuncu bölümlerin isimleri sırasıyla Forgetting Sarick Mortshall ve Rickmurai Jack olacaktı. Adult Swim’in bölümleri arka arkaya iki parter olarak yayınlaması ve bölümlerin birbirleriyle bağlantılı olması durumunda bir saatlik sezon finali olarak anılabilir. ",
                    "https://i2.wp.com/shiftdelete.net/wp-content/uploads/2021/08/Rick-and-Mortyden-5.-sezon-finali-icin-buyuk-surpriz.jpg?w=1280&ssl=1"
                ),
            )
        )
        val bigCard1: BigCardFragment by lazy {
            BigCardFragment.newInstance(
                newsList[0].head,
                newsList[0].content,
                newsList[0].image
            )
        }
        val bigCard2: BigCardFragment by lazy {
            BigCardFragment.newInstance(
                newsList[1].head,
                newsList[1].content,
                newsList[1].image
            )
        }
        val bigCard3: BigCardFragment by lazy {
            BigCardFragment.newInstance(
                newsList[2].head,
                newsList[2].content,
                newsList[2].image
            )
        }
        val bigCard4: BigCardFragment by lazy {
            BigCardFragment.newInstance(
                newsList[3].head,
                newsList[3].content,
                newsList[3].image
            )
        }
        val bigCard5: BigCardFragment by lazy {
            BigCardFragment.newInstance(
                newsList[4].head,
                newsList[4].content,
                newsList[4].image
            )
        }
        val bigCard6: BigCardFragment by lazy {
            BigCardFragment.newInstance(
                newsList[5].head,
                newsList[5].content,
                newsList[5].image
            )
        }
        val bigCard7: BigCardFragment by lazy {
            BigCardFragment.newInstance(
                newsList[6].head,
                newsList[6].content,
                newsList[6].image
            )
        }
        val bigCard8: BigCardFragment by lazy {
            BigCardFragment.newInstance(
                newsList[7].head,
                newsList[7].content,
                newsList[7].image
            )
        }
        val bigCard9: BigCardFragment by lazy {
            BigCardFragment.newInstance(
                newsList[8].head,
                newsList[8].content,
                newsList[8].image
            )
        }
        val bigCard10: BigCardFragment by lazy {
            BigCardFragment.newInstance(
                newsList[9].head,
                newsList[9].content,
                newsList[9].image
            )
        }
        val bigCard11: BigCardFragment by lazy {
            BigCardFragment.newInstance(
                newsList[10].head,
                newsList[10].content,
                newsList[10].image
            )
        }
        val bigCard12: BigCardFragment by lazy {
            BigCardFragment.newInstance(
                newsList[11].head,
                newsList[11].content,
                newsList[11].image
            )
        }

        val smallCard1: SmallCardFragment by lazy {
            SmallCardFragment.newInstance(
                newsList[12].head,
                newsList[12].image
            )
        }
        val smallCard2: SmallCardFragment by lazy {
            SmallCardFragment.newInstance(
                newsList[13].head,
                newsList[13].image
            )
        }
        val smallCard3: SmallCardFragment by lazy {
            SmallCardFragment.newInstance(
                newsList[14].head,
                newsList[14].image
            )
        }
        fragments.addAll(
            listOf(
                bigCard1,
                bigCard2,
                smallCard1,
                bigCard3,
                bigCard4,
                bigCard5,
                smallCard2,
                bigCard6,
                bigCard7,
                bigCard8,
                smallCard3,
                bigCard9,
                bigCard10,
                bigCard11,
                bigCard12,
            )
        )
        addNews()

        binding.frameLayout1.setOnClickListener {
            onDetail = true
            removeNews()
            infoCard = CardInfoFragment.newInstance(
                newsList[0].head,
                newsList[0].content,
                newsList[0].image
            )
            supportFragmentManager.beginTransaction().replace(binding.frameLayout1.id, infoCard)
                .commit()
        }

        binding.frameLayout2.setOnClickListener {
            onDetail = true
            removeNews()
            infoCard = CardInfoFragment.newInstance(
                newsList[1].head,
                newsList[1].content,
                newsList[1].image
            )
            supportFragmentManager.beginTransaction().replace(binding.frameLayout2.id, infoCard)
                .commit()
        }

        binding.frameLayout3.setOnClickListener {
            onDetail = true
            removeNews()
            infoCard = CardInfoFragment.newInstance(
                newsList[12].head,
                newsList[12].content,
                newsList[12].image
            )
            supportFragmentManager.beginTransaction().replace(binding.frameLayout3.id, infoCard)
                .commit()
        }

        binding.frameLayout4.setOnClickListener {
            onDetail = true
            removeNews()
            infoCard = CardInfoFragment.newInstance(
                newsList[2].head,
                newsList[2].content,
                newsList[2].image
            )
            supportFragmentManager.beginTransaction().replace(binding.frameLayout4.id, infoCard)
                .commit()
        }

        binding.frameLayout5.setOnClickListener {
            onDetail = true
            removeNews()
            infoCard = CardInfoFragment.newInstance(
                newsList[3].head,
                newsList[3].content,
                newsList[3].image
            )
            supportFragmentManager.beginTransaction().replace(binding.frameLayout5.id, infoCard)
                .commit()
        }

        binding.frameLayout6.setOnClickListener {
            onDetail = true
            removeNews()
            infoCard = CardInfoFragment.newInstance(
                newsList[4].head,
                newsList[4].content,
                newsList[4].image
            )
            supportFragmentManager.beginTransaction().replace(binding.frameLayout6.id, infoCard)
                .commit()
        }

        binding.frameLayout7.setOnClickListener {
            onDetail = true
            removeNews()
            infoCard = CardInfoFragment.newInstance(
                newsList[13].head,
                newsList[13].content,
                newsList[13].image
            )
            supportFragmentManager.beginTransaction().replace(binding.frameLayout7.id, infoCard)
                .commit()
        }

        binding.frameLayout8.setOnClickListener {
            onDetail = true
            removeNews()
            infoCard = CardInfoFragment.newInstance(
                newsList[5].head,
                newsList[5].content,
                newsList[5].image
            )
            supportFragmentManager.beginTransaction().replace(binding.frameLayout8.id, infoCard)
                .commit()
        }

        binding.frameLayout9.setOnClickListener {
            onDetail = true
            removeNews()
            infoCard = CardInfoFragment.newInstance(
                newsList[6].head,
                newsList[6].content,
                newsList[6].image
            )
            supportFragmentManager.beginTransaction().replace(binding.frameLayout9.id, infoCard)
                .commit()
        }

        binding.frameLayout10.setOnClickListener {
            onDetail = true
            removeNews()
            infoCard = CardInfoFragment.newInstance(
                newsList[7].head,
                newsList[7].content,
                newsList[7].image
            )
            supportFragmentManager.beginTransaction().replace(binding.frameLayout10.id, infoCard)
                .commit()
        }

        binding.frameLayout11.setOnClickListener {
            onDetail = true
            removeNews()
            infoCard = CardInfoFragment.newInstance(
                newsList[14].head,
                newsList[14].content,
                newsList[14].image
            )
            supportFragmentManager.beginTransaction().replace(binding.frameLayout11.id, infoCard)
                .commit()
        }

        binding.frameLayout12.setOnClickListener {
            onDetail = true
            removeNews()
            infoCard = CardInfoFragment.newInstance(
                newsList[8].head,
                newsList[8].content,
                newsList[8].image
            )
            supportFragmentManager.beginTransaction().replace(binding.frameLayout12.id, infoCard)
                .commit()
        }

        binding.frameLayout13.setOnClickListener {
            onDetail = true
            removeNews()
            infoCard = CardInfoFragment.newInstance(
                newsList[9].head,
                newsList[9].content,
                newsList[9].image
            )
            supportFragmentManager.beginTransaction().replace(binding.frameLayout13.id, infoCard)
                .commit()
        }

        binding.frameLayout14.setOnClickListener {
            onDetail = true
            removeNews()
            infoCard = CardInfoFragment.newInstance(
                newsList[10].head,
                newsList[10].content,
                newsList[10].image
            )
            supportFragmentManager.beginTransaction().replace(binding.frameLayout14.id, infoCard)
                .commit()
        }

        binding.frameLayout15.setOnClickListener {
            onDetail = true
            removeNews()
            infoCard = CardInfoFragment.newInstance(
                newsList[11].head,
                newsList[11].content,
                newsList[11].image
            )
            supportFragmentManager.beginTransaction().replace(binding.frameLayout15.id, infoCard)
                .commit()
        }
    }

    override fun onBackPressed() {
        if (onDetail) {
            supportFragmentManager.beginTransaction().remove(infoCard).commit()
            addNews()
            onDetail = false
            binding.scrollView.scrollY
        } else {
            super.onBackPressed()
        }
    }

    private fun addNews() {
        val transection = supportFragmentManager.beginTransaction()
        for (i in 0 until fragments.size) {
            transection.add(idList[i], fragments[i])
        }
        transection.commit()
    }

    private fun removeNews() {
        for (i in 0 until fragments.size) {
            supportFragmentManager.beginTransaction().remove(fragments[i]).commit()
        }
    }
}