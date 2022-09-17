import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt(); //no. of testcases
        while(t-->0) {
            int size = scan.nextInt();
            int[] nums = new int[size];
            for(int i =0;i<size;i++)
                nums[i] = scan.nextInt();
            Tree binaryTree = new Tree();
            binaryTree.insert(nums);
            List<List<Integer>> list = binaryTree.verticalTraversal();
            for (List<Integer> temp : list)
                System.out.println(temp);
        }
    }
}

 class TreeNode{
    private final int data;
    private TreeNode leftChild;
    private TreeNode rightChild;
    public TreeNode(int data){
        this.data=data;
    }
     public void insert(Queue<TreeNode> queue,int val1,int val2) {
         if(leftChild==null&&val1!=0) {
                 leftChild = new TreeNode(val1);
                 queue.add(leftChild);
         }
         if(rightChild==null&&val2!=0) {
                 rightChild = new TreeNode(val2);
                 queue.add(rightChild);
         }
     }

     public int getData() {
         return data;
     }

     public TreeNode getLeftChild() {
         return leftChild;
     }

     public TreeNode getRightChild() {
         return rightChild;
     }
 }

class Tree{
    private TreeNode root;
    public void insert(int[] nums) {
            root=new TreeNode(nums[0]);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int i=1;
            while (!queue.isEmpty()) {
                TreeNode presentNode = queue.remove();
                presentNode.insert(queue,nums[i++],nums[i++]);
                if(i==nums.length)
                    break;
            }
    }

    Map<Integer,ArrayList<int[]>> map;
    public List<List<Integer>> verticalTraversal() {
        List<List<Integer>> res = new ArrayList<>();
        map = new HashMap<>();
        preOrder(root,0,0);
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for(int key:keys)
        {
            ArrayList<int[]> list = map.get(key);
            list.sort(new ArrayComparator());
            ArrayList<Integer> a = new ArrayList<>();
            for(int[] x: list)
                a.add(x[0]);
            res.add(a);
        }
        return res;
    }

    private void preOrder(TreeNode root,int col,int row)
    {
        if(root==null)
            return;
        if(map.get(col)==null)
        {
            ArrayList<int[]> temp = new ArrayList<>();
            temp.add(new int[]{root.getData(),row});
            map.put(col,temp);
        }
        else
        {
            map.get(col).add(new int[]{root.getData(),row});
        }
        preOrder(root.getLeftChild(),col-1,row+1);
        preOrder(root.getRightChild(),col+1,row+1);
    }
}
class ArrayComparator implements Comparator<int[]>{
    public int compare(int[] a,int[] b)
    {
        if(a[1]==b[1])
            return Integer.compare(a[0],b[0]);
        else
            return Integer.compare(a[1],b[1]);
    }
}