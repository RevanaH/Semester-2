import java.util.*;

class Gerbong {
  int penumpang;
  int dewasa;
  int anak;
  Gerbong next;

  Gerbong(int dewasa, int anak) {
    this.dewasa = dewasa;
    this.anak = anak;
    this.penumpang = dewasa + anak;
  }
}

class LinkedList {
  Gerbong head;
  Gerbong tail;

  boolean isEmpty() {
    return head == null && tail == null;
  }

  void addLast(int dewasa, int anak) {
    Gerbong node = new Gerbong(dewasa, anak);
    if (isEmpty()) {
      head = tail = node;
    } else {
      tail.next = node;
      node.next = null;
      tail = node;
    }

  }

  // void removeFirst() {
  //   Gerbong temp = head;
  //   if (!isEmpty()) {
  //     if (head == tail)
  //       head = tail = null;
  //   } else {
  //     temp = temp.next;
  //     head = temp;
  //     temp = null;
  //   }
  // }

  void reverse() {
    Gerbong temp = head;
    Gerbong before = null;
    Gerbong after = null;
    while (temp != null) {
      after = temp;
      temp = temp.next;

      after.next = before;
      before = after;
      head = after;

    }

  }

  // void deleteNode(int data) {
  // Gerbong temp = head;
  // if (!isEmpty()) {
  // while (temp != null) {
  // if (temp.next.penumpang == data) {
  // temp.next = temp.next.next;
  // if (temp.next == null) {
  // tail = temp;
  // break;
  // }
  // } else if ((temp.penumpang == data) && (temp == head)) {
  // this.removeFirst();
  // break;
  // }
  // temp = temp.next;
  // }
  // }
  // }
  void deleteNode(int data) {
    Gerbong temp = head;
    Gerbong prev = null;

    while (temp != null) {
      if (temp.penumpang == data) {
        if (prev == null) {
          head = temp.next;
          if (tail == temp) {
            tail = null;
          }
        } else {
          prev.next = temp.next;
          if (tail == temp) {
            tail = prev;
          }
        }
        return;
      }
      prev = temp;
      temp = temp.next;
    }
  }

  void print() {
    Gerbong temp = head;
    while (temp != null) {
      System.out.print("[" + temp.dewasa + "" + ", " + temp.anak + "]");
      if (temp.next != null) {
        System.out.print("-");
      }
      temp = temp.next;
    }
    System.out.println();
  }
}

public class KeretaSLL {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int length = s.nextInt();
    s.nextLine();

    LinkedList run = new LinkedList();

    for (int i = 0; i < length; i++) {
      run.addLast(s.nextInt(), s.nextInt());
    }
    int lost = s.nextInt();
    run.deleteNode(lost);
    run.reverse();
    run.print();
    s.close();

  }
}