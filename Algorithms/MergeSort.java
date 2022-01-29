class MergeSort{

    public void printArray(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public void sort(int[] arr,int[] temp,int low,int high){
        if(low<high){
            int mid=low+(high-low)/2;
            sort(arr,temp,low,mid);
            sort(arr,temp,mid+1,high);
            merge(arr,temp,low,mid,high);
        }
    }

    private void merge(int[] arr,int[] temp,int low,int mid,int high){
        for(int i=low;i<=high;i++){
            temp[i]=arr[i];
        }
        int i=low; //Traverse left sorted subarray
        int j=mid+1; //Traverse right sorted subarray
        int k=low; //Will merger both arrays into original array 

        while(i<=mid && j<=high){
            if(temp[i]<=temp[j]){
                arr[k]=temp[i];
                i++;
            }else{
                arr[k]=temp[j];
                j++;
            }
            k++;
        }

        // we are checking only for i because we have already copied the whole array in temp so no need to check for j
        while(i<=mid){
            arr[k]=temp[i];
            k++;
            i++;
        }
    }

    public static void main(String[] args) {
        // int arr[]={1,5,3,6,4,8,0,2,7,9,-1,10,-2};
        // int arr[]={2,1,3};
        int arr[]={1,3,5};
        MergeSort ms=new MergeSort();
        ms.sort(arr, new int[arr.length],0, arr.length-1);
        ms.printArray(arr);
    }
}