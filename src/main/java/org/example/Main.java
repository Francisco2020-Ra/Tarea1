package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        int opcion = 0, elemento;
        String nombre;
        BinarySearchTree arbolBinario = new BinarySearchTree();
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
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresar el número del Nodo", "Agregando Nodo", JOptionPane.QUESTION_MESSAGE));
                        arbolBinario.add(elemento);
                        break;
                    case 2:
                        //Si no esta vacio lo recorre
                        if(!arbolBinario.estaVacio()){
                            System.out.println();
                            //recorre la raiz, la cual la pasamos por parametros
                            arbolBinario.inOrden(arbolBinario.root);
                        }else {
                            JOptionPane.showMessageDialog(null, "El árbol esta vacio",
                                    "Fin", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 3:
                        //Si no esta vacio lo recorre
                        if(!arbolBinario.estaVacio()){
                            System.out.println();
                            //recorre la raiz, la cual la pasamos por parametros
                            arbolBinario.preOrden(arbolBinario.root);
                        }else {
                            JOptionPane.showMessageDialog(null, "El árbol esta vacio",
                                    "Fin", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 4:
                        //Si no esta vacio lo recorre
                        if(!arbolBinario.estaVacio()){
                            System.out.println();
                            //recorre la raiz, la cual la pasamos por parametros
                            arbolBinario.postOrden(arbolBinario.root);
                        }else {
                            JOptionPane.showMessageDialog(null, "El árbol esta vacio",
                                    "Fin", JOptionPane.INFORMATION_MESSAGE);
                        }

                        break;
                    case 5:
                        if(!arbolBinario.estaVacio()){
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa el Número del Nodo Buscado...", "Buscando Nodo",
                                    JOptionPane.QUESTION_MESSAGE));
                            if(arbolBinario.find(elemento) == false){
                                JOptionPane.showMessageDialog(null, "Nodo no encontrado", "¡No encontrado!", JOptionPane.INFORMATION_MESSAGE);
                            }else {
                                System.out.println("Encontrado, sus dotos son: " + arbolBinario.find(elemento));
                            };

                        }else{
                            JOptionPane.showMessageDialog(null, "El Árbol esta vacio", "!Cuidado¡", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 6:
                        if(!arbolBinario.estaVacio()){
                            elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Ingresa el Número del Nodo a eliminar...", "Eliminando Nodo",
                                    JOptionPane.QUESTION_MESSAGE));
                            if(arbolBinario.remove(elemento) == false){
                                JOptionPane.showMessageDialog(null, "Nodo no encontrado",
                                        "¡No encontrado!", JOptionPane.INFORMATION_MESSAGE);
                            }else {
                                JOptionPane.showMessageDialog(null, "El Nodo ha sido eliminado del Árbol",
                                        "¡No eliminado!", JOptionPane.INFORMATION_MESSAGE);
                            };

                        }else{
                            JOptionPane.showMessageDialog(null, "El Árbol esta vacio", "!Cuidado¡", JOptionPane.INFORMATION_MESSAGE);
                        }

                        break;
                    case 7:
                        if(!arbolBinario.estaVacio()){

                            if(arbolBinario.repOK()){
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
        }while(opcion!=8);
    }
}