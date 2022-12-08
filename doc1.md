# Serveur multi-Threads avec IO Bloquantes :   

    Pour qu'un serveur puisse communiquer avec plusieurs clients en même temps , il fault que : 
    1. Le serveur puisee attendre une connexion à tout moment .
    2. Pour chaque connexion , il fault créer un nouveau thread associé à la socket du client connecté , puis attendre à nouveau une connexion .
    3. Le thread crée doit s'occuper des opérations d'entées-sorties(read/write) pour communiquer avec le client indépendamment des autres activitées de serveur .  
![Image3](/Part%203%20-%20Programmation%20R%C3%A9seaux%20-%20Mise%20en%20oeuvre%20des%20applications%20Client%20serveur%2026-42%20screenshot.png)

  
