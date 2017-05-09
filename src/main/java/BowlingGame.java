public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
    	int n = 10;
    	String[] bowGridTmp = bowlingCode.split("\\|");
        int cunt = 0;
        for(int i = 0; i < bowGridTmp.length; i++){
        	if(bowGridTmp[i].equals("")){
        		cunt++;
        	}
        }
        
        String[] bowGrid = new String[bowGridTmp.length-cunt];
        for(int i = 0,j = 0; i < bowGridTmp.length; i++){
        	if(!bowGridTmp[i].equals("")){
        		bowGrid[j++] = bowGridTmp[i];
        	}
        }
       int sum = 0;
       for(int i = 0; i < n-2; i++){
    	   int GridScore = 0;
    	   int iTmp = i;
    	 
    	   if(bowGrid[iTmp].equals("X")){
    		   GridScore += 10;
    		   iTmp++;
    		   
    		   if(bowGrid[iTmp].equals("X")){
    			   GridScore += 10;
        		   iTmp++;
        		   GridScore += judgeXOrChGreater1AndLess9(bowGrid[iTmp],1);
    		   }else{
    			   if((bowGrid[iTmp].charAt(1))=='/'){
    				   GridScore += 10;
    			   }else{
    				   GridScore += judgeChGreater1AndLess9(bowGrid[iTmp], 2);
    			   }
    		   }
    		   
    	   }else{
    		   if((bowGrid[iTmp].charAt(1))=='/'){
    			   GridScore += 10;
    			   iTmp++;
    			   GridScore += judgeXOrChGreater1AndLess9(bowGrid[iTmp],1);
    		   
    		   }else{
    			   GridScore += judgeChGreater1AndLess9(bowGrid[iTmp], 2);
    		   }
    	   }
    	   
    	   sum += GridScore;
       }
       

       for(int i = n-2; i < n; i++){
    	   int GridScore = 0;
    	   int iTmp = i;
    	   if(bowGrid[n-1].equals("X")){
    		   if(i != (n-1)){
    			   if(bowGrid[iTmp].equals("X")){
    				   GridScore += 20;
        			   iTmp += 2;
        			   GridScore += judgeXOrChGreater1AndLess9(bowGrid[iTmp],1);
    			   }else{
    				   if((bowGrid[iTmp].charAt(1))=='/'){
    					   GridScore += 20;
    				   }else{
    					   GridScore += judgeChGreater1AndLess9(bowGrid[iTmp], 2);
    				   }
    			   }
    			  
    		   }else{
    			   GridScore += 10;
    			   iTmp++;
    			   GridScore += judgeXOrChGreater1AndLess9(bowGrid[iTmp],2);
    		   }
    		 
    	   }else{
    		   if((bowGrid[n-1].charAt(1))=='/'){
    			   if(i != (n-1)){
    				   if(bowGrid[iTmp].equals("X")){
    					   GridScore += 20;
        			   }else{
        				   if((bowGrid[iTmp].charAt(1))=='/'){
        					   GridScore += 10;
        					   iTmp++;
        					   GridScore += judgeChGreater1AndLess9(bowGrid[iTmp], 1);
        				   }else{
        					   GridScore += judgeChGreater1AndLess9(bowGrid[iTmp], 2);
        				   }
        			   }
    			   }else{
    				   GridScore += 10;
    				   iTmp++;
    				   GridScore += judgeXOrChGreater1AndLess9(bowGrid[iTmp],1);
    			   }
    			   
    		   }else{
    			   if(i != (n-1)){
    				   if(bowGrid[iTmp].equals("X")){
    					   GridScore += 10;
    					   iTmp++;
    					   GridScore += judgeChGreater1AndLess9(bowGrid[iTmp], 2);
        			   }else{
        				   if((bowGrid[iTmp].charAt(1))=='/'){
        					   GridScore += 10;
        					   iTmp++;
        					   GridScore += judgeChGreater1AndLess9(bowGrid[iTmp], 1);
        				   }else{
        					   GridScore += judgeChGreater1AndLess9(bowGrid[iTmp], 2);
        				   }
        			   } 
    			   }else{
    				   GridScore += judgeChGreater1AndLess9(bowGrid[iTmp], 2);
    			   }
    		   }
    	   }

    	   sum += GridScore;
       }
        
        return sum;
    }
    
    /**
     * judge char in a String    ch>='1' &&  ch<='9'  
     * @param str  To judge String
     * @param cyclesCunt  
     * @return  The corresponding score
     */
    public int judgeChGreater1AndLess9(String str, int cyclesCunt){
    	int score = 0;
    	for(int l = 0; l < cyclesCunt; l++){
    		if(str.charAt(l) >= '1' && str.charAt(l) <= '9')
        		score += (Integer.parseInt(str.charAt(l)+""));
    	}
    	return score;
    }
    
    /**
     * The third judge   char in a String,  ch =='X'  or   ch>='1' &&  ch<='9'  
     * @param str  To judge String
     * @param cyclesCunt 
     * @return  The corresponding score
     */
    public int judgeXOrChGreater1AndLess9(String str,int cyclesCunt){
    	int score = 0;
    	for(int l = 0; l < cyclesCunt; l++){
    		if(str.charAt(l)==('X'))
        		score += 10;
        	else
        		score += judgeChGreater1AndLess9(str.charAt(l)+"",1);
    	}
    	return score;
    }
}
