class Solution {
    public List<Integer> findDisappearedNumbers(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }

        List<Integer> result = new ArrayList<>();
        
        for (int index = 0; index  < arr.length; index++){
            if(arr[index] != index + 1) result.add(index + 1);
        }

        if(result.isEmpty()){
            if(arr[arr.length - 1] == arr.length) return new ArrayList<>();
            else return new ArrayList<>(Arrays.asList(arr.length));
        }
        else return result;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}