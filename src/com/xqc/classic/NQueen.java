package com.xqc.classic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author xqc
 * @data 2020��4��1��
 * Description:
 * ��һ��N*N�ľ����н�n�����ڲ�ͬ�в�ͬ�в�ͬ��б��λ��
 * ʹ�û����㷨���ӿ�ʼ��һ���ʺ��ж���һ�����������һֱ������Ǿ���һ�ַ���
 * ������ܵ���󣬾ͽ���һ��λ�õĻʺ���'.',�ı�ûʺ��λ��
 */
public class NQueen {
	
	public static void main(String[] args) {
		List<List<String>> result = GetNQueens(4);
		for (List<String> list : result) {
			for (String string : list) {
				System.out.println(string);
			}

		}

	}

	private static List<List<String>> GetNQueens(int n) {
		//���
		List<List<String>> res = new ArrayList<>();
		//����char[][]��ʾ��ά��ͼ��
		char[][] board = new char[n][n];
		//��ʼ������boardȫ����ɡ�,��
		init(board);
		//���ݵ�help����
		helper(res,board,0);
		return res;
	}

	private static void init(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			Arrays.fill(board[i], '.');
		}
		
	}

	private static void helper(List<List<String>> res, char[][] board, int rowIndex) {
		//������Ա�������󣬾ͽ���ͼ���뵽resͼ������
		if(rowIndex==board.length){
			res.add(gengerate(board));
			return;
		}
		//�д�0��ʼ
		for (int colIndex = 0; colIndex < board.length; colIndex++) {
			//�������ͬһ�У����ڶԽ���
			if(isValid(board,rowIndex,colIndex)){
				//�ͰѸ�λ�÷��ϻʺ�
				board[rowIndex][colIndex]='Q';
				//ȥ����һ���ط��Ļʺ�
				helper(res,board,rowIndex+1);
				//���˸ĳɡ�.��
				board[rowIndex][colIndex]='.';
			}
			
		}
		
	}
	
	private static boolean isValid(char[][] board, int rowIndex, int colIndex) {
		//���е���һ�����лʺ�ͳ�ͻ�ˣ�����false
		for (int i = 0; i < rowIndex; i++) {
			if(board[i][colIndex]=='Q')return false;
		}
		//�����ϵ����µĶԽ�������лʺ󣬷���false
		for (int i = rowIndex-1,j=colIndex-1; i >=0 && j>=0; i--,j--) {
			if(board[i][j]=='Q')return false;
		}
		//�����ϵ����µĶԽ�������лʺ󣬷���false��
		for (int i = rowIndex-1,j=colIndex+1; i >=0 && j<board.length; i--,j++) {
			if(board[i][j]=='Q')return false;
		}
		//��û�У�����true
		return true;
	}

	//��char[][]����list<string>
	private static List<String> gengerate(char[][] board) {
		List<String> list = new ArrayList<>();
		for (char[] row : board) {
			StringBuilder sb = new StringBuilder();
			for (char c : row) {
				sb.append(c);
			}
			list.add(sb.toString());
		}
		
		return list;
	}
	
	
	

}
