import com.dio_task5.ArrayHelper;
import com.dio_task5.Person;
import com.dio_task5.ServiceDelegate;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MergeTest {
    final ArrayHelper array = new ArrayHelper();
    final ServiceDelegate se = new ServiceDelegate(array);

    final Person[] p1 = {new Person.Builder().setAge(11).setMail("Stas@ukr.net").setName("Stas").setNumber(1234567).build(),
            new Person.Builder().setAge(25).setMail("ftt@yahoo.com").setName("Kar").setNumber(12577).build(),
            new Person.Builder().setAge(18).setMail("xxtt@yahoo.com").setName("Grag").setNumber(126742).build(),
            new Person.Builder().setAge(31).setMail("tt@yo.com").setName("Den").setNumber(3457).build()};

    final Person [] p2 = {new Person.Builder().setAge(13).setMail("Igor@yahoo.com").setName("Igor").setNumber(12345367).build(),
            new Person.Builder().setAge(23).setMail("KAr@yahoo.com").setName("Kar").setNumber(125477).build(),
            new Person.Builder().setAge(34).setMail("xxSil@yahoo.com").setName("Silva").setNumber(1267542).build(),
            new Person.Builder().setAge(33).setMail("Den@yo.com").setName("Denis").setNumber(34527).build()};

    final Person[] pEmpty = new Person[0];

    final Person[] oneNameEmpty = {new Person.Builder().setAge(11).setMail("Stas@ukr.net").setName("Stas").setNumber(1234567).build(),
            new Person.Builder().setAge(25).setMail("ftt@yahoo.com").setName("").setNumber(12577).build(),
            new Person.Builder().setAge(18).setMail("xxtt@yahoo.com").setName("Grag").setNumber(126742).build()};

    final Person[] oneNameNull = {new Person.Builder().setAge(11).setMail("Stas@ukr.net").setName("Stas").setNumber(1234567).build(),
            new Person.Builder().setAge(25).setMail("ftt@yahoo.com").setName("Kar").setNumber(12577).build(),
            new Person.Builder().setAge(18).setMail("xxtt@yahoo.com").setName(null).setNumber(126742).build()};

    @Test
    public void test_NormalValues() throws Exception {
        Person [] pTest = {new Person.Builder().setAge(11).setMail("Stas@ukr.net").setName("Stas").setNumber(1234567).build(),
                new Person.Builder().setAge(25).setMail("ftt@yahoo.com").setName("Kar").setNumber(12577).build(),
                new Person.Builder().setAge(18).setMail("xxtt@yahoo.com").setName("Grag").setNumber(126742).build(),
                new Person.Builder().setAge(31).setMail("tt@yo.com").setName("Den").setNumber(3457).build(),
                new Person.Builder().setAge(13).setMail("Igor@yahoo.com").setName("Igor").setNumber(12345367).build(),
                new Person.Builder().setAge(34).setMail("xxSil@yahoo.com").setName("Silva").setNumber(1267542).build(),
                new Person.Builder().setAge(33).setMail("Den@yo.com").setName("Denis").setNumber(34527).build()
        };

        Person [] result = se.merge(p1, p2);

        Arrays.sort(pTest);
        Arrays.sort(result);

        Assert.assertArrayEquals(result, pTest);
    }


    public void test_FirstArrayIsNull() throws Exception {
        Person [] pTest = p2.clone();
        Person [] result = se.merge(null, p2);

        Arrays.sort(pTest);
        Arrays.sort(result);

        Assert.assertArrayEquals(result, pTest);
    }

    public void test_SecoundArrayIsNull() throws Exception {
        Person [] pTest = p2.clone();
        Person [] result = se.merge(p2, null);

        Arrays.sort(pTest);
        Arrays.sort(result);

        Assert.assertArrayEquals(result, pTest);
    }

    public void test_FirstArrayIsEmpty() throws Exception {
        Person [] pTest = p1.clone();
        Person [] result = se.merge(pEmpty, p1);

        Arrays.sort(pTest);
        Arrays.sort(result);

        Assert.assertArrayEquals(result, pTest);
    }

    public void test_SecoundArrayIsEmty() throws Exception {
        Person [] pTest = p2.clone();
        Person [] result = se.merge(p2, pEmpty);

        Arrays.sort(pTest);
        Arrays.sort(result);

        Assert.assertArrayEquals(result, pTest);
    }

    public void test_FirstArraysNameIsEmpty() throws Exception {
        Person[] result = se.merge(oneNameEmpty, p1);

        Assert.assertArrayEquals(result, null);
    }

    public void test_SecoundArraysNameIsEmpty() throws Exception {
        Person[] result = se.merge(p1, oneNameEmpty);

        Assert.assertArrayEquals(result, null);

    }

    public void test_FirstArraysNameIsNull() throws Exception {
        Person[] result = se.merge(oneNameNull, p1);

        Assert.assertArrayEquals(result, null);
    }

    public void test_SecoundArraysNameIsNull() throws Exception {
        Person[] result = se.merge(oneNameEmpty, p2);

        Assert.assertArrayEquals(result, null);
    }
}