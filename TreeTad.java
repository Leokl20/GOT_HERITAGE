
public interface TreeTad{
    public Tree getparent();
    public String getitem();
    public void  addChild(Tree tree);
    public void addChild(int index, Tree tree);
    public Tree removeChild(int index);
    public Tree getChild(int index);
    public int childrenCount();
    public int size();

}