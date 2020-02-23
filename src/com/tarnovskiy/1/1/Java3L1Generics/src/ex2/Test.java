package ex2;

public class Test<T extends Comparable<T>> implements Comparable<Test<T>> {
    T data;

    public Test(T data) {
        this.data = data;
    }

    public static void main(String[] args) {
        Test<Integer> a = new Test<Integer>(1);
        Test<Integer> b = new Test<Integer>(2);
        if (a.compareTo(b) > 0) {

        }
    }

    @Override
    public int compareTo(Test<T> another) {
        //другая промежуточная логика
        return data.compareTo(another.data);
    }
}

