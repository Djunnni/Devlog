### Sort

Out of place Sort : 모든 데이터를 자료구조의 복사본에 옮긴 후 순서대로 배열하여 정렬.

In place Sort : 자료구조를 그대로 두고 안에서 요소들의 위치를 바꾸어 정렬

stable sort의 경우: 중복된 숫자가 원래의 순서를 유지한 상태로 정렬

unstable sort : 중복된 숫자의 순서를 보장할 수 없다.

##### 선택 정렬(select sort)

복잡도(최선, 최악, 평균)
(n-1) + (n-2) + (n-3) + ... + 1 => n(n - 1) / 2 = O(n^2)

unstable, in place sort에 속한다.

만약 b(1), b(2), a, c 가 있다고 하면 a가 최소이므로 b(1)과 자리를 교체 
a, b(2), b(1), c가 됨. 따라서 unstable

```java
public void selectSort(int[] arr) {
    for(int  i = 0; i < arr.length - 1; i++) {
        int min = i;
        for(int j = i + 1; j < arr.length; j++) {
            if(arr[min] > arr[j]) {
                min = j;
            }
        }
        swap(arr, min, i);
    }
}
```

##### 삽입 정렬(insertion sort)

최악, 평균 복잡도 : O(n^2)
최선 복잡도: O(n)

이미 정렬된 리스트 - 데이터베이스에서 이용
새롭게 키를 넣을 때, 빠르게 동작

stable, in-place 정렬이다.

```java
public static void insertSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int j;
            int v = arr[i];
            for(j = i - 1; j >= 0; j--) {
                if(arr[j] <= v) {
                    break;
                }
                arr[j+1] = arr[j];
            }
            arr[j+1] = v;
        }
    }
```

### 셸 정렬(Shell sort)

최악 복잡도 O(n^2)
평균 복잡도 O(n^(5/4)) or O(n^(3/2))

not stable, in place

```java
public void shellSort(int[] arr, int range) {
    int i, gap;
    for(gap = range / 2; gap > 0; gap /= 2) {
        if(gap % 2 == 0) {
            gap++;
        }
        for(int i = 0; i < gap; i++) {
            incInsertSort(arr, i, range - 1, gap);
        }
    }
}
public void incInsertSort(int[] arr, int start, int end, int gap) {
    int i, j, key;
    for(i = start + gap; i <= end; i += gap) {
        key = arr[i];
        for(j = i - gap; start <= j && key < arr[j]; j-= gap) {
            list[j + gap] = list[j];
        }
        list[j+gap] = key;
    }
}
```

### 합병 정렬(Merge Sort)

O(nlogn)

stable, not in place

```java
public void MergeSort(int[] arr) {
    this.array = arr;
    this.temp = new int[arr.length];
    split(0, arr.length - 1);
}

public void split(int start, int end) {
    if(start >= end) { return; }
    int mid = (start + end) / 2;
    split(start, mid);
    split(mid + 1, end);
    merge(start, mid, end);
}

public void merge(int start, int mid, int end) {
    int i = start; int j = mid + 1; int temppoint = start;
    while(i <= mid && j <= end) {
        if(array[i] < array[j]) {
            temp[temppoint++] = array[i++];
        } else {
            temp[temppoint++] = array[j++];
        }
    }

    while(i <= mid) temp[temppoint++] = array[i++];
    while(j <= end) temp[temppoint++] = array[j++];

    for(temppoint = start; temppoint <= end; temppoint++) {
        array[temppoint] = temp[temppoint];
    }
}
```