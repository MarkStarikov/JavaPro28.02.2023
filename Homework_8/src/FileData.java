public class FileData implements Comparable<FileData>{

    private String name;
    private int sizeByte;
    private String path;

    public FileData(String name, int sizeByte, String path) {
        this.name = name;
        this.sizeByte = sizeByte;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSizeByte() {
        return sizeByte;
    }

    public void setSizeByte(int sizeByte) {
        this.sizeByte = sizeByte;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public int compareTo(FileData bytes) {
        return this.sizeByte - bytes.getSizeByte();
    }

    @Override
    public String toString() {
        return "\n{" +
                "name='" + name + '\'' +
                ", sizeByte= " + sizeByte +
                ", path='" + path + '\'' +
                "}";

    }
}
