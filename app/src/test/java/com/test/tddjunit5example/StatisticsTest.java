package com.test.tddjunit5example;

import com.test.tddjunit5example.airconditioning.Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.test.tddjunit5example.airconditioning.DarabaseUtil.buildFlightsList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MokitoExtension.class)
public class StatisticsTest {

    @Spy
    Database database;

    private List<List<String>> querieData;
    private List<Flight> flightList;

    @BeforeEach
    void before()
    {
        querieData = new ArrayList<>();
        List<String> row1 = Arrays.asList("1","e","Mike","false","349");

        List<String> row2 = Arrays.asList("2","b","John","true","278");

        List<String> row3 = Arrays.asList("3","e","Mike","false","319");

        List<String> row4 = Arrays.asList("4","p","John","true","817");

        List<String> row5 = Arrays.asList("5","e","Mike","false","623");

        List<String> row6 = Arrays.asList("6","e","John","true","978");

        querieData.add(row1);
        querieData.add(row2);
        querieData.add(row3);
        querieData.add(row4);
        querieData.add(row5);
        querieData.add(row6);

    }

    @Test
    void testQueriedData()
    {
        when(database.queryFlightDatabase()).thenReturn(querieData);
        flightList = buildFlightsList(querieData);
        assertEquals(6,database.queryFlightDatabase().size());
        assertEquals(6,flightList.size());
        assertEquals(560.666,database.averageDistance(flightList),0.001);

        assertEquals(278,database.minimumnDistance(flightList ));

        assertEquals(978 ,database.maximumDistance(flightList));
    }
}
