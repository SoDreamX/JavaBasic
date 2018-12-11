package cn.sxh.arithmetic.tree.binaryTree;

public class BinaryTree implements Tree {
	//根节点
	Node root;

	@Override
	public Node find(int value) {
		Node current = root;
		while(current!=null) {
			if(value == current.getData()) {
				break;
			}else if(value < current.getData()) {
				current = current.getLeftNode();
			}else {
				current = current.getRightNode();
			}
		}
		return current;
	}

	@Override
	public boolean insert(int value) {
		boolean flag = false;
		Node newNode = new Node(value);
		if(root == null) {
			root = newNode;
			flag = true;
		}else {
			Node current = root;
			Node parentNode = null;
			while(current != null) {
				parentNode = current;
				if(value == current.getData()) {
					break;
				}else if(value < current.getData()) {
					current = current.getLeftNode();
					if(current == null) {
						parentNode.setLeftNode(newNode);
					}
					flag = true;
				}else {
					current = current.getRightNode();
					if(current == null) {
						parentNode.setRightNode(newNode);
					}
					flag = true;
				}
			}
		}
		return flag;
	}
	/**
	 * 中序遍历:左子树——》根节点——》右子树
	 */
	@Override
	public void infixOrder(Node current) {
		if(current != null) {
			infixOrder(current.getLeftNode());
			System.out.print(current.display()+"-->");
			infixOrder(current.getRightNode());
		}
	}
	/**
	 * 前序遍历:根节点——》左子树——》右子树
	 */
	@Override
	public void preOrder(Node current) {
		if(current != null) {
			System.out.print(current.display()+"-->");
			preOrder(current.getLeftNode());
			preOrder(current.getRightNode());
		}
	}
	/**
	 * 后序遍历:左子树——》右子树——》根节点
	 */
	@Override
	public void postOrder(Node current) {
		if(current != null) {
			postOrder(current.getLeftNode());
			postOrder(current.getRightNode());
			System.out.print(current.display()+"-->");
		}
	}

	@Override
	public Node findMax() {
		Node maxNode = null;
		Node current = root;
		while(current != null) {
			maxNode = current;
			current = current.getRightNode();
		}
		return maxNode;
	}

	@Override
	public Node findMin() {
		Node minNode = null;
		Node current = root;
		while(current != null) {
			minNode = current;
			current = current.getLeftNode();
		}
		return minNode;
	}

	@Override
	public boolean delete(int value) {
		boolean flag = false;
		Node current = root;
        Node parent = root;
        boolean isLeftChild = false;
        //先查到待删除数据
        while(current.getData()!=value) {
        	parent = current;
        	if(value < current.getData()) {
        		isLeftChild = true;
        		current = current.getLeftNode();
        	}else {
        		isLeftChild = false;
        		current = current.getRightNode();
        	}
        	if(current == null){
                return false;
            }
        }
        //如果当前节点没有子节点
        if(current.getLeftNode()==null && current.getRightNode()==null) {
        	if(current == root) {
        		root = null;
        	}else if(isLeftChild) {
        		parent.setLeftNode(null);
        	}else {
        		parent.setRightNode(null);
        	}
        	flag = true;
        //如果当前节点只没有左节点
        }else if(current.getLeftNode()==null && current.getRightNode()!=null) {
        	if(current == root) {
        		root = current.getRightNode();
        	}else if(isLeftChild) {
        		parent.setLeftNode(current.getRightNode());
        	}else {
        		parent.setRightNode(current.getRightNode());
        	}
        	flag = true;
        //如果当前节点只没有右节点
        }else if(current.getLeftNode()!=null && current.getRightNode()==null) {
        	if(current == root) {
        		root = current.getLeftNode();
        	}else if(isLeftChild) {
        		parent.setLeftNode(current.getLeftNode());
        	}else {
        		parent.setRightNode(current.getLeftNode());
        	}
        	flag = true;
        }else {
        	//两个节点均不为空
        	//后继节点-比删除节点大的最小节点
        	Node successor = getSuccessor(current);
        	if(current == root){
                successor = root;
            }else if(isLeftChild){
                parent.setLeftNode(successor);
            }else{
                parent.setRightNode(successor);
            }
            successor.setLeftNode(current.getLeftNode());
        	flag = true;
        }
		return flag;
	}
	/**
	 * 查找删除节点的后继节点
	 * @param delNode
	 * @return
	 */
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.getRightNode();
        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.getLeftNode();
        }
        //后继节点不是删除节点的右子节点，将后继节点替换删除节点
        if(successor != delNode.getRightNode()){
            successorParent.setLeftNode(successor.getRightNode());
            successor.setRightNode(delNode.getRightNode());
        }
		return successor;
	}

	public void draw() {
		System.out.println("Binary Tree:");
		printInOrder(root, 0, "H", 10);
	}
	
	public void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.getRightNode(), height + 1, "v", len);
        String val = "[" + head.getData() + "]";
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.getLeftNode(), height + 1, "^", len);
    }

	private String getSpace(int num) {
		String space = "-";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
	}
}
