/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ssl;

/**
 *
 * @author ADMIN
 */
public class Node {
    //1 node bao gồm 1 thân và 1 đuôi
    int data;//Ô chứa data (người, vật, ...)
    Node next;//Đuôi của node

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
