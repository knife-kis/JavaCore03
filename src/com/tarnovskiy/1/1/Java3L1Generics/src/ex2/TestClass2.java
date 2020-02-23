package ex2;

import java.util.*;

public class TestClass2 {
    static List<String> strings;

    public long getSumOLD(List accounts){
        long sum = 0;

        for(int i = 0, n = accounts.size(); i<n; i++){
            Object account = accounts.get(i);
            if (account instanceof Account) {
                sum += ((Account) account).getAmount();
            }
        }

        return sum;
    }

    public long getSum(List<Account> accounts) {
        long sum = 0;
        for (Account account : accounts) {
//            sum + = ...
        }

        return sum;
    }

    public static void main(String[] args) {
        //Кошка - Животных
        //Множество<Кошек> = Множество<Животных>;

        Number n = Integer.valueOf(42);
        List<Number> aList = new ArrayList<>();
        Collection<Number> aCollection = aList;
        Iterable<Number> iterable = aCollection;
        //Множество<Живоные> = Множество<Кошки>; ковариантность

        String[] strings = new String[] {"a", "b", "c"};
        Object[] arr = strings;

        // Дженерики инвариантны
        // WildCards
        //public final class <? extends Number> implements Comparable<Double> {

        List<Integer> ints = Arrays.asList(1,2,3);
        List<Double> doubles = Arrays.asList(1.1,2.1,3.1);
        List<Number> numbers = Arrays.asList(1.1,2.1,3.1);
        List<StringBuilder> stringBuilders = new List<StringBuilder>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<StringBuilder> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(StringBuilder stringBuilder) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends StringBuilder> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends StringBuilder> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public StringBuilder get(int index) {
                return null;
            }

            @Override
            public StringBuilder set(int index, StringBuilder element) {
                return null;
            }

            @Override
            public void add(int index, StringBuilder element) {

            }

            @Override
            public StringBuilder remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<StringBuilder> listIterator() {
                return null;
            }

            @Override
            public ListIterator<StringBuilder> listIterator(int index) {
                return null;
            }

            @Override
            public List<StringBuilder> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        List<? extends Number> nums = ints;
        List<? extends Number> nums2 = doubles;
        List<? extends Number> nums3 = numbers;
        //List<? extends Number> nums3 = stringBuilders;


        List<Number> nums4 = new ArrayList<Number>();
        List<? super Integer> ints2 = nums4;
    }
}
