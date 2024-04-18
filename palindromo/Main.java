public class Main {

    public boolean palindromo(String word){
        for(int i=0;i<=word.length()-1;i++){
            for(int j=word.length()-1;j>i;j--){
                if(word.charAt(i)!=word.charAt(j)){
                return false;			
            }
        }
        return true;
    }

}

