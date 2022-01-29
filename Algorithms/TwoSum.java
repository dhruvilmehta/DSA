import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] numbers,int target){
        int[] result=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if(!map.containsKey(target-numbers[i])){
                map.put(numbers[i],i);
            }else{
                result[1]=i;
                result[0]=map.get(target-numbers[i]);
                return result;
            }
        }
        throw new IllegalArgumentException();
    }

    public static int[] twoSum2(int[] arr,int target){
        Arrays.sort(arr);
        int left=0;
        int right=arr.length-1;
        int[] result=new int[2];
        while(left<right){
            int sum=arr[left]+arr[right];
            if(sum==target){
                result[0]=arr[left];
                result[1]=arr[right];
                return result;
            }else if(sum<target){
                left++;
            }else{
                right--;
            }
        }
        throw new IllegalArgumentException("Value not found");
    }

    public static void main(String[] args) {
        int[] numbers=new int[] {2,11,5,10,7,8};
        // int[] result=twoSum(numbers, 20);
        // System.out.println(result[0]+" "+result[1]);

        int[] result=twoSum2(numbers, 14);
        System.out.println(result[0]+" "+result[1]);
    }
}
