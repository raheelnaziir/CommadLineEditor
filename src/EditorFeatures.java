
abstract class EditorFeatures {
	
	public abstract void createNewFile(String fileName);
    public abstract void openFile(String fileName);
    public abstract void editFile(String fileName);
    public abstract void saveFile(String fileName, String content);

}
