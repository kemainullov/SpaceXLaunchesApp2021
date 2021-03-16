# SpaceXLaunchesApp
Получение и отображение данных о запусках ракет компанией SpaceX.  
В приложении 3 экрана: "Прошедшие запуски", "Предстоящие запуски" и "Детальная информация о прошедшем запуске".  
В приложении присутствует локальное хранении полученных данных и отображении их в случае отсутствия интернета или при проблемах на сервере.  

**Стек технологий:**  
Clean architecture, MVVM, Kotlin Coroutines, Hilt, Navigation, Room, Retrofit 2, Coil, ViewBinding.  

**Проект разделен на несколько модулей:**  
Presentation - отвечает за ui. (Activity, Fragments, ViewModels, etc)  
Domain - бизнес-логика. (UseCases, Domain Models, Repository Interfaces, etc)  
Data - отвечает за предоставление данных. Содержит имплементацию репозиториев из Domain модуля и контракты для модулей Remote и Cache. (Repository Implementation, Source Interfaces, etc)  
Remote - сетевое взаимодействие. (Networking, Source Implementation, Remote Models, Mappres, etc)  
Cache - взаимодейстие с БД. (Working with DB, Source Implementation, Cache Models, Mappres, etc)  

Первоначальная версия, будут доработки.  
