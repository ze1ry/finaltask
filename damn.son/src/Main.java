import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        Object[] randArr = new Object[]{2, 2, 4, "Bih", "Bih"};
//        System.out.println(deleteDublicates(deleteDublicates(new ArrayList<Object>(
//                Arrays.asList(randArr)))));

//        3rd task
        HashMap<Object, Object> map = new HashMap<>();
        map.put("Hello", "World");
        map.put("Bye", "World");
        map.put("Black", 1);
        map.put("Brown", 1);
        map.put("Yellow", 3);
        map.put("Orange", 3);
        System.out.println(changePlaces(map));


//        4th task
        System.out.println(orders(new String[]{"Hello", "Hello", "Hello", "Hello"}));

//        5th task
        System.out.println(convertImproved(new Object[]{"Hello", "World", "Shit"}, new Object[]{1, 2}));
    }


    public static HashMap<Character, Integer> dict(String word)  {
        HashMap <Character, Integer> finalHash = new HashMap<>();
        for (int i = 0; i<word.length(); i++) {
            Character curString = word.charAt(i);
            if (finalHash.containsKey(curString)) {
                finalHash.put(curString, finalHash.get(curString) + 1);
            } else {
                finalHash.put(curString, 1);
            }
        }
        return finalHash;
    }


    public static ArrayList<Object> deleteDublicates(ArrayList<Object> lst) {
        ArrayList<Object> finalArr = new ArrayList<>();

        for (int i = 0; i<lst.size(); i++) {
            if (!finalArr.contains(lst.get(i))) {
                finalArr.add(lst.get(i));
            } else {
                continue;
            }
        }
        return finalArr;
    }


    public static HashMap<Object, ArrayList<Object>> changePlaces(HashMap<Object, Object> map) {
        HashMap<Object, ArrayList<Object>> finalHash = new HashMap<>();

        for (Object obj : map.keySet()) {
            Object curVal = map.get(obj);

            if (finalHash.keySet().contains(curVal)) {
                ArrayList<Object> tempHash = finalHash.get(curVal);
                tempHash.add(obj);
                finalHash.put(curVal, tempHash);
            } else {
                ArrayList<Object> initialLst = new ArrayList<>();
                initialLst.add(obj);
                finalHash.put(curVal, initialLst);
            }
        }

        return finalHash;

    }


    public static ArrayList<Object> orders(String[] arr) {
        ArrayList<Object> finalArr = new ArrayList<>();
        HashSet<String> finalSet = new HashSet<>(Arrays.asList(arr));
        TreeSet<String> finalTree = new TreeSet<>(Arrays.asList(arr));

        finalArr.add(finalSet);
        finalArr.add(finalTree);

        return finalArr;

    }


    public static HashMap<Object, Object> convert(Object[] arrKeys, Object[] arrVals) {
        HashMap<Object, Object>  finalMap = new HashMap<>();
        for (int i = 0; i<arrKeys.length; i++) {
            if (i >= arrVals.length) {
                finalMap.put(arrKeys[i], null);
            } else {
                finalMap.put(arrKeys[i], arrVals[i]);
            }
        }

        return finalMap;

    }

    public static HashMap<Object, Object> convertImproved(Object[] arrKeys, Object[] arrVals) {
        if (arrKeys.length > arrVals.length) {
            throw new ArraysNotEqualException("Value is not enough for map");
        } else if (arrKeys.length < arrVals.length) {
            throw new ArraysNotEqualException("Key is not enough for map");
        }

        HashMap<Object, Object>  finalMap = new HashMap<>();
        for (int i = 0; i<arrKeys.length; i++) {
            finalMap.put(arrKeys[i], arrVals[i]);
        }

        return finalMap;

    }
}

class ArraysNotEqualException extends RuntimeException {
    public ArraysNotEqualException(String errorMessage) {
        super(errorMessage);
    }
}
