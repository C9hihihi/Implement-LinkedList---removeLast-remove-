/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ssl;

/**
 *
 * @author ADMIN
 */
public class SinglyLinkedList {
    //1 sll là 1 tập hợp của nhiều node
    //1 sll có 1 head và 1 tail
    Node head; //đầu của sll
    Node tail; //đuôi của sll
    
    int size; //size của sll
    
    //Hàm xóa hết dữ liệu SLL
    public void clear() {
        head = tail = null;       
    }
    
    //Hàm kiểm tra SLL rỗng
    public boolean isEmpty() {
        return head == null;
    }
    
    //Hàm lấy size của SLL
    public int size() {
        return size;
    }
    
    //Hàm thêm node mới vào đầu SLL
    public void addFirst(int data) {
        //Khởi tạo node mới
        Node newNode = new Node(data);
        
        //TH1: SLL chưa có node nào
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        
        //TH2: SLL có ít nhất 1 node
        //B1: Cho đuôi node mới nối vào head
        newNode.next = head; // newNode -> head ->
        //B2: Chuyển head lên node mới
        head = newNode;
        //B3: Tăng size
        size++;
    }
    
    //Hàm thêm node mới vào cuối SLL
    public void addLast(int data) {
        //Khởi tạo node mới
        Node newNode = new Node(data);
        
        //TH1: SLL chưa có node nào
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        
        //TH2: SLL có ít nhất 1 node
        //B1: Lấy đuôi của tail nối vào node mới
        tail.next = newNode;
        //B2: Chuyển tail sang node mới
        tail = newNode;
        //B3: Tăng size
        size++;
    }
    
    //Hàm thêm node mới vào vị trí bất kỳ trong SLL
    public void addAt(int index, int data) {
        if (index < 0 || index > size) {
            System.out.println("Index out of bounds!");
            return;
        }
        
        //TH1: index = 0
        if (index == 0) {
            addFirst(data);
            return;
        }
        
        //TH2: index = size
        if (index == size) {
            addLast(data);
            return;
        }
        
        //TH3: 0 < index < size - 1
        //Khởi tạo node mới
        Node newNode = new Node(data);
        
        Node temp = head; // Node bản sao của head để truy tìm vị trí node tại index - 1
        int i = 0;
        //B1: Tìm đến vị trí index - 1
        while (i < index - 1) {
            temp = temp.next; // Dịch temp lên 1 đơn vị
            i++;
        }
        
        //B2: Nối đuôi node mới vào node tại vị trí index
        newNode.next = temp.next;
        //B3: Nối đuôi node tại index - 1 vào node mới
        temp.next = newNode;
        //B4: Tăng size
        size++;
    }
    
    //Hàm xóa node ở đầu SLL
    public void removeFirst() {
        //Tư duy: Chuyển head sang node thứ 2 thì node đầu tiên sẽ tự bị netbean xóa
        
        //TH1: SLL không có node nào
        if (head == null)
            return;
        
        //TH2: SLL có ít nhất 1 node
        
        //B1: Chuyển head sang node thứ 2
        //Nhận thấy head là node đầu tiên => head.next là node thứ 2
        head = head.next;
        //B2: Chuyển lại tail cho đúng vị trí nếu SLL chỉ có 1 node
        if (head == null)
            tail = null;
        //B3: Giảm size
        size--;
    }
    
    //Hàm xóa node ở cuối SLL
    public void removeLast() {
        //Tư duy: do tail không thể dịch chuyển lên nên ta sẽ lấy đuôi của node trước tail nối vào null
        
        //TH1: SLL không có node nào
        if (head == null)
            return;
        
        //TH2: SLL có 1 node
        if (head == tail) {
            head = tail = null;
            size = 0;
            return;
        }
        
        //TH3: SLL có nhiều hơn 1 node
        //B1: Lấy node trước tail (sau này sẽ update để tối ưu hiệu năng)
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        //Lúc này là temp = node trước tail, và temp.next = tail
        
        //B2: Lấy đuôi node trước tail nối vào null
        temp.next = null;
        //B3: Chuyển tail về node trước tail
        tail = temp;
        //B4; Giảm size
        size--;
    }
    
    //Hàm xóa node ở vị trí bất kỳ trong SLL
    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds!");
            return;
        }
        
        //TH1: index = 0
        if (index == 0) {
            removeFirst();
            return;
        }
        
        //TH2: index = size - 1
        if (index == size - 1) {
            removeLast();
            return;
        }
        
        //TH3: 0 < index < size - 1
        //B1: Truy tới vị trí node trước node tại cần xóa (node tại index)
        Node temp = head;
        int i = 0;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        //B2: Lấy đuôi node vừa truy nối vào node sau node tại index
        temp.next = temp.next.next;
        //B3: Giảm size
        size--;
    }
    
    //Hàm in ra tất cả data trong SLL 
    public void printList() {
        Node temp = head;
        int i = 0;
        while (i < size) {
            System.out.print(temp.data + " ");
            temp = temp.next;
            i++;
        }
    }
    
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.addLast(3);
        sll.addLast(4);
        sll.addLast(5);
        sll.addLast(6);
        sll.addLast(7);
        sll.addLast(8);
        sll.addLast(9);
        sll.addLast(10);
        
        System.out.println("Before removals:");
        sll.printList();
        
        sll.removeLast();
        sll.remove(3);
        
        System.out.println("After removals:");
        sll.printList();
    }
}
