import entities.DrugsEntity;
import org.junit.jupiter.api.Test;

/**
 * Created by Andrew on 21.03.2017.
 */
public class TestDrug {

    Service service = new Service();

    @Test
    public void testSaveRecord() throws Exception {
        DrugsEntity de1 = new DrugsEntity();
        de1.setDrugsid(5);
        de1.setName("Nizoral");
        de1.setBarcode(1235784l);
        DrugsEntity de = service.add(de1);
        //Вывели записанную в БД запись
        System.out.println(de);
    }
}
