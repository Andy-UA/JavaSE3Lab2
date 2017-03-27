package Tests;

import entities.DrugsEntity;
import entities.OrderdrugEntity;
import org.junit.jupiter.api.Test;
import services.DrugService;

/**
 * Created by Andrew on 21.03.2017.
 */
public class TestDrug {

    DrugService drugService = new DrugService();

    @Test
    public void testSaveRecord() throws Exception {
        DrugsEntity de1 = new DrugsEntity();
        de1.setDrugsid(5);
        de1.setName("Nizoral");
        de1.setBarcode(1235784l);
        DrugsEntity de = drugService.add(de1);
        //Вывели записанную в БД запись
        System.out.println(de);
    }
}
