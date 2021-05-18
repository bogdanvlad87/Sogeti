package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import Utils.ApiUtils;
import Utils.JsonUtils;

public class ApiTests {
    private ApiUtils apiUtils = new ApiUtils();
    private JsonUtils jsonUtils = new JsonUtils();

    @Test
    public void ApiTest1Test(){
        List response = apiUtils.getResponse("de/bw/stuttgart");
        Assert.assertEquals(response.get(0), 200);
        Assert.assertEquals(jsonUtils.getValueForGivenKey(response.get(1).toString(), "country"), "Germany");
        Assert.assertEquals(jsonUtils.getValueForGivenKey(response.get(1).toString(), "state"), "Baden-Württemberg");
        Assert.assertTrue((long)response.get(2) < 1000, "Request took " + response.get(2));
    }

    @Test
    public void ApiTest2Test(){
        List country = Arrays.asList("us", "us", "ca");
        List postalCodes = Arrays.asList("90210", "12345", "B2R");
        List expectedResponse = Arrays.asList("Beverly Hills", "Schenectady", "Waverley");
        for(int i = 0; i < 3; i++){
            List response = apiUtils.getResponse(country.get(i) + "/" + postalCodes.get(i));
            Assert.assertEquals(response.get(0), 200);
            Assert.assertEquals(jsonUtils.getValueFromJsonArrayForGivenKey(response.get(1).toString(), "places" ,"place name"), expectedResponse.get(i));
            Assert.assertTrue((long)response.get(2) < 1000, "Request took " + response.get(2));
        }
    }
}
