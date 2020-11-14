package com.xqc.RBTree;
/**
 * 
 * @ClassName:RBTree.java
 * @Author qcxiao
 * @Date:2020��8��9������3:45:56
 * @Version:1.0
 * @Description:��������ݽṹ����
 */
public class RBTree {
	//��ɫ
	private final int R=0;
	//��ɫ
	private final int B =1;
	//���ĸ��ڵ�
	private Node root;
	
	class Node{
		int data;
		int color = R;//�ʼ��Ϊ��ɫ
		Node left;
		Node right;
		Node parent;
		public Node (int data) {
			this.data = data;
		}
		
	}
	/**
	* 
	* @Function: RBTree.java
	* @Description: ��������
	*
	* @Return Type:void
	* @Parament:
	* @Throws���쳣����
	*
	* @Version: v1.0.0
	* @Author : qcxiao
	* @Date:2020��8��9�� ����4:07:52
	 */
	private void insert(Node root,int data){
		//����ȸ��ڵ�󣬲���������
		if(root.data< data){
			//���������Ϊ�գ�ֱ�Ӳ���
			if(root.right == null){
				root.right = new Node(data);
			}else{
				insert(root.right,data);
			}
		}else{
			if(root.left == null){
				root.left = new Node(data);
			}else{
				insert(root.left, data);
			}
			
		}
	}
	
	/**
	 * 
	* @Function: RBTree.java
	* @Description: ����
	*
	* @Return Type:void
	* @Parament:
	* @Throws���쳣����
	*
	* @Version: v1.0.0
	* @Author : qcxiao
	* @Date:2020��8��9�� ����4:29:34
	 */
	private void leftRotate(Node node) {
		//���nodeû�и��ڵ㣬ֻ��Ҫ����������
		if(node.parent == null){
			//ȡ�ø��ڵ���������ڵ�
			Node right = root.right;
			//�����ڵ����ָ��ָ���ҽڵ��������
			root.right = right.left;
			
			right.left.parent = root;
			root.parent=right;
			right.parent = null;
		}else{
			
		}

	}
	
	

}
