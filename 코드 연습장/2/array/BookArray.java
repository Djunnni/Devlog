package chapter7.array;

public class BookArray {
    public static void main(String[] args) {
        // int는 4바이트라고 했는데 5개면 20 바이트다.
        // object일 경우에는?
        // ex) Book이 만들어질 주소자리 5개를 만든거다.
        Book[] library = new Book[5];

        library[0] = new Book("태백산맥", "조정래");
        library[1] = new Book("태백산맥", "조정래");
        library[2] = new Book("태백산맥", "조정래");
        library[3] = new Book("태백산맥", "조정래");

        for(int i=0; i< library.length; i++) {
            if(library[i] != null)
                library[i].showBook();
        }

        // System.arraycopy를 통한 복사 방법
        int[] arr = { 1, 2, 3, 4, 5};
        int[] arr2 = {10,20,30,40,50};
        System.arraycopy(arr, 2, arr2, 3, 2);
        for(var x : arr2) {
            System.out.println(x);
        }
    }
}
