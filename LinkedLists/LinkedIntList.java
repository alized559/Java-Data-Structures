public class LinkedIntList {
  private ListNode front;

  public LinkedIntList() {
    front = null;
  }

  public void add(int value) {
    if (front == null) {
      front = new ListNode(value);
    } else {
      ListNode current = front;
      while (current.next != null) {
        current = current.next;
      }
      current.next = new ListNode(value);
    }
  }

  public int get(int index) {
    if (index < 0 || index >= size())
      throw new IndexOutOfBoundsException("index out of bounds");
    if (front == null)
      throw new NullPointerException("list is empty!");
    ListNode current = front;
    for (int i = 0; i < index; ++i) {
      current = current.next;
    }
    return current.data;
  }

  public void add(int index, int value) {
    if (index < 0 || index >= size())
      throw new IndexOutOfBoundsException("index out of bounds");
    if (index == 0) {
      front = new ListNode(value, front);
    } else {
      ListNode newNode = new ListNode(value);
      ListNode current = front;
      for (int i = 0; i < index - 1; ++i)
        current = current.next;
      current.next = new ListNode(value, current.next);
    }
  }

  public int remove() {
    if (front == null)
      throw new NullPointerException("list is empty!");
    int data = front.data;
    front = front.next;
    return data;
  }

  public void remove(int index) {
    if (index < 0 || index >= size())
      throw new IndexOutOfBoundsException("index out of bounds");
    if (front == null)
      throw new NullPointerException("list is empty!");
    ListNode current = front;
    for (int i = 0; i < index - 1; ++i) {
      current = current.next;
    }
    current.next = current.next.next;
  }

  public void addSorted(int value) {
    if (front == null)
      throw new NullPointerException("list is empty!");
    if (value < front.data) {
       front = new ListNode(value, front);
       return;
    }
    ListNode current = front;
    while (current != null && current.next != null && current.next.data < value) {
      current = current.next;
    }
    current.next = new ListNode(value, current.next);
  }

  public int size() {
    ListNode current = front;
    int res = 0;
    while (current != null) {
      res++;
      current = current.next;
    }
    return res;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public void clear() {
    int sz = size();
    for (int i = 0; i < sz; ++i)
      remove();
  }

  public boolean contains(int value) {
    if (front == null)
      throw new NullPointerException("list is empty!");
    ListNode current = front;
    while (current != null) {
      if (current.data == value)
        return true;
      current = current.next;
    }
    return false;
  }

  public int indexOf(int value) {
    if (front == null)
      throw new NullPointerException("list is empty!");
    ListNode current = front;
    int index = 0;
    while (current != null) {
      if (current.data == value)
        return index;
      index++;
      current = current.next;
    }
    return -1;
  }

  public String toString() {
    ListNode current = front;
    String res = "";
    while (current != null) {
      res += current.data + " -> ";
      current = current.next;
    }
    return res + "null";
  }

  public static void main(String[] args) {
    LinkedIntList list = new LinkedIntList();
    list.add(5);
    list.add(6);
    list.add(7);
    System.out.println(list);
    System.out.println(list.get(1));
    list.add(10);
    System.out.println(list);
    list.remove(1);
    System.out.println(list);

    LinkedIntList sortedList = new LinkedIntList();
    sortedList.add(-4);
    sortedList.add(8);
    sortedList.add(22);
    System.out.println(sortedList);
    sortedList.addSorted(100);
    System.out.println(sortedList);
  }
}
