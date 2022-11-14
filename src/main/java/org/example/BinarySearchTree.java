package org.example;

import java.util.Stack;

public class BinarySearchTree {
	BinTreeNode root;
	//int size;
	public BinarySearchTree() {
		this.root =null;
	}
	public boolean estaVacio(){
		return root == null;
	}

	//Recorrido InOrden (Operaciones Recursivas):
	//Debe de estar NO VACIO
	//1. Recorrer el Subárbol Izquierdo InOrden (Primero se mostrarán los lados izquierdos, luego raiz y  luego lado derecho)
	//2. Examinar la Raíz (la imprime)
	//3. Recorrer el Subárbol Derecho InOrden

	/* Para recorrer el arbol inOrden necesito la raiz
	* y para este caso la raiz es de tipo BinTreeNode
	* eso lo paso por parametros */
	public void inOrden(BinTreeNode r){
		//Checo que la r sea diferente de null, eso indica que puedo recorrer algo
		if ( r!=null){
			inOrden(r.left);
			System.out.print(r.dato + ", ");
			inOrden(r.right);
		}

		/* --------------------------------------------------*/
		//left-root-right
		/*if (root==null){
			System.out.println(" Tree empty ");
			return;
		}
		Stack <BinTreeNode> bst=new Stack<>();
		BinTreeNode aux=root;
		while (	aux !=null || !bst.empty()){
			while (aux !=null){
				bst.push(aux);
				aux=aux.left;
			}
			aux=bst.pop();
			System.out.print(aux.value + " , ");
			aux=aux.right;
		}*/

	}

	//Recorrido PreOrden (Operaciones Recursivas):
	//Debe de estar NO VACIO
	//1. Examinar la Raiz(Primero se mostrarán los valores de la raiz, luego lado izquierdo y  luego lado derecho)
	//2. Recorrer el Subárbol Izquierdo en PreOrden
	//3. Recorrer el Subárbol Derecho en PreOrden

	/* Para recorrer el arbol PreOrden necesito la raiz
	 * y para este caso la raiz es de tipo BinTreeNode
	 * eso lo paso por parametros */
	public void preOrden(BinTreeNode r){
		//Checo que la r sea diferente de null, eso indica que puedo recorrer algo
		if ( r!=null){
			System.out.print(r.dato + ", ");
			preOrden(r.left);
			preOrden(r.right);
		}

		/*----------------------------------------------------------*/
		//root-left-right
		/*if (root==null){
			System.out.println(" Tree empty  ");
			return;
		}
		Stack<BinTreeNode> bst=new Stack<>();
		bst.push(root);
		BinTreeNode aux2;
		while (!bst.empty()){
			aux2=bst.pop();
			System.out.print(aux2.value + " , ");
			if (aux2.right !=null)
			if (aux2.left !=null){
				bst.push(aux2.left);
			}
		}*/
	}


	//Recorrido PostOrden (Operaciones Recursivas):
	//Debe de estar NO VACIO
	//1. Recorrer el Subárbol Izquierdo en PostOrden (Imprimer el último valor izquierdo del último nodo raiz)
	//2. Recorrer el Subárbol Derecho en PostOrden
	//3. Examinar la Raiz

	/* Para recorrer el arbol PostOrden necesito la raiz
	 * y para este caso la raiz es de tipo BinTreeNode
	 * eso lo paso por parametros */
	public void postOrden(BinTreeNode r){
		//Checo que la r sea diferente de null, eso indica que puedo recorrer algo
		if ( r!=null){
			postOrden(r.left);
			postOrden(r.right);
			System.out.print(r.dato + ", ");
		}
		/*----------------------------------------------------------*/
		// left-right-root
		/*if (root==null){
			System.out.println(" Tree empty ");
			return;
		}
		Stack <BinTreeNode> bst =new Stack<>();
		BinTreeNode aux3 =root;
		BinTreeNode temporal;
		while (aux3 !=null || !bst.empty()){
			if (aux3 !=null){
				bst.push(aux3);
				aux3=aux3.left;
			}else {
				temporal=bst.peek();
				if (temporal.right !=null){
					aux3=temporal.right;
				}else {
					bst.pop();
					while (!bst.empty() && bst.peek().right == temporal){
						System.out.print(temporal.value +" , ");
						temporal=bst.pop();
					}
					System.out.print(temporal.value +" , ");
				}
			}

		}*/
	}


	//1. Crear un puntero auxiliar de tipo BinTreeNode y apuntarlo a la raiz
	//2. Mientras que el auxiliar sea diferente del dato buscado hacer:
		//a. si dato buscado es menor que auxiliar de dato entonces:
			//a.1 Apuntar auxiliar a auxiliar de hijo izquierdo.
		//b. sino:
			//b.1 Apuntar auxiliar a auxiliar de hijo derecho.
		//c. Si auxiliar es idéntico a nulo:
			//c.1 Retornar nulo
	//3. Retornar true
	public boolean find(int k) {
		BinTreeNode aux = root;
		while (aux.dato != k){
			if(k < aux.dato){
				aux = aux.left;
			}else {
				aux = aux.right;
			}
			
			if(aux ==null){
				return false;
			}
		}
		return true;

		/*-----------------------------------------------------------------------------*/
		// este metodo debe retornar true si y solo si k aparece en elgun nodo del arbol
		/*
		return true;
		*/
	}

	/*--------------------------------Agregando Nodos y nombre al arbol ----------------------------*/
	public void add(int dato) {
		// este metodo agrega el valor k al arbol y retorna true si el valor no estaba.
		// Si ya estaba, retorna false.

		BinTreeNode nuevo = new BinTreeNode(dato);
		Stack <BinTreeNode> bst=new Stack<>();
		bst.push(nuevo);

		for (BinTreeNode valor : bst) {
			System.out.println(valor.dato);
		}


		if(root == null){
			root = nuevo;
		}else {
			//Esta condicion verifica que no se puedan ingresar dos veces el mismo valor
			if(!find(dato)) {
				BinTreeNode temporal = root; //--> = 2
				BinTreeNode padre; // --> null
				while (true) {
					padre = temporal; // --> 2
					if (dato < temporal.dato) {
						temporal = temporal.left;
						if (temporal == null) {
							padre.left = nuevo;
							return;
						}
					} else {
						temporal = temporal.right;
						if (temporal == null) {
							padre.right = nuevo;
							return;
						}
					}
				}
			}


		}
		/*--------------------------------------------------*/
		/*BinTreeNode padre=null;
		BinTreeNode temporall=root;
		int leftOrRight=-1;
		while (temporall !=null){
			if (temporall.value >k){
				padre=temporall;
				temporall=padre.left;
				leftOrRight=0;
			} else if (temporall.value <k) {
				padre=temporall;
				temporall=padre.right;
				leftOrRight=1;
			}else {
				System.out.println("ignored");
			}
		}
		BinTreeNode newNode=new BinTreeNode(k);
		if (padre==null){
			root=newNode;
		}else {
			if (leftOrRight==0){
				padre.left=newNode;
			}else {
				padre.right=newNode;
			}
		}
		return true;*/
	}

	public boolean repOK() {
		// este metodo retorna true si y solo si la estructura es un arbol binario de busqueda
		if (root.left == null && root.right == null){
			System.out.println("No es un arbol binario");
			return true;
		}
		return false;
	}


	//1. Buscar en el Árbol, para encontrar la posición del nodo a elminar.
	//2. Si el nodo a suprimir tiene menos de dos hijos, reajustar los enlaces de su antecesor.
	//3. Si el nodo tiene dos hijos(rama izquierda y derecha):
		//a. Es necesario subir a la posición que este del dato más próximo de sus subárboles
		//   (el inmediatamente superior o el inmediatamente inferior)
		//	 con el fin de mantener la estructura del árbol binario de búsqueda
	public boolean remove(int k) {
		BinTreeNode aux = root;
		BinTreeNode padre = root;
		boolean esHijoIzq = true;

		while (aux.dato != k){
			padre = aux;
			//si se cumple esta condicion va por la izquierda
			if ( k < aux.dato){
				esHijoIzq = true;
				aux = aux.left;


			}else {
				//Si no es menor va por la derechoa porque o es mayor o es igual
				esHijoIzq = false;
				aux = aux.right;

			}

			//Si retorna false no encontro el nodo
			if(aux == null){
				return  false;
			}else {
				return true;
			}
		}//fin while

		//Si encontro el nodo ejecuta esto
		//Reacomodando los punteros y aun no encontramos el nodo a reemplazar
		if(aux.left == null && aux.right == null){
			//Si ingresan a aca es porque el nodo es hoja o es el único nodo es decir raiz
			if(aux == root){
				root = null;
			}else if(esHijoIzq){
				padre.left = null;
			}else {
				padre.right = null;
			}
		}else if(aux.right == null){
			if(aux == root){
				root = aux.left;
			}else if(esHijoIzq){
				padre.left = aux.left;
			}else {
				padre.left = aux.left;
			}
		}else if (aux.left == null){
			if(aux == root){
				root = aux.right;
			}else if(esHijoIzq){
				padre.left = aux.right;
			}else {
				padre.right = aux.right;
			}
		}else {
			//aca buscamos el nodo reemplazo con un método que está fuera
			BinTreeNode reemplazo = obtenerNodoReempleazo(aux);
			if(aux == root){
				root = reemplazo;
			}else if(esHijoIzq){
				padre.left = reemplazo;
			} else {
				padre.right = reemplazo;
			}

			reemplazo.left = aux.left;
		}
		return true;


		/*---------------------------------------------------------*/
		// este metodo elimina el valor k del arbol.
		// Si el valor ya estaba retorna true.
		// Si el valor no estaba, retorna false.
		/*return true;*/
	}

	//Metodo encargado de devolvernos el nodo reemplazo
	public BinTreeNode obtenerNodoReempleazo(BinTreeNode nodoReemp){
		BinTreeNode reemplazarPadre = nodoReemp;
		BinTreeNode reemplazo = nodoReemp;
		BinTreeNode auxiliar = nodoReemp.right;

		//Recorremos para encontrar el nodo candidato para el que vamos a reemplazar
		while(auxiliar != null){
			reemplazarPadre = reemplazo;
			reemplazo = auxiliar;
			auxiliar = auxiliar.left;
		}
		if(reemplazo != nodoReemp.right){
			//Reacomodando los enlaces
			reemplazarPadre.left = reemplazo.right;
			reemplazo.right = nodoReemp.right;
		}
		System.out.println("El Nodo reemplazo es: " + reemplazo);
		return reemplazo;
	}

	/*public static void main(String[] args) {
		BinarySearchTree b = new BinarySearchTree();
		b.add(6);
		b.add(4);
		b.add(9);
		b.add(12);
		b.add(1);
		assert !b.find(3); //comprueba que no esta tree
		assert b.find(9); //comprueba que si esta tree
		b.remove(2);
		assert !b.find(2); //delete no cambia, xq el 2 no esta
		for (int i=0;i<8;i++) {
			System.out.println(b);
		}
		System.out.println("----------------- InOrden ----------------");
		b.inOrden();

		System.out.println("\n----------------- PreOrden ----------------");
		b.preOrden();

		System.out.println("\n----------------- PostOrden ----------------");
		b.postOrden();
	}*/
}
