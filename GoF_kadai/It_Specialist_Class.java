public class It_Specialist_Class {
	public static void main(String[] args) {
		ClassRoom classRoom = new ClassRoom(11);
		classRoom.appendName(new Student("はらぺこゆっきー"));
		classRoom.appendName(new Student("ひろくん"));
		classRoom.appendName(new Student("けいご"));
		classRoom.appendName(new Student("とうま"));
		classRoom.appendName(new Student("さむ"));
		classRoom.appendName(new Student("仲西"));
		classRoom.appendName(new Student("かずき"));
		classRoom.appendName(new Student("ちひろ"));
		classRoom.appendName(new Student("よぎ"));
		classRoom.appendName(new Student("吉岡"));
		Iterator it = classRoom.iterator();
		while (it.hasNext()) {
			Student student = (Student)it.next();
			System.out.println(student.getName());
		}
	}
}

interface Aggregate {
	public abstract Iterator iterator();
}

interface Iterator {
	public abstract boolean hasNext();
	public abstract Object next();
}

class Student {
	private String name;
	public Student(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}

class ClassRoom implements Aggregate {
	private Student[] students;
	private int last = 0;
	public ClassRoom(int maxsize) {
		this.students = new Student[maxsize];
	}
	public Student getNameAt(int index) {
		return students[index];
	}
	public void appendName(Student student) {
		this.students[last] = student;
		last++;
	}
	public int getLength() {
		return last;
	}
	public Iterator iterator() {
		return new ClassRoomIterator(this);
	}
}

class ClassRoomIterator implements Iterator {
	private ClassRoom classRoom;
	private int index;
	public ClassRoomIterator(ClassRoom classRoom) {
		this.classRoom = classRoom;
		this.index = 0;
	}
	public boolean hasNext() {
		if (index < classRoom.getLength()) {
			return true;
		} else {
			return false;
		}
	}
	public Object next() {
		Student student = classRoom.getNameAt(index);
		index++;
		return student;
	}
}