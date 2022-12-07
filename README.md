# **1. Pricipe de base d'une application client serveur avec les sockets**  
---  
---
---
# Coté serveur  
---

### **1. Création des objets ServerSockets** :  

> ServerSocket ss = new ServerSocket(Port);  

    ServerSocket est un objet qui attend le cleint demender une connextion  
### **2. La méthode accept() de l'objet ServerSocket** :  

> Socket s =  ss.accept();  


    Une fois que le client demende une connection la méthode accept s'éxécute , et elle retourne un objet de type Socket qui contient des informations sur le client   
L'objet Socket que la méthode accept retourne contient 2 méthodes :  

1. __getInputStream()__ 
> **InputSteam is = s.getInputStream()**  

    La méthode getInputStream retourne un objet de type InputStream , cet objet avec lequel nous pouvons lire les données envoyées par le client .
> **int nb = is.read()**  
>  **int rep = nb*2;** 

    ici le client envoie au serveur un nombre qu'on a stocker dans une variable nb , et puis on le multipler par 2 .  

    La méthode read() attend que le client m'envoie un octet 
2. __getOutPutStream()__
> **getOutputStream os = s.getOutputStream()**  
La méthode getOutputStream retourne un objet de type OutputStream , cet objet avec lequel nous pouvons écrie des données pour envoyées par le client .  

> **os.write(rep)**  

    Envoyé la réponse au client
---  
---
---
# Coté client  
---
> Socket s = new Socket("192.168.10.2",port)  

    ici on a crée une socket , et comporte comme paramétres 2 arguments : 
    1. L'adresse ip de serveur .
    2. Le port de serveur .

    une fois qu'on a crée l'objet Socket , automatiquement ce dernier envoie une demende de connection au serveur (Le protocoele tcp qui va faire ça) , puis la méthode accept() au serveur s'éxécute .

    L'objet Socket va aussi générer duex méthode :  
1. __getInputStream()__ 
> **InputSteam is = s.getInputStream()** 

    Les objets envoyée par le client avec la méthode getInputStream() vont être reçue par le serveur avec la méthode getOutputStream()
    

2. __getOutPutStream()__
> **getOutputStream os = s.getOutputStream()**  

    Les objets reçue par le client avec la méthode getOutputStream() vont être envoyée par le serveur avec la méthode getInputStream()
> **os.write(23)**  

    ici le client envoie au serveur le nombre 23  
    
    

![CoursSocket](image.png)
    





