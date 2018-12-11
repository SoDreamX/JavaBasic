package cn.sxh.arithmetic.tree.binaryTree;

public class BinaryTree implements Tree {
	//���ڵ�
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
	 * �������:���������������ڵ㡪����������
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
	 * ǰ�����:���ڵ㡪����������������������
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
	 * �������:���������������������������ڵ�
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
        //�Ȳ鵽��ɾ������
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
        //�����ǰ�ڵ�û���ӽڵ�
        if(current.getLeftNode()==null && current.getRightNode()==null) {
        	if(current == root) {
        		root = null;
        	}else if(isLeftChild) {
        		parent.setLeftNode(null);
        	}else {
        		parent.setRightNode(null);
        	}
        	flag = true;
        //�����ǰ�ڵ�ֻû����ڵ�
        }else if(current.getLeftNode()==null && current.getRightNode()!=null) {
        	if(current == root) {
        		root = current.getRightNode();
        	}else if(isLeftChild) {
        		parent.setLeftNode(current.getRightNode());
        	}else {
        		parent.setRightNode(current.getRightNode());
        	}
        	flag = true;
        //�����ǰ�ڵ�ֻû���ҽڵ�
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
        	//�����ڵ����Ϊ��
        	//��̽ڵ�-��ɾ���ڵ�����С�ڵ�
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
	 * ����ɾ���ڵ�ĺ�̽ڵ�
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
        //��̽ڵ㲻��ɾ���ڵ�����ӽڵ㣬����̽ڵ��滻ɾ���ڵ�
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
