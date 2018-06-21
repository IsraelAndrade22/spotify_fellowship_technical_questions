class question3{
    
    public static void main(String args[]){
        int [] coins = new int[] {1, 2, 3};
        int amount = 4;
        System.out.println("Total Combinations: " + 
                                    changePossibilities(amount, coins)); 
    }
    public static int changePossibilities(int amount, int coins[]){
        int combinations[] = new int[amount + 1];
        combinations[0] = 1;
        
        for(int i = 0; i < coins.length; i++){
            for(int j = 1; j < (amount + 1); j++){
                if(j >= coins[i]){
                    combinations[j] += combinations[j - coins[i]];
                }
            }
        }
        return combinations[amount];
    }
}