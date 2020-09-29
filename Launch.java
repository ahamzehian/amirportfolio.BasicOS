package com.amirportfolio;

import java.io.*;
import java.util.Scanner;

class Launch{
  
  Scanner in = new Scanner(System.in);

  public Application setApp(){
    Input input = new Input();
    input.flush();
    input.getString();
    return new Application();
  }
  
  public void operation(){
    do{
      setApp().mainBody();
    }while(repeat());
    new Input().flush();
  }
  
  public boolean repeat(){
    System.out.println("Do you wish to repeat? y/n");
    String answer = in.nextLine();
    answer = correctAnswer(answer);
    
    if(answer.equalsIgnoreCase("Y"))
      return true;
    else
    close();
    
      return false;
  }
  
  public String correctAnswer(String answer){
    boolean doAgain;
    do{
      try{
        answer = checkAnswer(answer);
        doAgain = false;
      }catch(AnswerException ae){
        System.out.println("Error 001: Unacceptable input.\nPlease use only letters Y/N");
        System.out.println("Do you proceed? y/n");
        answer = in.nextLine();
        doAgain = true;
      }
    }while(doAgain);
    return answer;
  }
  
  public String checkAnswer(String answer) throws AnswerException{
    if(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N")){
        return answer;
      }else{
        throw new AnswerException();
      }
  }
  
  public void close(){
    System.out.println("Do you want to save? y/n");
    String answer = in.nextLine();
    answer = correctAnswer(answer);
    if(answer.equalsIgnoreCase("Y")){
      System.out.println("Enter a name for your file.");
      String name = in.nextLine();
      try{
        RandomAccessFile rafw = new RandomAccessFile("SavedFiles.txt", "rw");
        RandomAccessFile rafr = new RandomAccessFile("C:\\Users\\amirh\\IdeaProjects\\BasicOS\\src\\com\\amirportfolio\\Application.java","r");
        rafr.seek(0);
        byte[] bytes = new byte[(int)rafr.length()];
        rafr.read(bytes);
        StringBuilder result = new StringBuilder();
        for(byte b:bytes)
          result.append((char)b);
        rafr.close();
        rafw.seek(rafw.length());
        rafw.write(("//"+name + "-------------------\n\n"+result.toString()+"\n\n").getBytes());
        rafw.close();

      }catch(IOException e){
        System.out.println("Error 003: Failed to save! " + e.getMessage());
        e.printStackTrace();
      }
      
      System.out.println("File is saved!");
    }else{
      System.out.println("Thank you");
    }
  }
}