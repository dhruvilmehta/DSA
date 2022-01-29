
public class InsertionSort {

    public void printArray(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public void sort(int arr[]){
        // Take the current element and swap it with the previous elements if its value is small . Current element is i and previous elements are j which starts from i-1 to 0
        int n=arr.length;

        for(int i=1;i<n;i++){
            int temp=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>temp){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=temp;
        }
    }

    public static void main(String[] args) {
        int[] arr={5,3,6,2,8,1,10,9,4,7};
        InsertionSort is=new InsertionSort();

        is.sort(arr);
        is.printArray(arr);
    }
}
