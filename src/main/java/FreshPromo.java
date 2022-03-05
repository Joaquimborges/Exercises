public class FreshPromo {

    private static int freshPromotion(String[][] codeList, String[] shoppingCart) {
//        Start at 0 index for both the code list and shopping cart.
        int cartIdx = 0, codeIdx = 0;
        while (cartIdx < shoppingCart.length && codeIdx < codeList.length) {
            String cur = shoppingCart[cartIdx];
//            If the first fruit of the codeList is anything or if it matches the current fruit at the cart idx.
            if((codeList[codeIdx][0].equals("anything") || codeList[codeIdx][0].equals(cur))
                    && hasOrder(shoppingCart, cartIdx, codeList[codeIdx])){
                cartIdx += codeList[codeIdx++].length;
            }else{
                cartIdx++;
            }
        }
//        If the all the codeList is present then return 1, else 0.
        return codeIdx == codeList.length ? 1 : 0;
    }

    private static boolean hasOrder(String[] shoppingCart, int idx, String[] order) {
//        Loop through the codeList to check if the fruits are in order.
        for (String s : order) {
            if (idx < shoppingCart.length && (s.equals("anything") || shoppingCart[idx].equals(s))){
                idx++;
            }else{
                return false;
            }
        }
        return true;
    }
    ////////////////////////////////////////

    // option 2

    private static int check(String[][] codeList,String[] shoppingcart){

        // check corner cases
        if(codeList == null || codeList.length == 0) return 1;
        if(shoppingcart == null || shoppingcart.length == 0) return 0;

        int i =0,j=0;

        while(i<codeList.length && j+codeList[i].length <= shoppingcart.length){

            boolean match = true;

            for(int k = 0;k<codeList[i].length;k++){

                if(!codeList[i][k].equals("anything") && !shoppingcart[j+k].equals(codeList[i][k])){
                    match = false;
                    break;
                }
            }

            if(match){
                j+= codeList[i].length;
                i++;
            }else{
                j++;
            }
        }

        return (i == codeList.length)?1:0;
    }
}
