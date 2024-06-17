public class HashMapTest {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap(100);

        // Test Case 1: Insertion and Retrieval
        hashMap.put(1, 10);
        assert hashMap.get(1) == 10 : "Test Case 1 Failed";

        // Test Case 2: Non-Existent Key
        assert hashMap.get(2) == -1 : "Test Case 2 Failed";

        // Test Case 3: Update Existing Key
        hashMap.put(1, 20);
        assert hashMap.get(1) == 20 : "Test Case 3 Failed";

        // Test Case 4: Remove Key
        hashMap.remove(1);
        assert hashMap.get(1) == -1 : "Test Case 4 Failed";

        // Test Case 5: Collision Handling
        hashMap.put(1, 10);
        hashMap.put(101, 20);  // 1 and 101 will have same hash
        assert hashMap.get(1) == 10 : "Test Case 5 Failed (1)";
        assert hashMap.get(101) == 20 : "Test Case 5 Failed (2)";

        System.out.println("All test cases passed.");
    }
}
