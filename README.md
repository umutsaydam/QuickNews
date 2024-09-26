# Quick-News

## ScreenShots
![quick_news_cover](https://github.com/user-attachments/assets/e40527c4-b71c-4cfc-a88c-0e80d265d4f5)

<div>
<h3><a href="#uygulama-icerik">TR</a></h3>
<h3><a href="#app-content">EN</a></h3>
</div>

## TR
### <p id="uygulama-icerik"></p>
Uygulama Özellikleri
 - Farklı kaynaklardan haberleri listeler.
 - Haberlerin tamamına erişim için kaynak sağlar.
 - Haberleri kaydetme özelliği mevcut.
 - Haber arama özelliği mevcut.
 - İnsanlarla haber paylaşma özelliği mevcut.
 - Açık/ Karanlık tema desteği mevcut.

## Kullanılan Teknolojiler - Kütüphaneler
- Kotlin Jetpack Compose
- Dagger-Hilt - Bağımlılık yönetimi.
- DataStore - Veri kaydedilmesi için kullanıldı.
- Pagin3 - Verileri sayfalama ve ön bellekte tutulması için kullanıldı.
- Coroutines - Main thread'leri bloklayıp uygulamaları yanıt vermemesine sebep olabilecek işlemleri asenkron bir şekilde arka planda yapmamızı sağlar.
- JetPack
    - Lifecycle 
    - ViewModel - MVVM mimaresinin bir parçası olan view model, mantıksal işlemlerin yürütüldüğü kısımdır.
    - Room - Temeli SQLite olan veri tabanı. 
    - Navigation - Fragment'lar arası dolaşım ve parametre gönderimi için kullanıldı.
- Material-Components - Material design komponentler.
- Retrofit - REST API hizmeti için kullanıldı.
- Coil - Resimleri verimli bir şekilde gösterilmesini sağlar.

## <p id="app-content">EN</p>
App Features
  -Lists news from various sources.
  - Provides access to full news articles.
  - Includes a feature to save news.
  - Contains a news search feature.
  - Allows sharing news with others.
  - Supports light/dark theme options.

## Tech Stack - Library
- Kotlin Jetpack Compose
- Dagger-Hilt Dependency management.
- DataStore - Used for data storage.
- Paging3 - Used for paginating and chaching data.
- Coroutines - Allows us to perform operations asynchronously in the background, which may block main threads and cause applications to stop responding.
- JetPack
    - Lifecycle
    - ViewModel - The view model, which is a part of the MVVM architecture, is the part where logical operations are carried out.
    - Room - Database based on SQLite.
    - Navigation - Used for inter-fragment navigation and parameter sending.
- Material-Components - Material design components (like cardview).
- Retrofit - Used for REST API service.
- Coil - It allows images to be displayed efficiently.
