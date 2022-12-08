# Recevoir et envoyer des chaînes de charactères :  
### Création de l'objet ServerSocket  
----  
`SeverSocket ss = new ServerSocket();` 
### Attendre une connexion d'un client   
`Socket s = ss.Accept();` 
### Pour lire une chaîne de charactère envoyée par le client  
`InputStream is = s.getInputStream();`  
`InputStreamReader isr = new InputStreamReader(is);`
`BufferReader br = new BufferReader(isr);`

!["image"](/Octet%20N%C2%B01.png)  
 ### Pour envoyée une chaîne de characère à un client  
 `OutputStream os = s.getOutPutStream();`  
 `printWriter pw = new printWriter(os,true);`  
    
    L'objet printWriter prend deux paramétres , le duexiéme paramétre , est un booléan , si le paramétre est égale à true , alors le steam va envoyée la chîne de charactère au client , mais si false , le stream va stocker la chaîne de charactère dans un buffer , (le stream stocke les chînes de charactères par println()), et pour les envoyer , le stream utilise la méthode flush() . 
 `pw.println("chaîne de charactère que je voudrais envoyer")`  
 !["image"](/Octet%20N%C2%B01%20(1).png)





