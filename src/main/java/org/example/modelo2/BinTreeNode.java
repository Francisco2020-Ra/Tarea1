package org.example.modelo2;

public class BinTreeNode {

	//BinTreeNode left, right; --> es sinonimo a la codificacion de la linea siguiente
	BinTreeNode parent;
	BinTreeNode left;
	int dato;
	BinTreeNode right;
	public BinTreeNode() {}
	public BinTreeNode(int dato) {
		this.parent = null;
		this.left = null;
		this.dato = dato;
		this.right = null;
	}



}
