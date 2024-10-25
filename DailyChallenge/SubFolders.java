import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubFolders {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        String prev = "";
        for(String word:folder){
            if(prev.isEmpty() || !word.startsWith(prev+"/")){
                res.add(word);
                prev=word;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] arr = {"/a","/a/b","/c/d","/c/f","/c/d/e",};
        SubFolders s = new SubFolders();
        System.out.println(s.removeSubfolders(arr));
    }
}







