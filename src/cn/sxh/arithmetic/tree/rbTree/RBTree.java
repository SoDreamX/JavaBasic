package cn.sxh.arithmetic.tree.rbTree;

/**
 * �����
 * @author Sxh
 * 2018��12��19�� ����11:46:14
 */
public class RBTree<T extends Comparable<T>> {
	//���ڵ�
	private RBNode<T> root;
	
	/**
	 * �Ժ�����ڵ�x������������
	 * ����ʾ��ͼ���Խڵ�x�������� 
	 *     p                       p 
	 *    /                       / 
	 *   x                       y 
	 *  / \                     / \ 
	 * lx  y      ----->       x  ry 
	 *    / \                 / \ 
	 *   ly ry               lx ly 
	 * �������������£� 
	 * 1. ��y�����ӽڵ㸳��x�����ӽڵ�,����x����y���ӽڵ�ĸ��ڵ�(y���ӽڵ�ǿ�ʱ) 
	 * 2. ��x�ĸ��ڵ�p(�ǿ�ʱ)����y�ĸ��ڵ㣬ͬʱ����p���ӽڵ�Ϊy(�����) 
	 * 3. ��y�����ӽڵ���Ϊx����x�ĸ��ڵ���Ϊy 
	 * @param x
	 */
	private void leftRotate(RBNode<T> x){
		//1. ��y�����ӽڵ㸳��x�����ӽڵ㣬����x����y���ӽڵ�ĸ��ڵ�(y���ӽڵ�ǿ�ʱ)
	    RBNode<T> y = x.right;
	    x.right = y.left;
	    if(y.left != null){
	        y.left.parent = x;
	    }
	     
	    //2. ��x�ĸ��ڵ�p(�ǿ�ʱ)����y�ĸ��ڵ㣬ͬʱ����p���ӽڵ�Ϊy(�����)
	    y.parent = x.parent;
	    if(x.parent == null){
	        this.root = y;//���x�ĸ��ڵ�Ϊ��(��xΪ���ڵ�)����y��Ϊ���ڵ�
	    }else{
	        if(x == x.parent.left){//���x�����ӽڵ�
	            x.parent.left = y;//��Ҳ��y��Ϊ���ӽڵ� 
	        }else{
	            x.parent.right = y;//����y��Ϊ���ӽڵ� 
	        }
	    }
	     
	    //3. ��y�����ӽڵ���Ϊx����x�ĸ��ڵ���Ϊy
	    y.left = x;
	    x.parent = y;
	}
	
	/*
	 * �Ժ�����ڵ�y������������
	 * ����ʾ��ͼ���Խڵ�y��������
	 *        p                   p
	 *       /                   /
	 *      y                   x
	 *     / \                 / \
	 *    x  ry   ----->      lx  y
	 *   / \                     / \
	 * lx  rx                   rx ry
	 * �������������£�
	 * 1. ��x�����ӽڵ㸳��y�����ӽڵ�,����y����x���ӽڵ�ĸ��ڵ�(x���ӽڵ�ǿ�ʱ)
	 * 2. ��y�ĸ��ڵ�p(�ǿ�ʱ)����x�ĸ��ڵ㣬ͬʱ����p���ӽڵ�Ϊx(�����)
	 * 3. ��x�����ӽڵ���Ϊy����y�ĸ��ڵ���Ϊx
	 */
	private void rightRotate(RBNode<T> y){
	    //1. ��y�����ӽڵ㸳��x�����ӽڵ㣬����x����y���ӽڵ�ĸ��ڵ�(y���ӽڵ�ǿ�ʱ)
	    RBNode<T> x = y.left;
	    y.left = x.right;
	    if(x.right != null){
	        x.right.parent = y;
	    }
	     
	    //2. ��x�ĸ��ڵ�p(�ǿ�ʱ)����y�ĸ��ڵ㣬ͬʱ����p���ӽڵ�Ϊy(�����)
	    x.parent = y.parent;
	    if(y.parent == null){
	        this.root = x;//���y�ĸ��ڵ�Ϊ��(��yΪ���ڵ�)������ת��x��Ϊ���ڵ�
	    }else{
	        if(y == y.parent.left){//���y�����ӽڵ�
	            y.parent.left = x;//��xҲ����Ϊ���ӽڵ�
	        }else{
	            y.parent.right = x;//����x����Ϊ���ӽڵ�
	        }
	    }
	     
	    //3. ��x�����ӽڵ���Ϊy����y�ĸ��ڵ���Ϊy
	    x.right = y;
	    y.parent = x;
	}
	/**
	 * ����ؼ���key�ڵ�
	 * @param key
	 */
	public void insert(T key){
	    RBNode<T> node = new RBNode<T>("R", key, null, null, null);
	    if(node != null){
	        insert(node);
	    }
	}
	/**
	 * ����ڵ�
	 * @param node
	 */
	public void insert(RBNode<T> node){
	    RBNode<T> current = null;//��ʾ���node�ĸ��ڵ�
	    RBNode<T> x = this.root;//������������
	     
	    //1.�ҵ�����λ��
	    while(x != null){
	        current = x;
	        int cmp = node.key.compareTo(x.key);
	        if(cmp < 0){
	            x = x.left;
	        }else{
	            x = x.right;
	        }
	    }
	    node.parent = current;//�ҵ��˲����λ�ã�����ǰcurrent��Ϊnode�ĸ��ڵ�
	     
	    //2.�������ж�node�����ӽڵ㻹�����ӽڵ�
	    if(current != null){
	        int cmp = node.key.compareTo(current.key);
	        if(cmp < 0){
	            current.left = node;
	        }else{
	            current.right = node;
	        }
	    }else{
	        this.root = node;
	    }
	     
	    //3.������ת������������Ϊһ�ź����
	    insertFixUp(node);
	}
	/**
	 * ����ת,��ɫ��������Ϊ�����
	 * @param node
	 */
	private void insertFixUp(RBNode<T> node){
	    RBNode<T> parent,gparent;//���常�ڵ���游�ڵ�
	     
	    //��Ҫ���������������ڵ���ڣ��Ҹ��ڵ����ɫ�Ǻ�ɫ
	    while(((parent = parentOf(node)) != null) && isRed(parent)){
	        gparent = parentOf(parent);//����游�ڵ�
	         
	        //�����ڵ����游�ڵ�����ӽڵ㣬�����else�෴
	        if(parent == gparent.left){
	            RBNode<T> uncle = gparent.right;//�������ڵ�
	             
	            //case1:����ڵ�Ҳ�Ǻ�ɫ
	            if(uncle != null && isRed(uncle)){
	                setBlack(parent);//�Ѹ��ڵ������ڵ�Ϳ��
	                setBlack(uncle);
	                setRed(gparent);//���游�ڵ�Ϳ��
	                node = gparent;//��λ�÷ŵ��游�ڵ㴦
	                continue;//����whileѭ���������ж�
	            }
	             
	            //case2:����ڵ��Ǻ�ɫ���ҵ�ǰ�ڵ������ӽڵ�
	            if(node == parent.right){
	                leftRotate(parent);//�Ӹ��ڵ㴦����
	                RBNode<T> tmp = parent;//Ȼ�󽫸��ڵ���Լ�����һ�£�Ϊ����������׼��
	                parent = node;
	                node = tmp;
	            }
	             
	            //case3:����ڵ��Ǻ�ɫ���ҵ�ǰ�ڵ������ӽڵ�
	            setBlack(parent);
	            setRed(gparent);
	            rightRotate(gparent);
	        }else{//�����ڵ����游�ڵ�����ӽڵ㣬������������ȫ�෴��������һ����
	            RBNode<T> uncle = gparent.left;
	             
	            //case1:����ڵ�Ҳ�Ǻ�ɫ��
	            if(uncle != null && isRed(uncle)){
	                setBlack(parent);
	                setBlack(uncle);
	                setRed(gparent);
	                node = gparent;
	                continue;
	            }
	             
	            //case2:����ڵ��Ǻ�ɫ�ģ��ҵ�ǰ�ڵ������ӽڵ�
	            if(node == parent.left){
	                rightRotate(parent);
	                RBNode<T> tmp = parent;
	                parent = node;
	                node = tmp;
	            }
	             
	            //case3:����ڵ��Ǻ�ɫ�ģ��ҵ�ǰ�ڵ������ӽڵ�
	            setBlack(parent);
	            setRed(gparent);
	            leftRotate(gparent);
	        }
	    }
	    setBlack(root);//�����ڵ�����Ϊ��ɫ
	}

	private void setRed(RBNode<T> parent) {
		parent.color = "R";
	}

	private void setBlack(RBNode<T> parent) {
		parent.color = "B";
	}

	private boolean isRed(RBNode<T> parent) {
		return "R".equals(parent.color);
	}

	private RBNode<T> parentOf(RBNode<T> node) {
		return node.parent;
	}
	/**
	 * �������:���������������ڵ㡪����������
	 */
	public void infixOrder(RBNode<T> current) {
		if(current != null) {
			infixOrder(current.left);
			System.out.print(current.toString()+"-->");
			infixOrder(current.right);
		}
	}

	public RBNode<T> getRoot() {
		return root;
	}
}
