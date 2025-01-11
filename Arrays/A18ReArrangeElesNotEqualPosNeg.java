import java.util.ArrayList;

public class A18ReArrangeElesNotEqualPosNeg {
    // void rearrange(ArrayList<Integer> arr) {
    //     ArrayList<Integer> pos = new ArrayList<>();
    //     ArrayList<Integer> neg = new ArrayList<>();
    //     int n = arr.size();
    //     for(int i=0;i<n;i++){
    //         if(arr.get(i)>=0) pos.add(arr.get(i));
    //         else neg.add(arr.get(i));
    //     }
    //     int pind=0,nind=0,i=0;
    //     while(pind<pos.size() &&nind<neg.size()){
    //         if(i%2==0){
    //             arr.set(i++,pos.get(pind++));
    //         }
    //         else{
    //             arr.set(i++,neg.get(nind++));
    //         }
    //     }

    //     while(pind<pos.size()){
    //         arr.set(i++,pos.get(pind++));
    //     }
    //     while(nind<neg.size()){
    //         arr.set(i++,neg.get(nind++));
    //     }   
    // }


    // void rearrange(ArrayList<Integer> arr) {
    //     ArrayList<Integer> pos = new ArrayList<>();
    //     ArrayList<Integer> neg = new ArrayList<>();
    //     int n = arr.size();
    //     for(int i=0;i<n;i++){
    //         if(arr.get(i)>=0) pos.add(arr.get(i));
    //         else neg.add(arr.get(i));
    //     }
    //     int pind=0,nind=0;
    //     if(pos.size()>neg.size()){
    //         for(int i=0;i<neg.size();i++){
    //             arr.set(2*i,pos.get(i));
    //             arr.set(2*i+1,neg.get(i));
    //         }
    //         int ind = neg.size()*2;
    //         for(int i=neg.size();i<pos.size();i++){
    //             arr.set(ind++,pos.get(i));
    //         }
    //     }
    //     else{
    //         for(int i=0;i<pos.size();i++){
    //             arr.set(2*i,pos.get(i));b
    //             arr.set(2*i+1,neg.get(i));
    //         }
    //         int ind = pos.size()*2;
    //         for(int i=pos.size();i<neg.size();i++){
    //             arr.set(ind++,neg.get(i));
    //         }
    //     }
    // }




}
