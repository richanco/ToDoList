package model;

public class ToDo {
   private int id;
   private String name;
   private int progress;
   
   public ToDo(int id,String name,int progress) {
	   this.id = id;
	   this.name = name;
	   this.progress = progress;
   }
   
   public int getId() {return id;}
   public String getName() {return name;}
   public int getProgress() {return progress; }
}
