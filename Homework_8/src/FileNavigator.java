import java.util.*;
import java.util.Collections;

public class FileNavigator {

  private Map <String, List<FileData>> totalityName;

  public FileNavigator() {
    this.totalityName = new HashMap<>();
  }

  public void add (String path, FileData file){
    if(file.getPath().equals(path)) {
     if (!totalityName.containsKey(path)) {
       List<FileData> newFile = new ArrayList<>();
       newFile.add(file);
       totalityName.put(path, newFile);
     } else {
       List<FileData> existList = totalityName.get(path);
       existList.add(file);
     }
   } else {
     System.out.println("Unfortunately, we found a mismatch between tne "+ path +" and the "+ file.getPath() +". Please check and add again");
   }

  }
  public List <FileData>  find (String path){
     return totalityName.get(path);
  }

  public List <FileData> filterBySize (int size){
    List<FileData> filesInterval = new ArrayList<>();
    for(Map.Entry<String, List <FileData>> searcher : totalityName.entrySet()){
      for(  FileData file : searcher.getValue()) {
         if (file.getSizeByte() <= size){
           filesInterval.add(file);
         }
      }
    }
    return filesInterval;
    }

  public boolean remove (String path) {
    for (Iterator<String> cleaner = totalityName.keySet().iterator(); cleaner.hasNext(); ) {
      String key = cleaner.next();
      if (Objects.equals(key, path)) {
        cleaner.remove();
        return true;
      }
    }
    return false;
  }
  public List <FileData> filterBySize (){
    List<FileData> sortedFiles = new ArrayList<>();
    for(Map.Entry<String, List <FileData>> sorter : totalityName.entrySet()){
      for(  FileData file : sorter.getValue()) {
        sortedFiles.add(file);
      }
    }
    Collections.sort(sortedFiles);
    return sortedFiles;
  }

  @Override
  public String toString() {
    return "FileNavigator{" +
            "totalityName=" + totalityName +
            '}';
  }

  public Map<String, List<FileData>> getTotalityName() {
    return totalityName;
  }

  public void setTotalityName(Map<String, List<FileData>> totalityName) {
    this.totalityName = totalityName;
  }
}
