import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;

public class StringReassemblyTest {

    // routine
    @Test
    public void testcombination_apple_lead_2() {
        String str1 = "apple";
        String str2 = "lead";
        int overlap = 2;
        String combination = StringReassembly.combination(str1, str2, overlap);
        assertEquals("applead", combination);
    }

    // boundary
    @Test
    public void testcombination_empty_empty_0() {
        String str1 = "";
        String str2 = "";
        int overlap = 0;
        String combination = StringReassembly.combination(str1, str2, overlap);
        assertEquals("", combination);
    }

    // challenging
    @Test
    public void testcombination_apple_apple_5() {
        String str1 = "apple";
        String str2 = "apple";
        int overlap = 5;
        String combination = StringReassembly.combination(str1, str2, overlap);
        assertEquals("apple", combination);
    }

    // boundary
    @Test
    public void addToSetAvoidingSubstrings_empty_empty() {
        String str = "";
        Set<String> strSet = new Set1L<>();
        Set<String> strSetTrue = strSet.newInstance();
        strSetTrue.add("");
        StringReassembly.addToSetAvoidingSubstrings(strSet, str);
        assertEquals("", str);
        assertEquals(strSetTrue, strSet);
    }

    // challenging
    @Test
    public void addToSetAvoidingSubstrings_apple_set_challenging1() {
        String str = "apple";
        Set<String> strSet = new Set1L<>();
        strSet.add("tree");
        strSet.add("applesauce");

        Set<String> strSetTrue = new Set1L<>();
        strSetTrue.add("tree");
        strSetTrue.add("applesauce");
        StringReassembly.addToSetAvoidingSubstrings(strSet, str);
        assertEquals("apple", str);
        assertEquals(strSetTrue, strSet);
    }

    // challenging 2
    @Test
    public void addToSetAvoidingSubstrings_apple_set_challenging2() {
        String str = "apple";
        Set<String> strSet = new Set1L<>();
        Set<String> strSetTrue = new Set1L<>();
        strSet.add("tree");
        strSet.add("app");
        strSetTrue.add("tree");
        strSetTrue.add("apple");
        StringReassembly.addToSetAvoidingSubstrings(strSet, str);
        assertEquals("apple", str);
        assertEquals(strSetTrue, strSet);
    }

    // routine
    @Test
    public void addToSetAvoidingSubstrings_apple_set() {
        String str = "apple";
        Set<String> strSet = new Set1L<>();
        strSet.add("tree");
        strSet.add("cattle");
        strSet.add("cherry");

        Set<String> strSetTrue = new Set1L<>();
        strSetTrue.add("tree");
        strSetTrue.add("cattle");
        strSetTrue.add("cherry");
        strSetTrue.add("apple");
        StringReassembly.addToSetAvoidingSubstrings(strSet, str);
        assertEquals("apple", str);
        assertEquals(strSetTrue, strSet);
    }

}
