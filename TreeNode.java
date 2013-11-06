package lib;

public class TreeNode {
	public int data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	private int size=0;
	
	public TreeNode(int value){
		data=value;
		size=1;
	}
	
	public void SetLeftChild(TreeNode T){
		left=T;
		if(left!=null){
			left.parent=this;
		}
	}
	public void SetRightChild(TreeNode T){
		right=T;
		if(right!=null){
			right.parent=this;
		}
	}
	public void InsertOrder(int v){
		TreeNode tn= new TreeNode(v); 
		if(v<data){
			if(left==null){
				SetLeftChild(tn);
			}
			left.InsertOrder(v);
		}
		else{
			if(right==null){
				SetRightChild(tn);
			}
			right.InsertOrder(v);
		}
	}
	public int Size(){
		return size;
	}
	public boolean isBst(){
		if(left!=null){
			if(data>left.data || !left.isBst()){
				return false;
			}
		}
		if(right!=null){
			if(right!=null){
				if(data<right.data || right.isBst()){
					return false;
				}
			}
		}
		return true;
	}
	public TreeNode find(int v){
		if(v==data){
			return this;
		}
		else if(v<data){
			return left!=null ? left.find(v) : null;
		}
		else if(v>data){
			return right!=null ? right.find(v):null;
		}
		return null;
	}
	public int height(){
		int leftheight=left!=null ? left.height() : 0;
		int rightheight=right!=null ? right.height():0;
		return 1+Math.max(leftheight, rightheight);
	}
	
}
