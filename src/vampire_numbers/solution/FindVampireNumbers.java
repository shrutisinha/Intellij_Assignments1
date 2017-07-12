package vampire_numbers.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public  class FindVampireNumbers {
    private int count=0;
    public boolean sameChars(String a, String b) {
        if(a==null || b==null)return false;
        char[] first = a.toCharArray();
        char[] second = b.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }
    public void generate(ArrayList<Integer> vamp, int n) {
        if (n % 2 == 1){
            System.out.println("Number of digits must be even");
            generate(vamp,n-1);
            return;
        }
        int start=(int)Math.pow(10, n/2-1);
        for(int i=start;i<start*10;i++){
            for(int j=i;j<start*10;j++){
                int num= i*j;
                String a=String.valueOf(num);
                String b=String.valueOf(i)+String.valueOf(j);
                if(sameChars(a,b) ){
                    count++;
                    vamp.add(num);
                    // Collections.sort(vamp);
                    //System.out.println(i+" * "+j+" = "+num+"  and count is "+count);
                }
            }
        }
        Collections.sort(vamp);
    }
    public int getCount(){
        return(count);
    }

}
