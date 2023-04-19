import java.util.*;

public class Main {
    public static void main(String[] args) {


        FileNavigator fileManager = new FileNavigator();
        fileManager.add( "E:\\SimCamp", new FileData("Sky", 3890,"E:\\SimCamp"));
        fileManager.add("D:\\SimCamp", new FileData( "Sea" ,3834, "D:\\SimCamp"));
        fileManager.add("C:\\SimCamp",  new FileData( "Text ", 3452, "C:\\SimCamp"));
        fileManager.add("E:\\NewFolder",  new FileData( "Family", 3810, "E:\\NewFolder"));
        fileManager.add("E:\\NewFolder",  new FileData( "Holiday", 3850, "E:\\NewFolder"));
        fileManager.add("D:\\SimCamp",  new FileData( "Journey", 3899, "E:\\NewFolder"));
        fileManager.add("E:\\NewFolder",  new FileData( "Work", 3802, "E:\\NewFolder"));
        fileManager.add("E:\\SimCamp",  new FileData( "Sport", 3833, "E:\\NewFolder"));
        fileManager.add("C:\\SimCamp",  new FileData( "Leisure", 3812, "C:\\SimCamp"));
        fileManager.add("F:\\Recycler",  new FileData( "Bad", 3543, "F:\\Recycler"));
        fileManager.add("F:\\Recycler",  new FileData( "TheWorst", 3643, "F:\\Recycler"));
        System.out.println(fileManager.filterBySize());
        System.out.println(fileManager.remove("F:\\Recycler"));
        System.out.println(fileManager.filterBySize());
        System.out.println(fileManager.filterBySize(3812));
        System.out.println(fileManager.find("C:\\SimCamp"));


    }
}