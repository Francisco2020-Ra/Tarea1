package org.example.modelo2;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0, elemento = 0;
        BinarySearchTree arbolSearch = new BinarySearchTree();
        BinTreeNode root = null;
        BinTreeNode arbolBinario;

        do{
            try{
                opcion = Integer.parseInt( JOptionPane.showInputDialog(null,
                        "1. Agregar un Nodo\n"
                                + "2. Recorrer un Arbol InOrden\n"
                                + "3. Recorrer un Arbol PreOrden\n"
                                + "4. Recorrer un Arbol PostOrden\n"
                                + "5. Buscar un Nodo en el Arbol\n"
                                + "6. Eliminar un Nodo del Arbol\n"
                                + "7. Es Binario Arbol?\n"
                                + "8. Salir\n"
                                + "Elige Una Opción ...", "Árboles Binarios", JOptionPane.QUESTION_MESSAGE));

                switch (opcion){
                    case 1:
                            System.out.println("Ingresar el número del Nodo");
                            elemento = sc.nextInt();
                            arbolBinario = new BinTreeNode(elemento);
                            root = arbolSearch.add(root, arbolBinario);
                        break;
                    case 2:
                        //Si no esta vacio lo recorre
                        if(!arbolSearch.estaVacio(root)){
                            System.out.println();
                            //recorre la raiz, la cual la pasamos por parametros
                            arbolSearch.inOrden(root);
                        }else {
                            JOptionPane.showMessageDialog(null, "El árbol esta vacio",
                                    "Fin", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 3:
                        //Si no esta vacio lo recorre
                        if(!arbolSearch.estaVacio(root)){
                            System.out.println();
                            //recorre la raiz, la cual la pasamos por parametros
                            arbolSearch.preOrden(root);
                        }else {
                            JOptionPane.showMessageDialog(null, "El árbol esta vacio",
                                    "Fin", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 4:
                        //Si no esta vacio lo recorre
                        if(!arbolSearch.estaVacio(root)){
                            System.out.println();
                            //recorre la raiz, la cual la pasamos por parametros
                            arbolSearch.postOrden(root);
                        }else {
                            JOptionPane.showMessageDialog(null, "El árbol esta vacio",
                                    "Fin", JOptionPane.INFORMATION_MESSAGE);
                        }

                        break;
                    case 5:
                        if(!arbolSearch.estaVacio(root)){
                            System.out.println("Ingresa el Número del Nodo Buscado...");
                            elemento = sc.nextInt();

                            if(arbolSearch.treeSearch(root,elemento) == null){
                                System.out.println("Nodo no encontrado");
                            }else {
                                System.out.println("Encontrado, sus datos son: " + arbolSearch.treeSearch(root,elemento).dato);
                            };

                        }else{
                            System.out.println("El Árbol esta vacio");
                        }
                        break;
                    case 6:
                        if(!arbolSearch.estaVacio(root)){
                            System.out.println("Ingresa el Número del Nodo a eliminar...");
                            elemento = sc.nextInt();
                            arbolBinario = arbolSearch.treeSearch(root, elemento);
                            root = arbolSearch.TreeDelete(root, arbolBinario);
                        }else{
                            System.out.println("El Árbol esta vacio");
                        }

                        break;
                    case 7:
                        if(!arbolSearch.estaVacio(root)){

                            if(arbolSearch.repOK(root)){
                                JOptionPane.showMessageDialog(null, "Arbol no Binario",
                                        "¡No Binario!", JOptionPane.INFORMATION_MESSAGE);
                            }else {
                                JOptionPane.showMessageDialog(null, "Es Binario",
                                        "¡Binario!", JOptionPane.INFORMATION_MESSAGE);
                            };

                        }else{
                            JOptionPane.showMessageDialog(null, "El Árbol esta vacio", "!Cuidado¡", JOptionPane.INFORMATION_MESSAGE);
                        }

                        break;
                    case 8:
                        JOptionPane.showMessageDialog(null, "Aplicación finalizada", "Fin", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción incorrecta", "!Cuidado¡", JOptionPane.INFORMATION_MESSAGE);

                }
            }catch (NumberFormatException n){
                JOptionPane.showMessageDialog(null, "Error " + n.getMessage());
            }

        }while(true);
    }


}