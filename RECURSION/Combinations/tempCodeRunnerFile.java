 public void cal(int i,int s,List<Integer> templi,int[] cand,int tar){
        if(s==tar){
            ans.add(new ArrayList<>(templi));
            return;
        }
        if(i>=cand.length){
            return;
        }
        templi.add(cand[i]);
        s+=cand[i];
        cal(i+1,s,templi,cand,tar);
        templi.remove(templi.size()-1);
        s-=cand[i];
        while (i + 1 < cand.length && cand[i] == cand[i + 1]) {
            i++;
        }
        cal(i+1,s,templi,cand,tar);
    }