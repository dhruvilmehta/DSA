

public class FibonacciNumber {

    public int fib(int n){ //bottom up approach
        int[] table=new int[n+1];   // 0 => n

        table[0]=0;
        table[1]=1;

        for(int i=2;i<=n;i++){
            table[i]=table[i-1]+table[i-2];
        }

        return table[n];
    }

    public int fib(int[] memo,int n){
        if(memo[n]==0){
            if(n<2){
                memo[n]=n;  // 0 and 1
            }else{
                int left=fib(memo,n-1); // the current number is sum if its preceding numbers
                int right=fib(memo,n-2);
                memo[n]=left+right;
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        FibonacciNumber fb=new FibonacciNumber();
        System.out.println(fb.fib(7));
        System.out.println(fb.fib(new int[7+1],7));
        
    }
}
