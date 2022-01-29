public class SelectionSort {

    public void printArray(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public void sort(int arr[]){
        // Take minimum value from the whole array and swap it with the front pointer ,i.e i,and then increment i further repeat the same
        int n=arr.length;
        for(int i=0;i<n;i++){
            int min=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            int temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
    }

    public static void main(String[] args) {
        int[] arr={5,3,6,2,8,1,10,9,4,7};
        SelectionSort ss=new SelectionSort();

        ss.sort(arr);
        ss.printArray(arr);
    }
}
