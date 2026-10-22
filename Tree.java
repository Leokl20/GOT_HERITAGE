import java.util.ArrayList;


public class Tree implements TreeTad{

    private ArrayList<Tree> children;
    private Tree parent;
    private String item;

    public Tree(String item){
        this.item=item;
        this.parent=null;
        this.children = new ArrayList<>();
    }

    public Tree getparent(){
        return this.parent;
    }

    public String getitem(){
        return this.item;
    }
    public void  addChild(Tree tree){
        tree.parent= this;
        this.children.add(tree);

    }
    public void addChild(int index, Tree tree){
        tree.parent= this;
        this.children.add(index, tree);
    }

    public Tree removeChild(int index){
       Tree removed= this.children.remove(index);
       removed.parent= null;
       return removed;
    }
    public Tree getChild(int index){
        return this.children.get(index);
    }
    public int childrenCount(){
        return this.children.size();
    }

   public int size(){//não entendi como ela funciona na prática *PERGUNTAR PARA O HENRY*
    int count = 1;
    for (int i = 0; i < this.children.size(); i++) {
        Tree child = this.children.get(i);
        count += child.size();
    }
    return count;
}
/*       

        A
       / \
      B   C
     / \
    D   E               */
       

}
