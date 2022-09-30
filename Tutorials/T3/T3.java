import java.util.Random;

public class T3{

    // some names to use
    public static String[] class_list = {"Aaron","Aaryan","Abaseen","Abdul","Abdullah","Abdulrahman","Abdulrahman","Abdurahman","Abhijeet","Adam","Ahmad","Aiden","Alameen","Alessia","Alexander","Alexis","Alexis","Alex","Alex","Alex","Alex","Ali","Alisha","Allan","Alvin","Amber","Amine","Amira Jumoke","Anastasiia","Andreas","Andrew","Andrey","Annas","Ansh","Anthony","Antonio","Arda","Ashok","Athira","Aung Kyaw","Avery","Aya","Benjamin","Benjamin","Berdlens","Blake","Boris","Bowen","Braden","Brendan","Brian","Bronwyn","Bryson","Byron","Callie","Calvin","Cameron","Catalina","Catherine","Charlie","Charlotte","Chinedu","Clara","Cody","Cole","Cole","Cole","Colin","Connor","Dalton","Damon","Daniel","Daniel","Daniel","David","David","David","Dhirran","Don","Dylan","Earle","Edward","El-Amine","Elliot","Elsie","Emily","Emily","Eric","Eric","Erin","Ethan","Ethan","Evan","Evan","Evan","Everett","Fatima","Favour","Fawaz","Federico","Francesca","Galine","Garrison","Giovanni","Giselle","Hamda","Hammad","Hang","Harley","Hassan","Haun","Hayden","Hayli","Heath","Hunter","Malla","Ijeoma","Isaac","Bella","Jackson","Jackson","Jacob","Jacob","Jade","Jaewon","James","Jarnail","Jason","Jason","Jasper","Jearina","Jeremy","Jillson","Joe","Joey","Josh","Josh","Josh","Joshua","Joyee","Juliana","Julien","Justice","Justin","Justin","Kaleb","Karim","Katiana","Kayla","Keith-Luke","Kendra","Kensley","Ken","Kevin","Kevin","Keziah","Khaled","Khushie","Kiara","Kien","Kolton","Krystian","Layan","Leah","LeeAnne","Leila","Liam","Liam","Liam","Louis-Victor","Luka","Luka","Maddy","Marcel","Mark","Marko","Marwan","Mathew","Matteo","Matteo","Matthew","Matthieu-Jean","Maya","Melissa","Melissa","Mengyuan","Michael","Michael","Michel","Miguel","Mireille","Mohammad","Mohammed","Mustafa","Myo Pyae Sone","Naa Akuyea","Naz","Ngozi","Nick","Nick","Nina","Noah","Noah","Noah","Nour","Oluwadara","Omar","Omer Faruk","Osato","Owen","Paing Zay","Parsa","Rose","Raahim","Rachel","Rayyan","Rhys","Ridley","Ridwan","Ross","Ruby","Ryan","Ryan","Ryan","Ryan","Saad","Samarth","Sameer","Sam","Sara","Sean","Seniha","Sergey","Shaojie","Shirley","Sibte","Sifan","Stella","Stephanie","Tabion","Taifeng","Tanner","Taseen","Teague","Thomas","Thomas","Thomas","Tobiloba","Tonny","Torben","Trista","Usama","Valerie","Victor","Victor","Vidun","Vivian","Vivian","Vivian","Will","Xavier","Xianheng","Xuan Nam","Leo","Yordan","Youssef","Youssef","Yousuf","Yufan","Yufeng","Yumna","Yuxiao","Zach","Zach","Zhengning","Zhewei","Zhi","Zhuoran"};


    public static void stringFormatting(int size){
        
        // Random object for random numbers
        Random rnd = new Random();  
        
        // allocate memory for some arrays
        String[] names = new String[size];
        int[]    ages = new int[size];
        double[] values = new double[size];

        // populate the arrays
        for(int i=0; i<size; i+=1){
            names[i] = class_list[rnd.nextInt(class_list.length)];
            ages[i] = rnd.nextInt(2000)+ 17;
            values[i] = (rnd.nextInt(100)-50)*Math.sin(rnd.nextDouble());
        } 

        // display the data
        for(int i=0; i<size; i+=1){
            System.out.println(String.format("%s %d %f",names[i], ages[i], values[i]));
        } 
        

    }

    public static void main(String[] args){
      // command line arguments to set size of data set
      
      // if no command line argument is given use 12
      int size = 12;
      if(args.length > 0){
         size = Integer.parseInt(args[0]);
      } 

      stringFormatting(size);

    }

}