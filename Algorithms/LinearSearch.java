public class LinearSearch {

    public int search(int[] arr,int n,int x){
        for(int i=0;i<n;i++){
            if(arr[i]==x){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,1,6,7,8,3};
        LinearSearch ls=new LinearSearch();
        System.out.println(ls.search(arr, arr.length, 5));
    }   
}
