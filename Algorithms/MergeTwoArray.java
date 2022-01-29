public class MergeTwoArray {

    public void printArray(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public int[] merge(int arr1[],int arr2[]){
        int n=arr1.length;
        int m=arr2.length;
        int[] result=new int[n+m];
        int i=0,j=0,k=0;
        while(i<n && j<m){
            if(arr1[i]<arr2[j]){
                result[k]=arr1[i];
                i++;
            }else{
                result[k]=arr2[j];
                j++;
            }
            k++;
        }
        while(i<n){
            result[k]=arr1[i];
            i++;
            k++;
        }
        while(j<m){
            result[k]=arr2[j];
            j++;
            k++;
        }
        return result;
        
    }

    public static void main(String[] args) {
        int arr1[]={0,2,4,6,8,9,10};
        int arr2[]={1,3,5,7};

        MergeTwoArray merger=new MergeTwoArray();
        int[] result=merger.merge(arr1, arr2);
        merger.printArray(result);
    }
}
