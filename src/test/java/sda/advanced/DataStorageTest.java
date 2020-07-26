package sda.advanced;

import org.junit.Test;
import sda.advanced.core.DataStorage;
import sda.advanced.inbound.DataMapper;
import sda.advanced.model.ZtmData;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class DataStorageTest {
    @Test
    public void testUpdate() throws IOException {
        //given
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("test.json");
        String testJson = new String(resourceAsStream.readAllBytes(), Charset.defaultCharset());
        ZtmData ztmData = DataMapper.map(testJson);
        //when
        DataStorage dataStorage = new DataStorage();
        dataStorage.update(ztmData);
        //then
        LocalDateTime expectedDateTime = LocalDateTime.of(2020, 7, 25, 14, 45, 00);
        LocalDateTime actualDateTime = dataStorage.getLastUpdateDate();

        assertEquals(expectedDateTime, actualDateTime);
        assertEquals(7, dataStorage.getVehicleList().size());
    }
}
