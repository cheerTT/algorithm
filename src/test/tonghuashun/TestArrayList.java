package test.tonghuashun;

public class TestArrayList {

    Integer[] obj;
    private static int size = -1;
    private static int maxsize = 3;
    int threadhold;

    public TestArrayList() {

        obj = new Integer[maxsize];
//        this.size = size;
//        size = 0;
    }

    public void add(int val) {

        int tmp = size + 1;
        if (tmp >= maxsize) {
            resize();
        }

        obj[tmp] = val;
        size++;
    }

    private void resize() {

        Integer[] oldObj = obj;
        obj = new Integer[maxsize * 2];
        this.maxsize = maxsize * 2;

//        Arrays.copyOf(ol, )

        System.arraycopy(oldObj, 0, obj, 0, oldObj.length);

    }

    public static void main(String[] args) {

        TestArrayList arrayList = new TestArrayList();

        arrayList.add(1);
        System.out.println("1:" + TestArrayList.size + ":" + TestArrayList.maxsize);
        arrayList.add(2);
        System.out.println("2:" + TestArrayList.size + ":" +TestArrayList.maxsize);
        arrayList.add(3);
        System.out.println("3:" + TestArrayList.size + ":" +TestArrayList.maxsize);
        arrayList.add(4);
        System.out.println("4:" + TestArrayList.size + ":" +TestArrayList.maxsize);

        for (int i = 0; i < TestArrayList.size; i++) {

        }
    }

}
