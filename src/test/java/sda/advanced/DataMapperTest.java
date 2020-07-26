package sda.advanced;


import org.junit.Test;
import sda.advanced.inbound.DataMapper;
import sda.advanced.model.Vehicle;
import sda.advanced.model.ZtmData;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * DataMapper Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>lip 25, 2020</pre>
 */
public class DataMapperTest {

    /**
     * Method: map(String json)
     */
    @Test
    public void testMap() throws Exception {
        //given
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("test.json");
        String testJson = new String(resourceAsStream.readAllBytes(), Charset.defaultCharset());
        //when
        ZtmData ztmData = DataMapper.map(testJson);
        List<Vehicle> vehicles = ztmData.getVehicleList();
        //then
        assertEquals(7, vehicles.size());
        assertEquals("118", vehicles.get(1).getLine());
    }

}
