package com.amirportfolio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Input {

    public void getString(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your code.");
        String code = "";
        StringBuilder sb = new StringBuilder();
        while(!code.equalsIgnoreCase("End")){
            sb.append(code).append("\n");
            code=in.nextLine();
        }

        try{
//            new RandomAccessFile("C:\\Users\\amirh\\IdeaProjects\\BasicOS\\src\\com\\amirportfolio\\Application.java", "rw").setLength(0);
            RandomAccessFile raf = new RandomAccessFile("C:\\Users\\amirh\\IdeaProjects\\BasicOS\\src\\com\\amirportfolio\\Application.java", "rw");
            new RandomAccessFile("C:\\Users\\amirh\\IdeaProjects\\BasicOS\\src\\com\\app\\Application.java", "rw").setLength(0);

            raf.seek(0);
            String headLine = "package com.amirportfolio;";
            String classMethod = "class Application{\n\tpublic void mainBody(){";
            raf.write((headLine + "\n\n" + classMethod).getBytes());
            raf.write(("\n\t\t"+sb.toString()).getBytes());
            raf.write("\n\t}\n}".getBytes());
            raf.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void flush(){
        try{
            new RandomAccessFile("C:\\Users\\amirh\\IdeaProjects\\BasicOS\\src\\com\\amirportfolio\\Application.java", "rw").setLength(0);
//            new RandomAccessFile("C:\\Users\\amirh\\IdeaProjects\\BasicOS\\src\\com\\app\\Application.java", "rw").setLength(0);
            String headLine = "package com.amirportfolio;\n\n";
            String classMethod = "\tclass Application{\n\tpublic void mainBody(){\n\n\n\t}\n}";
            RandomAccessFile raf = new RandomAccessFile("C:\\Users\\amirh\\IdeaProjects\\BasicOS\\src\\com\\amirportfolio\\Application.java", "rw");
            raf.write((headLine+classMethod).getBytes());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
