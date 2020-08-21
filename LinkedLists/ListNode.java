
public class ListNode {
  int data;
  ListNode next;

  public ListNode(int data) {
    this.data = data;
    this.next = null;
  }

  public ListNode(int data, ListNode next) {
    this.data = data;
    this.next = next;
  }

  public String toString() {
    if (this == null)
      return "null";
    return "ListNode(data=" + this.data + ", next=" + this.next + ")";
  }
}
