# SpaceXLaunchesApp
Receiving and displaying data on rocket launches by SpaceX.
There are 3 screens in the app: "Past launches", "Upcoming launches" and "Detailed information about the last launch".
The application contains local storage of the received data and displaying them in the absence of the internet or in case of problems on the server.

**Stack:**  
Clean architecture, MVVM/MVI (implementations in different branches), Kotlin Coroutines, Hilt, Navigation, Room, Retrofit 2, Coil, ViewBinding.  

**The project is divided into several modules:**  
Presentation - responsible for ui. (Activity, Fragments, ViewModels, etc)  
Domain - business logic. (UseCases, Domain Models, Repository Interfaces, etc)  
Data - responsible for providing data. Contains the implementation of repositories from the Domain module and contracts for the Remote and Cache modules. (Repository Implementation, Source Interfaces, etc)  
Remote - networking. (Networking, Source Implementation, Remote Models, Mappres, etc)  
Cache - interaction with the database. (Working with DB, Source Implementation, Cache Models, Mappres, etc)  

Initial version, there will be improvements.
