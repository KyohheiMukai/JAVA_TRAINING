package ch22.ex22_04;

public class Main {

	public static void main(String[] args) {
		Attr a = new Attr("a", "obj1");
		Attr b = new Attr("b", "obj2");
		Attr c = new Attr("c", "obj3");
		Attr d = new Attr("d", "obj4");
		Attr e = new Attr("e", "obj5");

		AttributedImpl attributed = new AttributedImpl();
		AttributedObserver observer = new AttributedObserver(attributed);

		attributed.add(a);
		attributed.add(b);
		attributed.add(c);
		attributed.add(d);
		attributed.remove(b.getName());
		attributed.add(e);
		attributed.remove(c.getName());
		attributed.remove(e.getName());

	}

}
