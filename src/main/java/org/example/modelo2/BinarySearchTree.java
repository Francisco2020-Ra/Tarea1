package org.example.modelo2;

import java.util.Stack;

public class BinarySearchTree {

	//int size;
	public boolean estaVacio(BinTreeNode root){
		return root == null;
	}

	public void inOrden(BinTreeNode r){
		//Checo que la r sea diferente de null, eso indica que puedo recorrer algo
		if ( r!=null){
			inOrden(r.left);
			System.out.print(r.dato + ", ");
			inOrden(r.right);
		}
	}

	public void preOrden(BinTreeNode r){
		//Checo que la r sea diferente de null, eso indica que puedo recorrer algo
		if ( r!=null){
			System.out.print(r.dato + ", ");
			preOrden(r.left);
			preOrden(r.right);
		}
	}

	public void postOrden(BinTreeNode r){
		//Checo que la r sea diferente de null, eso indica que puedo recorrer algo
		if ( r!=null){
			postOrden(r.left);
			postOrden(r.right);
			System.out.print(r.dato + ", ");
		}
	}


	public BinTreeNode treeSearch(BinTreeNode x, int k) {
		if( x == null || k == x.dato){
			return x;
		}
		if(k < x.dato){
			return treeSearch(x.left, k);
		}else {
			return treeSearch(x.right, k);
		}
	}

	/*--------------------------------Agregando Nodos y nombre al arbol ----------------------------*/
	public static BinTreeNode add(BinTreeNode T, BinTreeNode z) {
		BinTreeNode y = null;
		BinTreeNode x = T;
		while( x != null) {
			y = x;
			if (z.dato < x.dato) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		z.parent = y;
		if (y == null) {
			T = z;
		} else if (z.dato < y.dato) {
			y.left = z;
		} else {
			y.right = z;
		}
		return T;
	}



	public boolean repOK(BinTreeNode root) {
		// este metodo retorna true si y solo si la estructura es un arbol binario de busqueda
		if (root.left == null && root.right == null){
			System.out.println("No es un arbol binario");
			return true;
		}
		return false;
	}

	public BinTreeNode TreeDelete(BinTreeNode root, BinTreeNode z) {
		if(z.left == null){
			root = Transplant(root, z, z.right);
		} else if (z.right == null) {
			root = Transplant(root,z,z.left);
		}else {
			BinTreeNode y = TreeMinimun(z.right);
			if (y.parent != z){
				root = Transplant(root, y, y.right);
				y.right = z.right;
				y.right.parent = y;
			}
			root = Transplant(root,z,y);
			y.left = z.left;
			y.left.parent = y;
		}
		return root;
	}
	public  BinTreeNode TreeMinimun(BinTreeNode x){
		while (x.left != null){
			x = x.left;
		}
		return x;
	}
	public BinTreeNode Transplant(BinTreeNode root, BinTreeNode u, BinTreeNode v){
		if(u.parent == null){
			root = v;
		}else if(u == u.parent.left){
			u.parent.left = v;
		}else{
			u.parent.right = v;
		}

		if(v != null){
			v.parent = u.parent;
		}
		return root;
	}
}
