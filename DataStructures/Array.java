
public class Array{

    public static void printArray(int arr[]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void reverse(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }

    public static int findMinimum(int[] arr){
        if(arr==null || arr.length==0){
            System.out.println("Array is Empty");
            throw new IllegalArgumentException();
        }
        else{
            int min=arr[0];
            for(int i=0;i<arr.length;i++){
                if(arr[i]<min){
                    min=arr[i];
                }
            }
            System.out.println(min);
            return min;
        }
    }

    public static void moveZeroToEnd(int[] arr){
        int j=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]!=0 && arr[j]==0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
            if(arr[j]!=0){
                j++;
            }
        }
    }

    public static int[] reSize(int[] arr,int capacity){
        int[] temp=new int[capacity];
        for(int i=0;i<arr.length;i++){
            temp[i]=arr[i];
        }
        return temp;
    }

    public static boolean isPalindrome(String word){
        char[] charArray=word.toCharArray();
        int start=0;
        int end=word.length()-1;
        while(start<end){
            if(charArray[start]!=charArray[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static int findMissingNumber(int[] arr){
        int n=arr.length+1;
        int sum=n*(n+1)/2;
        for(int num:arr){
            sum=sum-num;
        }
        return sum;
    }

    public static int[] sortedSquares(int[] arr){
        int n=arr.length;
        int[] result= new int[n];
        int i=0,j=n-1;
        for(int k=n-1;k>=0;k--){
            if(Math.abs(arr[i])>Math.abs(arr[j])){
                result[k]=arr[i]*arr[i];
                i++;
            }else{
                result[k]=arr[j]*arr[j];
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args){
        // Array arrayUtil=new Array();v
        int[] array={-1,0,2,4,5};

        // reverse(array);

        // findMinimum(array);

        // moveZeroToEnd(array);

        // array=reSize(array,10);

        // System.out.println(isPalindrome("madam"));

        
        // System.out.println(findMissingNumber(array));
        
        printArray(sortedSquares(array));
    }
}
